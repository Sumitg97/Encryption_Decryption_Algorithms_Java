import java.io.*;
import java.util.*;
import org.apache.commons.io.FileUtils;
import java.nio.charset.Charset;
class DHC
{
	public static int inverse(int a,int b)
	{
		int t1=0,t2=1,r1=a,r2=b,t=0,q=0,r=0;
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
	public static void main(String []args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		String key="",msg="",op="";
		int i=0,j=0;
		System.out.print("Enter Key file::");
		key=sc.next();
		File f=new File(key+".txt");
		key=FileUtils.readFileToString(f, Charset.forName("UTF-8"));
	 	key=key.toUpperCase();
		System.out.print("Enter name of file to take input from...");
		String input=sc.next();
		f=new File(input+".txt");
		msg=FileUtils.readFileToString(f, Charset.forName("UTF-8"));
		msg=msg.toUpperCase();
		msg=msg.replaceAll("[^a-zA-Z0-9]", "");
		if(key.length()!=4)
		{
			System.out.println("Key is not of required length..");
			return;
		}	
		
		msg=msg.toUpperCase();
		key=key.toUpperCase();
		int k[][]=new int[2][2];
		msg=msg.toUpperCase();
		key=key.toUpperCase();
		int m=0,n=0;
		for(i=0;i<2;i++)
		{
			for(j=0;j<2;j++)
				k[i][j]=key.charAt(m++)-65;
		}
		int d=k[0][0]*k[1][1]-k[0][1]*k[1][0];
		d=(d+26)%26;
		d=inverse(26,d);
		//System.out.println(d);
		int tmp=0;
		tmp=k[0][0];
		k[0][0]=k[1][1];
		k[1][1]=tmp;
		k[0][1]=-k[0][1];
		k[1][0]=-k[1][0];
		//System.out.println("\nDecrypted Message::");
		for(i=0;i<2;i++)
		{
			for(j=0;j<2;j++)
				k[i][j]=k[i][j]%26;
		}
		for(i=0;i<2;i++)
		{
			for(j=0;j<2;j++)
				k[i][j]=(k[i][j]+26)%26;
		}
		for(i=0;i<2;i++)
		{
			for(j=0;j<2;j++)
				k[i][j]*=d;
		}
		for(i=0;i<2;i++)
		{
			for(j=0;j<2;j++)
				k[i][j]=(k[i][j]+26)%26;
		}
		for(i=0;i<msg.length();i=i+2)
		{
			m=0;
			n=0;
			int l=0;
			int p[]=new int[2];
			int c[]={msg.charAt(i)-65,msg.charAt(i+1)-65};
			c[0]=c[0]%26;
			c[1]=c[1]%26;
			
			//System.out.println(c[0]+" "+c[1]);
			p[0]=c[0]*k[0][0]+c[1]*k[0][1];
			p[1]=c[0]*k[1][0]+c[1]*k[1][1];
			p[0]=p[0]%26;
			p[1]=p[1]%26;
			op+=""+(char)(p[0]+65)+(char)(p[1]+65);
			//System.out.print(""+(char)(p[0]+65)+(char)(p[1]+65));
			/*for(j=0;j<3;j++)
				System.out.println(Arrays.toString(k[j]));
			System.out.println(Arrays.toString(c));
			System.out.println(Arrays.toString(p));*/
		}
		
		System.out.println("Decrypted Text:"+op);
		System.out.print("Enter output file name::");
		String opp=sc.next();
		f=new File(opp+".txt");
		FileUtils.writeStringToFile(f,op,Charset.forName("UTF-8"));
	}
}


/*EXPERIMENTS:::
1.CREATE digitL SIGN
2.CREATE DIGITAL CERT KEY TOOL KEY STORE IMPORT EXPORT
3.SNORT
4.SHA*/