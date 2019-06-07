package com.hungpn.funnystories.story;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.hungpn.funnystories.ManagerSql;
import com.hungpn.funnystories.R;

public class StoryActivity extends AppCompatActivity {
    ManagerSql managerSql;
    Story story;
    TextView tvTitle;
    TextView tvDetail;
    String name;
    String detail;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        managerSql = new ManagerSql(this);
        int id = getIntent().getIntExtra("IDStory", 0);
        story = managerSql.getStory(id);
        tvTitle = findViewById(R.id.tv_name_story);
        tvDetail = findViewById(R.id.tv_detail);
        inits();


    }
    private void inits(){
        name = story.getName();
        detail = story.getDetail();
        tvTitle.setText(name);
        tvDetail.setText(android.text.Html.fromHtml(detail));
    }

}
