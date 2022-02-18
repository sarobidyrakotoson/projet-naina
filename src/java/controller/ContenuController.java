/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import annotation.Annotation;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import modele.Connexion;
import modele.Contenu;
import modele.ModeleView;

/**
 *
 * @author Aroniaina Saotra
 */
public class ContenuController {
    Contenu contenu;
    
    public Contenu getContenu(){
        return this.contenu;
    }
    
    public void setContenu(Contenu c){
        this.contenu = c;
    }
    @Annotation(nameClass = "listeContenu")
    public ModeleView liste(HttpServletRequest hr) throws Exception{
        ModeleView m = new ModeleView();
        Contenu c = new Contenu(); 
        String page = "index2.jsp";
        List l = c.contenu();
        HashMap<String, Object> h = new HashMap<String, Object>();
        h.put("liste", l);
        m.setPage(page);
        m.setHash(h);
        return m;
    }
    
    @Annotation(nameClass = "insertContenu")
    public ModeleView insert(HttpServletRequest hr) throws Exception{
        ModeleView m = new ModeleView();
        Contenu c = new Contenu();
        List l = c.contenu();
        HashMap<String, Object> h = new HashMap<String, Object>();
        h.put("liste", l);
        Date d = Date.valueOf(LocalDate.now());///idddd
        this.getContenu().setDatecontenu(d);
        this.getContenu().setId(c.id(Connexion.getConnection()));
        c = this.getContenu();
        c.insertContenu();
        System.out.println(this.getContenu().getDescription());
        System.out.println(this.getContenu().getFichier());
        System.out.println(this.getContenu().getTitre());
        System.out.println(this.getContenu().getTypecontenuid());
        String page = "index2.jsp";
        m.setPage(page);
        m.setHash(h);
        return m;
    }
}
