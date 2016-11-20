/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import bean.Count;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import service.CountFacade;

/**
 *
 * @author mehdi
 */
@ManagedBean
@SessionScoped
public class CountController {

    /**
     * Creates a new instance of CountController
     */
    
    List<Count> counts = new ArrayList<>();
    Count current = new Count();
    @EJB
    private CountFacade countFacade;
    
    private Count copier(){
        Count count = new Count();
        count.setDate(this.current.getDate());
        count.setLangue(this.current.getLangue());
        count.setTitre(this.current.getTitre());
        return count;
    }
    public void create(){
        Count count = copier();
        countFacade.create(count);
        counts.add(count);
    }
    public Count findById(){
        return countFacade.find(current);    
    }
    public void remove(Count count){
        counts.remove(count);
        countFacade.remove(count);
    }
    public String diff(Count count){
       return countFacade.diff(count);
        }
       

    
    public List<Count> getCounts() {
        return counts;
    }

    public void setCounts(List<Count> counts) {
        this.counts = counts;
    }

    public Count getCurrent() {
        return current;
    }

    public void setCurrent(Count current) {
        this.current = current;
    }

    public CountFacade getCountFacade() {
        return countFacade;
    }

    public void setCountFacade(CountFacade countFacade) {
        this.countFacade = countFacade;
    }
    
    
    public CountController() {
    }
    
}
