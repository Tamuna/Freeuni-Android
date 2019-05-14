package ge.edu.freeuni.asignment3.ui.explorer;

/*
 * created by tgeldiashvili on 5/8/2019
 */

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

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

    public void setData(final FileInfo fileInfo, final ExplorerRecyclerAdapter.OnItemClickListener onItemClickListener, boolean highlighted) {
        tvTitle.setText(fileInfo.getFileName());
        imgIcon.setImageResource(fileInfo.getType());
        if (highlighted) {
            itemView.setBackgroundColor(Color.parseColor("#978BC34A"));
        }else{
            itemView.setBackgroundColor(Color.parseColor("#ffffff"));
        }
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(fileInfo, getAdapterPosition());
            }

        });
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onItemClickListener.onItemLongClick(fileInfo, getAdapterPosition());
                return true;
            }
        });
    }
}
