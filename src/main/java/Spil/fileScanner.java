package Spil;

import java.io.File;
import java.util.Arrays;

public class fileScanner {
    String[] fieldNames;


    public fileScanner(String folder) {
        File allFields = new File("./" + folder);

        String[] fieldNames = allFields.list();

    }

    public String[] getFieldNames() {
        return fieldNames;
    }
}