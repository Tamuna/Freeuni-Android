package ge.edu.freeuni.asignment3.ui.pdfview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;

import ge.edu.freeuni.asignment3.R;

public class PdfReaderActivity extends AppCompatActivity {
    private PDFView pdfView;

    public static void start(String path, Activity previous) {
        Intent intent = new Intent(previous, PdfReaderActivity.class);
        intent.putExtra("path", path);
        previous.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_reader);
        pdfView = findViewById(R.id.pdfView);
        String path = getIntent().getStringExtra("path");
        pdfView.fromFile(new File(path)).load();
    }
}
