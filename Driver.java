package Assignment3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Driver 
	{
	
	  public static void main(String[] args) 
	  {			  
		  if (0 < args.length) 
		  {
			  File file;
			  String filename = args[0];
			  file = new File(filename);
			  
			  try 
			  {
				  FileReader freader = new FileReader(filename);
				  BufferedReader reader = new BufferedReader(freader);
				  
				  for (String line = reader.readLine(); line != null; line = reader.readLine()) 
				  {
					  //Parse input, take appropriate actions
					  parseInput (line);
				  }
			  } 
			  catch (FileNotFoundException e) 
			  {
				  System.err.println ("Error: File not found. Exiting...");
				  e.printStackTrace();
				  System.exit(-1);
			  }
			  catch (IOException e) 
			  {
				  System.err.println ("Error: IO exception. Exiting...");
				  e.printStackTrace();
				  System.exit(-1);
			  }
		  }
	  }
	  
	  
	  // Check the validity of the input line
	  // Parse the input line and call the necessary method
	  public static void parseInput (String input)
	  {
		  String[] userInput = input.split("[\\s]");
		  
		  if (isInputValid (userInput))
		  {
			  if (userInput[0].matches("insert"))
			  {  
				  String type = userInput[1];
				  
				  if (type.matches("electronics")) insertElectronics (userInput);
				  
				  if (type.matches("groceries")) insertGroceries (userInput);
				  
				  if (type.matches("clothing")) insertClothes (userInput);
			  }
			  
			  else if (userInput[0].matches("search"))
			  {
				  String name = userInput[1];  
			  }
			  
			  else if (userInput[0].matches("delete"))
			  {
				  String name = userInput[1];
			  }			  
			  
			  else if (userInput[0].matches("update"))
			  {
				  String name = userInput[1];
			  }
			  
			  else if (userInput[0].matches("print"))
			  {
				  
			  }
		  }
		  
		  else
		  {
			  System.out.println("Error encountered.");
			  System.out.println("Proceeding to process next transaction ... ");
		  }
	  }
	  
	  
	  // Majority of error handling in input line
	  // Check for length of input, invalid actions, etc.
	  public static boolean isInputValid (String[] input)
	  {
		  int length = input.length;
		  switch (input[0])
		  {
		  case "insert": 
			  String category = input[1];
			  if (category.matches("groceries"))
			  {
				  if (length != 7 && length != 8)
					  return false;
				  if (input[5] != "P" && input[5] != "NP")
					  return false;
				  
				  return true;
			  }
			  else if (category.matches("electronics"))
			  {
				  if (length != 7 && length != 8)
					  return false;
				  if (input[5] != "F" && input[5] != "NF")
					  return false;
				  
				  return true;
			  }
			  else if (category.matches("clothing"))
			  {
				  if (length != 6 && length != 7)
					  return false;
				  
				  return true;
			  }
			  else return false;
			  
			  
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
		  }
		  
		  return false;
	  }

	  
	  // Conversts the string to float
	  public static float convertStringToFloat (String value)
	  {
		  return 0;
	  }
	  
	  
	  // Converts the string to double
	  public static double convertStringToDouble (String value)
	  {
		  try 
			{
				if (value.matches("[0123456789.]+"))
				{
					double result = Double.parseDouble(value);
					
					if (result == 0) return -1;
					
					else return result;

				}
				return -1;
			}
			
			catch (NumberFormatException nfe)
			{
				return -1;
			}
	  }
	  
	  
	  // Overloaded the insert method 3 times - each to account for inserting 
	  // each of the 3 types of items (electronics, groceries, clothing)
	  public static void insertElectronics (String[] input)
	  {
		  String name = input[2];
		  float price = convertStringToFloat(input[3]);
		  double quantity = convertStringToDouble(input[4]);
		  double weight = convertStringToDouble(input[5]);
		  boolean fragile;
		  
		  if (input[6].matches("F"))
			  fragile = true;
		  
		  else if (input[6].matches("NF"))
			  fragile = false;
		  
		  else
		  {
			  System.out.println("Error encountered.");
			  System.out.println("Proceeding to process next transaction ... ");
			  return;  
		  }
	  }
	  
	  
	  public static void insertGroceries (String[] input)
	  {
		  String name = input[2];
		  float price = convertStringToFloat(input[3]);
		  double quantity = convertStringToDouble(input[4]);
		  double weight = convertStringToDouble(input[5]);
		  boolean perishable;
		  
		  if (input[6].matches("P"))
			  perishable = true;
		  
		  else if (input[6].matches("NP"))
			  perishable = false;
		  
		  else
		  {
			  System.out.println("Error encountered.");
			  System.out.println("Proceeding to process next transaction ... ");
			  return;
		  }
	  }
	  
	  
	  public static void insertClothes (String[] input)
	  { 
		  String name = input[2];
		  float price = convertStringToFloat(input[3]);
		  double quantity = convertStringToDouble(input[4]);
		  double weight = convertStringToDouble(input[5]);
		 
	  }
	  
	  
	  // Search for the desired item and print results
	  public static void search (String name)
	  {
		  
	  }
	  
	  
	  // Delete all instances of the desired item and print results
	  public static void delete (String name)
	  {
		  
	  }
	  
	  
	  // Update desired item and print results
	  public static void update (String name, double amount)
	  {
		  
	  }
	  
	  
	  // Printing the entire shopping cart
	  public static void print ()
	  {
		  
	  }
}














