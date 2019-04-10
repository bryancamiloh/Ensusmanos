/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.model.dao;

import com.helloworld.apispring.model.entity.Ciudadano;
import com.helloworld.apispring.model.entity.Ciudadano_evento;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class Ciudadano_eventoRepositorio implements Serializable{
    
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public long reportarCiudadano(Ciudadano_evento reporte)
    {
        getSessionFactory().getCurrentSession().save(reporte);
        return reporte.getNumReporte();
    }
    
    public List<Ciudadano_evento>obtenerReportesCiudadano(Ciudadano ciudadano)
    {
        Criteria crit = getSessionFactory().getCurrentSession().createCriteria(Ciudadano_evento.class);
        crit.add(Restrictions.eq("ciudadano", ciudadano));
        return crit.list();
    }
    
    
    
}
