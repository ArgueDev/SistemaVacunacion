package Controller;

import database.DataBaseConnection;
import model.Vacunacion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacunacionServices {
    public List<Vacunacion> getAllVacunados() {
        List<Vacunacion> vacunados = new ArrayList<>();
        String query = "SELECT * FROM vacunacion";

        try (Connection conn = DataBaseConnection.getConnection();
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery(query)) {

            while(rs.next()) {
                vacunados.add(new Vacunacion(
                        rs.getInt("id"),
                        rs.getDate("fecha"),
                        rs.getInt("dosis"),
                        rs.getInt("vacuna_id"),
                        rs.getInt("paciente_id"),
                        rs.getInt("enfermera_id")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vacunados;
    }

    public void agregarVacunado(Vacunacion vacunado) {
        String query = "INSERT INTO vacunacion (fecha, dosis, vacuna_id, paciente_id, enfermera_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstm = conn.prepareStatement(query)) {

            java.util.Date fechaDosis = vacunado.getFecha();
            java.sql.Date sqlFechaDosis = new java.sql.Date(fechaDosis.getTime());
            pstm.setDate(1, sqlFechaDosis);
            pstm.setInt(2, vacunado.getDosis());
            pstm.setInt(3, vacunado.getVacunaId());
            pstm.setInt(4, vacunado.getPacienteId());
            pstm.setInt(5, vacunado.getEnfermeraId());

            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarVacunadoPorPacienteID(int pacienteId) {
        String query = "DELETE FROM vacunacion WHERE paciente_id = ?";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstm = conn.prepareStatement(query)) {

            pstm.setInt(1, pacienteId);

            int filasAfectadas = pstm.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Vacunado eliminado correctamente.");
            } else {
                System.out.println("No se encontró un registro con ese paciente ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
