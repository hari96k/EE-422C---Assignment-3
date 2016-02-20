package Assignment3;

public class Item 
{
	protected String name = "";
	protected float price;
	protected int quantity;
	protected double weight;
	protected boolean shipping;
	

// You will need a constructor (Why?). Create it here.
	
	Item (String Name, float Price, int Quantity, double Weight, boolean Shipping)
	{
		name = Name;
		if (Price != -1 && Quantity != -1 && Weight != -1)
		{
			price = Price;
			quantity = Quantity;
			weight = Weight;
		}
		shipping = Shipping;
	}
	
	float calculatePrice () 
	{
		float final_price = 0;
		// Insert price calculation here
		return final_price;
	}
	

	void printItemAttributes () 
	{
		//Print all applicable attributes of this class
	}

}
