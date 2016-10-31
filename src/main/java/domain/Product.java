/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 *
 * @author Maarten
 */
@Entity
public class Product implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    @ManyToMany()
    @JoinTable(name = "ProductDoelgroeps", joinColumns = @JoinColumn(name = "DoelgroepId"), inverseJoinColumns = @JoinColumn(name = "ProductId"))
    private Set<Doelgroep> doelgroepen;
    @ManyToMany()
    @JoinTable(name = "ProductLeergebieds", joinColumns = @JoinColumn(name = "LeergebiedId"), inverseJoinColumns = @JoinColumn(name = "ProductId"))
    private Set<Leergebied> leergebieden;
    @OneToMany(mappedBy = "product")
    private Set<ReservatieLijn> reservatieLijnen;
    //private int firmaId;
    @OneToOne
    @JoinColumn(name = "FIRMAID")
    private Firma firma;
    private String foto;
    private String artikelnaam;
    private String omschrijving;
    private String artikelnummer;
    private double prijs;
    private int aantalInCatalogus;
    private int aantalProductStukken;
    private boolean uitleenbaar;
    @Transient
    private String plaats;
    
    public Product()
    {
    }

    public Product(Set<Doelgroep> doelgroepen, Set<Leergebied> leergebieden, Firma firma, String foto, String artikelNaam, String omschrijving, String artikelNummer, double prijs, int aantalInCatalogus, int aantalProductStukken, boolean uitleenbaar, String plaats)
    {
        this.doelgroepen = doelgroepen;
        this.leergebieden = leergebieden;
        this.firma = firma;
        this.foto = foto;
        this.artikelnaam = artikelNaam;
        this.omschrijving = omschrijving;
        this.artikelnummer = artikelNummer;
        this.prijs = prijs;
        this.aantalInCatalogus = aantalInCatalogus;
        this.aantalProductStukken = aantalProductStukken;
        this.uitleenbaar = uitleenbaar;
        this.plaats = plaats;
    }
    
    public int getProductId()
    {
        return productId;
    }

    public void setProductId(int productId)
    {
        this.productId = productId;
    }

    public String getArtikelnaam()
    {
        return artikelnaam;
    }

    public void setArtikelnaam(String artikelNaam)
    {
        this.artikelnaam = artikelNaam;
    }

    public String getArtikelNummer()
    {
        return artikelnummer;
    }

    public void setArtikelNummer(String artikelNummer)
    {
        this.artikelnummer = artikelNummer;
    }

    public Collection<Doelgroep> getDoelgroepen()
    {
        return doelgroepen;
    }

    public Collection<Leergebied> getLeergebieden()
    {
        return leergebieden;
    }

    public Firma getFirma()
    {
        return firma;
    }

    public String getFoto()
    {
        return foto;
    }

    public String getOmschrijving()
    {
        return omschrijving;
    }

    public double getPrijs()
    {
        return prijs;
    }

    public int getAantalInCatalogus()
    {
        return aantalInCatalogus;
    }

    public int getAantalProductStukken()
    {
        return aantalProductStukken;
    }

    public boolean isUitleenbaar()
    {
        return uitleenbaar;
    }

    public String getPlaats()
    {
        return plaats;
    }

    public void setDoelgroepen(Set<Doelgroep> doelgroepen)
    {
        this.doelgroepen = doelgroepen;
    }

    public void setLeergebieden(Set<Leergebied> leergebieden)
    {
        this.leergebieden = leergebieden;
    }

    public void setFoto(String foto)
    {
        this.foto = foto;
    }

    public void setOmschrijving(String omschrijving)
    {
        this.omschrijving = omschrijving;
    }

    public void setPrijs(double prijs)
    {
        this.prijs = prijs;
    }

    public void setAantalInCatalogus(int aantalInCatalogus)
    {
        this.aantalInCatalogus = aantalInCatalogus;
    }

    public void setAantalProductStukken(int aantalProductStukken)
    {
        this.aantalProductStukken = aantalProductStukken;
    }

    public void setUitleenbaar(boolean uitleenbaar)
    {
        this.uitleenbaar = uitleenbaar;
    }

    public void setPlaats(String plaats)
    {
        this.plaats = plaats;
    }

    public void setFirma(Firma firma)
    {
        this.firma = firma;
    }
    
    public boolean bevatDoelgroep(String doelgroep)
    {
        return this.doelgroepen.stream().map(Doelgroep::getNaam).map(String::toLowerCase).anyMatch(naam -> naam.contains(doelgroep.toLowerCase()));
    }

    public boolean bevatLeergebied(String leergebied)
    {
        return this.leergebieden.stream().map(Leergebied::getNaam).map(String::toLowerCase).anyMatch(naam -> naam.contains(leergebied));
    }

    public void setReservatieLijnen(Set<ReservatieLijn> reservatieLijnen) {
        this.reservatieLijnen = reservatieLijnen;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) productId;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product))
        {
            return false;
        }
        Product other = (Product) object;
        if (this.productId != other.productId)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "domain.Product[ id=" + productId + " ]";
    }
    
}
