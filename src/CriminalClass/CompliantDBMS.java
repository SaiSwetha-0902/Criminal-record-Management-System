package CriminalClass;


import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;


// import HelpOperations.Help;


import ConnectionFactoryClass.ConnectionFactory;



public class CompliantDBMS {


     // This method takes a Complaint object and adds it into the appropriate DBMS Table

     public static void createComplaint(Complaint c ,  String TableName){

        Connection con = ConnectionFactory.giveNewConnection();
       
        String query = "insert into " + TableName + " values(?, ?, ?, ?, ?, ?, ?,?)";

        try(PreparedStatement stmt = con.prepareStatement(query)) {
        
            stmt.setString(1, c.getName());
            stmt.setString(2, c.getgender());
            stmt.setString(3, c.getDateOfBirth());
            stmt.setString(4, c.getphone_no());
            stmt.setString(5, c.getSubject());
            stmt.setString(6, c.getplace_Of_Occurence());
            stmt.setString(7, c.getDescription());
            stmt.setString(8, c.getstatus());


            int k = stmt.executeUpdate();

            System.out.println(k + " rows have been affected");
            con.close();

        } catch(Exception e) {
            e.getLocalizedMessage();
        }
}


    // This method searches the Criminals and returns list based on attribute
    //search with order
    public  static void searchComplaintbyID(String attribute, String mode, String val, String order, String tableName){
        List<Complaint>  c = new ArrayList<Complaint>();
        Connection con = ConnectionFactory.giveNewConnection();
        final String query;
        if(attribute.equals("Name")  || attribute.equals("Subject") || attribute.equals("phone_no") || attribute.equals("place_OfOccurence") ){
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
                Complaint c1 = new Complaint(rs.getString("Name"), rs.getString("gender"), rs.getString("DateOfBirth"), rs.getString("phone_no"), rs.getString("Subject"), rs.getString("place_Of_Occurence"),rs.getString("Description"));
                c.add(c1);
            }
            con.close();
            Complaint.print_eff(c);
            
        }
    
        catch(SQLException e){
            System.out.println("Cant search numeric value with a String");
            e.getLocalizedMessage();
        }
    
         // Complaint.print_eff(c);
    }


    // This method returns the number of complaints in the specified table

    public static  int returnCount(String tableName){
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


    public static void UpdateStatus(String tableName,String val){

        Connection con = ConnectionFactory.giveNewConnection();

         String query= "update "  + tableName +  "set status " + "= ? "  +   "where Name "+ "= ?" ;
        
        String s = "SOLVED";

        
        
        


        try(PreparedStatement stmt = con.prepareStatement(query)) {
        	
        	stmt.setString(1, s);
        	stmt.setString(2,val);
        
           
        int k = stmt.executeUpdate();
      
            System.out.println(k + " rows have been affected");
            con.close();

        } catch(Exception e) {
            e.getLocalizedMessage();
        }
 }

    
}
