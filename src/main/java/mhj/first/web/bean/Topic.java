package mhj.first.web.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Topic {
    private Integer id;
    private Integer empId;
    private String title;
    private String content;
    private Integer countReplies;
    private Date createTime;
    private Integer tabId;
    private Integer click;
    private Employee employee;
    private Tab tab;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Tab getTab() {
        return tab;
    }

    public void setTab(Tab tab) {
        this.tab = tab;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCountReplies() {
        return countReplies;
    }

    public void setCountReplies(Integer countReplies) {
        this.countReplies = countReplies;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getTabId() {
        return tabId;
    }

    public void setTabId(Integer tabId) {
        this.tabId = tabId;
    }

    public String getLocalCreateTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
        String date =simpleDateFormat.format(this.createTime);
        return date;
    }
}
