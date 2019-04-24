/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.controller;

import com.helloworld.apispring.model.dao.EventoRepositorio;
import com.helloworld.apispring.model.entity.Evento;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventoServicio {
    
    @Autowired
    private EventoRepositorio eventoRepositorio;
    
    
    public List<Evento> obtenerEventos()
    {
        List<Evento> eventos = eventoRepositorio.obtenerEventos();
        return eventos;
    }
    
}
