

package crypto;

import crypto.Encryption;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class message {
    
    public static String str1="",var2;
    public static int keypass, v;
    public static StringBuilder binary;
    
    public static String getmsgpath(String[] args3)
    {
        
        
        try
        {
           var2=args3[1];
            v=Integer.parseInt(var2);
           
            
            String var=args3[0];
        
        File a=new File(var);
        
         FileInputStream fis=null;
        FileOutputStream fos=null;
            
             fis=new FileInputStream(a);
            char c ;
            while(fis.available()>0)
            {
                c=(char)fis.read();
                str1=str1+c;
            }
        }catch(Exception e){}
       // System.out.println("keypass"+(char)keypass);
        System.out.println("key="+v);
        return str1;
      
    }

    public static String getmessage() {
       
        
        try{
       Encryption obj4=new Encryption();
       String msg= obj4.encrypt(str1, v);
        
      // System.out.println("str1="+str1);
        //StringBuilder binary;
        
        byte[]  bytes;
      //  String msg="hello adwitiya chandan";
      bytes=  msg.getBytes();
       binary=new StringBuilder();
      
           
      for(byte b:bytes)
      {
          int val=b;
          for(int i=0;i<8;i++)
          {
              binary.append((val & 128) == 0?0:1);
              val<<=1;
          }
         // binary.append(' ');
      }
      
       
        }catch(Exception e){}
      
      return binary.toString();
     
       // throw new UnsupportedOperationException("Not yet implemented");
    }

}
