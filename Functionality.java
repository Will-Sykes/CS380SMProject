import java.util.*;

public class Functionality {
	
	// class properties 
	
	/*
	 * properties formated for display purposes
	 * hashmap to be used only for display purposes
	 * arraylist to be used to keep track of what is being ordered in what order
	 */
	private HashMap<String, Integer> orderDisplay;
	private ArrayList<String> orderDisplayArray;
	private ArrayList<String> orderArray;// arraylist to keep track of the order formated for the database
	private float total;// keeps track of the customers total 
	
	
	/*
	 * constructor
	 */
	public Functionality(){
		orderDisplay = new HashMap<String, Integer>();
		orderArray = new ArrayList<String>();
		orderDisplayArray = new ArrayList<String>();
		total = (float) 0.0;
	}
	
	// methods for unit testing
	public String getOrderDisplayHash() {
		return orderDisplay.toString();
	}
	public String getOrderDisplayArray() {
		return orderDisplayArray.toString();
	}
	public String getOrderArray() {
		return orderArray.toString();
	}
	public float getTotal() {
		return total;
	}
	public void clear() {
		orderDisplay.clear();
		orderDisplayArray.clear();
		orderArray.clear();
		total = (float) 0.0;
	}
	
	/*
	 * adds 1 of a certain food item to cart 
	 * @param the item to add to the cart
	 * @param quanitity of items to add to the cart
	 */
	public void addToCart(String food, Integer quanitity) {
		boolean canAdd = true;
		try{
			Float.parseFloat(CustomerLineDatabase.getPrice(food));
		}catch(Exception e) {
			canAdd = false;
		}
		if(canAdd && quanitity > 0) {
			if(orderDisplay.containsKey(food)) {
				orderDisplay.put(food, orderDisplay.get(food) + quanitity);
				orderDisplayArray.add(food);
				addtoTotal(food, quanitity);
			}else {
				String orderString = "|" + quanitity.toString() + " " + food;
				orderDisplay.put(food, quanitity);
				orderArray.add(orderString);
				orderDisplayArray.add(food);
				addtoTotal(food, quanitity);
			}
		}
	}
	
	/*
	 * adds a certain drink item to cart 
	 * @param the item to add to the cart
	 * @param quanitity of items to add to the cart
	 * @param mod is the customizations made to the item
	 */
	public void addToCart(String drink, String mod, Integer quanitity) {
		boolean canAdd = true;
		try{
			Float.parseFloat(CustomerLineDatabase.getPrice(drink));
		}catch(Exception e) {
			canAdd = false;
		}
		if(canAdd && quanitity > 0) {
		
			String item = drink + ": " + mod.substring(2, mod.length());
			if(orderDisplay.containsKey(item)) {
				orderDisplay.put(item, orderDisplay.get(item) + quanitity);	
				orderDisplayArray.add(item);
				addtoTotal(drink, quanitity);
			}else {
				String orderString = "|" + quanitity.toString() + " " + item.substring(0, item.length() - 2);
				orderDisplay.put(item, quanitity);
				orderArray.add(orderString);
				addtoTotal(drink, quanitity);
				for(int i = 0; i < quanitity; i++) {
					orderDisplayArray.add(item); 
				}
			}
		}
	}
	
	/*
	 * remove the last entered item from the cart
	 */
	public void remove() {
		if (!orderDisplayArray.isEmpty()) {
	        String lastEnteredItem = orderDisplayArray.get(orderDisplayArray.size() - 1);
	        if(lastEnteredItem.contains(":")) {
	        	// because of the way each item is formatted, we only care about the name of the item, not its modifications
	        	// so everything from the ":" and on should be dropped and decrement the the price of the last ordered item from the total
	        	String[] parts = lastEnteredItem.split(":");
	        	total -= Float.parseFloat(CustomerLineDatabase.getPrice(parts[0].trim()));
	        }else {
	        	total -= Float.parseFloat(CustomerLineDatabase.getPrice(lastEnteredItem));
	        }
	        //if there is more then 1 of that item, decrement it by 1, 
	        // if there is only 1 of that item, delete the item decrement the the price of the last ordered item from the total
	        Integer count = orderDisplay.get(lastEnteredItem);
	        if (count > 0) {
	            orderDisplay.put(lastEnteredItem, count - 1);
	            orderArray.set(orderArray.size() -1, "|" + Integer.toString(count -1 ) + " " + lastEnteredItem.substring(0, lastEnteredItem.length() - 2) );
	            if (count <= 1 ) {
	                orderDisplay.remove(lastEnteredItem);
	                orderArray.remove(orderArray.size()-1);
	                
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
	
	/*
	 * sanitize user inputs and make sure only letters are entered
	 */
	public boolean santizie(String firstN, String lastN) {
		// check if the strings are invalid 
		boolean isInvalid = false;
		
		// make sure the strings contain at least 1 letter
		int letterCounterFName = 0;
		int letterCounterLName = 0;
		
		//check the first name
		char[] chars = firstN.toCharArray();
	    for (char c : chars) {
	        if(!Character.isLetter(c) && c != ' ') {
	            isInvalid = true;
	            
	        }else if(Character.isLetter(c)) {
	        	letterCounterFName ++;
	        }
	    }
	    
	    // check the last name
	    chars = lastN.toCharArray();
	    for (char c : chars) {
	        if(!Character.isLetter(c) && c != ' ') {
	            isInvalid = true;
	        }else if(Character.isLetter(c)) {
	        	letterCounterLName ++;
	        }
	    }
	    
	    // check if either strings is missing at least 1 letter
	    if(letterCounterFName <= 0|| letterCounterLName <= 0) {
	    	isInvalid = true;
	    }
	    return isInvalid;
	}
	
	/*
	 * get the price and only keep the 2nd decimal place ex: .00
	 * @return the price with only 2 decimal places
	 */
	public String getPrice() {
		return "$" + String.format("%.2f", total);
	}
	
	/*
	 * add the to the total: the price of a certain item multiplies by the amount of that item
	 * @param item is what price we are looking for 
	 * @param is how many of that item we want
	 */
	public void addtoTotal(String item, int quant) {
		total += quant * Float.parseFloat(CustomerLineDatabase.getPrice(item));
	}

	/*
	 * add an order to the database
	 * @param fname is the first name of the 
	 */
	public void order(String fName, String lName) {
		// format the order
		StringBuilder finalOrder = new StringBuilder();
		for(String item: orderArray) {
			finalOrder.append(item);
		}
		//format the order
		CustomerLineDatabase.makeOrder(fName.toUpperCase(), lName.toUpperCase(), finalOrder.toString());
		
		// clear everything
		orderDisplay.clear();
		orderDisplayArray.clear();
		orderArray.clear();
		total = (float) 0.0;
	}
	
}
