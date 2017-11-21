package com.example.saif.tp4;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RechercheActivity extends AppCompatActivity {


    private Button info_base;
    private Button info_web;
    private EditText pays;
    private Base base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche);
        Intent intent=getIntent();
        this.info_base=(Button) findViewById(R.id.b_base);
        this.info_web=(Button) findViewById(R.id.b_web);
        this.pays=(EditText) findViewById(R.id.ed_pays2);
        this.base=new Base(this);

    }

    public void infoBase(View view){
        Context context=getApplicationContext();
        CharSequence message="";
        message=base.touteInfo(pays.getText().toString());
        Toast toast=Toast.makeText(context,message,Toast.LENGTH_LONG);
        toast.show();
        System.out.println(base.touteInfo(pays.getText().toString()));
    }

    public void infoWeb(View view){

    }


}
