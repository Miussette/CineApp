package model;

public class Entrada {

    private Cliente cliente;
    private Funcion funcion;
    private int asiento;

    public Entrada(Cliente cliente, Funcion funcion, int asiento) {
        this.cliente = cliente;
        this.funcion = funcion;
        this.asiento = asiento;
    }

    public void mostrar() {
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Película: " + funcion.getPelicula().getTitulo());
        System.out.println("Horario: " + funcion.getHorario());
        System.out.println("Asiento: " + asiento);
        System.out.println("----------------------");
    }
}