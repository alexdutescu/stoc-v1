/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ro.alexdutescu.stoctotal.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alex Dutescu
 */
@Entity
@Table(name = "utilizatori")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilizatori.findAll", query = "SELECT u FROM Utilizatori u"),
    @NamedQuery(name = "Utilizatori.findByIdUtilizator", query = "SELECT u FROM Utilizatori u WHERE u.idUtilizator = :idUtilizator"),
    @NamedQuery(name = "Utilizatori.findByNumeUtilizator", query = "SELECT u FROM Utilizatori u WHERE u.numeUtilizator = :numeUtilizator"),
    @NamedQuery(name = "Utilizatori.findByParolaUtilizator", query = "SELECT u FROM Utilizatori u WHERE u.parolaUtilizator = :parolaUtilizator"),
    @NamedQuery(name = "Utilizatori.findByLocatie", query = "SELECT u FROM Utilizatori u WHERE u.locatie = :locatie")})
public class Utilizatori implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUtilizator")
    private Integer idUtilizator;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "numeUtilizator")
    private String numeUtilizator;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "parolaUtilizator")
    private String parolaUtilizator;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "locatie")
    private String locatie;

    public Utilizatori() {
    }

    public Utilizatori(Integer idUtilizator) {
        this.idUtilizator = idUtilizator;
    }

    public Utilizatori(Integer idUtilizator, String numeUtilizator, String parolaUtilizator, String locatie) {
        this.idUtilizator = idUtilizator;
        this.numeUtilizator = numeUtilizator;
        this.parolaUtilizator = parolaUtilizator;
        this.locatie = locatie;
    }

    public Integer getIdUtilizator() {
        return idUtilizator;
    }

    public void setIdUtilizator(Integer idUtilizator) {
        this.idUtilizator = idUtilizator;
    }

    public String getNumeUtilizator() {
        return numeUtilizator;
    }

    public void setNumeUtilizator(String numeUtilizator) {
        this.numeUtilizator = numeUtilizator;
    }

    public String getParolaUtilizator() {
        return parolaUtilizator;
    }

    public void setParolaUtilizator(String parolaUtilizator) {
        this.parolaUtilizator = parolaUtilizator;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUtilizator != null ? idUtilizator.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilizatori)) {
            return false;
        }
        Utilizatori other = (Utilizatori) object;
        if ((this.idUtilizator == null && other.idUtilizator != null) || (this.idUtilizator != null && !this.idUtilizator.equals(other.idUtilizator))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ro.alexdutescu.stoctotal.model.Utilizatori[ idUtilizator=" + idUtilizator + " ]";
    }
    
}
