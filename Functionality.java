import java.util.*;

public class Functionality {
	
	// class properties 
	private HashMap<String, Integer> orderDisplay; // hashmap to be used only for display purposes
	private ArrayList<String> orderArray;
	private ArrayList<String> orderDisplayArray;
	private StringBuilder finalOrder = new StringBuilder();
	private float total;
	
	Order_database order;
	
	// constructor
	public Functionality(){
		orderDisplay = new HashMap<String, Integer>();
		orderArray = new ArrayList<String>();
		orderDisplayArray = new ArrayList<String>();
		total = (float) 0.0;
		order= new Order_database();
	}
	
	
	public void addToCart(String food, Integer quanitity) {
		
		if(orderDisplay.containsKey(food)) {
			orderDisplay.put(food, orderDisplay.get(food) + 1);
			orderDisplayArray.add(food);
		}else {
			String orderString = "|" + quanitity.toString() + " " + food;
			orderDisplay.put(food, quanitity);
			orderArray.add(orderString);
			orderDisplayArray.add(food);
		}
	}
	public void addToCart(String drink, String mod, Integer quanitity) {
		
		String item = drink + ": " + mod.substring(2, mod.length());
		
		if(orderDisplay.containsKey(item)) {
			orderDisplay.put(item, orderDisplay.get(item) + 1);	
			orderDisplayArray.add(item);
		}else {
			String orderString = "|" + quanitity.toString() + " " + item.substring(0, item.length() - 2);
			orderDisplay.put(item, quanitity);
			orderArray.add(orderString);
			for(int i = 0; i < quanitity; i++) {
				orderDisplayArray.add(item);
			}
		}
	}
	
	public void remove() {
		if (!orderDisplayArray.isEmpty()) {
	        String lastEnteredItem = orderDisplayArray.get(orderDisplayArray.size() - 1);
	        Integer count = orderDisplay.get(lastEnteredItem);
	        if (count > 0) {
	            orderDisplay.put(lastEnteredItem, count - 1);
	            if (count <= 1 ) {
	                orderDisplay.remove(lastEnteredItem);
	            }
	        }
	        orderDisplayArray.remove(orderDisplayArray.size() - 1);
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
	
	public boolean santizie(String firstN, String lastN) {
		boolean isInvalid = false;
		char[] chars = firstN.toCharArray();
	    for (char c : chars) {
	        if(!Character.isLetter(c)) {
	            isInvalid = true;
	        }
	    }
	    
	    chars = lastN.toCharArray();
	    for (char c : chars) {
	        if(!Character.isLetter(c)) {
	            isInvalid = true;
	        }
	    }
	    return isInvalid;
	}
	
	public void order(String fName, String lName) {
		for(String item: orderArray) {
			finalOrder.append(item);
		}
		String grandTotal = "" + this.total;
		Order_database order = new Order_database();
		order.OrderAdd(fName, lName, finalOrder.toString(), grandTotal);
	}
	
	public float getPrice(String item) {
		String menuPrices = order.PrintPriceCheckPanel();
		String[] lines = menuPrices.split("\n");
		
		for (String line : lines) {
		    String[] part = line.split(" ");
		    String menuItem = part[0];
		    double price = Double.parseDouble(part[1]);
		    
		    if(item.equals(menuItem)) {
		    	this.total += price;
		    }
		}
		
		return this.total;
	}
	
	
	
}
