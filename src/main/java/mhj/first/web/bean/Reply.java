package mhj.first.web.bean;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reply {
    Employee employee;
    BigInteger id;
    Integer topicId;
    Integer replyEmpId;
    String content;
    Date createTime;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getReplyEmpId() {
        return replyEmpId;
    }

    public void setReplyEmpId(Integer replyEmpId) {
        this.replyEmpId = replyEmpId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(this.createTime);
        return date;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
