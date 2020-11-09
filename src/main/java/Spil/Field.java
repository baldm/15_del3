package Spil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Field {
    private static String fieldName;


    public Field(String fileName, String language){
        try {
            FileInputStream input = new FileInputStream("./Fields/"+ fileName);


            Properties prop = new Properties();
            prop.load(input);
            switch (language){
                case "Danish":
                    fieldName = prop.getProperty("dkName");
                    break;
                case  "English":
                    fieldName = prop.getProperty("engName");
                    break;
                default: fieldName = "Error!";
            }




        } catch (FileNotFoundException e){

        } catch (IOException e){

        }



    }

    public static String getFieldName() {
        return fieldName;
    }
}
