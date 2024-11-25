package model;

public class Enfermera {
    private int id;
    private String nombre;
    private String apellido;
    private String licencia;
    private String especialidad;

    public Enfermera(int id, String nombre, String apellido, String licencia, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.licencia = licencia;
        this.especialidad = especialidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
