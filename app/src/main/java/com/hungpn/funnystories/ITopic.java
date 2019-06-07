package com.hungpn.funnystories;

import com.hungpn.funnystories.topic.Topic;

public interface ITopic {
    Topic getTopic(int position);
    int getSize();
    void onClick(int position);
}
