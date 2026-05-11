package objectdata;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
