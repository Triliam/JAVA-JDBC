package application;

import db.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ProgramaCreate {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pst = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try{
            conn = DB.criaConnection();
//            pst = conn.prepareStatement("INSERT INTO seller(Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
//
//            pst.setString(1, "Taís");
//            pst.setString(2, "t@gmail.com");
//            pst.setDate(3, new java.sql.Date(sdf.parse("22/04/2000").getTime()));
//            pst.setDouble(4, 3000.0);
//            pst.setInt(5, 4);

            //para adicionar mais de uma linha na tabela, atenção as aspas simples.
            pst = conn.prepareStatement("INSERT INTO department (Name) VALUES ('D1'),('D2')", Statement.RETURN_GENERATED_KEYS);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0){
                ResultSet rs = pst.getGeneratedKeys();
                while (rs.next()){
                    int id = rs.getInt(1); //pega o id da linha 1
                    System.out.println("Pronto! Id = " +  id);
                }
            } else {
                System.out.println("Linhas afetadas: 0 " );
            }


        }catch (SQLException e){
            e.printStackTrace();
//        }catch (ParseException e) {
//            e.printStackTrace();
        }finally {
            DB.closePrepareStatement(pst);
            DB.closeConnection();
        }

    }
}
