package objectdata;

import lombok.Getter;
import lombok.Setter;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class PracticeFormObject extends GeneralObject {
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
}


