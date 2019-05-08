package ge.edu.freeuni.asignment3.ui.navigation;

/*
 * created by tgeldiashvili on 5/8/2019
 */

import java.util.List;

import ge.edu.freeuni.asignment3.model.FileInfo;

public interface ExplorerContract {
    interface ExplorerView {
        void onDataLoaded(List<FileInfo> directoryContent);
        void loadPdf(String path);
    }

    interface ExplorerPresenter {
        void handleFileClick(String dirName);
    }

    interface ExplorerInteractor {
        interface OnFinishListener {
            void onDirectoryDataLoaded(List<FileInfo> directoryContent);
        }

        void getDirectoryContent(OnFinishListener onFinishListener, String path);
    }
}
