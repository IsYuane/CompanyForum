package mhj.first.web.bean;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class Employee implements Serializable {
    private Integer empId;
    @Pattern(regexp = "(^[a-zA-Z0-9_-]{6,16})|(^[\\u2E80-\\u9FFF]{2,5})",message = "用户名只能是6到16位英文或者2到5位中文")
    private String empName;

    private String userName;

    private String password;

    private Integer level;

    private String gender;
    @Pattern(regexp = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$",message = "邮箱格式错误")
    private String email;

    private Integer dId;

    private Department department;

    public Employee() {
    }


    public Employee(Integer empId, String empName, String userName, String password, Integer level, String gender, String email, Integer dId, Department department) {
        this.empId = empId;
        this.empName = empName;
        this.userName = userName;
        this.password = password;
        this.level = level;
        this.gender = gender;
        this.email = email;
        this.dId = dId;
        this.department = department;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    private static final long serialVersionUID = 1L;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", empId=").append(empId);
        sb.append(", empName=").append(empName);
        sb.append(", gender=").append(gender);
        sb.append(", email=").append(email);
        sb.append(", dId=").append(dId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}