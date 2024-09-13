
/*
    objective: Giving a brief structure about what a criminal is and how he looks like and its methods
*/

package CriminalClass;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class Complaint {
	
	private String Name;
	
	private String gender;
	
	private String DateOfBirth;
	
	private String phone_no;
	
	private String Subject;
	
	private String place_Of_Occurence;
	
	private String Description;

	private String status="NOTSOLVED";
	
	
	private static  final String tablename = "complaint";
	
	public Complaint(String name,String gender,String dob,String pn,String subject,String place,String des){
	    this.Name=name;
	    this.gender=gender;
	    this.DateOfBirth=dob;
	    
	    this.phone_no=pn;
	    this.Subject=subject;
	    this.place_Of_Occurence=place;
	    this.Description=des;
		
	}

	public Complaint(){
	    
	}
	
	public static String gettablename(){
	    return tablename; 
	}
	
	public String getName(){
	    return Name;
	}
	public void setName(){
	    Scanner sin = new Scanner(System.in);
	    System.out.print("\t\t\t\t" );
	    System.out.print("Enter your name:"); 
	    String name=sin.nextLine();
	    //sin.close();
	  this.Name= name;
	}
	public String getgender(){
	    return gender;
	}
	public void setgender(){
	    Scanner sin = new Scanner(System.in);
	    System.out.print("\t\t\t\t" );
	    System.out.print("Enter your gender:"); 
	    String gen=sin.nextLine();
	    //sin.close();
	  this.gender= gen;
	}
	
	public String getDateOfBirth(){
	    return DateOfBirth;
	}
	public void setDateOfBirth(){
	    Scanner sin = new Scanner(System.in);
	    System.out.print("\t\t\t\t" );
	    System.out.print("Enter your Dateofbirth:"); 
	    String dob=sin.nextLine();
	    //sin.close();
	  this.DateOfBirth=dob;
	}
	
	public String getphone_no(){
	    return phone_no;
	}
	public void setphoneno(){
	    Scanner sin = new Scanner(System.in);
	    System.out.print("\t\t\t\t" );
	    System.out.print("Enter your phoneno:"); 
	    String pn =sin.nextLine();
	    //sin.close();
	  this.phone_no=pn;
	}
	
	public String getSubject(){
	    return Subject;
	}
	public void setSubject(){
	    Scanner sin = new Scanner(System.in);
	    System.out.print("\t\t\t\t" );
	    System.out.print("Enter the subject of complaint:"); 
	    String sub =sin.nextLine();
	    //sin.close();
	  this.Subject=sub;
	}
	
	
	
	public String getplace_Of_Occurence(){
	    return place_Of_Occurence;
	}
	public void setplace_Of_Occurence(){
	    Scanner sin = new Scanner(System.in);
	    System.out.print("\t\t\t\t" );
	    System.out.print("Enter the place of occurence :"); 
	    String occ =sin.nextLine();
	    //sin.close();
	  this.place_Of_Occurence=occ;
	}
	
	
	public String getDescription(){
	    return Description;
	}
	public void setDescription(){
	    Scanner sin = new Scanner(System.in);
	    System.out.print("\t\t\t\t" );
	    System.out.print("Enter the description of complaint :"); 
	    String des =sin.nextLine();
	    //sin.close();
	  this.Description=des;
	}


	public String getstatus(){
	    return status;
	}
	public void setstatus(String sta){
	    this.status = "sta";
	}
	
	// This method prints the list of complaints in Table format
	public static void print_eff(List<Complaint> list)
	{
	    System.out.print(" ");
	    for(int i=0;i<153;i++)
	    System.out.print("_");
	    System.out.println("");
	    System.out.print("|         name         |          gender        |     dateofBirth        |        phone_no        |        subject        |      place_of_occurence        |           Description                  |       Status  ");
	     System.out.println("");
	     System.out.print("|");
	     for(int i=1;i<=154;i++)
	     {
	     if(i%24==0)
	     System.out.print("|");
	     else    
	     System.out.print("_");
	     }
	     for (Complaint v : list) {
	         String temp;
	         System.out.println("");
	         System.out.print("|");
	         System.out.print(" "+v.getName());
	         for(int i=1+v.getName().length();i<23;i++)
	         System.out.print(" ");
	         System.out.print("|");
	         temp = v.getgender();
	         System.out.print(" "+temp);
	         for(int i=1+temp.length();i<33;i++)
	         System.out.print(" ");
	         System.out.print("|");
	         temp = v.getDateOfBirth();
	         System.out.print(" "+temp);
	         for(int i=1+temp.length();i<33;i++)
	         System.out.print(" ");
	         System.out.print("|");
	         temp = v.getphone_no();
	         System.out.print(" "+temp);
	         for(int i=1+temp.length();i<33;i++)
	         System.out.print(" ");
	         System.out.print("|");
	         temp = v.getSubject();
	         System.out.print(" "+temp);
	         for(int i=1+temp.length();i<33;i++)
	         System.out.print(" ");
	         System.out.print("|");
	         temp = v.getplace_Of_Occurence();
	         System.out.print(" "+temp);
	         for(int i=1+temp.length();i<33;i++)
	         System.out.print(" ");
	         System.out.print("|");
	         temp = v.getDescription();
	         System.out.print(" "+temp);
	         for(int i=1+temp.length();i<33;i++)
	         System.out.print(" ");
	         System.out.print("|");
			 temp = v.getstatus();
	         System.out.print(" "+temp);
	         for(int i=1+temp.length();i<33;i++)
	         System.out.print(" ");
	         System.out.print("|");
	     }
		
	     System.out.println("");
	     System.out.print("|");
	     for(int i=1;i<=154;i++)
	     {
	        if(i%24==0)
	        System.out.print("|");
	        else    
	        System.out.print("_");
	     }
	}
	
	
}
