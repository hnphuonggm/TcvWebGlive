/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gm.ltt.tcv.web.repository.impl;

import gm.ltt.tcv.web.entity.TcvWebContent;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

/**
 *
 * @author X58
 */
@Repository
public class TcvWebContentRepositoryImpl {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public TcvWebContent findByKey(String key) {
        TcvWebContent content = null;
        try {
            TypedQuery<TcvWebContent> query = entityManager.createQuery("SELECT t FROM TcvWebContent t WHERE t.key = :key", TcvWebContent.class);
            query.setParameter("key", key);
            query.setFirstResult(0);
            query.setMaxResults(1);
            content = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }
    
}
