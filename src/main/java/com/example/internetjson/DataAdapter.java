package com.example.internetjson;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<PersonInfo> items;
    ItemClickListener listener;
    public DataAdapter(List<PersonInfo> items,ItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_data,parent, false);
        return new ItemViewHolder(cardView);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PersonInfo personInfo = items.get(position);
        ItemViewHolder viewHolder = (ItemViewHolder) holder;
//        viewHolder.avatarView.setImageBitmap();
        viewHolder.nameView.setText(personInfo.getName());
        viewHolder.phoneView.setText(personInfo.getPhone());
        viewHolder.emailView.setText(personInfo.getEmail());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        ImageView avatarView;
        TextView nameView;
        TextView emailView;
        TextView phoneView;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            avatarView = itemView.findViewById(R.id.imageView);
            nameView = itemView.findViewById(R.id.textView);
            emailView = itemView.findViewById(R.id.textView2);
            phoneView = itemView.findViewById(R.id.textView3);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null)
                        listener.OnItemClick(position);
                }
            });
        }

    }
}
