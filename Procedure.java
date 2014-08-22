public class Procedure {
	
	protected DataBase myDB;
	
	public void GetData(DataBase inputDB){
		this.myDB = inputDB;
	}
	public void Task(){
		
	}
	
	protected String ParseCSV(String inputString){
		String newString = inputString.replace('\t', ' ');
		newString = newString.replace('"', ' ');
		newString = newString.replace('-', ' ');
		newString = newString.replace(" ", "");
		return newString;
	}
	
	protected String WarpWithComma(String inputString){
		return '"' + inputString + '"' + ",";
	}
	protected String WarpWithoutComma(String inputString){
		return '"' + inputString + '"';
	}
	protected String WarpWithCommaTab(String inputString){
		return '"' + "\t" + inputString + '"' + ",";
	}
	protected String WarpWithoutCommaTab(String inputString){
		return '"' + "\t" + inputString + '"';
	}
}
