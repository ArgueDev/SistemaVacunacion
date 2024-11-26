package view;

import Controller.VacunaServices;
import model.Vacuna;

import java.util.Scanner;

public class VacunaView {
    private final Scanner sc = new Scanner(System.in);
    private final VacunaServices vacunaServices = new VacunaServices();

    public VacunaView(int opcion) {
        ejecutarOpcion(opcion);
    }

    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                listarVacunas();
                break;
            case 2:
                agregarVacuna();
                break;
            case 3:
                eliminarVacuna();
                break;
            case 4:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }

    private void listarVacunas() {
        vacunaServices.getAllVacunas().forEach(vacuna ->
                System.out.println("ID: " + vacuna.getId() +
                        ", Nombre: " + vacuna.getNombre() +
                        ", Tipo: " + vacuna.getTipo() +
                        ", Descripción: " + vacuna.getDescripcion())
        );
    }

    private void agregarVacuna() {
        System.out.print("Ingrese el nombre de la vacuna: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el tipo de vacuna: ");
        String tipo = sc.nextLine();
        System.out.print("Ingrese una descripción: ");
        String descripcion = sc.nextLine();

        Vacuna nuevaVacuna = new Vacuna(0, nombre, tipo, descripcion);
        vacunaServices.agregarVacunas(nuevaVacuna);
        System.out.println("Vacuna agregada correctamente.");
    }

    private void eliminarVacuna() {
        System.out.print("Ingrese el tipo de vacuna: ");
        String tipoVacuna = sc.nextLine();
        vacunaServices.eliminarVacunaPorTipo(tipoVacuna);
    }
}
