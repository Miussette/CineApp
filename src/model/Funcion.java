package model;

import java.util.ArrayList;
import java.util.List;

public class Funcion {

    private Pelicula pelicula;
    private String horario;
    private int capacidad;
    private List<Integer> asientosOcupados;

    public Funcion(Pelicula pelicula, String horario, int capacidad) {
        this.pelicula = pelicula;
        this.horario = horario;
        this.capacidad = capacidad;
        this.asientosOcupados = new ArrayList<>();
    }

    public boolean hayAsientos() {
        return asientosOcupados.size() < capacidad;
    }

    public boolean asientoDisponible(int asiento) {
        return !asientosOcupados.contains(asiento);
    }

    public void ocuparAsiento(int asiento) {
        asientosOcupados.add(asiento);
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public String getHorario() {
        return horario;
    }
}