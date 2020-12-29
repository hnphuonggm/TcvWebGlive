/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gm.ltt.tcv.web.repository;

import gm.ltt.tcv.web.entity.TcvWebContent;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author X58
 */
public interface TcvWebContentRepository extends JpaRepository<TcvWebContent, Double> {
    
}
