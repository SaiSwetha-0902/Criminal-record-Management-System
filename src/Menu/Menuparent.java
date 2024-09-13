
/*
    Objective: This is the MENU Program from which you will operate. Main method calls this and direct accordingly
*/

package Menu;

import java.util.*;

import Operations.CreateCriminal;
import Operations.DeleteCriminalFromDatabase;
import Operations.DeleteAllMain;
import Operations.Listofcriminals;
import Operations.SearchCriminalinDatabase;
import Operations.SortCriminals;
import Operations.UpdateCriminal;
import Login.UserLogin;
import Login.AdminLogin;


import CriminalClass.*;


public class Menuparent {

	
	public void User_Menu(){
		
		int input;
		try {
		while(true) {
		System.out.print("\n\n\n");
	      System.out.print("\t\t\t\t\t");
	      System.out.print( "\n");
	      System.out.print("\t\t\t\t    ----------------------------------\n");
	      System.out.print("\t\t\t\t    |POLICE STATION MANAGEMENT SYSTEM|\n");
	      System.out.print( "\t\t\t\t    ----------------------------------\n");
	      System.out.print("\n\n\n\n");
	      System.out.print("\t\t\t\t");
	      System.out.print(" 1. Register CASE \n\n");
	      System.out.print("\t\t\t\t");
	      System.out.print(" 2. CHECK CASE STATUS \n\n");
	      System.out.print("\t\t\t\t");
	      System.out.print(" 3. SEARCH ARRESTED CRIMINAL(BASED ON DATE) \n\n");
	      System.out.print("\t\t\t\t" );
	      System.out.print( " 4. Go Back\n\n" );
	      System.out.print("\t\t\t\t") ;
	      System.out.print("Choose Option:[1/2/3/4] : " );
	      Scanner scanner = new Scanner(System.in);
	      
	      input=scanner.nextInt();
	      
	      switch(input) {
	      
	      case 1 :{

          Complaint c = new Complaint();
          c.setName();
          c.setgender();
          c.setDateOfBirth();
          c.setphoneno();
          c.setSubject();
          c.setplace_Of_Occurence();
          c.setDescription();

          CompliantDBMS.createComplaint(c,Complaint.gettablename());
          
          
	    	  break;
	      }
	      case 2 :{

          scanner.nextLine();
	    	  System.out.print("\t\t\t\t");
	    	  System.out.print("Enter ur phone_number to search :");
          String pn = scanner.nextLine();
	    	  // List<Complaint> ls = new ArrayList<Complaint>();
          CompliantDBMS.searchComplaintbyID("phone_no","=",pn,"DESC",Complaint.gettablename());

         
          
	    	  break;
	    	  
	      }
	      
	      case 3 : {
	    	  scanner.nextLine();
	    	  System.out.print("\t\t\t\t");
	    	  System.out.print("Enter info of attribute  u want to search :");
	    	  String info= scanner.nextLine();
	    	  System.out.print("\t\t\t\t");
	    	  System.out.print("Enter order(i or d) that  u want to search :");
	    	  String ord= scanner.nextLine();

	    	  String [] opt = {"cdoa","eq",info,ord};

	    	  SearchCriminalinDatabase.search(opt,Criminal.gettablename());
	      
	      }
	      
	      case 4 : {

	    	 Menu_Login();
	    	}


	    	default:
	    	      {
	    	        System.out.print( "\n\n\n" );
	    	        System.out.print("\t\t\t\t" );
	    	        System.out.print("  Invalid input!" );
	    	        System.out.print("\n\n" );
	    	        System.out.print("\t\t\t\t" );
	    	       User_Menu();
	    	        }
	    	  
	      
	      
	      
	      }
	      
	      
	      
		}
		}catch(Exception e) {
			 System.out.println("You had entered an wrong an input ....... pls try again.....");
			 User_Menu();
		}
	      
	      
	      
		
	}
     
