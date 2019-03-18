/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Ciudadano_evento")
public class Ciudadano_evento implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Num_reporte")
    private long numReporte;
    
    @Column(name="Fecha_evento")
    private Date fechaEvento;
    
    @Column
    private String Situacion;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="Ident_ciudadano")
    private Ciudadano ciudadano;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="Num_evento")
    private Evento evento;
    
    @Transient
    private long idCiudadano;
    
    @Transient
    private long idEvento;
    
    public Ciudadano_evento()
    {
        
    }

    public Ciudadano_evento(long numReporte, Date fechaEvento, String Situacion, long idCiudadano, long idEvento) {
        this.numReporte = numReporte;
        this.fechaEvento = fechaEvento;
        this.Situacion = Situacion;
        this.idCiudadano = idCiudadano;
        this.idEvento = idEvento;
    }

    public long getNumReporte() {
        return numReporte;
    }

    public void setNumReporte(long numReporte) {
        this.numReporte = numReporte;
    }

    public Date getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(Date fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getSituacion() {
        return Situacion;
    }

    public void setSituacion(String Situacion) {
        this.Situacion = Situacion;
    }

    public long getIdCiudadano() {
        return idCiudadano;
    }

    public void setIdCiudadano(long idCiudadano) {
        this.idCiudadano = idCiudadano;
    }

    public long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(long idEvento) {
        this.idEvento = idEvento;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
    
    
}
