import java.io.*;
import java.net.*;
import java.util.*;
class ClientDFH
{
	private static Socket socket;
    private static int port = 9876;
	static
	{
		try
		{
			socket = new Socket("localhost",port);
			System.out.println("Connected");
		}
		catch(Exception e){}
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
	public static boolean isPrimRoot(long q,long a)
	{
		boolean arr[]=new boolean[(int)q];
		Arrays.fill(arr,false);
		boolean brr[]=new boolean[(int)q];
		Arrays.fill(brr,true);
		int cnt=1;
		while(cnt<=q-1)
		{
			long tmp=(long)Math.pow(a,cnt);
			tmp=tmp%q;
			if(arr[(int)tmp]==true)
			{
				System.out.println(Arrays.toString(arr)+" "+Arrays.toString(brr));
				return false;
			}
				
			arr[(int)tmp]=true;
			cnt++;
		}
		arr[0]=true;
		//System.out.println(Arrays.toString(arr)+" "+Arrays.toString(brr));
		if(Arrays.equals(arr,brr))
			return true;
		return false;
	}
	private static void send(long publicKey)
	{
		try
		{
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeLong(publicKey);
		}catch(Exception e){}
	}
	private static long receive()
	{
		try
		{
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			long otherPublicKey = dis.readLong();
			return otherPublicKey;
		}
		catch(Exception e){
			System.out.println(e);
		}
		return 0;
	}
	
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		long q=0,a=0;
		System.out.print("Enter a prime number:");
		q=sc.nextLong();
		System.out.print("Enter primitive root of prime number:");
		a=sc.nextLong();
		if(isPrime(q)==false)
		{
			System.out.println("q entered is not prime..");
			return;
		}
		if(isPrimRoot(q,a)==false)
		{
			System.out.println("alpha is not primitive root of q..");
			return;		
		}
		System.out.print("Enter private key less than q..");
		long x=sc.nextLong();
		if(x>=q)
		{
			System.out.println("Conditions not satisfied..");
			return;
		}
		long y=((long)Math.pow(a,x))%q;
		
		
		try
		{
			Thread th = new Thread();
			System.out.println("Public key "+y);
			send(y);
			long yb = receive();
			System.out.println("Public key received "+yb);
			long k = ((long)Math.pow(yb,x))%q;
			System.out.println("Shared Key = "+k);
		}
		catch(Exception e){}
	}
}