package objectdata;

public class WebTablesObject extends GeneralObject{
    private String firstNameValue;
    private String lastNameValue;
    private String userEmailValue;
    private String ageFieldValue;
    private String salaryFieldValue;
    private String departmentFieldValue;
    private String editSalaryFieldValue;
    private String editDepartmentFieldValue;

    public WebTablesObject(String filepath) {
        fromJsonToObject(filepath);
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

    public String getAgeFieldValue() {
        return ageFieldValue;
    }

    public void setAgeFieldValue(String ageFieldValue) {
        this.ageFieldValue = ageFieldValue;
    }

    public String getSalaryFieldValue() {
        return salaryFieldValue;
    }

    public void setSalaryFieldValue(String salaryFieldValue) {
        this.salaryFieldValue = salaryFieldValue;
    }

    public String getDepartmentFieldValue() {
        return departmentFieldValue;
    }

    public void setDepartmentFieldValue(String departmentFieldValue) {
        this.departmentFieldValue = departmentFieldValue;
    }

    public String getEditSalaryFieldValue() {
        return editSalaryFieldValue;
    }

    public void setEditSalaryFieldValue(String editSalaryFieldValue) {
        this.editSalaryFieldValue = editSalaryFieldValue;
    }

    public String getEditDepartmentFieldValue() {
        return editDepartmentFieldValue;
    }

    public void setEditDepartmentFieldValue(String editDepartmentFieldValue) {
        this.editDepartmentFieldValue = editDepartmentFieldValue;
    }
}
