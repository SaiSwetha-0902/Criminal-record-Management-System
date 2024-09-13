
/*
    Objective: Based on user given string , it directs to invoking the appropriate updation method 
*/

package Operations;

import FileHandler.UpdateFile;
import FileHandler.UpdatetoDatabase;
import HelpOperations.Help;
import CriminalClass.CriminalDBMS;

public class UpdateCriminal {

      // This method directs to the appropriate updation function i.e csv updation or command line updation
      public static void update(String cri[], String fileName, String tableName){
        if(cri.length == 0){
            //update from csv
            UpdateCriminalinDatabase.updateCriminal(UpdatetoDatabase.updateToDatabase(fileName, (new CriminalDBMS()).returnCount(tableName)), tableName);
        }
        
        else if(cri.length == 5 && cri[2].equals("where")){
            //command line updation
            //needs to update both database and .csv
            if((cri[0].equals("cn")||cri[0].equals("cno")||cri[0].equals("cdob")||cri[0].equals("cdoa")||cri[0].equals("tc") || cri[0].equals("cg") || cri[0].equals("ca"))&&(cri[3].equals("cn")||cri[3].equals("cno")||cri[3].equals("cdob")||cri[3].equals("cdoa")||cri[3].equals("tc")||cri[3].equals("cg") ||cri[3].equals("ca") ))
            {
            UpdateCriminalinDatabase.updateCriminal(cri, tableName);
            UpdateFile.updateFile(fileName, Help.inShort(cri[0]), Help.inShort(cri[3]), cri[1], cri[4]);
            }
            else
            {
                System.out.println("Entered wrong attribute name");
            }
        }
        else{
            //printUpdateHelp
        }
    }


    
}