    public void  admin_Menu(){

      Scanner scanner = new Scanner(System.in);

   try {
    int input;
    while(true)
    {
      
      System.out.print("\n\n\n");
      System.out.print("\t\t\t\t\t");
      System.out.print( "\n");
      System.out.print("\t\t\t\t    ----------------------------------\n");
      System.out.print("\t\t\t\t    |POLICE STATION MANAGEMENT SYSTEM|\n");
      System.out.print( "\t\t\t\t    ----------------------------------\n");
      System.out.print("\n\n\n\n");
      System.out.print("\t\t\t\t");
      System.out.print(" 1. ADD RECORD\n\n");
      System.out.print("\t\t\t\t");
      System.out.print(" 2. Delete RECORD\n\n");
      System.out.print("\t\t\t\t" );
      System.out.print( " 3. Search RECORD\n\n" );
      System.out.print("\t\t\t\t") ;
      System.out.print( " 4. Update RECORD\n\n") ;
      System.out.print("\t\t\t\t" );
      System.out.print(" 5. LIST ALL RECORDS\n\n") ;
      System.out.print("\t\t\t\t") ;
      System.out.print(" 6. SORT ALL RECORDS\n\n") ;
      
      System.out.print("\t\t\t\t" );
      System.out.print(" 7 . UPDATE STATUS \n\n") ;
      System.out.print("\t\t\t\t") ;
      System.out.print(" 8 . SEARCH CASES \n\n") ;
      System.out.print("\t\t\t\t") ;
       System.out.print( " 9 . GO Back\n\n" );
      System.out.print("\t\t\t\t") ;
      
      
      System.out.print("Choose Option:[1/2/3/4/5/6/7/8/9] : " );
      
      input=scanner.nextInt();

      
      
      
      switch(input) {
        case 1: {
        	
        	try {
          System.out.print("\t\t\t\t");
            System.out.print(" 1. ADD RECORD From File\n\n");
      System.out.print("\t\t\t\t");
      System.out.print(" 2. ADD  RECORD From User input\n\n");
      System.out.print("\t\t\t\t" );
      System.out.print("Choose Option:[1/2] : " );
      
      input=scanner.nextInt();
        	}
        	catch(Exception e) {
        		 System.out.println("You had entered an wrong an input ....... pls try again.....");
        		 admin_Menu();
        	}
      switch(input){
        case 1 :{
         String [] criminal = new String[0];
        CreateCriminal.create(criminal,Criminal.getfilename(),Criminal.gettablename());
        break;
        }

        case 2 :{
        Criminal c = new Criminal();
        c.setcriminal_name();
        c.setcriminal_no();
        c.setcriminal_dateofBirth();
        c.setcriminal_dateofArrest();
        c.settype_crime();
        c.setcriminal_gender();
        c.setcriminal_address();
        String [] criminal1 = new String[7];
        criminal1[0] = c.getcriminal_name();
        criminal1[1] = c.getcriminal_no();
        criminal1[2] = c.getcriminal_dateofBirth();
        criminal1[3] = c.getcriminal_dateofArrest();
        criminal1[4] = c.gettype_crime();
        criminal1[5] = c.getcriminal_gender();
        criminal1[6] = c.getcriminal_address();
        CreateCriminal.create(criminal1,Criminal.getfilename(),Criminal.gettablename());
        break;
        }
        default:
      {
        System.out.print( "\n\n\n" );
        System.out.print("\t\t\t\t" );
        System.out.print("  Invalid input!" );
        System.out.print("\n\n" );
        System.out.print("\t\t\t\t" );
        admin_Menu();
        }
}

  break;


        }

    case 2 :{
    	 try {
      System.out.print("\t\t\t\t");
    System.out.print(" 1. Delete RECORD Using Criminal_no\n\n");
    System.out.print("\t\t\t\t");
    System.out.print(" 2. Delete RECORD From any attribute\n\n");
    System.out.print("\t\t\t\t" );
    System.out.print(" 3. Delete ALL RECORDs\n\n");
    System.out.print("\t\t\t\t" );

    System.out.print("Choose Option:[1/2/3] : " );
    
    input=scanner.nextInt();
     	}
     	catch(Exception e) {
   	 	 System.out.println("You had entered an wrong an input ....... pls try again.....");
   	 	 admin_Menu();
   	 }

    switch(input){
        case 1 :{
       String [] cri= new String[0];
        DeleteCriminalFromDatabase.delete(cri,Criminal.getfilename(),Criminal.gettablename());
        break;
        }
        case 2 :{
          System.out.print("\t\t\t\t");
           scanner.nextLine();
        System.out.print("Enter From which attribute u want to delete :");
       
        String att= scanner.nextLine();
        System.out.print("\t\t\t\t");
        System.out.print("Enter Info about attribute that  u want to delete :");
        String info= scanner.nextLine();
        String [] cri1 ={att,info};
        DeleteCriminalFromDatabase.delete(cri1,Criminal.getfilename(),Criminal.gettablename());
        break;
        }

        case 3 :{
         DeleteAllMain.deleteall(Criminal.gettablename(),Criminal.getfilename());
         break;
        }

         default:
      {
        System.out.print( "\n\n\n" );
        System.out.print("\t\t\t\t" );
        System.out.print("  Invalid input!" );
        System.out.print("\n\n" );
        System.out.print("\t\t\t\t" );
        admin_Menu();
        }



    } 

    break;
    }

case 3 :{

  try {
  System.out.print("\t\t\t\t");
    System.out.print(" 1. Search RECORD with out order using an attribute\n\n");
    System.out.print("\t\t\t\t");
    System.out.print(" 2. Search Record with order using an attribute\n\n");
    System.out.print("\t\t\t\t" );

    System.out.print("Choose Option:[1/2] : " );
    
    input=scanner.nextInt();
  }
  catch(Exception e) {
		 System.out.println("You had entered an wrong an input ....... pls try again.....");
		 admin_Menu();
	}

    switch(input){
        case 1 : {
scanner.nextLine();
System.out.print("\t\t\t\t");
            System.out.print("Enter From which attribute u want to search :");
        String att= scanner.nextLine();
        System.out.print("\t\t\t\t");
        System.out.print("Enter mode(>,<,=,!=)  u want to search :");
        String mode= scanner.nextLine();
        System.out.print("\t\t\t\t");
        System.out.print("Enter info of attribute  u want to search :");
        String info= scanner.nextLine();
        String [] opt = {att,mode,info};

        SearchCriminalinDatabase.search(opt,Criminal.gettablename());

        break;
}

case 2 : {
scanner.nextLine();
System.out.print("\t\t\t\t");
    System.out.print("Enter From which attribute u want to search :");
String att= scanner.nextLine();
System.out.print("\t\t\t\t");
System.out.print("Enter mode(>,<,=,!=)  u want to search :");
String mode= scanner.nextLine();
System.out.print("\t\t\t\t");
System.out.print("Enter info of attribute  u want to search :");
String info= scanner.nextLine();
System.out.print("\t\t\t\t");
System.out.print("Enter order(i or d) that  u want to search :");
String ord= scanner.nextLine();

String [] opt = {att,mode,info,ord};

SearchCriminalinDatabase.search(opt,Criminal.gettablename());

break;
}

default:
{
  System.out.print( "\n\n\n" );
  System.out.print("\t\t\t\t" );
  System.out.print("  Invalid input!" );
  System.out.print("\n\n" );
  System.out.print("\t\t\t\t" );
  admin_Menu();
  }
}
break;

}

case 4 : {
  scanner.nextLine();
  System.out.print("\t\t\t\t");
      System.out.print("Enter which attribute u want to set :");
  String att1= scanner.nextLine();
  System.out.print("\t\t\t\t");
      System.out.print("Enter new data  u want to set :");
  String dat1= scanner.nextLine();
  System.out.print("\t\t\t\t");
      System.out.print("Enter using which attribute u want to set (where) :");
  String att2= scanner.nextLine();
  System.out.print("\t\t\t\t");
      System.out.print("Enter  data  u want for where :");
  String dat2= scanner.nextLine();

  String []cri = {att1,dat1,"where",att2,dat2};




  UpdateCriminal.update(cri,Criminal.getfilename(),Criminal.gettablename());

  break;

}


case 5 : {
  Listofcriminals.print(Criminal.gettablename());

  break;
}

case 6 : {

	scanner.nextLine();
  System.out.print("\t\t\t\t");

  System.out.print("Enter From which attribute u want to sort :");

  String att= scanner.nextLine();
        System.out.print("\t\t\t\t");
        System.out.print("Enter mode(>,<,=,!=)  u want to search :");
        String mode= scanner.nextLine();

    String []cri = {att,mode};

    SortCriminals.sort(cri,Criminal.gettablename());

  



  break;

}

case 7 : {

  scanner.nextLine();
  System.out.print("\t\t\t\t");

  System.out.print("Enter name of person that u want to update status :");

  String nam = scanner.nextLine();
  System.out.println(nam);

  CompliantDBMS.UpdateStatus(Complaint.gettablename(), nam);


  break;


}


case 8 : {

  scanner.nextLine();
  System.out.print("\t\t\t\t");
  System.out.print("Enter From which attribute u want to search :");
  String att= scanner.nextLine();
  System.out.print("\t\t\t\t");
  System.out.print("Enter mode(>,<,=,!=)  u want to search :");
  String mode= scanner.nextLine();
  System.out.print("\t\t\t\t");
  System.out.print("Enter info of attribute  u want to search :");
  String info= scanner.nextLine();
  System.out.print("\t\t\t\t");
  System.out.print("Enter order(i or d) that  u want to search :");
  String ord= scanner.nextLine();
  System.out.print("\t\t\t\t");
  CompliantDBMS.searchComplaintbyID(att, mode, info, ord,Complaint.gettablename());
  
 
  
  

  break;







}

case 9 : {

  Menu_Login();
}


default:
      {
        System.out.print( "\n\n\n" );
        System.out.print("\t\t\t\t" );
        System.out.print("  Invalid input!" );
        System.out.print("\n\n" );
        System.out.print("\t\t\t\t" );
        admin_Menu();
        }





}

    }
    
   }
   

   catch(Exception e) {
    
   System.out.println("You had entered an wrong an input ....... pls try again.....");
    admin_Menu();
   }

   

  
}

public void Menu_Login(){
	while(true) {
	try {
    System.out.print("\t\t\t\t    ----------------------------------\n");
      System.out.print("\t\t\t\t    |WELCOME TO POLICE STATION MANAGEMENT SYSTEM|\n");
      System.out.print( "\t\t\t\t    ----------------------------------\n");
      System.out.print("\n\n\n\n");
      System.out.print("\t\t\t\t");
      System.out.print(" 1.USER LOGIN\n\n");
      System.out.print("\t\t\t\t");
      System.out.print(" 2.Create User LOGIN\n\n");
      System.out.print("\t\t\t\t");
     System.out.print(" 3. ADMIN LOGIN\n\n");
      System.out.print("\t\t\t\t" );
      System.out.print(" 4.Logout\n\n");
      System.out.print("\t\t\t\t" );
    System.out.print("Choose Option:[1/2/3/4] : " );
    Scanner s = new Scanner(System.in);
     int input=s.nextInt();
     //s.close();


       
     

     switch(input){
     
     
        case 1 : {
       if(UserLogin.login()){
        User_Menu();
       }
      break;
        }

      case 2 :
       UserLogin.create();
       break;
        
       case 3: {
        if(AdminLogin.login()){
                admin_Menu();
        
              }
              break;
            }
        case 4 :
        UserLogin.callExit();
        
        default:
        {
          System.out.print( "\n\n\n" );
          System.out.print("\t\t\t\t" );
          System.out.print("  Invalid input!" );
          System.out.print("\n\n" );
          System.out.print("\t\t\t\t" );
          Menu_Login();
          }
          
             }
        }
	
    catch(Exception e) {
   	 System.out.println("You had entered an wrong an input ....... pls try again.....");
   	 Menu_Login();
       
   }
	}



    }
}
 


    
    

