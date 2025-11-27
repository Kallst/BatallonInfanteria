package autonoma.batalloninfanteria.models;

import autonoma.batalloninfanteria.enums.RangoSoldado;

public class Soldado {

    // Atributos requeridos
    private String nombre;
    private int edad;
    private RangoSoldado rango;
    private String estadoSalud;
    private static int edadMinimaServicio = 18;

    // Constructor
    public Soldado(String nombre, int edad, RangoSoldado rango, String estadoSalud) {
        this.nombre = nombre;
        this.edad = edad;
        this.rango = rango;
        this.estadoSalud = estadoSalud;
    }

    // Metodo que cambia el estado
    public void entrenar() {
        this.estadoSalud = "APTO";
    }

    // Metodo que cambia el estado
    public void marcarComoHerido() {
        this.estadoSalud = "HERIDO";
    }

    // Metodo logico
    public boolean esAptoParaMision() {
        return this.edad >= edadMinimaServicio && this.estadoSalud.equalsIgnoreCase("APTO");
    }

    // Metodo que cambia el rango
    public void asignarRango(RangoSoldado nuevoRango) {
        this.rango = nuevoRango;
    }

    // Metodo que retorna informacion
    public String descripcion() {
        return "Soldado: " + nombre +
               " | Edad: " + edad +
               " | Rango: " + rango +
               " | Estado: " + estadoSalud;
    }

    // Metodo static requerido
    public static void cambiarEdadMinimaServicio(int nuevaEdad) {
        edadMinimaServicio = nuevaEdad;
    }

    // Getters
    public String getNombre() { return nombre; }

    public int getEdad() { return edad; }

    public RangoSoldado getRango() { return rango; }

    public String getEstadoSalud() { return estadoSalud; }
}
