/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Datum;
import java.util.List;

/**
 *
 * @author Maarten
 */
public interface Dao<T>
{
    public List<T> findAll();
    public List<T> findReservatieMetDatum(Datum datum);
}
