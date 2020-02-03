import java.io.*;
import java.util.*;
import org.apache.commons.io.FileUtils;
import java.nio.charset.Charset;
class PFC
{
	public static void main(String []args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		String key="",msg="",ke="";
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
		String s="";
		//System.out.println(msg+" "+key);
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
		String copymsg=""+msg;
		msg="";
		for(i=0;i<copymsg.length();i++)
			if(copymsg.charAt(i)>=65&&copymsg.charAt(i)<=91)
				msg+=copymsg.charAt(i);
		String rmsg=""+msg.charAt(0);
		for(i=1;i<msg.length();i++)
		{
			if(msg.charAt(i)>=65&&msg.charAt(i)<=91)
			{
				if(msg.charAt(i)==msg.charAt(i-1))
				{
					rmsg+="X";
				}
				rmsg+=msg.charAt(i);
			}
		}
		if(rmsg.length()%2==1)
			rmsg+="X";
		System.out.println("");
		System.out.println("Pairs of two are as follows");
		for(i=0;i<rmsg.length()-1;i=i+2)
		{
			System.out.print(""+rmsg.charAt(i)+""+rmsg.charAt(i+1)+" ");
		}
		System.out.println("");
		System.out.println("");

		System.out.print("Encrypted Text::");
		for(i=0;i<rmsg.length()-1;i=i+2)
		{
			int x1=-1,y1=-1,x2=-1,y2=-1;
			if(rmsg.charAt(i)=='I'||rmsg.charAt(i)=='J')
			{
				for(j=0;j<5;j++)
				{
					for(k=0;k<5;k++)
					{
						if(a[j][k]=='I'||a[j][k]=='J')
						{
							x1=j;
							y1=k;
							break;
						}
					}
					if(k<5)
						break;
				}
			}
			else
			{
				for(j=0;j<5;j++)
				{
					for(k=0;k<5;k++)
					{
						if(a[j][k]==rmsg.charAt(i))
						{
							x1=j;
							y1=k;
							break;
						}
					}
					if(k<5)
						break;
				}
			}
			if(rmsg.charAt(i+1)=='I'||rmsg.charAt(i+1)=='J')
			{
				for(j=0;j<5;j++)
				{
					for(k=0;k<5;k++)
					{
						if(a[j][k]=='I'||a[j][k]=='J')
						{
							x2=j;
							y2=k;
							break;
						}
					}
					if(k<5)
						break;
				}
			}
			else
			{
				for(j=0;j<5;j++)
				{
					for(k=0;k<5;k++)
					{
						if(a[j][k]==rmsg.charAt(i+1))
						{
							x2=j;
							y2=k;
							break;
						}
					}
					if(k<5)
						break;
				}
			}
			//System.out.println(x1+" "+y1+" "+x2+" "+y2);
			if(x1==x2)
			{
				y1=(y1+5+1)%5;
				y2=(y2+6)%5;
			}
			else if(y1==y2)
			{
				x1=(x1+5+1)%5;
				x2=(x2+6)%5;
			}
			else
			{
				int tmp=y1;
				y1=y2;
				y2=tmp;
			}
			s+=""+a[x1][y1]+a[x2][y2];
		}
		System.out.println("Enter output file name::");
		String op=sc.next();
		f=new File(op+".txt");
		FileUtils.writeStringToFile(f,s,Charset.forName("UTF-8"));
		System.out.println(""+s);
	}
}