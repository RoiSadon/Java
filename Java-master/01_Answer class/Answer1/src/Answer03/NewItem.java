package Answer03;

public class NewItem {
	
	// ATTRIBUTES:
	
	// Product: 
	private Item Product;
	public Item getProduct()
	{
		return this.Product;
	}
	public void setProduct(Item v)
	{
			this.Product = v;
	}
 
	// Bonus: 
	private int Bonus;	
	public int getBonus()
	{
		return this.Bonus;
	}
	public void setBonus(int v)
	{
			this.Bonus = v;
	}
	
	// Constructor:
	public NewItem(Item Product,int Bonus) {
		this.Product=Product;
		this.Bonus=Bonus;
	}
		
	// Set Bonus function:
	public void SetBonus(int B) {
		this.Bonus=B;
	}
	
	// Cost - sum of items and their price:
	public float Cost(int N) {
		float res;
		if(N<=100)
			return Product.Cost(N);
		else
			res = Product.Cost(N)+(N-100)*(1-Bonus/100);
			return res;
	}
	
}
















