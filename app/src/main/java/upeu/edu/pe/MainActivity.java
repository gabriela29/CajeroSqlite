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
import android.widget.Toast;

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
    mostrarYocultar(true);
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

    private  boolean valida(EditText txt){ //metodo que perrmite validar si la caja de texto tiene informacion o no
        if(txt == txtCuenta){
            strsCuenta = txtCuenta.getText().toString()+""; //strt va ser igual a lo que esta en la caja de texto cuenta
            //to string nos devuelve la cadena que contiene el texto y eso lo concatenamos con una cadena vacia
            //para k cuando sea nulo la cadena no se asigne nulo  a nuestra cadena de comprobacion
            if(strsCuenta.length()==0){//preguntamos si la cena la longitud es igual  a 0 si eso es asi return false
                return false;
            }
        }else {
            strClave = txtClave.getText().toString()+"";
            if(strsCuenta.length()==0){
                return false;
            }
        }
        return true;//retuurna true o false
    }

    public void LogSeguir(View view){//invocamosla desde interfaz   con el dato de view
    if (valida(txtCuenta)){//va validar si valida en la caja cuenta para que la identifique cuando entre en el
        if(true){//si la cuenta existe o no
            mostrarYocultar(false);
            Toast.makeText(this,"Si existe el usuario",Toast.LENGTH_SHORT).show();
        }
    }else{//si no enviaremos un mensaje
        Toast.makeText(this,"No existe el usuario",Toast.LENGTH_SHORT).show();
        //clase toast la secuencia de caracteres que queremos mostrar para
        //ponemos lenght short por queremos que la duracion del mensaje en pantalla sea corto lo muestro con .show
    }

    }
    public void logAnterior(View view){//va llamar al metodo mostrar y ocultar
        mostrarYocultar(true);
    }

    private void mostrarYocultar(boolean visible){//recibe un bolean al cual se le envia una variable
    //para ver si es visible para ver si es visible o no es true kiere decir k es visible cuando
        //falso quiere decir que la ventana invisible se hace visible la segunda ventana
        int vcuenta =(visible)? View.VISIBLE : View.INVISIBLE;//tendra el valor de visible en caso contrario inv
        int vClave =(!visible)? View.VISIBLE : View.INVISIBLE;

        txtCuenta.setVisibility(vcuenta);//que sea la visibilidad que obtuvo la cuenta
        btnSeguir.setVisibility(vcuenta);

        labCuenta.setVisibility(vClave);
        txtClave.setVisibility(vClave);
        btnAcceder.setVisibility(vClave);
        btnAnterior.setVisibility(vClave);
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
