/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.Date;

/**
 *
 * @author Aroniaina Saotra
 */
public class Contenu {
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
}
