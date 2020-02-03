import java.io.*;
import java.util.*;
import org.apache.commons.io.FileUtils;
import java.nio.charset.Charset;
class RF
{
	public static void main(String []args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter name of file to take input from...");
		String input=sc.next();
		File f=new File(input+".txt");
		String msg=FileUtils.readFileToString(f, Charset.forName("UTF-8"));
		System.out.print("Enter level...");
		int l=sc.nextInt();
		int i=0,j=-1,flg=0;
		String e="";
		char m[][]=new char[l][msg.length()];
		for(i=0;i<l;i++)
		{
			for(j=0;j<msg.length();j++)
			{
				m[i][j]='^';
			}
		}
		j=-1;
		for(i=0;i<msg.length();i++)
		{
			if(flg==0)
			{
				j++;
				m[j][i]=msg.charAt(i);
			}
			else
			{
				j--;
				m[j][i]=msg.charAt(i);
			}
			if(j==l-1)
				flg=1;
			else if(j==0)
				flg=0;
		}
		for(i=0;i<l;i++)
		{
			for(j=0;j<msg.length();j++)
			{
				if(m[i][j]!='^')	
				{
					e+=m[i][j];
					System.out.print(m[i][j]);
				}
				else
					System.out.print(" ");
			}	
			System.out.println("");
		}
		System.out.print("Enter output file name::");
		String op=sc.next();
		f=new File(op+".txt");
		FileUtils.writeStringToFile(f,e,Charset.forName("UTF-8"));
		System.out.println(e);
	}
}