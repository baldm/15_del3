package Spil;

import java.io.File;
import java.util.Arrays;

public class Launcher {
    public static void main(String[] args) {
        // Information to make a the automatic version of a filereader is found on
        // https://www.javabrahman.com/corejava/how-to-count-number-of-files-in-a-directory-in-java-file-list-vs-nios-directorystream/
        // accessed 09.11.2020
        File allFields = new File("./Fields");
        int fileCount = allFields.list().length;
        String[] fieldNames = allFields.list();
        System.out.println(fileCount);
        System.out.println(Arrays.toString(fieldNames));
    }
}
