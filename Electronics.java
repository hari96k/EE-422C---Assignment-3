package Assignment3;

public class Electronics extends Item 
{
	protected boolean fragile;
	protected String state;
	
	Electronics(String Name, float Price, int Quantity, double Weight, boolean Fragile, String State) 
	{
		super(Name, Price, Quantity, Weight, Fragile);
		fragile = Fragile;
		state = State;
	}
	
	float calculatePrice () 
	{
		// For tax free states
		if (state == "TX" || state == "NM" || state == "VA" || state == "AZ" || state == "AK"){
			float standardShipping = (float) ((20*weight)*quantity);
			//final price = ( Premium shipping OR Standard Shipping determined by fragility) 
			return (float) ( fragile ? 1.2*standardShipping : standardShipping);
		}
		// For all other states
		else {
			float standardShipping = (float) ((20*weight)*quantity);
			//final price = ( Premium shipping OR Standard Shipping determined by fragility) 
			return (float) ( price*1.1 + (fragile ? 1.2*standardShipping : standardShipping));			
		}
	}

}

