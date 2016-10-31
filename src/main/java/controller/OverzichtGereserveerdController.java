/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Datum;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.Dao;

/**
 *
 * @author Maarten
 */
@Controller
public class OverzichtGereserveerdController
{
    @Autowired
    private Dao reservatieDao;
    
    @RequestMapping(value = "/overzichtGereserveerdeMaterialen/{datum}", method = RequestMethod.GET)
    public String toonOverzichtGereserveerdeMaterialen(@PathVariable("datum")String d ,Model model)
    {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try
        {
            date = format.parse(d);
        } catch (ParseException ex)
        {
            System.out.println("Kan de datum niet parsen");
            return "hello";
        }
        Datum datum = new Datum(date);
        System.out.println(datum);
        model.addAttribute("datum", datum);
        model.addAttribute("reservaties", reservatieDao.findReservatieMetDatum(datum));
        return "overzichtGereserveerdeMaterialen";
    } 
    
    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public String redirect(Model model)
    {
        return "redirect:/welcome.htm";
    }
}
