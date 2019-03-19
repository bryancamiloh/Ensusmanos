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
import org.springframework.web.bind.annotation.RequestParam;
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
       String Mensaje = "Reporte realizado con éxito numero de reporte: "+ciudadanoEventoServicio.reportarCiudadano(reporte);
       return new ResponseEntity<String>(Mensaje,HttpStatus.OK);
   }
   
   @RequestMapping(value="/ciudadanos/{id}/reportes",method=RequestMethod.GET)
   public ResponseEntity<String> obtenerReportesCiudadano(@PathVariable("id") long ident)
   {
       String Mensaje = "";
       List<Ciudadano_evento> listaReportes = ciudadanoEventoServicio.obtenerRepoortesCiudadano(ident);
       if(!listaReportes.isEmpty())
           Mensaje = "Se han encontrado los siguientes reportes: \n\n"+listaReportes;
       else
           Mensaje="El ciudadano no tiene reportes";
       
       return new ResponseEntity<String>(Mensaje,HttpStatus.OK);
   }
   
   @RequestMapping(value="/ciudadanos",method=RequestMethod.GET)
   public ResponseEntity<List<Ciudadano>>obtenerCiudadanos()
   {
       List<Ciudadano> listaCiudadanos = ciudadanoServicio.obtenerCiudadanos();
       return new ResponseEntity<List<Ciudadano>>(listaCiudadanos,HttpStatus.OK);
   }
   
   @RequestMapping(value="/login",method=RequestMethod.GET)
   public ResponseEntity<String>Login(@RequestParam(value="id", required=true) long ident, @RequestParam(value="pass", required=true) String contraseña)
   {
       List<Ciudadano> resultado = ciudadanoServicio.Login(ident, contraseña);
       String Mensaje = "";
       if(!resultado.isEmpty())
           Mensaje = "El usuario ha sido ha sido autenticado exitosamente";
       else
           Mensaje = "No existe un usuario con los datos ingresados";
       
       return new ResponseEntity<String>(Mensaje,HttpStatus.OK);
   }
   
   @RequestMapping(value="/puntajes/{pag}",method=RequestMethod.GET)
   public ResponseEntity<List<Ciudadano>> otenerPuntajesDeCiudadanos(@PathVariable("pag") int pagina)
   {
       List<Ciudadano> puntajesCiudadanos = ciudadanoServicio.obtenerPuntajesDeCiudadanos(pagina);
       return new ResponseEntity<List<Ciudadano>>(puntajesCiudadanos,HttpStatus.OK);
   }
   
   @RequestMapping(value="/top10",method=RequestMethod.GET)
   public ResponseEntity<List<Ciudadano>> obtenerTop10()
   {
       List<Ciudadano> topList = ciudadanoServicio.obtenerTop10();
       return new ResponseEntity<List<Ciudadano>>(topList,HttpStatus.OK);
   }
    
}
