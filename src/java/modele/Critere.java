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
    String un;
    String deux;
    //String idtype;
   // String utilisateurid;
    String keyword;
    
    public String getKeyword(){
        return this.keyword;
    }
    public void setKeyword(String n){
        this.keyword = n;
    }
    
    public String getUn(){
        return this.un;
    }
    public void setUn(String d){
        this.un = d;
    }
    
    public String getDeux(){
        return this.deux;
    }
    
    public void setDeux(String d){
        this.deux = d;
    }
    /*
    public String getIdtype(){
        return this.idtype;
    }
    public void setIdtype(String n){
        this.idtype = n;
    }*/
}
