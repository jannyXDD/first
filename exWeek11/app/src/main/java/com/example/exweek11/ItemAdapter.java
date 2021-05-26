package com.example.exweek11;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private static final String TAG = "ItemAdapter";

    private List<Item> itemList;
    private Context context;

    public ItemAdapter(Context context, List<Item> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder");
        View view = LayoutInflater.from(this.context).inflate(R.layout.list_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = this.itemList.get(position);
        TextView textViewName = holder.getTextViewName();
        textViewName.setText(item.getTitle() + " " + item.getId());
        TextView textViewDesc = holder.getTextViewDesc();
        textViewDesc.setText(item.getDescription() + " " + item.getId());
        CheckBox checkBox = holder.getCheckBox();
        checkBox.setChecked(item.isCompleted());

        holder.getParentLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("RecyclerViewAdapter", String.format("Clicked on: %s (position %d)", item.getTitle(), position));

                DetailsActivity.startActivity(ItemAdapter.this.context, item.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    public void updateList(List<Item> itemList) {
        this.itemList = itemList;
        this.notifyDataSetChanged();
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private View parentLayout;
        private TextView textViewName;
        private TextView textViewDesc;
        private CheckBox checkBox;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            this.parentLayout = itemView.findViewById(R.id.parentLayout);
            this.textViewName = itemView.findViewById(R.id.textViewName);
            this.textViewDesc = itemView.findViewById(R.id.textViewDesc);
            this.checkBox = itemView.findViewById(R.id.checkBox);
        }


        public TextView getTextViewName() {
            return textViewName;
        }

        public TextView getTextViewDesc() {
            return textViewDesc;
        }

        public CheckBox getCheckBox() {
            return checkBox;
        }

        public View getParentLayout() {
            return parentLayout;
        }
    }
}
