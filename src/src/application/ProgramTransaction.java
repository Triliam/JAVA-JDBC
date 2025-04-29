package application;

import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProgramTransaction {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = DB.criaConnection();

            //para não ser aprovado automaticamente e sim a partir de codigo
            conn.setAutoCommit(false);

            st = conn.createStatement();
            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

            //erro proposital
//            int x = 1;
//            if(x<2){
//                throw new SQLException("Fake error");
//            }
            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

            //confirmaçao do termino da transação
            conn.commit();
        } catch (SQLException e) {
            try{
                conn.rollback();
                throw new DbException("Transaction rolled back! " + e.getMessage());
            }catch (SQLException e1) {
                throw new DbException("Error tryng to rollback! " + e1.getMessage());
            }
        }
    }
}
