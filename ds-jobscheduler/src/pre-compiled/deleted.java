/* no use anymore, check out new file client.java
import java.util.*;
import java.net.*;
import java.io.*;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;


public class Client_Schedule_job {

    public static String HELO="HELO";
    public static String AUTH="AUTH here";
    public static String REDY="REDY";
    public static String QUIT="QUIT";
    public static String GETSALL="GETS ALL";
    public static String OK="OK";
    public ArrayList<Server> serverList =new ArrayList<Server>();
    public int coreCount=-1;

    public String readMsg(byte[] b,BufferedInputStream bis){
        try{
            bis.read(b);
            String str =new String(b,StandardCharsets.UTF_8);
            return str;
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    


    public Server findLargest() {
    
		// Max is the first server in the serverList
		Server maximum = serverList.get(0);
        
		for (Server server : serverList) {
			// Iterate through each server in the serverList, set maximum = server with the largest amount of cores
			if(Integer.parseInt(server.getCoreCount())> Integer.parseInt(maximum.getCoreCount())) {
				maximum = server;
			}
		}
		return maximum;
	}


  
   public static void main(String[] args) {
   
        Socket s=new Socket("127.0.0.1",50000);  
        
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        DataInputStream din=new DataInputStream(s.getInputStream());
        BufferedOutputStream bout=new BufferedOutputStream(dout);
        BufferedInputStream bin=new BufferedInputStream(din);
        Client_Schedule_job scheduler= new Client_Schedule_job();

        bout.write(HELO.getBytes());
        System.out.println("SENT HELO");
        bout.flush();
        String serverReply =scheduler.readMsg(new byte[32],bin);
        System.out.println("RCVD in response to HELO"+ serverReply);
        //sent helo and reciveve server response

        bout.write(AUTH.getBytes());
        System.out.println("SENT AUTH");
        bout.flush();
        serverReply =scheduler.readMsg(new byte[32],bin);
        System.out.println("RCVD in response to AUTH"+ serverReply);
        //sent atuh and reciveve server response

        bout.write(REDY.getBytes());
        System.out.println("SENT REDY");
        bout.flush();
        serverReply =scheduler.readMsg(new byte[32],bin);
        System.out.println("RCVD in response to REDY"+ serverReply);
        //sent redy and reciveve server response

        bout.write(GETSALL.getBytes());
        System.out.println("SENT GETS ALL");
        bout.flush();
        serverReply =scheduler.readMsg(new byte[32],bin);
        System.out.println("RCVD in response to GETS ALL"+ serverReply);
        bout.write(OK.getBytes());
        bout.flush();
        //sent rcvd and reciveve server response

        String[] mes_space= serverReply.split(" ");
        serverReply= scheduler.readMsg(new byte[Integer.parseInt(mes_space[1])*Integer.parseInt(mes_space[2])], bin);
        String[] arrOfStr=serverReply.split("\n");
        
        
        Client_Schedule_job stage1= new Client_Schedule_job();
        for (String server:arrOfStr){
        String[] individualServer=server.split(" ");
        Server eachServer= new Server();
        eachServer.setType(individualServer[0]);
        eachServer.setLimit(individualServer[1]);
        eachServer.setBootupTime(individualServer[2]);
        eachServer.setRate(individualServer[3]);
        eachServer.setCoreCount(individualServer[4]);
        eachServer.setMemory(individualServer[5]);
        eachServer.setDisk(individualServer[6]);
        stage1.serverList.add(eachServer);

        //The method add(String) in the type ArrayList<String> is not applicable for the arguments (Server)Java(67108979)

     }
     // add the server infomation to ServerLIst

    
        bout.write(OK.getBytes());
        System.out.println("SENT OK");
        bout.flush();
        serverReply =scheduler.readMsg(new byte[32],bin);
        System.out.println("RCVD in response to OK"+ serverReply);
        
        //send ok to server should be recieved "."
        
        
        stage1.findLargest(); //find the largest Server
        String largeServer="SCHD 110"+stage1.findLargest().getType()+stage1.findLargest().getID();
        bout.write(largeServer.getBytes());
        bout.flush();
        System.out.println("The largest Server is : "+largeServer);
        serverReply=stage1.readMsg(new byte[200], bin);
        System.out.println("RCVD in response to SCHD: "+serverReply);
        // schedule the job to server

        bout.write(REDY.getBytes());
        System.out.println("SENT REDY");
        bout.flush();
        serverReply =scheduler.readMsg(new byte[32],bin);
        System.out.println("RCVD in response to REDY"+ serverReply);
        //sent REDY to server 

        bout.write(QUIT.getBytes());
        System.out.println("SENT QUIT");
        bout.flush();
        serverReply =scheduler.readMsg(new byte[32],bin);
        System.out.println("RCVD in response to QUIT"+ serverReply);
        //quit simulation now

        if(serverReply.equals(QUIT)){
            bout.close();
            dout.close();
            s.close();

        }
    } 
    
    catch(Exception e){
        System.out.println(e);
    }

}
}
        
        
        
        
        
        
        
        
        
        /*
        // Document Builder Properties (Read the 'ds-system.xml' file)
        File file_of_interest = new File("../ds-simulator/src/pre-compiled/ds-system.xml");
        
        DocumentBuilderFactory doc_builder = DocumentBuilderFactory.newInstance();    // XML Parsers
        DocumentBuilder dBuild = doc_builder.newDocumentBuilder();
        
        Document doc = dBuild.parse(file_of_interest); 
        doc.getDocumentElement().normalize();

    }    




    


