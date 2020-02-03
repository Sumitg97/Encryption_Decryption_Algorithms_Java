import java.io.*;
import java.util.*;
import org.apache.commons.io.FileUtils;
import java.nio.charset.Charset;
class DCC
{
	public static void main(String []args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		int key=3;
		String s="",e="";;
		System.out.print("Enter name of file to take input from...");
		String input=sc.next();
		File f=new File(input+".txt");
		s=FileUtils.readFileToString(f, Charset.forName("UTF-8"));
		int i=0,j=0;
		for(i=0;i<s.length();i++)
		{
			//System.out.println(-3%26);
			if(s.charAt(i)>=97&&s.charAt(i)<=122)
			{
				int tmp=(s.charAt(i)-97-key)%26;
				if(tmp<0)
					tmp=tmp+26;
				e+=(char)(97+tmp%26);
			}	
			else if(s.charAt(i)>=65&&s.charAt(i)<=90)
			{
				int tmp=(s.charAt(i)-65-key)%26;
				if(tmp<0)
					tmp=tmp+26;
				e+=(char)(65+tmp%26);
			}
			else
				e+=s.charAt(i);
		}
		System.out.println("Enter output file name::");
		String op=sc.next();
		f=new File(op+".txt");
		FileUtils.writeStringToFile(f,e,Charset.forName("UTF-8"));
		System.out.println("Decrypted : "+e);
	}
}