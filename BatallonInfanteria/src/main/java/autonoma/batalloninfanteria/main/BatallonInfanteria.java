package autonoma.batalloninfanteria.main;

import java.util.Scanner;

import autonoma.batalloninfanteria.enums.*;
import autonoma.batalloninfanteria.models.*;

public class BatallonInfanteria {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Batallon batallon = null;

        int opcion = 0;

        while (opcion != 6) {

            System.out.println("=== Menu Batallon de Infanteria ===");
            System.out.println("1. Crear batallon");
            System.out.println("2. Crear peloton y agregar al batallon");
            System.out.println("3. Crear escuadra y agregar a un peloton");
            System.out.println("4. Crear soldado y agregar a una escuadra");
            System.out.println("5. Mostrar resumen del batallon");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {
                System.out.print("Nombre del batallon: ");
                String nombre = sc.nextLine();

                System.out.print("Ubicacion: ");
                String ubicacion = sc.nextLine();

                System.out.println("Tipo de batallon:");
                System.out.println("1. LIGERO");
                System.out.println("2. MECANIZADO");
                System.out.println("3. AEROTRANSPORTADO");
                int t = sc.nextInt();
                sc.nextLine();

                TipoBatallon tipo;
                if (t == 1) tipo = TipoBatallon.LIGERO;
                else if (t == 2) tipo = TipoBatallon.MECANIZADO;
                else tipo = TipoBatallon.AEROTRANSPORTADO;

                batallon = new Batallon(nombre, ubicacion, tipo);
                System.out.println("Batallon creado");

            } else if (opcion == 2) {

                if (batallon == null) {
                    System.out.println("Primero debe crear un batallon");
                } else {
                    System.out.print("Nombre del peloton: ");
                    String nombre = sc.nextLine();

                    System.out.print("Nombre del comandante: ");
                    String comandante = sc.nextLine();

                    System.out.println("Tipo de peloton:");
                    System.out.println("1. ASALTO");
                    System.out.println("2. ENTRENAMIENTO");
                    System.out.println("3. APOYO");
                    int t = sc.nextInt();
                    sc.nextLine();

                    TipoPeloton tipo;
                    if (t == 1) tipo = TipoPeloton.ASALTO;
                    else if (t == 2) tipo = TipoPeloton.ENTRENAMIENTO;
                    else tipo = TipoPeloton.APOYO;

                    Peloton p = new Peloton(nombre, comandante, tipo);
                    batallon.agregarPeloton(p);

                    System.out.println("Peloton agregado");
                }

            } else if (opcion == 3) {

                if (batallon == null || batallon.getPelotones().isEmpty()) {
                    System.out.println("Debe haber un batallon y al menos un peloton");
                } else {
                    System.out.print("Nombre del peloton donde agregar la escuadra: ");
                    String nombrePel = sc.nextLine();

                    Peloton encontrado = null;
                    for (Peloton p : batallon.getPelotones()) {
                        if (p.getNombre().equalsIgnoreCase(nombrePel)) {
                            encontrado = p;
                            break;
                        }
                    }

                    if (encontrado == null) {
                        System.out.println("Peloton no encontrado");
                    } else {
                        System.out.print("Nombre de la escuadra: ");
                        String nombre = sc.nextLine();

                        System.out.print("Numero de la escuadra: ");
                        int numero = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Tipo de escuadra:");
                        System.out.println("1. INFANTERIA");
                        System.out.println("2. RECONOCIMIENTO");
                        System.out.println("3. APOYO");
                        int t = sc.nextInt();
                        sc.nextLine();

                        TipoEscuadra tipo;
                        if (t == 1) tipo = TipoEscuadra.INFANTERIA;
                        else if (t == 2) tipo = TipoEscuadra.RECONOCIMIENTO;
                        else tipo = TipoEscuadra.APOYO;

                        Escuadra e = new Escuadra(nombre, numero, tipo);
                        encontrado.agregarEscuadra(e);

                        System.out.println("Escuadra agregada");
                    }
                }

            } else if (opcion == 4) {

                if (batallon == null) {
                    System.out.println("Primero cree el batallon");
                } else {

                    System.out.print("Nombre del peloton: ");
                    String nombrePel = sc.nextLine();

                    Peloton p = null;
                    for (Peloton pel : batallon.getPelotones()) {
                        if (pel.getNombre().equalsIgnoreCase(nombrePel)) {
                            p = pel;
                            break;
                        }
                    }

                    if (p == null) {
                        System.out.println("Peloton no encontrado");
                    } else {

                        System.out.print("Nombre de la escuadra: ");
                        String nombreEsc = sc.nextLine();

                        Escuadra e = null;
                        for (Escuadra esc : p.getEscuadras()) {
                            if (esc.getNombre().equalsIgnoreCase(nombreEsc)) {
                                e = esc;
                                break;
                            }
                        }

                        if (e == null) {
                            System.out.println("Escuadra no encontrada");
                        } else {

                            System.out.print("Nombre del soldado: ");
                            String nombre = sc.nextLine();

                            System.out.print("Edad del soldado: ");
                            int edad = sc.nextInt();
                            sc.nextLine();

                            System.out.println("Rango:");
                            System.out.println("1. RECLUTA");
                            System.out.println("2. SOLDADO");
                            System.out.println("3. CABO");
                            System.out.println("4. SARGENTO");
                            System.out.println("5. TENIENTE");
                            int r = sc.nextInt();
                            sc.nextLine();

                            RangoSoldado rango;
                            if (r == 1) rango = RangoSoldado.RECLUTA;
                            else if (r == 2) rango = RangoSoldado.SOLDADO;
                            else if (r == 3) rango = RangoSoldado.CABO;
                            else if (r == 4) rango = RangoSoldado.SARGENTO;
                            else rango = RangoSoldado.TENIENTE;

                            System.out.print("Estado del soldado (APTO/HERIDO): ");
                            String estado = sc.nextLine();

                            Soldado s = new Soldado(nombre, edad, rango, estado);

                            boolean agregado = e.agregarSoldado(s);

                            if (agregado)
                                System.out.println("Soldado agregado");
                            else
                                System.out.println("La escuadra esta llena");
                        }
                    }
                }

            } else if (opcion == 5) {

                if (batallon == null) {
                    System.out.println("Debe crear un batallon");
                } else {
                    System.out.println(batallon.generarResumen());
                }
            }
        }

        sc.close();
    }
}
