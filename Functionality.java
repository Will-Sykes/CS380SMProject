import java.util.*;

public class Functionality {
	
	// class properties 
	private HashMap<String, Integer> orderDisplay; // hashmap to be used only for display purposes
	private ArrayList<String> orderArray;
	
	// constructor
	public Functionality(){
		orderDisplay = new HashMap<String, Integer>();
		orderArray = new ArrayList<String>();
	}
	
	
	public void addToOrder(String food, Integer quanitity) {
		
		if(orderDisplay.containsKey(food)) {
			orderDisplay.put(food, orderDisplay.get(food) + 1);
		}else {
			String orderString = "|" + quanitity.toString() + " " + food;
			orderDisplay.put(food, quanitity);
			orderArray.add(orderString);
		}
	}
	public void addToOrder(String drink, String mod, Integer quanitity) {
		
		String item = drink + ": " + mod.substring(2, mod.length());
		
		if(orderDisplay.containsKey(item)) {
			orderDisplay.put(item, orderDisplay.get(item) + 1);			
		}else {
			String orderString = "|" + quanitity.toString() + " " + item.substring(0, item.length() - 2);
			orderDisplay.put(item, quanitity);
			orderArray.add(orderString);
		}
	}
	
	
	/*
	 * method to get the entire order as a string
	 */
	public String getOrder() {
		StringBuilder fullOrder = new StringBuilder();
		for(String item: orderDisplay.keySet()) {
			fullOrder.append(orderDisplay.get(item) + " ");
			fullOrder.append(item + "\n");
		}
		
		return fullOrder.toString();
	}
	
	
	
}
