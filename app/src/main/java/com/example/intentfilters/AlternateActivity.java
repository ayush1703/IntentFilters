package com.example.intentfilters;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AlternateActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alternate);
        Button activity2= (Button)findViewById(R.id.button1);
        activity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent replyIntent = new Intent();
            setResult(RESULT_OK, replyIntent);
                finish();
            }
        });
        Button startTimer = (Button) findViewById(R.id.button2);
        startTimer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                timerAlert(arg0);
            } });
    }

    public void timerAlert(View view)
    {
        EditText textField = (EditText)findViewById(R.id.editText1);
        int i = Integer.parseInt(textField.getText().toString());
        Intent timerIntent = new Intent(this, TimerBroadcast.class);
        PendingIntent myPendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(),0,timerIntent,0);
        AlarmManager myAlarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        myAlarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+(i*1000),myPendingIntent);
        Toast.makeText(this, "Alarm is set for "+i+"seconds",Toast.LENGTH_LONG).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_alternate, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
