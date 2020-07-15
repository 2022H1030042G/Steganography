

package crypto;

import java.io.File;
    import java.io.FileInputStream;
    import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.String;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

    public class encode

    {

        static byte[] bFile,newbFile;
        static int x,y=0;
        static StringBuffer cs;
        static String binary2,encodepath;
       
        static char l2[]=new char[16];
        static String l3[]=new String[16];
        
                
        public static void main( String[] args ) throws IOException, UnsupportedAudioFileException
        {
                 
            try{
            message obj1=new message();
           binary2= obj1.getmessage();
            }catch(Exception e){}
         
     
                
            encodepath=args[1];
            
       //audio to binary     
            
           String srtnew=args[0];
            System.out.println(srtnew);
            
            FileInputStream fileInputStream=null;
            FileOutputStream fop = null;

            File file = new File(srtnew);

             bFile = new byte[(int) file.length()];

            try {
              //  File fileo = new File("g:/origcopy.wav");
       // fop = new FileOutputStream(fileo);
            // if file doesnt exists, then create it
           //     if (!fileo.exists()) {
             //       fileo.createNewFile();
                //}
                //convert file into array of bytes
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();

            
         
            
           
            for (int i = 0; i < bFile.length; i++) {
                System.out.println(Integer.toBinaryString(0x100 + (bFile[i])).substring(1));
                //String  a =(Integer.toBinaryString(0x100 + (bFile[i])).substring(1));
                  int a=bFile[i];
                 // fop.write(a);
                 System.out.println("\t ---: " +a);
                  
                }
            
          
           //  System.out.println(Integer.toBinaryString(0x100 + (bFile[0])).substring(1));
             System.out.println("size in bytes---"+bFile.length+"bytes");
//                fop.flush();
  //              fop.close();
            System.out.println("Done");

            }catch(Exception e){
                e.printStackTrace();
            }
            
          //  System.out.println("'"+msg2+"'to binary:"+binary);
            System.out.println("message to binary:"+binary2);
            System.out.println("message length-"+binary2.length());
          
          
         
            
          //  try{
            int count=0;
            
            
           for( x=255;x<bFile.length;x=x+255)
           {
            
            cs=new StringBuffer(Integer.toBinaryString(0x100 + (bFile[x])).substring(1));
           
           if(cs.length()==8)
               method1();
           else if(cs.length()==7)
               method2();
           
           
           }
   wrifile();
        }
        
  

    private static void method1() {
        
       // JOptionPane.showMessageDialog(null, "please wait till the encoding");
        
        try{
        System.out.println("old bit at index-"+x+" is="+ cs.charAt(7));
                       
             if(y<=binary2.length())
             { 
                 
            cs.setCharAt(7, binary2.charAt(y));
            y++;
          
            
             }
         
            
           System.out.println("change bit at index-"+x+"is= "+cs.charAt(7));
           System.out.println("whole changed value(8 bit) at index-"+x+"is= "+cs);
            
           double j=0;
    for(int i=0;i<cs.length();i++){
        if(cs.charAt(i)== '1'){
         j=j+ Math.pow(2,cs.length()-1-i);
        }
    }
             System.out.println("decimal value-"+(int)j);
             
          
             bFile[x]= (byte)j;
       
         System.out.println("modified="+Integer.toBinaryString(0x100 + (bFile[x])).substring(1));
           
           System.out.println();
        }catch(Exception e){}
         //  throw new UnsupportedOperationException("Not yet implemented");
           }
                      
        
        
    

    private static void method2() {
        
        try{
        System.out.println("old bit at index-"+x+" is="+ cs.charAt(6));
                       
             if(y<=binary2.length())
             { 
                 
            cs.setCharAt(6, binary2.charAt(y));
            y++;
          
            
             }
         
            
           System.out.println("change bit at index-"+x+"is= "+cs.charAt(6));
           System.out.println("whole changed value(8 bit) at index-"+x+"is= "+cs);
            
           double j=0;
    for(int i=0;i<cs.length();i++){
        if(cs.charAt(i)== '1'){
         j=j+ Math.pow(2,cs.length()-1-i);
        }
    }
             System.out.println("decimal value-"+(int)j);
             
          
             bFile[x]= (byte)j;
       
         System.out.println("modified="+Integer.toBinaryString(0x100 + (bFile[x])).substring(1));
           
           System.out.println();
        }catch(Exception e){}
       // throw new UnsupportedOperationException("Not yet implemented");
    }





    private static void wrifile() throws IOException {
                                FileOutputStream fos = new FileOutputStream(encodepath);
                                //System.out.println("encodepath="+encodepath);
                                fos.write(bFile);
                                fos.close();
        throw new UnsupportedOperationException("Not yet implemented");
    }
    }
