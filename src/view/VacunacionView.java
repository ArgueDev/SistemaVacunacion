package view;

import Controller.EnfermeraServices;
import Controller.PacienteServices;
import Controller.VacunaServices;
import Controller.VacunacionServices;
import model.Vacunacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class VacunacionView {
    private final Scanner sc = new Scanner(System.in);
    private final VacunacionServices vacunacionServices = new VacunacionServices();
    private VacunaServices vacunaServices = new VacunaServices();
    private PacienteServices pacienteServices = new PacienteServices();
    private EnfermeraServices enfermeraServices = new EnfermeraServices();

    public VacunacionView(int opcion) {
        ejecutarOpcion(opcion);
    }

    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                agregarVacunados();
                break;
            case 2:
                listarVacunados();
                break;
            case 3:
                eliminarVacunados();
                break;
            case 4:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    private void listarVacunados() {
        vacunacionServices.getAllVacunados().forEach(vacunacion -> {
            System.out.println("ID: " + vacunacion.getId()
                            + ", Fecha: " + vacunacion.getFecha()
                            + ", Dosis: " + vacunacion.getDosis()
                            + ", Vacuna: " + vacunacion.getVacunaId()
                            + ", Paciente: " + vacunacion.getPacienteId()
                            + ", Enfermera: " + vacunacion.getEnfermeraId()
            );
        });
    }

    private void agregarVacunados() {
        System.out.println("--- Vacunas ---");
        // Llama al servicio que lista vacunas (impleméntalo si no existe)
        vacunaServices.getAllVacunas().forEach(vacuna ->
                System.out.println("ID: " + vacuna.getId() + ", Nombre: " + vacuna.getNombre())
        );

        System.out.println("--- Pacientes ---");
        pacienteServices.getAllPaciente().forEach(paciente ->
                System.out.println("ID: " + paciente.getId() + ", Nombre: " + paciente.getNombre())
        );

        System.out.println("--- Enfermeras ---");
        enfermeraServices.getAllEnfermera().forEach(enfermera ->
                System.out.println("ID: " + enfermera.getId() + ", Nombre: " + enfermera.getNombre())
        );
        java.sql.Date sqlFecha = null;
        System.out.print("\nIngresa la fecha (yyyy-MM-dd): ");
        String fechaString = sc.nextLine();

        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaDosis = formato.parse(fechaString);
            sqlFecha = new java.sql.Date(fechaDosis.getTime());
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Intente de nuevo.");
            return; // Salir del método si el formato es inválido
        }

        System.out.print("Ingresa la dosis: ");
        int dosis = sc.nextInt();
        System.out.print("Ingrese el ID de la vacuna: ");
        int vacunaId = sc.nextInt();
        System.out.print("Ingrese el ID del paciente: ");
        int pacienteId = sc.nextInt();
        System.out.print("Ingrese el ID de la enfermera: ");
        int enfermeraId = sc.nextInt();

        Vacunacion nuevoVacunado = new Vacunacion(0, sqlFecha, dosis, vacunaId, pacienteId, enfermeraId);
        vacunacionServices.agregarVacunado(nuevoVacunado);
        System.out.println("Vacunado agregado correctamente");

    }

    private void eliminarVacunados() {
        System.out.print("Ingrese el ID del paciente para eliminar su vacunación: ");
        int pacienteId = sc.nextInt();
        vacunacionServices.eliminarVacunadoPorPacienteID(pacienteId);
    }

}
