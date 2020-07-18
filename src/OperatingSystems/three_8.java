package OperatingSystems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class three_8 {
    public static void main(String[] args){
        try{
            Random rand=new Random();
            ServerSocket sock = new ServerSocket(6013);
            String[] fortuntes = new String[5];
            fortuntes[0] = "today will be a good day";
            fortuntes[1] = "good luck on that test";
            fortuntes[2] = "it will rain";
            fortuntes[3] = "have fun";
            fortuntes[4] = "this is cool. \n now this is a second line maybe, \n we'll see";
            //now listen for connections
            while (true){
                Socket client = sock.accept();
                PrintWriter pout = new
                        PrintWriter(client.getOutputStream(), true);
                //write the Date to the socket

                int index = rand.nextInt()%5;
                if(index < 0 ){
                    index = index * -1;
                }
                System.out.println(index);
                Scanner scanner = new Scanner(fortuntes[index]);
                while(scanner.hasNextLine()){
                    pout.println(scanner.nextLine());
                }

                //close the socket and resume
                //listening for connections
                client.close();
            }
        }
        catch (IOException ioe){
            System.err.println(ioe);
        }
    }

}
