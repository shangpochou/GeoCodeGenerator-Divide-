import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/*
 * Read input geo code from a .csv file.
 * Now the input file only has codes, but
 * maybe that it contains codes in different year. 
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
                
                GeoData tmpGeoData = new GeoData();
                for(int i = 0; i < item.length; i++){
                	tmpGeoData.curDivisionList.add(this.ParseCSV(item[i]));
                }
                /*
                 * The current code is the last year's code
                 * */
                tmpGeoData.totalCode = this.ParseCSV(item[item.length-1]);
                
                myDB.geoDataList.add(tmpGeoData);
                /*
                for(int i = 0; i < item.length; i++)
                	System.out.println(this.ParseCSV(item[i]));
				*/
                /*
                 * Actually we don't have to
                 * update nOfYear after we reading each line.
                 * Yet I didn't come up with a smarter way now.
                 * */
                myDB.nOfYear = item.length;
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
