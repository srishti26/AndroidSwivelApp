package com.dover.com.swivellifeindicator;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import java.net.UnknownHostException;


public class Client extends AsyncTask<Void, Void, Integer> {

    String dstAddress;
    int dstPort;
    String response = "";
    TextView textResponse;
    TextView tvdate;
    int value;
    int i = 0;
    Context context;

    NotificationManager notif;
    Notification notify;


    Client(String addr, int port, TextView textResponse, Context context) {
        dstAddress = addr;

        dstPort = port;
        this.textResponse = textResponse;
        this.context = context;
    }

    @Override
    protected Integer doInBackground(Void... arg0) {

        Socket socket = null;

        /*try {
            socket = new Socket(dstAddress, dstPort);
            byte ch = '1';

            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            // dout.writeUTF(ch);
            dout.write(ch);
            dout.flush();
            InputStream input;
            DataInputStream in;

            while (true) {

                input = socket.getInputStream();
                in = new DataInputStream(input);
                System.out.print(in.readInt());
                value = in.readInt();
                System.out.print(value);
                dout.write(ch);
                dout.flush();

                publishProgress(null);
//                in.read(buf);
//                for(byte b:buf)
//                {
//                    c = (char)b;
//                    System.out.print(c);
//
//            }}}
            }


        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.print("UnknownHostException: " + e.toString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.print("IOException: " + e.toString());
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }*/

        // while loop for testing without socket, replace return value with 'i'
        while (i < 20) {
            i++;
            Log.d("", "value of i" + i);
            publishProgress(null);

        }
        return i;
    }

    //@Override
//protected void onPostExecute(Integer result) {
//        super.onPostExecute(result);
//        String hostname = "172.16.209.86";
//        int port = 12344;
//        Log.d("Exception","result"+result);
//        textResponse.setText("" +result);
//
//        }
    @Override
    protected void onProgressUpdate(Void... values) {
        textResponse.setText("");
        // If testing needs to be done without socket then replace value with 'i present in while loop'
        Log.d("onProgressUpdate", "count values  :" + value);
        textResponse.append(" Count " + value + "\n");
        callNotification(800);
    }

    private void callNotification(int i) {
        float percentage = i;
        percentage = (100 - (percentage / 1000) * 100);
        if (Float.compare(percentage, 20) == 0 || Float.compare(percentage, 10) == 0 || Float.compare(percentage, 5) == 0 || Float.compare(percentage, 3) == 0 || Float.compare(percentage, 1) == 0 ) {
            notif = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            notify = new Notification.Builder
                    (context).setContentText("Swivel life remaining: " + percentage + "%").
                    setContentTitle("SwivelLifeIndicator").setSmallIcon(R.drawable.pic).build();

            notify.flags |= Notification.FLAG_AUTO_CANCEL;
            notif.notify(0, notify);
        }
    }

}


