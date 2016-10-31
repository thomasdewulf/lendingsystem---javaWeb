/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Maarten
 */
@Entity
public class ReservatieLijn implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reservatieLijnId;
    private int aantal;
    @ManyToOne
    @JoinColumn(name = "ReservatieId")
    private Reservatie reservatie;

    @ManyToOne
    @JoinColumn(name = "ProductId")
    private Product product;
    private int aantalTeruggebracht;

    public int getReservatieLijnId()
    {
        return reservatieLijnId;
    }

    public void setId(int id)
    {
        this.reservatieLijnId = id;
    }

    public ReservatieLijn()
    {

    }

    public ReservatieLijn(int aantal, Product product, int aantalTeruggebracht)
    {
        this.aantal = aantal;
        this.product = product;
        this.aantalTeruggebracht = aantalTeruggebracht;
    }

    public void setReservatie(Reservatie reservatie)
    {
        this.reservatie = reservatie;
    }

    public int getAantal()
    {
        return aantal;
    }

    public void setAantal(int aantal)
    {
        this.aantal = aantal;
    }

    public Product getProduct()
    {
        return product;
    }

    public void setProduct(Product product)
    {
        this.product = product;
    }

    public int getAantalTeruggebracht()
    {
        return aantalTeruggebracht;
    }

    public void setAantalTeruggebracht(int aantalTeruggebracht)
    {
        this.aantalTeruggebracht = aantalTeruggebracht;
    }

    public  Reservatie getReservatie() {
        return reservatie;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += reservatieLijnId;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservatieLijn))
        {
            return false;
        }
        ReservatieLijn other = (ReservatieLijn) object;
        if (this.reservatieLijnId != other.reservatieLijnId)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "domain.ReservatieLijn[ id=" + reservatieLijnId + " ]";
    }
    
}
