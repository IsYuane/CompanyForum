package mhj.first.web.service;

import mhj.first.web.bean.Topic;
import mhj.first.web.mapper.TopicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    TopicMapper topicMapper;

    public boolean addTopic(Topic topic) {
        return topicMapper.addTopic(topic)>0;
    }

    public List<Topic> getTopics() {
        return topicMapper.getTopics();
    }

    public Topic getTopic(Integer id) {
        return topicMapper.getTopic(id);
    }

    public List<Topic> getTopicsOfTab(Integer tabId) {
        return topicMapper.getTopicsOfTab(tabId);
    }
}
