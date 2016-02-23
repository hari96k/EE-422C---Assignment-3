package Assignment3;

public class Item 
{
	protected String name;
	protected float price;
	protected int quantity;
	protected int weight;
	protected boolean shipping;
	

	Item (String Name, float Price, int Quantity, int Weight, boolean Shipping)
	{		
		name = Name;
		price = Price;
		quantity = Quantity;
		weight = Weight;
		shipping = Shipping;
	}
	
	float calculatePrice () 
	{
		float standardShipping = (float) ((20*weight)*quantity);
		//final price =	  Taxes     +               ( Premium shipping OR Standard Shipping ) 
		return (float) (price*1.1*quantity + ( shipping ? 1.2*standardShipping : standardShipping));
	}
	

	void printItemAttributes () 
	{
		//Print all applicable attributes of this class
	}
	
	String getName(){
		return name;
	}

}
