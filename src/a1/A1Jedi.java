package a1;

import java.util.Scanner;

public class A1Jedi {

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
		
		// gather amount sold of a particular item
		// gather amount of people that have bought a particular item
		
		
		int[] storeItemsSold = new int[itemNames.length];
		int[] customerBoughtCount = new int[itemNames.length];
		
		for (int i = 0; i < itemNames.length; i++) {
			
			for (int x = 0; x < custCount; x++) {
				
				for(int xx = 0; xx < nameArr[x].length; xx++) {
					
					if (itemNames[i].equals(nameArr[x][xx])) {
						customerBoughtCount[i]++;
						xx = nameArr[x].length;
					}
				}
			}
			
			for (int x = 0; x < custCount; x++) {
				
				for (int xx = 0; xx < nameArr[x].length; xx++) {
					
					if (itemNames[i].equals(nameArr[x][xx])) {
						
						storeItemsSold[i] = storeItemsSold[i] + quantityArr[x][xx];
					}
				}
				
			}
			


		}
		
		//output
		
		for (int i = 0; i<itemNames.length; i++) {
			
			if (customerBoughtCount[i] == 0) {
				System.out.println("No customers bought " + itemNames[i]);
			} else {
				System.out.println(customerBoughtCount[i] + " customers bought " + storeItemsSold[i] + " " + itemNames[i]);
		
			}
			
			
		}
		
		
	}
}
