package Answer02;

public class Shop {
	
	// ATTRIBUTES:
	
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
 
	// banana: 
	private float Banana;	
	public float getBanana()
	{
		return this.Banana;
	}
	public void setBanana(float v)
	{
			this.Banana = v;
	}
	
	// apple: 
	private float Apple;	
	public float getApple()
	{
		return this.Apple;
	}
	public void setApple(float v)
	{
			this.Apple = v;
	}
	
	// Orange: 
	private float Orange;	
	public float getOrange()
	{
		return this.Orange;
	}
	public void setOrange(float v)
	{
			this.Orange = v;
	}	
	
	public Shop(String Name ,float Banana,float Apple,float Orange) {
		this.Name=Name;
		this.Banana=Banana;
		this.Apple=Apple;
		this.Orange=Orange;
	}
	
	public Shop() {
		
	}
	
	@Override
	public String toString() {
		return "[Name: "+this.Name+" ,Banana: "+this.Banana + " ,Apple:"+this.Apple+" ,Orange:"+this.Orange +"]";
	}
	
	public static void cheapest(Shop[] shopsArr, int bananas, int oranges, int apples) {
		int max=0;
		int sum=0;
		int index=0;
		for(int i=0;i<shopsArr.length;i++) {
			sum += (shopsArr[i].Apple)*apples + (shopsArr[i].Banana)*bananas + (shopsArr[i].Orange)*oranges;
			if (sum>max)
			{
				max = sum;
				index = i;
			}
		}
		
		System.out.println("Cheapest shop: "+ shopsArr[index].getName()+" Price: "+max);
	}
}

















