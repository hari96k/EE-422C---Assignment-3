package Assignment3;

public class Clothing extends Item 
{

	Clothing(String Name, float Price, long Quantity, long Weight)
	{
		// No premium shipping for clothes
		super(Name, Price, Quantity, Weight, false);
	}

	//Uses calculatePrice of Item class
}
