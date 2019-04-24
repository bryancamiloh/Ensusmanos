/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.controller;




import com.helloworld.apispring.model.entity.Ciudadano;
import com.helloworld.apispring.model.entity.Ciudadano_evento;
import com.helloworld.apispring.model.entity.Evento;
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
   
   @Autowired
   private EventoServicio eventoServicio;
   
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
   public ResponseEntity<List<Ciudadano_evento>> obtenerReportesCiudadano(@PathVariable("id") long ident)
   {
       List<Ciudadano_evento> listaReportes = ciudadanoEventoServicio.obtenerReportesCiudadano(ident);
       return new ResponseEntity<List<Ciudadano_evento>>(listaReportes,HttpStatus.OK);
   }
   
   @RequestMapping(value="/ciudadanos",method=RequestMethod.GET)
   public ResponseEntity<List<Ciudadano>>obtenerCiudadanos(@RequestParam(value="pag", required=true) int pagina)
   {
       List<Ciudadano> listaCiudadanos = ciudadanoServicio.obtenerCiudadanos(pagina);
       return new ResponseEntity<List<Ciudadano>>(listaCiudadanos,HttpStatus.OK);
   }
   
   @RequestMapping(value="/eventos",method=RequestMethod.GET)
   public ResponseEntity<List<Evento>> obtenerEventos(){
       List<Evento> listaEventos = eventoServicio.obtenerEventos();
       return new ResponseEntity<List<Evento>>(listaEventos,HttpStatus.OK);
   }
   
   @RequestMapping(value="/eventos",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<String> agregarEvento(@RequestBody Evento evento)
   {
       long evt = eventoServicio.agregarEvento(evento);
       String mensaje = "El evento ha sido agregado exitosamente. Evento #: "+evt;
       return new ResponseEntity<String>(mensaje,HttpStatus.OK);
   }
   
   @RequestMapping(value="/login",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Ciudadano>Login(@RequestBody Ciudadano ciudadano)
   {   
       Ciudadano persona = ciudadanoServicio.Login(ciudadano);
       return new ResponseEntity<Ciudadano>(persona,HttpStatus.OK);
   }
   
   @RequestMapping(value="/puntajes",method=RequestMethod.GET)
   public ResponseEntity<List<Ciudadano>> otenerPuntajesDeCiudadanos()
   {
       List<Ciudadano> puntajesCiudadanos = ciudadanoServicio.obtenerPuntajesDeCiudadanos();
       return new ResponseEntity<List<Ciudadano>>(puntajesCiudadanos,HttpStatus.OK);
   }
   
   @RequestMapping(value="/top10",method=RequestMethod.GET)
   public ResponseEntity<List<Ciudadano>> obtenerTop10()
   {
       List<Ciudadano> topList = ciudadanoServicio.obtenerTop10();
       return new ResponseEntity<List<Ciudadano>>(topList,HttpStatus.OK);
   }
   
   @RequestMapping(value="/Ciudadanos/{id}/puntajes",method=RequestMethod.GET)
   public ResponseEntity<Ciudadano> obtnerPuntajeCiudadano(@PathVariable("id") int id)
   {
       Ciudadano ciudadano = ciudadanoServicio.obtenerPuntajeCiudadano(id);
       return new ResponseEntity<Ciudadano>(ciudadano,HttpStatus.OK);
   }
    
}
