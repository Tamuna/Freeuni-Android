package ge.edu.freeuni.asignment3.ui.textediting;

public class TextEditorPresenterImpl implements TextEditorContract.TextEditorPresenter {

    private TextEditorContract.TextEditorView view;
    private TextEditorContract.TextEditorInteractor interactor;
    private String path;


    public TextEditorPresenterImpl(TextEditorContract.TextEditorView view, TextEditorContract.TextEditorInteractor interactor, String path) {
        this.view = view;
        this.interactor = interactor;
        this.path = path;
    }

    @Override
    public void saveFile(String name, String text) {
        interactor.saveFile(new OnFinishListenerImpl(), path, name, text);
    }

    @Override
    public void loadFile() {
        interactor.loadFile(new OnFinishListenerImpl(), path);
    }

    class OnFinishListenerImpl implements TextEditorContract.TextEditorInteractor.OnFinishListener {

        @Override
        public void onFileSaved() {
            view.closeEditor();
        }

        @Override
        public void onFileLoaded(String text) {
            view.showFileContent(text);
        }
    }
}
