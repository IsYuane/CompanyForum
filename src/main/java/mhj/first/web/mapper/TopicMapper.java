package mhj.first.web.mapper;

import mhj.first.web.bean.Topic;

import java.util.List;

public interface TopicMapper {
    List<Topic> getTopics();

    Integer addTopic(Topic topic);

    Topic getTopic(Integer id);

    List<Topic> getTopicsOfTab(Integer tabId);
}
