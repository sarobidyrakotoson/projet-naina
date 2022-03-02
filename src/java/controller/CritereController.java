/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import modele.Contenu;
import modele.Critere;
import modele.ModeleView;
import modele.TypeContenu;

/**
 *
 * @author Aroniaina Saotra
 */
public class CritereController {
    Critere critere;
    
    public Critere getCritere(){
        return this.critere;
    }
    public void setCritere(Critere c){
        this.critere = c;
    }
    
    @Annotation(nameClass = "recherche")
    public ModeleView rechercher(HttpServletRequest hr) throws Exception {
        ModeleView m = new ModeleView();
        Contenu c = new Contenu();
        List li = c.recherche(this.getCritere().getUn(), this.getCritere().getDeux(), this.getCritere().getKeyword());
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
