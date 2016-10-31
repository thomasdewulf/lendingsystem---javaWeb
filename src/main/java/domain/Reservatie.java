/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 *
 * @author Maarten
 */
@Entity
public class Reservatie implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reservatieId;
    private Date startDatum;
    private Date eindDatum;
    private Date aanmaakDatum;
    @Enumerated(EnumType.STRING)
    private ReservatieStatus reservatieStatus;
    private String discriminator;
    @ManyToOne()
    @JoinColumn(name = "ApplicationUserId")
    private AspNetUsers user;
    @OneToMany(mappedBy = "reservatie", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<ReservatieLijn> reservatieLijnen;
    @Transient
    private List<ReservatieLijn> lijnenLijst;
    
    public Reservatie(){}
    
    public Reservatie(Date startDatum, Date eindDatum, Date aanmaakDatum, ReservatieStatus reservatieStatus, String discriminator,
            Set<ReservatieLijn> reservatieLijnen, AspNetUsers user)
    {
        this.startDatum = startDatum;
        this.eindDatum = eindDatum;
        this.aanmaakDatum = aanmaakDatum;
        this.discriminator = discriminator;
        this.user = user;
        this.reservatieLijnen = reservatieLijnen;
        this.reservatieStatus = reservatieStatus;
        this.lijnenLijst = new ArrayList<>(reservatieLijnen);
    }

    public int getReservatieId()
    {
        return reservatieId;
    }

    public void setReservatieId(int reservatieId)
    {
        this.reservatieId = reservatieId;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash = reservatieId;
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Reservatie other = (Reservatie) obj;
        if (this.reservatieId != other.reservatieId)
        {
            return false;
        }
        return true;
    }

    public Date getStartDatum()
    {
        return startDatum;
    }

    public void setStartDatum(Date startDatum)
    {
        this.startDatum = startDatum;
    }

    public Date getEindDatum()
    {
        return eindDatum;
    }

    public void setEindDatum(Date eindDatum)
    {
        this.eindDatum = eindDatum;
    }

    public Date getAanmaakDatum()
    {
        return aanmaakDatum;
    }

    public void setAanmaakDatum(Date aanmaakDatum)
    {
        this.aanmaakDatum = aanmaakDatum;
    }

    public AspNetUsers getUser()
    {
        return user;
    }

    public void setUser(AspNetUsers user)
    {
        this.user = user;
    }

    public Collection<ReservatieLijn> getReservatieLijnen()
    {
        return reservatieLijnen;
    }

    public String getDiscriminator() {
        return discriminator;
    }

    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }
    

    public void setReservatieLijnen(Set<ReservatieLijn> reservatieLijnen)
    {
        this.reservatieLijnen = reservatieLijnen;
    }

    public ReservatieStatus getReservatieStatus()
    {
        return reservatieStatus;
    }

    @Override
    public String toString()
    {
        return "Reservatie{" + "startDatum=" + startDatum + ", eindDatum=" + eindDatum + ", aanmaakDatum=" + aanmaakDatum + '}';
    }

    public List<Product> geefAlleProductenPerReservatie()
    {
        List<Product> producten = new ArrayList<>();
        reservatieLijnen.stream().forEach((lijn)
                ->
                {
                    producten.add(lijn.getProduct());
        });

        return producten;
    }

    public ReservatieLijn getLijn(int index)
    {
        return lijnenLijst.get(index);
    }
    
}
