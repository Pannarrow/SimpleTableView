package com.pan.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SimpleTableView tableView = findViewById(R.id.table_view);
        tableView.setTitles("标题1", "标题2")
                .setFirstPaddingLeft(27)
                .setSecondPaddingLeft(57)
                .setTextSize(36)
                .setBorderRadius(18)
                .setBorderColor(Color.parseColor("#cecece"))
                .setCursorDrawable(getDrawable(R.drawable.edit_cursor_bg))
                .refresh();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}