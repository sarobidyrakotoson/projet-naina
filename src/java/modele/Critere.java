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
public class Critere {
    Date un;
    Date deux;
    String idtype;
   // String utilisateurid;
    String keyword;
    
    public String getKeyword(){
        return this.keyword;
    }
    public void setKeyword(String n){
        this.keyword = n;
    }
    
    public Date getUn(){
        return this.un;
    }
    public void setUn(Date d){
        this.un = d;
    }
    
    public Date getDeux(){
        return this.deux;
    }
    
    public void setDeux(Date d){
        this.deux = d;
    }
    
    public String getIdtype(){
        return this.idtype;
    }
    public void setIdtype(String n){
        this.idtype = n;
    }
}
