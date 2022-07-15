package sample;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController  implements Initializable {
    @FXML
    private Button btn_login;
    @FXML
    private TextField txt_username,passwordText,PinText;
    @FXML
    private PasswordField passwordHidden,PinHidden;
    @FXML
    private RadioButton userRdo, adminRdo;
    @FXML
    private CheckBox showcheckbox,showPinCheckbox;
    @FXML
    private FontAwesomeIconView keyFont;
    @FXML
    private Label lbl_createAccount,lbl_forgetpassword;

    @FXML
    private Label wrong_lbe;
    Connection connection= null;
    PreparedStatement pst = null;
    ResultSet resultSet= null;
    DBConector dbConector = new DBConector() ;
    FileInputStream fis ;
    File file;
    public void handleButton(MouseEvent event) throws IOException {

        if (event.getSource() == btn_login){
            if (userRdo.isSelected()){
                if (Userlogin().equals("Success")){
                    try {
                        Stage stage= new Stage();
                        Node node = (Node) event.getSource();
                        stage = (Stage) node.getScene().getWindow();
                        stage.hide();


                        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                        stage.setTitle("BrotherHood");
                        stage.setResizable(false);
                        stage.setScene(new Scene(root));
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
            if (adminRdo.isSelected()){
                if (adminlogin().equals("success")){
                    try {
                        Stage stage= new Stage();
                        Node node = (Node) event.getSource();
                        stage = (Stage) node.getScene().getWindow();
                        stage.hide();


                        Parent root = FXMLLoader.load(getClass().getResource("AdminSean.fxml"));
                        stage.setTitle("BrotherHood");
                        stage.setResizable(false);
                        stage.setScene(new Scene(root));
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            }
        if (event.getSource()==lbl_createAccount){
            try {
                Stage stage= new Stage();
                Node node = (Node) event.getSource();
                stage = (Stage) node.getScene().getWindow();
                stage.hide();


                Parent root = FXMLLoader.load(getClass().getResource("createAccount.fxml"));
                stage.setTitle("BrotherHood");
                stage.setResizable(false);
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (event.getSource()==lbl_forgetpassword){
            try {
                Stage stage= new Stage();
                Node node = (Node) event.getSource();
                stage = (Stage) node.getScene().getWindow();
                stage.hide();


                Parent root = FXMLLoader.load(getClass().getResource("ForgotPassword.fxml"));
                stage.setTitle("BrotherHood");
                stage.setResizable(false);
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            }
    public void getchoice(){
        if (userRdo.isSelected()){
            PinHidden.setVisible(false);
            PinText.setVisible(false);
            showPinCheckbox.setVisible(false);
            keyFont.setVisible(false);
            txt_username.setPromptText("User name");
        }
        if (adminRdo.isSelected()){
            PinHidden.setVisible(true);
            PinText.setVisible(true);
            showPinCheckbox.setVisible(true);
            keyFont.setVisible(true);
            txt_username.setPromptText("Admin name");

        }
    }
    public void visiblePword(ActionEvent event){
        if (showcheckbox.isSelected()) {
            passwordText.setText (passwordHidden.getText());
            passwordText.setVisible(true);
            passwordHidden.setVisible(false);
            return;
        }
        passwordHidden.setText (passwordText.getText());
        passwordHidden.setVisible(true);
        passwordText.setVisible(false);
    }
    public void visiblePin(ActionEvent event){
        if (showPinCheckbox.isSelected()) {
            PinText.setText(PinHidden.getText());
            PinText.setVisible(true);
            PinHidden.setVisible(false);
            return;
        }
        PinHidden.setText (PinText.getText());
        PinHidden.setVisible(true);
        PinText.setVisible(false);

    }

    private String Userlogin(){
        String username = txt_username.getText();
        String password = passwordHidden.getText();
        String sqluser ="SELECT * FROM `user` WHERE `UserName`=? AND `Password`=?";
        try {
           pst =connection.prepareStatement(sqluser);
           pst.setString(1,username);
           pst.setString(2,password);
           resultSet =pst.executeQuery();
           if (!resultSet.next()){
               wrong_lbe.setTextFill(Color.TOMATO);
               wrong_lbe.setText("Incorrect Username & Password ");
               wrong_lbe.setFont(Font.font("Verdana", 18));
               passwordHidden.setStyle("-fx-border-color: red;" + "-fx-background-color: transparent;" + "-fx-border-width: 0px 0px 2px 0px");
               txt_username.setStyle("-fx-border-color: red;" + "-fx-background-color: transparent;" + "-fx-border-width: 0px 0px 2px 0px");
               return "error";
           }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "Success";
    }
    public String adminlogin(){
        try {
        String username = txt_username.getText();
        String password = passwordHidden.getText();
        String pin =PinHidden.getText();
        String sqladmin ="SELECT * FROM `admin` WHERE `UserName`=? AND `Password`=? AND `Pin`=?";

            pst =connection.prepareStatement(sqladmin);
            pst.setString(1,username);
            pst.setString(2,password);
            pst.setString(3,pin);
            resultSet =pst.executeQuery();
            if (!resultSet.next()){
                wrong_lbe.setTextFill(Color.TOMATO);
                wrong_lbe.setText("Incorrect AdminName Password & Pin ");
                wrong_lbe.setFont(Font.font("Verdana", 18));
                passwordHidden.setStyle("-fx-border-color: red;" + "-fx-background-color: transparent;" + "-fx-border-width: 0px 0px 2px 0px");
                txt_username.setStyle("-fx-border-color: red;" + "-fx-background-color: transparent;" + "-fx-border-width: 0px 0px 2px 0px");
                PinHidden.setStyle("-fx-border-color: red;" + "-fx-background-color: transparent;" + "-fx-border-width: 0px 0px 2px 0px");
                return "error";
            }
        } catch (Exception throwables) {
           System.out.print(throwables);
        }
        return "success";
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      userRdo.setSelected(true);
      connection = dbConector.getConnectionDB();
        getchoice();
    }
}


