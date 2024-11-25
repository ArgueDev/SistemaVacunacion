package Controller;

import database.DataBaseConnection;
import model.Vacuna;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacunaServices {
    public List<Vacuna> getAllVacunas() {
        List<Vacuna> vacunas = new ArrayList<>();
        String query = "SELECT * FROM vacuna";

        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                vacunas.add(new Vacuna(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("tipo"),
                        rs.getString("descripcion")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vacunas;
    }

    public void agregarVacunas(Vacuna vacuna) {
        String query = "INSERT INTO vacuna (nombre, tipo, descripcion) VALUES (?, ?, ?)";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, vacuna.getNombre());
            pstmt.setString(2, vacuna.getTipo());
            pstmt.setString(3, vacuna.getDescripcion());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarVacunaPorTipo(String tipo) {
        String query = "DELETE FROM vacuna WHERE tipo = ?";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, tipo);
            int filasAfectadas = pstmt.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Vacuna eliminado correctamente");
            } else {
                System.out.println("No se encontro una vacuna con el tipo especifico");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
