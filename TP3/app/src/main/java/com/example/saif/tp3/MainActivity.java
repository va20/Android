package com.example.saif.tp3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends Activity {


    private Button Changepreference;
    private CheckBox lievre;
    private CheckBox tortue;
    private Button afficher;
    private Intent i;
    private View bg_accueil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.Changepreference=(Button) findViewById(R.id.pref);
        this.afficher=(Button) findViewById(R.id.affichage);
        this.lievre=(CheckBox) findViewById(R.id.option1);
        this.tortue=(CheckBox) findViewById(R.id.option2);
        //i=new Intent();
        bg_accueil=(View) findViewById(R.id.ecran_accueil);
        this.i=new Intent(this,Preferences2.class);
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onStart(){
        super.onStart();
        SharedPreferences pref=getSharedPreferences("color", Context.MODE_PRIVATE);
        int couleur=0;
        couleur=pref.getInt("couleur",20);
        bg_accueil.setBackgroundColor(couleur);
        System.out.println("blanc");

    }
    public void changePref(View view){
        view=this.Changepreference;
        //i.putExtra("test",Changepreference.getText());
        startActivity(i);
    }
    public void faireToast(String message){
        Context context=getApplicationContext();
        Toast toast=Toast.makeText(context,message,Toast.LENGTH_LONG);
        toast.show();
    }


    public void afficher(View view){
        Intent intent;
        String m="";
        String adresse="";
        Resources resources=getResources();
        if(lievre.isChecked() && !tortue.isChecked()){
            m+=resources.getString(R.string.theme1);
            adresse+=resources.getString(R.string.adresse_theme1);
        }
        if (tortue.isChecked() && !lievre.isChecked()){
            m+=resources.getString(R.string.theme2);
            adresse+=resources.getString(R.string.adresse_theme2);
        }
        if (tortue.isChecked() && lievre.isChecked()){
            m+=resources.getString(R.string.theme1)+resources.getString(R.string.theme2);
            adresse+=resources.getString(R.string.adresse_themes1_et_2);
        }
        if(adresse.length()!=0){
            allerVersPageWeb(adresse);
        }
        if(m.length()!=0){
            faireToast(m);
        }
        else if(adresse.length()==0){
            intent=new Intent(this,ErreurActivity.class);
            startActivityForResult(intent,1);
        }
    }

    private void allerVersPageWeb(String adresse){
        Uri uri=Uri.parse(adresse);
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }

    protected void onActivityResult(int reqCode,int resCode,Intent ErrMain){
        if(reqCode == 1 && resCode == RESULT_CANCELED){
            finish();
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
        else if(reqCode==1 && resCode == RESULT_OK){
            //System.out.println(ErrMain.getStringExtra("recommencer"));
            faireToast(ErrMain.getStringExtra("recommencer"));
        }
    }
}
