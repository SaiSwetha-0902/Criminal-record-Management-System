
/*
    Objective: All the Operations possible on Vehicle is given here. 
*/




package CriminalClass;

import java.util.List;
import java.util.Set;

// This interface has all the Database methods which are required for Criminal Management Database

public interface CriminalDBMSMethods {

    public void createCriminal(Criminal c ,  String TableName); 

    List<Criminal> printCriminalContent(String TableName);

    int returnCount(String tableName);

    void deleteCriminal(Set<String>Criminal_no,String tableName);

    void deleteCriminalFromAttribute(String Attribute, String data, String tableName);
    
    void updateCriminal(String args[], String tableName);

    List<Criminal> searchCriminalbyID(String attribute, String mode, String val, String tableName);
    List<Criminal> sortCriminalbyAttribute(String attribute, String order, String tableName);
    
    void truncateTable(String TableName);

    

    
}
