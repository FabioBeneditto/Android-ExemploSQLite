package tk.altoscodigos.exemplosqlite;

import android.content.Intent;
import android.database.Cursor;
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

    public void abreDataBase(View v) {
        DatabaseApp dbApp = new DatabaseApp(this);
        SQLiteDatabase dtb = dbApp.getWritableDatabase();

        /* Cursor - Equialente ao ResultSet */
        try {
            //Cursor c = dtb.rawQuery("select * from Locais", null);
            String[] colunas = {"idLocal", "dsLocal"};
            String[] parametros = {"2014-01-01", "%feevale%"};
            Cursor cl = dtb.query(
                    "Locais",
                    colunas,
                    "dtVisita > ? and dsLocal like ?",
                    parametros,
                    null,
                    null,
                    "dtVisita");

        } catch (Exception e) {

        } finally {
            dtb.close();
        }
    }

    public void tiraFoto(View v) {
        Intent i = new Intent(this, CapturaCamera.class);
        startActivity(i);
    }

    public void exibeListaSimples(View v) {
        Intent i = new Intent(this, ArrayListActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_exemplo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.configurar:

                break;
            case R.id.imprimir:

                break;
            case R.id.sobre:

                break;
            case R.id.sair:

                break;
        }
        return true;
    }
}
