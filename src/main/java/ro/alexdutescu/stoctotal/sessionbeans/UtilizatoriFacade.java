/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ro.alexdutescu.stoctotal.sessionbeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import ro.alexdutescu.stoctotal.model.Utilizatori;

/**
 *
 * @author Alex Dutescu
 */
@Stateless
public class UtilizatoriFacade extends AbstractFacade<Utilizatori> implements UtilizatoriFacadeLocal {
//    @PersistenceContext(unitName = "stoctotalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        if (em == null){
            em = Persistence.createEntityManagerFactory("stoctotalPU").createEntityManager();
    }
        return em;
    }

    public UtilizatoriFacade() {
        super(Utilizatori.class);
    }
    
}
