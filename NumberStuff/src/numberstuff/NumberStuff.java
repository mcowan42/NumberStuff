package numberstuff;

import java.util.Scanner;
import java.util.LinkedList;

public class NumberStuff {

	private static void PrimeFactor(){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number to be factored:");
		int n = in.nextInt();
		int o = n;
		LinkedList factors = new LinkedList();
		int i=2;
		while(i<=n){
			if (n%i==0){
				factors.add(i);
				n=n/i;
			}else{
				i++;
			}
		}
		if (factors.size()==1){
			System.out.println(o+" is prime.");
		}else{
			System.out.println("The prime factorization of "+o+" is:");
			String out = "";
			for (int j=0; j<factors.size(); j++){
				out = out+factors.get(j)+",";
			}
			System.out.println(out);
		}
		in.close();
	}
	
	private static void reduce(){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the numerator of the fraction: ");
		int num = in.nextInt();
		System.out.println("Enter the denominator of the fraction: ");
		int den = in.nextInt();
		int i = 2;
		while (i<=Math.min(num, den)){
			if (num%i==0 && den%i==0){
				num=num/i;
				den=den/i;
			}else{
				i++;
			}
		}
		System.out.println("The reduced fraction is: "+num+"/"+den);
		in.close();
	}
	
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		
		System.out.println("What would you like to do?");
		System.out.println("1. Find the prime factorization a number (must be an integer between 2 and 2,147,483,647)");
		System.out.println("2. Reduce a fraction to lowest terms");
		
		int selection = input.nextInt();
		if (selection == 1){
			PrimeFactor();
		}else if (selection == 2){
			reduce();
		}
	}
}
