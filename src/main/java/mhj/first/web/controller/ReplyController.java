package mhj.first.web.controller;

import mhj.first.web.bean.Reply;
import mhj.first.web.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class ReplyController {

    @Autowired
    ReplyService replyService;

    @RequestMapping(value = "/reply",method = RequestMethod.POST)
    public ModelAndView reply(HttpServletRequest request , HttpSession session){
        Integer topicId = Integer.valueOf(request.getParameter("topicId"));
        Integer replyEmpId = Integer.valueOf(request.getParameter("replyEmpId"));
        String content = request.getParameter("content");
        Reply reply= new Reply();
        reply.setContent(content);
        reply.setCreateTime(new Date());
        reply.setReplyEmpId(replyEmpId);
        reply.setTopicId(topicId);
        boolean ifreply=replyService.add(reply);
        ModelAndView modelAndView = new ModelAndView("redirect:/t/"+topicId);
        return modelAndView;
    }
}
