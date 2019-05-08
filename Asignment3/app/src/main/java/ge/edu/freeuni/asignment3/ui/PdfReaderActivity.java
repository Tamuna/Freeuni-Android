package ge.edu.freeuni.asignment3.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import ge.edu.freeuni.asignment3.R;

public class PdfReaderActivity extends AppCompatActivity {
    private WebView webView;

    public static void start(String path, Activity previous) {
        Intent intent = new Intent(previous, PdfReaderActivity.class);
        intent.putExtra("path", path);
        previous.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_reader);

        webView = findViewById(R.id.webView);
        String path = getIntent().getStringExtra("path");

        webView.loadUrl("file:///android_asset/pdfjs/web/viewer.html?file=" + path);
    }
}
