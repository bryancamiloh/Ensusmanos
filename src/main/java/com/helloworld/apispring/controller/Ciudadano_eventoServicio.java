/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.controller;

import com.helloworld.apispring.model.dao.CiudadanoRepositorio;
import com.helloworld.apispring.model.dao.Ciudadano_eventoRepositorio;
import com.helloworld.apispring.model.entity.Ciudadano;
import com.helloworld.apispring.model.entity.Ciudadano_evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Ciudadano_eventoServicio {
    
    @Autowired
    private Ciudadano_eventoRepositorio ciudadanoEventoRepositorio;
    
    @Autowired
    private CiudadanoRepositorio ciudadanoRepositorio;
    
    public Ciudadano_eventoServicio()
    {
        
    }
    
    public Long reportarCiudadano(Ciudadano_evento reporte)
    {
        Ciudadano ciudadano = ciudadanoRepositorio.obtenerCiudadanoPorId(reporte.getIdCiudadano());
        reporte.setCiudadano(ciudadano);
        return reporte.getNumReporte();
    }
    
}
