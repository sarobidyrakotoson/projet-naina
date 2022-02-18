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
public class TypeContenu extends DBTable{
    String id;
    String nom;
    
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
    
    public TypeContenu(){}
    public TypeContenu(String id,String nom){
        this.setId(id);
        this.setNom(nom);
    }
    
    public List typecontenu() throws Exception{
        
        List l = new ArrayList();
        DBTable[] db = this.find(this, Connexion.getConnection());
        for(int i = 0;i<db.length;i++){
            l.add((TypeContenu)db[i]);
        }
        return l;
    }
    
    public void insertTypeContenu() throws Exception{
        this.insertInto(Connexion.getConnection());
    }
}
