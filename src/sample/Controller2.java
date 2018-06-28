package sample;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

    private void setCellToTable(){
        nameCo.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageCo.setCellValueFactory(new PropertyValueFactory<>("age"));
    }



}

