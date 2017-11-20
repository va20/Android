package com.example.saif.tp3;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Preferences2 extends AppCompatActivity {

    private Button blanc;
    private Button magenta;
    private Button turquoise;
    private View bg_preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences2);
        bg_preference=(View) findViewById(R.id.preferences);
        blanc=(Button) findViewById(R.id.blanc);
        magenta=(Button)findViewById(R.id.magenta);
        turquoise=(Button)findViewById(R.id.turquoise);

    }

    protected void onStart(){
        super.onStart();
        SharedPreferences pref=getSharedPreferences("color", Context.MODE_PRIVATE);
        int couleur=0;
        couleur=pref.getInt("couleur",20);
        bg_preference.setBackgroundColor(couleur);
        System.out.println("blanc");
    }

    public void couleur(View view){
        SharedPreferences pref=getSharedPreferences("color", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        int couleur = 0;
        if(view==this.blanc){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                couleur=getColor(R.color.blanc);
            }
            System.out.println("blanc");
            editor.putInt("couleur",couleur);
            editor.apply();
            bg_preference.setBackgroundColor(couleur);

        }
        else if(view==this.magenta){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                couleur=getColor(R.color.magenta);
            }
            System.out.println("magenta");
            editor.putInt("couleur",couleur);
            editor.apply();
            bg_preference.setBackgroundColor(couleur);

        }
        else if(view==this.turquoise){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                couleur=getColor(R.color.turquoise);
            }
            System.out.println("truc");
            editor.putInt("couleur",couleur);
            editor.apply();
            bg_preference.setBackgroundColor(couleur);

        }
    }
}
