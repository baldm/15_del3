package Spil;

import java.io.File;

public class Launcher {
    public static void main(String[] args) {
        File allFields = new File("./Fields");
        int fileCount = allFields.list().length;
        String[] fieldNames = allFields.list();
        System.out.println(fileCount);
        System.out.println(fieldNames);
    }
}
