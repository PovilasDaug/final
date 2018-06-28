package sample;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Controller2 implements Initializable {

    @FXML
    public TableView<Model> view;
    @FXML
    public TableColumn<Model, String> nameCo;
    @FXML
    public TableColumn<Model, String> ageCo;
    @FXML
    public TextField nameField;
    @FXML
    public TextField ageField;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        nameCo.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageCo.setCellValueFactory(new PropertyValueFactory<>("age"));
    }


    @FXML
    public void addLine() {


        SQLinserter in = new SQLinserter();
        in.insert(nameField.getText(), ageField.getText());

        String name = nameField.getText();
        String age = ageField.getText();

        Model model = new Model(name, age);
        //reikia atvaizduoti is DB
        view.getItems().add(model);
    }

    private ObservableList<Model> data;
    String url = "jdbc:sqlite:C:/Users/Admin/Documents/SQLiteStudio/finalDB";
    Connection conn = null;

    public void buildData() {
        data = FXCollections.observableArrayList();
        try {
            String SQL = "Select * from final Order By UserName";
            ResultSet rs = conn.createStatement().executeQuery(SQL);
            while (rs.next()) {
//                Model cm = new Model();
//                cm.setName(rs.getString("Vardas"));
//                Image img = new Image("tailoring/UserPhoto/User"+cm.getUserId().toString()+".jpg");

//                ImageView mv = new ImageView();
//                mv.setImage(img);
//                mv.setFitWidth(70);
//                mv.setFitHeight(80);
//                cm.userPhoto.set(mv);
//                cm.setName(rs.getString("Vardas"));
//                cm.setAge(rs.getString("Amzius"));
//
//                data.add(cm);
            }
            view.setItems(data);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }
}

