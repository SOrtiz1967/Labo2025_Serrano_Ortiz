import segundoCuatri.Ej2repaso.Publicacion;

import java.time.LocalDate;
import java.util.*;

public class Usuario {
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private double credito;
    private String mail;
    private int numeroSocio;

    public int getNumeroSocio() {
        return numeroSocio;
    }

    public void setNumeroSocio(int numeroSocio) {
        this.numeroSocio = numeroSocio;
    }

    private HashSet<Publicacion> publicacionesLeidas;
    private HashMap<Publicacion, Integer> prestamosSolicitados; // Publicación y cantidad de veces

    // Constructor
    public Usuario(String nombre, String apellido, LocalDate fechaNacimiento, double credito, String mail, int numeroSocio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.credito = credito;
        this.mail = mail;
        this.publicacionesLeidas = new HashSet<>();
        this.prestamosSolicitados = new HashMap<>();
        this.numeroSocio=numeroSocio;
    }

    // Getters y Setters
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public HashSet<Publicacion> getPublicacionesLeidas() {
        return publicacionesLeidas;
    }

    public void setPublicacionesLeidas(HashSet<Publicacion> publicacionesLeidas) {
        this.publicacionesLeidas = publicacionesLeidas;
    }

    public HashMap<Publicacion, Integer> getPrestamosSolicitados() {
        return prestamosSolicitados;
    }

    public void setPrestamosSolicitados(HashMap<Publicacion, Integer> prestamosSolicitados) {
        this.prestamosSolicitados = prestamosSolicitados;
    }
}