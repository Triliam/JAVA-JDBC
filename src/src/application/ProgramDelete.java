package application;

import db.DB;
import db.DbIntegrityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProgramDelete {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pst = null;

        try{
            conn = DB.criaConnection();
            pst = conn.prepareStatement("DELETE FROM department WHERE id = ?");
            pst.setInt(1,2);
            int rowsAffected = pst.executeUpdate();

            System.out.println("Feito! linhas afetadas: " + rowsAffected);

        }catch (SQLException e){
            throw new DbIntegrityException(e.getMessage()) ;
        } finally {
            DB.closePrepareStatement(pst);
            DB.closeConnection();
        }
    }
}
