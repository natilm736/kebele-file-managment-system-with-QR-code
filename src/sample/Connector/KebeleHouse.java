package sample.Connector;

public class KebeleHouse {
    public String FatherFullName;
    public String MotherFullName;
    public Integer HouseNumber;
    public Integer AmountRoom;
    public Integer SurfaceArea;
    public String HouseLocation;
    public String WindowAmount;
    public String WindowType;
    public String DoorType;
    public Integer KebeleHouseNumber;
    public String childfullname;
    public String childgender;
    public Integer childage;
    public String childcarrier;
    public String Childstatus;

    public KebeleHouse(String fatherFullName, String motherFullName, Integer houseNumber, Integer amountRoom, Integer surfaceArea, String houseLocation, String windowAmount, String windowType, String doorType, Integer kebeleHouseNumber, String childfullname, String childgender, Integer childage, String childcarrier, String childstatus) {
        this.FatherFullName = fatherFullName;
        this.MotherFullName = motherFullName;
        this.HouseNumber = houseNumber;
        this.AmountRoom = amountRoom;
        this.SurfaceArea = surfaceArea;
        this.HouseLocation = houseLocation;
        this.WindowAmount = windowAmount;
        this.WindowType = windowType;
        this.DoorType = doorType;
        this.KebeleHouseNumber = kebeleHouseNumber;
        this.childfullname = childfullname;
        this.childgender = childgender;
        this.childage = childage;
        this.childcarrier = childcarrier;
        this.Childstatus = childstatus;
    }

    public String getFatherFullName() {
        return FatherFullName;
    }

    public void setFatherFullName(String fatherFullName) {
        FatherFullName = fatherFullName;
    }

    public String getMotherFullName() {
        return MotherFullName;
    }

    public void setMotherFullName(String motherFullName) {
        MotherFullName = motherFullName;
    }

    public Integer getHouseNumber() {
        return HouseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        HouseNumber = houseNumber;
    }

    public Integer getAmountRoom() {
        return AmountRoom;
    }

    public void setAmountRoom(Integer amountRoom) {
        AmountRoom = amountRoom;
    }

    public Integer getSurfaceArea() {
        return SurfaceArea;
    }

    public void setSurfaceArea(Integer surfaceArea) {
        SurfaceArea = surfaceArea;
    }

    public String getHouseLocation() {
        return HouseLocation;
    }

    public void setHouseLocation(String houseLocation) {
        HouseLocation = houseLocation;
    }

    public String getWindowAmount() {
        return WindowAmount;
    }

    public void setWindowAmount(String windowAmount) {
        WindowAmount = windowAmount;
    }

    public String getWindowType() {
        return WindowType;
    }

    public void setWindowType(String windowType) {
        WindowType = windowType;
    }

    public String getDoorType() {
        return DoorType;
    }

    public void setDoorType(String doorType) {
        DoorType = doorType;
    }

    public Integer getKebeleHouseNumber() {
        return KebeleHouseNumber;
    }

    public void setKebeleHouseNumber(Integer kebeleHouseNumber) {
        KebeleHouseNumber = kebeleHouseNumber;
    }

    public String getChildfullname() {
        return childfullname;
    }

    public void setChildfullname(String childfullname) {
        this.childfullname = childfullname;
    }

    public String getChildgender() {
        return childgender;
    }

    public void setChildgender(String childgender) {
        this.childgender = childgender;
    }

    public Integer getChildage() {
        return childage;
    }

    public void setChildage(Integer childage) {
        this.childage = childage;
    }

    public String getChildcarrier() {
        return childcarrier;
    }

    public void setChildcarrier(String childcarrier) {
        this.childcarrier = childcarrier;
    }

    public String getChildstatus() {
        return Childstatus;
    }

    public void setChildstatus(String childstatus) {
        Childstatus = childstatus;
    }
}
