package ge.edu.freeuni.asignment3.ui.textediting;

public interface TextEditorContract {
    interface TextEditorView {
        void closeEditor();

        void showFileContent(String text);
    }

    interface TextEditorPresenter {
        void saveFile(String name, String text);

        void loadFile();
    }

    interface TextEditorInteractor {
        void saveFile(OnFinishListener onFinishListener, String path, String name, String text);

        void loadFile(OnFinishListener onFinishListener, String path);

        interface OnFinishListener {
            void onFileSaved();

            void onFileLoaded(String text);
        }
    }
}
