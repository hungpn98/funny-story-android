package com.hungpn.funnystories.topic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.hungpn.funnystories.ITopic;
import com.hungpn.funnystories.ManagerSql;
import com.hungpn.funnystories.R;
import com.hungpn.funnystories.title.TitleActivity;
import com.hungpn.funnystories.title.TitleAdapter;

import java.util.List;

public class TopicActivity extends AppCompatActivity implements ITopic {
    private ManagerSql managerSql;
    private RecyclerView rc;
    private List<Topic> topics;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        managerSql = new ManagerSql(this);
        topics = managerSql.getAllTopic();
        rc = findViewById(R.id.rc);
        rc.setLayoutManager( new LinearLayoutManager(this));
        rc.setAdapter( new TopicAdapter(this));

    }

    @Override
    public Topic getTopic(int position) {
        return topics.get(position);
    }

    @Override
    public int getSize() {
        return topics.size();
    }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent();
        intent.setClass(this, TitleActivity.class);
        intent.putExtra("ID", topics.get(position).getId());
        intent.putExtra("TOPICNAME", topics.get(position).getName());
        startActivity(intent);
    }
}
