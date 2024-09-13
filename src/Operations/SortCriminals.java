package Operations;


import CriminalClass.CriminalDBMS;
import CriminalClass.Criminal;
import HelpOperations.Help;
import java.util.*;

public class SortCriminals { 

    // This method sorts on attribute and directs to printing function
    public static void sort(String cri[], String tableName) {
        if (cri[0].equals("cn") || cri[0].equals("cno") || cri[0].equals("cdob") || cri[0].equals("cdoa")
                || cri[0].equals("tc") || cri[0].equals("cg")   || cri[0].equals("ca") ) {
            if (cri[1].equals("i") || cri[1].equals("d")) {
                List<Criminal> ls = (new CriminalDBMS()).sortCriminalbyAttribute(Help.inShort(cri[0]),
                        Help.inShort(cri[1]), tableName);
                if (ls != null) {
                    Criminal.print_eff(ls);
                }
            } else {
                System.out.println("Entered invalid sorting order");
                System.out.println("Should enter i or d for increasing and decreasing order respectively");
            }
        } else {
            System.out.println("Entered invalid attribute");
        }
    }


    
}
