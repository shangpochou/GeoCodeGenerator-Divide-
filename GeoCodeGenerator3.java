import java.util.ArrayList;
/*
 * Generating the "big table" based on the divide list
 * for example
 * 
 * This is the current version,
 * the big table only contains ID
 * 
 * divide list is as follows:
 * 
 * A
 *   B
 *   
 * A
 *   C
 *   
 * the big table will looks like
 * year1 year2
 * A      A
 * A      B
 * A      C
 *
 * Because A is divided to B and C
 *
 * */

public class GeoCodeGenerator3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DataBase myDB = DataBase.GetDataBase();
	
		myDB.SetPath(args[0], args[1], args[2]);
		
		ArrayList<Procedure> myProcAL = new ArrayList<Procedure>();
		
		ReadCSV myRCSV = new ReadCSV();
		myProcAL.add(myRCSV);
	
		ReadDivideList myRDL = new ReadDivideList();
		myProcAL.add(myRDL);
		
		WriteToCSV myWCSV = new WriteToCSV();
		myProcAL.add(myWCSV);
				
		for(int i = 0; i < myProcAL.size(); i++){
			myProcAL.get(i).GetData(myDB);
			myProcAL.get(i).Task();
		}
		
		
	}

}
