package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLinserter
{
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    ResultSet rs = null;
    ObservableList<Model> data = FXCollections.observableArrayList();

    private Connection connect() {

        String url = "jdbc:sqlite:C:/Users/Admin/Documents/SQLiteStudio/finalDB";

        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "dsasadsa");
            e.printStackTrace();
            System.exit(123);
        }
        return conn;
    }


    public void insert(String id, String name, String comment) {
        String sql = "INSERT INTO final(id,name,comment) VALUES(?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, comment);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "asdasdas");
        }
    }
    public List<Model> getData(){
        String sql = "select id, name, comment from final";
        List<Model> list = new ArrayList<>();
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Model newEntry = new Model(rs.getString(1),rs.getString(2),rs.getString(3));
                list.add(newEntry);
            }
            System.out.println("Įrašų skaičius DB: "  + list.size() );

        } catch (SQLException e) {
            System.out.println(e.getMessage() +"SQL klauida");
            System.err.println(e + "SQL Klaida2");
        }

        return list;
    }
}










