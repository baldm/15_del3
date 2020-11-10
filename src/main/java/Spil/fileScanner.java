package Spil;

import java.io.File;

public class fileScanner {
    String[] fieldNames;

    // Information to make a the automatic version of a filereader is found on
    // https://www.javabrahman.com/corejava/how-to-count-number-of-files-in-a-directory-in-java-file-list-vs-nios-directorystream/
    // accessed 09.11.2020

    public fileScanner(String folder) {
        File allFields = new File("./" + folder);

        fieldNames = allFields.list();

    }

    public String[] getFieldNames() {
        return fieldNames;
    }
}