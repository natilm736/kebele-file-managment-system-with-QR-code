package sample;

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
import javafx.stage.Stage;
import sample.Connector.*;
import sample.DBConnector.DBConector;

import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    Connection connection= null;
    PreparedStatement pst = null;
    ResultSet resultSet= null;
    DBConector dbConector = new DBConector() ;
    FileInputStream fis ;
    File file;
//Button
    @FXML
    private Button  btn_logout,btn_AcessUnemployedID,btn_AcessKebeleHouse,btn_AcessBirthCertificate,btn_AcessOrganizing,btn_AcessMarrage;
    @FXML
    private Button btn_AccessHouse,btn_AcessID,btn_users,deletehouse,deleteid,deleteKebele,deletebirth,deletemarriage,deletunemployed,deletOrganize,deleteuser;
    @FXML
    private ImageView IDimage,OrganizeImage;
 //TextField
    @FXML
    private TextField search_Organize,search_House,searchBirth,searchMarrage,searchID,searchUnemployed,SearchKebele,search_users;
//Anchor
    @FXML
    private AnchorPane pn_tabel_organize,pn_tabel_id,pn_tabel_users,pn_tabel_House,pn_tabel_unemployed,pn_tabel_KebelaHouse,pn_tabel_marrage,pn_tabel_BirthCeriteficate;
