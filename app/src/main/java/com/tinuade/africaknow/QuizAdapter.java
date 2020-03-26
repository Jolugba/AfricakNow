package com.tinuade.africaknow;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tinuade.africaknow.Model.Answer;
import com.tinuade.africaknow.Model.Question;

import java.util.List;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.QuizViewHolder> {

    public static boolean answerValue = false;
    public static boolean isOptionSelected = false;

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

        //set value for each option
        holder.option1Value = answers.get(0).getValue();
        holder.option2Value = answers.get(1).getValue();
        holder.option3Value = answers.get(2).getValue();
        holder.option4Value = answers.get(3).getValue();
    }

    @Override
    public int getItemCount() {
        return mQuestionList.size();
    }

    static class QuizViewHolder extends RecyclerView.ViewHolder {
        TextView question, option1, option2, option3, option4;
        boolean option1Value, option2Value, option3Value, option4Value;

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
                answerValue = option1Value;
                isOptionSelected = true;
            });
            option2.setOnClickListener(view -> {
                if (!option2.isSelected()) {
                    option2.setSelected(true);
                    option1.setSelected(false);
                    option3.setSelected(false);
                    option4.setSelected(false);
                }
                answerValue = option2Value;
                isOptionSelected = true;
            });
            option3.setOnClickListener(view -> {
                if (!option3.isSelected()) {
                    option3.setSelected(true);
                    option1.setSelected(false);
                    option2.setSelected(false);
                    option4.setSelected(false);

                }
                answerValue = option3Value;
                isOptionSelected = true;
            });
            option4.setOnClickListener(view -> {
                if (!option4.isSelected()) {
                    option4.setSelected(true);
                    option1.setSelected(false);
                    option2.setSelected(false);
                    option3.setSelected(false);
                }
                answerValue = option4Value;
                isOptionSelected = true;
            });
        }
    }
}
