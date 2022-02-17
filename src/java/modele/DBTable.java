package modele;

import java.sql.*;
import java.lang.reflect.*;
import java.util.Vector;
import java.time.LocalDateTime;

public class DBTable
{

    public String[] getFieldsName()
    {
        Field[] listeAttribut=getClass().getDeclaredFields();
        String[] retour=new String[listeAttribut.length];
        for(int i=0;i<listeAttribut.length;i++)
        {
            retour[i]=listeAttribut[i].getName();
        }
        return retour;
    }
    public Method getFonction(String nom)
    {
        Method[] listeF=getClass().getDeclaredMethods();
        Method m=listeF[0];
        for(int i=0;i<listeF.length;i++)
        {
            if(listeF[i].getName().equalsIgnoreCase("get"+nom))
            {
                m=listeF[i];
            }
        }
        return m;
    }
    public String[] getAttributTsyNull()throws Exception
    {
        int isa=0;
        String[] att=getFieldsName();
        for(int i=0;i<att.length;i++)
        {
            Object o=getFonction(att[i]).invoke(this);
            if(o!=null){
                isa++;
                }
        }
        String[] retour=new String[isa];
        isa=0;
        for(int i=0;i<att.length;i++)
        {
            Object o=getFonction(att[i]).invoke(this);
            if(o!=null)
            {
                retour[isa]=att[i];
                isa++;
            }
        }
        return retour;
    }
    public Method getFonctionSet(String nom)
    {
        Method[] listeF=getClass().getMethods();
        Method m=listeF[0];
        for(int i=0;i<listeF.length;i++)
        {
            if(listeF[i].getName().equalsIgnoreCase("set"+nom))
            {
                m=listeF[i];
            }
        }
        return m;
    }
    public String getRequeteInsert(String nom,String[] att)throws Exception
    {
        String req="INSERT INTO "+nom+"(";
        for(int i=0;i<att.length-1;i++)
        {
            req=req+att[i]+",";
        }
        req=req+att[att.length-1]+") VALUES(";
        for(int i=0;i<att.length-1;i++)
        {
            Object valeur=getFonction(att[i]).invoke(this);
            if(valeur.getClass().isPrimitive()==false && valeur.getClass().getSuperclass().getSimpleName().equals("Number"))
            {
                req=req+""+String.valueOf(getFonction(att[i]).invoke(this))+",";
            }
            else{
                req=req+"'"+String.valueOf(getFonction(att[i]).invoke(this))+"',";
            }  
        }
        req=req+"'"+String.valueOf(getFonction(att[att.length-1]).invoke(this))+"')";
        System.out.println(req);
        return req;
    }
    public void insertInto(Connection con)throws Exception
    {

        String nomTable=this.getClass().getSimpleName();
        //String[] listeAttribut=getFieldsName();
        String[] listeAttribut=this.getAttributTsyNull();
        try{
            String req=getRequeteInsert(nomTable,listeAttribut);
            java.sql.Statement stmt = con.createStatement();
            stmt.executeUpdate(req);
            stmt.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public boolean misyVe(Object valeur)throws Exception
    {
        String[] listeAtt=getFieldsName();
        for(int i=0;i<listeAtt.length;i++)
        {
            Object v1=getFonction(listeAtt[i]).invoke(this);
            if(v1.equals(valeur))
            {
                return true;
            }
        }
        return false;
    }
    public String getNomColonne(Object valeur)throws Exception
    {
        String[] listeAtt=getFieldsName();
        for(int i=0;i<listeAtt.length;i++)
        {
            Object v1=getFonction(listeAtt[i]).invoke(this);
            if(v1.equals(valeur))
            {
                return listeAtt[i];
            }
        }
        return "";
    }
    public String getRequeteUpdate(String nom,Object avant,Object apres,String[] att)throws Exception
    {
        String nomCol=getNomColonne(avant);
        String req="UPDATE "+nom+" SET "+nomCol+"='"+String.valueOf(apres)+"' ";
        return req+getWHERE(nom,att);
    }
    public void update2(Object avant,Object apres,Connection con)throws Exception
    {
        if(misyVe(avant))
        {
            String nom=getClass().getSimpleName();
            String req=getRequeteUpdate(nom,avant,apres,getFieldsName());
            try{
                java.sql.Statement stmt=con.createStatement();
                stmt.executeUpdate(req);
                Method setter=getFonctionSet(nom);
                setter.invoke(this,avant);
                stmt.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }  
    }
    public void update(Connection con)throws Exception
    {
        String[] listeAtt=getFieldsName();
        String req="UPDATE "+getClass().getSimpleName()+" SET ";
        for(int i=0;i<listeAtt.length-1;i++)
        {
            Object valeur=getFonction(listeAtt[i]).invoke(this);
            if(valeur.getClass().isPrimitive()==false && valeur.getClass().getSuperclass().getSimpleName().equals("Number"))
            {
                req=req+listeAtt[i]+"="+String.valueOf(getFonction(listeAtt[i]).invoke(this))+",";
            }
            else{
                req=req+listeAtt[i]+"='"+String.valueOf(getFonction(listeAtt[i]).invoke(this))+"',";
            }
        }
        Object valeur=getFonction(listeAtt[listeAtt.length-1]).invoke(this);
        if(valeur.getClass().isPrimitive()==false && valeur.getClass().getSuperclass().getSimpleName().equals("Number"))
        {
            req=req+listeAtt[listeAtt.length-1]+"="+String.valueOf(getFonction(listeAtt[listeAtt.length-1]).invoke(this))+" ";
        }
        else{
            req=req+listeAtt[listeAtt.length-1]+"='"+String.valueOf(getFonction(listeAtt[listeAtt.length-1]).invoke(this))+"' ";
        }
        //req=req+"WHERE id"+getClass().getSimpleName()+"='"+String.valueOf(getFonction("id"+getClass().getSimpleName()).invoke(this))+"'";
        req=req+"WHERE id='"+String.valueOf(getFonction("id"+getClass().getSimpleName()).invoke(this))+"'";
        System.out.println(req);
        try
        {
            java.sql.Statement stmt=con.createStatement();
            stmt.executeUpdate(req);
            stmt.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public DBTable[] find(DBTable objet,Connection con)throws Exception
    {
        String[] listeAttTsyNull=objet.getAttributTsyNull();
        String[] listeAtt=objet.getFieldsName();
        String where=getWHERE(objet.getClass().getSimpleName(),listeAttTsyNull);
        String req="SELECT * FROM "+objet.getClass().getSimpleName()+" "+where;
        int taille=0;
        Vector liste=new Vector();
        System.out.println(req);
        try{
            java.sql.Statement stmt=con.createStatement();
            ResultSet res=stmt.executeQuery(req);
            while(res.next())
            {
                Object table;
                Object[] args=new Object[listeAtt.length];
                for(int i=0;i<args.length;i++)
                {
                    args[i]=res.getObject(i+1);
                }
                Constructor[] c=objet.getClass().getConstructors();
                for(int i=0;i<c.length;i++)
                {
                    if(c[i].getParameterCount()==listeAtt.length)
                    {
                        table=c[i].newInstance(args);
                        liste.addElement(table);
                        break;
                    }
                }
                taille++;
            }
            stmt.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        DBTable[] retour=new DBTable[taille];
        for(int i=0;i<taille;i++)
        {
            retour[i]=(DBTable)liste.get(i);
        }
        return retour;
    }
    public DBTable[] findAvecFinal(DBTable objet,String reqFinal,Connection con)throws Exception
    {
        String[] listeAttTsyNull=objet.getAttributTsyNull();
        String[] listeAtt=objet.getFieldsName();
        String where=getWHERE(objet.getClass().getSimpleName(),listeAttTsyNull);
        String req="SELECT * FROM "+objet.getClass().getSimpleName()+" "+where+reqFinal;
        System.out.println(req);
        int taille=0;
        Vector liste=new Vector();
        try{
            java.sql.Statement stmt=con.createStatement();
            ResultSet res=stmt.executeQuery(req);
            while(res.next())
            {
                Object table;
                Object[] args=new Object[listeAtt.length];
                for(int i=0;i<args.length;i++)
                {
                    args[i]=res.getObject(i+1);
                }
                Constructor[] c=objet.getClass().getConstructors();
                for(int i=0;i<c.length;i++)
                {
                    if(c[i].getParameterCount()==listeAtt.length)
                    {
                        table=c[i].newInstance(args);
                        liste.addElement(table);
                        break;
                    }
                }
                taille++;
            }
            stmt.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        DBTable[] retour=new DBTable[taille];
        for(int i=0;i<taille;i++)
        {
            retour[i]=(DBTable)liste.get(i);
        }
        return retour;
    }
    
    public String getTableNameFromRequest(String req)
    {
        String[] s=req.split(" ");
        String retour="";
        for(int i=0;i<s.length-1;i++)
        {
            if(s[i].equalsIgnoreCase("FROM"))
            {
                retour=s[i+1];
            }
        }
        return retour;
    }
    public Constructor getClassConstructor(Class c)
    {
        Constructor[] liste=c.getConstructors();
        Field[] listeAtt=c.getDeclaredFields();
        for(int i=0;i<liste.length;i++)
        {
            if(liste[i].getParameterCount()==listeAtt.length)
            {
                return liste[i];
            }
        }
        return liste[0];
    }
    public DBTable[] find2(String req,Connection con)
    {
        String nomTable=getTableNameFromRequest(req);
        String nomPackage=getClass().getPackage().getName();
        Vector liste=new Vector();
        int taille=0;
        try
        {
            Class classe=Class.forName(nomPackage+"."+nomTable);
            Field[] listeAtt=classe.getDeclaredFields();
            java.sql.Statement stmt=con.createStatement();
            ResultSet res=stmt.executeQuery(req);
            while(res.next())
            {
                Object[] args=new Object[listeAtt.length];
                for(int i=0;i<listeAtt.length;i++)
                {
                    args[i]=res.getObject(i+1);
                }
                Constructor c=getClassConstructor(classe);
                Object table=c.newInstance(args);
                liste.addElement(table);
                taille++;
            }
            stmt.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        DBTable[] retour=new DBTable[taille];
        for(int i=0;i<taille;i++)
        {
            retour[i]=(DBTable)liste.get(i);
        }
        return retour;
    }
    public String getWHERE(String nom,String[] att)throws Exception
    {
        if(att.length==0)
        {
            return "";
        }
        String req="WHERE ";
        if(att.length>1)
        {
            for(int i=0;i<att.length-1;i++)
            {
                req=req+att[i]+"='"+String.valueOf(getFonction(att[i]).invoke(this))+"' and ";
            }
        }
        req=req+att[att.length-1]+"='"+String.valueOf(getFonction(att[att.length-1]).invoke(this))+"'";
        return req;
    }
    public String getRequeteDelete(String nom,String[] att)throws Exception
    {
        String req="DELETE FROM "+nom+" "+getWHERE(nom,att);
        return req;
    }
    public void delete(Connection con)throws Exception
    {
        String nom=getClass().getSimpleName();
        try{
            String[] listeAttTsyNull=this.getAttributTsyNull();
            String req=getRequeteDelete(nom,listeAttTsyNull);
            System.out.println(req);
            java.sql.Statement stmt=con.createStatement();
            stmt.executeUpdate(req);
            stmt.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}