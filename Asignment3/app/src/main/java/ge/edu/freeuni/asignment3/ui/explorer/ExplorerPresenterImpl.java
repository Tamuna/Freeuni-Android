package ge.edu.freeuni.asignment3.ui.explorer;

/*
 * created by tgeldiashvili on 5/8/2019
 */

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.content.ContextCompat;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import ge.edu.freeuni.asignment3.model.FileInfo;
import ge.edu.freeuni.asignment3.util.FileTypeHelper;

public class ExplorerPresenterImpl implements ExplorerContract.ExplorerPresenter {
    private static String currentPlace = "/storage/emulated/0";
    private boolean longClickOccurred = false;
    private List<String> highlightedFiles = new ArrayList<>();
    private ExplorerContract.ExplorerView view;
    private ExplorerContract.ExplorerInteractor interactor;

    public ExplorerPresenterImpl(ExplorerContract.ExplorerView view, ExplorerContract.ExplorerInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void checkPermissions(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int selfPermission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (selfPermission != PackageManager.PERMISSION_GRANTED) {
                view.requestPermission();
            } else {
                handleFileClick("", -1);
            }
        }
    }

    @Override
    public void handleFileClick(String filename, int position) {
        String path = currentPlace + filename;
        if (longClickOccurred && filename == null) {
            longClickOccurred = false;
            highlightedFiles.clear();
            view.unhighlightAll();
        } else {
            if (longClickOccurred) {
                handleHighlighting(position, filename);
            } else {
                navigate(filename, path);
            }
        }
    }

    @Override
    public void handleFileLongClick(String filename, int position) {
        longClickOccurred = true;
        handleHighlighting(position, filename);
    }

    @Override
    public void deleteSelectedFiles() {
        longClickOccurred = false;
        interactor.deleteFiles(new OnFinishListenerImpl(), currentPlace, highlightedFiles);
    }

    private boolean standingOnRoot() {
        return currentPlace.equals("/storage/emulated/0");
    }

    private void navigate(String filename, String path) {
        if (filename != null) {
            File file = new File(path);
            if (!file.isDirectory()) {
                if (FileTypeHelper.getFileExtension(file.getName()).equals("txt")) {
                    view.editTxt(path);
                } else if (FileTypeHelper.getFileExtension(file.getName()).equals("pdf")) {
                    view.loadPdf(path);
                }
                path = currentPlace.substring(0, path.lastIndexOf('/'));
            }
        } else {
            if (standingOnRoot()) {
                view.finishApplication();
                return;
            } else {
                path = currentPlace.substring(0, currentPlace.lastIndexOf('/'));
            }
        }
        currentPlace = path;
        interactor.getDirectoryContent(new OnFinishListenerImpl(), currentPlace);
    }

    private void handleHighlighting(int position, String filename) {
        if (highlightedFiles.contains(filename)) {
            highlightedFiles.remove(filename);
            view.unhighlight(position);
        } else {
            highlightedFiles.add(filename);
            view.highlight(position);
        }
    }

    public class OnFinishListenerImpl implements ExplorerContract.ExplorerInteractor.OnFinishListener {
        @Override
        public void onDirectoryDataLoaded(List<FileInfo> directoryContent) {
            String path = currentPlace.substring(1).replace("/", " > ");
            view.onDataLoaded(path, directoryContent);
        }

        @Override
        public void onDeletion() {
            view.reloadData();
        }
    }
}
