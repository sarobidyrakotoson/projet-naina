/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aroniaina Saotra
 */
public class Utilisateur extends DBTable{
    String id;
    String nom;
    String email;
    String mdp;
    Integer isResponsable;
    
    public String getId(){
        return this.id;
    }
    public void setId(String n){
        this.id = n;
    }
    
    public String getNom(){
        return this.nom;
    }
    public void setNom(String n){
        this.nom = n;
    }
    
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String n){
        this.email = n;
    }
    
    public String getMdp(){
        return this.mdp;
    }
    public void setMdp(String n){
        this.mdp = n;
    }
    
    public Integer getIsResponsable(){
        return this.isResponsable;
    }
    public void setIsResponsable(Integer n){
        this.isResponsable = n;
    }
    
    public Utilisateur(){}
    public Utilisateur(String id,String nom,String email,String mdp,Object is){
        this.setId(id);
        this.setNom(nom);
        this.setEmail(email);
        this.setMdp(mdp);
        this.setIsResponsable(Integer.valueOf(String.valueOf(is)));
    }
    
    public List responsable() throws Exception{
        
        List l = new ArrayList();
        this.setIsResponsable(1);
        DBTable[] db = this.find(this, Connexion.getConnection());
        for(int i = 0;i<db.length;i++){
            l.add((Utilisateur)db[i]);
        }
        return l;
    }
    
    
     public List employe() throws Exception{
        
        List l = new ArrayList();
        this.setIsResponsable(0);
        DBTable[] db = this.find(this, Connexion.getConnection());
        for(int i = 0;i<db.length;i++){
            l.add((Utilisateur)db[i]);
        }
        return l;
    }       
     
     public Utilisateur login() throws Exception{
         DBTable[] db = this.find(this, Connexion.getConnection());
         if(db.length == 0) return null;
         return (Utilisateur)db  [0];
     }
}
