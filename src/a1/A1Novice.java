package a1;

import java.util.Scanner;



public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		// Receives total customer amount input
		int count = scan.nextInt();
		
		// Creates a a string array for first names
		
		String[] fname = new String[count];
		
		// Creates a string array for last names
		
		String[] lname = new String[count];
		
		/* creates an int array for the total
		 * number of items each customers has
		 */
		
		int[] total = new int[count];
		
		// creates an array of total costs
		
		double[] totalCost = new double[count];
		
		/* creates an array of arrays for each smaller
		 * customer detail
		 */
		
		int[][] quantityArr = new int[count][];
		String[][] nameArr = new String[count][];
		double[][] priceArr = new double[count][];

		/* Scan function that receives inputs for customers and 
		 * total items along with item details
		 */
		
		for(int i = 0; i<count; i++) {
			fname[i] = scan.next();
			lname[i] = scan.next();
			total[i] = scan.nextInt();
			quantityArr[i] = new int[total[i]];
			nameArr[i] = new String[total[i]];
			priceArr[i] = new double[total[i]];
		
			double sumCost = 0;
				for(int ii = 0; ii<total[i]; ii++) {
					quantityArr[i][ii] = scan.nextInt();
					nameArr[i][ii] = scan.next();
					priceArr[i][ii] = scan.nextDouble();
					for(int iii = 0; iii<quantityArr[i][ii]; iii++) {
					sumCost = sumCost + priceArr[i][ii];
					}
			}
			totalCost[i] = sumCost;
		}
		
		scan.close();
		
		for(int i = 0; i<count; i++) {
			System.out.println(fname[i].charAt(0) + ". " + lname[i] + ": " + String.format("%.2f",(double) totalCost[i]));
		}
	
	}
}
