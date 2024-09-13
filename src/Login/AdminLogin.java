package Login;


import java.util.*;

public class AdminLogin {
    public  static boolean login() 
    {
        int try1 = 0;
        
       
        while(try1<3){
        System.out.print ("\n\n\n\n\n\n");
        System.out.print("\t\t\t\t    ----------------------------------\n");
        System.out.print("\t\t\t\t    |POLICE STATION MANAGEMENT SYSTEM|\n");
        System.out.print("\t\t\t\t    ----------------------------------\n");
        System.out.print("\n\n");
        System.out.print ("\t\t\t\t\t");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username:"); //username:admin
        String username = scanner.nextLine();
        System.out.print("\t\t\t\t\n");
        System.out.print("\n\n");
        System.out.print ("\t\t\t\t\t");
    System.out.print("Enter password:");//password:password
       String password =scanner.nextLine();
        //scanner.close();
        if(username.equals("admin") && password.equals("password"))
        {
            System.out.print("\n\n");
            System.out.print("\t\t\t\t");
            System.out.print("You are accessed to the system!\n\n");
            System.out.print("\t\t\t\t");
            
            return true;
            
        }
    else{
        try1 = try1+1;
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print("\t\t\t\t\t");
        System.out.print("No. of attempts remain: ");
        System.out.print(3-try1);
        System.out.print("\n\n");
        System.out.print("\t\t\t\t");
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

}
