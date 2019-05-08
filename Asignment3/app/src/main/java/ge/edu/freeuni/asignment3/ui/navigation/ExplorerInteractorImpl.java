package ge.edu.freeuni.asignment3.ui.navigation;

/*
 * created by tgeldiashvili on 5/8/2019
 */

import android.annotation.TargetApi;
import android.os.Build;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import ge.edu.freeuni.asignment3.model.FileInfo;
import ge.edu.freeuni.asignment3.util.FileTypeHelper;

public class ExplorerInteractorImpl implements ExplorerContract.ExplorerInteractor {

    @TargetApi(Build.VERSION_CODES.O)
    @Override
    public void getDirectoryContent(OnFinishListener onFinishListener, String path) {
        File curFile = new File(path);
        List<FileInfo> fileContent = new ArrayList<>();
        for (String it : curFile.list()) {
            String filePath = path + "/" + it;
            File itFile = new File(filePath);
            if (curFile.isDirectory()) {
                try {
                    BasicFileAttributes attrs = Files.readAttributes(curFile.toPath(), BasicFileAttributes.class);
                    String creationTime = attrs.creationTime().toString();
                    long size;
                    if (curFile.isDirectory()) {
                        size = curFile.list().length;
                    } else {
                        size = attrs.size();
                    }
                    fileContent.add(new FileInfo(FileTypeHelper.getIconByType(it), it, creationTime, size));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        onFinishListener.onDirectoryDataLoaded(fileContent);
    }
}
