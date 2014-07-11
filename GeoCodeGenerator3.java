import java.util.ArrayList;
/*
 * Generate the "Big ID table"
 * It accepts ID table with vary number of years
 * (the number of columns is not a fixed value)
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
