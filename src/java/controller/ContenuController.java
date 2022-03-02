/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import annotation.Annotation;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import modele.Connexion;
import modele.Contenu;
import modele.ModeleView;
import modele.TypeContenu;

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
        List li = c.contenu();
        TypeContenu tc = new TypeContenu();
        List list = tc.typecontenu();
        List l = new ArrayList();
        l.add(li);
        l.add(list);
        HashMap<String, Object> hm = new HashMap<String, Object>();
        hm.put("liste", l);
       
        String page = "/index2.jsp";
        m.setPage(page);
        m.setHash(hm);
        return m;
    }
    
    @Annotation(nameClass = "insertContenu")
    public ModeleView insert(HttpServletRequest hr) throws Exception{
        ModeleView m = new ModeleView();
        Contenu c = new Contenu();
        Date d = Date.valueOf(LocalDate.now());
        this.getContenu().setDatecontenu(d);
        this.getContenu().setId(c.id(Connexion.getConnection()));
        System.out.println(this.getContenu().getId());
        this.getContenu().insertContenu();
        List li = c.contenu();
        TypeContenu tc = new TypeContenu();
        List list = tc.typecontenu();
        List l = new ArrayList();
        l.add(li);
        l.add(list);
        HashMap<String, Object> hm = new HashMap<String, Object>();
        hm.put("liste", l);
        String page = "/index2.jsp";
        m.setPage(page);
        m.setHash(hm);
        return m;
    }
    
    @Annotation(nameClass="listeC")
    public ModeleView listec(HttpServletRequest hr) throws Exception{
        ModeleView m = new ModeleView();
        List li = this.getContenu().contenu();
        TypeContenu tc = new TypeContenu();
        List list = tc.typecontenu();
        List l = new ArrayList();
        l.add(li);
        l.add(list);
        HashMap<String, Object> hm = new HashMap<String, Object>();
        hm.put("liste", l);
        String page = "/index2.jsp";
        m.setPage(page);
        m.setHash(hm);
        return m;
    }
    
    @Annotation(nameClass="listeAll")
    public ModeleView listeAll(HttpServletRequest hr) throws Exception{
        ModeleView m = new ModeleView();
        Contenu c= new Contenu();
        List li = c.contenu();
        TypeContenu tc = new TypeContenu();
        List list = tc.typecontenu();
        List l = new ArrayList();
        l.add(li);
        l.add(list);
        HashMap<String, Object> hm = new HashMap<String, Object>();
        hm.put("liste", l);
        String page = "/index2.jsp";
        m.setPage(page);
        m.setHash(hm);
        return m;
    }
}
