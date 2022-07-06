import java.io.*;                                                               
import java.net.*; 

public class ServerTextApplication {
  @SuppressWarnings("deprecation")
  public static void main(String args[])throws Exception                       
     {                                                                            
          try                                                                     
          {                                                                       
                  String line;                                           
                  ServerSocket ss=new ServerSocket(6789);                         
                  // Communication Endpoint for the client and server.     
                  
                  while(true)                                                     
                  {                                                               
                    // Waiting for socket connection                              
                    Socket s=ss.accept();                                         
                    System.out.println("Server Started...");  
                    
                    // DataInputStream to read data from input stream             
                    DataInputStream inp=new DataInputStream(s.getInputStream());
                    
                    // DataOutputStream to write data on output stream             
                    DataOutputStream out = new DataOutputStream(s.getOutputStream());
                    DataInputStream in=new DataInputStream(System.in); 
                   
                    // Reads a line text                                           
                    while(true) {                                                 
                     
                     //System.out.println("Press 'q' if you want to exit server");  
                     line = inp.readLine(); 
                     System.out.println("Received from client: " + line);  
                     System.out.println("\n");
                     
                     // Writes in output stream as bytes      
                     String length = String.valueOf(count(line));
                     
                     //out.writeBytes(line +'\n');   
                     out.writeBytes("Total word count = "+ length + '\n'); 
                       //out.writeBytes(newLine + '\n'); 
                     }                                                            
                    } 
          }                                                                       
          catch(Exception e)                                                      
          {                                                                       
                                                                                  
          }                                                                       
     }  
  
    
  public static int count(String line)
  {
    if(line == null || line.isEmpty())
    {
      return 0;
    }
    String[] words = line.split("\\s+");
    return words.length;
    
  }
}