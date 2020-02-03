import java.io.*;
import java.util.*;
import org.apache.commons.io.FileUtils;
import java.nio.charset.Charset;
class IDAC
{
	public static void main(String []args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		int key=0;
		String s="",e="";
		File f=new File("dict.txt");
		String finans="";
		String d=FileUtils.readFileToString(f, Charset.forName("UTF-8"));
		//System.out.println(d);
		System.out.print("Enter name of file to take input from...");
		String input=sc.next();
		f=new File(input+".txt");
		s=FileUtils.readFileToString(f, Charset.forName("UTF-8"));
		int i=0,j=0,k=0;
		for(j=0;j<26;j++)
		{
			key=j;
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
			String  r = e.replaceAll("[^\\w\\s]"," ");
			System.out.println(r);
			e="";
			//System.out.println("");
			r=r.toLowerCase();
			Scanner scc=new Scanner(r);
			while(scc.hasNext())
			{
				String tmp=scc.next();
				if(!d.contains(tmp))
					break;
			}
			if(scc.hasNext()==false)
				finans=r;
		}
		System.out.println("");
		System.out.println("Final answer:"+finans);
		System.out.println("Enter output file name::");
		String op=sc.next();
		f=new File(op+".txt");
		FileUtils.writeStringToFile(f,finans,Charset.forName("UTF-8"));
	}
}