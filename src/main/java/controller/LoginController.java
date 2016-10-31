package controller;

import domain.Datum;
import java.time.Instant;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.Dao;

@Controller
public class LoginController
{

    @Autowired
    private Dao beheerderDao;
    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String printWelcome(Model model)
    {
        model.addAttribute("datum", new Datum());
        return "hello";
    }

    @RequestMapping(value = "/login")
    public String login(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout, Model model)
    {
        System.out.println("LOGIN GET");
        if (error != null)
        {
            model.addAttribute("error", "Incorrecte gebruikersnaam en wachtwoord!");
        }
        if (logout != null)
        {
            model.addAttribute("msg", "Je bent succesvol uitgelogd.");
        }
        return "login";
    }
    
    @RequestMapping(value = "/overzichtUitgeleend", method = RequestMethod.POST)
    public String overzichtUitgeleendeMaterialen(Model model)
    {
        return "redirect:/overzichtUitgeleendeMaterialen.htm";
    }
    
    @RequestMapping(value = "/overzichtGereserveerd/{datum}", method = RequestMethod.POST)
    public String overzichtGereserveerdeMaterialen(@Valid Datum datum, BindingResult result, Model model)
    {
        System.out.println(datum);
        if(result.hasErrors())
            return "hello";
        Date vandaag = new Date();
        if(!datum.getDatum().after(vandaag))
        {
            model.addAttribute("error", "De datum moet in de toekomst liggen");
            return "hello";
        }
        model.addAttribute("datum", datum);
        return "redirect:/overzichtGereserveerdeMaterialen/"+ datum +".htm";
    }
}
