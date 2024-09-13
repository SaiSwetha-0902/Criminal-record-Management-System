/*
    objective: Giving a brief structure about what a criminal is and how he looks like and its methods
*/

package CriminalClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Criminal {
private String criminal_name;
private String criminal_no;
private String criminal_dateofBirth;
private String criminal_dateofArrest;
private String type_crime;
private String criminal_gender;
private String crimianl_address;

private static  final String filename = "criminal.csv";

private static  final String tablename = "criminal";


public Criminal(String name,String no,String dob,String doa,String type_crime,String gen,String add){
    this.criminal_name=name;
    this.criminal_no=no;
    this.criminal_dateofBirth=dob;
    this.criminal_dateofArrest=doa;
    this.type_crime=type_crime;
    this.criminal_gender=gen;
    this.crimianl_address=add;
}

public Criminal(){
    
}

public static String getfilename(){
    return filename; 
}

public static String gettablename(){
    return tablename; 
}

public String getcriminal_name(){
    return criminal_name;
}
public void setcriminal_name(){
    Scanner sin = new Scanner(System.in);
    System.out.print("\t\t\t\t" );
    System.out.print("Enter criminal_name:"); 
    String name=sin.nextLine();
    //sin.close();
  this.criminal_name= name;
}
  
public String getcriminal_no(){
    return criminal_no;
}
public void setcriminal_no(){
    Scanner sin = new Scanner(System.in);
    System.out.print("\t\t\t\t" );
    System.out.print("Enter criminal_no:");
    String no=sin.nextLine();
    //sin.close();
    this.criminal_no=no;
    
}

public String getcriminal_dateofBirth(){
    return criminal_dateofBirth;
}
public void setcriminal_dateofBirth(){
     Scanner sin = new Scanner(System.in);
     System.out.print("\t\t\t\t" );
    System.out.print("Enter criminal_dateofBirth:");
    String dob=sin.nextLine();
    //sin.close();
    this.criminal_dateofBirth=dob;
}

public String getcriminal_dateofArrest(){
    return criminal_dateofArrest;
}
public void setcriminal_dateofArrest(){
    Scanner sin = new Scanner(System.in);
    System.out.print("\t\t\t\t" );
    System.out.print("Enter criminal_dateofArrest:");
    String doa=sin.nextLine();
    //sin.close();
    
    this.criminal_dateofArrest=doa;
}


public String gettype_crime(){
    return type_crime;
}
public void settype_crime(){
    Scanner sin = new Scanner(System.in);
    System.out.print("\t\t\t\t" );
    System.out.print("Enter type_crime:");
    String type=sin.nextLine();
    //sin.close();
    
    this.type_crime=type;
}


public String getcriminal_gender(){
    return criminal_gender;
}
public void setcriminal_gender(){
    Scanner sin = new Scanner(System.in);
    System.out.print("\t\t\t\t" );
    System.out.print("Enter criminal_gender:");
    String gen=sin.nextLine();
    //sin.close();
    this.criminal_gender=gen;
}


public String getcriminal_address(){
    return crimianl_address;
}
public void setcriminal_address(){
    Scanner sin = new Scanner(System.in);
    System.out.print("\t\t\t\t" );
    System.out.print("Enter criminal_address:");
    String add=sin.nextLine();
    //sin.close();
    this.crimianl_address=add;
}



// This method takes a list and directs to fancy printing(Box shaped) or list kind printing
public static void printListofCriminals(List<Criminal> list)
{
  if(list.size()<=25)
  print_nice(list); 
  else
  print_eff(list); 
}


// This method prints the list of vehicles in Table format
public static void print_eff(List<Criminal> list)
{
    System.out.print(" ");
    for(int i=0;i<153;i++)
    System.out.print("_");
    System.out.println("");
    System.out.print("|         criminal_name         |          criminal_no        |    Criminal_dateofBirth   |        Criminal_dateofArrest         |     type_crime     |      criminal_gender    |      criminal_address");
     System.out.println("");
     System.out.print("|");
     for(int i=1;i<=154;i++)
     {
     if(i%24==0)
     System.out.print("|");
     else    
     System.out.print("_");
     }
     for (Criminal v : list) {
         String temp;
         System.out.println("");
         System.out.print("|");
         System.out.print(" "+v.getcriminal_name());
         for(int i=1+v.getcriminal_name().length();i<23;i++)
         System.out.print(" ");
         System.out.print("|");
         temp = v.getcriminal_no();
         System.out.print(" "+temp);
         for(int i=1+temp.length();i<33;i++)
         System.out.print(" ");
         System.out.print("|");
         temp = v.getcriminal_dateofBirth();
         System.out.print(" "+temp);
         for(int i=1+temp.length();i<33;i++)
         System.out.print(" ");
         System.out.print("|");
         temp = v.getcriminal_dateofArrest();
         System.out.print(" "+temp);
         for(int i=1+temp.length();i<33;i++)
         System.out.print(" ");
         System.out.print("|");
         temp = v.gettype_crime();
         System.out.print(" "+temp);
         for(int i=1+temp.length();i<33;i++)
         System.out.print(" ");
         System.out.print("|");
         temp = v.getcriminal_gender();
         System.out.print(" "+temp);
         for(int i=1+temp.length();i<33;i++)
         System.out.print(" ");
         System.out.print("|");
         temp = v.getcriminal_address();
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

// This method prints the list of Criminals in fancy printing(Box shaped)
public static void print_nice(List<Criminal> list)
{
    if(list.size()>=5)
    for(int i=0;i<149;i++)
    System.out.print("_");
    else
    for(int i=0;i<30*list.size()-1;i++)
    System.out.print("_");
    for(int i=0;i<list.size();i=i+6)
    {
        System.out.println("");
        List<Criminal> list1 = new ArrayList<>();
        for(int j=i;j<list.size() && j<i+6;j++)
        {
            list1.add(list.get(j));
        }
        for(int z=0;z<list1.size();z++)
        {
            System.out.print(" Criminal_name : "+list1.get(z).getcriminal_name());
            for(int x=30*z+11+list1.get(z).getcriminal_name().length();x<(z+1)*30;x++)
            System.out.print(" ");
            System.out.print("|");
        }
        System.out.println("");
        for(int z=0;z<list1.size();z++)
        {
            String temp = list1.get(z).getcriminal_no();
            
            System.out.print(" criminal_no : "+temp);
            for(int x=30*z+11+temp.length();x<(z+1)*30;x++)
            System.out.print(" ");
            System.out.print("|");
        }
        System.out.println("");
        for(int z=0;z<list1.size();z++)
        {
            String temp = list1.get(z).getcriminal_dateofBirth();
            
            System.out.print(" criminal_dateofBirth : "+temp);
            for(int x=30*z+20+temp.length();x<(z+1)*30;x++)
            System.out.print(" ");
            System.out.print("|");
        }
         System.out.println("");
        for(int z=0;z<list1.size();z++)
        {
            String temp = list1.get(z).getcriminal_dateofArrest();
            
            System.out.print(" criminal_dateofArrest : "+temp);
            for(int x=(30*z)+14+temp.length();x<(z+1)*30;x++)
            System.out.print(" ");
            System.out.print("|");
        }
        System.out.println("");
        for(int z=0;z<list1.size();z++)
        {
            System.out.print(" type_crime : "+list1.get(z).gettype_crime());
            for(int x=(30*z)+20+list1.get(z).gettype_crime().length();x<(z+1)*30;x++)
            System.out.print(" ");
            System.out.print("|");
        }
        System.out.println("");
        for(int z=0;z<list1.size();z++)
        {
            System.out.print(" criminal_gender : "+list1.get(z).getcriminal_gender());
            for(int x=(30*z)+16+list1.get(z).getcriminal_gender().length();x<(z+1)*30;x++)
            System.out.print(" ");
            System.out.print("|");
        }
        System.out.println("");
        for(int z=0;z<list1.size();z++)
        {
            System.out.print(" criminal_address : "+list1.get(z).getcriminal_address());
            for(int x=(30*z)+16+list1.get(z).getcriminal_address().length();x<(z+1)*30;x++)
            System.out.print(" ");
            System.out.print("|");
        }

        System.out.println("");

        for(int z=1;z<=list1.size()*30;z++)
        {
        if(z%28==0)
        System.out.print("|");
        else
        System.out.print("_");
        }
        list1.clear();
    }
}





    
}
