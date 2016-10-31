package domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
public class Firma implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int firmaId;
    private String website;
    private String contactPersoon;
    private String emailContactPersoon;
    private String naam;

    public Firma()
    {

    }

    public Firma(String naam, String website, String contactPersoon, String emailContactPersoon)
    {
        this.naam = naam;
        this.website = website;
        this.contactPersoon = contactPersoon;
        this.emailContactPersoon = emailContactPersoon;
    }

    public String getNaam() {
        return naam;
    }

    public String getWebsite() {
        return website;
    }

    public String getContactPersoon() {
        return contactPersoon;
    }

    public String getEmailContactPersoon() {
        return emailContactPersoon;
    }
    
    @Override
    public String toString()
    {
        return String.format("%s", this.naam);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return true;
        }
       Firma f = (Firma) obj;
       return f.naam.equals(this.naam);
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 37 * hash + this.firmaId;
        return hash;
    }
    

}
