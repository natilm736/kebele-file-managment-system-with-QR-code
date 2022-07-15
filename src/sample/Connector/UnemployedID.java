package sample.Connector;

import javafx.scene.image.ImageView;

public class UnemployedID {
    public ImageView image;
    public String Unfirstname;
    public String Unmiddlename;
    public String Unlastname;
    public String sex;
    public Integer phonenumber;
    public String resisdentadress;
    public String nationality;
    public String birthplace;
    public String city;
    public String zone;
    public Integer wereda;
    public Integer kebele;
    public String levelofeducation;

    public UnemployedID(String unfirstname, String unmiddlename, String unlastname, String sex, Integer phonenumber, String resisdentadress, String nationality, String birthplace, String city, String zone, Integer wereda,Integer kebele, String levelofeducation) {
        this.Unfirstname = unfirstname;
        this.Unmiddlename = unmiddlename;
        this.Unlastname = unlastname;
        this.sex = sex;
        this.phonenumber = phonenumber;
        this.resisdentadress = resisdentadress;
        this.nationality = nationality;
        this.birthplace = birthplace;
        this.city = city;
        this.zone = zone;
        this.wereda = wereda;
        this.kebele = kebele;
        this.levelofeducation = levelofeducation;
    }

    public String getUnfirstname() {
        return Unfirstname;
    }

    public void setUnfirstname(String unfirstname) {
        Unfirstname = unfirstname;
    }

    public String getUnmiddlename() {
        return Unmiddlename;
    }

    public void setUnmiddlename(String unmiddlename) {
        Unmiddlename = unmiddlename;
    }

    public String getUnlastname() {
        return Unlastname;
    }

    public void setUnlastname(String unlastname) {
        Unlastname = unlastname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Integer phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getResisdentadress() {
        return resisdentadress;
    }

    public void setResisdentadress(String resisdentadress) {
        this.resisdentadress = resisdentadress;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public Integer getWereda() {
        return wereda;
    }

    public void setWereda(Integer wereda) {
        this.wereda = wereda;
    }

    public Integer getKebele() {
        return kebele;
    }

    public void setKebele(Integer kebele) {
        this.kebele = kebele;
    }

    public String getLevelofeducation() {
        return levelofeducation;
    }

    public void setLevelofeducation(String levelofeducation) {
        this.levelofeducation = levelofeducation;
    }
}
