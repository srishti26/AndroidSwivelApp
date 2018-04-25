
package com.dover.com.swivellifeindicator;
import android.provider.Settings;

import java.net.*;
import java.io.*;

public class SocketResult {

    public static void main(String[] args) {
        String hostname = "172.16.209.86";
        int port = 12344;


        try (Socket socket = new Socket(hostname, port))
        {
            byte ch = '1';
            Character c;
            DataOutputStream dout=new DataOutputStream(socket.getOutputStream());
            // dout.writeUTF(ch);
            dout.write(ch);
            dout.flush();

            InputStream input = socket.getInputStream();
            DataInputStream in = new DataInputStream(input);
            byte buf[] = new byte[1000];
            while(true) {

                input = socket.getInputStream();
                in = new DataInputStream(input);
                System.out.print(in.readInt());
                dout.write(ch);
                dout.flush();
//                in.read(buf);
//                for(byte b:buf)
//                {
//                    c = (char)b;
//                    System.out.print(c);
//
//            }}
            }


        } catch (UnknownHostException ex) {

            System.out.println("Server not found: " + ex.getMessage());

        } catch (IOException ex) {

            System.out.println("I/O error: " + ex.getMessage());
        }catch (Exception ex) {

            System.out.println("error: " + ex.getMessage());
        }


    }
}