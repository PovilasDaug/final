package sample;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class Controller implements Initializable {

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
    String url = "jdbc:sqlite:C:/Users/Admin/Documents/SQLiteStudio/final";
    Connection conn = null;
}

