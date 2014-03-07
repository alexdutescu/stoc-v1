/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ro.alexdutescu.stoctotal.sessionbeans;

import java.util.List;
import javax.ejb.Local;
import ro.alexdutescu.stoctotal.model.Utilizatori;

/**
 *
 * @author Alex Dutescu
 */
@Local
public interface UtilizatoriFacadeLocal {

    void create(Utilizatori utilizatori);

    void edit(Utilizatori utilizatori);

    void remove(Utilizatori utilizatori);

    Utilizatori find(Object id);

    List<Utilizatori> findAll();

    List<Utilizatori> findRange(int[] range);

    int count();
    
}
