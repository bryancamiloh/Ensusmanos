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
    
    public Ciudadano obtenerCiudadanoPorId(long id)
    {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Ciudadano.class);
        criteria.add(Restrictions.eq("idCiudadano", id));
        return (Ciudadano) criteria.uniqueResult();
    }
    
    public List<Ciudadano> obtenerCiudadanos()
    {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Ciudadano.class);
        return criteria.list();
    }
    
}
