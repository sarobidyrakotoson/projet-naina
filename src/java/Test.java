
import java.util.List;
import modele.Contenu;

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
        List l = c.contenu();
        for(int i = 0;i<l.size();i++){
            c = (Contenu) l.get(i);
            System.out.println(c.getTitre());
        }
    }
    
}
