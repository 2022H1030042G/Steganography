 

package crypto;

import java.io.File;
import java.io.FileOutputStream;

public class Encryption 
{
   public static String endResult="";
    
    public Encryption() 
    {

    }
    
    
    public String encrypt(String text, int key)
    {
        
     //   String endResult = "";
        key = key*7;
        for(char a : text.toCharArray())
        {
            for(int i = 0; i < key; i++)
            {
                if(  !(a >= 123 || a < 31))
                {
                    if(a+1 != 123)
                    {
                        a += 1;
                    }
                    else
                    {
                        a = 32;
                    }
                }
            }
            
            endResult += a;
            System.out.println(endResult);
                   
        }
        
       
       try{
        FileOutputStream fos=null;
        new File("c:\\TrioSteg").mkdir();
       File fout=new File("c:\\TrioSteg\\encryptedtext.txt");
       fos=new FileOutputStream(fout);
       
       for(int i=0;i<endResult.length();i++)
       {
           char c=endResult.charAt(i);
           fos.write(c);
           System.out.println("c="+c) ;
       }
       
        
       } catch(Exception e){}
        
        return endResult;
    }

    /**
     * Decrypt a string, with a key
     * @param text - The string of text you want to decrypt
     * @param key - the key to decrypt it with.
     * @return - Decrypted String
     */
    public String decrypt(String cipherText, int key)
    {
        String endResult = "";
            key = key*7;
    for(char a : cipherText.toCharArray())
        {
        for(int i = 0; i < key; i++)
        {
            if(  !(a >= 123 || a < 31))
            {
                if(a-1 != 31)
                {
                    a -= 1;
                }
                else
                {
                    a = 122;
                }
            }
            else
            {
                break;
            }
        }
       
        endResult += a;
        System.out.println(endResult);
    }
    return endResult;
}
    


}