/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gm.ltt.tcv.web.repository.impl;

import gm.ltt.tcv.web.entity.VUserSubscribeActive;
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
public class VUserSubscribeActiveRepositoryImpl {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public VUserSubscribeActive findByMsisdn(double msisdn) {
        VUserSubscribeActive active = null;
        try {
            TypedQuery<VUserSubscribeActive> query = entityManager.createQuery("SELECT v FROM VUserSubscribeActive v WHERE v.userAccount = :msisdn", VUserSubscribeActive.class);
            query.setParameter("msisdn", msisdn);
            query.setFirstResult(0);
            query.setMaxResults(1);
            active = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return active;
    }
    
}
