/*
    Objective: This is a director class which directs to search with or without order 
*/

package Operations;

import java.util.ArrayList;
import java.util.List;

import HelpOperations.Help;
import CriminalClass.CriminalDBMS;
import CriminalClass.Criminal;

public class SearchCriminalinDatabase {
    // This method takes arguments and directs to ordered searching or unordered searching
    public static void search(String cri[], String tableName){
        CriminalDBMS cd = new CriminalDBMS();
        List<Criminal> ls = new ArrayList<>();
        if( cri[0].equals("cn")||cri[0].equals("cno")||cri[0].equals("cdob")||cri[0].equals("cdoa")||cri[0].equals("tc")||cri[0].equals("cg")
             || cri[0].equals("ca"))
        {
        if (cri.length == 3){
            // search and give result without order
            ls = cd.searchCriminalbyID(Help.inShort(cri[0]), Help.inShort(cri[1]), cri[2], tableName);    
        }
       else if (cri.length == 4 && (cri[3].equals("i")||cri[3].equals("d")))
       {
            // search and give result with sorted order
            ls = cd.searchCriminalbyID(Help.inShort(cri[0]), Help.inShort(cri[1]), cri[2], Help.inShort(cri[3]), tableName);    
        }
        else
        {
            System.out.println("Entered invalid sorting order");
            System.out.println("Should enter i or d for increasing and decreasing order respectively");
        }
        Criminal.print_eff(ls);
    }
    else
    {
        System.out.println("Entered invalid attribute or mode of operation");
    }
    }
}
