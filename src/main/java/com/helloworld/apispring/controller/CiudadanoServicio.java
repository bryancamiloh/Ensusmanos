/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.controller;

import com.helloworld.apispring.model.dao.CiudadanoRepositorio;
import com.helloworld.apispring.model.entity.Ciudadano;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CiudadanoServicio {
    
    @Autowired
    private CiudadanoRepositorio ciudadanoRepositorio;
    
    public CiudadanoServicio()
    {
        
    }
    
    public Ciudadano registrarCiudadano(Ciudadano ciudadano)
    {
        return ciudadanoRepositorio.registrarCuidadano(ciudadano);
    }
    
    public Ciudadano obtenerCiudadanoPorId(long id)
    {
        return ciudadanoRepositorio.obtenerCiudadanoPorId(id);
    }
    
    public List<Ciudadano> obtenerCiudadanos(int pagina)
    {
        return ciudadanoRepositorio.obtenerCiudadanos(pagina);
    }
    
    public List<Ciudadano> obtenerCiudadanos()
    {
        return ciudadanoRepositorio.obtenerCiudadanos();
    }
    
    public Ciudadano Login(Ciudadano ciudadano)
    {
        return ciudadanoRepositorio.login(ciudadano);
    }
    
    public List<Ciudadano> obtenerPuntajesDeCiudadanos()
    {
        return ciudadanoRepositorio.obtenerPuntajesDeCiudadanos();
    }
    
    public List<Ciudadano> obtenerTop10()
    {
        return ciudadanoRepositorio.obtenerTop10();
    }
    
    public Ciudadano obtenerPuntajeCiudadano(long id)
    {
        return ciudadanoRepositorio.obtenerPuntajeCiudadano(id);
    }
    
}
