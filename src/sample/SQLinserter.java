package sample;

import java.sql.*;

public class SQLinserter
{


    private Connection conn = null;

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

    /**
     * Insert a new row into the warehouses table
     *
     * @param name
     * @param age
     */
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

    private void loadDataFromDB() throws SQLException {


        try (Connection conn2 = this.connect();

        PreparedStatement pst = conn2.prepareStatement("Select * from final");
        ResultSet rs =

        {


        }





    }


    }


