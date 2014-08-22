import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/*
 * Read input geo code from a .csv file.
 * */
public class ReadCSV extends Procedure{

	
	public void Task(){
        BufferedReader reader;
        
        try {

            reader = new BufferedReader(new FileReader(myDB.geoCodePath));
         
            // Read the first line or not (comment means yes)
            reader.readLine();
      
            String line = null;
            
            while ((line = reader.readLine()) != null) {               
                String item[] = line.split(",");              
             
                GeoData tmpGData = new GeoData();
                /*
                 * read all current data,
                 * which is all cells in different columns
                 * */
                for(int i = 0; i < item.length; i++){
                	tmpGData.curDivisionList.add(this.ParseCSV(item[i]));
                }
                /*
                 * we don't have to refresh the number 
                 * of length for each line.
                 * But I didn't come up with a better solution
                 * now.
                 * */
                myDB.nOfYears = item.length;
                /*
                 * the latest code represents the ID
                 * of this Geo Data.
                 * */
                tmpGData.totalCode = this.ParseCSV(item[item.length-1]);
                myDB.geoDataList.add(tmpGData);
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
