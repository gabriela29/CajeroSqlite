package upeu.edu.pe;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by GABY on 04/11/2015.
 */
public class BDAdmin { //o bd adpater para administrar la base de datos
    private BDHelper helper;
    private Context contexto;
//
    public BDAdmin(Context contexto){//constructor que reciba el contexto inicializamos el helper
        this.contexto = contexto;//inicializa dos variables una es el contexto y otro es el ayudante de la manipulacion de base de datos
        helper = null;
    }
    public SQLiteDatabase getBDEscribir(){//que obtengamos la base de datos para escribir la correspondiente base de datos
     return helper.getWritableDatabase();//este es para obtener la base de datos lista para escribir
    }

    public SQLiteDatabase getBDleer(){//que obtengamos la base de datos para leer la correspondiente base de datos
        return helper.getReadableDatabase();//este es para tener la base de datos lista para leer
    }
     public void abrirBD(){//para que el helper no sea nulo tenemos que tener unos metodos que nos permitan abrir la base de datos
        helper = new BDHelper(contexto);//creamos un nuevo objeto de tipo heleper con la base de datos

     }

    public void cerrarBD(){//OTRO METOIDO QUE PERMITA CERRAR
       if(helper !=null ) {//si helper es diferente de nulo que helper cierre
       helper.close();
          helper = null; //para que destruya la referencia
       }
       }
}
