package Assignment3;

public class Clothing extends Item 
{

	// variables, constructors as necessary
	
	Clothing(String Name, float Price, int Quantity, double Weight, boolean Shipping)
	{
		super(Name, Price, Quantity, Weight, Shipping);
	}

	float calculatePrice () 
	{
		float final_price = 0;
		// Insert price calculation here
		return final_price;
	}
	
	void printItemAttributes () 
	{
		//Print all applicable attributes of this sub-class
	}
	

}
