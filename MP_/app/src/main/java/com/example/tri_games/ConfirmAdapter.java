package com.example.tri_games;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Vector;

public class ConfirmAdapter extends RecyclerView.Adapter<ConfirmAdapter.ConfirmViewHolder> {


    Activity activity;

    public Vector<CartModel> vector = new Vector<CartModel>();

    public ConfirmAdapter(Activity activity){
        this.activity = activity;
        this.vector = Cart.vector;
    }



    public class ConfirmViewHolder extends RecyclerView.ViewHolder {

        TextView user, game, score;
        public ConfirmViewHolder(@NonNull View itemView) {
            super(itemView);

            user = itemView.findViewById(R.id.t1);
            game = itemView.findViewById(R.id.t2);
            score = itemView.findViewById(R.id.t3);
            }
        }


    @NonNull
    @Override
    public ConfirmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.orderrow, parent, false);
        ConfirmViewHolder confirmViewHolder = new ConfirmViewHolder(view);
        return confirmViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ConfirmViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.user.setText(vector.get(position).getUser());
        holder.game.setText(vector.get(position).getGame());
        holder.score.setText(vector.get(position).getScore());

    }

    @Override
    public int getItemCount() {
        return vector.size();
    }


}
