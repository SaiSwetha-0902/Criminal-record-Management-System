

/*
    objective: Implementing CRUD operations on Vehicles through DBMS
*/



package CriminalClass;


import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import HelpOperations.Help;


import ConnectionFactoryClass.ConnectionFactory;

public class CriminalDBMS implements CriminalDBMSMethods {


    // This method takes a Criminal object and adds it into the appropriate DBMS Table

    public void createCriminal(Criminal c ,  String TableName){

        Connection con = ConnectionFactory.giveNewConnection();
       
        String query = "insert into " + TableName + " values(?, ?, ?, ?, ?, ?, ?)";

        try(PreparedStatement stmt = con.prepareStatement(query)) {
        
            stmt.setString(1, c.getcriminal_name());
            stmt.setString(2, c.getcriminal_no());
            stmt.setString(3, c.getcriminal_dateofBirth());
            stmt.setString(4, c.getcriminal_dateofArrest());
            stmt.setString(5, c.gettype_crime());
            stmt.setString(6, c.getcriminal_gender());
            stmt.setString(7, c.getcriminal_address());


            int k = stmt.executeUpdate();

            System.out.println(k + " rows have been affected");
            con.close();

        } catch(Exception e) {
            e.getLocalizedMessage();
        }
}


      // This method takes the tablename and returns all the entries in the respective tablename in the form of a list

     public  List<Criminal> printCriminalContent(String TableName){

        Connection con = ConnectionFactory.giveNewConnection();
        String query = "select * from " + TableName;
        
        try(PreparedStatement stmt = con.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();
            List<Criminal> c = new ArrayList<Criminal>();
            while(rs.next()){
                Criminal stud = new Criminal(rs.getString("criminal_name"), rs.getString("criminal_no"), rs.getString("criminal_dateofBirth"), rs.getString("criminal_dateofArrest"), rs.getString("type_crime"), rs.getString("criminal_gender"),rs.getString("criminal_address"));

                c.add(stud);
            }
            con.close();
            return c;
        }catch(Exception e){
            e.getLocalizedMessage();
            return null;
        }
}

// This method returns the number of criminals in the specified table

     public int returnCount(String tableName){
         Connection con = ConnectionFactory.giveNewConnection();
         String query = "select count(*) from " + tableName;
         ResultSet rs;
         int c = 0;
         try(PreparedStatement stmt = con.prepareStatement(query)){
             rs = stmt.executeQuery(query);
             rs.next();
             c = rs.getInt(1);
             rs.close();
             con.close();
         }catch(Exception e){
             e.getLocalizedMessage();
         }
         return (c);
     }


// This method takes a set of criminalNumbers and deletes them from the appropriate vehicle DBMS table

public void deleteCriminal(Set<String>Criminal_no,String tableName){
    Connection con = ConnectionFactory.giveNewConnection();
    for(String string : Criminal_no){
        String query = "delete from " + tableName + " where criminal_no =  ?";
        try(PreparedStatement stmt = con.prepareStatement(query)){
            stmt.setString(1, string);
            stmt.executeUpdate();
        }
        catch(Exception e){
            e.getLocalizedMessage();
        }
    }
    }


    // This method deletes the criminal data  from DBMS Table purely on criminalnumber

    public void deleteCriminal(String Criminal_no,String tableName){

        Connection con = ConnectionFactory.giveNewConnection();
        String query = "delete from " + tableName + " where criminal_no =  " + "?";

        try(PreparedStatement stmt = con.prepareStatement(query)){
            stmt.setString(1,Criminal_no);
            stmt.executeUpdate();
            con.close();
        }catch(Exception e){
            e.getLocalizedMessage();
        }

    }

   // This method deletes the vehicle from appropriate vehicle DBMS table
   public void deleteCriminalFromAttribute(String Attribute, String data, String tableName){
    Connection con = ConnectionFactory.giveNewConnection();
    String query = "delete from " + tableName + " where " + Attribute + " =  ?" ;
    try(PreparedStatement stmt = con.prepareStatement(query)){
        stmt.setString(1, data);
        stmt.executeUpdate();
        con.close();
    }catch(Exception e){
        e.getLocalizedMessage();
    }
} 


// This method takes one attribute and returns list from it


public List<Criminal> sortCriminalbyAttribute(String attribute, String order, String tableName){


    List<Criminal>  c = new ArrayList<Criminal>();
    Connection con = ConnectionFactory.giveNewConnection();
    final String query = "select * from " + tableName + " order by " + attribute + " " + order;
    
    try(PreparedStatement st = con.prepareStatement(query)){
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            Criminal c1 = new Criminal(rs.getString("criminal_name"), rs.getString("criminal_no"), rs.getString("criminal_dateofBirth"), rs.getString("criminal_dateofArrest"), rs.getString("type_crime"), rs.getString("criminal_gender"),rs.getString("criminal_address"));
            c.add(c1);
        }
        con.close();
        return c;
    }

