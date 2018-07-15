package com.example.mushfiqurrahman.classscheduler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener{

    Spinner versityName;
    Spinner discName;
    Spinner session;
    ArrayAdapter<CharSequence> adapter;
    ArrayAdapter<CharSequence> adapter1;
    Button  bproceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        versityName = (Spinner)findViewById(R.id.versity);
        adapter = ArrayAdapter.createFromResource(this,R.array.university_name,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        versityName.setAdapter(adapter);

        discName = (Spinner)findViewById(R.id.disc);
        adapter1 = ArrayAdapter.createFromResource(this,R.array.discipline_name,android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        discName.setAdapter(adapter1);

        session = (Spinner)findViewById(R.id.session);
        adapter = ArrayAdapter.createFromResource(this,R.array.session,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        session.setAdapter(adapter);

        bproceed = (Button)findViewById(R.id.button);

        bproceed.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first, menu);
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

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case    R.id.button:

                startActivity(new Intent(this,SecondActivity.class));
                break;

        }
    }
}
