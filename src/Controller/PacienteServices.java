package Controller;

import database.DataBaseConnection;
import model.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteServices {
    public List<Paciente> getAllPaciente() {
        List<Paciente> pacientes = new ArrayList<>();
        String query = "SELECT * FROM paciente";

        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                pacientes.add(new Paciente(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getDate("fechaNacimiento"),
                        rs.getString("direccion"),
                        rs.getString("telefono")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pacientes;
    }

    public void agregarPaciente(Paciente paciente) {
        String query = "INSERT INTO paciente (nombre, apellido, fechaNacimiento, direccion, telefono) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, paciente.getNombre());
            pstmt.setString(2, paciente.getApellido());
            // Conversión de fecha
            java.util.Date fechaNacimiento = paciente.getFechaNacimiento();
            java.sql.Date sqlFechaNacimiento = new java.sql.Date(fechaNacimiento.getTime());
            pstmt.setDate(3, sqlFechaNacimiento);
            pstmt.setString(4, paciente.getDireccion());
            pstmt.setString(5, paciente.getTelefono());


            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarPacientePorTelefono(String telefono) {
        String query = "DELETE FROM paciente WHERE telefono = ?";

        try (Connection conn = DataBaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, telefono);
            int filasAfectadas = pstmt.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Paciente eliminado correctamente");
            } else {
                System.out.println("No se encontro un paciente con el telefono especifico");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
