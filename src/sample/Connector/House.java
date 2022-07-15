package sample.Connector;

import java.sql.Date;

public class House {
public String FatherName;
public String MotherName;
public Integer HouseNumber;
public Date FileSubmissionDate;
public Integer HousePhoneNumber;
public String ChildName;
public String Gender;
public Integer Age;

    public House(String fatherName, String motherName, Integer houseNumber, Date fileSubmissionDate, Integer housePhoneNumber, String childName, String gender, Integer age) {
        this.FatherName = fatherName;
        this.MotherName = motherName;
        this.HouseNumber = houseNumber;
        this.FileSubmissionDate = fileSubmissionDate;
        this.HousePhoneNumber = housePhoneNumber;
        this.ChildName = childName;
        this.Gender = gender;
        this.Age = age;
    }

    public String getFatherName() {
        return FatherName;
    }

    public void setFatherName(String fatherName) {
        FatherName = fatherName;
    }

    public String getMotherName() {
        return MotherName;
    }

    public void setMotherName(String motherName) {
        MotherName = motherName;
    }

    public Integer getHouseNumber() {
        return HouseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        HouseNumber = houseNumber;
    }

    public Date getFileSubmissionDate() {
        return FileSubmissionDate;
    }

    public void setFileSubmissionDate(Date fileSubmissionDate) {
        FileSubmissionDate = fileSubmissionDate;
    }

    public Integer getHousePhoneNumber() {
        return HousePhoneNumber;
    }

    public void setHousePhoneNumber(Integer housePhoneNumber) {
        HousePhoneNumber = housePhoneNumber;
    }

    public String getChildName() {
        return ChildName;
    }

    public void setChildName(String childName) {
        ChildName = childName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }
}











