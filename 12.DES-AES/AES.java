import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.io.*;
import java.util.*;
import org.apache.commons.io.FileUtils;
import java.nio.charset.Charset;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
 
public class AES {
 
    private static SecretKeySpec secretKey;
    private static byte[] key;
 
    public static void setKey(String myKey)
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
 
    public static String encrypt(String strToEncrypt, String secret)
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
 
    public static String decrypt(String strToDecrypt, String secret)
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        }
        catch (Exception e)
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
    public static void main(String[] args) throws Exception
{
	Scanner sc=new Scanner(System.in);
	
	System.out.println("Input Key::");
    final String secretKey = sc.nextLine();
    System.out.println("Key:"+secretKey);
	
	
	System.out.print("Enter name of file to take input from...");
	String input=sc.nextLine();
	
	File f=new File(input+".txt");
	String originalString=FileUtils.readFileToString(f, Charset.forName("UTF-8"));
	System.out.println(originalString);
	String encryptedString = AES.encrypt(originalString, secretKey) ;
    //System.out.println("Encrypted:"+encrypter.encrypt(msg));
	String decryptedString = AES.decrypt(encryptedString, secretKey) ;
    System.out.println(originalString);
    System.out.println(encryptedString);
    System.out.println(decryptedString);
	System.out.println("Enter output file name::");
	String opp=sc.next();
	f=new File(opp+".txt");
	FileUtils.writeStringToFile(f,encryptedString,Charset.forName("UTF-8")); 

	}
}

