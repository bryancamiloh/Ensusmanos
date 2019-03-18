/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.controller;




import com.helloworld.apispring.model.entity.Ciudadano;
import com.helloworld.apispring.model.entity.Ciudadano_evento;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ensusmanos")
public class Controller {
   
   @Autowired
   private CiudadanoServicio ciudadanoServicio;
   
   @Autowired
   private Ciudadano_eventoServicio ciudadanoEventoServicio;
   
   @RequestMapping(value="/ciudadanos",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<String> registrarCiudadano(@RequestBody Ciudadano ciudadano)
   {
       String Mensaje = "Se ha realizado exitosamente un registro con número de identificacion: "+ciudadanoServicio.registrarCiudadano(ciudadano);
       return new ResponseEntity<String>(Mensaje,HttpStatus.OK);
   }
   
   @RequestMapping(value="/ciudadanos/{id}",method=RequestMethod.GET)
   public ResponseEntity<Ciudadano> obtenerCiudadanoPorId(@PathVariable("id") long id)
   {
       Ciudadano persona = ciudadanoServicio.obtenerCiudadanoPorId(id);
       return new ResponseEntity<Ciudadano>(persona,HttpStatus.OK);
   }
   
   @RequestMapping(value="/ciudadanos/{id}/reportes",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<String> reportarCiudadano(@RequestBody Ciudadano_evento reporte, @PathVariable("id") long id)
   {
       String Mensaje = "Se ha realizado con éxito un reporte con el número de identificacion: "+ciudadanoEventoServicio.reportarCiudadano(reporte);
       return new ResponseEntity<String>(Mensaje,HttpStatus.OK);
   }
   
   @RequestMapping(value="/ciudadanos",method=RequestMethod.GET)
   public ResponseEntity<List<Ciudadano>>obtenerCiudadanos()
   {
       List<Ciudadano> listaCiudadanos = ciudadanoServicio.obtenerCiudadanos();
       return new ResponseEntity<List<Ciudadano>>(listaCiudadanos,HttpStatus.OK);
   }
    
}
