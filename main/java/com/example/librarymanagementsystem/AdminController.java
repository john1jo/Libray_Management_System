package com.example.librarymanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminController {
    Database_Connectionclass dbc = new Database_Connectionclass();
    Connection connection = dbc.connMethod();
    Connection conn;
    PreparedStatement prs;

    @FXML
    private Button ADD_B;

    @FXML
    private Button DELETE_B;

    @FXML
    private RadioButton FEMALE;

    @FXML
    private RadioButton MALE;

    @FXML
    private Button UPDATE_B;

    @FXML
    private TextField book_aut;

    @FXML
    private TextField book_na;

    @FXML
    private TextField book_publi;

    @FXML
    private TextField bookid;

    @FXML
    private Button delete;

    @FXML
    private TextField email;

    @FXML
    private Button green;

    @FXML
    private AnchorPane greenAnchor;

    @FXML
    private TextField id;

    @FXML
    private Button insert;

    @FXML
    private TextField name;

    @FXML
    private TextField password;

    @FXML
    private Button red;

    @FXML
    private AnchorPane redAnchor;

    @FXML
    private ToggleGroup sex;

    @FXML
    private Button update;



    public AdminController() throws ClassNotFoundException {
    }

    @FXML
    void showGreen(ActionEvent event) {
        redAnchor.setVisible(false);
        greenAnchor.setVisible(true);
    }

    @FXML
    void showRed(ActionEvent event) {
        redAnchor.setVisible(true);
        greenAnchor.setVisible(false);
    }




    @FXML
    void addbookmth(ActionEvent event) {

        String sql = "INSERT INTO add_book(book_name,book_id,book_auther,publishet) VALUES (?,?,?,?)";

        PreparedStatement prs;
        try {
            prs = connection.prepareStatement(sql);
            prs.setString(1, book_na.getText());
            prs.setString(2, bookid.getText());
            prs.setString(3, book_aut.getText());
            prs.setString(4, book_publi.getText());

            int i = prs.executeUpdate();
            if (i == 1) {

                JOptionPane.showMessageDialog(null, "Data Inserted succsecfully");
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Try again!!");
            e.printStackTrace();
        }
        System.out.println();
    }
    @FXML
    void deletemth(ActionEvent event) {
        Database_Connectionclass db = new Database_Connectionclass();

        String lbl1 = bookid.getText();
        String sql = "DELETE FROM add_book WHERE book_id='" + lbl1 + "'";

        try {
            conn = db.connMethod();
            prs = conn.prepareStatement(sql);

            prs.executeUpdate();

            JOptionPane.showMessageDialog(null, "Deleted succsecfully");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Try again!!");
        }
    }


    @FXML
    void updateMt(ActionEvent event) {
        String sql = "UPDATE add_book SET book_name= ?,book_auther=?,publishet=? WHERE book_id='" + bookid.getText() + "'";

        try {
            prs = connection.prepareStatement(sql);
            prs.setString(1, book_na.getText());
            prs.setString(2, book_aut.getText());
            prs.setString(3, book_publi.getText());
            int i = prs.executeUpdate();
            if (i == 1) {

                JOptionPane.showMessageDialog(null, "Updated succsecfully");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Try again!!");
        }
    }

    @FXML
    void InsertionMtd(ActionEvent event) {
        String sql = "INSERT INTO add_member(Name,id,sex,pass,email) VALUES (?,?,?,?,?)";
        String str = null;
        if (MALE.isSelected()) {
            str = "male";
        } else if (FEMALE.isSelected()) {
            str = "female";
        }
        PreparedStatement prs;
        try {
            prs = connection.prepareStatement(sql);
            prs.setString(1, name.getText());
            prs.setString(2, id.getText());
            prs.setString(3, str);
            prs.setString(4, password.getText());
            prs.setString(5, email.getText());
            int i = prs.executeUpdate();
            if (i == 1) {

                JOptionPane.showMessageDialog(null, "Data Inserted succsecfully");
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        System.out.println();
    }

    @FXML
    void deleteMtd(ActionEvent event) {

        Database_Connectionclass db = new Database_Connectionclass();

        String lbl1 = id.getText();
        String sql = "DELETE FROM add_member WHERE id='" + lbl1 + "'";
        //String lbl1 = stud_id.getText();
        try {
            conn = db.connMethod();
            prs = conn.prepareStatement(sql);
            //prs.setString(1, lbl1);
            prs.executeUpdate();

            JOptionPane.showMessageDialog(null, "Deleted succsecfully");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Try again!!");
        }
    }


    @FXML
    void updateMtd(ActionEvent event) throws ClassNotFoundException {

        Database_Connectionclass db = new Database_Connectionclass();
        conn = db.connMethod();
        String str = null;
        if (MALE.isSelected()) {
            str = "male";
        } else if (FEMALE.isSelected()) {
            str = "female";
        }
        String sql = "UPDATE add_member SET name= ?,sex=?,pass=?,email=? WHERE id='" + id.getText() + "'";

        try {
            prs = connection.prepareStatement(sql);
            prs.setString(1, name.getText());
            prs.setString(2, str);
            prs.setString(3, password.getText());
            prs.setString(4, email.getText());
            int i = prs.executeUpdate();
            if (i == 1) {

                JOptionPane.showMessageDialog(null, "Updated succsecfully");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Try again!!");
        }
    }
}

