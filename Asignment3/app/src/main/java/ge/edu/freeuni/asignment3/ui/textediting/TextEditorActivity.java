package ge.edu.freeuni.asignment3.ui.textediting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import ge.edu.freeuni.asignment3.R;

public class TextEditorActivity extends AppCompatActivity implements SaveFileDialogFragment.NoticeDialogListener {

    private EditText etFile;
    private TextView btnSave;
    private String path;

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
        etFile = findViewById(R.id.et_file);
        btnSave = findViewById(R.id.tv_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveFileDialogFragment.newInstance(path.substring(path.lastIndexOf('/') + 1)).show(getSupportFragmentManager(), "alert");
            }
        });
        loadFile();

    }

    private void loadFile() {

        StringBuilder text = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;

            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            br.close();

            etFile.setText(text.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void saveFile(String name) {
        String text = etFile.getText().toString();
        File file = new File(path);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(text.getBytes());
            fos.close();
            file.renameTo(new File(path.substring(0, path.lastIndexOf('/')) + "/" + name));
        } catch (Exception e) {
            e.printStackTrace();
        }
        finish();
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog, String name) {
        dialog.dismiss();
        saveFile(name);
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        dialog.dismiss();
    }
}
