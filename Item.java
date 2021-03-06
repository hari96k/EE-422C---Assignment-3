package Assignment3;

public class Item 
{
	protected String name;
	protected float price;
	protected long quantity;
	protected long weight;
	protected boolean shipping;
	

	Item (String Name, float Price, long Quantity, long Weight, boolean Shipping)
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
	

	String getName(){
		return name;
	}

}
