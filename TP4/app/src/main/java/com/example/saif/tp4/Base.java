package com.example.saif.tp4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by saif on 10/10/17.
 */

public class Base extends SQLiteOpenHelper{

    private static final String db_name="tp4";

    private static final String GEO="geo";
    private static final String PAYS="pays";
    private static final String CAPITALE="capitale";
    private static final String CONTINENT="continent";
    private static final String POPULATION="population";

    private static final String CREATE_GEO="" +
            "create table "+GEO+"( "+
            PAYS + " STRING PRIMARY_KEY NOT NULL, "+
            CAPITALE+" STRING NOT NULL,"+
            CONTINENT+" STRING NOT NULL,"+
            POPULATION+" STRING NOT NULL);";

    public Base(Context context) {
        super(context, db_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_GEO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if (i1>i){
            sqLiteDatabase.execSQL("drop table if exists "+GEO);
            onCreate(sqLiteDatabase);
        }
    }
    public boolean ajouterLigne(String pays,String capitale,String continent,String population){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues row=new ContentValues();
        row.put(Base.PAYS,pays);
        row.put(Base.CAPITALE,capitale);
        row.put(Base.CONTINENT,continent);
        row.put(Base.POPULATION,population);

        return (db.insert(Base.GEO,null,row)>0);
    }

    public String touteInfo(String pays){
        String info="";
        SQLiteDatabase db=this.getReadableDatabase();
        String [] list_cond={pays};
        Cursor c=db.query("GEO",null,"Pays=?", list_cond,null,null,null);
        if (c==null){
            return "erreur";
        }
        else if(c.getCount()==0){
            return "cursor vide";
        }
        else {
            while(c.moveToNext()){
                info=info+c.getString(c.getColumnIndex("capitale"));
                info=info+c.getString(c.getColumnIndex("continent"));
                info=info+c.getString(c.getColumnIndex("population"));
                info=info+"";
            }
        }
        return info;
    }

    public boolean verifierCapitale(String p,String c){
        SQLiteDatabase db=this.getReadableDatabase();
        String [] list_cond={p};
        Cursor cursor=db.query("GEO", new String[]{CAPITALE},"Pays=?",list_cond,null,null,null);
       if(c==null || cursor.getCount()==0){
           return false;
       }
       else {
           while(cursor.moveToNext()){
               if(c.equals(cursor.getString(cursor.getColumnIndex(CAPITALE)))){
                   return true;
               }
           }
       }
       return false;
    }

    public List<String> touteCapitales(){
        ArrayList<String> capitale=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.query("GEO", new String[]{CAPITALE},null,null,null,null,null);
        if(c==null || c.getCount()==0){
            return null;
        }
        else{
            while(c.moveToNext()){
                capitale.add(c.getString(c.getColumnIndex(CAPITALE)));
            }
        }
        for(int i=0;i<capitale.size();i++){
            System.out.printf(capitale.get(i));
        }
        return capitale;
    }
}
