package com.mr9.signinform;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public
class MainActivity extends AppCompatActivity  {

    private static EditText uname, pass, email, phone, dob, intrest;
    private static TextView out;
    private static RadioButton male, female;
    private static RadioGroup gend;
    protected String count, stat;
    private AutoCompleteTextView country_auto,state_auto;
    private static Button sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uname = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone_number);
        intrest = (EditText) findViewById(R.id.interest);
        dob = (EditText) findViewById(R.id.dob);
        gend = (RadioGroup) findViewById(R.id.gender);
        male = (RadioButton) findViewById(R.id.male);
        female = (RadioButton) findViewById(R.id.female);
        sub = (Button) findViewById(R.id.submit);

        country_auto = (AutoCompleteTextView) findViewById(R.id.spinner_country);
        state_auto = (AutoCompleteTextView) findViewById(R.id.spinner_state);
        ArrayAdapter countryAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.country));
        country_auto.setAdapter(countryAdapter);
        country_auto.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View arg0) {
                        country_auto.showDropDown();
                        if (country_auto.getText().toString().compareTo("India")==0) {
                            ArrayAdapter stateAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.india_states));
                            state_auto.setAdapter(stateAdapter);
                        } else if (country_auto.getText().toString().compareTo("United States")==0) {
                            ArrayAdapter stateAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.us_states));
                            state_auto.setAdapter(stateAdapter);
                        }
                    }
                });
            sub.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(MainActivity.this, SignIn.class);
                            intent.putExtra("uname", uname.getText().toString());
                            intent.putExtra("mail", email.getText().toString());
                            intent.putExtra("mobile", phone.getText().toString());
                            intent.putExtra("cont", country_auto.getText().toString());
                            intent.putExtra("state", state_auto.getText().toString());
                            intent.putExtra("dob", dob.getText().toString());
                            startActivity(intent);
                        }
                    }
            );
        }
}
