/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.model.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Ciudadano")
public class Ciudadano {
    
    @Id
    @Column(name="Identificacion")
    private long idCiudadano;
    
    @Column
    private String Nombre;
    
    @Column
    private String Apellido;
    
    @Column
    private String Contraseña;
    
    @Column
    private int Puntaje;
    
    @OneToMany(mappedBy="ciudadano")
    private List<Ciudadano_evento> reportes;
    
    public Ciudadano()
    {
        
    }
    

    public Ciudadano(long idCiudadano, String Nombre, String Apellido, String Contraseña) {
        this.idCiudadano = idCiudadano;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Contraseña = Contraseña;
        this.Puntaje = 0;
    }

    public long getIdCiudadano() {
        return idCiudadano;
    }

    public void setIdCiudadano(long idCiudadano) {
        this.idCiudadano = idCiudadano;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public int getPuntaje() {
        return Puntaje;
    }

    public void setPuntaje(int Puntaje) {
        this.Puntaje = Puntaje;
    }
    
    
    
}
