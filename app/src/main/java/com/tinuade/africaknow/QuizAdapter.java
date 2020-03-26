package com.tinuade.africaknow;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tinuade.africaknow.Model.Answer;
import com.tinuade.africaknow.Model.Question;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerVi
public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.QuizViewHolder> {

    private List<Question> mQuestionList;

    public QuizAdapter(List<Question> questionList) {
        mQuestionList = questionList;
    }

    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new QuizViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.question_fragment_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull QuizViewHolder holder, int position) {
        holder.question.setText(mQuestionList.get(position).getQuestion());
        List<Answer> answers = mQuestionList.get(position).getAnswers();
        holder.option1.setText(answers.get(0).getOption());
        holder.option2.setText(answers.get(1).getOption());
        holder.option3.setText(answers.get(2).getOption());
        holder.option4.setText(answers.get(3).getOption());
    }

    @Override
    public int getItemCount() {
        return mQuestionList.size();
    }

    static class QuizViewHolder extends RecyclerView.ViewHolder {
        TextView question, option1, option2, option3, option4;

        QuizViewHolder(@NonNull View itemView) {
            super(itemView);

            question = itemView.findViewById(R.id.question_textView);
            option1 = itemView.findViewById(R.id.option_1_textView);
            option2 = itemView.findViewById(R.id.option_2_textView);
            option3 = itemView.findViewById(R.id.option_3_textView);
            option4 = itemView.findViewById(R.id.option_4_textView);

            option1.setOnClickListener(view -> {
                if (!option1.isSelected()) {
                    option1.setSelected(true);
                    option2.setSelected(false);
                    option3.setSelected(false);
                    option4.setSelected(false);
                }
            });
            option2.setOnClickListener(view -> {
                if (!option2.isSelected()) {
                    option2.setSelected(true);
                    option1.setSelected(false);
                    option3.setSelected(false);
                    option4.setSelected(false);
                }
            });
            option3.setOnClickListener(view -> {
                if (!option3.isSelected()) {
                    option3.setSelected(true);
                    option1.setSelected(false);
                    option2.setSelected(false);
                    option4.setSelected(false);

                }
            });
            option4.setOnClickListener(view -> {
                if (!option4.isSelected()) {
                    option4.setSelected(true);
                    option1.setSelected(false);
                    option2.setSelected(false);
                    option3.setSelected(false);
                }
            });
        }
    }
}
