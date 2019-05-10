package ge.edu.freeuni.asignment3.ui.explorer;

/*
 * created by tgeldiashvili on 5/8/2019
 */

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ge.edu.freeuni.asignment3.model.FileInfo;

public abstract class ExplorerViewHolder extends RecyclerView.ViewHolder {
    public ExplorerViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract void setData(FileInfo fileInfo, ExplorerRecyclerAdapter.OnItemClickListener onItemClickListener);
}
