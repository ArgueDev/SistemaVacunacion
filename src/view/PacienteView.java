package view;

import Controller.PacienteServices;
import model.Paciente;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PacienteView {
    private final Scanner sc = new Scanner(System.in);
    private final PacienteServices pacienteServices = new PacienteServices();

    public PacienteView(int opcion) {
        ejecutarOpcion(opcion);
    }

    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                listarPacientes();
                break;
            case 2:
                agregarPaciente();
                break;
            case 3:
                eliminarPaciente();
                break;
            case 4:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    private void listarPacientes() {
        pacienteServices.getAllPaciente().forEach(paciente -> {
            System.out.println("ID: " + paciente.getId()
                    + ", Nombre: " + paciente.getNombre()
                    + ", Apellido: " + paciente.getApellido()
                    + ", Cedula: " + paciente.getCedula()
                    + ", FechaNacimiento: " + paciente.getFechaNacimiento()
                    + ", Direccion: " + paciente.getDireccion()
                    + ", Telefono: " + paciente.getTelefono());
        });
    }

    private void agregarPaciente() {
        System.out.print("Ingrese el nombre del paciente: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el apellido del paciente: ");
        String apellido = sc.nextLine();
        System.out.print("Ingresa la cedula del paciente: ");
        String cedula = sc.nextLine();

        java.sql.Date sqlFechaNacimiento = null;
        System.out.print("Ingrese la fecha de nacimiento (yyyy-MM-dd): ");
        String fechaString = sc.nextLine();
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaNacimiento = formato.parse(fechaString);
            sqlFechaNacimiento = new java.sql.Date(fechaNacimiento.getTime());
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Intente de nuevo.");
            return; // Salir del método si el formato es inválido
        }

        System.out.print("Ingrese la dirección: ");
        String direccion = sc.nextLine();
        System.out.print("Ingrese el teléfono: ");
        String telefono = sc.nextLine();

        Paciente nuevoPaciente = new Paciente(0, nombre, apellido, cedula, sqlFechaNacimiento, direccion, telefono);
        pacienteServices.agregarPaciente(nuevoPaciente);
        System.out.println("Paciente agregado correctamente.");
    }

    private void eliminarPaciente() {
        System.out.print("Ingrese la cedula del paciente: ");
        String cedula = sc.nextLine();
        pacienteServices.eliminarPacientePorCedula(cedula);
    }
}
