package FileHandler;










import java.nio.charset.StandardCharsets;


import java.nio.file.Files;
import java.nio.file.Paths;



import java.util.*;


import CriminalClass.Criminal;

/*
OBJECTIVE: READ FROM .csv AND GIVE LIST DURING -create -b PROCESS
*/

public class AddtoDatabase {

    private static List<String> data = new ArrayList<>() ;

    private static List<Criminal> listOfCriminals = new ArrayList<>();

    private static List<String> cno = new ArrayList<>();
    
    private static List<Integer> indx = new ArrayList<>(); 

    private static int flag =0;


    // This method adds a criminal to the list by taking the individual values
	private static void addToList(String values[]) {
		Criminal c = new Criminal(values[0],values[1],values[2],values[3],values[4],values[5],values[6]);

       listOfCriminals.add(c);

	}

    // This method checks duplicate entry or not (returns 0 if not found and 1 if found)by taking criminal_no

    private static int present(String criminalno){
         
        int flag=0;

        if(cno.size()>0){
            for (String string : cno) {
                if(string.equals(criminalno))
                {
                flag=1;
                break;
                }
             }
          }

          if(flag==1)
          return 1;

          else 
          {
            if(listOfCriminals.size()>0)
            {
                for(Criminal c :listOfCriminals) {
                    if(c.getcriminal_no().equals(criminalno))
                    {
                        flag = 1;
                        break;
                    }
                }
            if(flag==1)
			return 1;
			else
			return 0;

            }
            else
            return 0 ;
          }
}

       // _____________Method to be called_______________//
	// _____________Requires Filename and number of records present in the
	// database______________//
	// _____________Returns the list of Criminals to be inserted into
	// database________//

    public static List<Criminal> readFromCSV(String fileName,int num) {
         
      
    	
        try {
			data = Files.readAllLines(Paths.get(fileName));
			 //System.out.println(data.size());
		}
		catch(Exception e)
		{
			e.getLocalizedMessage();
			return null;
		}

        
           



        for (int i = 0; i < num; i++) {
            String temp[] = data.get(i).split(",");
            cno.add(temp[1]);
        }
        
        for (int i=num;i<data.size();i++) {
             String values[] = data.get(i).split(",");
             // System.out.println(values.length);

            if(values.length==7)
            {
                int x = present(values[1]);
               // System.out.println(x);
                if(x == 0) {
               AddtoDatabase.addToList(values);
                }
               if(x == 1) {
					System.out.println("Duplicate entry found : "+data.get(i));
					indx.add(i);
               }
				
        }

                else
                {
                    System.out.println("Incomplete inputs found at line number "+(1+i));
                    flag=1;
                } 
            }

            if(flag==0)
			{
			if(indx.size()>0){
			for (int i=0;i<indx.size();i++){
				data.remove(indx.get(i)-i);
			}

            try {
				Files.write(Paths.get(fileName),data,StandardCharsets.US_ASCII);
            }
            
            catch(Exception e)
			{
				e.getLocalizedMessage();
				return null;
			}


            }

            return listOfCriminals;
        }

            else
            {
                System.out.println("Found incomplete inputs so we are not gonna proceed any futher");
                 return listOfCriminals;
            }

}

}








