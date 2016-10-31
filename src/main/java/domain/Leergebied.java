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
public class Leergebied implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int leergebiedId;
    private String naam;
    
    protected Leergebied()
    {

    }

    public Leergebied(String naam)
    {
        this.naam = naam;
    }

    public String getNaam()
    {
        return naam;
    }

    @Override
    public String toString()
    {
        return String.format("%s", naam);
    }
     @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return true;
        }
       Leergebied f = (Leergebied) obj;
      
       return f.naam.equals(this.naam);
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 89 * hash + this.leergebiedId;
        return hash;
    }

}
