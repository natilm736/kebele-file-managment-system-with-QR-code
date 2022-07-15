package sample.Connector;

import javafx.scene.image.ImageView;

import java.sql.Date;

public class IDcard {
    public Integer RegisterNumber;
    public ImageView Image;
    public String FirstName;
    public String MiddleName;
    public String LastName;
    public Integer IdNumber;
    public Date  DateOfBirth;
    public String BloodGroup;
    public String sex;
    public Date IssueDate;
    public Date ExpireDate;
    public String ResidentAdress;
    public Integer PhoneNumber;
    public Integer HouseNumber;
    public String EmgFirstName;
    public String EmgMiddleName;
    public String EmgLastName;
    public Integer EmgPhoneNumber;
    public ImageView imageQR;
    public IDcard(Integer registerNumber, String firstName, String middleName, String lastName, Integer idNumber, Date dateOfBirth, String bloodGroup, String sex, Date issueDate, Date expireDate, String residentAdress, Integer phoneNumber, Integer houseNumber, String emgFirstName, String emgMiddleName, String emgLastName, Integer emgPhoneNumber) {
        this.RegisterNumber = registerNumber;
        this.FirstName = firstName;
        this.MiddleName = middleName;
        this.LastName = lastName;
        this.IdNumber = idNumber;
        this.DateOfBirth = dateOfBirth;
        this.BloodGroup = bloodGroup;
        this.sex = sex;
        this.IssueDate = issueDate;
        this.ExpireDate = expireDate;
        this.ResidentAdress = residentAdress;
        this.PhoneNumber = phoneNumber;
        this.HouseNumber = houseNumber;
        this.EmgFirstName = emgFirstName;
        this.EmgMiddleName = emgMiddleName;
        this.EmgLastName = emgLastName;
        this.EmgPhoneNumber = emgPhoneNumber;
    }
    public Integer getRegisterNumber() {
        return RegisterNumber;
    }

    public void setRegisterNumber(Integer registerNumber) {
        RegisterNumber = registerNumber;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Integer getIdNumber() {
        return IdNumber;
    }

    public void setIdNumber(Integer idNumber) {
        IdNumber = idNumber;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getBloodGroup() {
        return BloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        BloodGroup = bloodGroup;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getIssueDate() {
        return IssueDate;
    }

    public void setIssueDate(Date issueDate) {
        IssueDate = issueDate;
    }

    public Date getExpireDate() {
        return ExpireDate;
    }

    public void setExpireDate(Date expireDate) {
        ExpireDate = expireDate;
    }

    public String getResidentAdress() {
        return ResidentAdress;
    }

    public void setResidentAdress(String residentAdress) {
        ResidentAdress = residentAdress;
    }

    public Integer getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public Integer getHouseNumber() {
        return HouseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        HouseNumber = houseNumber;
    }

    public String getEmgFirstName() {
        return EmgFirstName;
    }

    public void setEmgFirstName(String emgFirstName) {
        EmgFirstName = emgFirstName;
    }

    public String getEmgMiddleName() {
        return EmgMiddleName;
    }

    public void setEmgMiddleName(String emgMiddleName) {
        EmgMiddleName = emgMiddleName;
    }

    public String getEmgLastName() {
        return EmgLastName;
    }

    public void setEmgLastName(String emgLastName) {
        EmgLastName = emgLastName;
    }

    public Integer getEmgPhoneNumber() {
        return EmgPhoneNumber;
    }

    public void setEmgPhoneNumber(Integer emgPhoneNumber) {
        EmgPhoneNumber = emgPhoneNumber;
    }

}
