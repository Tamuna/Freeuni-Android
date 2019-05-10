package ge.edu.freeuni.asignment3.ui.explorer;

/*
 * created by tgeldiashvili on 5/8/2019
 */

import java.io.File;
import java.util.List;

import ge.edu.freeuni.asignment3.model.FileInfo;

public class ExplorerPresenterImpl implements ExplorerContract.ExplorerPresenter {
    private static String currentPlace = "/storage/emulated/0";

    private ExplorerContract.ExplorerView view;
    ExplorerContract.ExplorerInteractor interactor;

    public ExplorerPresenterImpl(ExplorerContract.ExplorerView view, ExplorerContract.ExplorerInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void handleFileClick(String dirName) {
        String path = "";
        //if not going back
        if (dirName != null) {
            //go one step deeper
            path = currentPlace + dirName;
            File file = new File(path);
            if (!file.isDirectory()) {
                view.editTxt(path);
                path = currentPlace.substring(0, path.lastIndexOf('/'));
            }
        } else {
            path = currentPlace.substring(0, currentPlace.lastIndexOf('/'));
        }
        currentPlace = path;
        interactor.getDirectoryContent(new OnFinishListenerImpl(), currentPlace);
    }

    public class OnFinishListenerImpl implements ExplorerContract.ExplorerInteractor.OnFinishListener {
        @Override
        public void onDirectoryDataLoaded(List<FileInfo> directoryContent) {
            view.onDataLoaded(directoryContent);
        }
    }
}
