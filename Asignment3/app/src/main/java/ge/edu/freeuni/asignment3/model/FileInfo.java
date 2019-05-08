package ge.edu.freeuni.asignment3.model;

/*
 * created by tgeldiashvili on 5/8/2019
 */

public class FileInfo {
    private int type;
    private String fileName;
    private String createDate;
    private Long size;

    public FileInfo(int type, String fileName, String createDate, long size) {
        this.type = type;
        this.fileName = fileName;
        this.createDate = createDate;
        this.size = size;
    }

    public int getType() {
        return type;
    }

    public String getFileName() {
        return fileName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public Long getSize() {
        return size;
    }
}