    catch(SQLException e){
        e.getLocalizedMessage();
    }

    return c;

}

// This method truncates the given table contents
    @Override
    public void truncateTable(String TableName) {
        Connection con = ConnectionFactory.giveNewConnection();
        String query = "truncate table " + TableName;
        try(PreparedStatement stmt = con.prepareStatement(query)){
            stmt.executeUpdate();
            System.out.println("Table " + TableName + " has been truncated");
            con.close();
        }catch(Exception e){
            e.getLocalizedMessage();
        } 
    }


        //This method searches the criminals and returns list based on attribute
    //search without order

    public List<Criminal> searchCriminalbyID(String attribute, String mode, String val, String tableName){
        List<Criminal>  c = new ArrayList<Criminal>();
        Connection con = ConnectionFactory.giveNewConnection();
        final String query;
        if(attribute.equals("criminal_no") || attribute.equals("criminal_name") || attribute.equals("criminal_dateofBirth") ||  attribute.equals("criminal_dateofArrest")){
            String temp;
            if(mode.equals("=")){
                temp = "'%" + val + "%'";
                val = temp;
                mode = "like"; 
            }
            else{
                temp = "'" + val + "'";
                val = temp;
            }
        }
        query = "select * from " + tableName + " where " + attribute + " " + mode + " " + val;
        try(PreparedStatement st = con.prepareStatement(query)){
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Criminal c1 = new Criminal(rs.getString("criminal_name"), rs.getString("criminal_no"), rs.getString("criminal_dateofBirth"), rs.getString("criminal_dateofArrest"), rs.getString("type_crime"), rs.getString("criminal_gender"),rs.getString("criminal_address"));
                c.add(c1);
            }
            con.close();
            return c;
        }
    
        catch(SQLException e){
            System.out.println("Cant search numeric value with a String");
            e.getLocalizedMessage();
        }
    
        return c;
    }



        // This method searches the vehicles and returns list based on attribute
    //search with order
    public List<Criminal> searchCriminalbyID(String attribute, String mode, String val, String order, String tableName){
        List<Criminal>  c = new ArrayList<Criminal>();
        Connection con = ConnectionFactory.giveNewConnection();
        final String query;
        if(attribute.equals("criminal_no") || attribute.equals("criminal_name") || attribute.equals("criminal_dateofBirth") || attribute.equals("criminal_dateofArrest")){
            String temp;
            if(mode.equals("=")){
                temp = "'%" + val + "%'";
                val = temp;
                mode = "like"; 
            }
            else{
                temp = "'" + val + "'";
                val = temp;
            }
        }
        query = "select * from " + tableName + " where " + attribute + " " + mode + " " + val + " order by " + attribute + " " + order;
        try(PreparedStatement st = con.prepareStatement(query)){
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Criminal c1 = new Criminal(rs.getString("criminal_name"), rs.getString("criminal_no"), rs.getString("criminal_dateofBirth"), rs.getString("criminal_dateofArrest"), rs.getString("type_crime"), rs.getString("criminal_gender"),rs.getString("criminal_address"));
                c.add(c1);
            }
            con.close();
            return c;
        }
    
        catch(SQLException e){
            System.out.println("Cant search numeric value with a String");
            e.getLocalizedMessage();
        }
    
        return c;
    }


   public void updateCriminal(String cri[], String tableName){

    Connection con = ConnectionFactory.giveNewConnection();
    String query = "update " + tableName + " set " + Help.inShort(cri[0])  + " = ?" +  " where " + Help.inShort(cri[3]) +  " = " + "?";
    try(PreparedStatement stmt = con.prepareStatement(query)){
        stmt.setString(1, cri[1]);
        stmt.setString(2, cri[4]);
       int k = stmt.executeUpdate();
       System.out.println(k + " rows have been updated");
        con.close();
    }catch(Exception e){
        e.getLocalizedMessage();
    }




    }



    



}


    




    

























    


