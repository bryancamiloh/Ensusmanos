/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.model.dao;

import com.helloworld.apispring.model.entity.Ciudadano;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CiudadanoRepositorio {
    
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public long registrarCuidadano(Ciudadano ciudadano)
    {
        getSessionFactory().getCurrentSession().save(ciudadano);
        return ciudadano.getIdCiudadano();
    }
    
    public Ciudadano login(Ciudadano ciudadano)
    {
        Criteria crit = getSessionFactory().getCurrentSession().createCriteria(Ciudadano.class);
        crit.add(Restrictions.eq("idCiudadano", ciudadano.getIdCiudadano()));
        crit.add(Restrictions.eq("Contrasena", ciudadano.getContrasena()));
        return (Ciudadano) crit.uniqueResult();
    }
    
    public Ciudadano obtenerCiudadanoPorId(long id)
    {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Ciudadano.class);
        criteria.add(Restrictions.eq("idCiudadano", id));
        return (Ciudadano) criteria.uniqueResult();
    }
    
    public List<Ciudadano> obtenerCiudadanos(int pagina)
    {
        int resultados = 5;
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Ciudadano.class);
        criteria.setFirstResult((resultados * pagina) - resultados);
        criteria.setMaxResults(resultados);
        return criteria.list();
    }
    
    public List<Ciudadano> obtenerPuntajesDeCiudadanos()
    {
        
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Ciudadano.class);
        ProjectionList projection = Projections.projectionList();
        projection.add(Projections.property("Nombre"));
        projection.add(Projections.property("Apellido"));
        projection.add(Projections.property("Puntaje"));
        criteria.setProjection(projection);
        criteria.addOrder(Order.desc("Puntaje"));
        return criteria.list();
    }
    
    public List<Ciudadano> obtenerTop10()
    {   
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Ciudadano.class);
        ProjectionList projection = Projections.projectionList();
        projection.add(Projections.property("Nombre"));
        projection.add(Projections.property("Apellido"));
        projection.add(Projections.property("Puntaje"));
        criteria.setProjection(projection);
        criteria.addOrder(Order.desc("Puntaje"));
        criteria.setMaxResults(10);
        return criteria.list();
    }
    
    public Ciudadano obtenerPuntajeCiudadano(long id)
    {
       Criteria c = getSessionFactory().getCurrentSession().createCriteria(Ciudadano.class);
       c.add(Restrictions.eq("idCiudadano", id));
       ProjectionList p = Projections.projectionList();
       p.add(Projections.property("Puntaje"));
       return (Ciudadano) c.uniqueResult();
    }
    
}
