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
    public TableColumn<Model, String> idCo;
    @FXML
    public TableColumn<Model, String> nameCo;
    @FXML
    public TableColumn<Model, String> comCo;
    @FXML
    public TextField idField;
    @FXML
    public TextField nameField;
    @FXML
    public TextField comField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        SQLinserter in = new SQLinserter();
        List<Model> data = in.getData();
        lists.setAll(data);

        idCo.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCo.setCellValueFactory(new PropertyValueFactory<>("name"));
        comCo.setCellValueFactory(new PropertyValueFactory<>("comment"));

        view.setItems(lists);
    }

    @FXML
    public void addLine() {

        //sukuriam SQL inserteri

        SQLinserter in = new SQLinserter();

        //i lentele idedam nauja lentele.

        in.insert(idField.getText(), nameField.getText(), comField.getText());

        List<Model> data = in.getData();

        lists.setAll(data);

    }





}



