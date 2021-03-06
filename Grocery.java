package Assignment3;

public class Grocery extends Item
{
	protected boolean perishable;

	
	Grocery(String Name, float Price, long Quantity, long Weight, boolean Shipping, boolean Perishable) 
	{
		super(Name, Price, Quantity, Weight, Shipping);
		perishable = Perishable;
	}

	float calculatePrice () {
		float standardShipping = (float) ((20*weight)*quantity);
		//final price = ( Premium shipping OR Standard Shipping determined by perishability) 
		return (float)  ( price*quantity + ( perishable ? 1.2*standardShipping : standardShipping) );
	}
}
