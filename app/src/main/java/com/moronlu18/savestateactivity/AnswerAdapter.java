package com.moronlu18.savestateactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;


public class AnswerAdapter extends ArrayAdapter<Answer> {
    private Context context;
    int answerPosition = 0;

    public AnswerAdapter(Context context) {
        super(context, R.layout.item_task);
        this.context=context;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final AnswerHolder answerHolder;
        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.item_task, null);
            answerHolder=new AnswerHolder();
            answerHolder.rdAnswer=  convertView.findViewById(R.id.rdAnswer);
            answerHolder.txvAnswer=convertView.findViewById(R.id.txvAnswer);
            convertView.setTag(answerHolder);

        }
        else{
            answerHolder=(AnswerHolder)convertView.getTag();
        }
        answerHolder.txvAnswer.setText(getItem(position).getText());
        answerHolder.rdAnswer.setChecked(position == answerPosition);

        answerHolder.rdAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerPosition = position;
                getItem(position).setSelection(!getItem(position).isSelection());
                notifyDataSetChanged();
            }
        });
        return convertView;
    }

    public void setAnswer() {
        getItem(answerPosition).setSelection(!getItem(answerPosition).isSelection());
        notifyDataSetChanged();
    }

    class AnswerHolder{
        RadioButton rdAnswer;
        TextView txvAnswer;

    }
}
