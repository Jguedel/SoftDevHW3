package HW3;

import java.util.ArrayList;

public class SaleSlip {
	public static ArrayList<String> list = new ArrayList<String>();
	public static double total;
	public static double TotalCost;
	public static double Quan;
	public static double Cost;
	
	public static boolean valid;
	
	
	public static void addToList(String item, String cost, String quan) {
		valid = validCheck(item, cost, quan);
		if(valid == true) {
			SaleItem oneSlip = new SaleItem(item, cost, quan);
			Cost = Double.parseDouble(oneSlip.getCost());
			Quan = Double.parseDouble(oneSlip.getQuan());
			TotalCost = Quan * Cost;
			list.add(oneSlip.getItem());
			list.add(String.valueOf(TotalCost));
			list.add(oneSlip.getQuan());
			total = 0;
			for (int i = 1; i <= list.size(); i += 3) {
				total += Double.parseDouble(list.get(i));
				total = round(total, 2);
			}
		}
		
	}

	
	public static boolean validCheck(String item, String cost, String quan) {
		valid = true; 
		if(item.contains("1")|| item.contains("2")|| item.contains("3")|| item.contains("4")|| item.contains("5")|| item.contains("6")
				||item.contains("7")|| item.contains("8")|| item.contains("9")|| item.contains("0")) {
			valid = false;
		}
		if (cost.contains("a") || cost.contains("b") || cost.contains("c") || cost.contains("d") || cost.contains("e")
				|| cost.contains("f") || cost.contains("g") || cost.contains("h") || cost.contains("i")
				|| cost.contains("j") || cost.contains("k") || cost.contains("l") || cost.contains("m")
				|| cost.contains("n") || cost.contains("o") || cost.contains("p") || cost.contains("q")
				|| cost.contains("r") || cost.contains("s") || cost.contains("t") || cost.contains("u")
				|| cost.contains("v") || cost.contains("w") || cost.contains("x") || cost.contains("y")
				|| cost.contains("z")) {
			valid = false;
		}
		if (quan.contains("a") || quan.contains("b") || quan.contains("c") || quan.contains("d") || quan.contains("e")
				|| quan.contains("f") || quan.contains("g") || quan.contains("h") || quan.contains("i")
				|| quan.contains("j") || quan.contains("k") || quan.contains("l") || quan.contains("m")
				|| quan.contains("n") || quan.contains("o") || quan.contains("p") || quan.contains("q")
				|| quan.contains("r") || quan.contains("s") || quan.contains("t") || quan.contains("u")
				|| quan.contains("v") || quan.contains("w") || quan.contains("x") || quan.contains("y")
				|| quan.contains("z")) {
			valid = false;
		}
		return valid;
	}
	
	
	public static double round(double total, int holder) {
		double scale = Math.pow(10, holder);
		return Math.round(total * scale)/scale;
	}

	
	public static double getTotal() {
		return total;
	}

	
	public static ArrayList<String> getList() {
		return list;
	}
	public static boolean isValid() {
		return valid;
	}
	
}