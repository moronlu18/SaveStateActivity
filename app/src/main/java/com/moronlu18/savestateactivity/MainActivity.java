package com.moronlu18.savestateactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private AnswerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lstTask);
        adapter = new AnswerAdapter(this);
        listView.setAdapter(adapter);
        initialiceAnswer();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("answerPosition", adapter.answerPosition);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        adapter.answerPosition = savedInstanceState.getInt("answerPosition");
        adapter.setAnswer();

    }


    /**
     * Método que inicializa la lista con tareas
     */
    private void initialiceAnswer() {
        adapter.add(new Answer(true,  "Opcion A"));
        adapter.add(new Answer(false, "Opcion B"));
        adapter.add(new Answer(false, "Opcion C"));
        adapter.add(new Answer(false, "Opción D"));
        adapter.add(new Answer(false, "Opción E"));
        adapter.add(new Answer(false, "Opción F"));
    }
}
