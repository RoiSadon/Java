package Answer04;

public class Check {
	
	// ATTRIBUTES:
	
		// ChNumber: 
		private String ChNumber;
		public String getChNumber()
		{
			return this.ChNumber;
		}
		public void setChNumber(String v)
		{
				this.ChNumber = v;
		}
	 
		// Bname: 
		private String Bname;
		public String getBname()
		{
			return this.Bname;
		}
		public void setBname(String v)
		{
				this.Bname = v;
		}
		// DepNumber: 
		private int DepNumber;	
		public int getDepNumber()
		{
			return this.DepNumber;
		}
		public void setDepNumber(int v)
		{
				this.DepNumber = v;
		}
		
		// Amount: 
		private float Amount;	
		public float getAmount()
		{
			return this.Amount;
		}
		public void setAmount(float v)
		{
				this.Amount = v;
		}	
		
		// Full Constructor
		public Check(String ChNumber,String Bname,int DepNumber,float Amount) {
				this.ChNumber=ChNumber;
				this.Bname=Bname;
				this.DepNumber=DepNumber;
				this.Amount=Amount;
		}
		
		// Empty Constructor
		public Check() {
			this.ChNumber="na";
			this.Bname="na";
			this.DepNumber=0;
			this.Amount=0;
		}
		
		@Override
		public String toString() {
			return "[ChNumber: "+this.ChNumber+" ,Bname: "+this.Bname + " ,DepNumber:"+this.DepNumber+ " ,Amount:"+this.Amount+"]";
		}
		
}








































