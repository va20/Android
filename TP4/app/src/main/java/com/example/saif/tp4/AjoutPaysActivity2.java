package com.example.saif.tp4;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AjoutPaysActivity2 extends AppCompatActivity {
    private Base db;
    private Button ajouter;
    private EditText pays;
    private EditText capitale;
    private EditText continent;
    private EditText population;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_pays2);
        Intent intent=getIntent();
        this.ajouter=(Button) findViewById(R.id.bajouter);
        this.pays=(EditText) findViewById(R.id.ed_pays);
        this.capitale=(EditText) findViewById(R.id.ed_capitale);
        this.continent=(EditText) findViewById(R.id.ed_continent);
        this.population=(EditText) findViewById(R.id.ed_population);
        this.db=new Base(this);
    }

    public void ajouter(View view){
        Context context=getApplicationContext();
        CharSequence message="";
        if(db.ajouterLigne(pays.getText().toString(),capitale.getText().toString()
                ,continent.getText().toString(),population.getText().toString())){
            message="Information ajouté";
            Toast toast=Toast.makeText(context,message,Toast.LENGTH_LONG);
            toast.show();
        }
        else{
            message="echec";
            Toast toast=Toast.makeText(context,message,Toast.LENGTH_LONG);
            toast.show();
        }
    }

}
