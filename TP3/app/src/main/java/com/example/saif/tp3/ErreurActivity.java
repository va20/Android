package com.example.saif.tp3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ErreurActivity extends AppCompatActivity {

    private Button recommencer;
    private Button quitter;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erreur);
        this.intent=this.getIntent();
        this.quitter=(Button) findViewById(R.id.quitter);
        this.recommencer= (Button) findViewById(R.id.recommencer);
    }

    public void quitter(View view){
        Intent intErrMain=new Intent(this,MainActivity.class);
        intErrMain.putExtra("quitter","ferme");
        setResult(RESULT_CANCELED,intErrMain);
        finish();
    }

    public void recommencer(View view){
        Intent intErrMain=new Intent(this,MainActivity.class);
        intErrMain.putExtra("recommencer","Il faut faire un choix");
        setResult(RESULT_OK,intErrMain);
        finish();
    }
}
