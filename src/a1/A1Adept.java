package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		// Part 1 create store stock pile arrays
		
		int itemCount = scan.nextInt();
		
		String itemNames[] = new String[itemCount];
		
		Double itemPrices[] = new Double[itemCount];
		
		// Part 2 Obtain item specifics (names are a single word)
		
		for(int i = 0; i<itemCount; i++) {
			itemNames[i] = scan.next();
			itemPrices [i] = scan.nextDouble();
			
		}
		
		// part 2 create customer roster arrays
		
		int custCount = scan.nextInt();
		
		String[] fnames = new String[custCount];
		
		String[] lnames = new String[custCount];
		
		int[][] quantityArr = new int[custCount][];
		
		String[][] nameArr = new String[custCount][];
		
		int[] total = new int[custCount];
		
		// part 3 obtain info on each customer
		
		for (int i = 0; i<custCount; i++) {
			fnames[i] = scan.next();
			lnames[i] = scan.next();
			total[i] = scan.nextInt();
			
			quantityArr[i] = new int[total[i]];
			nameArr[i] = new String[total[i]];
			
			for(int ii = 0; ii<total[i]; ii++) {
				quantityArr[i][ii] = scan.nextInt();
				nameArr[i][ii] = scan.next();
			}
		}
		
		scan.close();
		
		System.out.println(biggestSpender(itemNames, itemPrices, custCount, fnames, lnames, nameArr, quantityArr));
		System.out.println(smallestSpender(itemNames, itemPrices, custCount, fnames, lnames, nameArr, quantityArr));
		System.out.println(averageSpender(itemNames, itemPrices, custCount, fnames, lnames, nameArr, quantityArr));
		
	}
	
	// creating methods area
	// search for the biggest spender method returns customer of id 0 with a bill of id 0 if nothing works
	static String biggestSpender(String[] itemNames, Double[] itemPrices, int custCount, String[] fnames, String[] lnames, String[][] nameArr, int[][] quantityArr) {
		
		int fatCustomerID = 0;
		double thiccBill = 0;
		for (int i = 0; i < quantityArr[0].length; i++) {
			thiccBill = thiccBill + (priceFinder(itemNames, itemPrices, nameArr[0][i]) * quantityArr[0][i]);
			};
		
		for(int i = 0; i<custCount; i++) {
			
			double bill = 0;
					
			for(int ii = 0; ii < quantityArr[i].length; ii++) {
				
				bill = bill + (priceFinder(itemNames, itemPrices, nameArr[i][ii]) * quantityArr[i][ii]);
			}
			
			if (bill >= thiccBill) { 
				thiccBill = bill;
				fatCustomerID = i;
			}
		}
		
		return "Biggest: " +  fnames[fatCustomerID] + " " + lnames[fatCustomerID] + " " + "(" + String.format("%.2f",(double) thiccBill) + ")";
				
	}
	
	// smallest spender method returns customer of id 0 with a bill of id 0 if nothing works
	
	static String smallestSpender(String[] itemNames, Double[] itemPrices, int custCount, String[] fnames, String[] lnames, String[][] nameArr, int[][] quantityArr) {
		
		int skinnyCustomerID = 0;
		double smolBill = 0;
				
		for (int i = 0; i < quantityArr[0].length; i++) {
			smolBill = smolBill + (priceFinder(itemNames, itemPrices, nameArr[0][i]) * quantityArr[0][i]);
			};
		
		for(int i = 0; i<custCount; i++) {
			
			double countbill = 0;
					
			for(int ii = 0; ii < quantityArr[i].length; ii++) {
				
				countbill = countbill + (priceFinder(itemNames, itemPrices, nameArr[i][ii]) * quantityArr[i][ii]);
				
			}
			
			if (countbill <= smolBill) { 
				smolBill = countbill;
				skinnyCustomerID = i;
			}
		}
		
		return "Smallest: " +  fnames[skinnyCustomerID] + " " + lnames[skinnyCustomerID] + " " + "(" + String.format("%.2f",(double) smolBill) + ")";
				
	}
	
	// average spent amount finder
	
	static String averageSpender(String[] itemNames, Double[] itemPrices, int custCount, String[] fnames, String[] lnames, String[][] nameArr, int[][] quantityArr) {
		
		double realFatBill = 0;
		
		for (int i = 0; i < custCount; i++) {
			for(int ii = 0; ii < quantityArr[i].length; ii++) {
				
				realFatBill = realFatBill + (priceFinder(itemNames, itemPrices, nameArr[i][ii]) * quantityArr[i][ii]);
				
			}
			
		}
		
		
		
		return "Average: " + String.format("%.2f",(double) (realFatBill/custCount));
	}
	
	// price finder method
	
	static Double priceFinder(String[] itemNames, Double[] itemPrices, String nameArr) {
		
		for(int i = 0; i<itemNames.length; i++) {
			if (itemNames[i].equals(nameArr)) {
				return itemPrices[i];
			}
		}
		return 696969.00;
	}
	
	
	
}
