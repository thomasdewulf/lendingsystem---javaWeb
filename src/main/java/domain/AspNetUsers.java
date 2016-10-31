/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Maarten
 */
@Entity
public class AspNetUsers implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String gebruikersNummer;
    private String naam;
    private String voornaam;
    private String foto;
    private String email;
    private String userName;
    @OneToMany(mappedBy = "user")
    private List<Reservatie> reservaties;
    public AspNetUsers() {
    }

    public AspNetUsers(String naam, String voornaam, String email)
    {
        this.naam = naam;
        this.voornaam = voornaam;
        this.email = email;
    }

    public AspNetUsers(String gebruikersNummer, String naam, String voornaam, String foto, String email, String userName)
    {
        this.gebruikersNummer = gebruikersNummer;
        this.naam = naam;
        this.voornaam = voornaam;
        this.foto = foto;
        this.email = email;
        this.userName = userName;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += 1;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AspNetUsers))
        {
            return false;
        }
        AspNetUsers other = (AspNetUsers) object;
        return !(this.id == null ? other.id != null : !this.id.equals(other.id));
    }

    @Override
    public String toString()
    {
        return this.naam + " " + this.voornaam;
    }
    
    public String getGebruikersNummer() {
        return gebruikersNummer;
    }
    
    public String getNaam() {
        return naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getFoto() {
        return foto;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public List<Reservatie> getReservaties() {
        return reservaties;
    }
    
    public void setReservaties(List<Reservatie> reservaties) {
        this.reservaties = reservaties;
    }
    
}
