package Assignment3;

public class Clothing extends Item 
{

	Clothing(String Name, float Price, int Quantity, int Weight)
	{
		super(Name, Price, Quantity, Weight, false);
		this.calculatePrice();
	}

	float calculatePrice () 
	{
		//final price =	  Taxes     +  Standard Shipping ) 
		return (float) (price*1.1 +  (20*weight)*quantity);
	}
	
	void printItemAttributes () 
	{
		//Print all applicable attributes of this sub-class
	}
	

}
