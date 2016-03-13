package anubhav.calculatorapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Anubhav on 13-03-2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String database_Name="HISTORY.DB";
    private static final int database_Version=1;
    private static final String TAG="DATABASE OPERATIONS";
    private static final String table_Name="history";
    private static final String column1="calculator_name";
    private static final String column2="expression";
    private static final String create_Table="CREATE TABLE "+table_Name+"("+column1+" TEXT,"+column2+" TEXT);";

    SQLiteDatabase db;
    public DBHelper(Context context) {
        super(context,database_Name,null,database_Version);
        Log.i(TAG,"Database Created / Opened");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_Table);
        Log.i(TAG,"Table Created");
    }

    public void insert(String calcName,String expression)
    {
        db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(column1,calcName);
        contentValues.put(column2,expression);
        db.insert(table_Name, null, contentValues);
        Log.i(TAG,calcName+"-->"+expression);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
