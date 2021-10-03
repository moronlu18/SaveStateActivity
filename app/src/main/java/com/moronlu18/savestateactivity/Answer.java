package com.moronlu18.savestateactivity;

import java.io.Serializable;

public class Answer implements Serializable {
    private boolean selection;
    private String text;

    public Answer(boolean selection, String text) {
        this.selection = selection;
        this.text = text;
    }

    public void setSelection(boolean selection) {
        this.selection = selection;
    }

    public boolean isSelection() {
        return selection;
    }

    public String getText() {
        return text;
    }

}