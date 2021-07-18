import java.io.*;
import java.util.*;
import java.math.*;
class RSAD
{
	public static long inverse(long a,long b)
	{
		long t1=0,t2=1,r1=a,r2=b,t=0,q=0,r=0;
		while(r2!=0)
		{
			q=r1/r2;
			r=r1%r2;
			t=t1-q*t2;
			r1=r2;
			r2=r;
			t1=t2;
			t2=t;
		}
		return t1;
	}
	public static boolean isPrime(long a)
	{
		long i=2;
		for(;i<=Math.sqrt(a);i++)
			if(a%i==0)
				break;
		if(a>Math.sqrt(a))
			return true;
		return false;
	}
	public static long gcd(long a, long b)
    {
        if (a == 0)
            return b;
		if (b == 0)
            return a;	
        return gcd(b%a, a);
    }
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		long a=0,b=0,m=0,n=0;
		System.out.print("Enter message to be decrypted.. ");
		m=sc.nextLong();
		System.out.print("Enter first prime number.. ");
		a=sc.nextLong();
		System.out.print("Enter second prime number.. ");
		b=sc.nextLong();
		if(!(isPrime(a)==true&&isPrime(b)==true))
		{
			System.out.println("Entered numbers are not prime...");
			return;
		}
		n=a*b;
		long etf=(a-1)*(b-1);
		long e=2;
		System.out.print("Want to give value for e::y/n::");
		String s=sc.next();
		if(s.equals("y"))
		{
			System.out.print("Enter value of e::");
			e=sc.nextLong();
			if(gcd(e,etf)!=1)
			{
				System.out.print("\nConditions not satisfied");
				return;
			}
		}
		else
		{
			for(;e<etf;e++)
			{
				if(gcd(e,etf)==1)
					break;
			}
		}
		long d=inverse(etf,e);
		BigInteger m1=new BigInteger(""+m);
		BigInteger d1=new BigInteger(""+d);
		BigInteger n1=new BigInteger(""+n);
		System.out.println("c:"+m+"\np:"+a+"\nq:"+b+"\nETF:"+etf+"\ne:"+e+"\nd:"+d+"\nn:"+n);
		System.out.println("Plain text:"+m1.modPow(d1,n1));
	}
}