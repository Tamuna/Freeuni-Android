package ge.edu.freeuni.asignment3.ui.explorer;

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
        if (curFile.list() != null) {
            for (String it : curFile.list()) {
                File itFile = new File(path + "/" + it);
                try {
                    BasicFileAttributes attrs = Files.readAttributes(itFile.toPath(), BasicFileAttributes.class);
                    String creationTime = attrs.creationTime().toString();
                    String size;
                    if (itFile.isDirectory()) {
                        size = itFile.listFiles().length + " items";
                    } else {
                        size = attrs.size() + " kb";
                    }
                    fileContent.add(new FileInfo(FileTypeHelper.getIconByType(it), it, creationTime, size));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        onFinishListener.onDirectoryDataLoaded(fileContent);
    }

    @Override
    public void deleteFiles(OnFinishListener onFinishListener, String path, List<String> files) {
        for (String file : files) {
            File toDelete = new File(path + file);
            toDelete.delete();
        }
        onFinishListener.onDeletion();
    }
}
