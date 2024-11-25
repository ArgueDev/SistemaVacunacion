package model;

import java.util.Date;

public class Vacunacion {
    private int id;
    private Date fecha;
    private int dosis;

    public Vacunacion(int id, Date fecha, int dosis) {
        this.id = id;
        this.fecha = fecha;
        this.dosis = dosis;
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
}
