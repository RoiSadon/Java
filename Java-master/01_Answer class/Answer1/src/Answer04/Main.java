package Answer04;

public class Main {

	// Function to find if 
	public static void Search(Check[] CheckArr,Check CheckPtr) {
		boolean exists = false;
		for(int i=0;i<CheckArr.length;i++)
		{
			if(CheckArr[i].getChNumber().equals(CheckPtr.getChNumber()))
				{
					System.out.println(CheckArr[i].toString());
					exists=true;
				}
		}
		if(exists==false)
			System.out.println("Check not exists");
	}
	
	public static void main(String[] args) {
		Check[] CheckArr = new Check[15];
		Check CheckPtr = new Check("X","B",1,1);
		for(int i=0;i<CheckArr.length;i++) {
			CheckArr[i] = new Check("X","Y",i,i);
		}
		Search(CheckArr,CheckPtr);
	}
}
