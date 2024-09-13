
/*
    Objective: Contains all the Helper functions and printHelp functions 
*/




package HelpOperations;

public class Help {

     // This method prints all the help
     public static void printAllHelp(){
        System.out.println("Try to access something for help like: \n");
        System.out.println("-create -help: (For help in creating Criminal in various ways)");
        System.out.println("-update -help: (For help in updating Criminal in various ways)");
        System.out.println("-delete -help: (For help in deleting Criminal in various ways)");
        System.out.println("-search -help: (For help in deleting Criminal in various ways)");
        System.out.println("-sort -help: (For help in printing vehicle in various ways)\n\n");
        System.out.println("-h for entire command list\n-v for version of the program\n-credits for the people contributed to the program\n");
    }
    
   
    public static int checkCreationArguments(String cri[]){
        if(cri.length != 7){
            System.out.println("error");
            return 0;
        }else{
            return 1;
        }
    }


    public static int checkDeletionArguments(String cri[]){
        if(cri.length != 2){
            System.out.println("error");
            return 0;
        }else{
            return 1;
        }
    }

    public static String inShort(String s){
        String res = null;
        switch(s){
            case "cn":
            res = "criminal_name";
            break;
            case "cno":
            res = "criminal_no";
            break;
            case "cdob":
            res = "criminal_dateofBirth";
            break;
            case "cdoa":
            res = "criminal_dateofArrest";
            break;
            case "tc":
            res = "type_crime";
            break;
            case "cg":
            res = "criminal_gender";
            break;
            case "ca":
            res = "criminal_address";
            break;

            case "ne":
            res = "!=";
            break;

            case "gt":
            res = ">";
            break;
            case "lt":
            res = "<";
            break;
            case "eq":
            res = "=";
            break;
            case "i":
            res = "ASC";
            break;
            case "d":
            res = "DESC";
            break;
        }
        return res;
    }



    public static void printCredits() {
        System.out.println("First Created as an OOPS Mini Project:\n\nContributors: \n");
        System.out.println("Abhishikth");
        System.out.println("Manikanta");
        System.out.println("Avinash");
        System.out.println("Swetha");
        System.out.println("Gagan\n\n\n");
    }





}
