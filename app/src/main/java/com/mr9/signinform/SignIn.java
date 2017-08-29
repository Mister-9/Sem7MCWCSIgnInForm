package com.mr9.signinform;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignIn extends AppCompatActivity {
    private static TextView name,emil,mob,con,state,dob;
    private static Button retry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        name=(TextView)findViewById(R.id.name);
        emil=(TextView)findViewById(R.id.em);
        mob=(TextView)findViewById(R.id.mob);
        con=(TextView)findViewById(R.id.con);
        state=(TextView)findViewById(R.id.stat);
        dob=(TextView)findViewById(R.id.bdate);
        retry=(Button)findViewById(R.id.try_again);
        Intent intent=getIntent();
        name.append(intent.getExtras().getString("uname"));
        emil.append(intent.getExtras().getString("mail"));
        mob.append(intent.getExtras().getString("mobile"));
        con.append(intent.getExtras().getString("cont"));
        state.append(intent.getExtras().getString("state"));
        dob.append(intent.getExtras().getString("dob"));
        retry.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(SignIn.this,MainActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}
