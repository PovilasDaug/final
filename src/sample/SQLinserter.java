package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.logging.Logger;

public class SQLinserter
{


    private Connection conn = null;
    private PreparedStatement pstmt = null;
    ResultSet rs = null;
    ObservableList<Model> data = FXCollections.observableArrayList();

    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/Users/Admin/Documents/SQLiteStudio/finalDB";

        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.exit(123);
        }
        return conn;
    }


    public void insert(String name, String age) {
        String sql = "INSERT INTO final(name,age) VALUES(?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, age);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

//    private void loadDataFromDB() throws SQLException {
//
//
//        try (Connection conn2 = this.connect();
//
//        ResultSet rs = conn2.createStatement().executeQuery("SELECT * FROM filan");
//
//        while (rs.next()){
//            data.add(new Model(rs.getString("name"),rs.getString("age"));
//
//        }
//        catch (SQLException ex){
//            System.out.println("smthg");
//        }
//
//    }


        }










