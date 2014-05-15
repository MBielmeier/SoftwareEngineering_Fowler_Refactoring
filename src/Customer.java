import java.lang.*;
import java.util.*;

class Customer {
	private String name;
	private Vector rentals = new Vector();

	public Customer(String newname) {
		name = newname;
	};

	public void addRental(Rental arg) {
		rentals.addElement(arg);
	};

	public String getName() {
		return name;
	};

	public String statement() {
		Enumeration enum_rentals = rentals.elements();
		String result = "<H1>Rental Record for<EM> " + this.getName() + "</EM></H1><P>\n";
		result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount"
				+ "\n";

		while (enum_rentals.hasMoreElements()) {
			Rental each = (Rental) enum_rentals.nextElement();


			
			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + "\t"
					+ each.getDaysRented() + "\t" + String.valueOf(each.getCharge())
					+ "<BR>\n";
		}
		// add footer lines
		result += "<P>Amount owed is<EM> " + String.valueOf(getTotalCharge()) + "</EM><P>\n";
		result += "You earned <EM>" + String.valueOf(getTotalFrequentRenterPoints())
				+ "</EM> frequent renter points<P>";
		return result;
	}

	private double amountFor(Rental aRental){
		return aRental.getCharge();
	}
	private double getTotalCharge(){
		
		double result=0;
		
		Enumeration enum_rentals = rentals.elements();
		while(enum_rentals.hasMoreElements()){
			
			Rental each = (Rental) enum_rentals.nextElement();
			result+=each.getCharge();
		}
		
		
		
		return result;
	}
	private int getTotalFrequentRenterPoints(){
		int result =0;
		Enumeration enum_rentals = rentals.elements();
		while(enum_rentals.hasMoreElements()){
			Rental each = (Rental) enum_rentals.nextElement();
			result += each.getFrequentRenterPoints();
			
		}
		
		
		return result;
		
	}
}
