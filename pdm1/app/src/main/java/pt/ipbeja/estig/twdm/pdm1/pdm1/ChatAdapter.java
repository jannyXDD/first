package pt.ipbeja.estig.twdm.pdm1.pdm1;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder>{
    private static final String TAG = "BookAdapter";

    private List<Chat> chatList;
    private Context context;

    public ChatAdapter(Context context, List<Chat> chatList){
        this.chatList = chatList;
        this.context = context;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder");
        View view = LayoutInflater.from(this.context).inflate(R.layout.list_item, parent, false);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        Chat chat = this.chatList.get(position);
        holder.getTextViewName().setText(chat.getName());
        holder.getTextViewDesc().setText(chat.getMessage());
        holder.getParentLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("RecyclerViewAdapter", String.format("Clicked on: %s (position %d)", chat.getName(), position));

                DetailsActivity.startActivity(ChatAdapter.this.context, chat.getId());
            }
     });
    }

    @Override
    public int getItemCount() {
        return this.chatList.size();
    }


    public class ChatViewHolder extends RecyclerView.ViewHolder{
        private final View parentLayout;
        private ImageView imageViewCover;
        private TextView textViewName;
        private TextView textViewDesc;

        public ChatViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textViewName = itemView.findViewById(R.id.textViewNameMain);
            this.textViewDesc = itemView.findViewById(R.id.textViewLastMessage);
            this.parentLayout = itemView.findViewById(R.id.parentLayout);
        }

        public ImageView getImageViewCover() {
            return imageViewCover;
        }

        public TextView getTextViewName() {
            return textViewName;
        }

        public TextView getTextViewDesc() {
            return textViewDesc;
        }

        public View getParentLayout() {
            return parentLayout;
        }

    }
}
