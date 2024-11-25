package Controller;

import database.DataBaseConnection;
import model.Enfermera;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnfermeraServices {
    public List<Enfermera> getAllEnfermera() {
        List<Enfermera> enfermeras = new ArrayList<>();
        String query = "SELECT * FROM enfermera";

        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                enfermeras.add(new Enfermera(
                   rs.getInt("id"),
                   rs.getString("nombre"),
                   rs.getString("apellido"),
                   rs.getString("licencia"),
                   rs.getString("especialidad")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return enfermeras;
    }

    public void agregarEnfermera(Enfermera enfermera) {
        String query = "INSERT INTO enfermera (nombre, apellido, licencia, especialidad) VALUES (?, ?, ?, ?)";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstm = conn.prepareStatement(query)) {

            pstm.setString(1, enfermera.getNombre());
            pstm.setString(2, enfermera.getApellido());
            pstm.setString(3, enfermera.getLicencia());
            pstm.setString(4, enfermera.getEspecialidad());

            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarEnfermeraPorlicencia(String licencia) {
        String query = "DELETE FROM enfermera WHERE licencia = ?";

        try (Connection conn = DataBaseConnection.getConnection();
        PreparedStatement pstm = conn.prepareStatement(query)) {

            pstm.setString(1, licencia);
            int filasAfectadas = pstm.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Enfermera eliminada correctamente");
            } else {
                System.out.println("No se encontro una enfermera con su licencia");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
