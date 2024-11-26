package view;

import Controller.PacienteServices;
import Controller.VacunaServices;
import model.Paciente;
import model.Vacuna;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VacunaServices vacunaServices = new VacunaServices();
        PacienteServices pacienteServices = new PacienteServices();

        while(true) {
            System.out.println("\n--- Sistema de Vacunación ---");
            System.out.println("1. Pacientes");
            System.out.println("2. Vacunas");
            System.out.println("3. Enfermeras");
            System.out.println("4. Lista de Vacunaciones");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Registro de Pacientes ---");
                    System.out.println("1. Listar Pacientes");
                    System.out.println("2. Agregar Paciente");
                    System.out.println("3. Eliminar Paciente");
                    System.out.println("4. Salir");
                    System.out.print("Seleccione una opción: ");

                    int opcion2 = sc.nextInt();
                    sc.nextLine();
                    PacienteView pacienteView = new PacienteView(opcion2);
                    break;

                case 2:
                    System.out.println("\n--- Registro de Vacunas ---");
                    System.out.println("1. Listar vacunas");
                    System.out.println("2. Agregar vacuna");
                    System.out.println("3. Eliminar vacuna");
                    System.out.println("4. Salir");
                    System.out.print("Seleccione una opción: ");

                    int opcion3 = sc.nextInt();
                    sc.nextLine();
                    VacunaView vacunaView = new VacunaView(opcion3);
                    break;

                case 3:
                    System.out.println("\n--- Registro de Enfermera ---");
                    System.out.println("1. Listar Enfermera");
                    System.out.println("2. Agregar Enfermera");
                    System.out.println("3. Eliminar Enfermera");
                    System.out.println("4. Salir");
                    System.out.print("Seleccione una opción: ");

                    int opcion4 = sc.nextInt();
                    sc.nextLine();
                    EnfermeraView enfermeraView = new EnfermeraView(opcion4);
                    break;
                case 4:
                    System.out.println("\n--- Registro de Vacunaciones ---");
                    System.out.println("1. Registro de Vacunacion");
                    System.out.println("2. Lista de Vacunados");
                    System.out.println("3. Eliminar Vacunado");
                    System.out.println("4. Salir");
                    System.out.print("Seleccione una opción: ");

                    int opcion5 = sc.nextInt();
                    sc.nextLine();
                    VacunacionView vacunacionView = new VacunacionView(opcion5);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
