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

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {
    private static final String TAG = "MessageAdapter";

    private List<Message> messageList;
    private Context context;

    public MessageAdapter(Context context, List<Message> messageList) {
        this.messageList = messageList;
        this.context = context;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder");
        View view = LayoutInflater.from(this.context).inflate(R.layout.message, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        Message message = this.messageList.get(position);
        holder.getTextViewMessage().setText(message.getContent());
    }

    @Override
    public int getItemCount() {
        return this.messageList.size();
    }

    public void updateList(List<Message> newList) {
        newList = this.messageList;
    }


    public class MessageViewHolder extends RecyclerView.ViewHolder {
        private final View parentLayout;
        private TextView textViewMessage;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textViewMessage = itemView.findViewById(R.id.textViewMessage);
            this.parentLayout = itemView.findViewById(R.id.parentLayout2);
        }


        public TextView getTextViewMessage() {
            return textViewMessage;
        }


        public View getParentLayout() {
            return parentLayout;
        }

    }
}

