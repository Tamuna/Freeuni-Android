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

public class ExplorerListViewHolder extends ExplorerViewHolder {
    private ImageView imgIcon;
    private TextView tvTitle;
    private TextView tvSize;
    private TextView tvCreateTime;

    public ExplorerListViewHolder(@NonNull View itemView) {
        super(itemView);
        imgIcon = itemView.findViewById(R.id.img_icon_list);
        tvTitle = itemView.findViewById(R.id.tv_title_list);
        tvSize = itemView.findViewById(R.id.tv_size);
        tvCreateTime = itemView.findViewById(R.id.tv_create_date);
    }

    public void setData(final FileInfo fileInfo, final ExplorerRecyclerAdapter.OnItemClickListener onItemClickListener, boolean contains) {
        tvTitle.setText(fileInfo.getFileName());
        imgIcon.setImageResource(fileInfo.getType());
        tvSize.setText(fileInfo.getSize());
        tvCreateTime.setText(fileInfo.getCreateDate());
        if (contains) {
            itemView.setBackgroundColor(Color.parseColor("#978BC34A"));
        } else {
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
