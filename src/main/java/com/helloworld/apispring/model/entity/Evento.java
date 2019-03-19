/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.model.entity;

import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Evento")
public class Evento {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Num_evento")
    private long numEvento;
    
    @Column
    private String Descripcion;
    
    @Column
    private int Puntaje;
    
    @OneToMany(mappedBy="evento")
    private List<Ciudadano_evento> reportes;
    
    public Evento()
    {
        
    }

    public Evento(long numEvento, String Descripcion, int Puntaje) {
        this.numEvento = numEvento;
        this.Descripcion = Descripcion;
        this.Puntaje = Puntaje;
    }
    
    

    public long getNumEvento() {
        return numEvento;
    }

    public void setNumEvento(long numEvento) {
        this.numEvento = numEvento;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getPuntaje() {
        return Puntaje;
    }

    public void setPuntaje(int Puntaje) {
        this.Puntaje = Puntaje;
    }
    
    
    
}
