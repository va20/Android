package com.example.saif.tp4;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    private Button verifier;
    private Button nouvelle;
    private TextView capitale;
    private EditText pays;
    private Base db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        this.db=new Base(this);
        this.verifier=(Button) findViewById(R.id.bverifier);
        this.nouvelle=(Button) findViewById(R.id.bnouvelle);
        this.capitale=(TextView) findViewById(R.id.tv_capitale);
        this.pays=(EditText) findViewById(R.id.ed_pays3);
        capitaleAlea();
    }

    public void capitaleAlea(){
        List<String> capitale= this.db.touteCapitales();
        int index=aleatoire(capitale);
        this.capitale.setText(capitale.get(index));
    }

    public int aleatoire(List<String> capitale){
        int alea=(int)(Math.random()*capitale.size());
        return alea;
    }

    public void verifier(View view){
        Context context=getApplicationContext();
        String message=""+this.db.verifierCapitale(pays.getText().toString(),this.capitale.getText().toString());
        Toast toast=Toast.makeText(context,message,Toast.LENGTH_LONG);
        toast.show();

    }

    public void nouvelle (View view){

    }
}
