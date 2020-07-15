
package crypto;

import crypto.Encryption;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
//import crypto.Encryption;

public class decode {
   public static String l3,path,decryptmsg2;
    static int l4,n,key2;
    static  StringBuffer cs3;
     static String sta="",sta2="",binary3,len;
     //static int l4;
 
 public static void decode2()
 {
    
            
            FileInputStream fileInputStream=null;
            FileOutputStream fop = null;

            File file = new File(path);
                byte[] bFile2;
             bFile2 = new byte[(int) file.length()];
        
             
       
             
             try
             {
                 fileInputStream = new FileInputStream(file);
                 fileInputStream.read(bFile2);
                 fileInputStream.close();
            

               
             
             
            for (int i = 0; i < bFile2.length; i++) {
               
                  int a=bFile2[i];  
                }
                 
                 
                 for(int j=255;j<=255*n;j=j+255)
                 {
                  cs3=new StringBuffer(Integer.toBinaryString(0x100 + (bFile2[j])).substring(1));
                     
                  sta=sta+cs3.charAt(7);
                  }   
                 
                 System.out.println("message bits="+sta+" ");  
                 System.out.println("message length="+sta.length());
             

            
            char ch;
            String ch2 = "";
                 for(int p=0;p<sta.length();p=p+8)
                 {
                    sta2= sta.substring(p , p+8);
                     
                     
                    
                     int d=Integer.parseInt(sta2,2);
                     ch=(char) d;
                     System.out.println(sta2+"---"+d+"---"+ch);
                     ch2=ch2+ch;
                      }
            System.out.println("decoded message is="+ch2);
                
 Encryption obj5=new Encryption();
String decryptmsg= obj5.decrypt(ch2, key2);

decryptmsg2=decryptmsg;
System.out.println("decrypted message is="+decryptmsg);


             }catch(Exception e){}
 }
  
  
   
   public static void main(String args[]) 
    {
       try{
           path=args[0];
           key2=Integer.parseInt(args[1]);
           
          FileInputStream fis=null;
              File fin=new File("c:\\TrioSteg\\encryptedtext.txt");
          fis=new FileInputStream(fin);
          
           n=(int) fin.length()*8;
               
          
             decode obj=new decode();
             decode.decode2();
      
       
       }catch(Exception e){}
      // System.out.println("len"+len);
    }
   
   public static String decryptedmsg()
   {
       return decryptmsg2;
   }



}
