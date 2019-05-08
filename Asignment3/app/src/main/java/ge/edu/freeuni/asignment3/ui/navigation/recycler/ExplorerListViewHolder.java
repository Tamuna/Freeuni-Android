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

    public void setData(FileInfo fileInfo, ExplorerRecyclerAdapter.OnItemClickListener onItemClickListener) {
        tvTitle.setText(fileInfo.getFileName());
        imgIcon.setImageResource(fileInfo.getType());
        tvSize.setText(String.format("%d", fileInfo.getSize()));
        tvCreateTime.setText(fileInfo.getCreateDate());
    }
}
