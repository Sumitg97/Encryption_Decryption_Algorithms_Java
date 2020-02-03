import java.io.*;
import java.util.*;
import org.apache.commons.io.FileUtils;
import java.nio.charset.Charset;
class DVC
{
	public static void main(String []args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Key File:");
		String key=sc.next();
		File f=new File(key+".txt");
		key=FileUtils.readFileToString(f, Charset.forName("UTF-8"));
		System.out.print("Enter name of file to take input from...");
		String input=sc.next();
		f=new File(input+".txt");
		String msg=FileUtils.readFileToString(f, Charset.forName("UTF-8"));
		String e="";
		int l=key.length(),i=0,j=0;
		for(i=0;i<msg.length();i++)
		{
			if(msg.charAt(i)>=65&&msg.charAt(i)<=91)
			{
				char c=key.charAt(j);
				if(key.charAt(j)>=97&&key.charAt(j)<=122)
					c=(char)(key.charAt(j)-97+65);
				int tmp=((msg.charAt(i)-65)-(c-65))%26;
				if(tmp<0)
					tmp=tmp+26;
				e+=(char)(65+tmp);
				j++;
			}
			else if(msg.charAt(i)>=97&&msg.charAt(i)<=122)
			{
				char c=key.charAt(j);
				if(key.charAt(j)>=65&&key.charAt(j)<=91)
					c=(char)(key.charAt(j)+97-65);
				int tmp=((msg.charAt(i)-97)-(c-97))%26;
				if(tmp<0)
					tmp=tmp+26;
				e+=(char)(97+tmp);
				j++;
			} 
			else
				e+=msg.charAt(i);
			if(j==l)
				j=0;
		}
		System.out.println("Enter output file name::");
		String op=sc.next();
		f=new File(op+".txt");
		FileUtils.writeStringToFile(f,e,Charset.forName("UTF-8"));
		System.out.println("Decrypted String:"+e);
	}
}