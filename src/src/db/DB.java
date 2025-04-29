package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {
    private static Connection conn = null;

    //metodo para conectar com o banco. Connection, usada para executar SQL, gerenciar transações e acessar metadados.
    //Properties pega os dados que o metodo loadProperties passa.
    //DriverManager gerencia o driver jdbc para fazer a conexão com o banco.
    public static Connection criaConnection(){

        if(conn == null){
            try {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
            }
            catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }


    //metodo para criar um fluxo de entrada e ler o arquivo db.properties (onde tem os dados para a conexão com o banco de dados). Le o arquivo com a classe FileInputStream, abre um fluxo de entrada.
    //Properties carrega os dados, as propriedades contendo chave e valor(como é o arquivo db.properties).
    private static Properties loadProperties(){
        try (FileInputStream fs = new FileInputStream("db.properties")){
                Properties props = new Properties();
                props.load(fs);
                return props;
        }
        catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void closeConnection(){
        if (conn !=null){
            try{
                conn.close();
            }
            catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
    public static void closePrepareStatement(PreparedStatement pst) {
        if (pst != null) {
            try {
                pst.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}
