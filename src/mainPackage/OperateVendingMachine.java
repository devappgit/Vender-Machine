package mainPackage;

import java.math.BigDecimal;
import java.util.Scanner;

public class OperateVendingMachine {
	
	private static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		
		// Load items to Vending machine
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.loadItems(Util.loadItems());
		
		//Enter the name of the item wanted to purchase
        System.out.println("Enter the item name:");
        String name = scan.nextLine();
        
        System.out.println("Enter the amount paid: ");
        BigDecimal amountPayed = scan.nextBigDecimal();
                
        //Purchase item from vending machine
        vendingMachine.purchaseItem(name, amountPayed);
        
        vendingMachine.restockItems(Util.reloadItems());

	}
}
