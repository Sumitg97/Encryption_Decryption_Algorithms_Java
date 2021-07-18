import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.util.*;
import org.apache.commons.io.FileUtils;
import java.nio.charset.Charset;
class DES 
{
	Cipher ecipher;
	Cipher dcipher;
	DES(SecretKey key) throws Exception 
	{
		ecipher = Cipher.getInstance("DES");
		dcipher = Cipher.getInstance("DES");
		ecipher.init(Cipher.ENCRYPT_MODE, key);
		dcipher.init(Cipher.DECRYPT_MODE, key);
	}

	public String encrypt(String str) throws Exception 
	{
		byte[] utf8 = str.getBytes("UTF8");
		byte[] enc = ecipher.doFinal(utf8);
		return new sun.misc.BASE64Encoder().encode(enc);
	}

	public String decrypt(String str) throws Exception 
	{
		byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);
		byte[] utf8 = dcipher.doFinal(dec);	
		return new String(utf8, "UTF8");
	}
}

class Main 
{
	public static void main(String[] argv) throws Exception 
	{
		SecretKey key = KeyGenerator.getInstance("DES").generateKey();
		System.out.println("Key:"+key);
		DES encrypter = new DES(key);
		Scanner sc=new Scanner(System.in);
		String msg="";
		System.out.print("Enter name of file to take input from...");
		String input=sc.next();
		File f=new File(input+".txt");
		msg=FileUtils.readFileToString(f, Charset.forName("UTF-8"));
		System.out.println("Encrypted:"+encrypter.encrypt(msg));
		System.out.println("Enter output file name::");
		String opp=sc.next();
		f=new File(opp+".txt");
		FileUtils.writeStringToFile(f,encrypter.encrypt(msg),Charset.forName("UTF-8"));
		
	}
}
