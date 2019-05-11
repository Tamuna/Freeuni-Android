package ge.edu.freeuni.asignment3.ui.textediting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import ge.edu.freeuni.asignment3.R;

public class TextEditorActivity extends AppCompatActivity implements SaveFileDialogFragment.NoticeDialogListener, TextEditorContract.TextEditorView {

    private EditText etFile;
    private TextView btnSave;
    private String path;
    private TextEditorContract.TextEditorPresenter presenter;

    public static void start(String path, Context previous) {
        Intent intent = new Intent(previous, TextEditorActivity.class);
        intent.putExtra("path", path);
        previous.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_editor);
        path = getIntent().getStringExtra("path");
        presenter = new TextEditorPresenterImpl(this, new TextEditorInteractorImpl(), path);

        etFile = findViewById(R.id.et_file);
        btnSave = findViewById(R.id.tv_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveFileDialogFragment.newInstance(path.substring(path.lastIndexOf('/') + 1)).show(getSupportFragmentManager(), "alert");
            }
        });
        presenter.loadFile();
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog, String name) {
        dialog.dismiss();
        presenter.saveFile(name, etFile.getText().toString());
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        dialog.dismiss();
        finish();
    }

    @Override
    public void closeEditor() {
        finish();
    }

    @Override
    public void showFileContent(String text) {
        etFile.setText(text);
    }
}
