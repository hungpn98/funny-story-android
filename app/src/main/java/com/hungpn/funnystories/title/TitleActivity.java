package com.hungpn.funnystories.title;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.hungpn.funnystories.ITitle;
import com.hungpn.funnystories.ManagerSql;
import com.hungpn.funnystories.R;
import com.hungpn.funnystories.story.StoryActivity;

import java.util.List;

public class TitleActivity extends AppCompatActivity implements ITitle {
    private ManagerSql managerSql;
    RecyclerView rc;
    List<Title> titles;
    TextView tvTopic;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
        managerSql = new ManagerSql(this);

        int id = getIntent().getIntExtra("ID",0);
        String nameTopic = getIntent().getStringExtra("TOPICNAME" );
        titles = managerSql.getAllTitle(id);
        rc = findViewById(R.id.rc_title);
        tvTopic = findViewById(R.id.tv_topic);
        tvTopic.setText(nameTopic + "");
        rc.setLayoutManager(new LinearLayoutManager(this));
        rc.setAdapter(new TitleAdapter(this));
    }

    @Override
    public Title getTitle(int position) {
        return titles.get(position);
    }

    @Override
    public int getSize() {
        return titles.size();
    }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent();
        intent.setClass(this, StoryActivity.class);
        intent.putExtra("IDStory", titles.get(position).getIdStory());
        startActivity(intent);
    }
}
