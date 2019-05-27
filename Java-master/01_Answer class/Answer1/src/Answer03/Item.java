package Answer03;

public class Item {
	
	// ATTRIBUTES:
	
	// Catalog: 
	private long Catalog;	
	public long getCatalog()
	{
		return this.Catalog;
	}
	public void setCatalog(long v)
	{
			this.Catalog = v;
	}
	
	// Name: 
	private String Name;
	public String getName()
	{
		return this.Name;
	}
	public void setName(String v)
	{
		if(v.length()<=15)
			this.Name = v;
	}
 
	
	// Price: 
	private float Price;	
	public float getPrice()
	{
		return this.Price;
	}
	public void setPrice(float v)
	{
			this.Price = v;
	}
	
	// Full Constructor
	public Item(long Catalog,String Name,float Price) {
		this.Catalog=Catalog;
		this.Name=Name;
		this.Price=Price;
	}
	
	// empty Constructor
	public Item() {
		this.Catalog=0;
		this.Name="na";
		this.Price=0;
	}

	@Override
	public String toString() {
		return "[Name: "+this.Name+" ,Catalog: "+this.Catalog + " ,Price:"+this.Price+"]";
	}
	
	// Cost - sum of items and their price:
	public  float Cost(int N) {
		return N*(this.Price);
	}
}





























