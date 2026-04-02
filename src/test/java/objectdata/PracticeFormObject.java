package objectdata;

import java.util.Arrays;
import java.util.List;

public class PracticeFormObject extends GeneralObject{
    private String firstNameValue = "Daniel";
    private String lastNameValue = "Vlasceanu";
    private String userEmailValue = "automationtesting@gmail.com";
    private String genderValue = "Male";
    private String userNumberValue = "0712412445";
    private String monthValue = "December";
    private String yearValue = "2000";
    private String dayValue = "23";
    private String subjectsValue = "Arts";
    private List<String> hobbiesValues = Arrays.asList("Reading", "Music");
    private String picturePathValue = "exempluUpload.txt";
    private String currentAddressValue = "Str. Carpati, Nr.24, Orasul Focsani, Jud. Vrancea, Cod Postal: 625100";
    private String currentStateValue = "Haryana";
    private String currentCityValue = "Karnal";

    public PracticeFormObject(String filePath) {
        fromJsonToObject(filePath);
    }

    public String getFirstNameValue() {
        return firstNameValue;
    }

    public void setFirstNameValue(String firstNameValue) {
        this.firstNameValue = firstNameValue;
    }

    public String getLastNameValue() {
        return lastNameValue;
    }

    public void setLastNameValue(String lastNameValue) {
        this.lastNameValue = lastNameValue;
    }

    public String getUserEmailValue() {
        return userEmailValue;
    }

    public void setUserEmailValue(String userEmailValue) {
        this.userEmailValue = userEmailValue;
    }

    public String getGenderValue() {
        return genderValue;
    }

    public void setGenderValue(String genderValue) {
        this.genderValue = genderValue;
    }

    public String getUserNumberValue() {
        return userNumberValue;
    }

    public void setUserNumberValue(String userNumberValue) {
        this.userNumberValue = userNumberValue;
    }

    public String getMonthValue() {
        return monthValue;
    }

    public void setMonthValue(String monthValue) {
        this.monthValue = monthValue;
    }

    public String getYearValue() {
        return yearValue;
    }

    public void setYearValue(String yearValue) {
        this.yearValue = yearValue;
    }

    public String getDayValue() {
        return dayValue;
    }

    public void setDayValue(String dayValue) {
        this.dayValue = dayValue;
    }

    public String getSubjectsValue() {
        return subjectsValue;
    }

    public void setSubjectsValue(String subjectsValue) {
        this.subjectsValue = subjectsValue;
    }

    public List<String> getHobbiesValues() {
        return hobbiesValues;
    }

    public void setHobbiesValues(List<String> hobbiesValues) {
        this.hobbiesValues = hobbiesValues;
    }

    public String getPicturePathValue() {
        return picturePathValue;
    }

    public void setPicturePathValue(String picturePathValue) {
        this.picturePathValue = picturePathValue;
    }

    public String getCurrentAddressValue() {
        return currentAddressValue;
    }

    public void setCurrentAddressValue(String currentAddressValue) {
        this.currentAddressValue = currentAddressValue;
    }

    public String getCurrentStateValue() {
        return currentStateValue;
    }

    public void setCurrentStateValue(String currentStateValue) {
        this.currentStateValue = currentStateValue;
    }

    public String getCurrentCityValue() {
        return currentCityValue;
    }

    public void setCurrentCityValue(String currentCityValue) {
        this.currentCityValue = currentCityValue;
    }
}
