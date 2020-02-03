import java.io.*;
import java.util.*;
import org.apache.commons.io.FileUtils;
import java.nio.charset.Charset;
class DPFC
{
	public static void main(String []args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		String key="",msg="",ke="",rmsg="";
		System.out.print("Enter Key file::");
		key=sc.next();
		File f=new File(key+".txt");
		key=FileUtils.readFileToString(f, Charset.forName("UTF-8"));
		 
		key=key.toUpperCase();
		sc.nextLine();
		System.out.print("Enter name of file to take input from...");
		String input=sc.next();
		f=new File(input+".txt");
		msg=FileUtils.readFileToString(f, Charset.forName("UTF-8"));
		int i=0,j=0,k=0;
		char a[][]=new char[5][5];
		for(i=0;i<key.length();i++)
		{
			if(key.indexOf("I")!=-1&&key.indexOf("J")!=-1&&key.charAt(i)=='J')
				continue;
			if(ke.indexOf(""+key.charAt(i))!=-1)
				continue;
			ke+=""+key.charAt(i);
			a[j][k]=key.charAt(i);
			k++;
			if(k==5)
			{
				j++;
				k=0;
			}
		}
		for(i=0;i<26;i++)
		{
			
			if(key.indexOf(""+(char)(i+65))!=-1)
				continue;
			if((key.indexOf("I")!=-1&&i==9)||(key.indexOf("J")!=-1&&i==8))
				continue;
			else if(i==9)
				continue;
			else
			{
				a[j][k]=(char)(i+65);
				k++;
				if(k==5)
				{
					j++;
					k=0;
				}
			}
			
		}
		System.out.println("");
		for(i=0;i<5;i++)
			System.out.println(Arrays.toString(a[i]));
		
		for(i=0;i<msg.length()-1;i=i+2)
		{
			int x1=-1,y1=-1,x2=-1,y2=-1;
			for(j=0;j<5;j++)
			{
				for(k=0;k<5;k++)
				{
					if(a[j][k]==msg.charAt(i))
					{
						x1=j;
						y1=k;
						break;
					}
				}
				if(k<5)
					break;
			}
			
			for(j=0;j<5;j++)
			{
				for(k=0;k<5;k++)
				{
					if(a[j][k]==msg.charAt(i+1))
					{
						x2=j;
						y2=k;
						break;
					}
				}
				if(k<5)
					break;
			}
			
			//System.out.println(x1+" "+y1+" "+x2+" "+y2);
			if(x1==x2)
			{
				y1=(y1+4)%5;
				y2=(y2+4)%5;
			}
			else if(y1==y2)
			{
				x1=(x1+4)%5;
				x2=(x2+4)%5;
			}
			else
			{
				int tmp=y1;
				y1=y2;
				y2=tmp;
			}
			rmsg+=""+a[x1][y1]+a[x2][y2];
		}
		rmsg=rmsg.replaceAll("X","");
		System.out.println("Enter output file name::");
		String op=sc.next();
		f=new File(op+".txt");
		FileUtils.writeStringToFile(f,rmsg,Charset.forName("UTF-8"));
		System.out.println("\nDecrypted::");
		System.out.println(""+rmsg);
	}
}