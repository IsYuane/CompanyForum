package mhj.first.web.service;

import mhj.first.web.bean.Employee;
import mhj.first.web.bean.EmployeeExample;
import mhj.first.web.bean.Msg;
import mhj.first.web.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;



    /**
     * 员工查询
     * @return
     */
    public List<Employee> getAll(){
        return employeeMapper.selectByExampleWithDept(null);
    }

    /**
     * 员工保存
     * @param employee
     */
    public void saveEmp(Employee employee) {
//        自增不用写id
        employeeMapper.insertSelective(employee);
    }
//检验用户名唯一性
    public boolean checkUser(String empName) {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmpNameEqualTo(empName);
        long count = employeeMapper.countByExample(example);
        return count == 0;
    }

    public Employee getEmp(Integer id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    /**
     * 员工更新
     * @param employee
     */
    public void updateEmp(Employee employee) {
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public void deleteEmp(Integer id) {
        employeeMapper.deleteByPrimaryKey(id);
    }

    public void deleteBatch(List<Integer> list) {
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andEmpIdIn(list);
        employeeMapper.deleteByExample(employeeExample);
    }

    public Msg login(String userName, String password, HttpSession session) {
        Employee employee =employeeMapper.getUser(userName,password);
        Assert.notNull(employee,"用户或密码错误");
        session.setAttribute("employee",employee);
        return Msg.success();
    }
}
