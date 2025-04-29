package application;

import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProgramRead {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        //Para consultar e exibir os dados: utiliza as interfaces: Statement para montar o comando SQL que será executado e ResultSet para apresentar esse resultado da query SQL.
        try{
            //cria a conexão
            conn = DB.criaConnection();

            //metodo da interface Connection cria uma Statement que serve para monta o comando SQL.
            //*Statement não é tão seguro, no próximo será usado o PreparedStatement.
            st = conn.createStatement();

            //metodo da interface Statement que retorna uma ResultSet para apresentar o resultado obtido na query.
            rs = st.executeQuery("select * from department");

            //metodo next() da interface ResultSet para mostrar os resultados.
            while(rs.next()) {
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
            }
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
            DB.closeConnection();
        }

    }
}
