package ge.edu.freeuni.asignment3.ui.navigation.recycler;

/*
 * created by tgeldiashvili on 5/8/2019
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ge.edu.freeuni.asignment3.R;
import ge.edu.freeuni.asignment3.model.FileInfo;

public class ExplorerRecyclerAdapter extends RecyclerView.Adapter<ExplorerViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(FileInfo item);
    }

    public ExplorerRecyclerAdapter(Context context, OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setData(List<FileInfo> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }


    private List<FileInfo> data = new ArrayList<>();
    private boolean isListLayout = false;
    private OnItemClickListener onItemClickListener;

    @NonNull
    @Override
    public ExplorerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (isListLayout) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_list_file, null);
            return new ExplorerListViewHolder(view);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_grid_file, null);
            return new ExplorerGridViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ExplorerViewHolder holder, int position) {
        holder.setData(data.get(position), onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setListLayout(boolean isListLayout) {
        this.isListLayout = isListLayout;
        notifyDataSetChanged();
    }
}
