package Operations;


import java.util.List;

import CriminalClass.CriminalDBMS;
import CriminalClass.Criminal;


public class UpdateCriminalinDatabase {

    private static CriminalDBMS vd = new CriminalDBMS();
    // This method reads from csv, and through the list of vehicles, deletes entry and re-enters new entry
    public static void updateCriminal(List<Criminal> list, String tableName){
       if(list!=null)
       { 
       for (Criminal v : list) {
           vd.deleteCriminal(v.getcriminal_no(), tableName);
       }
       for (Criminal v : list) {
           vd.createCriminal(v, tableName);
       }
       System.out.println("Updated "+list.size()+" rows");
      }
    }

    // This method directly updates the Vehicle DBMS Table
    public static void updateCriminal(String cri[], String tableName){
        vd.updateCriminal(cri, tableName);
    }
    
}
