package mhj.first.web.service;

import mhj.first.web.bean.Reply;
import mhj.first.web.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {
    @Autowired
    ReplyMapper replyMapper;
    public List<Reply> getReplies(Integer id) {
        return replyMapper.getReplies(id);
    }

    public int getRepliesNum(Integer id) {
        return replyMapper.getRepliesNum(id);
    }

    public boolean add(Reply reply) {
        return replyMapper.add(reply)>0;
    }
}
