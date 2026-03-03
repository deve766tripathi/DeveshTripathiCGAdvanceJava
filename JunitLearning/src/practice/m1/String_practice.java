package practice.m1;

import java.util.Scanner;

/*You are developing a Restaurant Order Booking Validator that checks whether a customer’s food order is valid and calculates 
 * the total bill. The input is given as a single line in the format <FoodName>:<Size>:<Quantity>. The system must validate
 *  each field before calculating the bill. The food name should be one of the following values: Pizza, Burger, Pasta, or 
 *  Sandwich (case-insensitive). If the food name is invalid, print: The food name <name> is invalid. The size must be 
 *  exactly one of Small, Medium, or Large (case-sensitive). If the size is invalid, print: The size <size> is invalid. 
 *  The quantity must be between 1 and 5 inclusive. If the quantity is invalid, print: The quantity <quantity> is invalid. 
 *  If all validations pass, calculate the total bill based on size pricing: Small costs ₹100, Medium costs ₹150, and Large
 *   costs ₹200. Multiply the price by the quantity and print the result in the format: Total bill: ₹<amount>. The program 
 *   should stop validation as soon as the first error is found and display only that error message; otherwise, it should 
 *   display the total bill.*/

public class String_practice {
	String foodname;
	String Size;
	int quantity;
	public String_practice(String foodname,String Size,int quantity) {
		this.foodname=foodname;
		this.Size=Size;
		this.quantity=quantity;
	}
	public void validate() {
		switch(foodname) {
		case "Pizza":
			System.out.println("Valid FoodName");
			break;
		
		case "Burger":
			System.out.println("Valid FoodName");
			break;
		
		case "Sandwitch":
			System.out.println("Valid FoodName");
			break;
		
		case "Pasta":
			System.out.println("Valid FoodName");
			break;
		
		default:
			System.out.println("Invalid Input");
			break;
		}
		if((Size.equalsIgnoreCase("Large"))||(Size.equalsIgnoreCase("Large"))||(Size.equalsIgnoreCase("Large"))){
			System.out.println("Valid Size");
		}
		else {
			System.out.println("Invalid Input");
		}
		if(quantity<=5) {
			System.out.println("Valid Quantity");
		}
		else {
			System.out.println("Invalid Quantity");
		}
		int price=0;
		if(Size.equals("Large")){
			price=200;
	}
		if(Size.equals("Medium")){
			price=150;
	}
		if(Size.equals("Small")){
			price=100;
	}
		int total=price*quantity;
		System.out.println("Total Bill: "+total);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// Pizza:Medium:2
		String order = sc.next();
		String[] orderFormat = order.split(":");
		
		String foodName = orderFormat[0];
		String size = orderFormat[1];
		int quantity = Integer.parseInt(orderFormat[2]);
		
		String_practice s=new String_practice(foodName, size, quantity);
		s.validate();
		
		sc.close();

	}
}

