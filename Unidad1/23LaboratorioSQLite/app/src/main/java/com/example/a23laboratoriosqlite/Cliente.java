package com.example.a23laboratoriosqlite;

public class Cliente {

    private int idCliente;
    private String nombre;
    private String rfc;
    private String cel;
    private String descripcion;
    private String costo;

    public Cliente(int idCliente, String nombre, String rfc, String cel, String descripcion, String costo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.rfc = rfc;
        this.cel = cel;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }
}
