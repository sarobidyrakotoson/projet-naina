/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aroniaina Saotra
 */
public class Contenu extends DBTable{
    String id;
    String typecontenuid;
    String titre;
    String description;
    String fichier;
    Date datecontenu;
    
    public String getId(){
        return this.id;
    }
    public void setId(String n){
        this.id = n;
    }
    
    public String getTypecontenuid(){
        return this.typecontenuid;
    }
    public void setTypecontenuid(String n){
        this.typecontenuid = n;
    }
    
    public String getTitre(){
        return this.titre;
    }
    public void setTitre(String n){
        this.titre = n;
    }
    
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String n){
        this.description = n;
    }
    
    public String getFichier(){
        return this.fichier;
    }
    public void setFichier(String n){
        this.fichier = n;
    }
    public Date getDatecontenu(){
        return this.datecontenu;
    }
    public void setDatecontenu(Date n){
        this.datecontenu = n;
    }
    
    public Contenu(){}
    public Contenu(String id,String type,String titre,String desc,String fich,Date d){
        this.setId(id);
        this.setTypecontenuid(type);
        this.setTitre(titre);
        this.setDescription(desc);
        this.setFichier(fich);
        this.setDatecontenu(d);
    }
    
    public List contenu() throws Exception{
        List l = new ArrayList();
        DBTable[] db = this.find(this, Connexion.getConnection());
        for(int i = 0;i<db.length;i++){
            l.add((Contenu)db[i]);
        }
        return l;
    }
    
    
    public void insertContenu() throws Exception{
        this.insertInto(Connexion.getConnection());
    }
    
    
    public List recherche(Date un,Date deux,String keyword) throws Exception{
        List l = new ArrayList();
        DBTable[] db = this.findAvecFinal(this, " where titre like '%"+keyword+"%' or description like '%"+keyword+"%' and datecontenu between '"+un+"' and '"+deux+"'", Connexion.getConnection());
        for(int i = 0;i<db.length;i++){
            l.add((Contenu)db[i]);
        }
        return l;
    }
}