///Tabel View
    @FXML
    private TableView tabel_organize,tabel_House,tabel_BirthCerteficate,tabel_Marrage,tabel_Id,tabel_unemployed,tabel_KebeleHouse,tabel_User;
    //column
    @FXML
    private TableColumn<OrganizationUnemployed, String> col_orgFullName;
    @FXML
    private TableColumn<OrganizationUnemployed, String> col_orgTypeOfWork;
    @FXML
    private TableColumn<OrganizationUnemployed, String> col_orgWorkingLocation;
    @FXML
    private TableColumn<OrganizationUnemployed, Integer> col_orgAmountofcapital;
    ObservableList<OrganizationUnemployed> OrganizeObservableList = FXCollections.observableArrayList();
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
    ObservableList<House> HouseObservableList = FXCollections.observableArrayList();
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
    ObservableList<IDcard> IdentificationObservableList = FXCollections.observableArrayList();
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
    ObservableList <BirthCerteficate2>BirthCertificateObservableList = FXCollections.observableArrayList();
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
    //User
    @FXML
    private TableColumn<User, String> col_userfullname;
    @FXML
    private TableColumn<User, String> col_UserEmail;
    @FXML
    private TableColumn<User, Integer> col_userPhoneNumber;
    @FXML
    private TableColumn<User, String> col_username;
    ObservableList<User> UserObservableList = FXCollections.observableArrayList();
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
        if (event.getSource()==btn_AcessUnemployedID){ pn_tabel_unemployed.toFront(); }
        if (event.getSource()==btn_AccessHouse){ pn_tabel_House.toFront(); }
        if (event.getSource()==btn_AcessOrganizing){ pn_tabel_organize.toFront(); }
        if (event.getSource()==btn_AcessBirthCertificate){ pn_tabel_BirthCeriteficate.toFront();}
        if (event.getSource()==btn_AcessID){pn_tabel_id.toFront();}
        if (event.getSource()==btn_AcessKebeleHouse){pn_tabel_KebelaHouse.toFront();}
        if (event.getSource()==btn_AcessMarrage){pn_tabel_marrage.toFront();}
        if (event.getSource()==btn_users){pn_tabel_users.toFront();}

        if (event.getSource()==btn_AcessKebeleHouse){IDimage.setImage(null);OrganizeImage.setImage(null);}
        if(event.getSource()==btn_AcessBirthCertificate){ IDimage.setImage(null);OrganizeImage.setImage(null); }
        if (event.getSource()==btn_AcessUnemployedID){ IDimage.setImage(null);OrganizeImage.setImage(null); }
        if(event.getSource()==btn_AcessMarrage){IDimage.setImage(null);OrganizeImage.setImage(null); }
        if (event.getSource()==btn_AcessOrganizing){ IDimage.setImage(null);}
        if (event.getSource()==btn_AcessID){OrganizeImage.setImage(null);}
    }
    public void cellSetTable() {
        //house
        col_HFatherName.setCellValueFactory(new PropertyValueFactory<>("FatherName"));
        col_HMotherName.setCellValueFactory(new PropertyValueFactory<>("MotherName"));
        col_HfilesubmissionDate.setCellValueFactory(new PropertyValueFactory<>("FileSubmissionDate"));
        col_HhousePhoneNumber.setCellValueFactory(new PropertyValueFactory<>("HousePhoneNumber"));
        col_HchildrenName.setCellValueFactory(new PropertyValueFactory<>("ChildName"));
        col_Hgender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        col_Hage.setCellValueFactory(new PropertyValueFactory<>("Age"));
        col_HhouseNumber.setCellValueFactory(new PropertyValueFactory<>("HouseNumber"));
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
        //Organization
        col_orgFullName.setCellValueFactory(new PropertyValueFactory<>("FullName"));
        col_orgWorkingLocation.setCellValueFactory(new PropertyValueFactory<>("WorkingLocation"));
        col_orgTypeOfWork.setCellValueFactory(new PropertyValueFactory<>("TypeOfWork"));
        col_orgAmountofcapital.setCellValueFactory(new PropertyValueFactory<>("AmountOfCapital"));
        //users
        col_userfullname.setCellValueFactory(new PropertyValueFactory<>("FullName"));
        col_UserEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        col_userPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
        col_username.setCellValueFactory(new PropertyValueFactory<>("UserName"));
    }
    public void loadData(){
        try {
            pst = connection.prepareStatement("SELECT * FROM house");
            resultSet = pst.executeQuery();
            while (resultSet.next()){
                HouseObservableList.addAll(new House(resultSet.getString(1),resultSet.getString(2),Integer.parseInt(resultSet.getString(3)),Date.valueOf(resultSet.getString(4)),
                        Integer.parseInt(resultSet.getString(5)),resultSet.getString(6),resultSet.getString(7),Integer.parseInt(resultSet.getString(8))));
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
            pst=connection.prepareStatement("SELECT * FROM kebelehouse JOIN childrenstatus ON childrenstatus.kebelehousenumber = kebelehouse.HouseNumber");
            resultSet =pst.executeQuery();
            while (resultSet.next()){
                KebeleHouseObservableList.addAll(new KebeleHouse(resultSet.getString(1),resultSet.getString(2),Integer.parseInt(resultSet.getString(3)),Integer.parseInt(resultSet.getString(4)),
                        Integer.parseInt(resultSet.getString(5)),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),Integer.parseInt(resultSet.getString(10)),resultSet.getString(11),resultSet.getString(12),Integer.parseInt(resultSet.getString(13))
                        ,resultSet.getString(14),resultSet.getString(15)));
            }
            pst=connection.prepareStatement("SELECT firstname, middlename, lastname, sex, phonenumber, resisdentadress, nationality, birthplace, city, zone, wereda,kebele, levelofeducation FROM unimployed");
            resultSet =pst.executeQuery();
            while (resultSet.next()){
            UnemployedObservableList.addAll(new UnemployedID(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),Integer.parseInt(resultSet.getString(12)),resultSet.getString(6),
                    resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getString(10),Integer.parseInt(resultSet.getString(11)),Integer.parseInt(resultSet.getString(12)),resultSet.getString(13)));
        }
            pst = connection.prepareStatement("SELECT FullName, TypeOfWork, WorkingLocation, AmountOfCapital FROM organizing");
            resultSet = pst.executeQuery();
            while (resultSet.next()){
                OrganizeObservableList.addAll(new OrganizationUnemployed(resultSet.getString(1),
                        resultSet.getString(2),resultSet.getString(3),Integer.parseInt(resultSet.getString(4))));
            }
            pst = connection.prepareStatement("SELECT FullName, Email, PhoneNumber, UserName FROM user");
            resultSet = pst.executeQuery();
            while (resultSet.next()){
                UserObservableList.addAll(new User(resultSet.getString(1),resultSet.getString(2),Integer.parseInt(resultSet.getString(3)),
                        resultSet.getString(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tabel_organize.setItems(OrganizeObservableList);
        searchresult();
        tabel_House.setItems(HouseObservableList);
        searchresult();
        tabel_BirthCerteficate.setItems(BirthCertificateObservableList);
        searchresult();
        tabel_Marrage.setItems(MarriageObservableList);
        searchresult();
        tabel_Id.setItems(IdentificationObservableList);
        searchresult();
        tabel_KebeleHouse.setItems(KebeleHouseObservableList);
        searchresult();
        tabel_unemployed.setItems(UnemployedObservableList);
        searchresult();
        tabel_User.setItems(UserObservableList);
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

            FilteredList<User> filteredListUser= new FilteredList<>(UserObservableList, b -> true);
            search_users.textProperty().addListener((ObservableList, oldvalue, newvalue) -> {
                filteredListUser.setPredicate(user -> {
                    if (newvalue.isEmpty() || newvalue == null) {
                        return true;
                    }
                    String seachkey = newvalue;
                    if (user.getFullName().indexOf(seachkey)>-1){
                        return true;
                    }
                    if (user.getEmail().indexOf(seachkey)>-1){
                        return true;
                    }
                    if (user.getPhoneNumber().toString().indexOf(seachkey)>-1){
                        return true;
                    }
                    if (user.getUserName().indexOf(seachkey)>-1){
                        return true;
                    }
                    return false;
                });
            });
            SortedList<User> SortedListuser = new SortedList<>(filteredListUser);
            SortedListuser.comparatorProperty().bind(tabel_User.comparatorProperty());
            tabel_User.setItems(SortedListuser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            tabel_Id.setOnMouseClicked(e -> {
                IDcard iDcard = (IDcard) tabel_Id.getItems().get(tabel_Id.getSelectionModel().getSelectedIndex());
                showselectedimage(iDcard.getRegisterNumber());
            });
            tabel_organize.setOnMouseClicked(e -> {
                OrganizationUnemployed organizationUnemployed = (OrganizationUnemployed) tabel_organize.getItems().get(tabel_organize.getSelectionModel().getSelectedIndex());
                showimageorganize(organizationUnemployed.getFullName());
            });
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Not Selected Row");
            alert.setContentText("Please select Table row");
            alert.showAndWait();
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
    public void deletRow(ActionEvent event) throws SQLException {
        if (event.getSource()==deletunemployed){
            try {
                UnemployedID unemployedID=(UnemployedID) tabel_unemployed.getSelectionModel().getSelectedItem();
                pst=connection.prepareStatement("DELETE FROM `unimployed` WHERE `firstname`=?");
                pst.setString(1,unemployedID.getUnfirstname());
                pst.execute();
                System.out.println(" deleted");
                refreshUnemployTabel();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }else if(event.getSource()==deleteid){
            IDcard iDcard =(IDcard) tabel_Id.getSelectionModel().getSelectedItem();
            try {
                pst =connection.prepareStatement("DELETE FROM `id` WHERE `EmgLastName`=?");
                pst.setString(1,iDcard.getEmgLastName());
                pst.execute();

                IdentificationObservableList.clear();
                pst = connection.prepareStatement("SELECT `RegisterNumber`,  `FirstName`, `MiddleName`, `LastNumber`, `IdNumber`, `DateOfBirth`, `BloodGroup`, `Sex`, `IssueDate`, `ExpireDate`, `ResidentAdress`, `PhoneNumber`, `HouseNumber`, `EmgFirstName`, `EmgMiddleName`, `EmgLastName`, `EmgPhoneNumber`  FROM `id` ");
                resultSet=pst.executeQuery();
                while (resultSet.next()) {
                    IdentificationObservableList.addAll(new IDcard(Integer.parseInt(resultSet.getString(1)),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),Integer.parseInt(resultSet.getString(5)),Date.valueOf(resultSet.getString(6)),
                            resultSet.getString(7),resultSet.getString(8),Date.valueOf(resultSet.getString(9)),Date.valueOf(resultSet.getString(10)),resultSet.getString(11),Integer.parseInt(resultSet.getString(12)),Integer.parseInt(resultSet.getString(13)),resultSet.getString(14),
                            resultSet.getString(15),resultSet.getString(16),Integer.parseInt(resultSet.getString(17))));
                }
                tabel_Id.setItems(IdentificationObservableList);

                refrashIdTabel();
                IDimage.setImage(null);
                System.out.println(" deleted");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }else if(event.getSource() ==deletehouse){
        House house = (House) tabel_House.getSelectionModel().getSelectedItem();
        try {
            pst = connection.prepareStatement("DELETE FROM `house` WHERE `HousePhoneNumber`=?");
            pst.setInt(1,house.getHousePhoneNumber());
            pst.execute();
            refershHouseTable();
            System.out.println("deleted");
        } catch (SQLException throwables) {
            System.out.println(" not deleted");
        }
            refershHouseTable();
    } else if(event.getSource()==deleteKebele){
         KebeleHouse kebeleHouse =(KebeleHouse) tabel_KebeleHouse.getSelectionModel().getSelectedItem();
         try{
             pst=connection.prepareStatement("DELETE kebelehouse FROM kebelehouse INNER JOIN childrenstatus ON childrenstatus.kebelehousenumber = kebelehouse.HouseNumber WHERE HouseNumber= ?");
             pst.setInt(1,kebeleHouse.getKebeleHouseNumber());
             pst.execute();

             System.out.println("deleted");
         } catch (SQLException throwables) {
             throwables.printStackTrace();
         }
            refrashKebeleTabel();
     } else if (event.getSource()==deletebirth){
            BirthCerteficate2 birthCerteficate2 =(BirthCerteficate2) tabel_BirthCerteficate.getSelectionModel().getSelectedItem();
            try {
                pst =connection.prepareStatement("DELETE FROM `birthdaycertificate` WHERE `birthdayregisteruniqenumber`=?");
                pst.setInt(1,birthCerteficate2.getBirthdayregisteruniqenumber());
                pst.execute();
                System.out.println("deleted");

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
             refrashBirthTabel();
        }else if (event.getSource()==deletemarriage){
             try {
                 MarriageCeritificate marriageCeritificate =(MarriageCeritificate) tabel_Marrage.getSelectionModel().getSelectedItem();
                 pst =connection.prepareStatement("DELETE FROM `marriage` WHERE `wifename`=?");
                 pst.setString(1,marriageCeritificate.getWifename());
                 pst.execute();
                 System.out.println(" deleted");
             }catch (SQLException throwables) {
                 throwables.printStackTrace();
             }
             referashMarriageTabel();
         }else if (event.getSource()==deletOrganize){
             try {
                 OrganizationUnemployed organizationUnemployed =(OrganizationUnemployed) tabel_organize.getSelectionModel().getSelectedItem();
                 pst =connection.prepareStatement("DELETE FROM `organizing` WHERE `FullName`=?");
                 pst.setString(1,organizationUnemployed.getFullName());
                 pst.execute();
                 System.out.println(" deleted");
             } catch (SQLException throwables) {
                 throwables.printStackTrace();
             }
             refrashorganTabel();
             OrganizeImage.setImage(null);
         }else if (event.getSource()==deleteuser){
             try {
                 User user=(User) tabel_User.getSelectionModel().getSelectedItem();
                 pst =connection.prepareStatement("DELETE FROM `user` WHERE `PhoneNumber`=?");
                 pst.setInt(1,user.getPhoneNumber());
                 pst.execute();
                 System.out.println(" deleted");
             } catch (SQLException throwables) {
                 throwables.printStackTrace();
             }
             refreshUserTabel();
         }
    }
    public void refershHouseTable() {
        try {
            HouseObservableList.clear();
            pst = connection.prepareStatement("SELECT * FROM house");
            resultSet = pst.executeQuery();
            while (resultSet.next()) {
                HouseObservableList.addAll(new House(resultSet.getString(1), resultSet.getString(2), Integer.parseInt(resultSet.getString(3)), Date.valueOf(resultSet.getString(4)),
                        Integer.parseInt(resultSet.getString(5)), resultSet.getString(6), resultSet.getString(7), Integer.parseInt(resultSet.getString(8))));
            }
        } catch (Exception e) {
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
  public void refreshUserTabel(){
        try{
            UserObservableList.clear();
            pst = connection.prepareStatement("SELECT FullName, Email, PhoneNumber, UserName FROM user");
            resultSet = pst.executeQuery();
            while (resultSet.next()){
                UserObservableList.addAll(new User(resultSet.getString(1),resultSet.getString(2),Integer.parseInt(resultSet.getString(3)),
                        resultSet.getString(4)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tabel_User.setItems(UserObservableList);
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
        @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pn_tabel_users.toFront();
        connection = dbConector.getConnectionDB();
        cellSetTable();
        loadData();
    }
    }