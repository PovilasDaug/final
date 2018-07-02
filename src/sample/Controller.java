package sample;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Controller implements Initializable {

    private ObservableList lists = FXCollections.observableArrayList();

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

//        System.out.println("BBBBBBBBBBBBBBBBBBBb");
        SQLinserter in = new SQLinserter();
        List<Model> data = in.getData();
        lists.setAll(data);

        nameCo.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageCo.setCellValueFactory(new PropertyValueFactory<>("age"));
        view.setItems(lists);


    }

    @FXML
    public void addLine() {

        SQLinserter in = new SQLinserter();
        in.insert(nameField.getText(), ageField.getText());

        String name = nameField.getText();
        String age = ageField.getText();

        Model model = new Model(name, age);

      //  List<Model> data = in.getData();
       // lists.setAll(data);
        //reikia atvaizduoti is DB
        //view.getItems().add(model);

        List<Model> data = in.getData();
        lists.setAll(data);

    }





}



