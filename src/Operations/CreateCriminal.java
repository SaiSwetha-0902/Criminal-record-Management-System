
/*
    Objective: This class directs to what Method is being called during creation 
*/

package Operations;

import FileHandler.AddtoDatabase;
import FileHandler.AddtoFile;
// import HelpOperations.Help;
import CriminalClass.CriminalDBMS;
import CriminalClass.Criminal;


public class CreateCriminal {
    // This method directs to the appropriate creation method i.e csv creation or command line creation
    public static int create(String cri[], String FileName, String TableName){
        CriminalDBMS cd = new CriminalDBMS();
        if(cri.length == 0){
           // add from csv
           AddCriminalToDatabase.addCriminal(AddtoDatabase.readFromCSV(FileName,cd.returnCount(TableName)),TableName);
           System.out.println("Current Count: " + cd.returnCount(TableName));
        }

        else if(HelpOperations.Help.checkCreationArguments(cri) == 1){
            //add to dbms
            Criminal c = new Criminal(cri[0],cri[1], cri[2], cri[3], cri[4], cri[5],cri[6]);
            cd.createCriminal(c, TableName);
            //add to csv
            int res = AddtoFile.addToFile(FileName, c);
            if(res == 1){
                System.out.println(TableName + " " + c.getcriminal_name() + " has been inserted");
            }
            System.out.println("Current Count: " + cd.returnCount(TableName));
        } 
        else{
            System.out.println("No of inputs not sufficient: \n");
           // Help.printCreateHelp();
        }

        return  0 ;
        



    }


}



