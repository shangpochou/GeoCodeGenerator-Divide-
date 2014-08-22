import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;


public class WriteToCSV extends Procedure{
	public void Task(){
		try {
			Output();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void Output() throws IOException{
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(myDB.outputCSVPath)); 
		
		String tmpTitle = new String();
		/*
		 * generate the title
		 * */
		for(int i = 0; i < myDB.nOfYears + 1; i++){
			String curTmpTitle = "Code of Year " + String.valueOf(i);
			tmpTitle += this.WarpWithComma(curTmpTitle);
		}
		
		bw.write(tmpTitle);
	    bw.newLine();
	    
		for(int j = 0; j < myDB.geoDataList.size(); j++){
			GeoData tmpGData = myDB.geoDataList.get(j);
			/*
			 * Generate the ID table.
			 * This section write all current ID.
			 * */
			String temp = new String();
			for(int k = 0; k < tmpGData.curDivisionList.size(); k++){
				temp += this.WarpWithCommaTab(tmpGData.curDivisionList.get(k));
			}
			/*
			 * put the ID to the new column
			 * */
			temp += this.WarpWithCommaTab(tmpGData.curDivisionList.get(tmpGData.curDivisionList.size()-1));
			
			bw.write(temp);
			bw.newLine();
			/*
			 * put new division data
			 * */
			if(tmpGData.newDivisionList.size() != 0){
				for(int i = 0; i < tmpGData.newDivisionList.size(); i++){
					String tmpNewDiv = new String();
					/*
					 * The major difference,
					 * instead of filling spaces to all columns past cells
					 * We put the past values to cells.
					 * */
					for(int k = 0; k < myDB.nOfYears; k++){
						tmpNewDiv += this.WarpWithCommaTab(tmpGData.curDivisionList.get(k));
					}
					tmpNewDiv += this.WarpWithoutCommaTab(tmpGData.newDivisionList.get(i));
					bw.write(tmpNewDiv);
					bw.newLine();
				}
				
			}
			
			
		}
		
		bw.close();
	}
	
}
