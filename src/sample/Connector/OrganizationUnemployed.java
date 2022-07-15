package sample.Connector;

import javafx.scene.image.ImageView;

public class OrganizationUnemployed {
    public String FullName;
    public String TypeOfWork;
    public String WorkingLocation;
    public Integer AmountOfCapital;
    public ImageView QRImage;

    public OrganizationUnemployed(String fullName, String typeOfWork, String workingLocation, Integer amountOfCapital) {
        FullName = fullName;
        TypeOfWork = typeOfWork;
        WorkingLocation = workingLocation;
        AmountOfCapital = amountOfCapital;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getTypeOfWork() {
        return TypeOfWork;
    }

    public void setTypeOfWork(String typeOfWork) {
        TypeOfWork = typeOfWork;
    }

    public String getWorkingLocation() {
        return WorkingLocation;
    }

    public void setWorkingLocation(String workingLocation) {
        WorkingLocation = workingLocation;
    }

    public Integer getAmountOfCapital() {
        return AmountOfCapital;
    }

    public void setAmountOfCapital(Integer amountOfCapital) {
        AmountOfCapital = amountOfCapital;
    }
}