package com.dover.com.swivellifeindicator;


import android.app.NotificationManager;
import android.content.Context;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.DataInputStream;


public class HomeActivity2 extends AppCompatActivity {

    TextView tvCount;
    DataInputStream in = null;
    int values;
    String hostname = "172.16.209.86";
    int port = 12344;
    Client myClient;
    NotificationManager notif;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        notif = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        tvCount = findViewById(R.id.tv_countdata);
        tvCount.setText(" Count: ______ ");
        mContext = getApplicationContext();



        // new MyAyncTask().execute("hello world");
        myClient = new Client(hostname, port, tvCount, mContext);
        final Handler handler = new Handler();

        Runnable runnable = new Runnable() {
            public void run() {
                new Client(hostname, port, tvCount, mContext).execute();
                //do something

                handler.postDelayed(this, 1);
            }
        };
        runnable.run();


    }

}
