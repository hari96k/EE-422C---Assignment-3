package Assignment3;

public class Grocery extends Item
{
	protected boolean perishable;

	
	Grocery(String Name, float Price, int Quantity, double Weight, boolean Shipping, boolean Perishable) 
	{
		super(Name, Price, Quantity, Weight, Shipping);
		perishable = Perishable;
	}

	
	//override calculatePrice() if necessary; Implement print methods as necessary	
	// Only re-implement stuff you cannot get from the superclass (Item)
	
}
