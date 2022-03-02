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
import javax.servlet.http.HttpSession;
import modele.Contenu;
import modele.ModeleView;
import modele.TypeContenu;
import modele.Utilisateur;

/**
 *
 * @author Aroniaina Saotra
 */
public class UtilisateurController {

    Utilisateur utilisateur;

    public Utilisateur getUtilisateur() {
        return this.utilisateur;
    }

    public void setUtilisateur(Utilisateur u) {
        this.utilisateur = u;
    }

    @Annotation(nameClass = "login")
    public ModeleView login(HttpServletRequest hr) throws Exception {
        ModeleView m = new ModeleView();
        Utilisateur u = this.getUtilisateur().login();
        String page = "";
        if (u != null) {
            page = "/index2.jsp";
            m.setPage(page);
            HttpSession h = hr.getSession();
            Contenu c = new Contenu();
            List li = c.contenu();
            TypeContenu tc = new TypeContenu();
            List list = tc.typecontenu();
            List l = new ArrayList();
            l.add(li);l.add(list);
            HashMap<String, Object> hm = new HashMap<String, Object>();
            hm.put("liste", l);
            m.setHash(hm);
            h.setAttribute("utilisateur", u);
        } else {
            page = "/index.jsp";
            m.setPage(page);
        }
        return m;
    }
}
