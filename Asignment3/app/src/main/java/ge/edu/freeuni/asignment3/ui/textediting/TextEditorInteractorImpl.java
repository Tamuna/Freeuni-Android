package ge.edu.freeuni.asignment3.ui.textediting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

public class TextEditorInteractorImpl implements TextEditorContract.TextEditorInteractor {
    @Override
    public void saveFile(OnFinishListener onFinishListener, String path, String name, String text) {
        File file = new File(path);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(text.getBytes());
            fos.close();
            file.renameTo(new File(path.substring(0, path.lastIndexOf('/')) + "/" + name));
            onFinishListener.onFileSaved();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadFile(OnFinishListener onFinishListener, String path) {
        StringBuilder text = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;

            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            br.close();

            onFinishListener.onFileLoaded(text.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
