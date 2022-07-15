package sample.Connector;

public class MarriageCeritificate {
    public String husbandname;
    public String wifename;
    public Integer date;
    public Integer day;
    public Integer year;
    public String assigner;
    public String place;
    public String firstwitness;
    public String secondwitness;

    public MarriageCeritificate(String husbandname, String wifename, Integer date, Integer day, Integer year, String assigner, String place, String firstwitness, String secondwitness) {
        this.husbandname = husbandname;
        this.wifename = wifename;
        this.date = date;
        this.day = day;
        this.year = year;
        this.assigner = assigner;
        this.place = place;
        this.firstwitness = firstwitness;
        this.secondwitness = secondwitness;
    }

    public String getHusbandname() {
        return husbandname;
    }

    public void setHusbandname(String husbandname) {
        this.husbandname = husbandname;
    }

    public String getWifename() {
        return wifename;
    }

    public void setWifename(String wifename) {
        this.wifename = wifename;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getAssigner() {
        return assigner;
    }

    public void setAssigner(String assigner) {
        this.assigner = assigner;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getFirstwitness() {
        return firstwitness;
    }

    public void setFirstwitness(String firstwitness) {
        this.firstwitness = firstwitness;
    }

    public String getSecondwitness() {
        return secondwitness;
    }

    public void setSecondwitness(String secondwitness) {
        this.secondwitness = secondwitness;
    }
}
