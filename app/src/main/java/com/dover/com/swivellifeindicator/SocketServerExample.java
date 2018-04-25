package com.dover.com.swivellifeindicator;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class implements java Socket server
 * @author pankaj
 *
 */
public class SocketServerExample {
public static void main(String args[])
{  try{
        ServerSocket ss=new ServerSocket(6666);
        Socket s=ss.accept();//establishes connection
        DataInputStream dis=new DataInputStream(s.getInputStream());
        String  str=(String)dis.readUTF();
        System.out.println("message= "+str);
        ss.close();
    }catch(Exception e){System.out.println(e);}
}
}
