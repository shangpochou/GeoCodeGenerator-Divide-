import java.util.*;


public class DataBase {
		
	public ArrayList<GeoData> geoDataList;
	
	public int nOfYears;
	
	public String geoCodePath;
	
	public String divideListPath;
	
	public String outputCSVPath;
	//singulaton 
	private static DataBase myDataBase;
	
	/*
	 * Constructor, and config here.
	 */
	public DataBase(){	
		this.geoDataList = new ArrayList<GeoData>();
	}
	
	public void SetPath(String geoCodePath, String divideListPath, String outputPath){
		this.geoCodePath = geoCodePath;
		this.divideListPath = divideListPath;
		this.outputCSVPath = outputPath;
	}
	
	public static DataBase GetDataBase(){
		if(myDataBase == null){
			myDataBase = new DataBase();
		}
		return myDataBase;
	}
	
}
