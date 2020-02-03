import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 
import org.apache.commons.io.FileUtils;
import java.nio.charset.Charset;
import java.io.*;
import java.util.*;
public class SHA 
{ 
    public static String hash(String input) 
    { 
        try { 
            MessageDigest md = MessageDigest.getInstance("SHA-512"); 
            byte[] messageDigest = md.digest(input.getBytes()); 
			BigInteger no = new BigInteger(1, messageDigest); 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 128) { 
                hashtext = "0" + hashtext; 
            } 
			return hashtext; 
        } 
		catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    } 
    public static void main(String args[]) throws Exception 
    { 
        Scanner sc=new Scanner(System.in);
		String msg="";
		System.out.print("Enter name of file to take input from...");
		String input=sc.next();
		File f=new File(input+".txt");
		msg=FileUtils.readFileToString(f, Charset.forName("UTF-8"));
		System.out.println("Output Hash::"+hash(msg));
		System.out.println("Enter output file name::");
		String opp=sc.next();
		f=new File(opp+".txt");
		FileUtils.writeStringToFile(f,hash(msg),Charset.forName("UTF-8"));
    } 
} 