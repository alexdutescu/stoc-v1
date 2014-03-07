/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ro.alexdutescu.stoctotal.sessionbeans;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import ro.alexdutescu.stoctotal.model.StocTotal;
import ro.alexdutescu.stoctotal.model.Utilizatori;

/**
 *
 * @author Alex Dutescu
 */
@Stateless
public class StocTotalFacade extends AbstractFacade<StocTotal> implements StocTotalFacadeLocal {
//    @PersistenceContext(unitName = "stoctotalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        if (em == null){
            em = Persistence.createEntityManagerFactory("stoctotalPU").createEntityManager();
    }
        return em;
    }

    public StocTotalFacade() {
        super(StocTotal.class);
    }

    @Override
    public Utilizatori findUtilizatorByUsernameAndPassword(String username, String password) {
        Utilizatori u = em.createQuery("SELECT u FROM Utilizatori u WHERE u.numeUtilizator=:usr AND u.parolaUtilizator=:psw", Utilizatori.class)
                .setParameter("usr", username)
                .setParameter("psw", password)
                .getResultList().get(0);
        if(u != null) {return u;}
        return null;
    }

    @Override
    public List<StocTotal> findStocByFilters(String locatie, Integer cod, String nume, String producator, Boolean scanat) {
        String query = "SELECT s FROM StocTotal s";
        if (locatie != null && !locatie.toLowerCase().equals("god_mode") && locatie.length() > 0) {
			query = query.concat(" where lower(s.locatie) = '" + locatie.toLowerCase() + "' and ");
			if(cod != null) {query = query.concat("lower(s.cod)="+ cod +" and ");}
			if(!scanat) {query = query.concat("(lower(s.codBare) IS  NULL  OR lower(s.codBare) = '') and ");}
			if(nume != null && !"".equals(nume)){ query = query.concat("lower(s.nume) LIKE '"+ nume +"%' and ");}
			if(producator != null && !"".equals(producator)){ query = query.concat("lower(s.producator) LIKE '"+ producator+"%' and ");}
			
//			if(query.length() > 14) {query =  query.substring(0,query.length()-4);}
			query =  query.substring(0,query.length()-4);
			
		}else {
			if (cod != null || !scanat || (nume != null && nume.length() > 0) || (producator != null && producator.length() > 0)) query = query.concat(" WHERE ");
			if(cod != null) {query = query.concat("lower(s.cod)="+ cod +" and ");}
			if(!scanat) {query = query.concat("(lower(s.codBare) IS  NULL  OR lower(s.codBare) = '') and ");}
			if(nume != null && nume.length() > 0){ query = query.concat("lower(s.nume) LIKE '"+ nume +"%' and ");}
			if(producator != null && producator.length() > 0){ query = query.concat("lower(s.producator) LIKE '"+ producator+"%' and ");}

//			if(query.length() > 14) {query =  query.substring(0,query.length()-4);}
			if (cod != null || !scanat || (nume != null && nume.length() > 0) || (producator != null && producator.length() > 0)) {
                            query =  query.substring(0,query.length()-4);
                        }
		}
        query = query.concat(" ORDER BY s.nume");
        Logger.getLogger(StocTotalFacade.class.toString()).log(Level.INFO, query);
        return em.createQuery(query, StocTotal.class).getResultList();
    }
}
