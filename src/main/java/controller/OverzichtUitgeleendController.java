/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Datum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.Dao;

/**
 *
 * @author Maarten
 */
@Controller
public class OverzichtUitgeleendController
{
    @Autowired
    private Dao reservatieDao;
    
    @RequestMapping(value = "/overzichtUitgeleendeMaterialen", method = RequestMethod.GET)
    public String toonOverzichtUitgeleendeMaterialen(Model model)
    {
        model.addAttribute("reservaties", reservatieDao.findReservatieMetDatum(new Datum()));
        return "overzichtUitgeleendeMaterialen";
    }
}
