package ge.edu.freeuni.asignment3.util;

/*
 * created by tgeldiashvili on 5/8/2019
 */

import java.io.File;

import ge.edu.freeuni.asignment3.R;

public class FileTypeHelper {

    private static String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }

    public static int getIconByType(String file) {
        String type = getFileExtension(file);
        switch (type) {
            case "mp3":
                return R.drawable.mp3;
            case "doc":
            case "docx":
                return R.drawable.doc;
            case "xls":
            case "xlsx":
                return R.drawable.xls;
            case "txt":
                return R.drawable.txt;
            case "zip":
                return R.drawable.zip;
        }
        return R.drawable.folder;
    }
}
