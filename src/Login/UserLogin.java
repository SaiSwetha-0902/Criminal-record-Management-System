package Login;

import java.sql.*;

import java.util.*;

public class UserLogin {

 public static boolean login() {

        String url = "jdbc:mysql://localhost:3306/OOPS_Project";
        String uname = "root";
        String pass = "GAGANRAM";
        Scanner sin = new Scanner(System.in);
        
        int n = 0;
        int try1=0;
        
        try {

        while(try1<3){
        	
        	 System.out.print("\t\t\t\t");
             System.out.print("Enter userid : ");
             String username = sin.nextLine();
             System.out.print("\t\t\t\t");
             System.out.print("Enter password : ");
             String password = sin.nextLine();
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con = DriverManager.getConnection(url,uname,pass);
             String query = "select *from login";
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query);
        while(rs.next()) {
            if (username.matches(rs.getString(1)) && password.matches(rs.getString(2))) {
                n =1;
            }
        }
        st.close();
        con.close();
        //sin.close();
        if(n==1){
        System.out.print("\n\n");
        System.out.print("\t\t\t\t");
        System.out.print("You are accessed to the system!\n\n");
        System.out.print("\t\t\t\t");
        return true;
        }

        else {
            try1 = try1+1;
    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    System.out.print("\t\t\t\t\t");
    System.out.print("No. of attempts remain: ");
    System.out.print(3-try1);
    System.out.print("\n\n");
    //System.out.print("\t\t\t\t");
    if(try1>=3)
    {

        System.out.print("\t\t\t\t\t\t");
        System.out.print("\n");
        System.out.print("\t\t\t\t");
        System.out.print("No permission to enter the system!\n\n");
        System.out.print("\t\t\t\t");
     callExit();
    }
}

}

  return false;
        }
        
        catch(Exception e) {
        	e.getLocalizedMessage();
        }
        
        return false;

}



    public static void callExit()
    {
        System.out.print("\n\n\n\n\n");
        System.out.print("\n\tTaking You Out of The System");
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print("\t\t\t\t\t");
        System.out.print("You are out of the System.\n");
        System.out.print("\t\t\t\t\t\t");
        System.out.print("Thank You !");
        System.out.print("\n\n");
        System.out.print("\t\t\t\t\t");
      System.exit(0);
    
    }



    public static void create() {

        String url = "jdbc:mysql://localhost:3306/OOPS_Project";
        String uname = "root";
        String pass = "GAGANRAM";
        Scanner sin = new Scanner(System.in);
        System.out.print("\t\t\t\t\t");
        System.out.print("Enter userid : ");
        String username = sin.nextLine();
        System.out.print("\t\t\t\t");
        System.out.print("Enter password : ");
        String password = sin.nextLine();
        
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        String query = "insert into login values(?,?)";
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1,username);
        st.setString(2,password);
         st.executeUpdate();
         System.out.print("\t\t\t\t");
       System.out.println("*******Account Created Successfully ********* ");
        st.close();
        con.close();
        // sin.close();
        }
        catch(Exception e) {
        	e.getLocalizedMessage()
;        }
    }
}
    

