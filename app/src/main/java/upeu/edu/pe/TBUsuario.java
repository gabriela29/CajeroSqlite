package upeu.edu.pe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by GABY on 04/11/2015.
 */
public class TBUsuario implements BDConstantes{ //implaementamos la interfaz bd contantes
    //para poder utilizar de manera natural las constantes definidas para la manipulacion de los tipos de datos

    //tabla
    private static final String TB_NOMBRE = "tbusuario";

    //Campos
    private static  final String CM_ID = "idusuario";
    private static  final String CM_NOMBRE = "nombre";
    private static  final String CM_CUENTA = "cuenta";
    private static  final String CM_CLAVE = "clave";
    private static  final String CM_REGISTRO = "registro"; //FECHA de registro

    public static  final  String CREAR = "CREATE TABLE" +//CRAEAR LA TABLA
            TB_NOMBRE + " ( "+
            CM_ID + TIPO_ENTERO + LLAV_PRIMARIA + NO_NULO + VALOR_X_DEFECTO + "0" + COMA +
            CM_NOMBRE + TIPO_TEXTO + NO_NULO + VALOR_X_DEFECTO + "''"+ COMA +
            CM_CUENTA + TIPO_TEXTO + NO_NULO + VALOR_X_DEFECTO + "''"+ COMA +
            CM_CLAVE + TIPO_TEXTO + NO_NULO + VALOR_X_DEFECTO + "'1234'" +
            CM_REGISTRO + TIPO_FECHA + NO_NULO + VALOR_X_DEFECTO + "'1900-01-01'" +
            "}" + FIN;

    private static final String [] vecColumnas = {CM_ID, CM_NOMBRE, CM_CUENTA, CM_CLAVE, CM_REGISTRO };
    private static final String strColumnas = CM_ID + COMA + CM_NOMBRE + COMA + CM_CUENTA + COMA + CM_CLAVE + COMA + CM_REGISTRO;

    public final String INSERTAR_DATOS_INICIALES =
                 "INSERT INTO " + TB_NOMBRE + "{" + strColumnas + "} VALUES ( " +
                "92, 'GABRIELA AUQUI', 'ADMIN', '1234','2015-06-01'}" ;

    private BDAdmin bdAdmin;

    private TBUsuario(BDAdmin bdAdmin){
        this.bdAdmin = bdAdmin;
    }

    private ContentValues getValores (int id, String nombre, String cuenta, String clave, String fecha){
        ContentValues cv = new ContentValues();//definimos una variable
        cv.put(CM_ID, id);//fijamos la llave y el contenido
        cv.put(CM_NOMBRE, nombre);
        cv.put(CM_CUENTA, cuenta);
        cv.put(CM_CLAVE, clave);
        cv.put(CM_REGISTRO, fecha);

        return cv;
    }


    public  boolean insertar(int id, String nombre, String cuenta, String clave, String fecha) {
        SQLiteDatabase db = bdAdmin.getBDEscribir();
        ContentValues cv = getValores(id, nombre, cuenta, clave, fecha);
        long k = db.insert(TB_NOMBRE, null, cv);

        return (k != -1);

    }
    //public Cursor seleccionar(SQLiteDatabase)
    }

