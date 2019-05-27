package Answer01;

public class Hotel {

	// ATTRIBUTES:
	
	// Name: 
	private String Name;
	public String getName()
	{
		return this.Name;
	}
	public void setName(String v)
	{
		if(v.length()<=30)
			this.Name = v;
	}
 
	// City: 
	private String City;
	
	public String getCity()
	{
		return this.City;
	}
	public void setCity(String v)
	{
		if(v.length()<=20)
			this.City = v;
	}
	
	// Rooms: 
	private int Rooms;
	public int getRooms()
	{
		return this.Rooms;
	}
	public void setRooms(int v)
	{
			this.Rooms = v;
	}
	
	// Free: 
	private int Free;
	public int getFree()
	{
		return this.Free;
	}
	public void setFree(int v)
	{
			this.Free = v;
	}
	
	// FUNCTIONS
	
	// Full Constructor:
	public Hotel(String Name,String City,int Rooms,int Free) {
		this.Name=Name;
		this.City=City;
		this.Rooms = Rooms;
		this.Free = Free;
	}
	
	// Empty Constructor:
	public Hotel() {
		this.Name="NA";
		this.City="NA";
		this.Rooms = 0;
		this.Free = 0;
	}
	
	public void SetData(String a,String b,int c,int d) {
		this.Name=a;
		this.City=b;
		this.Rooms = c;
		this.Free = d;
	}
	
	@Override
	public String toString() {
		return "[Name: "+this.Name+" ,City: "+this.City + " ,Rooms:"+this.Rooms+" ,Free:"+this.Free +"]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


