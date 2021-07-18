import java.io.*;
import java.util.*;
import org.apache.commons.io.FileUtils;
import java.nio.charset.Charset;
class HC
{
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
		if(key.length()!=9)
		{
			System.out.println("Key is not of required length..");
			return;
		}	
		
		if(msg.length()%3==1)
			msg=msg+"XX";
		else if(msg.length()%3==2)
			msg+="X";
		msg=msg.toUpperCase();
		key=key.toUpperCase();
		int k[][]=new int[3][3];
		msg=msg.toUpperCase();
		key=key.toUpperCase();
		int m=0,n=0;
		for(i=0;i<3;i++)
		{
			for(j=0;j<3;j++)
				k[i][j]=key.charAt(m++)-65;
		}
		System.out.println("\nEncrypted Message::");
		for(i=0;i<msg.length();i=i+3)
		{
			m=0;
			n=0;
			int l=0;
			int p[]=new int[3];
			int c[]={msg.charAt(i)-65,msg.charAt(i+1)-65,msg.charAt(i+2)-65};
			for(j=0;j<3;j++) 
			{
				for (m=0;m<3;m++) 
				{
					for (n=0;n<1;n++)
					{
						p[j]+= k[j][m] * c[m];
					}
				}
				p[j]=p[j]%26;
			}
			op+=""+(char)(p[0]+65)+(char)(p[1]+65)+(char)(p[2]+65);
			System.out.print(""+(char)(p[0]+65)+(char)(p[1]+65)+(char)(p[2]+65));
			/*for(j=0;j<3;j++)
				System.out.println(Arrays.toString(k[j]));
			System.out.println(Arrays.toString(c));
			System.out.println(Arrays.toString(p));*/
		}
		System.out.println("Enter output file name::");
		String opp=sc.next();
		f=new File(opp+".txt");
		FileUtils.writeStringToFile(f,op,Charset.forName("UTF-8"));
	}
}
