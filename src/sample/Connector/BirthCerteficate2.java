package sample.Connector;

import javafx.scene.image.ImageView;

import java.sql.Date;

public class BirthCerteficate2 {
    public ImageView photo;
    public String ChildName;
    public String fathername;
    public String grandfather;
    public String gender;
    public Date birthday;
    public String birthplace;
    public String nationality;
    public String motherfullname;
    public String mothernationality;
    public String fatherfullname;
    public String fathernationality;
    public Date birthdayregestor;
    public Integer birthdayfileformnumber;
    public Date certificategiven;
    public Integer birthdayregisteruniqenumber;

    public BirthCerteficate2(String childName, String fathername, String grandfather, String gender, Date birthday, String birthplace, String nationality, String motherfullname, String mothernationality, String fatherfullname, String fathernationality, Date birthdayregestor, Integer birthdayfileformnumber, Date certificategiven, Integer birthdayregisteruniqenumber) {
        this.ChildName = childName;
        this.fathername = fathername;
        this.grandfather = grandfather;
        this.gender = gender;
        this.birthday = birthday;
        this.birthplace = birthplace;
        this.nationality = nationality;
        this.motherfullname = motherfullname;
        this.mothernationality = mothernationality;
        this.fatherfullname = fatherfullname;
        this.fathernationality = fathernationality;
        this.birthdayregestor = birthdayregestor;
        this.birthdayfileformnumber = birthdayfileformnumber;
        this.certificategiven = certificategiven;
        this.birthdayregisteruniqenumber = birthdayregisteruniqenumber;
    }

    public String getChildName() {
        return ChildName;
    }

    public void setChildName(String childName) {
        ChildName = childName;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getGrandfather() {
        return grandfather;
    }

    public void setGrandfather(String grandfather) {
        this.grandfather = grandfather;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMotherfullname() {
        return motherfullname;
    }

    public void setMotherfullname(String motherfullname) {
        this.motherfullname = motherfullname;
    }

    public String getMothernationality() {
        return mothernationality;
    }

    public void setMothernationality(String mothernationality) {
        this.mothernationality = mothernationality;
    }

    public String getFatherfullname() {
        return fatherfullname;
    }

    public void setFatherfullname(String fatherfullname) {
        this.fatherfullname = fatherfullname;
    }

    public String getFathernationality() {
        return fathernationality;
    }

    public void setFathernationality(String fathernationality) {
        this.fathernationality = fathernationality;
    }

    public Date getBirthdayregestor() {
        return birthdayregestor;
    }

    public void setBirthdayregestor(Date birthdayregestor) {
        this.birthdayregestor = birthdayregestor;
    }

    public Integer getBirthdayfileformnumber() {
        return birthdayfileformnumber;
    }

    public void setBirthdayfileformnumber(Integer birthdayfileformnumber) {
        this.birthdayfileformnumber = birthdayfileformnumber;
    }

    public Date getCertificategiven() {
        return certificategiven;
    }

    public void setCertificategiven(Date certificategiven) {
        this.certificategiven = certificategiven;
    }

    public Integer getBirthdayregisteruniqenumber() {
        return birthdayregisteruniqenumber;
    }

    public void setBirthdayregisteruniqenumber(Integer birthdayregisteruniqenumber) {
        this.birthdayregisteruniqenumber = birthdayregisteruniqenumber;
    }
}
