import java.io.*;
import java.util.*;
class EEA
{
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		long r1=0,r2=0,r=0,a=0,b=0,q=0,t1=0,t2=1,s1=1,s2=0,ss=0,t=0;
		System.out.println("");
		System.out.print("Enter two numbers:");
		r1=sc.nextLong();
		r2=sc.nextLong();
		
		a=r1;b=r2;
		String s="                ";
		System.out.println("");

		System.out.println((s.substring(0,15)+"q")+" "+(s.substring(0,14)+"r1")+" "+(s.substring(0,14)+"r2")+" "+(s.substring(0,15)+"r")+" "+(s.substring(0,14)+"s1")+" "+(s.substring(0,14)+"s2")+" "+(s.substring(0,15)+"s")+" "+(s.substring(0,14)+"t1")+" "+(s.substring(0,14)+"t2")+" "+(s.substring(0,15)+"t")+" ");
		System.out.println("");
		while(r2!=0)
		{
			q=r1/r2;
			r=r1%r2;
			ss=s1-q*s2;
			t=t1-q*t2;
			System.out.println((s.substring(0,16-(""+q).length())+q)+" "+(s.substring(0,16-(""+r1).length())+r1)+" "+(s.substring(0,16-(""+r2).length())+r2)+" "+(s.substring(0,16-(""+r).length())+r)+" "+(s.substring(0,16-(""+s1).length())+s1)+" "+(s.substring(0,16-(""+s2).length())+s2)+" "+(s.substring(0,16-(""+ss).length())+ss)+" "+(s.substring(0,16-(""+t1).length())+t1)+" "+(s.substring(0,16-(""+t2).length())+t2)+" "+(s.substring(0,16-(""+t).length())+t));
			r1=r2;
			r2=r;
			s1=s2;
			s2=ss;
			t1=t2;
			t2=t;
		}
		System.out.println(s+" "+(s.substring(0,16-(""+r1).length())+r1)+" "+(s.substring(0,16-(""+r2).length())+r2)+" "+s+" "+(s.substring(0,16-(""+s1).length())+s1)+" "+(s.substring(0,16-(""+s2).length())+s2)+" "+s+" "+(s.substring(0,16-(""+t1).length())+t1)+" "+(s.substring(0,16-(""+t2).length())+t2)+" ");
		System.out.println("");
		System.out.println("GCD of numbers "+a+" and "+b+" is "+r1);
		System.out.println("Value of S is "+s1);
		System.out.println("Value of T is "+t1);
	}
}