package mhj.first.web.controller;

import mhj.first.web.bean.*;
import mhj.first.web.exception.file.FileException;
import mhj.first.web.service.ReplyService;
import mhj.first.web.service.TabService;
import mhj.first.web.service.TopicService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class TopicController {

    @Autowired
    TopicService topicService;
    @Autowired
    TabService tabService;
    @Autowired
    ReplyService replyService;
    private final Log log = LogFactory.getLog(getClass());
    @RequestMapping("/topic")
    public ModelAndView forum(HttpSession session) throws FileException {
        ModelAndView view ;
        Employee employee = (Employee) session.getAttribute("employee");
        if(employee==null){
            return new ModelAndView("pleaselogin");
        }else {
            view = new ModelAndView("cate");
        }

        List<Topic> topics = topicService.getTopics();
        view.addObject("topics",topics);
        view.addObject("employee",employee);
        return view;
    }
    @RequestMapping("/new")
    public ModelAndView newTopic(){
        ModelAndView view = new ModelAndView("new");
        List<Tab> tabs = tabService.getTabs();
        view.addObject("tabs",tabs);
        return view;
    }

    @RequestMapping("/topic/{tabNameEn}")
    public ModelAndView toTabTopic(@PathVariable("tabNameEn")String tabNameEn , HttpSession session){
        Tab tab = tabService.get(tabNameEn);
        Integer tabId = tab.getId();
        ModelAndView modelAndView =new ModelAndView("cate");
        List<Topic> topitcs = topicService.getTopicsOfTab(tabId);
        Employee employee = (Employee) session.getAttribute("employee");
        if(employee==null){
            return new ModelAndView("pleaselogin");
        }else {
            modelAndView.addObject("topics",topitcs);
            modelAndView.addObject("employee",employee);
            modelAndView.addObject("tab",tab);
            return modelAndView;
        }
    }
    @RequestMapping(value = "/topic/add" ,method = RequestMethod.POST)
    public ModelAndView addTopic(HttpServletRequest request , HttpSession session){
        ModelAndView view ;
        Employee employee = (Employee) session.getAttribute("employee");
        if(employee==null){
            return new ModelAndView("pleaselogin");
        }else {
            view = new ModelAndView("redirect:/topic");
        }
        Integer empId = employee.getEmpId();
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        //String不能直接转Int 强制转换是从范围小的转成范围大的
        Integer tabId =Integer.parseInt(request.getParameter("tab"));
        Topic topic =new Topic();
        topic.setEmpId(empId);
        topic.setContent(content);
        topic.setTitle(title);
        topic.setTabId(tabId);
        topic.setCreateTime(new Date());
        boolean ifSucc = topicService.addTopic(topic);
        if (ifSucc){
            if(log.isInfoEnabled()){
                log.info("添加主题成功");
            }
        }
        return view;
    }

    @RequestMapping("/t/{id}")
    public ModelAndView toTopic(@PathVariable("id") Integer id, HttpSession session){
        ModelAndView modelAndView=new ModelAndView("detail");
        Topic topic =topicService.getTopic(id);
        //获取该主题的评论
        List<Reply> replies = replyService.getReplies(id);
        //获取评论数
        int repliesNum = replyService.getRepliesNum(id);
        Employee employee = (Employee) session.getAttribute("employee");
        modelAndView.addObject("topic",topic);
        modelAndView.addObject("replies",replies);
        modelAndView.addObject("employee",employee);
        return modelAndView;
    }
    @RequestMapping("/1")
    @ResponseBody
    public Msg test(){
        Topic topic =topicService.getTopic(1);
        return Msg.success().add("1",topic);
    }
}