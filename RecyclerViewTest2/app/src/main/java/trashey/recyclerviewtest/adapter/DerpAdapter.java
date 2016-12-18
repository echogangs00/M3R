package trashey.recyclerviewtest.adapter;


import android.content.Context;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import trashey.recyclerviewtest.R;
import trashey.recyclerviewtest.model.ListItem;

public class DerpAdapter extends RecyclerView.Adapter<DerpAdapter.DerpHolder>  {

    private List<ListItem> listData;
    private LayoutInflater inflater;

    private ItemClickCallback itemClickCallback;

    public interface ItemClickCallback {
        void onItemClick(int p);
        void onSecondaryIconClick(int p);
    }

    public void setItemClickCallback(final ItemClickCallback itemClickCallback){
        this.itemClickCallback = itemClickCallback;
    }

    public DerpAdapter(List<ListItem> listData, Context c){
        inflater = LayoutInflater.from(c);
        this.listData = listData;
    }


    @Override
    public DerpHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater .inflate(R.layout.list_item,parent,false);
        return new DerpHolder(view) ;
    }

    @Override
    public void onBindViewHolder(DerpHolder holder, int position) {
        ListItem item = listData.get(position);
        holder.title.setText(item.getTitle());
        holder.subTitle.setText(item.getSubTitle());
        if(item.isFavourite()){
            holder.secondaryicon.setImageResource(R.drawable.ic_star_black_24dp);
        }else {
            holder.secondaryicon.setImageResource(R.drawable.ic_star_border_black_24dp);
        }
    }

    public void setListData(ArrayList<ListItem> exerciseList){
        this.listData.clear();
        this.listData.addAll(exerciseList);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class DerpHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView title;
        private TextView subTitle;
        private ImageView thumbnail;
        private ImageView secondaryicon;
        private View container;

        public DerpHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.lbl_item_text);
            subTitle = (TextView) itemView.findViewById(R.id.lbl_item_sub_title);
            thumbnail = (ImageView) itemView.findViewById(R.id.im_item_icon);
            secondaryicon = (ImageView) itemView.findViewById(R.id.im_item_icon_secondary);
            secondaryicon.setOnClickListener(this);
            container = itemView.findViewById(R.id.cont_item_root);
            container.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.cont_item_root){
                itemClickCallback.onItemClick(getAdapterPosition());
            }else{
                itemClickCallback.onSecondaryIconClick(getAdapterPosition());
            }
        }
    }
}
