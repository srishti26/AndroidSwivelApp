package com.dover.com.swivellifeindicator;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends Activity {

@Override
public void setContentView(View view) {
    super.setContentView(view);
    setContentView(R.layout.activity_home);
    TextView mText = (TextView) findViewById(R.id.tv_countdata);
    mText.setText("Show data :  12 " );
    Toast.makeText(HomeActivity.this,"Login success" ,Toast.LENGTH_LONG).show();
}

}
