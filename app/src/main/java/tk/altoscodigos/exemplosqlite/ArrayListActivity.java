package tk.altoscodigos.exemplosqlite;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ArrayListActivity extends ActionBarActivity {
    String estados[] = new String[] {"Rio Grande do Sul", "Santa Catarina", "Paraná", "São Paulo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_list);


        // Primeiro parametro: Contexto
        // Segundo parametro: Layout para cada linha
        // Terceiro parametro: id da View na qual serao exibidas as strings
        // Quarto parametro: array de dados a ser exibido
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.linha_simples,
                R.id.txDescricao,
                estados
        );
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
/*        listView.setOnClickListener(new AdapterView.OnClickListener(){
            @Override
            public void onItemCLick(AdapterView<?> parent, View view, int position,);
        });*/
    }

/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_array_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

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
