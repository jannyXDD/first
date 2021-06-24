package pt.ipbeja.estig.twdm.pdm1.pdm1;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder>{
    private static final String TAG = "BookAdapter";

    private List<Chat> chatList;
    private Context context;

    public ChatAdapter(Context context){
        this.chatList = new ArrayList<>();
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
        // TODO obter a ultima mensagem do chat
        holder.getTextViewDesc().setText(chat.getLastMessage());
        holder.getParentLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("RecyclerViewAdapter", String.format("Clicked on: %s (position %d)", chat.getName(), position));

                DetailsActivity.startActivity(ChatAdapter.this.context, chat.getId());
            }
     });
        holder.getParentLayout().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.i("RecyclerViewAdapter", String.format("Clicked on: %s (position %d)", chat.getName(), position));
                AlertDialog.Builder builder = new AlertDialog.Builder(ChatAdapter.this.context);
                builder.setTitle("Eliminar Chat");
                builder.setMessage("Tem a certeza que deseja eliminar o chat de " + chat.getName() + "?");
                builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AppDataBase.getInstance(ChatAdapter.this.context).getChatDao().delete(chat);
                        chatList.remove(chat);
                        notifyDataSetChanged();

                        // updateList(AppDatabase.getInstance(ItemsAdapter.this.context).getItemDao().getAll());
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.chatList.size();
    }

    public void updateList(List<Chat> newList) {
        this.chatList = newList;
        notifyDataSetChanged();
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
