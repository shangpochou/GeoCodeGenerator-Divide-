import java.util.*;

public class GeoData {

	public String totalCode;
	/*
	 * a list contains all current data cells
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
