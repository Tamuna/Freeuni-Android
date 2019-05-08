package ge.edu.freeuni.asignment3.ui.navigation.recycler;

/*
 * created by tgeldiashvili on 5/8/2019
 */

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ge.edu.freeuni.asignment3.R;
import ge.edu.freeuni.asignment3.model.FileInfo;

public class ExplorerGridViewHolder extends ExplorerViewHolder {
    private TextView tvTitle;
    private ImageView imgIcon;

    public ExplorerGridViewHolder(@NonNull View itemView) {
        super(itemView);
        tvTitle = itemView.findViewById(R.id.tv_title_grid);
        imgIcon = itemView.findViewById(R.id.img_icon_grid);
    }

    public void setData(final FileInfo fileInfo, final ExplorerRecyclerAdapter.OnItemClickListener onItemClicnkListener) {
        tvTitle.setText(fileInfo.getFileName());
        imgIcon.setImageResource(fileInfo.getType());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClicnkListener.onItemClick(fileInfo);
            }
        });
    }
}
