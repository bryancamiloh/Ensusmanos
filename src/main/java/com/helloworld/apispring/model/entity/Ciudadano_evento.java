/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
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
public class Ciudadano_evento {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Num_reporte")
    private long numReporte;
    
    @Column
    private String Fecha;
    
    @Column
    private String Situacion;
    
    @Transient
    private long idCiudadano;
    
    @Transient
    private long idEvento;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="Ident_ciudadano")
    private Ciudadano ciudadano;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="Num_evento")
    private Evento evento;
    
    public Ciudadano_evento() {
    }

    public Ciudadano_evento(String Fecha, String Situacion, long idCiudadano, long idEvento) {
        this.Fecha = Fecha;
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

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getSituacion() {
        return Situacion;
    }

    public void setSituacion(String Situacion) {
        this.Situacion = Situacion;
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
    
}
