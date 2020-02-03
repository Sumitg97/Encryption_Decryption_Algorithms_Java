import java.io.*;
import java.util.*;
class CRTT
{
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
		System.out.print("Enter value of n::");
		int l=sc.nextInt();
		int i=0,j=0,k=0;
		long r1=0,r2=0,r=0,aa=0,b=0,q=0,t1=0,t2=1,t=0,M=1;
		long a[]=new long[l];
		long y[]=new long[l];
		long m[]=new long[l];
		long n[]=new long[l];
		for(i=0;i<l;i++)
		{
			System.out.println("Enter values of a"+(i+1)+" and n"+(i+1));
			a[i]=sc.nextLong();
			n[i]=sc.nextLong();
		}
		for(i=0;i<l;i++)
		{
			for(j=i+1;j<l;j++)
			{
				if(gcd(n[i],n[j])!=1)
					break;
			}
			if(j<l)
				break;
		}
		if(i<l)
		{
			System.out.println("");
			System.out.println("All numbers are not co-prime ...");
			return; 
		}
		String s="            ";
		for(i=0;i<l;i++)
			M*=n[i];
		System.out.println("M : "+M);
		for(i=0;i<l;i++)
		{
			m[i]=M/n[i];
			System.out.println("m"+(i+1)+": "+m[i]);
		}
		System.out.println("");
		
		for(i=0;i<l;i++)
		{
			
			t1=0;
			t2=1;
			t=0;
			aa=n[i];b=m[i];
			r1=aa;
			r2=b;
			System.out.println("Finding Y"+(i+1));
			System.out.println("");
			System.out.println((s.substring(0,11)+"q")+" "+(s.substring(0,10)+"r1")+" "+(s.substring(0,10)+"r2")+" "+(s.substring(0,11)+"r")+" "+(s.substring(0,10)+"t1")+" "+(s.substring(0,10)+"t2")+" "+(s.substring(0,11)+"t")+" ");
			System.out.println("");
			while(r2!=0)
			{
				q=r1/r2;
				r=r1%r2;
				t=t1-q*t2;
				System.out.println((s.substring(0,12-(""+q).length())+q)+" "+(s.substring(0,12-(""+r1).length())+r1)+" "+(s.substring(0,12-(""+r2).length())+r2)+" "+(s.substring(0,12-(""+r).length())+r)+" "+(s.substring(0,12-(""+t1).length())+t1)+" "+(s.substring(0,12-(""+t2).length())+t2)+" "+(s.substring(0,12-(""+t).length())+t));
				r1=r2;
				r2=r;
				t1=t2;
				t2=t;
			}
			System.out.println(s+" "+(s.substring(0,12-(""+r1).length())+r1)+" "+(s.substring(0,12-(""+r2).length())+r2)+" "+s+" "+(s.substring(0,12-(""+t1).length())+t1)+" "+(s.substring(0,12-(""+t2).length())+t2)+" ");
			System.out.println("");
			y[i]=t1;
			if(y[i]<0)
				y[i]=n[i]+y[i];
			System.out.println("Value of Y"+(i+1)+" is "+y[i]);
			System.out.println("");
		}
		
		System.out.println("");
		long x=0;
		for(i=0;i<l;i++)
		{
			x+=a[i]*y[i]*m[i];
		}
		x=x%M;
		System.out.println("Finally, X : "+x);
		System.out.print("Different values of Xs' are ");
		System.out.print(M+x+", ");
		System.out.print(2*M+x+", ");
		System.out.println(3*M+x+". ");
	}
}