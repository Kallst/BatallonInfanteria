package autonoma.batalloninfanteria.models;

import java.util.ArrayList;
import java.util.List;

import autonoma.batalloninfanteria.enums.TipoEscuadra;

public class Escuadra {

    // Atributos requeridos
    private String nombre;
    private int numero;
    private TipoEscuadra tipo;
    private List<Soldado> soldados;
    private static int maximoSoldados = 10;

    // Constructor
    public Escuadra(String nombre, int numero, TipoEscuadra tipo) {
        this.nombre = nombre;
        this.numero = numero;
        this.tipo = tipo;
        this.soldados = new ArrayList<>();
    }

    // Agrega un soldado si hay espacio
    public boolean agregarSoldado(Soldado s) {
        if (soldados.size() < maximoSoldados) {
            soldados.add(s);
            return true;
        }
        return false;
    }

    // Elimina un soldado por nombre
    public boolean eliminarSoldado(String nombre) {
        for (Soldado s : soldados) {
            if (s.getNombre().equalsIgnoreCase(nombre)) {
                soldados.remove(s);
                return true;
            }
        }
        return false;
    }

    // Retorna la cantidad de soldados
    public int contarSoldados() {
        return soldados.size();
    }

    // Retorna lista de soldados aptos
    public List<Soldado> obtenerSoldadosAptos() {
        List<Soldado> aptos = new ArrayList<>();
        for (Soldado s : soldados) {
            if (s.esAptoParaMision()) {
                aptos.add(s);
            }
        }
        return aptos;
    }

    // Metodo que informa si aun hay espacio
    public boolean tieneCapacidadDisponible() {
        return soldados.size() < maximoSoldados;
    }

    // Metodo static requerido
    public static void cambiarMaximoSoldados(int nuevoMaximo) {
        maximoSoldados = nuevoMaximo;
    }

    // Getters
    public String getNombre() { return nombre; }

    public int getNumero() { return numero; }

    public TipoEscuadra getTipo() { return tipo; }

    public List<Soldado> getSoldados() { return soldados; }
}
