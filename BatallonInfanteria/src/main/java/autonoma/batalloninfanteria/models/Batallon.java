package autonoma.batalloninfanteria.models;

import java.util.ArrayList;
import java.util.List;

import autonoma.batalloninfanteria.enums.TipoBatallon;

public class Batallon {

    // Atributos requeridos
    private String nombre;
    private String ubicacion;
    private TipoBatallon tipo;
    private List<Peloton> pelotones;
    private static String codigoOtan = "OTAN-DEF";

    // Constructor
    public Batallon(String nombre, String ubicacion, TipoBatallon tipo) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.pelotones = new ArrayList<>();
    }

    // Agrega un peloton
    public boolean agregarPeloton(Peloton p) {
        pelotones.add(p);
        return true;
    }

    // Elimina un peloton por nombre
    public boolean eliminarPeloton(String nombre) {
        for (Peloton p : pelotones) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                pelotones.remove(p);
                return true;
            }
        }
        return false;
    }

    // Retorna cantidad de pelotones
    public int contarPelotones() {
        return pelotones.size();
    }

    // Retorna cantidad total de soldados en el batallon
    public int contarTotalSoldados() {
        int total = 0;
        for (Peloton p : pelotones) {
            total += p.contarTotalSoldados();
        }
        return total;
    }

    // Metodo que genera un resumen del batallon
    public String generarResumen() {
        return "Batallon: " + nombre +
               " | Ubicacion: " + ubicacion +
               " | Tipo: " + tipo +
               " | Pelotones: " + pelotones.size() +
               " | Soldados Totales: " + contarTotalSoldados();
    }

    // Metodo static requerido
    public static void cambiarCodigoOtan(String nuevoCodigo) {
        codigoOtan = nuevoCodigo;
    }

    // Getters
    public String getNombre() { return nombre; }

    public String getUbicacion() { return ubicacion; }

    public TipoBatallon getTipo() { return tipo; }

    public List<Peloton> getPelotones() { return pelotones; }
}
