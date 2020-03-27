package com.tinuade.africaknow.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tinuade.africaknow.Model.HighScore;
import com.tinuade.africaknow.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HighScoreAdapter extends RecyclerView.Adapter<HighScoreAdapter.HighScoreViewHolder> {

    private List<HighScore> mScoreList;

    public HighScoreAdapter(List<HighScore> scoreList) {
        mScoreList = scoreList;
    }

    @NonNull
    @Override
    public HighScoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HighScoreViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.high_score_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HighScoreViewHolder holder, int position) {
        holder.name.setText(mScoreList.get(position).getName());
        holder.score.setText(String.valueOf(mScoreList.get(position).getScore()));
    }

    @Override
    public int getItemCount() {
        return mScoreList.size();
    }

    static class HighScoreViewHolder extends RecyclerView.ViewHolder {
        TextView name, score;

        HighScoreViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.fullName_text);
            score = itemView.findViewById(R.id.highest_score_text);
        }
    }
}
