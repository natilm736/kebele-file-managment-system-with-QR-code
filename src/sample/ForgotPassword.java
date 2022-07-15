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

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class ForgotPassword implements Initializable {
    @FXML
    private ImageView image_back;
    @FXML
    private TextField txt_forgotemail,txt_forgotphonenumber,txt_forgotUnique;
    @FXML
    private Button btn_conform;
    @FXML
    private Label lal_forgot;
    @FXML
    private RadioButton userrdo,adminrdo;

    Connection connection =null;
    PreparedStatement pst = null;
    ResultSet resultSet = null;
    DBConector dbConector = new DBConector();

    public void handleButton(MouseEvent event) {
        if (event.getSource()== btn_conform) {
            String email = txt_forgotemail.getText();
            String phone = txt_forgotphonenumber.getText();
            String uniq = txt_forgotUnique.getText();
           if (adminrdo.isSelected()) {
               if (valid().equals("success")) {
                   try {
                       pst = connection.prepareStatement("SELECT  `Password`, `Pin` FROM `admin` WHERE `Email` =? And `PhoneNumber` = ? AND `UniqueNumber` =?");
                       pst.setString(1, email);
                       pst.setString(2, phone);
                       pst.setString(3, uniq);
                       resultSet = pst.executeQuery();
                       if(resultSet.next()) {
                           lal_forgot.setText("Password is : " + resultSet.getString("Password") + " Pin is : " + resultSet.getString("Pin"));
                           lal_forgot.setTextFill(Color.rgb(154, 243, 242));
                       }else {
                           lal_forgot.setText("Email or Unique Number or Phone number is not match");
                           lal_forgot.setTextFill(Color.TOMATO);
                           lal_forgot.setFont(Font.font("Verdana", 18));
                       }
                   } catch (Exception e) {

                   }
               }
           }
            if (userrdo.isSelected()){
                if (valid().equals("success")) {
                    try {
                        pst=connection.prepareStatement("SELECT `Password` FROM `user` WHERE `Email` =? And `PhoneNumber` = ? AND `UniqueNumber` =?");
                        pst.setString(1,email);
                        pst.setString(2,phone);
                        pst.setString(3,uniq);
                        resultSet= pst.executeQuery();
                        if(resultSet.next()){
                            lal_forgot.setText("Password is : " + resultSet.getString("Password"));
                            lal_forgot.setTextFill(Color.rgb(154,243,242));
                        }else {
                            lal_forgot.setText("Email or Unique Number or Phone number is not match");
                            lal_forgot.setTextFill(Color.TOMATO);
                            lal_forgot.setFont(Font.font("Verdana", 18));
                        }
                    } catch (Exception e){
                    }
                }
            }
           }
        if (event.getSource()== image_back){
            try {
                Stage stage= new Stage();
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
      public String valid(){
        if (txt_forgotemail.getText().isEmpty() && txt_forgotphonenumber.getText().isEmpty() && txt_forgotUnique.getText().isEmpty()) {
            lal_forgot.setTextFill(Color.TOMATO);
            lal_forgot.setFont(Font.font("Verdana", 20));
            lal_forgot.setText("Enter All Value ");
            return "error";
        }
         if (txt_forgotemail.getText().isEmpty()){
             lal_forgot.setTextFill(Color.TOMATO);
             lal_forgot.setFont(Font.font ("Verdana", 20));
             lal_forgot.setText("Enter Email ");
             txt_forgotemail.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
             return "error";
         }
         if (txt_forgotphonenumber.getText().isEmpty()){
             lal_forgot.setTextFill(Color.TOMATO);
             lal_forgot.setFont(Font.font ("Verdana", 20));
             lal_forgot.setText("Enter Phone Number ");
             txt_forgotphonenumber.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
             return "error";
         }
         if (txt_forgotUnique.getText().isEmpty()){
             lal_forgot.setTextFill(Color.TOMATO);
             lal_forgot.setFont(Font.font ("Verdana", 20));
             lal_forgot.setText("Enter Kebele Unique Number ");
             txt_forgotUnique.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
             return "error";
         }
          return "success";
        }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        connection = dbConector.getConnectionDB();
        userrdo.setSelected(true);
    }

}
