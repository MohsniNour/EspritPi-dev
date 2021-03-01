/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import entities.Student;
import entities.User;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import services.StudentService;

/**
 * FXML Controller class
 *
 * @author rayen
 */
public class Display_Student_FXMLController implements Initializable {

    @FXML
    private AnchorPane AnchorPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         // role table view
        JFXTreeTableColumn<User, String> role = new JFXTreeTableColumn<>("role");
        role.setPrefWidth(150);
        role.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getRole());
            }
        });

        // name table view
        JFXTreeTableColumn<User, String> name = new JFXTreeTableColumn<>("name");
        name.setPrefWidth(150);
        name.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getName());
            }
        });
        
         // last_name table view
        JFXTreeTableColumn<User, String> last_name = new JFXTreeTableColumn<>("last_name");
        last_name.setPrefWidth(150);
        last_name.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getLast_name());
            }
        });
        
         // cin table view
        JFXTreeTableColumn<User, String> cin = new JFXTreeTableColumn<>("cin");
        cin.setPrefWidth(150);
        cin.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return new SimpleStringProperty(Integer.toString(param.getValue().getValue().getCin()));
            }
        });
        
         // email table view
        JFXTreeTableColumn<User, String> email = new JFXTreeTableColumn<>("email");
        email.setPrefWidth(150);
        email.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return new SimpleStringProperty(param.getValue().getValue().getEmail());
            }
        });
        
         // phone_number table view
        JFXTreeTableColumn<User, String> phone_number = new JFXTreeTableColumn<>("phone_number");
        phone_number.setPrefWidth(150);
        phone_number.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return new SimpleStringProperty(Integer.toString(param.getValue().getValue().getPhone_number()));
            }
        });
        
          // birth_date table view
//        JFXTreeTableColumn<User, String> birth_date = new JFXTreeTableColumn<>("birth_date");
//        birth_date.setPrefWidth(150);
//        birth_date.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>(){
//            @Override
//            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
//                return new SimpleStringProperty(Date.toString(param.getValue().getValue().getBirth_date()));
//            }
//        });
       
        StudentService ps = new StudentService();
        List<Student> myLst;
        myLst = ps.listStudent();
        ObservableList<User> students = FXCollections.observableArrayList();

        myLst.forEach(p -> students.add(p));
        JFXTreeTableView<User> treeview = new JFXTreeTableView<>();
        final TreeItem<User> root = new RecursiveTreeItem<User>(students, RecursiveTreeObject::getChildren);
        treeview.getColumns().setAll(name, last_name, role, cin, email, phone_number);
        treeview.setRoot(root);
        treeview.setShowRoot(false);
        AnchorPane.getChildren().add(treeview);
        
        
    }    
    
}
