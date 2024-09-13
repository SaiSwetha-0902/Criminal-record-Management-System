

/*
    Objective: This is a director class which directs and calls the appropriate delete method.
*/




package Operations;

import java.util.Set;

import FileHandler.DeleteFromFile;
import FileHandler.DeleteinFile;
import HelpOperations.Help;
import CriminalClass.CriminalDBMS;


public class DeleteCriminalFromDatabase {

      // This method directs to the appropriate delete method i.e. csv or command line
      public static void delete(String cri[], String fileName, String tableName){
        CriminalDBMS cd = new CriminalDBMS();
        if(cri.length == 0){
            //read from csv and delete from both 
            Set<String> temp = DeleteFromFile.deleteFromFile(fileName, cd.returnCount(tableName));
            //delete from database   
            cd.deleteCriminal(temp, tableName);
            System.out.println("Current Count: " + cd.returnCount(tableName)); 
        }
        else if(cri.length == 2){
            if(cri[0].equals("cn")||cri[0].equals("cno")||cri[0].equals("cdob")||cri[0].equals("cdoa")||cri[0].equals("tc")||cri[0].equals("cg")
             || cri[0].equals("ca"))
            {
            //no return while deleting from file
            DeleteinFile.deleteinFile(fileName, Help.inShort(cri[0]), cri[1]);
            //no return while deleting from database
            cd.deleteCriminalFromAttribute(Help.inShort(cri[0]), cri[1], tableName);
            System.out.println("Current Count: " + cd.returnCount(tableName));
            }
            else
            {
                System.out.println("Entered wrong attribute name");
            }
        }
    }  


    
}
