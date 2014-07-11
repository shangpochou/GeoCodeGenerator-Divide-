import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * Read divide list, and put the information to GeoData
 * 
 * */

public class ReadDivideList extends Procedure{

	public void Task(){
        BufferedReader reader;
        
        try {

            reader = new BufferedReader(new FileReader(myDB.divideListPath));
         
            // Read the first line or not (comment means yes)
            //reader.readLine();
      
            String line = null;
            /*
             * represent the index of current pivot, 
             * which is the division will divide to 
             * other division.
             */
            int curPivotIndex = -1;
            
            while ((line = reader.readLine()) != null) {               
                String item[] = line.split(",");              
                /*
                 * if this line's column is a string 
                 * with length more than 1. It is
                 * the "pivot" division's ID.
                 * 
                 * So we need to find the index of this
                 * division. Then we put new division's IDs
                 * to the "pivot" division's new division list.
                 * */
                
                if(this.ParseCSV(item[0]).length() > 1){
                	String tmpID = this.ParseCSV(item[0]);
                	
                	for(int i = 0; i < myDB.geoDataList.size(); i++){
                		if(myDB.geoDataList.get(i).totalCode.equals(tmpID)){
                			curPivotIndex = i;
                		}
                	}
                	/*
                	 * if this row has two columns, 
                	 * we need to put the IDs to the
                	 * "pivot" division's new division list.
                	 * */
                }else if(item.length == 2){
                	myDB.geoDataList.get(curPivotIndex).newDivisionList.add(this.ParseCSV(item[1]));
                }               
            }
           
            reader.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }		
		
	}
}
