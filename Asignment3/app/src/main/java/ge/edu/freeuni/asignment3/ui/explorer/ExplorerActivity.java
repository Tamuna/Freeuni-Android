package ge.edu.freeuni.asignment3.ui.explorer;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ge.edu.freeuni.asignment3.R;
import ge.edu.freeuni.asignment3.model.FileInfo;
import ge.edu.freeuni.asignment3.ui.pdfview.PdfReaderActivity;
import ge.edu.freeuni.asignment3.ui.textediting.TextEditorActivity;

public class ExplorerActivity extends AppCompatActivity implements ExplorerContract.ExplorerView {
    private static final int REQUEST_EXTERNAL_STORAGE = 123456;

    private ExplorerContract.ExplorerPresenter presenter;
    private RecyclerView recyclerView;
    private ImageView imgChangeLayout;
    private ImageView imgDeleteSelected;
    private TextView tvPath;
    private static boolean listLayout = false;
    private LinearLayoutManager linearLayoutManager;
    private GridLayoutManager gridLayoutManager;
    private ExplorerRecyclerAdapter adapter;
    private OnItemClickListenerImpl onItemClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explorer);

        onItemClickListener = new OnItemClickListenerImpl();

        recyclerView = findViewById(R.id.rv_explorer);
        linearLayoutManager = new LinearLayoutManager(this);
        gridLayoutManager = new GridLayoutManager(this, 4);
        imgChangeLayout = findViewById(R.id.img_change_layout);
        imgChangeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listLayout = !listLayout;
                if (listLayout) {
                    recyclerView.setLayoutManager(linearLayoutManager);
                } else {
                    recyclerView.setLayoutManager(gridLayoutManager);
                }
                adapter.setListLayout(listLayout);
                recyclerView.setAdapter(adapter);
            }
        });

        tvPath = findViewById(R.id.tv_path);
        imgDeleteSelected = findViewById(R.id.img_delete);
        imgDeleteSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.deleteSelectedFiles();
                imgDeleteSelected.setVisibility(View.GONE);
                imgChangeLayout.setVisibility(View.VISIBLE);
            }
        });
        presenter = new ExplorerPresenterImpl(this, new ExplorerInteractorImpl());
        presenter.checkPermissions(this);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_EXTERNAL_STORAGE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                presenter.handleFileClick("", -1);
            }
        }
    }

    @Override
    protected void onResume() {
        presenter.handleFileClick("", -1);
        super.onResume();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void requestPermission() {
        requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_EXTERNAL_STORAGE);
    }

    @Override
    public void onDataLoaded(String path, List<FileInfo> directoryContent) {
        if (listLayout) {
            recyclerView.setLayoutManager(linearLayoutManager);
        } else {
            recyclerView.setLayoutManager(gridLayoutManager);
        }
        adapter = new ExplorerRecyclerAdapter(onItemClickListener);
        adapter.setData(directoryContent);
        adapter.unhighlightAll();
        recyclerView.setAdapter(adapter);
        tvPath.setText(path);
    }

    @Override
    public void editTxt(String path) {
        TextEditorActivity.start(path, this);
    }

    @Override
    public void loadPdf(String path) {
        PdfReaderActivity.start(path, this);
    }

    @Override
    public void finishApplication() {
        finish();
    }

    @Override
    public void highlight(int position) {
        adapter.highlight(position);
    }

    @Override
    public void unhighlight(int position) {
        adapter.unhighlight(position);
    }

    @Override
    public void unhighlightAll() {
        adapter.unhighlightAll();
    }

    @Override
    public void reloadData() {
        presenter.handleFileClick("", 0);
    }


    class OnItemClickListenerImpl implements ExplorerRecyclerAdapter.OnItemClickListener {

        @Override
        public void onItemClick(FileInfo item, int position) {
            presenter.handleFileClick("/" + item.getFileName(), position);
        }

        @Override
        public void onItemLongClick(FileInfo item, int position) {
            imgDeleteSelected.setVisibility(View.VISIBLE);
            imgChangeLayout.setVisibility(View.GONE);
            presenter.handleFileLongClick("/" + item.getFileName(), position);
        }
    }

    @Override
    public void onBackPressed() {
        imgDeleteSelected.setVisibility(View.GONE);
        imgChangeLayout.setVisibility(View.VISIBLE);
        presenter.handleFileClick(null, -1);
    }
}
