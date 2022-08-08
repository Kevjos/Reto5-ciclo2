package co.reto5.informesminviviendaDAL;

import java.sql.*;

public class conexion {

    String strConxionDB = "jdbc:sqlite:ProyectosConstruccion.db";
    Connection conn = null;

    public conexion() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(strConxionDB);
            
            System.out.println("Conexion establacida");
        } catch (Exception e) {
            System.out.println("Error de conexion " + e);
        }
    }

    public int ejecutarSentenciaSQL(String strSentenciaSQL){
        try {
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            pstm.execute();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }
    
    public ResultSet consultarRegistros(String strSentenciaSQL){
        try {
           
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;
            
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
}

