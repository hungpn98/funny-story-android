package com.hungpn.funnystories;

import com.hungpn.funnystories.title.Title;
import com.hungpn.funnystories.topic.Topic;

public interface ITitle {
    Title getTitle(int position);
    int getSize();
    void onClick(int position);
}
