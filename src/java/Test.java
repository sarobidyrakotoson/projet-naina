
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import modele.Connexion;
import modele.Contenu;
import modele.DBTable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aroniaina Saotra
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        Contenu c = new Contenu();
        List l = c.recherche("2022-1-21", "2022-3-1", "reunion");
        for(int i = 0;i<l.size();i++){
            c = (Contenu) l.get(i);
            System.out.println(c.getTitre());
        }
    }
    
}
