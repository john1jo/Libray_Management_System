package com.example.librarymanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;
public class HelloController {
Database_Connectionclass dbc = new Database_Connectionclass();
Connection connection= dbc.connMethod();
    @FXML
    private Button cancelbtn;

    @FXML
    private Button logbtn;
    @FXML
    private RadioButton lab;

    @FXML
    private RadioButton stud;

    @FXML
    private TextField name;

    @FXML
    private PasswordField pass;

    @FXML
    private ToggleGroup type;

    public HelloController() throws ClassNotFoundException {
    }

    @FXML
    void cancelMethod(ActionEvent event) {
name.setText("");
pass.setText("");
    }

    @FXML
    void loginMethod(ActionEvent event) {
ResultSet res;
try{
//            if(type.getSelectedToggle().toString().equals("lab")) {
                String query = "select * from admin_login where username ='" + name.getText() + "' and password = '" + pass.getText() + "'";
                res = connection.createStatement().executeQuery(query);
                while (res.next()) {JOptionPane.showMessageDialog(null, "Welcome assistant " + name.getText());
                    FXMLLoader fx = new FXMLLoader(HelloApplication.class.getResource("admin.fxml"));
                    Scene sc = new Scene(fx.load(),600,400);
                    Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
                    st.setScene(sc);
                    st.show();

                }
//            }
//        else  if(type.getSelectedToggle().toString().equals("stud")){
//           /* String query = "select * from admin_login where username ='"+name.getText()+"' and password = '"+pass.getText()+"'";
//            res = connection.createStatement().executeQuery(query);
//            while (res.next()){
//
//            }*/
//            JOptionPane.showMessageDialog(null,"not supported yet ");
//    }
} catch (SQLException | IOException e) {
    e.printStackTrace();
}
    }
}
