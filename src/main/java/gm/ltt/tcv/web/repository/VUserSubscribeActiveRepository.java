/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gm.ltt.tcv.web.repository;

import gm.ltt.tcv.web.entity.VUserSubscribeActive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author X58
 */
@Repository
public interface VUserSubscribeActiveRepository extends JpaRepository<VUserSubscribeActive, Double> {
    
}
