package ge.edu.freeuni.asignment3.ui.explorer;

/*
 * created by tgeldiashvili on 5/8/2019
 */

import android.content.Context;

import java.util.List;

import ge.edu.freeuni.asignment3.model.FileInfo;

public interface ExplorerContract {
    interface ExplorerView {
        void requestPermission();
        void onDataLoaded(String path, List<FileInfo> directoryContent);

        void editTxt(String path);

        void loadPdf(String path);

        void finishApplication();

        void highlight(int position);

        void unhighlight(int position);

        void unhighlightAll();

        void reloadData();
    }

    interface ExplorerPresenter {
        void checkPermissions(Context context);

        void handleFileClick(String filename, int position);

        void handleFileLongClick(String filename, int position);

        void deleteSelectedFiles();
    }

    interface ExplorerInteractor {
        interface OnFinishListener {
            void onDirectoryDataLoaded(List<FileInfo> directoryContent);

            void onDeletion();
        }

        void getDirectoryContent(OnFinishListener onFinishListener, String path);

        void deleteFiles(OnFinishListener onFinishListener, String path, List<String> files);
    }
}
