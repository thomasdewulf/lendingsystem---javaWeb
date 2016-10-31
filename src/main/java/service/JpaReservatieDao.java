/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Datum;
import domain.Reservatie;
import java.sql.Date;
import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Maarten
 */
@Repository("reservatieDao")
public class JpaReservatieDao extends DaoImpl implements Dao<Reservatie>
{
    
    @Override
    @Transactional(readOnly = true)
    public List<Reservatie> findAll()
    {
        //String sql = "select r from Reservatie r join r.";
//        String sql = "select r.ReservatieId, r.StartDatum, r.EindDatum, r.AanmaakDatum, r.ReservatieStatus, r.Discriminator,  a.Id, a.Discriminator, a.Email, a.Foto, a.GebruikersNummer, a.Naam, a.UserName, a.VerlanglijstId, a.Voornaam, l.ReservatieLijnId, l.Aantal, l.AantalTeruggebracht, p.ProductId, p.Foto, p.Artikelnaam, p.Omschrijving, p.Artikelnummer, p.Prijs, p.AantalInCatalogus, p.AantalProductStukken, p.Uitleenbaar, f.FirmaId, f.Naam, f.Website, f.ContactPersoon, f.EmailContactPersoon\n" +
//                     "from Reservatie r join AspNetUsers a on r.ApplicationUserId = a.Id join ReservatieLijn l on r.ReservatieId = l.ReservatieId join Product p on l.ProductId = p.ProductId join Firma f on p.FirmaId = f.FirmaId;";
        TypedQuery query = em.createQuery("select distinct r from Reservatie r join r.reservatieLijnen rl join rl.product p",Reservatie.class);
        return query.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reservatie> findReservatieMetDatum(Datum datum)
    {
        Date date = new Date(datum.getDatum().getTime());
        System.out.println(date);
        TypedQuery query = em.createQuery("select distinct r from Reservatie r join r.reservatieLijnen rl join rl.product p where r.startDatum <= :date and r.eindDatum >= :date",Reservatie.class).setParameter("date", date);
        return query.getResultList();
    }
    
}
