package com.example.saif.tp2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.app.Activity.RESULT_OK;


public class MainActivity extends Activity {
    private Button math;
    private Button francais;
    private Intent i;
    private EditText nom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        math=(Button) findViewById(R.id.bouton_maths);
        francais=(Button) findViewById(R.id.bouton_french);
        nom=(EditText) findViewById(R.id.username);
        i=new Intent();
    }

    public void maths(View bouton){
        bouton=this.math;
        this.i=new Intent(this,Main2Activity.class);
        i.putExtra("nom",nom.getText().toString());
        //startActivity(i);
        startActivityForResult(i,1);
    }

    protected void onActivityResult(int reqCode,int resCode,Intent intBA){
        if(reqCode==1 && resCode==RESULT_OK){
            intBA.getStringExtra("result");
            Toast t=Toast.makeText(this,"Vous etes un genie",Toast.LENGTH_LONG);
            t.show();
        }
        else if(reqCode == 1 && resCode==RESULT_CANCELED){
            Toast t=Toast.makeText(this,"Vous etes nul en maths",Toast.LENGTH_LONG);
            t.show();
        }
    }
}
