package mainPackage;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mainPackage.Util.*;

public class VendingMachine {
	private HashMap<String, Item> itemsMap = new HashMap<String, Item>();
	
	/**
	 * Method which restocks items in the vending machine
	 * @param newItemsList
	 */
	public void restockItems(ArrayList<Item> newItemsList){
		for(Item newItems: newItemsList){
			Item existingItems =  itemsMap.get(newItems.getName());
			if(existingItems == null){
				//insert items to vending machine
				itemsMap.put(newItems.getName(), newItems);
			}else{
				//add additional items to existing items in the vending machine
				existingItems.setCount(existingItems.getCount()+newItems.getCount());
				itemsMap.put(newItems.getName(), existingItems);
			}
		}
	}
	
	/**
	 * Method which is used to purchase an item from vending machine
	 * @param purchaseItem
	 * @param amount
	 */
	public void purchaseItem(String purchaseItem, BigDecimal amount){
		Item items = itemsMap.get(purchaseItem);
		if(items == null || items.getCount() == 0){
			System.out.println("Wrong item selected");
			return;
		}else{
			int returnVal = amount.compareTo(items.getPrice());
			switch(returnVal){
			case 0:
				System.out.println("Price matched, No return amount");
				break;
			case 1:
				Map<Denomination, Integer>changeDue = Util.getChange(amount, items.getPrice());
				for(Denomination denomination : changeDue.keySet()) {
		            System.out.println("Return " + denomination + " bill(s) : "+ changeDue.get(denomination));
		        }
				break;
			case -1:
				System.out.println("insufficient amount. Please insert "+"amount");
			}
		}		
	}
	
	/**
	 * Method which loads all items in the vending machine initially
	 * @param items
	 */
	public void loadItems(HashMap<String, Item> items){
		itemsMap = items;
	}
}
