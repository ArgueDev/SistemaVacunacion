package view;

import Controller.EnfermeraServices;
import model.Enfermera;
import model.Vacuna;

import java.util.Scanner;

public class EnfermeraView {
    private final Scanner sc = new Scanner(System.in);
    private final EnfermeraServices enfermeraServices = new EnfermeraServices();

    public EnfermeraView(int opcion) {
        ejecutarOpcion(opcion);
    }

    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                listarEnfermera();
                break;
            case 2:
                agregarEnfermera();
                break;
            case 3:
                eliminarEnfermera();
                break;
            case 4:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    private void listarEnfermera() {
        enfermeraServices.getAllEnfermera().forEach(enfermera -> {
            System.out.println("ID: " + enfermera.getId()
                    + ", Nombre: " + enfermera.getNombre()
                    + ", Apellido: " + enfermera.getApellido()
                    + ", Licencia: " + enfermera.getLicencia()
                    + ", Especialidad: " + enfermera.getEspecialidad());
        });
    }

    private void agregarEnfermera() {
        System.out.print("Ingrese el nombre de la Enfermera: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el apellido de la Enfermera: ");
        String apellido = sc.nextLine();
        System.out.print("Ingrese la licencia de la Enfermera: ");
        String licencia = sc.nextLine();
        System.out.print("Ingrese la especialidad de la Enfermera: ");
        String especialidad = sc.nextLine();

        Enfermera enfermera = new Enfermera(0, nombre, apellido, licencia, especialidad);
        enfermeraServices.agregarEnfermera(enfermera);
        System.out.println("Enfermera agregada correctamente.");
    }

    private void eliminarEnfermera() {
        System.out.print("Ingrese la licencia de la Enfermera: ");
        String licencia = sc.nextLine();
        enfermeraServices.eliminarEnfermeraPorlicencia(licencia);
    }
}
