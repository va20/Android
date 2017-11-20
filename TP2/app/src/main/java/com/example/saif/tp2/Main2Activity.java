package com.example.saif.tp2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends Activity {
    private TextView username;
    private String name;
    private EditText rep;
    private Button verifier;
    private Button terminer;
    private Button encore;
    private int x;
    private String tmp;
    private int y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        username=(TextView)findViewById(R.id.username);
        Intent i = this.getIntent();
        aleatoire();
        name=i.getStringExtra("nom");
        tmp= (String) username.getText();
        username.setText(username.getText()+" "+this.x+" * "+" "+this.y+" "+name);
        rep=(EditText) findViewById(R.id.editText2);
        verifier=(Button)findViewById(R.id.button);
        encore=(Button)findViewById(R.id.button2);
        terminer=(Button)findViewById(R.id.button3);
    }
    public void aleatoire(){
        this.x=(int)((Math.random()*(10-0+1))+1);
        this.y=(int)((Math.random()*(10-0+1))+1);

    }
    public void verifier(View view){
        view=this.verifier;
        String reponse=rep.getText().toString();
        if(!reponse.isEmpty()){
            try{
                int number=Integer.parseInt(reponse);
                Log.i("",number+" is a number");
                if(number==(this.x*this.y)){
                    Toast t=Toast.makeText(this,"Bravo",Toast.LENGTH_LONG);
                    t.show();
                }
                else{
                    Toast t=Toast.makeText(this,"TFEUHHH",Toast.LENGTH_LONG);
                    t.show();
                }
            }catch (NumberFormatException e){
                Log.i("",reponse+" is not a number");
            }
        }
    }

    public void encore(View view){
        view=this.encore;
        this.x=0;
        this.y=0;
        rep.setText("");
        aleatoire();
        username.setText("");
        username.setText(tmp+" "+this.x+" * "+" "+this.y+" "+name);
    }

    public void terminer(View view){
        view=this.terminer;
        Intent intBA=new Intent(this,MainActivity.class);
        String reponse=rep.getText().toString();
        if(!reponse.isEmpty()){
            try{
                int number=Integer.parseInt(reponse);
                Log.i("",number+" is a number");
                if(number==(this.x*this.y)){
                    intBA.putExtra("result",Integer.toString(this.x*this.y));
                    setResult(RESULT_OK,intBA);
                    finish();
                }
                else{
                    intBA.putExtra("result",Integer.toString(this.x*this.y));
                    setResult(RESULT_CANCELED,intBA);
                    finish();
                }
            }catch (NumberFormatException e){
                Log.i("",reponse+" is not a number");
            }
        }
    }
}
