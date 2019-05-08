package ge.edu.freeuni.asignment3.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import ge.edu.freeuni.asignment3.R;

public class TextEditorActivity extends AppCompatActivity {

    private EditText etFile;

    public static void start(String path, Context previous) {
        Intent intent = new Intent(previous, TextEditorActivity.class);
        intent.putExtra("path", path);
        previous.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_editor);

        etFile = findViewById(R.id.et_file);
        String path = getIntent().getStringExtra("path");
        String aDataRow = "";
        String aBuffer = "";
        try {
            File myFile = new File("path");
            FileInputStream fIn = new FileInputStream(myFile);
            BufferedReader myReader = new BufferedReader(
                    new InputStreamReader(fIn));

            while ((aDataRow = myReader.readLine()) != null) {
                aBuffer += aDataRow + "\n";
            }
            myReader.close();
            etFile.setText(aBuffer.toString());
        } catch (Exception e) {
        }

    }
}
