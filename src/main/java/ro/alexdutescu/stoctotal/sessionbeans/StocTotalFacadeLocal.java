/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ro.alexdutescu.stoctotal.sessionbeans;

import java.util.List;
import javax.ejb.Local;
import ro.alexdutescu.stoctotal.model.StocTotal;
import ro.alexdutescu.stoctotal.model.Utilizatori;

/**
 *
 * @author Alex Dutescu
 */
@Local
public interface StocTotalFacadeLocal {

    void create(StocTotal stocTotal);

    void edit(StocTotal stocTotal);

    void remove(StocTotal stocTotal);

    StocTotal find(Object id);

    List<StocTotal> findAll();

    List<StocTotal> findRange(int[] range);

    int count();
    
    Utilizatori findUtilizatorByUsernameAndPassword(String username, String password);
    
    List<StocTotal> findStocByFilters(String locatie, Integer cod, String nume, String producator, Boolean scanat);
    
}
