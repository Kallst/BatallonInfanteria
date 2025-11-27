package autonoma.batalloninfanteria.models;

import java.util.ArrayList;
import java.util.List;

import autonoma.batalloninfanteria.enums.TipoPeloton;

public class Peloton {

    // Atributos requeridos
    private String nombre;
    private String comandante;
    private TipoPeloton tipo;
    private List<Escuadra> escuadras;
    private static int maximoEscuadras = 5;

    // Constructor
    public Peloton(String nombre, String comandante, TipoPeloton tipo) {
        this.nombre = nombre;
        this.comandante = comandante;
        this.tipo = tipo;
        this.escuadras = new ArrayList<>();
    }

    // Agrega una escuadra si hay espacio
    public boolean agregarEscuadra(Escuadra e) {
        if (escuadras.size() < maximoEscuadras) {
            escuadras.add(e);
            return true;
        }
        return false;
    }

    // Elimina una escuadra por nombre
    public boolean eliminarEscuadra(String nombre) {
        for (Escuadra e : escuadras) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                escuadras.remove(e);
                return true;
            }
        }
        return false;
    }

    // Retorna cantidad de escuadras
    public int contarEscuadras() {
        return escuadras.size();
    }

    // Retorna cantidad total de soldados en el peloton
    public int contarTotalSoldados() {
        int total = 0;
        for (Escuadra e : escuadras) {
            total += e.contarSoldados();
        }
        return total;
    }

    // Informa si esta completo
    public boolean estaCompleto() {
        return escuadras.size() == maximoEscuadras;
    }

    // Metodo static requerido
    public static void cambiarMaximoEscuadras(int nuevoMaximo) {
        maximoEscuadras = nuevoMaximo;
    }

    // Getters
    public String getNombre() { return nombre; }

    public String getComandante() { return comandante; }

    public TipoPeloton getTipo() { return tipo; }

    public List<Escuadra> getEscuadras() { return escuadras; }
}
