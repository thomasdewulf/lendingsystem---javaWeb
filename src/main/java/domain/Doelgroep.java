package domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
public class Doelgroep implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int doelgroepId;
    private String naam;
    
    protected Doelgroep() {

    }

    public Doelgroep(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    @Override
    public String toString() {
        return String.format("%s", this.naam);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return true;
        }
        Doelgroep f = (Doelgroep) obj;
    
        return f.getNaam().equals(this.naam);
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 37 * hash + this.doelgroepId;
        return hash;
    }

}
