import java.util.*;

public class GeoData {
	/*
	 * We don't need these data in this program, 
	 * but in the future we maybe need them.
	 * */
	/*
	public String cityName;
	public String townshipName;
	public String villageName;
	public String cityCode;
	public String townshipCode;
	public String villageCode;
	*/
	public String totalCode;
	/*
	 * contain all current division's code which 
	 * got from the input file.
	 * */
	public ArrayList<String> curDivisionList;
	/*
	 * contain division which are seperated from this
	 * division
	 * */
	public ArrayList<String> newDivisionList;
	/*
	 * need to initialize the newDivisionList 
	 * in constructor
	 * */
	public GeoData(){
		this.newDivisionList = new ArrayList<String>();
		this.curDivisionList = new ArrayList<String>();
	}
}
