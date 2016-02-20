package Assignment3;

public class Electronics extends Item 
{
	protected boolean fragile;
	
	Electronics(String Name, float Price, int Quantity, double Weight, boolean Shipping, boolean Fragile) 
	{
		super(Name, Price, Quantity, Weight, Shipping);
		fragile = Fragile;
	}

	// Variables, constructors etc. here.
	
	//Implement calculate price/print methods as necessary

}

