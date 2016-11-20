/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import bean.Count;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mehdi
 */
@Stateless
public class CountFacade extends AbstractFacade<Count> {
    @PersistenceContext(unitName = "com.mehdi_projet_countdown_war_0.0.1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CountFacade() {
        super(Count.class);
    }
    public Date formateDate(String date) {
        String pattern = "dd/MM/yyyy HH:mm:ss";
        Date d1=null;
        try {
            d1 = new SimpleDateFormat(pattern).parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(CountFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d1;
    }
    public String diff(Count count){
//		String theDate = date.toString();
//                System.out.println(theDate);
//		String pattern = "dd/MM/yyyy HH:mm:ss";
//		Date d2 = null;
//		try {
//			d2 = new SimpleDateFormat(pattern).parse(theDate);
//		} catch (ParseException e) {
//			return "server error...";
//		}
		Date d1 = new Date();

		long diff = count.getDate().getTime() - d1.getTime();

		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000);
		return "Il vous reste : "+diffDays+" jour(s) "+diffHours+" heure(s) "+diffMinutes+" minute(s) "+diffSeconds+" seconde(s)";

	}
    
}
