/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Maarten
 */
public class Datum
{
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date datum;

    public Datum()
    {
        this.datum = new Date();
    }
    
    public Datum(Date datum)
    {
        this.datum = datum;
    }

    public Date getDatum()
    {
        return datum;
    }
    
    public void setDatum(Date datum)
    {
        this.datum = datum;
    }
    
    @Override
    public String toString()
    {
        if(datum == null)
            return "";
        return datum.getDate() + "-" + (datum.getMonth()+1) + "-" + (datum.getYear()+1900);
    }
}
