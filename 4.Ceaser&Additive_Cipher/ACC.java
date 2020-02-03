import java.io.*;
import java.util.*;
import org.apache.commons.io.FileUtils;
import java.nio.charset.Charset;
class ACC
{
	public static void main(String []args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		int key=0;
		String s="",e="";
		System.out.print("Enter Key..");
		key=sc.nextInt();
		System.out.print("Enter name of file to take input from...");
		String input=sc.next();
		File f=new File(input+".txt");
		s=FileUtils.readFileToString(f, Charset.forName("UTF-8"));
		int i=0,j=0;
		for(i=0;i<s.length();i++)
		{
			if(s.charAt(i)>=97&&s.charAt(i)<=122)
				e+=(char)(97+(s.charAt(i)-97+key)%26);
			else if(s.charAt(i)>=65&&s.charAt(i)<=90)
				e+=(char)(65+(s.charAt(i)-65+key)%26);
			else
				e+=s.charAt(i);
		}
		System.out.print("Enter output file name::");
		String op=sc.next();
		f=new File(op+".txt");
		FileUtils.writeStringToFile(f,e,Charset.forName("UTF-8"));
		System.out.println("Encrypted : "+e);
	}
}