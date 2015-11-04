package upeu.edu.pe;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txtCuenta, txtClave;//comenzamos a declarar las variables para poder manipular la interfaz de usuario
    private Button btnSeguir, btnAcceder, btnAnterior;
    private TextView labCuenta;
    private String strsCuenta, strClave, laClave;
    private Context CTX;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Presentar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        referciarControles();//controles de la interfaz referenciar todos los elementos que vamos a utilizar
    }

    private void  referciarControles(){//un metodo que permite hacer referencia a los controles de la interfaz
        CTX = getApplicationContext();//contexto de la aplicacion

        txtCuenta =(EditText) findViewById(R.id.logTxtCuenta);//busaca vista por identificador osea el id
        txtClave =(EditText) findViewById(R.id.logTxtClave);
        labCuenta = (TextView) findViewById(R.id.logLabCuenta);
        btnSeguir = (Button) findViewById(R.id.logBtnSeguir);
        btnAcceder = (Button) findViewById(R.id.logBtnAcceder);// la conversion se hace acia la clase button
        btnAnterior = (Button) findViewById(R.id.logBtnAnterior);

        txtCuenta.requestFocus();//que el enfoque lo recupere la caja de texto cuenta al momento de
}

    private  boolean valida(){ //le alabamos

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    }
}
