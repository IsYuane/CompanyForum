package mhj.first.web.mapper;

import mhj.first.web.bean.Reply;

import java.util.List;

public interface ReplyMapper {
    List<Reply> getReplies(Integer id);

    int getRepliesNum(Integer id);

    int add(Reply reply);
}
