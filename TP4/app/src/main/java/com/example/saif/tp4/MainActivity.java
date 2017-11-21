package com.example.saif.tp4;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Base db;
    private static final String TAG="My app";
    private Button saisir;
    private Button consulter;
    private Button quiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.saisir=(Button) findViewById(R.id.bsaisir);
        this.consulter=(Button)findViewById(R.id.bconsulter);
        this.quiz=(Button)findViewById(R.id.bquiz);

    }

    public void saisir(View view){
        view=this.saisir;
        Intent intent=new Intent(this,AjoutPaysActivity2.class);
        Log.d(TAG,"erreur");
        startActivity(intent);
    }

    public void consulter(View view){
        view=this.consulter;
        Intent intent=new Intent(this,RechercheActivity.class);
        startActivity(intent);
    }
    public void quiz(View view){
        view=this.consulter;
        Intent intent=new Intent(this,QuizActivity.class);
        startActivity(intent);
    }
}
