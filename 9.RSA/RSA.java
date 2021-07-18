import java.io.*;
import java.util.*;
import java.math.*;
class RSA
{
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
		System.out.print("Enter message to be encrypted.. ");
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
		BigInteger m1=new BigInteger(""+m);
		BigInteger e1=new BigInteger(""+e);
		BigInteger n1=new BigInteger(""+n);
		System.out.println("p:"+a+"\nq:"+b+"\nETF:"+etf+"\ne:"+e);
		System.out.println("Cipher text:"+m1.modPow(e1,n1));
	}
}