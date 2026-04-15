package app;

import service.CineService;

public class Main {
    public static void main(String[] args) {
        CineService cine = new CineService();
        cine.iniciar();
    }
}