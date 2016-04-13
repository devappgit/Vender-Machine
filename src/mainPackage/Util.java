package mainPackage;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Util {
	
	/**
	 * Helper class to display the return amount in exact coins and their denominations
	 * @param amountPayed
	 * @param price
	 * @return
	 */
	public static Map<Denomination, Integer> getChange(BigDecimal amountPayed, BigDecimal price) {
        BigDecimal change = amountPayed.subtract(price);
        System.out.println("Return change -- "+ change);
        Map<Denomination, Integer> changeReturn = new LinkedHashMap<Denomination, Integer>();
        for(Denomination denomination : Denomination.values()) {

            BigDecimal[] values = change.divideAndRemainder(denomination.value, MathContext.DECIMAL32);
            if(!values[0].equals(BigDecimal.valueOf(0.0)) && !values[1].equals(BigDecimal.valueOf(0.0))) {
                changeReturn.put(denomination, values[0].intValue());
                change = values [1];
            }

        }
        return changeReturn;
    }
	
	public static HashMap<String, Item> loadItems(){
		HashMap<String, Item> itemsMap = new HashMap<String, Item>();
		itemsMap.put("Snickers", new Item("Snickers", new BigDecimal(0.75), 10));
		itemsMap.put("Milkyway", new Item("Milkyway", new BigDecimal(0.65), 20));
		itemsMap.put("Lays", new Item("Milkyway", new BigDecimal(1.65), 15));
		itemsMap.put("Cheetos", new Item("Milkyway", new BigDecimal(2.45), 20));
		return itemsMap;
	}
	
	public static ArrayList<Item> reloadItems(){
		ArrayList<Item> itemsList = new ArrayList<Item>();
		itemsList.add(new Item("Hersheys", new BigDecimal(1.00), 10));
		itemsList.add(new Item("Kitkat", new BigDecimal(0.25), 10));
		itemsList.add(new Item("coke", new BigDecimal(0.75), 5));
		return itemsList;
	}
	
	public static enum Denomination {
        FIVE(BigDecimal.valueOf(5)),
        ONE(BigDecimal.valueOf(1)),
        QUARTER(BigDecimal.valueOf(0.25)),
        DIME(BigDecimal.valueOf(0.10)),
        NICKEL(BigDecimal.valueOf(0.5)),
        PENNY(BigDecimal.valueOf(0.1));

        private BigDecimal value;

        Denomination(BigDecimal value) {
            this.value = value;
        }
    }
	
}
