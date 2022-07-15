package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.DBConnector.DBConector;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class CreateAccount implements Initializable {
    @FXML
    private ImageView imagebackcreate;
    @FXML
    private TextField txt_fullname, txt_Email, txt_phonenumber, txt_Uniquenumber, txt_choosepassword, txt_confirmpassword,txt_username,txt_pin;
    @FXML
    private Label lbl_erroraccount;
    @FXML
    private Button btn_createpassword;
    @FXML
    private RadioButton rdoUser,rdoadmin;
    Connection connection= null;
    PreparedStatement pst = null;
    ResultSet resultSet= null;
    DBConector dbConector = new DBConector() ;
    FileInputStream fis ;
    File file;

    public void handleButton(MouseEvent event) {
        if (rdoadmin.isSelected()){
            txt_pin.setVisible(true);
        }
        if (rdoUser.isSelected()){
            txt_pin.setVisible(false);
        }
        if (event.getSource() == btn_createpassword) {
            if (valid().equals("success")) {
                if (rdoadmin.isSelected()) {

                    String sql = "INSERT INTO admin(FullName, Email, PhoneNumber,UniqueNumber,UserName, Password, Pin) VALUES (?,?,?,?,?,?,?)";
                    try {
                        pst = connection.prepareStatement(sql);
                        pst.setString(1, txt_fullname.getText());
                        pst.setString(2, txt_Email.getText());
                        pst.setInt(3, Integer.parseInt(txt_phonenumber.getText()));
                        pst.setInt(4, Integer.parseInt(txt_Uniquenumber.getText()));
                        pst.setString(5, txt_username.getText());
                        pst.setString(6, txt_choosepassword.getText());
                        pst.setInt(7, Integer.parseInt(txt_pin.getText()));
                        pst.execute();
                        System.out.print("added");
                        txt_fullname.clear();
                        txt_Email.clear();
                        txt_phonenumber.clear();
                        txt_Uniquenumber.clear();
                        txt_username.clear();
                        txt_choosepassword.clear();
                        txt_confirmpassword.clear();
                        txt_pin.clear();
                        lbl_erroraccount.setTextFill(Color.rgb(148, 243, 242));
                        lbl_erroraccount.setText("Create Successfully");
                        lbl_erroraccount.setFont(Font.font("Verdana", 18));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (rdoUser.isSelected()){
                    String sql2= "INSERT INTO user(FullName,Email, PhoneNumber, UniqueNumber, UserName, Password) VALUES (?,?,?,?,?,?)";
                     try {
                         pst = connection.prepareStatement(sql2);
                         pst.setString(1, txt_fullname.getText());
                         pst.setString(2, txt_Email.getText());
                         pst.setInt(3, Integer.parseInt(txt_phonenumber.getText()));
                         pst.setInt(4, Integer.parseInt(txt_Uniquenumber.getText()));
                         pst.setString(5, txt_username.getText());
                         pst.setString(6, txt_choosepassword.getText());
                         pst.execute();
                         System.out.print("added");
                         txt_fullname.clear();
                         txt_Email.clear();
                         txt_phonenumber.clear();
                         txt_Uniquenumber.clear();
                         txt_username.clear();
                         txt_choosepassword.clear();
                         txt_confirmpassword.clear();
                         lbl_erroraccount.setTextFill(Color.rgb(148, 243, 242));
                         lbl_erroraccount.setText("Create Successfully");
                         lbl_erroraccount.setFont(Font.font("Verdana", 18));
                     } catch (Exception e) {
                         e.printStackTrace();
                     }
                }
            }
        }
        if (event.getSource()==imagebackcreate){
            try {
                Stage stage = new Stage();
                Node node = (Node) event.getSource();
                stage = (Stage) node.getScene().getWindow();
                stage.hide();


                Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
                stage.setTitle("BrotherHood");
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
        public String valid () {
            if (txt_fullname.getText().isEmpty() && txt_Email.getText().isEmpty() && txt_phonenumber.getText().isEmpty() && txt_Uniquenumber.getText().isEmpty() &&
                    txt_choosepassword.getText().isEmpty() && txt_confirmpassword.getText().isEmpty()) {
                lbl_erroraccount.setTextFill(Color.TOMATO);
                lbl_erroraccount.setFont(Font.font("Verdana", 18));
                lbl_erroraccount.setText("Please Enter All Value");
                return "error";
            }
            if (txt_fullname.getText().isEmpty()) {
                lbl_erroraccount.setTextFill(Color.TOMATO);
                lbl_erroraccount.setText("Please Enter FullName");
                lbl_erroraccount.setFont(Font.font("Verdana", 18));
                txt_fullname.setStyle("-fx-border-color: red;" + "-fx-background-color: transparent;" + "-fx-border-width: 0px 0px 2px 0px");
                return "error";
            }
            if (txt_Email.getText().isEmpty()) {
                lbl_erroraccount.setTextFill(Color.TOMATO);
                lbl_erroraccount.setText("Please Enter Email");
                lbl_erroraccount.setFont(Font.font("Verdana", 18));
                txt_Email.setStyle("-fx-border-color: red;" + "-fx-background-color: transparent;" + "-fx-border-width: 0px 0px 2px 0px");
                return "error";
            }
            if (txt_phonenumber.getText().isEmpty()) {
                lbl_erroraccount.setTextFill(Color.TOMATO);
                lbl_erroraccount.setText("Please Enter PhoneNumber");
                lbl_erroraccount.setFont(Font.font("Verdana", 18));
                txt_phonenumber.setStyle("-fx-border-color: red;" + "-fx-background-color: transparent;" + "-fx-border-width: 0px 0px 2px 0px");
                return "error";
            }
            if (txt_Uniquenumber.getText().isEmpty()) {
                lbl_erroraccount.setTextFill(Color.TOMATO);
                lbl_erroraccount.setText("Please Enter UniqueNumber");
                lbl_erroraccount.setFont(Font.font("Verdana", 18));
                txt_Uniquenumber.setStyle("-fx-border-color: red;" + "-fx-background-color: transparent;" + "-fx-border-width: 0px 0px 2px 0px");
                return "error";
            }
            if (txt_username.getText().isEmpty()){
                lbl_erroraccount.setTextFill(Color.TOMATO);
                lbl_erroraccount.setText("Please Enter User Name");
                lbl_erroraccount.setFont(Font.font("Verdana", 18));
                txt_username.setStyle("-fx-border-color: red;" + "-fx-background-color: transparent;" + "-fx-border-width: 0px 0px 2px 0px");
                return "error";
            }
            if (txt_choosepassword.getText().isEmpty()) {
                lbl_erroraccount.setTextFill(Color.TOMATO);
                lbl_erroraccount.setText("Please Enter Password");
                lbl_erroraccount.setFont(Font.font("Verdana", 18));
                txt_choosepassword.setStyle("-fx-border-color: red;" + "-fx-background-color: transparent;" + "-fx-border-width: 0px 0px 2px 0px");
                return "error";
            }
            if (txt_confirmpassword.getText().isEmpty()) {
                lbl_erroraccount.setTextFill(Color.TOMATO);
                lbl_erroraccount.setText("Please Enter ConfirmPassword");
                lbl_erroraccount.setFont(Font.font("Verdana", 18));
                txt_confirmpassword.setStyle("-fx-border-color: red;" + "-fx-background-color: transparent;" + "-fx-border-width: 0px 0px 2px 0px");
                return "error";
            }
            if (!txt_confirmpassword.getText().equals(txt_choosepassword.getText())){
                lbl_erroraccount.setTextFill(Color.TOMATO);
                lbl_erroraccount.setText("Password Confirm Not");
                lbl_erroraccount.setFont(Font.font("Verdana", 18));
                txt_confirmpassword.setStyle("-fx-border-color: red;" + "-fx-background-color: transparent;" + "-fx-border-width: 0px 0px 2px 0px");
                txt_choosepassword.setStyle("-fx-border-color: red;" + "-fx-background-color: transparent;" + "-fx-border-width: 0px 0px 2px 0px");
                return "error";
            }
            return "success";
        }
        @Override
        public void initialize (URL url, ResourceBundle resourceBundle){
            rdoUser.setSelected(true);
            connection = dbConector.getConnectionDB();
        }
    }
