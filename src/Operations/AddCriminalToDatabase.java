

/*
    Objective: It takes a list from .csv and directs to adding database, one at a time
*/



package Operations;


import java.util.List;

import CriminalClass.Criminal;

import CriminalClass.CriminalDBMS;

public class AddCriminalToDatabase {

// This method takes a list of vehicles from AddtoDatabase.readfromCSV and adds it to the database via createVehicle function

public static void addCriminal(List<Criminal> list,String tableName) {
if(list!=null) 
{
    for(Criminal c :list) {
        (new CriminalDBMS()).createCriminal(c, tableName);
    }

}



}

    
}
