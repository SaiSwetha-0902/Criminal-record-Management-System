
/*
    During Command Line deletion, the methods in this class searches and deletes the entry in respective .csv file. 
*/
package FileHandler;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import CriminalClass.Criminal;

public class DeleteinFile {

    private static List<String> data;
    private static List<Criminal> listOfCriminals = new ArrayList<>();
    private static List<Integer> indexes = new ArrayList<>();


    // This method adds to the vehicle list
    private static void addToList(String line) {
        String values[] = line.split(",");
        Criminal c = new Criminal(values[0], values[1], values[2],
               values[3], values[4], values[5],values[6]);
        listOfCriminals.add(c);
    }

    // This method returns the index of the vehicle needs to be deleted in csv
    private static int Delete(String name, String info)
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        int indx = 0;
        if (name.equals("Criminal_name") || name.equals("criminal_no") || name.equals("criminal_dateofBirth") || name.equals("criminal_dateofArrest")
        || name.equals("criminal_typecrime")||name.equals("criminal_gender") || name.equals("criminal_address")) {
            for (Criminal vehicle : listOfCriminals) {
                Object obj = vehicle;
                Class<?> cls = obj.getClass();
                Field f = cls.getDeclaredField(name);
                f.setAccessible(true);
                String temp = (String) f.get(obj);
                if (temp.equals(info)) 
                    indexes.add(indx);
                indx += 1;
                
            }
        }
          return 1;
            }

   // This method deletes the entry
   private static void Deletedata() {
    int i = 0;
    for (Integer indx : indexes) {

        data.remove(indx - i);
        i = i + 1;
    }
}

    // This method rewrites the entire csv from the filename
    private static int WriteToFile(String fileName) {
        try {
            Files.write(Paths.get(fileName),data,StandardCharsets.US_ASCII);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

// _______________Method to be called________________//
    // ________________Requires fileName , Name of the attribute ,info all
    // attributes to be passed in String Datatype________//
    // ________________Updates the csv files record on the given
    // information_______________________________//
    // ________________Returns 1 if successfull else returns 0_______________//

    // This method deletes the vehicle entry in .csv during Command Line Deletion


public static int deleteinFile(String fileName, String name, String info) {
        try {
            data = Files.readAllLines(Paths.get(fileName));
            for (String string : data) {
                DeleteinFile.addToList(string);
            }
        } catch (Exception e) {
            return 0;
        }
        try {
            DeleteinFile.Delete(name, info);
            Collections.sort(indexes);
        } catch (Exception e) {
            return 0;
        }
        DeleteinFile.Deletedata();
        try {
            WriteToFile(fileName);
            return 1;
        } catch (Exception e) {
            if (WriteToFile(fileName) == 1)
                return 1;
            else
                return 0;
        }
    }

}


          

        



    



