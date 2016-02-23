package Assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class A3Driver {

	public static void main(String[] args) {
		if (0 < args.length) {
			String filename = args[0];
			ShoppingCart cart = new ShoppingCart();

			try {
				FileReader freader = new FileReader(filename);
				BufferedReader reader = new BufferedReader(freader);

				for (String line = reader.readLine(); line != null; line = reader.readLine()) {
					// Parse and process input
					processInput(line, cart);
				}
				reader.close();
			} catch (FileNotFoundException e) {
				System.err.println("Error: File not found. Exiting...");
				e.printStackTrace();
				System.exit(-1);
			} catch (IOException e) {
				System.err.println("Error: IO exception. Exiting...");
				e.printStackTrace();
				System.exit(-1);
			}
		}
	}

	// Check the validity of the input line
	// Parse the input line and call the necessary method
	public static void processInput(String input, ShoppingCart cart) {
		String[] userInput = input.split("[ ]+"); // Must be able to handle
													// multiple spaces as well

		if (isInputValid(userInput)) {
			switch (userInput[0]) {
			case "insert":
				String type = userInput[1];

				if (type.matches("electronics"))
					insertElectronics(userInput, cart);

				if (type.matches("groceries"))
					insertGroceries(userInput, cart);

				if (type.matches("clothing"))
					insertClothes(userInput, cart);

				break;
			case "search":
				search(userInput[1], cart);
				break;
			case "delete":
				delete(userInput[1], cart);
				break;
			case "update":
				update(userInput[1], Integer.parseInt(userInput[2]), cart);
				break;
			case "print":
				print(cart);
				break;
			default:
				System.out.println("Error encountered.");
				System.out.println("Proceeding to process next transaction ... ");
			}
		}

		else {
			System.out.println("Error encountered.");
			System.out.println("Proceeding to process next transaction ... ");
		}
	}

	// Majority of error handling in input line
	// Check for length of input, invalid actions, etc.
	public static boolean isInputValid(String[] input) {
		int length = input.length;
		switch (input[0]) {
		case "insert":
			String category = input[1];
			if (category.matches("groceries")) {
				if (length != 7 && length != 8)
					return false;
				if (!input[6].equals("P") && !input[6].equals("NP"))
					return false;

				return true;
			} else if (category.matches("electronics")) {
				if (length != 7 && length != 8)
					return false;
				if (!input[6].equals("F") && !input[6].equals("NF"))
					return false;

				return true;
			} else if (category.matches("clothing")) {
				if (length != 6 && length != 7)
					return false;

				return true;
			} else
				return false;

		case "search":
			if (input.length != 2)
				return false;

			return true;

		case "delete":
			if (input.length != 2)
				return false;

			return true;

		case "update":
			if (input.length != 3)
				return false;

			return true;

		case "print":
			if (input.length != 1)
				return false;

			return true;
		}
		return false;
	}

	// Overloaded the insert method 3 times - each to account for inserting
	// each of the 3 types of items (electronics, groceries, clothing)
	public static void insertElectronics(String[] input, ShoppingCart cart) {
		
		String name = input[2];
		float price = Float.parseFloat(input[3]);
		int quantity = Integer.parseInt(input[4]);
		double weight = Double.parseDouble(input[5]);
		String state = "";
		boolean fragile;
		
		if (validState(input[7]))
		{
			state = input[7];
		}
		
		else 
		{
			System.out.println("Error encountered.");
			System.out.println("Proceeding to process next transaction ... ");
			return;
		}
		
		if (input[6].matches("F"))
		{
			fragile = true;
		}

		else if (input[6].matches("NF"))
		{
			fragile = false;
		}
		
		else 
		{
			System.out.println("Error encountered.");
			System.out.println("Proceeding to process next transaction ... ");
			return;
		}

		Electronics thisElectronic = new Electronics(name, price, quantity, weight, fragile, state);
		cart.shoppingCart.add(thisElectronic);
	}

	public static void insertGroceries(String[] input, ShoppingCart cart) {
		
		String name = input[2];
		float price = Float.parseFloat(input[3]);
		int quantity = Integer.parseInt(input[4]);
		double weight = Double.parseDouble(input[5]);
		boolean perishable;
		boolean shipping;

		if (input[6].matches("P")) {
			perishable = true;
			shipping = true;
		} else if (input[6].matches("NP")) {
			perishable = false;
			shipping = false;
		} else {
			System.out.println("Error encountered.");
			System.out.println("Proceeding to process next transaction ... ");
			return;
		}
		Grocery thisGrocery = new Grocery(name, price, quantity, weight, shipping, perishable);
		cart.shoppingCart.add(thisGrocery);
	}

	public static void insertClothes(String[] input, ShoppingCart cart) {
		
		String name = input[2];
		float price = Float.parseFloat(input[3]);
		int quantity = Integer.parseInt(input[4]);
		double weight = Double.parseDouble(input[5]);

		Clothing thisClothing = new Clothing(name, price, quantity, weight);
		cart.shoppingCart.add(thisClothing);
	}

	// Search for the desired item and print results
	public static void search(String name, ShoppingCart cart) {
		
		int searchCount = 0;
		
		for (int i = 0; i < cart.shoppingCart.size(); i++) {
			if (cart.shoppingCart.get(i).name.equals(name)) {
				searchCount = searchCount + cart.shoppingCart.get(i).quantity;
			}
		}
		System.out.println(searchCount + " " + name + "(s) found");
	}

	// Delete all instances of the desired item and print results
	public static void delete(String name, ShoppingCart cart) {
		
		int deleteCount = 0;
		
		for (int i = 0; i < cart.shoppingCart.size(); i++) {
			if (cart.shoppingCart.get(i).name.equals(name)) {
				deleteCount = deleteCount + cart.shoppingCart.get(i).quantity;
				cart.shoppingCart.remove(i);
			}
		}
		System.out.println(deleteCount + " " + name + "(s) deleted");
	}

	// Update desired item and print results
	public static void update(String name, int amount, ShoppingCart cart) {
		
		for (int i = 0; i < cart.shoppingCart.size(); i++) {
			if (cart.shoppingCart.get(i).name.equals(name)) {
				cart.shoppingCart.get(i).quantity = amount;
				break;
			}
			System.out.println("Quantity of " + name + "(s) updated to: " + amount);
		}
	}

	// Printing the entire shopping cart
	public static void print(ShoppingCart cart) {
		
		Collections.sort(cart.shoppingCart, new nameComparator()); // Sort by name
		
		for (int i = 0; i < cart.shoppingCart.size(); i++) {
			System.out.println(cart.shoppingCart.get(i).quantity + " " + cart.shoppingCart.get(i).name + "(s)");
		}
	}
	
	public static boolean validState (String state)
	{
		switch(state)
		{
		case "AL": case "AK": case "AZ": case "AR": case "CA": case "CO": case "CT": case "DE": case "FL": case "GA":
		case "HI": case "ID": case "IL": case "IN": case "IA": case "KS": case "KY": case "ME": case "MD": case "MA":
		case "LA": case "MI": case "MN": case "MS": case "MO": case "MT": case "NE": case "NV": case "NH": case "NJ":
		case "NM": case "NY": case "NC": case "ND": case "OH": case "OK": case "OR": case "PA": case "RI": case "SC":
		case "SD": case "TN": case "TX": case "UT": case "VT": case "VA": case "WA": case "WV": case "WI": case "WY":
		
		return true;
		}
		
		return false;
	}
}
