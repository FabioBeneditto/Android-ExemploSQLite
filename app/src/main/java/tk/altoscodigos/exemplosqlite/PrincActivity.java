package tk.altoscodigos.exemplosqlite;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import tk.altoscodigos.exemplosqlite.db.DatabaseApp;


public class PrincActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_princ);
    }

    public void abreDataBase(View v){
        if(v.getId() == R.id.btAbrirDB){
            DatabaseApp dbApp = new DatabaseApp(this);
            SQLiteDatabase dtb = dbApp.getReadableDatabase();
        }
    }
}
