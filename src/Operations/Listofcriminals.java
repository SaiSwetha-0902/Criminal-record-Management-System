package Operations;

import CriminalClass.*;

import FileHandler.*;

public class Listofcriminals {

public static void print(String tablename){
    CriminalDBMS c = new CriminalDBMS() ;

    Criminal.print_eff(c.printCriminalContent(tablename));
        
    



}


    
}
