/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ro.alexdutescu.stoctotal.controllers;

import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.util.Faces;
import org.primefaces.context.RequestContext;
import ro.alexdutescu.stoctotal.model.Utilizatori;
import ro.alexdutescu.stoctotal.sessionbeans.StocTotalFacadeLocal;

/**
 *
 * @author Alex Dutescu
 */
@Named("login")
@SessionScoped
public class LoginController implements Serializable{
    @Inject StocTotalFacadeLocal stfl;
//    @Inject PageController page;
    
    private String username, password;
    private Utilizatori utilizator;

    public Utilizatori getUtilizator() {
        return utilizator;
    }

    public void setUtilizator(Utilizatori utilizator) {
        this.utilizator = utilizator;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void redirect() throws IOException {
        try{
            utilizator = stfl.findUtilizatorByUsernameAndPassword(username, password);
        }catch(EJBException e) {
            //nmk
        }
        
        if (utilizator != null) {
            Faces.invalidateSession();
            Faces.setSessionAttribute("utilizator", utilizator);
            
            Faces.redirect("index.xhtml");
        }
        else RequestContext.getCurrentInstance().execute("loginFailedWidget.show()");
    }
    
    public void logout() throws IOException {
        Faces.invalidateSession();
        Faces.redirect("login.xhtml");
    }
}
