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
		
		for(int i = 0; i < myDB.nOfYear + 1; i++){
			String tmpTitleOfEachYear = "Code of Year " + String.valueOf(i);
			tmpTitle += this.WarpWithComma(tmpTitleOfEachYear);
		}
		bw.write(tmpTitle);
	    bw.newLine();
	    
		for(int j = 0; j < myDB.geoDataList.size(); j++){
			GeoData tmpGData = myDB.geoDataList.get(j);

			String temp = new String();
			/*
			 * add all ID code of current division list.
			 * */
			for(int i = 0; i < tmpGData.curDivisionList.size(); i++){
				temp += this.WarpWithCommaTab(tmpGData.curDivisionList.get(i));
			}
			/*
			*	add the code of new year (current year which).
			*	And it should be the duplicated value.
			*/
			temp += this.WarpWithoutCommaTab(tmpGData.curDivisionList.get(tmpGData.curDivisionList.size()-1));
			
			bw.write(temp);
			bw.newLine();
			/*
			 * put new division's data to the .csv file.
			 * */
			if(tmpGData.newDivisionList.size() != 0){
				for(int i = 0; i < tmpGData.newDivisionList.size(); i++){
					String tmpNewDiv = new String();
					/*
					 * fill space to cells which represents
					 * past years of the new division.
					 * */
					for(int k = 0; k < myDB.nOfYear; k++){
						tmpNewDiv += this.WarpWithCommaTab(" ");
					}
					/*
					 * put the new division's data at the end
					 * of this line which will written to the .csv file.
					 * */
					tmpNewDiv += this.WarpWithCommaTab(tmpGData.newDivisionList.get(i));
					
					bw.write(tmpNewDiv);
					bw.newLine();
				}
			}
			
			
		}
		
		bw.close();
	}
	
}
