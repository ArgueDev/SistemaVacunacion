package model;

import java.util.Date;

public class Vacunacion {
    private int id;
    private Date fecha;
    private int dosis;
    private int vacunaId;
    private int pacienteId;
    private int enfermeraId;

    public Vacunacion(int id, Date fecha, int dosis, int vacunaId, int pacienteId, int enfermeraId) {
        this.id = id;
        this.fecha = fecha;
        this.dosis = dosis;
        this.vacunaId = vacunaId;
        this.pacienteId = pacienteId;
        this.enfermeraId = enfermeraId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getDosis() {
        return dosis;
    }

    public void setDosis(int dosis) {
        this.dosis = dosis;
    }

    public int getVacunaId() {
        return vacunaId;
    }

    public void setVacunaId(int vacunaId) {
        this.vacunaId = vacunaId;
    }

    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }

    public int getEnfermeraId() {
        return enfermeraId;
    }

    public void setEnfermeraId(int enfermeraId) {
        this.enfermeraId = enfermeraId;
    }
}
