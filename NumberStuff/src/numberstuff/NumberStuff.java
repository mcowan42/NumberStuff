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
	
	public static void Buffon(){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of trials to simulate:");
		float n = in.nextFloat();
		int success = 0;
		for(int i=0; i<n; i++){
			double theta = Math.toRadians(Math.random()*360);
			double x = Math.random();
			if ((1-x)<=Math.sin(theta)){
				success++;
			}
		}
		double p = 2*n/success;
		double v = Math.pow((p-Math.PI),2);
		System.out.println("The calculated value of pi is "+p);
		System.out.println("The variance of this value from the accepted value is "+v);
		in.close();
	}
	
//	public static void Poly(){
//		Scanner in = new Scanner(System.in);
//		System.out.println("Enter the degree of the polynomial to be divided (the dividend):");
//		int deg1 = in.nextInt();
//		int[] poly1 = new int[deg1+1];
//		for (int i=0; i<=deg1; i++){
//			System.out.println("Enter the coefficent of the x^"+(deg1-i)+" term");
//			poly1[i] = in.nextInt();
//		}
//		System.out.println("Enter the degree of the polynomial being divided by (the divisor):");
//		int deg2 = in.nextInt();
//		while (deg2>deg1){
//			System.out.println("The divisor degree must be smaller than the dividend degree.");
//			System.out.println("Enter the degree of the polynomial being divided by (the divisor):");
//			deg2 = in.nextInt();
//		}
//		int[] poly2 = new int[deg2+1];
//		for (int j=0; j<=deg2; j++){
//			System.out.println("Enter the coefficent of the x^"+(deg2-j)+" term");
//			poly2[j] = in.nextInt();
//		}
//		int[] q = poly1;
//		int norm = poly2[0];
//		for (int k=0; k<(deg1-deg2-1); k++){
//			q[k]/=norm;
//			if (q[k]!=0){
//				for (int m=1; m<deg2;m++){
//					q[k+m]+=-1*poly2[m]*q[k];
//				}
//			}
//		}
//		System.out.print("The result is: ");
//		for (int i=0; i<(deg2-1); i++){
//			System.out.print(q[i]+"x^"+(deg1-i)+"+");
//		}
//		for (int i=(deg2-1); i<deg1; i++){
//			System.out.print("("+q[i]+"x^"+(deg1-i)+"+");
//		}
//		System.out.print(q[deg1]+")/(");
//		for (int i=0; i<deg1; i++){
//			System.out.print(poly1[i]+"x^"+(deg1-i)+"+");
//		}
//		System.out.print(poly1[deg1]+")");
//		System.out.print("\n");
//		in.close();
//	}
	
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		
		System.out.println("What would you like to do?");
		System.out.println("1. Find the prime factorization a number (must be an integer between 2 and 2,147,483,647)");
		System.out.println("2. Reduce a fraction to lowest terms");
		System.out.println("3. Approximate the value of pi using Buffon's needle");
		System.out.println("4. Divide two polynomials");
		
		int selection = input.nextInt();
		if (selection == 1){
			PrimeFactor();
		}else if (selection == 2){
			reduce();
		}else if (selection == 3){
			Buffon();
		}else if (selection == 4){
			Poly();
		}
	}
}
