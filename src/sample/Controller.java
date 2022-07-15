package sample;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import sample.Connector.*;
import sample.DBConnector.DBConector;

import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Controller<cb> implements Initializable {
              ////KEBELE FORM
//Buttons
    @FXML
    private Button btn_house,btn_id,btn_kebelehouse,btn_birth,btn_logout,btn_unemployed,btn_organizing,btn_marriage,btn_access;
// Anchors
    @FXML
    private AnchorPane pn_House,pn_form,pn_id,pn_kebeleHouse,pn_childrenStatus,pn_birthCerteficate,pn_unemployed,pn_organizing,pn_merriageCertificate,pn_Access;
//Image
    @FXML
    private ImageView img_back2;
               ////House
//Image
    @FXML
    private ImageView img_back1;
//choice box
    @FXML
    private ChoiceBox<String> choiceBHouseChilde;
    private String[] numbers = {"0","1","2","3","4","5","6","7","8","9","10"};
//text field
    @FXML
    private TextField txt_HName1,txt_HName2,txt_HName3,txt_HName4,txt_HName5,txt_HName6,txt_HName7,txt_HName8,txt_HName9,txt_HName10;
    @FXML
    private TextField rdoHAge1,rdoHAge2,rdoHAge3,rdoHAge4,rdoHAge5,rdoHAge6,rdoHAge7,rdoHAge8,rdoHAge9,rdoHAge10;
    @FXML
    private TextField search_House,txt_HFatherName,txt_HMatherName,txt_HhouseNumber,txt_HPNumber;
//Radio Button
    @FXML
    private RadioButton rdoHmale1,rdoHmale2,rdoHmale3,rdoHmale4,rdoHmale5,rdoHmale6,rdoHmale7,rdoHmale8,rdoHmale9,rdoHmale10;
    @FXML
    private RadioButton rdoHfemal1,rdoHfemal2,rdoHfemal3,rdoHfemal4,rdoHfemal5,rdoHfemal6,rdoHfemal7,rdoHfemal8,rdoHfemal9,rdoHfemal10;
//Date Picker
    @FXML
    private DatePicker datePickerHFile;
//Label
    @FXML
    private Label lbl_errorHouse;
//Button
    @FXML
    private Button btn_SubmitHouse;
//Toogle group
    @FXML
    private ToggleGroup genderChild1,genderChild2,genderChild3,genderChild4,genderChild5,genderChild6,genderChild7,genderChild8,genderChild9,genderChild10;
//label
    @FXML
    private Label lbl_HouseSucessful;

              ////IDENTIFICATION CARD
// Text Field
    @FXML
    private TextField txt_regNumber,txt_resFname,txt_resMname,txt_resLname,txt_resIdNumber,txt_resBloodGroup,txt_resAdress,txt_resPhoneNumber,txt_resHouseNumber;
    @FXML
    private TextField searchID,txt_EmgFName,txt_EmgMName,txt_EmgLName,tex_EmgPNumber;
// Button
   @FXML
   private Button byn_update,btn_Generator,btn_idSubmit,btn_chooseIdPhoto;
// Image
    @FXML
    public ImageView imageQR,img_idCard,img_backId,IDimage,imageAcessBack;
// Label
    @FXML
    private Label lbl_errorIdCard;
//DatePicker
    @FXML
    private DatePicker datePickerBirth,datePickerIssue,datePickerExpire;
//Radio Button
@FXML
private RadioButton id_male,id_female;
@FXML
private ToggleGroup chooseM;

                ////BIRTHDAY CERTIFICATE
// Text Field
    @FXML
    private TextField txt_childName,txt_fName,txt_gName,txt_bDayUnique,txt_mNationality;
    @FXML
    private TextField searchBirth,txt_bDayFile,txt_birthPlace,txt_fFullName,txt_fNationality,txt_mFullName,txt_nationality;
// Date Pickers
    @FXML
    private DatePicker dPicker_bDayRegistor,dpicker_birth,dPicker_certifGiven;
// button
    @FXML
    private Button btn_bDaySubmit,btn_choose;
// label
    @FXML
    private Label lbl_error;
// image
    @FXML
    private ImageView img_user,img_back3;
// Radio Button
    @FXML
    private RadioButton rdoMale,rdoFemale;
//Toogle group
    @FXML
    private ToggleGroup chooseF;
                       ////KEBELE HOUSE
// Radio buttons
    @FXML
    private RadioButton  rdo1, rdo2, woodRdo,frenchRdo,irondoorRdo,ironRdo,mirrorRdo,moreRdo,otherRdo;
// Text Fields
    @FXML
    private TextField SearchKebele, txt_fatherFullName,txt_motherFullName,txt_houseNumber,txt_AmountOfRoom,txt_SurfaceArea,txt_HouseLocation;
// Button
    @FXML
    private Button btn_next;
// Label
   @FXML
   private Label lbl_valid;
// choose photo
final FileChooser fc= new FileChooser();
//toggle group
    @FXML
    private ToggleGroup amountGroup;
    @FXML
    private ToggleGroup typeGroup;
    @FXML
    private ToggleGroup DtypeGroup;
                        ////Children Status
    @FXML
    private Button btn_done;
//Image
    @FXML
    private ImageView img_back4;
//choice Button
    @FXML
    private ChoiceBox<String> choiceB_Nchild;
    private String[] number = {"1","2","3","4","5","6","7","8","9","10"};
//Radio Button
    @FXML
    private RadioButton mRdo1,mRdo2,mRdo3,mRdo4,mRdo5,mRdo6,mRdo7,mRdo8,mRdo9,mRdo10;
    @FXML
    private RadioButton fRdo1,fRdo2,fRdo3,fRdo4,fRdo5,fRdo6,fRdo7,fRdo8,fRdo9,fRdo10;
    @FXML
    private RadioButton sRdo1,sRdo2,sRdo3,sRdo4,sRdo5,sRdo6,sRdo7,sRdo8,sRdo9,sRdo10;
    @FXML
    private RadioButton marrRdo1,marrRdo2,marrRdo3,marrRdo4,marrRdo5,marrRdo6,marrRdo7,marrRdo8,marrRdo9,marrRdo10;
//TextField
    @FXML
    private TextField txt_fN1,txt_fN2,txt_fN3,txt_fN4,txt_fN5,txt_fN6,txt_fN7,txt_fN8,txt_fN9,txt_fN10;
    @FXML
    private TextField txt_Age1,txt_Age2,txt_Age3,txt_Age4,txt_Age5,txt_Age6,txt_Age7,txt_Age8,txt_Age9,txt_Age10;
    @FXML
    private TextField txt_car1,txt_car2,txt_car3,txt_car4,txt_car5,txt_car6,txt_car7,txt_car8,txt_car9,txt_car10;
    @FXML
    private TextField txt_HouseNumbers;

//toggle group
 @FXML
 private ToggleGroup childG1,childG2,childG3,childG4,childG5,childG6,childG7,childG8,childG9,childG10;
 @FXML
 private ToggleGroup childS1,childS2,childS3,childS4,childS5,childS6,childS7,childS8,childS9,childS10;
 //label
 @FXML
 private Label lbl_childrenSucessful;
                           ////Unemployed ID Card
//TextField
    @FXML
    private TextField txt_Fname,txt_Mname,txt_Lname,txt_Pnumber,txt_Raddress,txt_Nationality,txt_Bplace,txt_City,txt_Zone,txt_Wereda,txt_Kebele;
//RadioButton
    @FXML
    private RadioButton RdoPrimary,RdoSecondary,RdoTertiary,RdoAbove,maleRdo,femaleRdo,rdomaleUnemploy,rdofemaleUnemployed;
//Button
    @FXML
    private Button btn_submit,btn_choose1;
//ImageView
    @FXML
    private ImageView img_unemployed,img_back5;
//Label
    @FXML
    private Label lbl_errorUnemployed;
//Toggle Group
  @FXML
  private ToggleGroup levelGroup,choose1;
           ////Organizing unemployed
//image
    @FXML
    private ImageView img_back6,image_Un1,image_Un2,image_Un3,image_Un4,image_Un5,OrganizeImage;
//button
    @FXML
    private Button btn_chooseQR1,btn_chooseQR2,btn_chooseQR3,btn_chooseQR4,btn_chooseQR5,btn_SubMit;
//TextField
    @FXML
    private TextField searchUnemployed,txt_fullname1,txt_fullname2,txt_fullname3,txt_fullname4,txt_fullname5,txt_typeWork1,txt_typeWork2,txt_typeWork3,txt_typeWork4,txt_typeWork5;
    @FXML
    private TextField search_Organize,txt_loc1,txt_loc2,txt_loc3,txt_loc4,txt_loc5,txt_capital1,txt_capital2,txt_capital3,txt_capital4,txt_capital5;
//Label
    @FXML
    private Label lbl_errorOrg;
    ////MARRIAGE CERTIFICATE
    @FXML
    private ImageView img_backId7;
//button
    @FXML
    private Button btn_submitMarriage;
//TextField
    @FXML
    private TextField searchMarrage,txt_hasbund,txt_wife,txt_month,txt_day,txt_year,txt_by,txt_at,txt_witness1,txt_witness2;
//Label
    @FXML
    private Label lbl_errorMarriage;
                ////Access File
///Tabel View
    @FXML
    private TableView tabel_organize,tabel_House,tabel_BirthCerteficate,tabel_Marrage,tabel_Id,tabel_unemployed,tabel_KebeleHouse;
/// FontAwesome
    @FXML
    private FontAwesomeIconView font_Back;
///Button
    @FXML
    private Button btn_AcessID,btn_AcessKebeleHouse,btn_AcessBirthCertificate,btn_AcessUnemployedID,btn_AcessOrganizing,btn_AcessMarrage;
/// Anchor
    @FXML
    private AnchorPane pn_tabel_organize,pn_tabel_unemployed,pn_tabel_id,pn_tabel_marrage,pn_tabel_House,pn_tabel_KebelaHouse,pn_tabel_BirthCeriteficate;

    ///OrganizingUnemployde
//column
    @FXML
    private TableColumn<OrganizationUnemployed, String> col_orgFullName;
    @FXML
    private TableColumn<OrganizationUnemployed, String> col_orgTypeOfWork;
    @FXML
    private TableColumn<OrganizationUnemployed, String> col_orgWorkingLocation;
    @FXML
    private TableColumn<OrganizationUnemployed, Integer> col_orgAmountofcapital;

    ObservableList OrganizeObservableList = FXCollections.observableArrayList();
    ////House
 //column
    @FXML
    private TableColumn<House, String>col_HFatherName;
    @FXML
    private TableColumn<House, String>col_HMotherName;
    @FXML
    private TableColumn<House, Integer>col_HhouseNumber;
    @FXML
    private TableColumn<House, Date>col_HfilesubmissionDate;
    @FXML
    private TableColumn<House, Integer>col_HhousePhoneNumber;
    @FXML
    private TableColumn<House, String>col_HchildrenName;
    @FXML
    private TableColumn<House, String>col_Hgender;
    @FXML
    private TableColumn<House, Integer>col_Hage;
    ObservableList HouseObservableList = FXCollections.observableArrayList();
  ///BirthCerteficate
 //Column
    @FXML
    private TableColumn<BirthCerteficate2,String>col_Bchildname;
    @FXML
    private TableColumn<BirthCerteficate2,String>col_Bfathername;
    @FXML
    private TableColumn<BirthCerteficate2,String>col_Bgrandfname;
    @FXML
    private TableColumn<BirthCerteficate2,String>col_Bgender;
    @FXML
    private TableColumn<BirthCerteficate2,Date>col_Bbirthday;
    @FXML
    private TableColumn<BirthCerteficate2,String>col_Bbirthplace;
    @FXML
    private TableColumn<BirthCerteficate2,String>col_Bnationality;
    @FXML
    private TableColumn<BirthCerteficate2,String>col_Bmotherfullname;
    @FXML
    private TableColumn<BirthCerteficate2,Integer>col_Bmothernationality;
    @FXML
    private TableColumn<BirthCerteficate2,Date>col_Bfatherfullname;
    @FXML
    private TableColumn<BirthCerteficate2,String>col_BfatherNationality;
    @FXML
    private TableColumn<BirthCerteficate2,Integer>col_Bbdayregnum;
    @FXML
    private TableColumn<BirthCerteficate2,Integer>col_Bdayfilenum;
    @FXML
    private TableColumn<BirthCerteficate2,Date>col_BCerteficate;
    @FXML
    private TableColumn<BirthCerteficate2,Integer>col_BdayregsterUnique;
    ObservableList<BirthCerteficate2> BirthCertificateObservableList = FXCollections.observableArrayList();
//Marraiage certeficate
    @FXML
    private TableColumn<MarriageCeritificate,String>col_Mhusbund;
    @FXML
    private TableColumn<MarriageCeritificate,String>col_Mwifename;
    @FXML
    private TableColumn<MarriageCeritificate,Integer>col_Mmonth;
    @FXML
    private TableColumn<MarriageCeritificate,Integer>col_Mday;
    @FXML
    private TableColumn<MarriageCeritificate,Integer>col_Myear;
    @FXML
    private TableColumn<MarriageCeritificate,String>col_Massigner;
    @FXML
    private TableColumn<MarriageCeritificate,String>col_Mplace;
    @FXML
    private TableColumn<MarriageCeritificate,String>col_Mfirstwitness;
    @FXML
    private TableColumn<MarriageCeritificate,String>col_Msecondwitness;
    ObservableList<MarriageCeritificate> MarriageObservableList = FXCollections.observableArrayList();
//Identification card
    @FXML
    private TableColumn<IDcard,String>col_IDresident;
    @FXML
    private TableColumn<IDcard,String>col_IDfirstname;
    @FXML
    private TableColumn<IDcard,String>col_IDmiddlename;
    @FXML
    private TableColumn<IDcard,String>col_IDlastname;
    @FXML
    private TableColumn<IDcard,Integer>col_IDidnumber;
    @FXML
    private TableColumn<IDcard,Date>col_IDdateofbirth;
    @FXML
    private TableColumn<IDcard,String>col_IDbloodgroup;
    @FXML
    private TableColumn<IDcard,String>col_IDsex;
    @FXML
    private TableColumn<IDcard,Date>col_IDissuedate;
    @FXML
    private TableColumn<IDcard,Date>col_IDexpiredate;
    @FXML
    private TableColumn<IDcard,String>col_IDressidentadress;
    @FXML
    private TableColumn<IDcard,Integer>col_IDphonenumber;
    @FXML
    private TableColumn<IDcard,Integer>col_IDhousenumber;
    @FXML
    private TableColumn<IDcard,String>col_IDemgfirst;
    @FXML
    private TableColumn<IDcard,String>col_IDemgmiddle;
    @FXML
    private TableColumn<IDcard,String>col_IDemglast;
    @FXML
    private TableColumn<IDcard,Integer>col_IDemgnum;
    ObservableList IdentificationObservableList = FXCollections.observableArrayList();
//UnemployedId
    @FXML
    private TableColumn<UnemployedID,String>col_Ufirstname;
    @FXML
    private TableColumn<UnemployedID,String>col_Umiddlename;
    @FXML
    private TableColumn<UnemployedID,String>col_Ulastname;
    @FXML
    private TableColumn<UnemployedID,String>col_Usex;
    @FXML
    private TableColumn<UnemployedID,Integer>col_Uphonenumber;
    @FXML
    private TableColumn<UnemployedID,String>col_UresidentAddress;
    @FXML
    private TableColumn<UnemployedID,String>col_Unationality;
    @FXML
    private TableColumn<UnemployedID,String>col_Ubirthplace;
    @FXML
    private TableColumn<UnemployedID,String>col_Ucity;
    @FXML
    private TableColumn<UnemployedID,String>col_Uzone;
    @FXML
    private TableColumn<UnemployedID,Integer>col_Uwereda;
    @FXML
    private TableColumn<UnemployedID,Integer>col_Ukebele;
    @FXML
    private TableColumn<UnemployedID,String>col_Ulevelofeducation;
    ObservableList<UnemployedID> UnemployedObservableList = FXCollections.observableArrayList();
  //Kebele House
    @FXML
    private TableColumn<KebeleHouse,String>col_Kfathername;
    @FXML
    private TableColumn<KebeleHouse,String>col_Kmothername;
    @FXML
    private TableColumn<KebeleHouse,Integer>col_Khousenumber;
    @FXML
    private TableColumn<KebeleHouse,Integer>col_Kamonutroom;
    @FXML
    private TableColumn<KebeleHouse,Integer>col_Ksurfacearea;
    @FXML
    private TableColumn<KebeleHouse,String>col_khouseloc;
    @FXML
    private TableColumn<KebeleHouse,Integer>col_Kwindowamonut;
    @FXML
    private TableColumn<KebeleHouse,Integer>col_Kwindowtype;
    @FXML
    private TableColumn<KebeleHouse,Integer>col_Kdoortype;
    @FXML
    private TableColumn<KebeleHouse,Integer>col_kebeleHousenumber;
    @FXML
    private TableColumn<KebeleHouse,String>col_Kchildname;
    @FXML
    private TableColumn<KebeleHouse,String>col_Kchildgender;
    @FXML
    private TableColumn<KebeleHouse,Integer>col_Kchildage;
    @FXML
    private TableColumn<KebeleHouse,String>col_Kchildcarrier;
    @FXML
    private TableColumn<KebeleHouse,String>col_Kchildatatus;
    ObservableList<KebeleHouse> KebeleHouseObservableList = FXCollections.observableArrayList();

    Connection connection= null;
    PreparedStatement pst = null;
    ResultSet resultSet= null;
    DBConector dbConector = new DBConector() ;
    FileInputStream fis ;
    File file;
    public void handleButton(MouseEvent event) {
        if (event.getSource() == btn_logout) {
            try {
                Stage stage;
                Node node = (Node) event.getSource();
                stage = (Stage) node.getScene().getWindow();
                stage.close();

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
                Parent root = fxmlLoader.load();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                System.out.print(e);
            }
        }
        ////House
        if (event.getSource() == btn_house) {
            pn_House.toFront();
        }
        if (event.getSource() == btn_SubmitHouse) {
            String hfathername=txt_HFatherName.getText();
            String hmathernam = txt_HMatherName.getText();
            String hhusenumber=txt_HhouseNumber.getText();
            java.sql.Date datapicker = Date.valueOf(datePickerHFile.getValue());
            int HPnumber = Integer.parseInt(txt_HPNumber.getText());
            if (validHouse().equals("Success")) {
                String sqlk ="INSERT INTO house(FatherName, MotherName, HouseNumber, FileSubmissionDate, HousePhoneNumber, ChildName, Gender, Age) VALUES (?,?,?,?,?,?,?,?)";
                 try {
                     pst = connection.prepareStatement(sqlk);
                     pst.setString(1,hfathername);
                     pst.setString(2, hmathernam);
                     pst.setInt(3, Integer.parseInt(hhusenumber));
                     pst.setDate(4, datapicker);
                     pst.setInt(5, HPnumber);
                     pst.setString(6, "null");
                     if (rdoHmale1.isSelected()) {
                         pst.setString(7, "");
                     }
                     if (rdoHfemal1.isSelected()) {
                         pst.setString(7, "");
                     }
                     pst.setInt(8, Integer.parseInt("0"));
                     pst.execute();
                     System.out.print(" added 0 ");
                     txt_HFatherName.clear();
                     txt_HMatherName.clear();
                     txt_HhouseNumber.clear();
                     datePickerHFile.getEditor().clear();
                     lbl_HouseSucessful.setTextFill(Color.rgb(148, 243, 242));
                     lbl_HouseSucessful.setText("Create Successfully");
                     lbl_HouseSucessful.setFont(Font.font("Verdana", 18));
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
                String sql = "INSERT INTO house(FatherName, MotherName, HouseNumber, FileSubmissionDate, HousePhoneNumber, ChildName, Gender, Age) VALUES (?,?,?,?,?,?,?,?)";
                try {
                    pst = connection.prepareStatement(sql);
                    pst.setString(1,hfathername);
                    pst.setString(2, hmathernam);
                    pst.setInt(3, Integer.parseInt(hhusenumber));
                    pst.setDate(4, datapicker);
                    pst.setInt(5, HPnumber);
                    pst.setString(6, txt_HName1.getText());
                    if (rdoHmale1.isSelected()) {
                        pst.setString(7, rdoHmale1.getText());
                    }
                    if (rdoHfemal1.isSelected()) {
                        pst.setString(7, rdoHfemal1.getText());
                    }
                    pst.setInt(8, Integer.parseInt(rdoHAge1.getText()));
                    pst.execute();

                    System.out.print(" added 1 ");
                    txt_HFatherName.clear();
                    txt_HMatherName.clear();
                    txt_HhouseNumber.clear();
                    datePickerHFile.getEditor().clear();
                    txt_HPNumber.clear();
                    txt_HName1.clear();
                    rdoHmale1.setSelected(false);
                    rdoHfemal1.setSelected(false);
                    rdoHAge1.clear();
                    lbl_HouseSucessful.setTextFill(Color.rgb(148, 243, 242));
                    lbl_HouseSucessful.setText("Create Successfully");
                    lbl_HouseSucessful.setFont(Font.font("Verdana", 18));
                    refrashtabel();

                    String sql2 = "INSERT INTO house(FatherName, MotherName, HouseNumber, FileSubmissionDate, HousePhoneNumber, ChildName, Gender, Age) VALUES (?,?,?,?,?,?,?,?)";
                                pst = connection.prepareStatement(sql2);
                                pst.setString(1, hfathername);
                                pst.setString(2,hmathernam);
                                pst.setInt(3, Integer.parseInt(hhusenumber));
                                pst.setDate(4, datapicker);
                                pst.setInt(5, HPnumber);
                                pst.setString(6, txt_HName2.getText());
                                if (rdoHmale2.isSelected()) {
                                    pst.setString(7, rdoHmale2.getText());
                                }
                                if (rdoHfemal2.isSelected()) {
                                    pst.setString(7, rdoHfemal2.getText());
                                }
                                pst.setInt(8, Integer.parseInt(rdoHAge2.getText()));
                                pst.execute();
                                System.out.print(" added 2 ");
                                txt_HName2.clear();
                                rdoHmale2.setSelected(false);
                                rdoHfemal2.setSelected(false);
                                rdoHAge2.clear();
                                lbl_HouseSucessful.setTextFill(Color.rgb(148, 243, 242));
                                lbl_HouseSucessful.setText("Create Successfully");
                                lbl_HouseSucessful.setFont(Font.font("Verdana", 18));
                                refrashtabel();


                            //third row
                            String sql3 = "INSERT INTO house(FatherName, MotherName, HouseNumber, FileSubmissionDate, HousePhoneNumber, ChildName, Gender, Age) VALUES (?,?,?,?,?,?,?,?)";
                            pst = connection.prepareStatement(sql3);
                            pst.setString(1,hfathername);
                            pst.setString(2, hmathernam);
                            pst.setInt(3, Integer.parseInt(hhusenumber));
                            pst.setDate(4, datapicker);
                            pst.setInt(5, HPnumber);
                            pst.setString(6, txt_HName3.getText());
                            if (rdoHmale3.isSelected()) {
                                pst.setString(7, rdoHmale3.getText());
                            }
                            if (rdoHfemal3.isSelected()) {
                                pst.setString(7, rdoHfemal3.getText());
                            }
                            pst.setInt(8, Integer.parseInt(rdoHAge3.getText()));
                            pst.execute();
                            System.out.print(" added 3 ");
                    txt_HFatherName.clear();
                    txt_HMatherName.clear();
                    txt_HhouseNumber.clear();
                    datePickerHFile.getEditor().clear();
                    txt_HPNumber.clear();
                    txt_HName3.clear();
                    rdoHmale3.setSelected(false);
                    rdoHfemal3.setSelected(false);
                      rdoHAge3.clear();
                            lbl_HouseSucessful.setTextFill(Color.rgb(148, 243, 242));
                            lbl_HouseSucessful.setText("Create Successfully");
                            lbl_HouseSucessful.setFont(Font.font("Verdana", 18));
                            refrashtabel();
                    //fourth row
                    String sql4 = "INSERT INTO house(FatherName, MotherName, HouseNumber, FileSubmissionDate, HousePhoneNumber, ChildName, Gender, Age) VALUES (?,?,?,?,?,?,?,?)";
                    pst = connection.prepareStatement(sql4);
                    pst.setString(1,hfathername);
                    pst.setString(2, hmathernam);
                    pst.setInt(3, Integer.parseInt(hhusenumber));
                    pst.setDate(4, datapicker);
                    pst.setInt(5, HPnumber);
                    pst.setString(6, txt_HName4.getText());
                    if (rdoHmale4.isSelected()) {
                        pst.setString(7, rdoHmale4.getText());
                    }
                    if (rdoHfemal4.isSelected()) {
                        pst.setString(7, rdoHfemal4.getText());
                    }
                    pst.setInt(8, Integer.parseInt(rdoHAge4.getText()));
                    pst.execute();
                    System.out.print(" added 4 ");
                    txt_HFatherName.clear();
                    txt_HMatherName.clear();
                    txt_HhouseNumber.clear();
                    datePickerHFile.getEditor().clear();
                    txt_HPNumber.clear();
                    txt_HName4.clear();
                    rdoHmale4.setSelected(false);
                    rdoHfemal4.setSelected(false);
                    rdoHAge4.clear();
                    lbl_HouseSucessful.setTextFill(Color.rgb(148, 243, 242));
                    lbl_HouseSucessful.setText("Create Successfully");
                    lbl_HouseSucessful.setFont(Font.font("Verdana", 18));
                    refrashtabel();
                    //fifth row
                    String sql5 = "INSERT INTO house(FatherName, MotherName, HouseNumber, FileSubmissionDate, HousePhoneNumber, ChildName, Gender, Age) VALUES (?,?,?,?,?,?,?,?)";
                    pst = connection.prepareStatement(sql5);
                    pst.setString(1,hfathername);
                    pst.setString(2, hmathernam);
                    pst.setInt(3, Integer.parseInt(hhusenumber));
                    pst.setDate(4, datapicker);
                    pst.setInt(5, HPnumber);
                    pst.setString(6, txt_HName5.getText());
                    if (rdoHmale5.isSelected()) {
                        pst.setString(7, rdoHmale5.getText());
                    }
                    if (rdoHfemal5.isSelected()) {
                        pst.setString(7, rdoHfemal5.getText());
                    }
                    pst.setInt(8, Integer.parseInt(rdoHAge5.getText()));
                    pst.execute();
                    System.out.print(" added 5 ");
                    txt_HFatherName.clear();
                    txt_HMatherName.clear();
                    txt_HhouseNumber.clear();
                    datePickerHFile.getEditor().clear();
                    txt_HPNumber.clear();
                    txt_HName5.clear();
                    rdoHmale5.setSelected(false);
                    rdoHfemal5.setSelected(false);
                    rdoHAge5.clear();
                    lbl_HouseSucessful.setTextFill(Color.rgb(148, 243, 242));
                    lbl_HouseSucessful.setText("Create Successfully");
                    lbl_HouseSucessful.setFont(Font.font("Verdana", 18));
                    refrashtabel();
                    //six row
                    String sql6 = "INSERT INTO house(FatherName, MotherName, HouseNumber, FileSubmissionDate, HousePhoneNumber, ChildName, Gender, Age) VALUES (?,?,?,?,?,?,?,?)";
                    pst = connection.prepareStatement(sql6);
                    pst.setString(1,hfathername);
                    pst.setString(2, hmathernam);
                    pst.setInt(3, Integer.parseInt(hhusenumber));
                    pst.setDate(4, datapicker);
                    pst.setInt(5, HPnumber);
                    pst.setString(6, txt_HName6.getText());
                    if (rdoHmale6.isSelected()) {
                        pst.setString(7, rdoHmale6.getText());
                    }
                    if (rdoHfemal6.isSelected()) {
                        pst.setString(7, rdoHfemal6.getText());
                    }
                    pst.setInt(8, Integer.parseInt(rdoHAge6.getText()));
                    pst.execute();
                    System.out.print(" added 6 ");
                    txt_HFatherName.clear();
                    txt_HMatherName.clear();
                    txt_HhouseNumber.clear();
                    datePickerHFile.getEditor().clear();
                    txt_HPNumber.clear();
                    txt_HName6.clear();
                    rdoHmale6.setSelected(false);
                    rdoHfemal6.setSelected(false);
                    rdoHAge6.clear();
                    lbl_HouseSucessful.setTextFill(Color.rgb(148, 243, 242));
                    lbl_HouseSucessful.setText("Create Successfully");
                    lbl_HouseSucessful.setFont(Font.font("Verdana", 18));
                    refrashtabel();
                    //seven row
                    String sql7 = "INSERT INTO house(FatherName, MotherName, HouseNumber, FileSubmissionDate, HousePhoneNumber, ChildName, Gender, Age) VALUES (?,?,?,?,?,?,?,?)";
                    pst = connection.prepareStatement(sql7);
                    pst.setString(1,hfathername);
                    pst.setString(2, hmathernam);
                    pst.setInt(3, Integer.parseInt(hhusenumber));
                    pst.setDate(4, datapicker);
                    pst.setInt(5, HPnumber);
                    pst.setString(6, txt_HName7.getText());
                    if (rdoHmale7.isSelected()) {
                        pst.setString(7, rdoHmale7.getText());
                    }
                    if (rdoHfemal7.isSelected()) {
                        pst.setString(7, rdoHfemal7.getText());
                    }
                    pst.setInt(8, Integer.parseInt(rdoHAge7.getText()));
                    pst.execute();
                    System.out.print(" added 7 ");
                    txt_HFatherName.clear();
                    txt_HMatherName.clear();
                    txt_HhouseNumber.clear();
                    datePickerHFile.getEditor().clear();
                    txt_HPNumber.clear();
                    txt_HName7.clear();
                    rdoHmale7.setSelected(false);
                    rdoHfemal7.setSelected(false);
                    rdoHAge7.clear();
                    lbl_HouseSucessful.setTextFill(Color.rgb(148, 243, 242));
                    lbl_HouseSucessful.setText("Create Successfully");
                    lbl_HouseSucessful.setFont(Font.font("Verdana", 18));
                    refrashtabel();
                    //eight row
                    String sql8 = "INSERT INTO house(FatherName, MotherName, HouseNumber, FileSubmissionDate, HousePhoneNumber, ChildName, Gender, Age) VALUES (?,?,?,?,?,?,?,?)";
                    pst = connection.prepareStatement(sql8);
                    pst.setString(1,hfathername);
                    pst.setString(2, hmathernam);
                    pst.setInt(3, Integer.parseInt(hhusenumber));
                    pst.setDate(4, datapicker);
                    pst.setInt(5, HPnumber);
                    pst.setString(6, txt_HName8.getText());
                    if (rdoHmale8.isSelected()) {
                        pst.setString(7, rdoHmale8.getText());
                    }
                    if (rdoHfemal8.isSelected()) {
                        pst.setString(7, rdoHfemal8.getText());
                    }
                    pst.setInt(8, Integer.parseInt(rdoHAge8.getText()));
                    pst.execute();
                    System.out.print(" added 8 ");
                    txt_HFatherName.clear();
                    txt_HMatherName.clear();
                    txt_HhouseNumber.clear();
                    datePickerHFile.getEditor().clear();
                    txt_HPNumber.clear();
                    txt_HName8.clear();
                    rdoHmale8.setSelected(false);
                    rdoHfemal8.setSelected(false);
                    rdoHAge8.clear();
                    lbl_HouseSucessful.setTextFill(Color.rgb(148, 243, 242));
                    lbl_HouseSucessful.setText("Create Successfully");
                    lbl_HouseSucessful.setFont(Font.font("Verdana", 18));
                    refrashtabel();
                    //nign row
                    String sql9 = "INSERT INTO house(FatherName, MotherName, HouseNumber, FileSubmissionDate, HousePhoneNumber, ChildName, Gender, Age) VALUES (?,?,?,?,?,?,?,?)";
                    pst = connection.prepareStatement(sql9);
                    pst.setString(1,hfathername);
                    pst.setString(2, hmathernam);
                    pst.setInt(3, Integer.parseInt(hhusenumber));
                    pst.setDate(4, datapicker);
                    pst.setInt(5, HPnumber);
                    pst.setString(6, txt_HName9.getText());
                    if (rdoHmale9.isSelected()) {
                        pst.setString(7, rdoHmale9.getText());
                    }
                    if (rdoHfemal9.isSelected()) {
                        pst.setString(7, rdoHfemal9.getText());
                    }
                    pst.setInt(8, Integer.parseInt(rdoHAge9.getText()));
                    pst.execute();
                    System.out.print(" added 9 ");
                    txt_HFatherName.clear();
                    txt_HMatherName.clear();
                    txt_HhouseNumber.clear();
                    datePickerHFile.getEditor().clear();
                    txt_HPNumber.clear();
                    txt_HName9.clear();
                    rdoHmale9.setSelected(false);
                    rdoHfemal9.setSelected(false);
                    rdoHAge9.clear();
                    lbl_HouseSucessful.setTextFill(Color.rgb(148, 243, 242));
                    lbl_HouseSucessful.setText("Create Successfully");
                    lbl_HouseSucessful.setFont(Font.font("Verdana", 18));
                    refrashtabel();
                    //tenth row
                    String sql10 = "INSERT INTO house(FatherName, MotherName, HouseNumber, FileSubmissionDate, HousePhoneNumber, ChildName, Gender, Age) VALUES (?,?,?,?,?,?,?,?)";
                    pst = connection.prepareStatement(sql10);
                    pst.setString(1,hfathername);
                    pst.setString(2, hmathernam);
                    pst.setInt(3, Integer.parseInt(hhusenumber));
                    pst.setDate(4, datapicker);
                    pst.setInt(5, HPnumber);
                    pst.setString(6, txt_HName10.getText());
                    if (rdoHmale10.isSelected()) {
                        pst.setString(7, rdoHmale10.getText());
                    }
                    if (rdoHfemal10.isSelected()) {
                        pst.setString(7, rdoHfemal10.getText());
                    }
                    pst.setInt(8, Integer.parseInt(rdoHAge10.getText()));
                    pst.execute();
                    System.out.print(" added 10 ");
                    //clear data
                    txt_HFatherName.clear();
                    txt_HMatherName.clear();
                    txt_HhouseNumber.clear();
                    datePickerHFile.getEditor().clear();
                    txt_HPNumber.clear();
                    txt_HName1.clear();
                    txt_HName2.clear();
                    txt_HName3.clear();
                    txt_HName4.clear();
                    txt_HName5.clear();
                    txt_HName6.clear();
                    txt_HName7.clear();
                    txt_HName8.clear();
                    txt_HName9.clear();
                    txt_HName10.clear();
                    rdoHmale1.setSelected(false);
                    rdoHmale2.setSelected(false);
                    rdoHmale3.setSelected(false);
                    rdoHmale4.setSelected(false);
                    rdoHmale5.setSelected(false);
                    rdoHmale6.setSelected(false);
                    rdoHmale7.setSelected(false);
                    rdoHmale8.setSelected(false);
                    rdoHmale9.setSelected(false);
                    rdoHmale10.setSelected(false);
                    rdoHfemal1.setSelected(false);
                    rdoHfemal2.setSelected(false);
                    rdoHfemal3.setSelected(false);
                    rdoHfemal4.setSelected(false);
                    rdoHfemal5.setSelected(false);
                    rdoHfemal6.setSelected(false);
                    rdoHfemal7.setSelected(false);
                    rdoHfemal8.setSelected(false);
                    rdoHfemal9.setSelected(false);
                    rdoHfemal10.setSelected(false);
                    rdoHAge1.clear();
                    rdoHAge2.clear();
                    rdoHAge3.clear();
                    rdoHAge4.clear();
                    rdoHAge5.clear();
                    rdoHAge6.clear();
                    rdoHAge8.clear();
                    rdoHAge9.clear();
                    rdoHAge10.clear();
                    lbl_HouseSucessful.setTextFill(Color.rgb(148, 243, 242));
                    lbl_HouseSucessful.setText("Create Successfully");
                    lbl_HouseSucessful.setFont(Font.font("Verdana", 18));
                    refrashtabel();
                } catch (Exception e) {
                    System.out.print(" not added ");
                    System.out.print(e);
                }
            }

        }
        ///IDENTIFICATION CARD
        if (event.getSource() == btn_id) {
            pn_id.toFront();
        }
        if (event.getSource() == btn_idSubmit) {
            if (validCard().equals("Success")) {
                String sql = "INSERT INTO id(RegisterNumber, Image, FirstName, MiddleName, LastNumber, IdNumber, DateOfBirth, BloodGroup, Sex, IssueDate, ExpireDate, ResidentAdress, PhoneNumber, HouseNumber, EmgFirstName, EmgMiddleName, EmgLastName, EmgPhoneNumber,QRimage) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
                try {
                    pst = connection.prepareStatement(sql);
                    pst.setString(1, txt_regNumber.getText());
                    fis = new FileInputStream(file);
                    pst.setBinaryStream(2, (InputStream) fis, (int) file.length());
                    pst.setString(3, txt_resFname.getText());
                    pst.setString(4, txt_resMname.getText());
                    pst.setString(5, txt_resLname.getText());
                    pst.setInt(6, Integer.parseInt(txt_resIdNumber.getText()));
                    pst.setDate(7, Date.valueOf(datePickerBirth.getValue()));
                    pst.setString(8, txt_resBloodGroup.getText());
                    if (id_male.isSelected()) {
                        pst.setString(9, id_male.getText());
                    }
                    if (id_female.isSelected()) {
                        pst.setString(9, id_female.getText());
                    }
                    pst.setDate(10, Date.valueOf(datePickerIssue.getValue()));
                    pst.setDate(11, Date.valueOf(datePickerExpire.getValue()));
                    pst.setString(12, txt_resAdress.getText());
                    pst.setInt(13, Integer.parseInt(txt_resPhoneNumber.getText()));
                    pst.setInt(14, Integer.parseInt(txt_resHouseNumber.getText()));
                    pst.setString(15, txt_EmgFName.getText());
                    pst.setString(16, txt_EmgMName.getText());
                    pst.setString(17, txt_EmgLName.getText());
                    pst.setInt(18, Integer.parseInt(tex_EmgPNumber.getText()));
                    fis = new FileInputStream(file);
                    pst.setBinaryStream(19, (InputStream) fis, (int) file.length());
                    pst.execute();
                    System.out.print("added");
                    img_idCard.setImage(null);
                    txt_regNumber.clear();
                    txt_regNumber.setStyle("");
                    txt_resFname.clear();
                    txt_resFname.setStyle("");
                    txt_resMname.clear();
                    txt_resMname.setStyle("");
                    txt_resLname.clear();
                    txt_resLname.setStyle("");
                    txt_resIdNumber.clear();
                    txt_resIdNumber.setStyle("");
                    datePickerBirth.getEditor().clear();
                    datePickerBirth.setStyle("");
                    txt_resBloodGroup.clear();
                    txt_resBloodGroup.setStyle("");
                    id_male.setSelected(false);
                    id_female.setSelected(false);
                    datePickerIssue.getEditor().clear();
                    datePickerIssue.setStyle("");
                    datePickerExpire.getEditor().clear();
                    datePickerExpire.setStyle("");
                    txt_resAdress.clear();
                    txt_resAdress.setStyle("");
                    txt_resPhoneNumber.clear();
                    txt_resPhoneNumber.setStyle("");
                    txt_resHouseNumber.clear();
                    txt_resHouseNumber.setStyle("");
                    txt_EmgFName.clear();
                    txt_EmgFName.setStyle("");
                    txt_EmgMName.clear();
                    txt_EmgMName.setStyle("");
                    txt_EmgLName.clear();
                    txt_EmgLName.setStyle("");
                    tex_EmgPNumber.clear();
                    tex_EmgPNumber.setStyle("");
                    lbl_errorIdCard.setTextFill(Color.rgb(148, 243, 242));
                    lbl_errorIdCard.setText("Registered Successfully");
                    lbl_errorIdCard.setFont(Font.font("Verdana", 18));
                    imageQR.setImage(null);
                    refrashIdTabel();
                } catch (Exception e) {
                    System.out.print("not added");
                    System.out.print(e);
                }

            }
        }
  ///Identification Update
        if (event.getSource()==byn_update){
            if (validCard().equals("Success")){
                try {
                    pst = connection.prepareStatement("UPDATE id SET IssueDate=?,ExpireDate=? WHERE IdNumber=?");

                    pst.setDate(1,Date.valueOf(datePickerIssue.getValue()));
                    pst.setDate(2,Date.valueOf(datePickerExpire.getValue()));
                    pst.setInt(3,Integer.parseInt(txt_resIdNumber.getText()));

                    pst.execute();
                    System.out.print("Update");
                    img_idCard.setImage(null);
                    txt_regNumber.clear();
                    txt_regNumber.setStyle("");
                    txt_resFname.clear();
                    txt_resFname.setStyle("");
                    txt_resMname.clear();
                    txt_resMname.setStyle("");
                    txt_resLname.clear();
                    txt_resLname.setStyle("");
                    txt_resIdNumber.clear();
                    txt_resIdNumber.setStyle("");
                    datePickerBirth.getEditor().clear();
                    datePickerBirth.setStyle("");
                    txt_resBloodGroup.clear();
                    txt_resBloodGroup.setStyle("");
                    id_male.setSelected(false);
                    id_female.setSelected(false);
                    datePickerIssue.getEditor().clear();
                    datePickerIssue.setStyle("");
                    datePickerExpire.getEditor().clear();
                    datePickerExpire.setStyle("");
                    txt_resAdress.clear();
                    txt_resAdress.setStyle("");
                    txt_resPhoneNumber.clear();
                    txt_resPhoneNumber.setStyle("");
                    txt_resHouseNumber.clear();
                    txt_resHouseNumber.setStyle("");
                    txt_EmgFName.clear();
                    txt_EmgFName.setStyle("");
                    txt_EmgMName.clear();
                    txt_EmgMName.setStyle("");
                    txt_EmgLName.clear();
                    txt_EmgLName.setStyle("");
                    tex_EmgPNumber.clear();
                    tex_EmgPNumber.setStyle("");
                    lbl_errorIdCard.setTextFill(Color.rgb(148, 243, 242));
                    lbl_errorIdCard.setText("Updated Successfully");
                    lbl_errorIdCard.setFont(Font.font("Verdana", 18));
                    imageQR.setImage(null);
                    refrashIdTabel();
                } catch (Exception e) {
                    System.out.println(e);
                    e.printStackTrace();
                }
            }
        }
        if (event.getSource() == btn_chooseIdPhoto) {
            fc.setTitle("Choose Photo");
            fc.setInitialDirectory(new File(System.getProperty("user.home")));
            fc.getExtensionFilters().clear();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
             file = fc.showOpenDialog(null);
            if (file != null) {
                img_idCard.setImage(new Image(file.toURI().toString()));
            }
        }
        ////BIRTHDAY CERTIFICATE
        if (event.getSource() == btn_birth) {
            pn_birthCerteficate.toFront();
        }
        if (event.getSource() == btn_choose) {
            fc.setTitle("Choose Photo");
            fc.setInitialDirectory(new File(System.getProperty("user.home")));
            fc.getExtensionFilters().clear();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
            file = fc.showOpenDialog(null);
            if (file != null) {
                img_user.setImage(new Image(String.valueOf(file.toURI().toString())));
            }
        }
        if (event.getSource() == btn_bDaySubmit) {
            if (validBirth().equals("success")) {
               String sql ="INSERT INTO birthdaycertificate(photo,childname,fathername,grandfname,gender,birthday,birthplace,nationality,motherfullname,mothernationality,fatherfullname,fathernationality,birthdayregestor,birthdayfileformnumber, certificategiven, birthdayregisteruniqenumber) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
               try{
                   pst = connection.prepareStatement(sql);
                   fis = new FileInputStream(file);
                   pst.setBinaryStream(1,(InputStream) fis,(int)file.length());
                   pst.setString(2,txt_childName.getText());
                   pst.setString(3,txt_fName.getText());
                   pst.setString(4,txt_gName.getText());
                   if(rdoMale.isSelected()){
                       pst.setString(5,rdoMale.getText());
                   }
                   if (rdoFemale.isSelected()){
                       pst.setString(5,rdoFemale.getText());
                   }
                   pst.setDate(6,Date.valueOf(dpicker_birth.getValue()));
                   pst.setString(7,txt_birthPlace.getText());
                   pst.setString(8,txt_nationality.getText());
                   pst.setString(9,txt_mFullName.getText());
                   pst.setString(10,txt_mNationality.getText());
                   pst.setString(11,txt_fFullName.getText());
                   pst.setString(12,txt_fNationality.getText());
                   pst.setDate(13,Date.valueOf(dPicker_bDayRegistor.getValue()));
                   pst.setString(14,txt_bDayFile.getText());
                   pst.setDate(15,Date.valueOf(dPicker_certifGiven.getValue()));
                   pst.setString(16,txt_bDayUnique.getText());
                    pst.execute();
                   System.out.print("added");
                   img_user.setImage(null);
                   txt_childName.clear();
                   txt_childName.setStyle("");
                   txt_fName.clear();
                   txt_fName.setStyle("");
                   txt_gName.clear();
                   txt_gName.setStyle("");
                   rdoMale.setSelected(false);
                   rdoFemale.setSelected(false);
                   dpicker_birth.getEditor().clear();
                   dpicker_birth.setStyle("");
                   txt_birthPlace.clear();
                   txt_birthPlace.setStyle("");
                   txt_nationality.clear();
                   txt_nationality.setStyle("");
                   txt_mFullName.clear();
                   txt_mFullName.setStyle("");
                   txt_mNationality.clear();
                   txt_mNationality.setStyle("");
                   txt_fFullName.clear();
                   txt_fFullName.setStyle("");
                   txt_fNationality.clear();
                   txt_fNationality.setStyle("");
                   dPicker_bDayRegistor.getEditor().clear();
                   dPicker_bDayRegistor.setStyle("");
                   txt_bDayFile.clear();
                   txt_bDayFile.setStyle("");
                   dPicker_certifGiven.getEditor().clear();
                   dPicker_certifGiven.setStyle("");
                   txt_bDayUnique.clear();
                   txt_bDayUnique.setStyle("");
                   lbl_error.setText("Successfully Added");
                   lbl_error.setTextFill(Color.rgb(148,243,242));
                   lbl_error.setFont(Font.font("Verdana", 18));
                   refrashBirthTabel();
               } catch (Exception e) {
                   System.out.print("not added");
                   System.out.print(e);
               }
            }
        }
        ////KEBELE HOUSE
        if (event.getSource() == btn_kebelehouse) {
            pn_kebeleHouse.toFront();
        }
        if (event.getSource() == btn_next) {
            if (validKebele().equals("success")) {
                String sql = "INSERT INTO kebelehouse(FatherFullName, MotherFullName, HouseNumber, AmountRoom, SurfaceArea, HouseLocation, WindowAmount, WindowType, DoorType) VALUES (?,?,?,?,?,?,?,?,?)";
                 try {
                     pst = connection.prepareStatement(sql);
                     pst.setString(1,txt_fatherFullName.getText());
                     pst.setString(2,txt_motherFullName.getText());
                     pst.setInt(3,Integer.parseInt(txt_houseNumber.getText()));
                     pst.setInt(4,Integer.parseInt(txt_AmountOfRoom.getText()));
                     pst.setInt(5,Integer.parseInt(txt_SurfaceArea.getText()));
                     pst.setString(6,txt_HouseLocation.getText());
                     if(rdo1.isSelected()){
                         pst.setString(7,rdo1.getText());
                     }
                     if (rdo2.isSelected()){
                         pst.setString(7,rdo2.getText());
                     }
                     if (moreRdo.isSelected()){
                         pst.setString(7,moreRdo.getText());
                     }
                     if (ironRdo.isSelected()){
                         pst.setString(8,ironRdo.getText());
                     }
                     if (mirrorRdo.isSelected()){
                         pst.setString(8,mirrorRdo.getText());
                     }
                     if (woodRdo.isSelected()){
                         pst.setString(8,woodRdo.getText());
                     }
                     if (irondoorRdo.isSelected()){
                         pst.setString(9,irondoorRdo.getText());
                     }
                     if (frenchRdo.isSelected()){
                         pst.setString(9,frenchRdo.getText());
                     }
                     if (otherRdo.isSelected()){
                         pst.setString(9,otherRdo.getText());
                     }
                     pst.execute();
                     System.out.print("added");
                     txt_fatherFullName.clear();
                     txt_fatherFullName.setStyle("");
                     txt_motherFullName.clear();
                     txt_motherFullName.setStyle("");
                     txt_houseNumber.clear();
                     txt_houseNumber.setStyle("");
                     txt_AmountOfRoom.clear();
                     txt_AmountOfRoom.setStyle("");
                     txt_SurfaceArea.clear();
                     txt_SurfaceArea.setStyle("");
                     txt_HouseLocation.clear();
                     txt_HouseLocation.setStyle("");
                     rdo1.setSelected(false);
                     rdo2.setSelected(false);
                     moreRdo.setSelected(false);
                     ironRdo.setSelected(false);
                     mirrorRdo.setSelected(false);
                     woodRdo.setSelected(false);
                     irondoorRdo.setSelected(false);
                     frenchRdo.setSelected(false);
                     refrashKebeleTabel();
                     ////Children Status
                     if (event.getSource() == btn_next) {
                      pn_childrenStatus.toFront();
                     }
                 } catch (Exception e) {
                     System.out.print("not added");
                     System.out.print(e);
                 }
            }
        }
                  ////Children Status
              if (event.getSource() == btn_done){
                  int Housenumber = Integer.parseInt(txt_HouseNumbers.getText());
                  String sqlm ="INSERT INTO childrenstatus(kebelehousenumber,childfullname, childgender, childage, childcarrier, childstatus) VALUES (?,?,?,?,?,?)";
                      try {
                          pst = connection.prepareStatement(sqlm);
                          pst.setInt(1,Housenumber);
                          pst.setString(2,"null");
                          if(mRdo1.isSelected()){
                              pst.setString(3,"null");
                          }
                          if (fRdo1.isSelected()){
                              pst.setString(3,"null");
                          }
                          pst.setInt(4,Integer.parseInt("null"));
                          pst.setString(5,"null");
                          if (sRdo1.isSelected()){
                              pst.setString(6,"null");
                          }
                          if (marrRdo1.isSelected()){
                              pst.setString(6,"null");
                          }
                          pst.execute();
                          System.out.print(" added 0 ");
                          txt_HouseNumbers.clear();
                          lbl_childrenSucessful.setTextFill(Color.rgb(148, 243, 242));
                          lbl_childrenSucessful.setText("Submitted Successfully");
                          lbl_childrenSucessful.setFont(Font.font("Verdana", 18));
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  String sql1 = "INSERT INTO childrenstatus(kebelehousenumber,childfullname, childgender, childage, childcarrier, childstatus) VALUES (?,?,?,?,?,?)";
                try {
                    pst = connection.prepareStatement(sql1);
                    pst.setInt(1,Housenumber);
                    pst.setString(2,txt_fN1.getText());
                    if(mRdo1.isSelected()){
                        pst.setString(3,mRdo1.getText());
                    }
                    if (fRdo1.isSelected()){
                        pst.setString(3,fRdo1.getText());
                    }
                    pst.setInt(4,Integer.parseInt(txt_Age1.getText()));
                    pst.setString(5,txt_car1.getText());
                    if (sRdo1.isSelected()){
                        pst.setString(6,sRdo1.getText());
                    }
                    if (marrRdo1.isSelected()){
                        pst.setString(6,marrRdo1.getText());
                    }
                    pst.execute();
                    System.out.print(" added 1 ");
                    txt_HouseNumbers.clear();
                    txt_fN1.clear();
                    mRdo1.setSelected(false);
                    fRdo1.setSelected(false);
                    txt_Age1.clear();
                    txt_car1.clear();
                    sRdo1.setSelected(false);
                    marrRdo1.setSelected(false);
                    lbl_childrenSucessful.setTextFill(Color.rgb(148, 243, 242));
                    lbl_childrenSucessful.setText("Submitted Successfully");
                    lbl_childrenSucessful.setFont(Font.font("Verdana", 18));
                    refrashKebeleTabel();
                    //second row
                    String sql2 = "INSERT INTO childrenstatus(kebelehousenumber,childfullname, childgender, childage, childcarrier, childstatus) VALUES (?,?,?,?,?,?)";
                    pst = connection.prepareStatement(sql2);
                    pst.setInt(1,Housenumber);
                    pst.setString(2,txt_fN2.getText());
                    if(mRdo2.isSelected()){
                        pst.setString(3,mRdo2.getText());
                    }
                    if (fRdo2.isSelected()){
                        pst.setString(3,fRdo2.getText());
                    }
                    pst.setInt(4,Integer.parseInt(txt_Age2.getText()));
                    pst.setString(5,txt_car2.getText());
                    if (sRdo1.isSelected()){
                        pst.setString(6,sRdo2.getText());
                    }
                    if (marrRdo2.isSelected()){
                        pst.setString(6,marrRdo2.getText());
                    }
                    pst.execute();
                    System.out.print(" added 2 ");
                    txt_HouseNumbers.clear();
                    txt_fN2.clear();
                    mRdo2.setSelected(false);
                    fRdo2.setSelected(false);
                    txt_Age2.clear();
                    txt_car2.clear();
                    sRdo2.setSelected(false);
                    marrRdo2.setSelected(false);
                    lbl_childrenSucessful.setTextFill(Color.rgb(148, 243, 242));
                    lbl_childrenSucessful.setText("Submitted Successfully");
                    lbl_childrenSucessful.setFont(Font.font("Verdana", 18));
                    refrashKebeleTabel();
                    // third row
                    String sql3 = "INSERT INTO childrenstatus(kebelehousenumber,childfullname, childgender, childage, childcarrier, childstatus) VALUES (?,?,?,?,?,?)";
                    pst = connection.prepareStatement(sql3);
                    pst.setInt(1,Housenumber);
                    pst.setString(2,txt_fN3.getText());
                    if(mRdo3.isSelected()){
                        pst.setString(3,mRdo3.getText());
                    }
                    if (fRdo3.isSelected()){
                        pst.setString(3,fRdo3.getText());
                    }
                    pst.setInt(4,Integer.parseInt(txt_Age3.getText()));
                    pst.setString(5,txt_car3.getText());
                    if (sRdo3.isSelected()){
                        pst.setString(6,sRdo3.getText());
                    }
                    if (marrRdo3.isSelected()){
                        pst.setString(6,marrRdo3.getText());
                    }
                    pst.execute();
                    System.out.print(" added 3 ");
                    txt_HouseNumbers.clear();
                    txt_fN3.clear();
                    mRdo3.setSelected(false);
                    fRdo3.setSelected(false);
                    txt_Age3.clear();
                    txt_car3.clear();
                    sRdo3.setSelected(false);
                    marrRdo3.setSelected(false);
                    lbl_childrenSucessful.setTextFill(Color.rgb(148, 243, 242));
                    lbl_childrenSucessful.setText("Submitted Successfully");
                    lbl_childrenSucessful.setFont(Font.font("Verdana", 18));
                    refrashKebeleTabel();
                    //fourth row
                    String sql4 = "INSERT INTO childrenstatus(kebelehousenumber,childfullname, childgender, childage, childcarrier, childstatus) VALUES (?,?,?,?,?,?)";
                    pst = connection.prepareStatement(sql4);
                    pst.setInt(1,Housenumber);
                    pst.setString(2,txt_fN4.getText());
                    if(mRdo4.isSelected()){
                        pst.setString(3,mRdo4.getText());
                    }
                    if (fRdo4.isSelected()){
                        pst.setString(3,fRdo4.getText());
                    }
                    pst.setInt(4,Integer.parseInt(txt_Age4.getText()));
                    pst.setString(5,txt_car4.getText());
                    if (sRdo4.isSelected()){
                        pst.setString(6,sRdo4.getText());
                    }
                    if (marrRdo4.isSelected()){
                        pst.setString(6,marrRdo4.getText());
                    }
                    pst.execute();
                    System.out.print(" added 4 ");
                    txt_HouseNumbers.clear();
                    txt_fN4.clear();
                    mRdo4.setSelected(false);
                    fRdo4.setSelected(false);
                    txt_Age4.clear();
                    txt_car4.clear();
                    sRdo4.setSelected(false);
                    marrRdo4.setSelected(false);
                    lbl_childrenSucessful.setTextFill(Color.rgb(148, 243, 242));
                    lbl_childrenSucessful.setText("Submitted Successfully");
                    lbl_childrenSucessful.setFont(Font.font("Verdana", 18));
                    refrashKebeleTabel();
                    //fifth row
                    String sql5 = "INSERT INTO childrenstatus(kebelehousenumber,childfullname, childgender, childage, childcarrier, childstatus) VALUES (?,?,?,?,?,?)";
                    pst = connection.prepareStatement(sql5);
                    pst.setInt(1,Housenumber);
                    pst.setString(2,txt_fN5.getText());
                    if(mRdo5.isSelected()){
                        pst.setString(3,mRdo5.getText());
                    }
                    if (fRdo5.isSelected()){
                        pst.setString(3,fRdo5.getText());
                    }
                    pst.setInt(4,Integer.parseInt(txt_Age5.getText()));
                    pst.setString(5,txt_car5.getText());
                    if (sRdo5.isSelected()){
                        pst.setString(6,sRdo5.getText());
                    }
                    if (marrRdo5.isSelected()){
                        pst.setString(6,marrRdo5.getText());
                    }
                    pst.execute();
                    System.out.print(" added 5 ");
                    txt_HouseNumbers.clear();
                    txt_fN5.clear();
                    mRdo5.setSelected(false);
                    fRdo5.setSelected(false);
                    txt_Age5.clear();
                    txt_car5.clear();
                    sRdo5.setSelected(false);
                    marrRdo5.setSelected(false);
                    lbl_childrenSucessful.setTextFill(Color.rgb(148, 243, 242));
                    lbl_childrenSucessful.setText("Submitted Successfully");
                    lbl_childrenSucessful.setFont(Font.font("Verdana", 18));
                    refrashKebeleTabel();
                    //six row
                    String sql6 = "INSERT INTO childrenstatus(kebelehousenumber,childfullname, childgender, childage, childcarrier, childstatus) VALUES (?,?,?,?,?,?)";
                    pst = connection.prepareStatement(sql6);
                    pst.setInt(1,Housenumber);
                    pst.setString(2,txt_fN6.getText());
                    if(mRdo6.isSelected()){
                        pst.setString(3,mRdo6.getText());
                    }
                    if (fRdo6.isSelected()){
                        pst.setString(3,fRdo6.getText());
                    }
                    pst.setInt(4,Integer.parseInt(txt_Age6.getText()));
                    pst.setString(5,txt_car6.getText());
                    if (sRdo6.isSelected()){
                        pst.setString(6,sRdo6.getText());
                    }
                    if (marrRdo6.isSelected()){
                        pst.setString(6,marrRdo6.getText());
                    }
                    pst.execute();
                    System.out.print(" added 6 ");
                    txt_HouseNumbers.clear();
                    txt_fN6.clear();
                    mRdo6.setSelected(false);
                    fRdo6.setSelected(false);
                    txt_Age6.clear();
                    txt_car6.clear();
                    sRdo6.setSelected(false);
                    marrRdo6.setSelected(false);
                    lbl_childrenSucessful.setTextFill(Color.rgb(148, 243, 242));
                    lbl_childrenSucessful.setText("Submitted Successfully");
                    lbl_childrenSucessful.setFont(Font.font("Verdana", 18));
                    refrashKebeleTabel();
                    //seven row
                    String sql7 = "INSERT INTO childrenstatus(kebelehousenumber,childfullname, childgender, childage, childcarrier, childstatus) VALUES (?,?,?,?,?,?)";
                    pst = connection.prepareStatement(sql7);
                    pst.setInt(1,Housenumber);
                    pst.setString(2,txt_fN7.getText());
                    if(mRdo7.isSelected()){
                        pst.setString(3,mRdo7.getText());
                    }
                    if (fRdo7.isSelected()){
                        pst.setString(3,fRdo7.getText());
                    }
                    pst.setInt(4,Integer.parseInt(txt_Age7.getText()));
                    pst.setString(5,txt_car7.getText());
                    if (sRdo7.isSelected()){
                        pst.setString(6,sRdo7.getText());
                    }
                    if (marrRdo7.isSelected()){
                        pst.setString(6,marrRdo7.getText());
                    }
                    pst.execute();
                    System.out.print(" added 7 ");
                    txt_HouseNumbers.clear();
                    txt_fN7.clear();
                    mRdo7.setSelected(false);
                    fRdo7.setSelected(false);
                    txt_Age7.clear();
                    txt_car7.clear();
                    sRdo7.setSelected(false);
                    marrRdo7.setSelected(false);
                    lbl_childrenSucessful.setTextFill(Color.rgb(148, 243, 242));
                    lbl_childrenSucessful.setText("Submitted Successfully");
                    lbl_childrenSucessful.setFont(Font.font("Verdana", 18));
                    refrashKebeleTabel();
                    //eight row
                    String sql8 = "INSERT INTO childrenstatus(kebelehousenumber,childfullname, childgender, childage, childcarrier, childstatus) VALUES (?,?,?,?,?,?)";
                    pst = connection.prepareStatement(sql8);
                    pst.setInt(1,Housenumber);
                    pst.setString(2,txt_fN8.getText());
                    if(mRdo8.isSelected()){
                        pst.setString(3,mRdo8.getText());
                    }
                    if (fRdo8.isSelected()){
                        pst.setString(3,fRdo8.getText());
                    }
                    pst.setInt(4,Integer.parseInt(txt_Age8.getText()));
                    pst.setString(5,txt_car8.getText());
                    if (sRdo8.isSelected()){
                        pst.setString(6,sRdo8.getText());
                    }
                    if (marrRdo8.isSelected()){
                        pst.setString(6,marrRdo8.getText());
                    }
                    pst.execute();
                    System.out.print(" added 8 ");
                    txt_HouseNumbers.clear();
                    txt_fN8.clear();
                    mRdo8.setSelected(false);
                    fRdo8.setSelected(false);
                    txt_Age8.clear();
                    txt_car8.clear();
                    sRdo8.setSelected(false);
                    marrRdo8.setSelected(false);
                    lbl_childrenSucessful.setTextFill(Color.rgb(148, 243, 242));
                    lbl_childrenSucessful.setText("Submitted Successfully");
                    lbl_childrenSucessful.setFont(Font.font("Verdana", 18));
                    refrashKebeleTabel();
                    //nine row
                    String sql9 = "INSERT INTO childrenstatus(kebelehousenumber,childfullname, childgender, childage, childcarrier, childstatus) VALUES (?,?,?,?,?,?)";
                    pst = connection.prepareStatement(sql9);
                    pst.setInt(1,Housenumber);
                    pst.setString(2,txt_fN9.getText());
                    if(mRdo9.isSelected()){
                        pst.setString(3,mRdo9.getText());
                    }
                    if (fRdo9.isSelected()){
                        pst.setString(3,fRdo9.getText());
                    }
                    pst.setInt(4,Integer.parseInt(txt_Age9.getText()));
                    pst.setString(5,txt_car9.getText());
                    if (sRdo9.isSelected()){
                        pst.setString(6,sRdo9.getText());
                    }
                    if (marrRdo9.isSelected()){
                        pst.setString(6,marrRdo9.getText());
                    }
                    pst.execute();
                    System.out.print(" added 9 ");
                    txt_HouseNumbers.clear();
                    txt_fN9.clear();
                    mRdo9.setSelected(false);
                    fRdo9.setSelected(false);
                    txt_Age9.clear();
                    txt_car9.clear();
                    sRdo9.setSelected(false);
                    marrRdo9.setSelected(false);
                    lbl_childrenSucessful.setTextFill(Color.rgb(148, 243, 242));
                    lbl_childrenSucessful.setText("Submitted Successfully");
                    lbl_childrenSucessful.setFont(Font.font("Verdana", 18));
                    refrashKebeleTabel();
                    //ten row
                    String sql10 = "INSERT INTO childrenstatus(kebelehousenumber,childfullname, childgender, childage, childcarrier, childstatus) VALUES (?,?,?,?,?,?)";
                    pst = connection.prepareStatement(sql10);
                    pst.setInt(1,Housenumber);
                    pst.setString(2,txt_fN10.getText());
                    if(mRdo10.isSelected()){
                        pst.setString(3,mRdo10.getText());
                    }
                    if (fRdo10.isSelected()){
                        pst.setString(3,fRdo10.getText());
                    }
                    pst.setInt(4,Integer.parseInt(txt_Age10.getText()));
                    pst.setString(5,txt_car10.getText());
                    if (sRdo10.isSelected()){
                        pst.setString(6,sRdo10.getText());
                    }
                    if (marrRdo10.isSelected()){
                        pst.setString(6,marrRdo10.getText());
                    }
                    pst.execute();
                    System.out.print(" added 10 ");
                    txt_HouseNumbers.clear();
                    txt_fN1.clear();
                    mRdo1.setSelected(false);
                    fRdo1.setSelected(false);
                    txt_Age1.clear();
                    txt_car1.clear();
                    sRdo1.setSelected(false);
                    marrRdo1.setSelected(false);

                    txt_fN2.clear();
                    mRdo2.setSelected(false);
                    fRdo2.setSelected(false);
                    txt_Age2.clear();
                    txt_car2.clear();
                    sRdo2.setSelected(false);
                    marrRdo2.setSelected(false);

                    txt_fN3.clear();
                    mRdo3.setSelected(false);
                    fRdo3.setSelected(false);
                    txt_Age3.clear();
                    txt_car3.clear();
                    sRdo3.setSelected(false);
                    marrRdo3.setSelected(false);

                    txt_fN4.clear();
                    mRdo4.setSelected(false);
                    fRdo4.setSelected(false);
                    txt_Age4.clear();
                    txt_car4.clear();
                    sRdo4.setSelected(false);
                    marrRdo4.setSelected(false);

                    txt_fN5.clear();
                    mRdo5.setSelected(false);
                    fRdo5.setSelected(false);
                    txt_Age5.clear();
                    txt_car5.clear();
                    sRdo5.setSelected(false);
                    marrRdo5.setSelected(false);

                    txt_fN6.clear();
                    mRdo6.setSelected(false);
                    fRdo6.setSelected(false);
                    txt_Age6.clear();
                    txt_car6.clear();
                    sRdo6.setSelected(false);
                    marrRdo6.setSelected(false);

                    txt_fN7.clear();
                    mRdo7.setSelected(false);
                    fRdo7.setSelected(false);
                    txt_Age7.clear();
                    txt_car7.clear();
                    sRdo7.setSelected(false);
                    marrRdo7.setSelected(false);

                    txt_fN7.clear();
                    mRdo7.setSelected(false);
                    fRdo7.setSelected(false);
                    txt_Age7.clear();
                    txt_car7.clear();
                    sRdo7.setSelected(false);
                    marrRdo7.setSelected(false);

                    txt_fN8.clear();
                    mRdo8.setSelected(false);
                    fRdo8.setSelected(false);
                    txt_Age8.clear();
                    txt_car8.clear();
                    sRdo8.setSelected(false);
                    marrRdo8.setSelected(false);

                    txt_fN9.clear();
                    mRdo9.setSelected(false);
                    fRdo9.setSelected(false);
                    txt_Age9.clear();
                    txt_car9.clear();
                    sRdo9.setSelected(false);
                    marrRdo9.setSelected(false);

                    txt_fN10.clear();
                    mRdo10.setSelected(false);
                    fRdo10.setSelected(false);
                    txt_Age10.clear();
                    txt_car10.clear();
                    sRdo10.setSelected(false);
                    marrRdo10.setSelected(false);
                    lbl_childrenSucessful.setTextFill(Color.rgb(148, 243, 242));
                    lbl_childrenSucessful.setText("Submitted Successfully");
                    lbl_childrenSucessful.setFont(Font.font("Verdana", 18));
                    refrashKebeleTabel();
                }catch (Exception e) {
                    System.out.print(" not added ");
                    System.out.print(e);
                }

            }

        ////Unemployed ID Card
        if (event.getSource() == btn_unemployed) {
            pn_unemployed.toFront();
        }
        if (event.getSource() == btn_choose1) {
            fc.setTitle("Choose Photo");
            fc.setInitialDirectory(new File(System.getProperty("user.home")));
            fc.getExtensionFilters().clear();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
             file = fc.showOpenDialog(null);
            if (file != null) {
                img_unemployed.setImage(new Image(String.valueOf(file.toURI().toString())));
            }
        }
        if (event.getSource() == btn_submit) {
            if (validUnemploy().equals("Success")) {
                String sql = "INSERT INTO unimployed(image, firstname, middlename, lastname, sex, phonenumber, resisdentadress, nationality, birthplace, city, zone, wereda, kebele, levelofeducation) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                 try{
                     pst = connection.prepareStatement(sql);
                     fis = new FileInputStream(file);
                     pst.setBinaryStream(1,(InputStream) fis,(int)file.length());
                     pst.setString(2,txt_Fname.getText());
                     pst.setString(3,txt_Mname.getText());
                     pst.setString(4,txt_Lname.getText());

                     if(rdomaleUnemploy.isSelected()){
                         pst.setString(5,rdomaleUnemploy.getText());
                     }
                     if (rdofemaleUnemployed.isSelected()){
                         pst.setString(5,rdofemaleUnemployed.getText());
                     }
                     pst.setInt(6, Integer.parseInt(txt_Pnumber.getText()));
                     pst.setString(7,txt_Raddress.getText());
                     pst.setString(8,txt_Nationality.getText());
                     pst.setString(9,txt_Bplace.getText());
                     pst.setString(10,txt_City.getText());
                     pst.setString(11,txt_Zone.getText());
                     pst.setInt(12,Integer.parseInt(txt_Wereda.getText()));
                     pst.setInt (13,Integer.parseInt(txt_Kebele.getText()));
                     if (RdoPrimary.isSelected()){
                         pst.setString(14,RdoPrimary.getText());
                     }
                     if (RdoSecondary.isSelected()){
                         pst.setString(14,RdoSecondary.getText());
                     }
                     if (RdoTertiary.isSelected()){
                         pst.setString(14,RdoTertiary.getText());
                     }
                     if (RdoAbove.isSelected()){
                         pst.setString(14,RdoAbove.getText());
                     }
                     pst.execute();
                     System.out.print("added");
                     img_unemployed.setVisible(false);
                     txt_Fname.clear();
                     txt_Fname.setStyle("");
                     txt_Mname.clear();
                     txt_Mname.setStyle("");
                     txt_Lname.clear();
                     txt_Lname.setStyle("");
                     rdofemaleUnemployed.setSelected(false);
                     rdomaleUnemploy.setSelected(false);
                     txt_Pnumber.clear();
                     txt_Pnumber.setStyle("");
                     txt_Raddress.clear();
                     txt_Raddress.setStyle("");
                     txt_Nationality.clear();
                     txt_Nationality.setStyle("");
                     txt_Bplace.clear();
                     txt_Bplace.setStyle("");
                     txt_City.clear();
                     txt_City.setStyle("");
                     txt_Zone.clear();
                     txt_Zone.setStyle("");
                     txt_Wereda.clear();
                     txt_Wereda.setStyle("");
                     txt_Kebele.clear();
                     txt_Kebele.setStyle("");
                     RdoPrimary.setSelected(false);
                     RdoSecondary.setSelected(false);
                     RdoTertiary.setSelected(false);
                     RdoAbove.setSelected(false);
                     lbl_errorUnemployed.setTextFill(Color.rgb(148, 243, 242));
                     lbl_errorUnemployed.setText("Submitted Successfully");
                     lbl_errorUnemployed.setFont(Font.font("Verdana", 18));
                     refreshUnemployTabel();
                 }catch (Exception e) {
                     System.out.print("not added");
                     System.out.print(e);
                 }

            }
        }
        ////Organizing unemployed
        if (event.getSource()==btn_organizing){
            pn_organizing.toFront();
        }
        if (event.getSource()==btn_chooseQR1){
            fc.setTitle("Choose Photo");
            fc.setInitialDirectory(new File(System.getProperty("user.home")));
            fc.getExtensionFilters().clear();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
             file = fc.showOpenDialog(null);
            if (file != null) {
                image_Un1.setImage(new Image(String.valueOf(file.toURI())));
            }
        }
        if (event.getSource()==btn_chooseQR2){
            fc.setTitle("Choose Photo");
            fc.setInitialDirectory(new File(System.getProperty("user.home")));
            fc.getExtensionFilters().clear();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
             file = fc.showOpenDialog(null);
            if (file != null) {
                image_Un2.setImage(new Image(String.valueOf(file.toURI())));
            }
        }
        if (event.getSource()==btn_chooseQR3){
            fc.setTitle("Choose Photo");
            fc.setInitialDirectory(new File(System.getProperty("user.home")));
            fc.getExtensionFilters().clear();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
             file = fc.showOpenDialog(null);
            if (file != null) {
                image_Un3.setImage(new Image(String.valueOf(file.toURI())));
            }
        }
        if (event.getSource()==btn_chooseQR4){
            fc.setTitle("Choose Photo");
            fc.setInitialDirectory(new File(System.getProperty("user.home")));
            fc.getExtensionFilters().clear();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
             file = fc.showOpenDialog(null);
            if (file != null) {
                image_Un4.setImage(new Image(String.valueOf(file.toURI())));
            }
        }
        if (event.getSource()==btn_chooseQR5){
            fc.setTitle("Choose Photo");
            fc.setInitialDirectory(new File(System.getProperty("user.home")));
            fc.getExtensionFilters().clear();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
            file = fc.showOpenDialog(null);
            if (file != null) {
                image_Un5.setImage(new Image(String.valueOf(file.toURI())));
            }
        }
        if (event.getSource()==btn_SubMit){
            if (validOrganize().equals("success")){
                String sql1 = "INSERT INTO organizing(QRImage, FullName, TypeOfWork, WorkingLocation, AmountOfCapital) VALUES (?,?,?,?,?)";
                try{
                    pst = connection.prepareStatement(sql1);
                    fis = new FileInputStream(file);
                    pst.setBinaryStream(1,(InputStream) fis,(int)file.length());
                    pst.setString(2,txt_fullname1.getText());
                    pst.setString(3,txt_typeWork1.getText());
                    pst.setString(4,txt_loc1.getText());
                    pst.setInt(5,Integer.parseInt(txt_capital1.getText()));
                    pst.execute();
                    System.out.print(" added 1 ");
                    refrashorganTabel();
                    //second row
                    String sql2 = "INSERT INTO organizing(QRImage, FullName, TypeOfWork, WorkingLocation, AmountOfCapital) VALUES (?,?,?,?,?)";
                    pst = connection.prepareStatement(sql2);
                    fis = new FileInputStream(file);
                    pst.setBinaryStream(1,(InputStream) fis,(int)file.length());
                    pst.setString(2,txt_fullname2.getText());
                    pst.setString(3,txt_typeWork2.getText());
                    pst.setString(4,txt_loc2.getText());
                    pst.setInt(5,Integer.parseInt(txt_capital2.getText()));
                    pst.execute();
                    System.out.print(" added 2 ");
                    refrashorganTabel();
                    //third row
                    String sql3 = "INSERT INTO organizing(QRImage, FullName, TypeOfWork, WorkingLocation, AmountOfCapital) VALUES (?,?,?,?,?)";
                    pst = connection.prepareStatement(sql3);
                    fis = new FileInputStream(file);
                    pst.setBinaryStream(1,(InputStream) fis,(int)file.length());
                    pst.setString(2,txt_fullname3.getText());
                    pst.setString(3,txt_typeWork3.getText());
                    pst.setString(4,txt_loc3.getText());
                    pst.setInt(5,Integer.parseInt(txt_capital3.getText()));
                    pst.execute();
                    System.out.print(" added 3 ");
                    refrashorganTabel();
                    //forth row
                    String sql4 = "INSERT INTO organizing(QRImage, FullName, TypeOfWork, WorkingLocation, AmountOfCapital) VALUES (?,?,?,?,?)";
                    pst = connection.prepareStatement(sql4);
                    fis = new FileInputStream(file);
                    pst.setBinaryStream(1,(InputStream) fis,(int)file.length());
                    pst.setString(2,txt_fullname4.getText());
                    pst.setString(3,txt_typeWork4.getText());
                    pst.setString(4,txt_loc4.getText());
                    pst.setInt(5,Integer.parseInt(txt_capital4.getText()));
                    pst.execute();
                    System.out.print(" added 4 ");
                    refrashorganTabel();
                    //fifth row
                    String sql5 = "INSERT INTO organizing(QRImage, FullName, TypeOfWork, WorkingLocation, AmountOfCapital) VALUES (?,?,?,?,?)";
                    pst = connection.prepareStatement(sql5);
                    fis = new FileInputStream(file);
                    pst.setBinaryStream(1,(InputStream) fis,(int)file.length());
                    pst.setString(2,txt_fullname5.getText());
                    pst.setString(3,txt_typeWork5.getText());
                    pst.setString(4,txt_loc5.getText());
                    pst.setInt(5,Integer.parseInt(txt_capital5.getText()));
                    pst.execute();
                    System.out.print(" added 5 ");
                    image_Un1.setImage(null);
                    image_Un2.setImage(null);
                    image_Un3.setImage(null);
                    image_Un4.setImage(null);
                    image_Un5.setImage(null);
                    txt_fullname1.clear();
                    txt_fullname1.setStyle("");
                    txt_fullname2.clear();
                    txt_fullname2.setStyle("");
                    txt_fullname3.clear();
                    txt_fullname3.setStyle("");
                    txt_fullname4.clear();
                    txt_fullname4.setStyle("");
                    txt_fullname5.clear();
                    txt_fullname5.setStyle("");
                    txt_typeWork1.clear();
                    txt_typeWork1.setStyle("");
                    txt_typeWork2.clear();
                    txt_typeWork2.setStyle("");
                    txt_typeWork3.clear();
                    txt_typeWork3.setStyle("");
                    txt_typeWork4.clear();
                    txt_typeWork4.setStyle("");
                    txt_typeWork5.clear();
                    txt_typeWork5.setStyle("");
                    txt_loc1.clear();
                    txt_loc1.setStyle("");
                    txt_loc2.clear();
                    txt_loc2.setStyle("");
                    txt_loc3.clear();
                    txt_loc3.setStyle("");
                    txt_loc4.clear();
                    txt_loc4.setStyle("");
                    txt_loc5.clear();
                    txt_loc5.setStyle("");
                    txt_capital1.clear();
                    txt_capital1.setStyle("");
                    txt_capital2.clear();
                    txt_capital2.setStyle("");
                    txt_capital3.clear();
                    txt_capital3.setStyle("");
                    txt_capital4.clear();
                    txt_capital4.setStyle("");
                    txt_capital5.clear();
                    txt_capital5.setStyle("");
                    lbl_errorOrg.setTextFill(Color.rgb(148, 243, 242));
                    lbl_errorOrg.setText("Submitted Successfully");
                    lbl_errorOrg.setFont(Font.font("Verdana", 18));
                    refrashorganTabel();
                }catch (Exception e) {
                    System.out.print("not added");
                    System.out.print(e);
                }
            }
        }
        ////MARRIAGE CERTIFICATE
        if (event.getSource()==btn_marriage){
            pn_merriageCertificate.toFront();
        }
        if (event.getSource()==btn_submitMarriage){
            if (validMarrage().equals("success")){
                String sql = "INSERT INTO marriage(husbandname, wifename, date, day, year, assigner, place, firstwitness, secondwitness) VALUES (?,?,?,?,?,?,?,?,?)";
                try{
                    pst = connection.prepareStatement(sql);
                    pst.setString(1,txt_hasbund.getText());
                    pst.setString(2,txt_wife.getText());
                    pst.setInt(3,Integer.parseInt(txt_month.getText()));
                    pst.setInt(4,Integer.parseInt(txt_day.getText()));
                    pst.setInt(5,Integer.parseInt(txt_year.getText()));
                    pst.setString(6,txt_by.getText());
                    pst.setString(7,txt_at.getText());
                    pst.setString(8,txt_witness1.getText());
                    pst.setString(9,txt_witness2.getText());
                    pst.execute();
                    System.out.print("added");
                    txt_hasbund.clear();
                    txt_hasbund.setStyle("");
                    txt_wife.clear();
                    txt_wife.setStyle("");
                    txt_month.clear();
                    txt_month.setStyle("");
                    txt_day.clear();
                    txt_day.setStyle("");
                    txt_year.clear();
                    txt_year.setStyle("");
                    txt_by.clear();
                    txt_by.setStyle("");
                    txt_at.clear();
                    txt_at.setStyle("");
                    txt_witness1.clear();
                    txt_witness1.setStyle("");
                    txt_witness2.setStyle("");
                    txt_witness2.clear();
                    lbl_errorMarriage.setTextFill(Color.rgb(148, 243, 242));
                    lbl_errorMarriage.setText("Submitted Successfully");
                    lbl_errorMarriage.setFont(Font.font("Verdana", 18));
                    referashMarriageTabel();
                }catch (Exception e) {
                    System.out.print("not added");
                    System.out.print(e);
                }
            }
        }
        ////Access File
        if (event.getSource() ==btn_access){
            pn_Access.toFront();

        }
        if (event.getSource()==btn_AcessID){ pn_tabel_id.toFront(); }
        if (event.getSource()==btn_AcessKebeleHouse){ pn_tabel_KebelaHouse.toFront(); }
        if(event.getSource()==btn_AcessBirthCertificate){ pn_tabel_BirthCeriteficate.toFront(); }
        if (event.getSource()==btn_AcessUnemployedID){ pn_tabel_unemployed.toFront(); }
        if(event.getSource()==btn_AcessMarrage){ pn_tabel_marrage.toFront(); }
        if (event.getSource()==btn_AcessOrganizing){ pn_tabel_organize.toFront(); }

        if (event.getSource()==btn_AcessKebeleHouse){IDimage.setImage(null);OrganizeImage.setImage(null);}
        if(event.getSource()==btn_AcessBirthCertificate){ IDimage.setImage(null);OrganizeImage.setImage(null); }
        if (event.getSource()==btn_AcessUnemployedID){ IDimage.setImage(null);OrganizeImage.setImage(null); }
        if(event.getSource()==btn_AcessMarrage){IDimage.setImage(null);OrganizeImage.setImage(null); }
        if (event.getSource()==btn_AcessOrganizing){ IDimage.setImage(null);}
        if (event.getSource()==btn_AcessID){OrganizeImage.setImage(null);}

    }
    public void backButon(MouseEvent event){
       ////House & IDENTIFICATION CARD  & Kebele &  BIRTHDAY CERTIFICATE &  ////Unemployed ID Card & Organizing unemployed & MARRIAGE CERTIFICATE & Acess File
        if(event.getSource()==img_back1 || event.getSource()==img_backId || event.getSource() ==img_back2 || event.getSource()==img_back3 || event.getSource()==img_back5 || event.getSource()==img_back6 || event.getSource()==font_Back || event.getSource()==img_backId7|| event.getSource()==imageAcessBack){
            pn_form.toFront();
        }
        ////Children Status
        if (event.getSource()==img_back4){
            pn_kebeleHouse.toFront();
        }
    }
           ///House
    public String validHouse(){
        if (txt_HFatherName.getText().isEmpty() && txt_HMatherName.getText().isEmpty() && txt_HhouseNumber.getText().isEmpty() && txt_HPNumber.getText().isEmpty() && datePickerHFile.getEditor().getText().isEmpty()){
            lbl_errorHouse.setTextFill(Color.TOMATO);
            lbl_errorHouse.setFont(Font.font ("Verdana", 20));
            lbl_errorHouse.setText("Please Enter All The Values");
            return "error";
        }
        if (txt_HFatherName.getText().isEmpty()){
            lbl_errorHouse.setTextFill(Color.TOMATO);
            lbl_errorHouse.setFont(Font.font ("Verdana", 20));
            lbl_errorHouse.setText("Enter Father Name");
            txt_HFatherName.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_HMatherName.getText().isEmpty()){
            lbl_errorHouse.setTextFill(Color.TOMATO);
            lbl_errorHouse.setFont(Font.font ("Verdana", 20));
            lbl_errorHouse.setText("Enter Mother Name");
            txt_HMatherName.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_HhouseNumber.getText().isEmpty()){
            lbl_errorHouse.setTextFill(Color.TOMATO);
            lbl_errorHouse.setFont(Font.font ("Verdana", 20));
            lbl_errorHouse.setText("Enter House Number");
            txt_HhouseNumber.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (datePickerHFile.getEditor().getText().isEmpty()){
            lbl_errorHouse.setTextFill(Color.TOMATO);
            lbl_errorHouse.setFont(Font.font ("Verdana", 20));
            lbl_errorHouse.setText("Enter File Submission Date");
            datePickerHFile.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_HPNumber.getText().isEmpty()){
            lbl_errorHouse.setTextFill(Color.TOMATO);
            lbl_errorHouse.setFont(Font.font ("Verdana", 20));
            lbl_errorHouse.setText("Enter House Phone Number");
            txt_HPNumber.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }

        return "Success";
    }
  public String HouseRadioChoose() {
      rdoHmale1.setToggleGroup(genderChild1);
      rdoHfemal1.setToggleGroup(genderChild1);
      rdoHmale2.setToggleGroup(genderChild2);
      rdoHfemal2.setToggleGroup(genderChild2);
      rdoHmale3.setToggleGroup(genderChild3);
      rdoHfemal3.setToggleGroup(genderChild3);
      rdoHmale4.setToggleGroup(genderChild4);
      rdoHfemal4.setToggleGroup(genderChild4);
      rdoHmale5.setToggleGroup(genderChild5);
      rdoHfemal5.setToggleGroup(genderChild5);
      rdoHmale6.setToggleGroup(genderChild6);
      rdoHfemal6.setToggleGroup(genderChild6);
      rdoHmale7.setToggleGroup(genderChild7);
      rdoHfemal7.setToggleGroup(genderChild7);
      rdoHmale8.setToggleGroup(genderChild8);
      rdoHfemal8.setToggleGroup(genderChild8);
      rdoHmale9.setToggleGroup(genderChild9);
      rdoHfemal9.setToggleGroup(genderChild9);
      rdoHmale10.setToggleGroup(genderChild10);
      rdoHfemal10.setToggleGroup(genderChild10);

      if (rdoHmale1.isSelected()) {
          return rdoHmale1.getText();
      }
      if (rdoHfemal1.isSelected()) {
          return rdoHfemal1.getText();
      }
      if (rdoHmale2.isSelected()) {
          return rdoHmale1.getText();
      }
      if (rdoHfemal2.isSelected()) {
          return rdoHfemal2.getText();
      }
      if (rdoHmale3.isSelected()) {
          return rdoHmale3.getText();
      }
      if (rdoHfemal3.isSelected()) {
          return rdoHfemal3.getText();
      }
      if (rdoHmale4.isSelected()) {
          return rdoHmale4.getText();
      }
      if (rdoHfemal4.isSelected()) {
          return rdoHfemal4.getText();
      }
      if (rdoHmale5.isSelected()) {
          return rdoHmale5.getText();
      }
      if (rdoHfemal5.isSelected()) {
          return rdoHfemal5.getText();
      }
      if (rdoHmale6.isSelected()) {
          return rdoHmale6.getText();
      }
      if (rdoHfemal6.isSelected()) {
          return rdoHfemal6.getText();
      }
      if (rdoHmale7.isSelected()) {
          return rdoHmale7.getText();
      }
      if (rdoHfemal7.isSelected()) {
          return rdoHfemal7.getText();
      }
      if (rdoHmale8.isSelected()) {
          return rdoHmale8.getText();
      }
      if (rdoHfemal8.isSelected()) {
          return rdoHfemal8.getText();
      }
      if (rdoHmale9.isSelected()) {
          return rdoHmale9.getText();
      }
      if (rdoHfemal9.isSelected()) {
          return rdoHfemal9.getText();
      }
      if (rdoHmale10.isSelected()) {
          return rdoHmale10.getText();
      }
      if (rdoHfemal10.isSelected()) {
          return rdoHfemal10.getText();
      }
      return null;
  }
          ///IDENTIFICATION CARD
    public String validCard(){
        if (txt_regNumber.getText().isEmpty()&& txt_resFname.getText().isEmpty()&& txt_resMname.getText().isEmpty() && txt_resLname.getText().isEmpty() && txt_resIdNumber.getText().isEmpty()
           &&  txt_resBloodGroup.getText().isEmpty() && txt_resPhoneNumber.getText().isEmpty() && txt_resAdress.getText().isEmpty() && txt_resHouseNumber.getText().isEmpty()
           &&  txt_EmgFName.getText().isEmpty() && txt_EmgMName.getText().isEmpty() &&  txt_EmgLName.getText().isEmpty() && tex_EmgPNumber.getText().isEmpty()){
            lbl_errorIdCard.setTextFill(Color.TOMATO);
            lbl_errorIdCard.setFont(Font.font ("Verdana", 20));
            lbl_errorIdCard.setText("Please Enter All The Values");
            return "error";
        }
        if (txt_regNumber.getText().isEmpty()){
            lbl_errorIdCard.setTextFill(Color.TOMATO);
            lbl_errorIdCard.setFont(Font.font ("Verdana", 20));
            lbl_errorIdCard.setText("Enter Register Number");
            txt_regNumber.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_resFname.getText().isEmpty()){
            lbl_errorIdCard.setTextFill(Color.TOMATO);
            lbl_errorIdCard.setFont(Font.font ("Verdana", 20));
            lbl_errorIdCard.setText("Enter First Name");
            txt_resFname.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_resMname.getText().isEmpty()) {
            lbl_errorIdCard.setTextFill(Color.TOMATO);
            lbl_errorIdCard.setFont(Font.font ("Verdana", 20));
            lbl_errorIdCard.setText("Enter Middle Name");
            txt_resMname.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_resLname.getText().isEmpty()) {
            lbl_errorIdCard.setTextFill(Color.TOMATO);
            lbl_errorIdCard.setFont(Font.font ("Verdana", 20));
            lbl_errorIdCard.setText("Enter Last Name");
            txt_resLname.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_resIdNumber.getText().isEmpty()) {
            lbl_errorIdCard.setTextFill(Color.TOMATO);
            lbl_errorIdCard.setFont(Font.font ("Verdana", 20));
            lbl_errorIdCard.setText("Enter ID Number");
            txt_resIdNumber.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (datePickerBirth.getEditor().getText().isEmpty()){
            lbl_errorIdCard.setTextFill(Color.TOMATO);
            lbl_errorIdCard.setFont(Font.font ("Verdana", 20));
            lbl_errorIdCard.setText("Enter Date Of Birth");
            datePickerBirth.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_resBloodGroup.getText().isEmpty()) {
            lbl_errorIdCard.setTextFill(Color.TOMATO);
            lbl_errorIdCard.setFont(Font.font ("Verdana", 20));
            lbl_errorIdCard.setText("Enter Blood Group");
            txt_resBloodGroup.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (datePickerIssue.getEditor().getText().isEmpty()){
            lbl_errorIdCard.setTextFill(Color.TOMATO);
            lbl_errorIdCard.setFont(Font.font ("Verdana", 20));
            lbl_errorIdCard.setText("Enter Issue Date");
            datePickerIssue.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (datePickerExpire.getEditor().getText().isEmpty()){
            lbl_errorIdCard.setTextFill(Color.TOMATO);
            lbl_errorIdCard.setFont(Font.font ("Verdana", 20));
            lbl_errorIdCard.setText("Enter Expire Date");
            datePickerExpire.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_resAdress.getText().isEmpty()) {
            lbl_errorIdCard.setTextFill(Color.TOMATO);
            lbl_errorIdCard.setFont(Font.font ("Verdana", 20));
            lbl_errorIdCard.setText("Enter Resident Address");
            txt_resAdress.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_resPhoneNumber.getText().isEmpty()) {
            lbl_errorIdCard.setTextFill(Color.TOMATO);
            lbl_errorIdCard.setFont(Font.font ("Verdana", 20));
            lbl_errorIdCard.setText("Enter Phone Number");
            txt_resPhoneNumber.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_resHouseNumber.getText().isEmpty()) {
            lbl_errorIdCard.setTextFill(Color.TOMATO);
            lbl_errorIdCard.setFont(Font.font ("Verdana", 20));
            lbl_errorIdCard.setText("Enter House Number");
            txt_resHouseNumber.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_EmgFName.getText().isEmpty()) {
            lbl_errorIdCard.setTextFill(Color.TOMATO);
            lbl_errorIdCard.setFont(Font.font ("Verdana", 20));
            lbl_errorIdCard.setText("Enter EMG First Name");
            txt_EmgFName.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if ( txt_EmgMName.getText().isEmpty()) {
            lbl_errorIdCard.setTextFill(Color.TOMATO);
            lbl_errorIdCard.setFont(Font.font ("Verdana", 20));
            lbl_errorIdCard.setText("Enter EMG Middle Name");
            txt_EmgMName.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if ( txt_EmgLName.getText().isEmpty()) {
            lbl_errorIdCard.setTextFill(Color.TOMATO);
            lbl_errorIdCard.setFont(Font.font ("Verdana", 20));
            lbl_errorIdCard.setText("Enter EMG Last Name");
            txt_EmgLName.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if ( tex_EmgPNumber.getText().isEmpty()) {
            lbl_errorIdCard.setTextFill(Color.TOMATO);
            lbl_errorIdCard.setFont(Font.font ("Verdana", 20));
            lbl_errorIdCard.setText("Enter EMG Phone Number");
            tex_EmgPNumber.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        return "Success";
    }
    public String radioChoose(){
        id_male.setToggleGroup(chooseM);
        id_female.setToggleGroup(chooseM);
        if (id_male.isSelected()){

            return id_male.getText();
        }
        else
            return id_female.getText();

    }
         ////BIRTHDAY CERTIFICATE
    public String validBirth(){
    if (txt_childName.getText().isEmpty() && txt_fName.getText().isEmpty() && txt_gName.getText().isEmpty() && txt_mFullName.getText().isEmpty() && txt_bDayFile.getText().isEmpty()
    && txt_bDayUnique.getText().isEmpty()  && txt_fNationality.getText().isEmpty() && txt_mNationality.getText().isEmpty() && txt_birthPlace.getText().isEmpty()
    && txt_nationality.getText().isEmpty()  &&  txt_fFullName.getText().isEmpty()){
        lbl_error.setTextFill(Color.TOMATO);
        lbl_error.setFont(Font.font ("Verdana", 20));
        lbl_error.setText("Please Enter All The Value");
        return "error";
    }
    if (txt_childName.getText().isEmpty()){
        lbl_error.setTextFill(Color.TOMATO);
        lbl_error.setFont(Font.font ("Verdana", 20));
        lbl_error.setText("Enter Child Name");
        txt_childName.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
        return "error";
        }
        if (txt_fName.getText().isEmpty()){
            lbl_error.setTextFill(Color.TOMATO);
            lbl_error.setFont(Font.font ("Verdana", 20));
            lbl_error.setText("Enter Father Name");
            txt_fName.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_gName.getText().isEmpty()){
            lbl_error.setTextFill(Color.TOMATO);
            lbl_error.setFont(Font.font ("Verdana", 20));
            lbl_error.setText("Enter Grand.F Name");
            txt_gName.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (dpicker_birth.getEditor().getText().isEmpty()){
            lbl_error.setTextFill(Color.TOMATO);
            lbl_error.setFont(Font.font ("Verdana", 20));
            lbl_error.setText("Enter Grand.F Name");
            dpicker_birth.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if ( txt_birthPlace.getText().isEmpty()){
            lbl_error.setTextFill(Color.TOMATO);
            lbl_error.setFont(Font.font ("Verdana", 20));
            lbl_error.setText("Enter Birth Place");
            txt_birthPlace.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_nationality.getText().isEmpty()){
            lbl_error.setTextFill(Color.TOMATO);
            lbl_error.setFont(Font.font ("Verdana", 20));
            lbl_error.setText("Enter Nationality");
            txt_nationality.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_mFullName.getText().isEmpty()){
            lbl_error.setTextFill(Color.TOMATO);
            lbl_error.setFont(Font.font ("Verdana", 20));
            lbl_error.setText("Enter Mother Full Name");
            txt_mFullName.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if ( txt_mNationality.getText().isEmpty()){
            lbl_error.setTextFill(Color.TOMATO);
            lbl_error.setFont(Font.font ("Verdana", 20));
            lbl_error.setText("Enter Mother Nationality");
            txt_mNationality.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if ( txt_fFullName.getText().isEmpty()){
            lbl_error.setTextFill(Color.TOMATO);
            lbl_error.setFont(Font.font ("Verdana", 20));
            lbl_error.setText("Enter Father FullName");
            txt_fFullName.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if ( txt_fNationality.getText().isEmpty()){
            lbl_error.setTextFill(Color.TOMATO);
            lbl_error.setFont(Font.font ("Verdana", 20));
            lbl_error.setText("Enter Father Nationality");
            txt_fNationality.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (dPicker_bDayRegistor.getEditor().getText().isEmpty()){
            lbl_error.setTextFill(Color.TOMATO);
            lbl_error.setFont(Font.font ("Verdana", 20));
            lbl_error.setText("Enter BirtDay Register Date");
            dPicker_bDayRegistor.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_bDayFile.getText().isEmpty()){
            lbl_error.setTextFill(Color.TOMATO);
            lbl_error.setFont(Font.font ("Verdana", 20));
            lbl_error.setText("Enter BirthDay File form Number");
            txt_bDayFile.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (dPicker_certifGiven.getEditor().getText().isEmpty()){
            lbl_error.setTextFill(Color.TOMATO);
            lbl_error.setFont(Font.font ("Verdana", 20));
            lbl_error.setText("Enter Certificate Given Date");
            dPicker_certifGiven.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_bDayUnique.getText().isEmpty()){
            lbl_error.setTextFill(Color.TOMATO);
            lbl_error.setFont(Font.font ("Verdana", 20));
            lbl_error.setText("Enter BirthDay Register Unique Number");
            txt_bDayUnique.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }

      return "success";
    }
    public String birthchoice(){
        rdoMale.setToggleGroup(chooseF);
        rdoFemale.setToggleGroup(chooseF);
        if (rdoMale.isSelected()){
            rdoMale.getText();
        }else if (rdoFemale.isSelected()){
            rdoFemale.getText();
        }
        return null;
    }
            ////KEBELE HOUSE
      public String validKebele() {
          if (txt_AmountOfRoom.getText().isEmpty() && txt_HouseLocation.getText().isEmpty() && txt_SurfaceArea.getText().isEmpty() && txt_fatherFullName.getText().isEmpty() &&
                  txt_houseNumber.getText().isEmpty() && txt_motherFullName.getText().isEmpty()) {
              lbl_valid.setTextFill(Color.TOMATO);
              lbl_valid.setFont(Font.font("Verdana", 20));
              lbl_valid.setText("Enter All Value");
              return "error";
          }
          if (txt_fatherFullName.getText().isEmpty()) {
              lbl_valid.setTextFill(Color.TOMATO);
              lbl_valid.setFont(Font.font("Verdana", 20));
              lbl_valid.setText("Enter Father Full Name");
              txt_fatherFullName.setStyle("-fx-border-color: red;" + "-fx-background-color: transparent;" + "-fx-border-width: 0px 0px 2px 0px");
              return "error";
          }
          if (txt_motherFullName.getText().isEmpty()) {
              lbl_valid.setTextFill(Color.TOMATO);
              lbl_valid.setFont(Font.font("Verdana", 20));
              lbl_valid.setText("Enter Mother Full Name");
              txt_motherFullName.setStyle("-fx-border-color: red;" + "-fx-background-color: transparent;" + "-fx-border-width: 0px 0px 2px 0px");
              return "error";
          }
          if (txt_houseNumber.getText().isEmpty()) {
              lbl_valid.setTextFill(Color.TOMATO);
              lbl_valid.setFont(Font.font("Verdana", 20));
              lbl_valid.setText("Enter House Number");
              txt_houseNumber.setStyle("-fx-border-color: red;" + "-fx-background-color: transparent;" + "-fx-border-width: 0px 0px 2px 0px");
              return "error";
          }
          if (txt_AmountOfRoom.getText().isEmpty()) {
              lbl_valid.setTextFill(Color.TOMATO);
              lbl_valid.setFont(Font.font("Verdana", 20));
              lbl_valid.setText("Enter Amount Of Room");
              txt_AmountOfRoom.setStyle("-fx-border-color: red;" + "-fx-background-color: transparent;" + "-fx-border-width: 0px 0px 2px 0px");
              return "error";
          }
          if (txt_SurfaceArea.getText().isEmpty()) {
              lbl_valid.setTextFill(Color.TOMATO);
              lbl_valid.setFont(Font.font("Verdana", 20));
              lbl_valid.setText("Enter Surface Area");
              txt_SurfaceArea.setStyle("-fx-border-color: red;" + "-fx-background-color: transparent;" + "-fx-border-width: 0px 0px 2px 0px");
              return "error";
          }
          if (txt_HouseLocation.getText().isEmpty()) {
              lbl_valid.setTextFill(Color.TOMATO);
              lbl_valid.setFont(Font.font("Verdana", 20));
              lbl_valid.setText("Enter House Location");
              txt_HouseLocation.setStyle("-fx-border-color: red;" + "-fx-background-color: transparent;" + "-fx-border-width: 0px 0px 2px 0px");
              return "error";
          }
          return "success";
      }
          public String windowAmountChoose(){ String windowAmount =null;rdo1.setToggleGroup(amountGroup);rdo2.setToggleGroup(amountGroup);moreRdo.setToggleGroup(amountGroup);
              if (rdo1.isSelected()){ windowAmount = rdo1.getText();return windowAmount;
              }
              if (rdo2.isSelected()){ windowAmount = rdo2.getText();return windowAmount;
              }
              if(moreRdo.isSelected()){ windowAmount =moreRdo.getText();return windowAmount;
              }
              return windowAmount;
          }
    public String windowTypeChoose(){
        ironRdo.setToggleGroup(typeGroup);
        mirrorRdo.setToggleGroup(typeGroup);
        woodRdo.setToggleGroup(typeGroup);
        if (ironRdo.isSelected()){ return ironRdo.getText();
        }
        if (mirrorRdo.isSelected()){ return mirrorRdo.getText();
        }
        if( woodRdo.isSelected()){ return woodRdo.getText();
        }return null;
    }
    public String doorTypeChoose(){
        String doorType =null;
        irondoorRdo.setToggleGroup(DtypeGroup);
        frenchRdo.setToggleGroup(DtypeGroup);
        otherRdo.setToggleGroup(DtypeGroup);
        if (irondoorRdo.isSelected()){ doorType = irondoorRdo.getText();return doorType;
        }
        if (frenchRdo.isSelected()){ doorType = frenchRdo.getText();return doorType;
        }
        if(otherRdo.isSelected()){ doorType = otherRdo.getText();return doorType;
        }return doorType;
    }
    ////Children status
    public  String statusChoose(){
        sRdo1.setToggleGroup(childS1);
        marrRdo1.setToggleGroup(childS1);
        sRdo2.setToggleGroup(childS2);
        marrRdo2.setToggleGroup(childS2);
        sRdo3.setToggleGroup(childS3);
        marrRdo3.setToggleGroup(childS3);
        sRdo4.setToggleGroup(childS4);
        marrRdo4.setToggleGroup(childS4);
        sRdo5.setToggleGroup(childS5);
        marrRdo5.setToggleGroup(childS5);
        sRdo6.setToggleGroup(childS6);
        marrRdo6.setToggleGroup(childS6);
        sRdo7.setToggleGroup(childS7);
        marrRdo7.setToggleGroup(childS7);
        sRdo8.setToggleGroup(childS8);
        marrRdo8.setToggleGroup(childS8);
        sRdo9.setToggleGroup(childS9);
        marrRdo9.setToggleGroup(childS9);
        sRdo10.setToggleGroup(childS10);
        marrRdo10.setToggleGroup(childS10);

        mRdo1.setToggleGroup(childG1);
        fRdo1.setToggleGroup(childG1);
        mRdo2.setToggleGroup(childG2);
        fRdo2.setToggleGroup(childG2);
        mRdo3.setToggleGroup(childG3);
        fRdo3.setToggleGroup(childG3);
        mRdo4.setToggleGroup(childG4);
        fRdo4.setToggleGroup(childG4);
        mRdo5.setToggleGroup(childG5);
        fRdo5.setToggleGroup(childG5);
        mRdo6.setToggleGroup(childG6);
        fRdo6.setToggleGroup(childG6);
        mRdo7.setToggleGroup(childG7);
        fRdo7.setToggleGroup(childG7);
        mRdo8.setToggleGroup(childG8);
        fRdo8.setToggleGroup(childG8);
        mRdo9.setToggleGroup(childG9);
        fRdo9.setToggleGroup(childG9);
        mRdo10.setToggleGroup(childG10);
        fRdo10.setToggleGroup(childG10);

        if (sRdo1.isSelected()){ return  sRdo1.getText();
        }
        if(marrRdo1.isSelected()){ return marrRdo1.getText();
        }
        if (sRdo2.isSelected()){ return  sRdo2.getText();
        }
        if(marrRdo2.isSelected()){ return marrRdo2.getText();
        }
        if (sRdo3.isSelected()){ return  sRdo3.getText();
        }
        if(marrRdo3.isSelected()){ return marrRdo3.getText();
        }
        if (sRdo4.isSelected()){ return  sRdo4.getText();
        }
        if(marrRdo4.isSelected()){ return marrRdo4.getText();
        }
        if (sRdo5.isSelected()){ return  sRdo5.getText();
        }
        if(marrRdo5.isSelected()){ return marrRdo5.getText();
        }
        if (sRdo6.isSelected()){ return  sRdo6.getText();
        }
        if(marrRdo6.isSelected()){ return marrRdo6.getText();
        }
        if (sRdo7.isSelected()){ return  sRdo7.getText();
        }
        if(marrRdo7.isSelected()){ return marrRdo7.getText();
        }
        if (sRdo8.isSelected()){ return  sRdo8.getText();
        }
        if(marrRdo8.isSelected()){ return marrRdo8.getText();
        }
        if (sRdo9.isSelected()){ return  sRdo9.getText();
        }
        if(marrRdo9.isSelected()){ return marrRdo9.getText();
        }
        if (sRdo10.isSelected()){ return  sRdo10.getText();
        }
        if(marrRdo10.isSelected()){ return marrRdo10.getText();
        }
        if (mRdo1.isSelected()){ return mRdo1.getText();
        }
        if (fRdo1.isSelected()){ return fRdo1.getText();
        }
        if (mRdo2.isSelected()){ return mRdo2.getText();
        }
        if (fRdo2.isSelected()){ return fRdo2.getText();
        }
        if (mRdo3.isSelected()){ return mRdo3.getText();
        }
        if (fRdo3.isSelected()){ return fRdo3.getText();
        }
        if (mRdo4.isSelected()){ return mRdo4.getText();
        }
        if (fRdo4.isSelected()){ return fRdo4.getText();
        }
        if (mRdo5.isSelected()){ return mRdo5.getText();
        }
        if (fRdo5.isSelected()){ return fRdo5.getText();
        }
        if (mRdo6.isSelected()){ return mRdo6.getText();
        }
        if (fRdo6.isSelected()){ return fRdo6.getText();
        }
        if (mRdo7.isSelected()){ return mRdo7.getText();
        }
        if (fRdo7.isSelected()){ return fRdo7.getText();
        }
        if (mRdo8.isSelected()){ return mRdo8.getText();
        }
        if (fRdo8.isSelected()){ return fRdo8.getText();
        }
        if (mRdo9.isSelected()){ return mRdo9.getText();
        }
        if (fRdo9.isSelected()){ return fRdo9.getText();
        }
        if (mRdo10.isSelected()){ return mRdo10.getText();
        }
        if (fRdo10.isSelected()){ return fRdo10.getText();
        }
        return null;
    }
    ////Unemployed ID Card
    public String validUnemploy() {
        if (txt_Fname.getText().isEmpty() && txt_Mname.getText().isEmpty() && txt_Lname.getText().isEmpty() && txt_Pnumber.getText().isEmpty() && txt_Raddress.getText().isEmpty()
                && txt_Nationality.getText().isEmpty() && txt_Bplace.getText().isEmpty() && txt_City.getText().isEmpty() && txt_Zone.getText().isEmpty() && txt_Wereda.getText().isEmpty()
                && txt_Kebele.getText().isEmpty()) {
            lbl_errorUnemployed.setTextFill(Color.TOMATO);
            lbl_errorUnemployed.setFont(Font.font("Verdana", 20));
            lbl_errorUnemployed.setText("Enter All Value");
            return "error";
        }
        if (txt_Fname.getText().isEmpty()) {
            lbl_errorUnemployed.setTextFill(Color.TOMATO);
            lbl_errorUnemployed.setFont(Font.font("Verdana", 20));
            lbl_errorUnemployed.setText("Enter First Name");
            txt_Fname.setStyle("-fx-border-color: red;" + "-fx-background-color: transparent;" + "-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_Mname.getText().isEmpty()) {
            lbl_errorUnemployed.setTextFill(Color.TOMATO);
            lbl_errorUnemployed.setFont(Font.font("Verdana", 20));
            lbl_errorUnemployed.setText("Enter Middle Name");
            txt_Mname.setStyle("-fx-border-color: red;" + "-fx-background-color: transparent;" + "-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_Lname.getText().isEmpty()) {
            lbl_errorUnemployed.setTextFill(Color.TOMATO);
            lbl_errorUnemployed.setFont(Font.font("Verdana", 20));
            lbl_errorUnemployed.setText("Enter Last Name");
            txt_Lname.setStyle("-fx-border-color: red;" + "-fx-background-color: transparent;" + "-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_Pnumber.getText().isEmpty()) {
            lbl_errorUnemployed.setTextFill(Color.TOMATO);
            lbl_errorUnemployed.setFont(Font.font("Verdana", 20));
            lbl_errorUnemployed.setText("Enter  Phone Number");
            txt_Pnumber.setStyle("-fx-border-color: red;" + "-fx-background-color: transparent;" + "-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_Raddress.getText().isEmpty()) {
            lbl_errorUnemployed.setTextFill(Color.TOMATO);
            lbl_errorUnemployed.setFont(Font.font("Verdana", 20));
            lbl_errorUnemployed.setText("Enter  Resident Address");
            txt_Raddress.setStyle("-fx-border-color: red;" + "-fx-background-color: transparent;" + "-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_Nationality.getText().isEmpty()) {
            lbl_errorUnemployed.setTextFill(Color.TOMATO);
            lbl_errorUnemployed.setFont(Font.font("Verdana", 20));
            lbl_errorUnemployed.setText("Enter Nationality");
            txt_Nationality.setStyle("-fx-border-color: red;" + "-fx-background-color: transparent;" + "-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_Bplace.getText().isEmpty()) {
            lbl_errorUnemployed.setTextFill(Color.TOMATO);
            lbl_errorUnemployed.setFont(Font.font("Verdana", 20));
            lbl_errorUnemployed.setText("Enter Birth Place");
            txt_Bplace.setStyle("-fx-border-color: red;" + "-fx-background-color: transparent;" + "-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_City.getText().isEmpty()) {
            lbl_errorUnemployed.setTextFill(Color.TOMATO);
            lbl_errorUnemployed.setFont(Font.font("Verdana", 20));
            lbl_errorUnemployed.setText("Enter City");
            txt_City.setStyle("-fx-border-color: red;" + "-fx-background-color: transparent;" + "-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_Zone.getText().isEmpty()) {
            lbl_errorUnemployed.setTextFill(Color.TOMATO);
            lbl_errorUnemployed.setFont(Font.font("Verdana", 20));
            lbl_errorUnemployed.setText("Enter Zone");
            txt_Zone.setStyle("-fx-border-color: red;" + "-fx-background-color: transparent;" + "-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_Wereda.getText().isEmpty()) {
            lbl_errorUnemployed.setTextFill(Color.TOMATO);
            lbl_errorUnemployed.setFont(Font.font("Verdana", 20));
            lbl_errorUnemployed.setText("Enter Wereda");
            txt_Wereda.setStyle("-fx-border-color: red;" + "-fx-background-color: transparent;" + "-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_Kebele.getText().isEmpty()) {
            lbl_errorUnemployed.setTextFill(Color.TOMATO);
            lbl_errorUnemployed.setFont(Font.font("Verdana", 20));
            lbl_errorUnemployed.setText("Enter Kebele");
            txt_Kebele.setStyle("-fx-border-color: red;" + "-fx-background-color: transparent;" + "-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        return "Success";
    }
        public  String levelEducationChoose(){
            String levelEducation =null;
            RdoPrimary.setToggleGroup(levelGroup);
            RdoSecondary.setToggleGroup(levelGroup);
            RdoTertiary.setToggleGroup(levelGroup);
            RdoAbove.setToggleGroup(levelGroup);
            rdomaleUnemploy.setToggleGroup(choose1);
            rdofemaleUnemployed.setToggleGroup(choose1);
            if (rdomaleUnemploy.isSelected()){ levelEducation= rdomaleUnemploy.getText();return levelEducation; }
            if (rdofemaleUnemployed.isSelected()){ levelEducation= rdofemaleUnemployed.getText();return levelEducation; }
            if (RdoPrimary.isSelected()){ levelEducation = RdoPrimary.getText();return  levelEducation; }
            if(RdoSecondary.isSelected()){ levelEducation =RdoSecondary.getText();return levelEducation; }
            if(RdoTertiary.isSelected()){ levelEducation =RdoTertiary.getText();return levelEducation; }
            if(RdoAbove.isSelected()){ levelEducation =RdoAbove.getText();return levelEducation; }return levelEducation;
        }
     ///Unemployed Organization
    public String validOrganize(){
        if (txt_fullname1.getText().isEmpty() && txt_fullname2.getText().isEmpty() && txt_fullname3.getText().isEmpty() && txt_fullname4.getText().isEmpty() && txt_fullname5.getText().isEmpty()
         && txt_typeWork1.getText().isEmpty() && txt_typeWork2.getText().isEmpty() && txt_typeWork3.getText().isEmpty() && txt_typeWork4.getText().isEmpty() && txt_typeWork5.getText().isEmpty()
         && txt_loc1.getText().isEmpty() && txt_loc2.getText().isEmpty() && txt_loc3.getText().isEmpty() && txt_loc4.getText().isEmpty() && txt_loc5.getText().isEmpty()
         && txt_capital1.getText().isEmpty() && txt_capital2.getText().isEmpty() && txt_capital3.getText().isEmpty() && txt_capital4.getText().isEmpty() && txt_capital5.getText().isEmpty()){
            lbl_errorOrg.setTextFill(Color.TOMATO);
            lbl_errorOrg.setFont(Font.font ("Verdana", 20));
            lbl_errorOrg.setText("Enter All Values");
            return "error";
        }
        if (txt_fullname1.getText().isEmpty()){
            lbl_errorOrg.setTextFill(Color.TOMATO);
            lbl_errorOrg.setFont(Font.font ("Verdana", 20));
            lbl_errorOrg.setText("Enter First Full Name");
            txt_fullname1.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_typeWork1.getText().isEmpty()){
            lbl_errorOrg.setTextFill(Color.TOMATO);
            lbl_errorOrg.setFont(Font.font ("Verdana", 20));
            lbl_errorOrg.setText("Enter First Type Of Work");
            txt_typeWork1.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_loc1.getText().isEmpty()){
            lbl_errorOrg.setTextFill(Color.TOMATO);
            lbl_errorOrg.setFont(Font.font ("Verdana", 20));
            lbl_errorOrg.setText("Enter First Working Location");
            txt_loc1.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_capital1.getText().isEmpty()){
            lbl_errorOrg.setTextFill(Color.TOMATO);
            lbl_errorOrg.setFont(Font.font ("Verdana", 20));
            lbl_errorOrg.setText("Enter First Capital");
            txt_capital1.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_fullname2.getText().isEmpty()){
            lbl_errorOrg.setTextFill(Color.TOMATO);
            lbl_errorOrg.setFont(Font.font ("Verdana", 20));
            lbl_errorOrg.setText("Enter Second Full Name");
            txt_fullname2.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_typeWork2.getText().isEmpty()){
            lbl_errorOrg.setTextFill(Color.TOMATO);
            lbl_errorOrg.setFont(Font.font ("Verdana", 20));
            lbl_errorOrg.setText("Enter Second Type Of Work");
            txt_typeWork2.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_loc2.getText().isEmpty()){
            lbl_errorOrg.setTextFill(Color.TOMATO);
            lbl_errorOrg.setFont(Font.font ("Verdana", 20));
            lbl_errorOrg.setText("Enter Second Working Location");
            txt_loc2.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_capital2.getText().isEmpty()){
            lbl_errorOrg.setTextFill(Color.TOMATO);
            lbl_errorOrg.setFont(Font.font ("Verdana", 20));
            lbl_errorOrg.setText("Enter Second Capital");
            txt_capital2.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_fullname3.getText().isEmpty()){
            lbl_errorOrg.setTextFill(Color.TOMATO);
            lbl_errorOrg.setFont(Font.font ("Verdana", 20));
            lbl_errorOrg.setText("Enter Third Full Name");
            txt_fullname3.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_typeWork3.getText().isEmpty()){
            lbl_errorOrg.setTextFill(Color.TOMATO);
            lbl_errorOrg.setFont(Font.font ("Verdana", 20));
            lbl_errorOrg.setText("Enter Third Work Type");
            txt_typeWork3.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_loc3.getText().isEmpty()){
            lbl_errorOrg.setTextFill(Color.TOMATO);
            lbl_errorOrg.setFont(Font.font ("Verdana", 20));
            lbl_errorOrg.setText("Enter Third Working Location");
            txt_loc3.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_capital3.getText().isEmpty()){
            lbl_errorOrg.setTextFill(Color.TOMATO);
            lbl_errorOrg.setFont(Font.font ("Verdana", 20));
            lbl_errorOrg.setText("Enter Third Capital");
            txt_capital3.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_fullname4.getText().isEmpty()){
            lbl_errorOrg.setTextFill(Color.TOMATO);
            lbl_errorOrg.setFont(Font.font ("Verdana", 20));
            lbl_errorOrg.setText("Enter Fourth Full Name");
            txt_fullname4.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_typeWork4.getText().isEmpty()){
            lbl_errorOrg.setTextFill(Color.TOMATO);
            lbl_errorOrg.setFont(Font.font ("Verdana", 20));
            lbl_errorOrg.setText("Enter Fourth Type Of Work");
            txt_typeWork4.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_loc4.getText().isEmpty()){
            lbl_errorOrg.setTextFill(Color.TOMATO);
            lbl_errorOrg.setFont(Font.font ("Verdana", 20));
            lbl_errorOrg.setText("Enter Fourth Working Location");
            txt_loc4.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_capital4.getText().isEmpty()){
            lbl_errorOrg.setTextFill(Color.TOMATO);
            lbl_errorOrg.setFont(Font.font ("Verdana", 20));
            lbl_errorOrg.setText("Enter Fourth Capital");
            txt_capital4.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_fullname5.getText().isEmpty()){
            lbl_errorOrg.setTextFill(Color.TOMATO);
            lbl_errorOrg.setFont(Font.font ("Verdana", 20));
            lbl_errorOrg.setText("Enter Fifth Full Name");
            txt_fullname5.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_typeWork5.getText().isEmpty()){
            lbl_errorOrg.setTextFill(Color.TOMATO);
            lbl_errorOrg.setFont(Font.font ("Verdana", 20));
            lbl_errorOrg.setText("Enter Fifth Type Of Work");
            txt_typeWork5.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_loc5.getText().isEmpty()){
            lbl_errorOrg.setTextFill(Color.TOMATO);
            lbl_errorOrg.setFont(Font.font ("Verdana", 20));
            lbl_errorOrg.setText("Enter Fifth Working Location");
            txt_loc5.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        if (txt_capital5.getText().isEmpty()){
            lbl_errorOrg.setTextFill(Color.TOMATO);
            lbl_errorOrg.setFont(Font.font ("Verdana", 20));
            lbl_errorOrg.setText("Enter Fifth Capital");
            txt_capital5.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
        return "success";
    }
    ///Marrage Certeficate
     public String validMarrage(){
        if (txt_hasbund.getText().isEmpty() && txt_wife.getText().isEmpty() && txt_month.getText().isEmpty() && txt_day.getText().isEmpty()
                && txt_year.getText().isEmpty()&& txt_by.getText().isEmpty() && txt_at.getText().isEmpty() && txt_witness1.getText().isEmpty()
                && txt_witness2.getText().isEmpty()){
            lbl_errorMarriage.setTextFill(Color.TOMATO);
            lbl_errorMarriage.setFont(Font.font ("Verdana", 20));
            lbl_errorMarriage.setText("Enter All Values");
            return "error";
        }
        if (txt_hasbund.getText().isEmpty()){
            lbl_errorMarriage.setTextFill(Color.TOMATO);
            lbl_errorMarriage.setFont(Font.font ("Verdana", 20));
            lbl_errorMarriage.setText("Enter Name Of Husband");
            txt_hasbund.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
            return "error";
        }
         if (txt_wife.getText().isEmpty()){
             lbl_errorMarriage.setTextFill(Color.TOMATO);
             lbl_errorMarriage.setFont(Font.font ("Verdana", 20));
             lbl_errorMarriage.setText("Enter Name Of Wife");
             txt_wife.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
             return "error";
         }
         if (txt_month.getText().isEmpty()){
             lbl_errorMarriage.setTextFill(Color.TOMATO);
             lbl_errorMarriage.setFont(Font.font ("Verdana", 20));
             lbl_errorMarriage.setText("Enter the Month");
             txt_month.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
             return "error";
         }
         if (txt_day.getText().isEmpty()){
             lbl_errorMarriage.setTextFill(Color.TOMATO);
             lbl_errorMarriage.setFont(Font.font ("Verdana", 20));
             lbl_errorMarriage.setText("Enter the day");
             txt_day.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
             return "error";
         }
         if (txt_year.getText().isEmpty()){
             lbl_errorMarriage.setTextFill(Color.TOMATO);
             lbl_errorMarriage.setFont(Font.font ("Verdana", 20));
             lbl_errorMarriage.setText("Enter the year");
             txt_year.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
             return "error";
         }
         if (txt_by.getText().isEmpty()){
             lbl_errorMarriage.setTextFill(Color.TOMATO);
             lbl_errorMarriage.setFont(Font.font ("Verdana", 20));
             lbl_errorMarriage.setText("Enter Name OF Assigner");
             txt_by.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
             return "error";
         }
         if (txt_at.getText().isEmpty()){
             lbl_errorMarriage.setTextFill(Color.TOMATO);
             lbl_errorMarriage.setFont(Font.font ("Verdana", 20));
             lbl_errorMarriage.setText("Enter The Location");
             txt_at.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
             return "error";
         }
         if (txt_witness1.getText().isEmpty()){
             lbl_errorMarriage.setTextFill(Color.TOMATO);
             lbl_errorMarriage.setFont(Font.font ("Verdana", 20));
             lbl_errorMarriage.setText("Enter The first Witness");
             txt_witness1.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
             return "error";
         }
         if (txt_witness2.getText().isEmpty()){
             lbl_errorMarriage.setTextFill(Color.TOMATO);
             lbl_errorMarriage.setFont(Font.font ("Verdana", 20));
             lbl_errorMarriage.setText("Enter The Second Witness");
             txt_witness2.setStyle("-fx-border-color: red;"+"-fx-background-color: transparent;"+"-fx-border-width: 0px 0px 2px 0px");
             return "error";
         }
         return "success";
     }
     ////children status
     public void getNumber (ActionEvent event){
        String myNumber =  choiceB_Nchild.getValue();
        switch (myNumber){
            case "0":
                break;
            case "1" :
                txt_fN1.setVisible(true);
                mRdo1.setVisible(true);
                fRdo1.setVisible(true);
                txt_Age1.setVisible(true);
                txt_car1.setVisible(true);
                sRdo1.setVisible(true);
                marrRdo1.setVisible(true);
                break;
            case "2":
                txt_fN1.setVisible(true);
                mRdo1.setVisible(true);
                fRdo1.setVisible(true);
                txt_Age1.setVisible(true);
                txt_car1.setVisible(true);
                sRdo1.setVisible(true);
                marrRdo1.setVisible(true);

                txt_fN2.setVisible(true);
                mRdo2.setVisible(true);
                fRdo2.setVisible(true);
                txt_Age2.setVisible(true);
                txt_car2.setVisible(true);
                sRdo2.setVisible(true);
                marrRdo2.setVisible(true);
                break;
            case "3":
                txt_fN1.setVisible(true);
                mRdo1.setVisible(true);
                fRdo1.setVisible(true);
                txt_Age1.setVisible(true);
                txt_car1.setVisible(true);
                sRdo1.setVisible(true);
                marrRdo1.setVisible(true);

                txt_fN2.setVisible(true);
                mRdo2.setVisible(true);
                fRdo2.setVisible(true);
                txt_Age2.setVisible(true);
                txt_car2.setVisible(true);
                sRdo2.setVisible(true);
                marrRdo2.setVisible(true);

                txt_fN3.setVisible(true);
                mRdo3.setVisible(true);
                fRdo3.setVisible(true);
                txt_Age3.setVisible(true);
                txt_car3.setVisible(true);
                sRdo3.setVisible(true);
                marrRdo3.setVisible(true);
                break;
            case "4":
                txt_fN1.setVisible(true);
                mRdo1.setVisible(true);
                fRdo1.setVisible(true);
                txt_Age1.setVisible(true);
                txt_car1.setVisible(true);
                sRdo1.setVisible(true);
                marrRdo1.setVisible(true);

                txt_fN2.setVisible(true);
                mRdo2.setVisible(true);
                fRdo2.setVisible(true);
                txt_Age2.setVisible(true);
                txt_car2.setVisible(true);
                sRdo2.setVisible(true);
                marrRdo2.setVisible(true);

                txt_fN3.setVisible(true);
                mRdo3.setVisible(true);
                fRdo3.setVisible(true);
                txt_Age3.setVisible(true);
                txt_car3.setVisible(true);
                sRdo3.setVisible(true);
                marrRdo3.setVisible(true);

                txt_fN4.setVisible(true);
                mRdo4.setVisible(true);
                fRdo4.setVisible(true);
                txt_Age4.setVisible(true);
                txt_car4.setVisible(true);
                sRdo4.setVisible(true);
                marrRdo4.setVisible(true);
                break;
            case "5":
                txt_fN1.setVisible(true);
                mRdo1.setVisible(true);
                fRdo1.setVisible(true);
                txt_Age1.setVisible(true);
                txt_car1.setVisible(true);
                sRdo1.setVisible(true);
                marrRdo1.setVisible(true);

                txt_fN2.setVisible(true);
                mRdo2.setVisible(true);
                fRdo2.setVisible(true);
                txt_Age2.setVisible(true);
                txt_car2.setVisible(true);
                sRdo2.setVisible(true);
                marrRdo2.setVisible(true);

                txt_fN3.setVisible(true);
                mRdo3.setVisible(true);
                fRdo3.setVisible(true);
                txt_Age3.setVisible(true);
                txt_car3.setVisible(true);
                sRdo3.setVisible(true);
                marrRdo3.setVisible(true);

                txt_fN4.setVisible(true);
                mRdo4.setVisible(true);
                fRdo4.setVisible(true);
                txt_Age4.setVisible(true);
                txt_car4.setVisible(true);
                sRdo4.setVisible(true);
                marrRdo4.setVisible(true);

                txt_fN5.setVisible(true);
                mRdo5.setVisible(true);
                fRdo5.setVisible(true);
                txt_Age5.setVisible(true);
                txt_car5.setVisible(true);
                sRdo5.setVisible(true);
                marrRdo5.setVisible(true);
                break;
            case "6":
                txt_fN1.setVisible(true);
                mRdo1.setVisible(true);
                fRdo1.setVisible(true);
                txt_Age1.setVisible(true);
                txt_car1.setVisible(true);
                sRdo1.setVisible(true);
                marrRdo1.setVisible(true);

                txt_fN2.setVisible(true);
                mRdo2.setVisible(true);
                fRdo2.setVisible(true);
                txt_Age2.setVisible(true);
                txt_car2.setVisible(true);
                sRdo2.setVisible(true);
                marrRdo2.setVisible(true);

                txt_fN3.setVisible(true);
                mRdo3.setVisible(true);
                fRdo3.setVisible(true);
                txt_Age3.setVisible(true);
                txt_car3.setVisible(true);
                sRdo3.setVisible(true);
                marrRdo3.setVisible(true);

                txt_fN4.setVisible(true);
                mRdo4.setVisible(true);
                fRdo4.setVisible(true);
                txt_Age4.setVisible(true);
                txt_car4.setVisible(true);
                sRdo4.setVisible(true);
                marrRdo4.setVisible(true);

                txt_fN5.setVisible(true);
                mRdo5.setVisible(true);
                fRdo5.setVisible(true);
                txt_Age5.setVisible(true);
                txt_car5.setVisible(true);
                sRdo5.setVisible(true);
                marrRdo5.setVisible(true);

                txt_fN6.setVisible(true);
                mRdo6.setVisible(true);
                fRdo6.setVisible(true);
                txt_Age6.setVisible(true);
                txt_car6.setVisible(true);
                sRdo6.setVisible(true);
                marrRdo6.setVisible(true);
                break;
            case "7":
                txt_fN1.setVisible(true);
                mRdo1.setVisible(true);
                fRdo1.setVisible(true);
                txt_Age1.setVisible(true);
                txt_car1.setVisible(true);
                sRdo1.setVisible(true);
                marrRdo1.setVisible(true);

                txt_fN2.setVisible(true);
                mRdo2.setVisible(true);
                fRdo2.setVisible(true);
                txt_Age2.setVisible(true);
                txt_car2.setVisible(true);
                sRdo2.setVisible(true);
                marrRdo2.setVisible(true);

                txt_fN3.setVisible(true);
                mRdo3.setVisible(true);
                fRdo3.setVisible(true);
                txt_Age3.setVisible(true);
                txt_car3.setVisible(true);
                sRdo3.setVisible(true);
                marrRdo3.setVisible(true);

                txt_fN4.setVisible(true);
                mRdo4.setVisible(true);
                fRdo4.setVisible(true);
                txt_Age4.setVisible(true);
                txt_car4.setVisible(true);
                sRdo4.setVisible(true);
                marrRdo4.setVisible(true);

                txt_fN5.setVisible(true);
                mRdo5.setVisible(true);
                fRdo5.setVisible(true);
                txt_Age5.setVisible(true);
                txt_car5.setVisible(true);
                sRdo5.setVisible(true);
                marrRdo5.setVisible(true);

                txt_fN6.setVisible(true);
                mRdo6.setVisible(true);
                fRdo6.setVisible(true);
                txt_Age6.setVisible(true);
                txt_car6.setVisible(true);
                sRdo6.setVisible(true);
                marrRdo6.setVisible(true);

                txt_fN7.setVisible(true);
                mRdo7.setVisible(true);
                fRdo7.setVisible(true);
                txt_Age7.setVisible(true);
                txt_car7.setVisible(true);
                sRdo7.setVisible(true);
                marrRdo7.setVisible(true);
                break;
            case "8":
                txt_fN1.setVisible(true);
                mRdo1.setVisible(true);
                fRdo1.setVisible(true);
                txt_Age1.setVisible(true);
                txt_car1.setVisible(true);
                sRdo1.setVisible(true);
                marrRdo1.setVisible(true);

                txt_fN2.setVisible(true);
                mRdo2.setVisible(true);
                fRdo2.setVisible(true);
                txt_Age2.setVisible(true);
                txt_car2.setVisible(true);
                sRdo2.setVisible(true);
                marrRdo2.setVisible(true);

                txt_fN3.setVisible(true);
                mRdo3.setVisible(true);
                fRdo3.setVisible(true);
                txt_Age3.setVisible(true);
                txt_car3.setVisible(true);
                sRdo3.setVisible(true);
                marrRdo3.setVisible(true);

                txt_fN4.setVisible(true);
                mRdo4.setVisible(true);
                fRdo4.setVisible(true);
                txt_Age4.setVisible(true);
                txt_car4.setVisible(true);
                sRdo4.setVisible(true);
                marrRdo4.setVisible(true);

                txt_fN5.setVisible(true);
                mRdo5.setVisible(true);
                fRdo5.setVisible(true);
                txt_Age5.setVisible(true);
                txt_car5.setVisible(true);
                sRdo5.setVisible(true);
                marrRdo5.setVisible(true);

                txt_fN6.setVisible(true);
                mRdo6.setVisible(true);
                fRdo6.setVisible(true);
                txt_Age6.setVisible(true);
                txt_car6.setVisible(true);
                sRdo6.setVisible(true);
                marrRdo6.setVisible(true);

                txt_fN7.setVisible(true);
                mRdo7.setVisible(true);
                fRdo7.setVisible(true);
                txt_Age7.setVisible(true);
                txt_car7.setVisible(true);
                sRdo7.setVisible(true);
                marrRdo7.setVisible(true);

                txt_fN8.setVisible(true);
                mRdo8.setVisible(true);
                fRdo8.setVisible(true);
                txt_Age8.setVisible(true);
                txt_car8.setVisible(true);
                sRdo8.setVisible(true);
                marrRdo8.setVisible(true);
                break;
            case "9":
                txt_fN1.setVisible(true);
                mRdo1.setVisible(true);
                fRdo1.setVisible(true);
                txt_Age1.setVisible(true);
                txt_car1.setVisible(true);
                sRdo1.setVisible(true);
                marrRdo1.setVisible(true);

                txt_fN2.setVisible(true);
                mRdo2.setVisible(true);
                fRdo2.setVisible(true);
                txt_Age2.setVisible(true);
                txt_car2.setVisible(true);
                sRdo2.setVisible(true);
                marrRdo2.setVisible(true);

                txt_fN3.setVisible(true);
                mRdo3.setVisible(true);
                fRdo3.setVisible(true);
                txt_Age3.setVisible(true);
                txt_car3.setVisible(true);
                sRdo3.setVisible(true);
                marrRdo3.setVisible(true);

                txt_fN4.setVisible(true);
                mRdo4.setVisible(true);
                fRdo4.setVisible(true);
                txt_Age4.setVisible(true);
                txt_car4.setVisible(true);
                sRdo4.setVisible(true);
                marrRdo4.setVisible(true);

                txt_fN5.setVisible(true);
                mRdo5.setVisible(true);
                fRdo5.setVisible(true);
                txt_Age5.setVisible(true);
                txt_car5.setVisible(true);
                sRdo5.setVisible(true);
                marrRdo5.setVisible(true);

                txt_fN6.setVisible(true);
                mRdo6.setVisible(true);
                fRdo6.setVisible(true);
                txt_Age6.setVisible(true);
                txt_car6.setVisible(true);
                sRdo6.setVisible(true);
                marrRdo6.setVisible(true);

                txt_fN7.setVisible(true);
                mRdo7.setVisible(true);
                fRdo7.setVisible(true);
                txt_Age7.setVisible(true);
                txt_car7.setVisible(true);
                sRdo7.setVisible(true);
                marrRdo7.setVisible(true);

                txt_fN8.setVisible(true);
                mRdo8.setVisible(true);
                fRdo8.setVisible(true);
                txt_Age8.setVisible(true);
                txt_car8.setVisible(true);
                sRdo8.setVisible(true);
                marrRdo8.setVisible(true);

                txt_fN9.setVisible(true);
                mRdo9.setVisible(true);
                fRdo9.setVisible(true);
                txt_Age9.setVisible(true);
                txt_car9.setVisible(true);
                sRdo9.setVisible(true);
                marrRdo9.setVisible(true);
                break;
            case "10":
                txt_fN1.setVisible(true);
                mRdo1.setVisible(true);
                fRdo1.setVisible(true);
                txt_Age1.setVisible(true);
                txt_car1.setVisible(true);
                sRdo1.setVisible(true);
                marrRdo1.setVisible(true);

                txt_fN2.setVisible(true);
                mRdo2.setVisible(true);
                fRdo2.setVisible(true);
                txt_Age2.setVisible(true);
                txt_car2.setVisible(true);
                sRdo2.setVisible(true);
                marrRdo2.setVisible(true);

                txt_fN3.setVisible(true);
                mRdo3.setVisible(true);
                fRdo3.setVisible(true);
                txt_Age3.setVisible(true);
                txt_car3.setVisible(true);
                sRdo3.setVisible(true);
                marrRdo3.setVisible(true);

                txt_fN4.setVisible(true);
                mRdo4.setVisible(true);
                fRdo4.setVisible(true);
                txt_Age4.setVisible(true);
                txt_car4.setVisible(true);
                sRdo4.setVisible(true);
                marrRdo4.setVisible(true);

                txt_fN5.setVisible(true);
                mRdo5.setVisible(true);
                fRdo5.setVisible(true);
                txt_Age5.setVisible(true);
                txt_car5.setVisible(true);
                sRdo5.setVisible(true);
                marrRdo5.setVisible(true);

                txt_fN6.setVisible(true);
                mRdo6.setVisible(true);
                fRdo6.setVisible(true);
                txt_Age6.setVisible(true);
                txt_car6.setVisible(true);
                sRdo6.setVisible(true);
                marrRdo6.setVisible(true);

                txt_fN7.setVisible(true);
                mRdo7.setVisible(true);
                fRdo7.setVisible(true);
                txt_Age7.setVisible(true);
                txt_car7.setVisible(true);
                sRdo7.setVisible(true);
                marrRdo7.setVisible(true);

                txt_fN8.setVisible(true);
                mRdo8.setVisible(true);
                fRdo8.setVisible(true);
                txt_Age8.setVisible(true);
                txt_car8.setVisible(true);
                sRdo8.setVisible(true);
                marrRdo8.setVisible(true);

                txt_fN9.setVisible(true);
                mRdo9.setVisible(true);
                fRdo9.setVisible(true);
                txt_Age9.setVisible(true);
                txt_car9.setVisible(true);
                sRdo9.setVisible(true);
                marrRdo9.setVisible(true);

                txt_fN10.setVisible(true);
                mRdo10.setVisible(true);
                fRdo10.setVisible(true);
                txt_Age10.setVisible(true);
                txt_car10.setVisible(true);
                sRdo10.setVisible(true);
                marrRdo10.setVisible(true);
                break;
        }

     }
     public void  getnumbers(ActionEvent event){
         String values =  choiceBHouseChilde.getValue();
         switch (values){
             case "0" :
                 break;
             case "1" :
                 txt_HName1.setVisible(true);
                 rdoHmale1.setVisible(true);
                 rdoHfemal1.setVisible(true);
                 rdoHAge1.setVisible(true);
                 break;
             case "2" :
                 txt_HName1.setVisible(true);
                 rdoHmale1.setVisible(true);
                 rdoHfemal1.setVisible(true);
                 rdoHAge1.setVisible(true);

                 txt_HName2.setVisible(true);
                 rdoHmale2.setVisible(true);
                 rdoHfemal2.setVisible(true);
                 rdoHAge2.setVisible(true);
                 break;
             case "3" :
                 txt_HName1.setVisible(true);
                 rdoHmale1.setVisible(true);
                 rdoHfemal1.setVisible(true);
                 rdoHAge1.setVisible(true);

                 txt_HName2.setVisible(true);
                 rdoHmale2.setVisible(true);
                 rdoHfemal2.setVisible(true);
                 rdoHAge2.setVisible(true);

                 txt_HName3.setVisible(true);
                 rdoHmale3.setVisible(true);
                 rdoHfemal3.setVisible(true);
                 rdoHAge3.setVisible(true);
                 break;
             case "4" :
                 txt_HName1.setVisible(true);
                 rdoHmale1.setVisible(true);
                 rdoHfemal1.setVisible(true);
                 rdoHAge1.setVisible(true);

                 txt_HName2.setVisible(true);
                 rdoHmale2.setVisible(true);
                 rdoHfemal2.setVisible(true);
                 rdoHAge2.setVisible(true);

                 txt_HName3.setVisible(true);
                 rdoHmale3.setVisible(true);
                 rdoHfemal3.setVisible(true);
                 rdoHAge3.setVisible(true);

                 txt_HName4.setVisible(true);
                 rdoHmale4.setVisible(true);
                 rdoHfemal4.setVisible(true);
                 rdoHAge4.setVisible(true);
                 break;
             case "5" :
                 txt_HName1.setVisible(true);
                 rdoHmale1.setVisible(true);
                 rdoHfemal1.setVisible(true);
                 rdoHAge1.setVisible(true);

                 txt_HName2.setVisible(true);
                 rdoHmale2.setVisible(true);
                 rdoHfemal2.setVisible(true);
                 rdoHAge2.setVisible(true);

                 txt_HName3.setVisible(true);
                 rdoHmale3.setVisible(true);
                 rdoHfemal3.setVisible(true);
                 rdoHAge3.setVisible(true);

                 txt_HName4.setVisible(true);
                 rdoHmale4.setVisible(true);
                 rdoHfemal4.setVisible(true);
                 rdoHAge4.setVisible(true);

                 txt_HName5.setVisible(true);
                 rdoHmale5.setVisible(true);
                 rdoHfemal5.setVisible(true);
                 rdoHAge5.setVisible(true);
                 break;
             case "6" :
                 txt_HName1.setVisible(true);
                 rdoHmale1.setVisible(true);
                 rdoHfemal1.setVisible(true);
                 rdoHAge1.setVisible(true);

                 txt_HName2.setVisible(true);
                 rdoHmale2.setVisible(true);
                 rdoHfemal2.setVisible(true);
                 rdoHAge2.setVisible(true);

                 txt_HName3.setVisible(true);
                 rdoHmale3.setVisible(true);
                 rdoHfemal3.setVisible(true);
                 rdoHAge3.setVisible(true);

                 txt_HName4.setVisible(true);
                 rdoHmale4.setVisible(true);
                 rdoHfemal4.setVisible(true);
                 rdoHAge4.setVisible(true);

                 txt_HName5.setVisible(true);
                 rdoHmale5.setVisible(true);
                 rdoHfemal5.setVisible(true);
                 rdoHAge5.setVisible(true);

                 txt_HName6.setVisible(true);
                 rdoHmale6.setVisible(true);
                 rdoHfemal6.setVisible(true);
                 rdoHAge6.setVisible(true);
                 break;
             case "7" :
                 txt_HName1.setVisible(true);
                 rdoHmale1.setVisible(true);
                 rdoHfemal1.setVisible(true);
                 rdoHAge1.setVisible(true);

                 txt_HName2.setVisible(true);
                 rdoHmale2.setVisible(true);
                 rdoHfemal2.setVisible(true);
                 rdoHAge2.setVisible(true);

                 txt_HName3.setVisible(true);
                 rdoHmale3.setVisible(true);
                 rdoHfemal3.setVisible(true);
                 rdoHAge3.setVisible(true);

                 txt_HName4.setVisible(true);
                 rdoHmale4.setVisible(true);
                 rdoHfemal4.setVisible(true);
                 rdoHAge4.setVisible(true);

                 txt_HName5.setVisible(true);
                 rdoHmale5.setVisible(true);
                 rdoHfemal5.setVisible(true);
                 rdoHAge5.setVisible(true);

                 txt_HName6.setVisible(true);
                 rdoHmale6.setVisible(true);
                 rdoHfemal6.setVisible(true);
                 rdoHAge6.setVisible(true);

                 txt_HName7.setVisible(true);
                 rdoHmale7.setVisible(true);
                 rdoHfemal7.setVisible(true);
                 rdoHAge7.setVisible(true);
                 break;
             case "8" :
                 txt_HName1.setVisible(true);
                 rdoHmale1.setVisible(true);
                 rdoHfemal1.setVisible(true);
                 rdoHAge1.setVisible(true);

                 txt_HName2.setVisible(true);
                 rdoHmale2.setVisible(true);
                 rdoHfemal2.setVisible(true);
                 rdoHAge2.setVisible(true);

                 txt_HName3.setVisible(true);
                 rdoHmale3.setVisible(true);
                 rdoHfemal3.setVisible(true);
                 rdoHAge3.setVisible(true);

                 txt_HName4.setVisible(true);
                 rdoHmale4.setVisible(true);
                 rdoHfemal4.setVisible(true);
                 rdoHAge4.setVisible(true);

                 txt_HName5.setVisible(true);
                 rdoHmale5.setVisible(true);
                 rdoHfemal5.setVisible(true);
                 rdoHAge5.setVisible(true);

                 txt_HName6.setVisible(true);
                 rdoHmale6.setVisible(true);
                 rdoHfemal6.setVisible(true);
                 rdoHAge6.setVisible(true);

                 txt_HName7.setVisible(true);
                 rdoHmale7.setVisible(true);
                 rdoHfemal7.setVisible(true);
                 rdoHAge7.setVisible(true);

                 txt_HName8.setVisible(true);
                 rdoHmale8.setVisible(true);
                 rdoHfemal8.setVisible(true);
                 rdoHAge8.setVisible(true);

                 break;
             case "9" :
                 txt_HName1.setVisible(true);
                 rdoHmale1.setVisible(true);
                 rdoHfemal1.setVisible(true);
                 rdoHAge1.setVisible(true);

                 txt_HName2.setVisible(true);
                 rdoHmale2.setVisible(true);
                 rdoHfemal2.setVisible(true);
                 rdoHAge2.setVisible(true);

                 txt_HName3.setVisible(true);
                 rdoHmale3.setVisible(true);
                 rdoHfemal3.setVisible(true);
                 rdoHAge3.setVisible(true);

                 txt_HName4.setVisible(true);
                 rdoHmale4.setVisible(true);
                 rdoHfemal4.setVisible(true);
                 rdoHAge4.setVisible(true);

                 txt_HName5.setVisible(true);
                 rdoHmale5.setVisible(true);
                 rdoHfemal5.setVisible(true);
                 rdoHAge5.setVisible(true);

                 txt_HName6.setVisible(true);
                 rdoHmale6.setVisible(true);
                 rdoHfemal6.setVisible(true);
                 rdoHAge6.setVisible(true);

                 txt_HName7.setVisible(true);
                 rdoHmale7.setVisible(true);
                 rdoHfemal7.setVisible(true);
                 rdoHAge7.setVisible(true);

                 txt_HName8.setVisible(true);
                 rdoHmale8.setVisible(true);
                 rdoHfemal8.setVisible(true);
                 rdoHAge8.setVisible(true);

                 txt_HName9.setVisible(true);
                 rdoHmale9.setVisible(true);
                 rdoHfemal9.setVisible(true);
                 rdoHAge9.setVisible(true);
                 break;
             case "10" :
                 txt_HName1.setVisible(true);
                 rdoHmale1.setVisible(true);
                 rdoHfemal1.setVisible(true);
                 rdoHAge1.setVisible(true);

                 txt_HName2.setVisible(true);
                 rdoHmale2.setVisible(true);
                 rdoHfemal2.setVisible(true);
                 rdoHAge2.setVisible(true);

                 txt_HName3.setVisible(true);
                 rdoHmale3.setVisible(true);
                 rdoHfemal3.setVisible(true);
                 rdoHAge3.setVisible(true);

                 txt_HName4.setVisible(true);
                 rdoHmale4.setVisible(true);
                 rdoHfemal4.setVisible(true);
                 rdoHAge4.setVisible(true);

                 txt_HName5.setVisible(true);
                 rdoHmale5.setVisible(true);
                 rdoHfemal5.setVisible(true);
                 rdoHAge5.setVisible(true);

                 txt_HName6.setVisible(true);
                 rdoHmale6.setVisible(true);
                 rdoHfemal6.setVisible(true);
                 rdoHAge6.setVisible(true);

                 txt_HName7.setVisible(true);
                 rdoHmale7.setVisible(true);
                 rdoHfemal7.setVisible(true);
                 rdoHAge7.setVisible(true);

                 txt_HName8.setVisible(true);
                 rdoHmale8.setVisible(true);
                 rdoHfemal8.setVisible(true);
                 rdoHAge8.setVisible(true);

                 txt_HName9.setVisible(true);
                 rdoHmale9.setVisible(true);
                 rdoHfemal9.setVisible(true);
                 rdoHAge9.setVisible(true);

                 txt_HName10.setVisible(true);
                 rdoHmale10.setVisible(true);
                 rdoHfemal10.setVisible(true);
                 rdoHAge10.setVisible(true);
                 break;
         }
     }
                ///Access File
           ///Organization Unemployed
     public void cellSetTable() {
        //Organization
        col_orgFullName.setCellValueFactory(new PropertyValueFactory<>("FullName"));
        col_orgWorkingLocation.setCellValueFactory(new PropertyValueFactory<>("WorkingLocation"));
        col_orgTypeOfWork.setCellValueFactory(new PropertyValueFactory<>("TypeOfWork"));
        col_orgAmountofcapital.setCellValueFactory(new PropertyValueFactory<>("AmountOfCapital"));
        //BirthCertificate
         col_Bchildname.setCellValueFactory(new PropertyValueFactory<>("ChildName"));
         col_Bfathername.setCellValueFactory(new PropertyValueFactory<>("fathername"));
         col_Bgrandfname.setCellValueFactory(new PropertyValueFactory<>("grandfather"));
         col_Bgender.setCellValueFactory(new PropertyValueFactory<>("gender"));
         col_Bbirthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
         col_Bbirthplace.setCellValueFactory(new PropertyValueFactory<>("birthplace"));
         col_Bnationality.setCellValueFactory(new PropertyValueFactory<>("nationality"));
         col_Bmotherfullname.setCellValueFactory(new PropertyValueFactory<>("motherfullname"));
         col_Bmothernationality.setCellValueFactory(new PropertyValueFactory<>("mothernationality"));
         col_Bfatherfullname.setCellValueFactory(new PropertyValueFactory<>("fatherfullname"));
         col_BfatherNationality.setCellValueFactory(new PropertyValueFactory<>("fathernationality"));
         col_Bbdayregnum.setCellValueFactory(new PropertyValueFactory<>("birthdayregestor"));
         col_Bdayfilenum.setCellValueFactory(new PropertyValueFactory<>("birthdayfileformnumber"));
         col_BCerteficate.setCellValueFactory(new PropertyValueFactory<>("certificategiven"));
         col_BdayregsterUnique.setCellValueFactory(new PropertyValueFactory<>("birthdayregisteruniqenumber"));
        //Marraiage Certeficate
         col_Mhusbund.setCellValueFactory(new PropertyValueFactory<>("husbandname"));
         col_Mwifename.setCellValueFactory(new PropertyValueFactory<>("wifename"));
         col_Mmonth.setCellValueFactory(new PropertyValueFactory<>("date"));
         col_Mday.setCellValueFactory(new PropertyValueFactory<>("day"));
         col_Myear.setCellValueFactory(new PropertyValueFactory<>("year"));
         col_Massigner.setCellValueFactory(new PropertyValueFactory<>("assigner"));
         col_Mplace.setCellValueFactory(new PropertyValueFactory<>("place"));
         col_Mfirstwitness.setCellValueFactory(new PropertyValueFactory<>("firstwitness"));
         col_Msecondwitness.setCellValueFactory(new PropertyValueFactory<>("secondwitness"));
         //Identification card
         col_IDresident.setCellValueFactory(new PropertyValueFactory<>("RegisterNumber"));
         col_IDfirstname.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
         col_IDmiddlename.setCellValueFactory(new PropertyValueFactory<>("MiddleName"));
         col_IDlastname.setCellValueFactory(new PropertyValueFactory<>("LastName"));
         col_IDidnumber.setCellValueFactory(new PropertyValueFactory<>("IdNumber"));
         col_IDdateofbirth.setCellValueFactory(new PropertyValueFactory<>("DateOfBirth"));
         col_IDbloodgroup.setCellValueFactory(new PropertyValueFactory<>("BloodGroup"));
         col_IDsex.setCellValueFactory(new PropertyValueFactory<>("sex"));
         col_IDissuedate.setCellValueFactory(new PropertyValueFactory<>("IssueDate"));
         col_IDexpiredate .setCellValueFactory(new PropertyValueFactory<>("ExpireDate"));
         col_IDressidentadress.setCellValueFactory(new PropertyValueFactory<>("ResidentAdress"));
         col_IDphonenumber.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
         col_IDhousenumber .setCellValueFactory(new PropertyValueFactory<>("HouseNumber"));
         col_IDemgfirst.setCellValueFactory(new PropertyValueFactory<>("EmgFirstName"));
         col_IDemgmiddle.setCellValueFactory(new PropertyValueFactory<>("EmgMiddleName"));
         col_IDemglast.setCellValueFactory(new PropertyValueFactory<>("EmgLastName"));
         col_IDemgnum.setCellValueFactory(new PropertyValueFactory<>("EmgPhoneNumber"));
         //unemployed
         col_Ufirstname.setCellValueFactory(new PropertyValueFactory<>("Unfirstname"));
         col_Umiddlename.setCellValueFactory(new PropertyValueFactory<>("Unmiddlename"));
         col_Ulastname.setCellValueFactory(new PropertyValueFactory<>("Unlastname"));
         col_Usex.setCellValueFactory(new PropertyValueFactory<>("sex"));
         col_Uphonenumber.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
         col_UresidentAddress.setCellValueFactory(new PropertyValueFactory<>("resisdentadress"));
         col_Unationality.setCellValueFactory(new PropertyValueFactory<>("nationality"));
         col_Ubirthplace.setCellValueFactory(new PropertyValueFactory<>("birthplace"));
         col_Ucity.setCellValueFactory(new PropertyValueFactory<>("city"));
         col_Uzone.setCellValueFactory(new PropertyValueFactory<>("zone"));
         col_Uwereda.setCellValueFactory(new PropertyValueFactory<>("wereda"));
         col_Ukebele .setCellValueFactory(new PropertyValueFactory<>("kebele"));
         col_Ulevelofeducation.setCellValueFactory(new PropertyValueFactory<>("levelofeducation"));
         //Kebele House
         col_Kfathername.setCellValueFactory(new PropertyValueFactory<>("FatherFullName"));
         col_Kmothername.setCellValueFactory(new PropertyValueFactory<>("MotherFullName"));
         col_Khousenumber.setCellValueFactory(new PropertyValueFactory<>("HouseNumber"));
         col_Kamonutroom.setCellValueFactory(new PropertyValueFactory<>("AmountRoom"));
         col_Ksurfacearea.setCellValueFactory(new PropertyValueFactory<>("SurfaceArea"));
         col_khouseloc.setCellValueFactory(new PropertyValueFactory<>("HouseLocation"));
         col_Kwindowamonut.setCellValueFactory(new PropertyValueFactory<>("WindowAmount"));
         col_Kwindowtype.setCellValueFactory(new PropertyValueFactory<>("WindowType"));
         col_Kdoortype.setCellValueFactory(new PropertyValueFactory<>("DoorType"));
         col_kebeleHousenumber.setCellValueFactory(new PropertyValueFactory<>("KebeleHouseNumber"));
         col_Kchildname.setCellValueFactory(new PropertyValueFactory<>("childfullname"));
         col_Kchildgender.setCellValueFactory(new PropertyValueFactory<>("childgender"));
         col_Kchildage.setCellValueFactory(new PropertyValueFactory<>("childage"));
         col_Kchildcarrier.setCellValueFactory(new PropertyValueFactory<>("childcarrier"));
         col_Kchildatatus.setCellValueFactory(new PropertyValueFactory<>("Childstatus"));
         //house
         col_HFatherName.setCellValueFactory(new PropertyValueFactory<>("FatherName"));
         col_HMotherName.setCellValueFactory(new PropertyValueFactory<>("MotherName"));
         col_HfilesubmissionDate.setCellValueFactory(new PropertyValueFactory<>("FileSubmissionDate"));
         col_HhousePhoneNumber.setCellValueFactory(new PropertyValueFactory<>("HousePhoneNumber"));
         col_HchildrenName.setCellValueFactory(new PropertyValueFactory<>("ChildName"));
         col_Hgender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
         col_Hage.setCellValueFactory(new PropertyValueFactory<>("Age"));
         col_HhouseNumber.setCellValueFactory(new PropertyValueFactory<>("HouseNumber"));

    }
    public void loadData(){
        try {
            pst = connection.prepareStatement("SELECT * FROM house");
            resultSet = pst.executeQuery();
            while (resultSet.next()){
                HouseObservableList.addAll(new House(resultSet.getString(1),resultSet.getString(2),Integer.parseInt(resultSet.getString(3)),Date.valueOf(resultSet.getString(4)),
                        Integer.parseInt(resultSet.getString(5)),resultSet.getString(6),resultSet.getString(7),Integer.parseInt(resultSet.getString(8))));
            }
            pst = connection.prepareStatement("SELECT FullName, TypeOfWork, WorkingLocation, AmountOfCapital FROM organizing");
            resultSet = pst.executeQuery();
            while (resultSet.next()){
                OrganizeObservableList.addAll(new OrganizationUnemployed(resultSet.getString(1),
                       resultSet.getString(2),resultSet.getString(3),Integer.parseInt(resultSet.getString(4))));
            }
            pst =connection.prepareStatement("SELECT  childname, fathername, grandfname, gender, birthday, birthplace, nationality, motherfullname, mothernationality, fatherfullname, fathernationality, birthdayregestor, birthdayfileformnumber, certificategiven, birthdayregisteruniqenumber FROM birthdaycertificate");
            resultSet = pst.executeQuery();
            while (resultSet.next()){
                BirthCertificateObservableList.addAll(new BirthCerteficate2(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),Date.valueOf(resultSet.getString(5)),
                        resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getString(10),resultSet.getString(11),
                        Date.valueOf(resultSet.getString(12)),Integer.parseInt(resultSet.getString(13)),Date.valueOf(resultSet.getString(14)),Integer.parseInt(resultSet.getString(15))));
            }
            pst =connection.prepareStatement("SELECT husbandname, wifename, date, day, year, assigner, place, firstwitness, secondwitness FROM marriage");
            resultSet = pst.executeQuery();
            while (resultSet.next()){
                MarriageObservableList.addAll(new MarriageCeritificate(resultSet.getString(1),resultSet.getString(2),Integer.parseInt(resultSet.getString(3)),Integer.parseInt(resultSet.getString(4)),
                        Integer.parseInt(resultSet.getString(5)),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9)));
            }
            pst =connection.prepareStatement("SELECT RegisterNumber, FirstName, MiddleName, LastNumber, IdNumber, DateOfBirth, BloodGroup, Sex, IssueDate, ExpireDate, ResidentAdress, PhoneNumber, HouseNumber, EmgFirstName, EmgMiddleName, EmgLastName, EmgPhoneNumber FROM id");
            resultSet = pst.executeQuery();
            while (resultSet.next()){
                IdentificationObservableList.addAll(new IDcard(Integer.parseInt(resultSet.getString(1)),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),Integer.parseInt(resultSet.getString(5)),Date.valueOf(resultSet.getString(6)),
                        resultSet.getString(7),resultSet.getString(8),Date.valueOf(resultSet.getString(9)),Date.valueOf(resultSet.getString(10)),resultSet.getString(11),Integer.parseInt(resultSet.getString(12)),Integer.parseInt(resultSet.getString(13)),resultSet.getString(14),
                        resultSet.getString(15),resultSet.getString(16),Integer.parseInt(resultSet.getString(17))));
            }
            pst=connection.prepareStatement("SELECT firstname, middlename, lastname, sex, phonenumber, resisdentadress, nationality, birthplace, city, zone, wereda,kebele, levelofeducation FROM unimployed");
               resultSet =pst.executeQuery();
               while (resultSet.next()){
                   UnemployedObservableList.addAll(new UnemployedID(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),Integer.parseInt(resultSet.getString(12)),resultSet.getString(6),
                           resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getString(10),Integer.parseInt(resultSet.getString(11)),Integer.parseInt(resultSet.getString(12)),resultSet.getString(13)));
               }
            pst=connection.prepareStatement("SELECT * FROM kebelehouse JOIN childrenstatus ON childrenstatus.kebelehousenumber = kebelehouse.HouseNumber");
            resultSet =pst.executeQuery();
            while (resultSet.next()){
                  KebeleHouseObservableList.addAll(new KebeleHouse(resultSet.getString(1),resultSet.getString(2),Integer.parseInt(resultSet.getString(3)),Integer.parseInt(resultSet.getString(4)),
                          Integer.parseInt(resultSet.getString(5)),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),Integer.parseInt(resultSet.getString(10)),resultSet.getString(11),resultSet.getString(12),Integer.parseInt(resultSet.getString(13))
                          ,resultSet.getString(14),resultSet.getString(15)));
            }
        }catch (Exception e){
            System.out.print(e);
        }
         tabel_organize.setItems(OrganizeObservableList);
         searchresult();
         tabel_BirthCerteficate.setItems(BirthCertificateObservableList);
         searchresult();
         tabel_Marrage.setItems(MarriageObservableList);
         searchresult();
         tabel_Id.setItems(IdentificationObservableList);
         searchresult();
         tabel_unemployed.setItems(UnemployedObservableList);
         searchresult();
         tabel_KebeleHouse.setItems(KebeleHouseObservableList);
         searchresult();
         tabel_House.setItems(HouseObservableList);
         searchresult();
     }
     public void searchresult() {
         try {
             FilteredList<OrganizationUnemployed> filteredList = new FilteredList<>(OrganizeObservableList, b -> true);
             search_Organize.textProperty().addListener((ObservableList, oldvalue, newvalue) -> {
                 filteredList.setPredicate(organizationUnemployed -> {
                     if (newvalue.isEmpty() || newvalue == null) {
                         return true;
                     }
                     String searchkey = newvalue;
                     if (organizationUnemployed.getFullName().indexOf(searchkey) > -1) {
                         return true;
                     } else if (organizationUnemployed.getTypeOfWork().indexOf(searchkey) > -1) {
                         return true;
                     } else if (organizationUnemployed.getWorkingLocation().indexOf(searchkey) > -1) {
                         return true;
                    } else if (organizationUnemployed.getAmountOfCapital().toString().indexOf(searchkey) >-1){
                         return true;
                 }
                     else return false;
                 });
             });
             SortedList<OrganizationUnemployed> sortedListunemployed = new SortedList<>(filteredList);
             sortedListunemployed.comparatorProperty().bind(tabel_organize.comparatorProperty());
             tabel_organize.setItems(sortedListunemployed);

             FilteredList<House> filteredListhouse = new FilteredList<>(HouseObservableList, c -> true);
             search_House.textProperty().addListener((ObservableList, oldvalue, newvalue) -> {
                 filteredListhouse.setPredicate(house -> {
                     if (newvalue.isEmpty() || newvalue == null) {
                         return true;
                     }
                     String seachkey = newvalue;
                     if (house.getFatherName().indexOf(seachkey) > -1) {
                         return true;
                     } else if (house.getMotherName().indexOf(seachkey) > -1) {
                         return true;
                     } else if (house.getHouseNumber().toString().indexOf(seachkey) > -1) {
                         return true;
                     } else if (house.getFileSubmissionDate().toString().indexOf(seachkey) > -1) {
                         return true;
                     } else if (house.getHousePhoneNumber().toString().indexOf(seachkey)>-1) {
                         return true;
                     }else if (house.getChildName().indexOf(seachkey) > -1) {
                         return true;
                     } else if (house.getGender().indexOf(seachkey) > -1) {
                         return true;
                     } else if (house.getAge().toString().indexOf(seachkey) > -1) {
                         return true;
                     } else return false;
                 });
             });
             SortedList<House> sortedListhosue = new SortedList<>(filteredListhouse);
             sortedListhosue.comparatorProperty().bind(tabel_House.comparatorProperty());
             tabel_House.setItems(sortedListhosue);

             FilteredList<BirthCerteficate2> filteredListBirthCerteficate = new FilteredList<>(BirthCertificateObservableList, c -> true);
             searchBirth.textProperty().addListener((ObservableList, oldvalue, newvalue) -> {
                 filteredListBirthCerteficate.setPredicate(birthCerteficate -> {
                     if (newvalue.isEmpty() || newvalue == null) {
                         return true;
                     }
                     String seachkey = newvalue;
                     if (birthCerteficate.getChildName().indexOf(seachkey) > -1) {
                         return true;
                     } else if (birthCerteficate.getFathername().indexOf(seachkey) > -1) {
                         return true;
                     } else if (birthCerteficate.getGrandfather().indexOf(seachkey) > -1) {
                         return true;
                     } else if (birthCerteficate.getGender().indexOf(seachkey) > -1) {
                         return true;
                     } else if (birthCerteficate.getBirthday().toString().indexOf(seachkey) > -1) {
                         return true;
                     } else if (birthCerteficate.getBirthplace().indexOf(seachkey) > -1) {
                         return true;
                     } else if (birthCerteficate.getNationality().indexOf(seachkey) > -1) {
                         return true;
                     } else if (birthCerteficate.getMotherfullname().indexOf(seachkey) > -1) {
                         return true;
                     } else if (birthCerteficate.getMothernationality().indexOf(seachkey) > -1) {
                         return true;
                     } else if (birthCerteficate.getFatherfullname().indexOf(seachkey) > -1) {
                         return true;
                     } else if (birthCerteficate.getFathernationality().indexOf(seachkey) > -1) {
                         return true;
                     } else if (birthCerteficate.getBirthdayregestor().toString().indexOf(seachkey) > -1) {
                         return true;
                     } else if (birthCerteficate.getBirthdayfileformnumber().toString().indexOf(seachkey) > -1) {
                         return true;
                     } else if (birthCerteficate.getCertificategiven().toString().indexOf(seachkey) > -1) {
                         return true;
                     } else if (birthCerteficate.getBirthdayregisteruniqenumber().toString().indexOf(seachkey) > -1) {
                         return true;
                     } else return false;
                 });

             });
             SortedList<BirthCerteficate2> sortedListBday = new SortedList<>(filteredListBirthCerteficate);
             sortedListBday.comparatorProperty().bind(tabel_BirthCerteficate.comparatorProperty());
             tabel_BirthCerteficate.setItems(sortedListBday);

             FilteredList<MarriageCeritificate> filteredListMarriage = new FilteredList<>(MarriageObservableList, c -> true);
             searchMarrage.textProperty().addListener((ObservableList, oldvalue, newvalue) -> {
                 filteredListMarriage.setPredicate(marriageCeritificate -> {
                     if (newvalue.isEmpty() || newvalue == null) {
                         return true;
                     }
                     String seachkey = newvalue;
                     if (marriageCeritificate.getHusbandname().indexOf(seachkey) > -1) {
                         return true;
                     }
                     if (marriageCeritificate.getWifename().indexOf(seachkey) > -1) {
                         return true;
                     }
                     if (marriageCeritificate.getDate().toString().indexOf(seachkey) > -1) {
                         return true;
                     }
                     if (marriageCeritificate.getDay().toString().indexOf(seachkey) > -1) {
                         return true;
                     }
                     if (marriageCeritificate.getYear().toString().indexOf(seachkey) > -1) {
                         return true;
                     }
                     if (marriageCeritificate.getAssigner().indexOf(seachkey) > -1) {
                         return true;
                     }
                     if (marriageCeritificate.getPlace().indexOf(seachkey) > -1) {
                         return true;
                     }
                     if (marriageCeritificate.getFirstwitness().indexOf(seachkey) > -1) {
                         return true;
                     }
                     if (marriageCeritificate.getSecondwitness().indexOf(seachkey) > -1) {
                         return true;
                     } else return false;
                 });
             });
             SortedList<MarriageCeritificate> sortedListMarriage = new SortedList<>(filteredListMarriage);
             sortedListMarriage.comparatorProperty().bind(tabel_Marrage.comparatorProperty());
             tabel_Marrage.setItems(sortedListMarriage);

             FilteredList<IDcard> filteredListId = new FilteredList<>(IdentificationObservableList, b -> true);
             searchID.textProperty().addListener((ObservableList, oldvalue, newvalue) -> {
                 filteredListId.setPredicate(iDcard -> {
                     if (newvalue.isEmpty() || newvalue == null) {
                         return true;
                     }
                     String seachkey = newvalue;
                     if (iDcard.getRegisterNumber().toString().indexOf(seachkey)>-1){
                         return true;
                     }
                     if (iDcard.getFirstName().indexOf(seachkey)>-1){
                         return true;
                     }
                     if (iDcard.getMiddleName().indexOf(seachkey)>-1){
                         return true;
                     }
                     if (iDcard.getLastName().indexOf(seachkey)>-1){
                         return true;
                     }
                     if (iDcard.getIdNumber().toString().indexOf(seachkey)>-1){
                         return true;
                     }
                     if (iDcard.getDateOfBirth().toString().indexOf(seachkey)>-1){
                         return true;
                     }
                     if (iDcard.getBloodGroup().indexOf(seachkey)>-1){
                         return true;
                     }
                     if (iDcard.getSex().indexOf(seachkey)>-1){
                         return true;
                     }
                     if (iDcard.getIssueDate().toString().indexOf(seachkey)>-1){
                         return true;
                     }
                     if (iDcard.getExpireDate().toString().indexOf(seachkey)>-1){
                         return true;
                     }
                     if (iDcard.getResidentAdress().indexOf(seachkey)>-1){
                         return true;
                     }
                     if (iDcard.getPhoneNumber().toString().indexOf(seachkey)>-1){
                         return true;
                     }
                     if (iDcard.getHouseNumber().toString().indexOf(seachkey)>-1){
                         return true;
                     }
                     if (iDcard.getEmgFirstName().indexOf(seachkey)>-1){
                         return true;
                     }
                     if (iDcard.getEmgMiddleName().indexOf(seachkey)>-1){
                         return true;
                     }
                     if (iDcard.getEmgLastName().indexOf(seachkey)>-1){
                         return true;
                     }
                     if (iDcard.getEmgPhoneNumber().toString().indexOf(seachkey)>-1){
                         return true;
                     }
                     else return false;
                 });

             });
             SortedList<IDcard> sortedListID = new SortedList<>(filteredListId);
             sortedListID.comparatorProperty().bind(tabel_Id.comparatorProperty());
             tabel_Id.setItems(sortedListID);

             FilteredList<UnemployedID> filteredListUnemployed = new FilteredList<>(UnemployedObservableList, b -> true);
             searchUnemployed.textProperty().addListener((ObservableList, oldvalue, newvalue) -> {
                 filteredListUnemployed.setPredicate(unemployed -> {
                     if (newvalue.isEmpty() || newvalue == null) {
                         return true;
                     }
                     String seachkey = newvalue;
                    if (unemployed.getUnfirstname().indexOf(seachkey)>-1){
                        return true;
                    }
                    if (unemployed.getUnmiddlename().indexOf(seachkey)>-1){
                        return true;
                    }
                    if (unemployed.getUnlastname().indexOf(seachkey)>-1){
                        return true;
                    }
                    if (unemployed.getSex().indexOf(seachkey)>-1){
                        return true;
                    }
                    if (unemployed.getPhonenumber().toString().indexOf(seachkey)>-1){
                        return true;
                    }
                    if (unemployed.getResisdentadress().indexOf(seachkey)>-1){
                        return true;
                    }
                    if (unemployed.getNationality().indexOf(seachkey)>-1){
                        return true;
                    }
                    if (unemployed.getBirthplace().indexOf(seachkey)>-1){
                        return true;
                    }
                    if (unemployed.getCity().indexOf(seachkey)>-1){
                        return true;
                    }
                    if (unemployed.getZone().indexOf(seachkey)>-1){
                        return true;
                    }
                    if (unemployed.getWereda().toString().indexOf(seachkey)>-1){
                        return true;
                    }
                    if (unemployed.getKebele().toString().indexOf(seachkey)>-1){
                        return true;
                    }
                    if (unemployed.getLevelofeducation().indexOf(seachkey)>-1){
                        return true;
                    }
                    else return false;
                 });

             });

             SortedList<UnemployedID> sortedListUnemployedID = new SortedList<>(filteredListUnemployed);
             sortedListUnemployedID.comparatorProperty().bind(tabel_unemployed.comparatorProperty());
             tabel_unemployed.setItems(sortedListUnemployedID);

             FilteredList<KebeleHouse> filteredListKebele = new FilteredList<>(KebeleHouseObservableList, b -> true);
             SearchKebele.textProperty().addListener((ObservableList, oldvalue, newvalue) -> {
                 filteredListKebele.setPredicate(kebelehouse -> {
                     if (newvalue.isEmpty() || newvalue == null) {
                         return true;
                     }
                     String seachkey = newvalue;
                     if (kebelehouse.getFatherFullName().indexOf(seachkey)>-1){
                         return true;
                     }
                     if (kebelehouse.getMotherFullName().indexOf(seachkey)>-1){
                         return true;
                     }
                     if (kebelehouse.getHouseNumber().toString().indexOf(seachkey)>-1){
                         return true;
                     }
                     if (kebelehouse.getAmountRoom().toString().indexOf(seachkey)>-1){
                         return true;
                     }
                     if (kebelehouse.getSurfaceArea().toString().indexOf(seachkey)>-1){
                         return true;
                     }
                     if (kebelehouse.getHouseLocation().indexOf(seachkey)>-1){
                         return true;
                     }
                     if (kebelehouse.getWindowAmount().toString().indexOf(seachkey)>-1){
                         return true;
                     }
                     if (kebelehouse.getWindowType().indexOf(seachkey)>-1){
                         return true;
                     }
                     if(kebelehouse.getDoorType().indexOf(seachkey)>-1){
                         return true;
                     }
                     if (kebelehouse.getKebeleHouseNumber().toString().indexOf(seachkey)>-1){
                         return true;
                     }
                     if (kebelehouse.getChildfullname().indexOf(seachkey)>-1){
                         return true;
                     }
                     if (kebelehouse.getChildgender().indexOf(seachkey)>-1){
                         return true;
                     }
                     if (kebelehouse.getChildage().toString().indexOf(seachkey)>-1){
                         return true;
                     }
                     if (kebelehouse.getChildcarrier().indexOf(seachkey)>-1){
                         return true;
                     }
                     if (kebelehouse.getChildstatus().indexOf(seachkey)>-1){
                         return true;
                     }
                     return false;
                 });
             });
             SortedList<KebeleHouse> SortedListKebelHouse = new SortedList<>(filteredListKebele);
             SortedListKebelHouse.comparatorProperty().bind(tabel_unemployed.comparatorProperty());
             tabel_KebeleHouse.setItems(SortedListKebelHouse);
         } catch (Exception e) {
             e.printStackTrace();
         }
         tabel_Id.setOnMouseClicked(e->{
             IDcard iDcard = (IDcard) tabel_Id.getItems().get(tabel_Id.getSelectionModel().getSelectedIndex());
             showselectedimage(iDcard.getRegisterNumber());
         });
         tabel_organize.setOnMouseClicked(e->{
             OrganizationUnemployed organizationUnemployed = (OrganizationUnemployed) tabel_organize.getItems().get(tabel_organize.getSelectionModel().getSelectedIndex());
            showimageorganize(organizationUnemployed.getFullName());
         });
     }
    //QR Generator
    public void clickdbutton(MouseEvent event) {
     if (event.getSource() == btn_Generator) {
         try {
             String text ="RegisterNumber "+ txt_regNumber.getText() +"\n" +"FullName "+txt_resFname.getText() +" "+ txt_resMname.getText()
                     +" " +txt_resLname.getText() +"\n"+"IDNumber "+txt_resIdNumber.getText() +"\n" +"DateOfBirth "+ datePickerBirth.getEditor().getText()+
                     "\n" +"BloodGroup "+ txt_resBloodGroup.getText() +"\n" +"IssueDate "+datePickerIssue.getEditor().getText() +"\n" +"ExpireDate "+datePickerExpire.getEditor().getText()
                     +"\n" +"ResidentAddress "+txt_resAdress.getText() +"\n"+ "PhoneNumber "+txt_resPhoneNumber.getText() +"\n"+"HouseNumber "+txt_resHouseNumber.getText() +"\n" +"Emg "+
                     txt_EmgFName.getText()+ " "+txt_EmgMName.getText() + " " +txt_EmgLName.getText() +" " +tex_EmgPNumber.getText();
             ByteArrayOutputStream out = QRCode.from(text).to(ImageType.PNG).stream();
             File file = new File("C:\\Users\\Nati Lamar\\Pictures\\Saved Pictures\\"+txt_resFname.getText()+".jpg");
             FileOutputStream fos =  new FileOutputStream(file);

             fos.write(out.toByteArray());
             fos.flush();

             System.out.print("out success");

             Image image = new Image(file.toString());
             imageQR.setImage(image);
         }catch (Exception e){
             System.out.print(e);
         }
     }
 }
 public void showselectedimage(int regist){
     try {
         pst = connection.prepareStatement("SELECT Image FROM id WHERE RegisterNumber = ?");
         pst.setInt(1,regist);
         resultSet = pst.executeQuery();
         while (resultSet.next()){
             InputStream is = resultSet.getBinaryStream(1);
             OutputStream os = new FileOutputStream(new File("photo.jpg"));
             byte[] contents = new byte[1024];
             int size = 0;
             while ((size = is.read(contents)) != -1){
                 os.write(contents,0,size);
             }
             Image image = new Image("file:photo.jpg",IDimage.getFitHeight(),IDimage.getFitWidth(),true,true);
             IDimage.setImage(image);
         }
     } catch (Exception throwables) {
         throwables.printStackTrace();
     }
 }
 public void showimageorganize(String name){
        try {
            pst = connection.prepareStatement("SELECT QRImage FROM organizing WHERE FullName=?");
            pst.setString(1,name);
            resultSet = pst.executeQuery();
            while (resultSet.next()){
                InputStream is = resultSet.getBinaryStream(1);
                OutputStream os = new FileOutputStream(new File("photo.jpg"));
                byte[] contents = new byte[1024];
                int size = 0;
                while ((size = is.read(contents)) != -1){
                    os.write(contents,0,size);
                }
                Image image = new Image("file:photo.jpg",OrganizeImage.getFitHeight(),OrganizeImage.getFitWidth(),true,true);
                OrganizeImage.setImage(image);
            }
        }  catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }
    //Refrash
    public void refrashtabel(){
        try {
            HouseObservableList.clear();
            pst = connection.prepareStatement("SELECT * FROM house");
            resultSet = pst.executeQuery();
            while (resultSet.next()) {
                HouseObservableList.addAll(new House(resultSet.getString(1), resultSet.getString(2), Integer.parseInt(resultSet.getString(3)), Date.valueOf(resultSet.getString(4)),
                        Integer.parseInt(resultSet.getString(5)), resultSet.getString(6), resultSet.getString(7), Integer.parseInt(resultSet.getString(8))));
            }
        }catch (Exception e) {
        }
     tabel_House.setItems(HouseObservableList);
    }
    public void refrashIdTabel() {
        try {
            IdentificationObservableList.clear();
            pst = connection.prepareStatement("SELECT `RegisterNumber`, `FirstName`, `MiddleName`, `LastNumber`, `IdNumber`, `DateOfBirth`, `BloodGroup`, `Sex`, `IssueDate`, `ExpireDate`, `ResidentAdress`, `PhoneNumber`, `HouseNumber`, `EmgFirstName`, `EmgMiddleName`, `EmgLastName`, `EmgPhoneNumber` FROM `id` WHERE 1");
            resultSet=pst.executeQuery();
            while (resultSet.next()) {
                IdentificationObservableList.addAll(new IDcard(Integer.parseInt(resultSet.getString(1)),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),Integer.parseInt(resultSet.getString(5)),Date.valueOf(resultSet.getString(6)),
                        resultSet.getString(7),resultSet.getString(8),Date.valueOf(resultSet.getString(9)),Date.valueOf(resultSet.getString(10)),resultSet.getString(11),Integer.parseInt(resultSet.getString(12)),Integer.parseInt(resultSet.getString(13)),resultSet.getString(14),
                        resultSet.getString(15),resultSet.getString(16),Integer.parseInt(resultSet.getString(17))));
            }
        } catch (Exception e) {
        }
        tabel_Id.setItems(IdentificationObservableList);
    }
    public void refrashKebeleTabel(){
        try{
            KebeleHouseObservableList.clear();
            pst=connection.prepareStatement("SELECT * FROM kebelehouse JOIN childrenstatus ON childrenstatus.kebelehousenumber = kebelehouse.HouseNumber");
            resultSet =pst.executeQuery();
            while (resultSet.next()){
                KebeleHouseObservableList.addAll(new KebeleHouse(resultSet.getString(1),resultSet.getString(2),Integer.parseInt(resultSet.getString(3)),Integer.parseInt(resultSet.getString(4)),
                        Integer.parseInt(resultSet.getString(5)),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),Integer.parseInt(resultSet.getString(10)),resultSet.getString(11),resultSet.getString(12),Integer.parseInt(resultSet.getString(13))
                        ,resultSet.getString(14),resultSet.getString(15)));
            }
            System.out.println("refreshed");
        } catch (Exception e) {
        }
        tabel_KebeleHouse.setItems(KebeleHouseObservableList);
    }
    public void refrashBirthTabel(){
        try {
            BirthCertificateObservableList.clear();
            pst =connection.prepareStatement("SELECT  childname, fathername, grandfname, gender, birthday, birthplace, nationality, motherfullname, mothernationality, fatherfullname, fathernationality, birthdayregestor, birthdayfileformnumber, certificategiven, birthdayregisteruniqenumber FROM birthdaycertificate");
            resultSet = pst.executeQuery();
            while (resultSet.next()){
                BirthCertificateObservableList.addAll(new BirthCerteficate2(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),Date.valueOf(resultSet.getString(5)),
                        resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getString(10),resultSet.getString(11),
                        Date.valueOf(resultSet.getString(12)),Integer.parseInt(resultSet.getString(13)),Date.valueOf(resultSet.getString(14)),Integer.parseInt(resultSet.getString(15))));
            }
            System.out.println("refreshed");
        } catch (Exception e) {
        }
        tabel_BirthCerteficate.setItems(BirthCertificateObservableList);
    }
    public void refreshUnemployTabel(){
        try {
            UnemployedObservableList.clear();
            pst=connection.prepareStatement("SELECT firstname, middlename, lastname, sex, phonenumber, resisdentadress, nationality, birthplace, city, zone, wereda,kebele, levelofeducation FROM unimployed");
            resultSet =pst.executeQuery();
            while (resultSet.next()){
                UnemployedObservableList.addAll(new UnemployedID(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),Integer.parseInt(resultSet.getString(12)),resultSet.getString(6),
                        resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getString(10),Integer.parseInt(resultSet.getString(11)),Integer.parseInt(resultSet.getString(12)),resultSet.getString(13)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tabel_unemployed.setItems(UnemployedObservableList);
    }
    public void refrashorganTabel(){
        try{
            OrganizeObservableList.clear();
            pst = connection.prepareStatement("SELECT FullName, TypeOfWork, WorkingLocation, AmountOfCapital FROM organizing");
            resultSet = pst.executeQuery();
            while (resultSet.next()){
                OrganizeObservableList.addAll(new OrganizationUnemployed(resultSet.getString(1),
                        resultSet.getString(2),resultSet.getString(3),Integer.parseInt(resultSet.getString(4))));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tabel_organize.setItems(OrganizeObservableList);
    }
    public void referashMarriageTabel(){
        try {
            MarriageObservableList.clear();
            pst =connection.prepareStatement("SELECT husbandname, wifename, date, day, year, assigner, place, firstwitness, secondwitness FROM marriage");
            resultSet = pst.executeQuery();
            while (resultSet.next()){
                MarriageObservableList.addAll(new MarriageCeritificate(resultSet.getString(1),resultSet.getString(2),Integer.parseInt(resultSet.getString(3)),Integer.parseInt(resultSet.getString(4)),
                        Integer.parseInt(resultSet.getString(5)),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tabel_Marrage.setItems(MarriageObservableList);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pn_form.toFront();
        connection = dbConector.getConnectionDB();
        choiceB_Nchild.getItems().addAll(number);
        choiceB_Nchild.setOnAction(this::getNumber);
        choiceBHouseChilde.getItems().addAll(numbers);
        choiceBHouseChilde.setOnAction(this::getnumbers);
        cellSetTable();
        loadData();
    }
}
