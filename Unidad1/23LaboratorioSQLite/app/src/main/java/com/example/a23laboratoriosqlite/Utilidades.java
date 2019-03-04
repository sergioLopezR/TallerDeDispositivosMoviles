package com.example.a23laboratoriosqlite;

public class Utilidades {

    public static String TABLA = "CLIENTE";
    public static String IDCLIENTE = "IDCLIENTE";
    public static String NOMBRE = "NOMBRE";
    public static String RFC = "RFC";
    public static String CEL="CEL";
    public static String DESCRIPCIONDEOBRA="DESCRIPCIONDEOBRA";
    public static String COSTOBASE="COSTOBASE";
    public static String ID="_id";

    public static final String DBNAME="BASEDEDATOS";


    public static String CREAR_TABLA="CREATE TABLE "+TABLA+"("+
            ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            IDCLIENTE+" TEXT NOT NULL, "+
            NOMBRE+" TEXT, "+
            RFC+" TEXT, " +
            CEL+" TEXT, " +
            DESCRIPCIONDEOBRA+" TEXT, " +
            COSTOBASE+" TEXT)";

}
