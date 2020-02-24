package com.example.cermati_test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cermati_test.Model.User;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<User> userPreferences;


    public RecyclerViewAdapter(List<User> userPreferences) {
        this.userPreferences = userPreferences;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.user_recycler_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picasso.get().load(userPreferences.get(position).getAvatar_url()).into(holder.userImage);
        holder.userName.setText(userPreferences.get(position).getLogin());
    }



    @Override
    public int getItemCount() {
        return userPreferences.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.userImage)
        ImageView userImage;
        @BindView(R.id.userName)
        TextView userName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
}
