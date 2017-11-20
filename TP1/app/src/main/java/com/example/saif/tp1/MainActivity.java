package com.example.saif.tp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button bouton_zero;
    private Button bouton_un;
    Button effacer;
    private TextView nombre_binaire;
    private TextView nombre_decimal;
    private String cumulBinaire;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bouton_zero = (Button) findViewById(R.id.bouton_zero);
        bouton_un = (Button) findViewById(R.id.bouton_un);
        nombre_binaire = (TextView) findViewById(R.id.nombre_binaire);
        nombre_decimal = (TextView) findViewById(R.id.nombre_decimal);
        cumulBinaire = "";
        effacer = (Button) findViewById(R.id.effacer);
        effacer.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                cumulBinaire="";
                if(savedInstanceState!=null){

                    savedInstanceState.putString("cumulBinaire",cumulBinaire);
                }
                update();
            }
        });

        if(savedInstanceState!=null){
            cumulBinaire=savedInstanceState.getString("cumulBinaire");
            update();
        }

    }

    public Button getEffacer() {
        return effacer;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        outState.putString("cumulBinaire",cumulBinaire);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle restore){
        super.onRestoreInstanceState(restore);
    }

    public void nouveauChiffre(View button){
        if(button == bouton_zero){
            cumulBinaire+="0";
        }
        else{
            cumulBinaire+="1";
        }
        update();
    }
    public void update(){
        if(cumulBinaire!=""){
            nombre_binaire.setText(cumulBinaire);
            int decimal=Integer.parseInt(cumulBinaire,2);
            nombre_decimal.setText(Integer.toString(decimal));
        }
        else{

            nombre_binaire.setText(cumulBinaire);
            nombre_decimal.setText(cumulBinaire);
        }
    }
}
