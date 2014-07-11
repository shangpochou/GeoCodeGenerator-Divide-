import java.util.*;


public class DataBase {
		
	/*
	 * nOfYear represent how many years
	 * of this input data. It is the number 
	 * of columns of input data.
	 * */
	public int nOfYear;
	/*
	 * we use Arraylist to store data here.
	 * Because the order of ID matters, 
	 * so we didn't use Hashtable.
	 * */
	public ArrayList<GeoData> geoDataList;
	
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
	/*
	 * this method is for passing parameters.
	 * */
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
