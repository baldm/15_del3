package Spil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Language {
    private String test1;
    private String test2;
    private String test3;



    public Language (String fileName) {
        try {
            FileInputStream input = new FileInputStream("./Fields/" + fileName);


            Properties prop = new Properties();
            prop.load(input);
            test1 = prop.getProperty("test1");
            test2 = prop.getProperty("test2");
            test3 = prop.getProperty("test3");


        } catch (FileNotFoundException e){

        } catch (IOException e){

        }

    }

    public String getName(String name){
        switch (name) {
            case test1:
                return test1;
                break;
            case test2:
                return test2;
                break;
            case test3:
                return test3;
                break;
            default:
                return "Error! Name not found!";
        }

    }


}
