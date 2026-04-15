package service;

import java.util.*;
import model.*;

public class CineService {

    private List<Cliente> clientes = new ArrayList<>();
    private List<Funcion> funciones = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void iniciar() {

        cargarFunciones(); // 👈 SOLUCIÓN AL PROBLEMA

        int opcion;

        do {
            System.out.println("\n1) Crear cliente");
            System.out.println("2) Ver cartelera");
            System.out.println("3) Comprar entrada");
            System.out.println("4) Ver entradas del cliente");
            System.out.println("0) Salir");

            opcion = leerEntero();

            switch (opcion) {
                case 1 -> crearCliente();
                case 2 -> verCartelera();
                case 3 -> comprarEntrada();
                case 4 -> verEntradasCliente();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }

        } while (opcion != 0);
    }

    private void cargarFunciones() {
        Pelicula p1 = new Pelicula("Avengers", 120);
        Pelicula p2 = new Pelicula("Spiderman", 110);

        funciones.add(new Funcion(p1, "18:00", 5));
        funciones.add(new Funcion(p2, "20:00", 5));
    }

    private void crearCliente() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        clientes.add(new Cliente(nombre));
        System.out.println("Cliente creado");
    }

    private void verCartelera() {
        if (funciones.isEmpty()) {
            System.out.println("No hay funciones disponibles");
            return;
        }

        for (int i = 0; i < funciones.size(); i++) {
            System.out.print(i + " - ");
            funciones.get(i).getPelicula().mostrarInfo();
        }
    }

    private void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados");
            return;
        }

        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(i + " - " + clientes.get(i).getNombre());
        }
    }

    private void comprarEntrada() {

        try {
            if (clientes.isEmpty()) {
                System.out.println("Primero debes crear un cliente");
                return;
            }

            verCartelera();
            listarClientes();

            System.out.print("Selecciona función: ");
            int f = leerEntero();

            System.out.print("Selecciona cliente: ");
            int c = leerEntero();

            System.out.print("Número de asiento: ");
            int asiento = leerEntero();

            Funcion funcion = funciones.get(f);
            Cliente cliente = clientes.get(c);

            if (!funcion.hayAsientos()) {
                System.out.println("Sala llena");
                return;
            }

            if (!funcion.asientoDisponible(asiento)) {
                System.out.println("Asiento ocupado");
                return;
            }

            funcion.ocuparAsiento(asiento);

            Entrada entrada = new Entrada(cliente, funcion, asiento);
            cliente.agregarEntrada(entrada);

            System.out.println("Entrada comprada con éxito");

        } catch (Exception e) {
            System.out.println("Error en la compra");
            sc.nextLine();
        }
    }

    private void verEntradasCliente() {
        listarClientes();

        System.out.print("Selecciona cliente: ");
        int c = leerEntero();

        Cliente cliente = clientes.get(c);

        if (cliente.getEntradas().isEmpty()) {
            System.out.println("No tiene entradas");
            return;
        }

        for (Entrada e : cliente.getEntradas()) {
            e.mostrar();
        }
    }

    private int leerEntero() {
        while (!sc.hasNextInt()) {
            System.out.println("Ingresa un número válido");
            sc.next();
        }
        int num = sc.nextInt();
        sc.nextLine();
        return num;
    }
}