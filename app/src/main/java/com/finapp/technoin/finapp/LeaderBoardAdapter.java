package com.finapp.technoin.finapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.finapp.technoin.finapp.domain.LeaderBoard;

public class LeaderBoardAdapter extends RecyclerView.Adapter<LeaderBoardAdapter.LeaderBoardViewHolder> {

    private LeaderBoard[] data;
    private Context context;

    public LeaderBoardAdapter(LeaderBoard[] data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public LeaderBoardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.leaderboard_item_list,viewGroup,false);
        return new LeaderBoardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderBoardViewHolder leaderBoardViewHolder, int i) {
        LeaderBoard text = data[i];
        leaderBoardViewHolder.textView.setText(text.getName());
        leaderBoardViewHolder.userScore.setText(text.getScore().toString());
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class LeaderBoardViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        TextView userScore;
        public LeaderBoardViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.listtext);
            imageView = itemView.findViewById(R.id.listimage);
            userScore = itemView.findViewById(R.id.userscore);
        }
    }
}
