package ge.edu.freeuni.asignment3.ui.explorer;

/*
 * created by tgeldiashvili on 5/8/2019
 */

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
    private List<FileInfo> data = new ArrayList<>();
    private static boolean isListLayout = false;
    private OnItemClickListener onItemClickListener;
    private List<Integer> highlights = new ArrayList<>();

    public interface OnItemClickListener {
        void onItemClick(FileInfo item, int position);

        void onItemLongClick(FileInfo item, int position);
    }

    public ExplorerRecyclerAdapter(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setData(List<FileInfo> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ExplorerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (isListLayout) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_list_file, parent, false);
            return new ExplorerListViewHolder(view);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_grid_file, parent, false);
            return new ExplorerGridViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ExplorerViewHolder holder, int position) {
        holder.setData(data.get(position), onItemClickListener, highlights.contains(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setListLayout(boolean listLayout) {
        isListLayout = listLayout;
        notifyDataSetChanged();
    }

    public void highlight(int position) {
        highlights.add(position);
        notifyItemChanged(position);
    }

    public void unhighlight(int position) {
        highlights.remove((Integer) position);
        notifyItemChanged(position);
    }

    public void unhighlightAll() {
        for (Integer i : highlights) {
            notifyItemChanged(i);
        }
        highlights.clear();
    }
}
