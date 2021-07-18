import java.io.*;
import java.util.*;
class EA
{
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		long r1=0,r2=0,r=0,a=0,b=0,q=0;
		System.out.println("");
		System.out.print("Enter two numbers:");
		r1=sc.nextLong();
		r2=sc.nextLong();
		
		a=r1;b=r2;
		String s="                    ";
		System.out.println("");

		System.out.println((s.substring(0,19)+"q")+" "+(s.substring(0,18)+"r1")+" "+(s.substring(0,18)+"r2")+" "+(s.substring(0,19)+"r"));
		System.out.println("");
		while(r2!=0)
		{
			q=r1/r2;
			r=r1%r2;
			System.out.println((s.substring(0,20-(""+q).length())+q)+" "+(s.substring(0,20-(""+r1).length())+r1)+" "+(s.substring(0,20-(""+r2).length())+r2)+" "+(s.substring(0,20-(""+r).length())+r));
			r1=r2;
			r2=r;			
		}
		System.out.println(s+" "+(s.substring(0,20-(""+r1).length())+r1)+" "+(s.substring(0,20-(""+r).length())+r)+"");
		System.out.println("");
		System.out.println("GCD of numbers "+a+" and "+b+" is "+r1);
	}
}