package test;

import mhj.first.web.bean.Department;
import mhj.first.web.bean.Employee;
import mhj.first.web.mapper.DepartmentMapper;
import mhj.first.web.mapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * 测试dao层工作
 * @author mhj
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class MapperTest {

//    @Autowired
//    DepartmentMapper departmentMapper;
//
//    @Autowired
//    EmployeeMapper employeeMapper;
//
//    @Autowired
//    SqlSession sqlSession;
    /**
     * 测试DepartmentMapper
     */
    @Test
    public void testMhj(){
//        //1、创建SpringIOC容器
//        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-mybatis-config.xml");
//        //2、从容器中获取mapper
//        DepartmentMapper departmentMapper = ioc.getBean(DepartmentMapper.class);
//        System.out.println(departmentMapper);
//        departmentMapper.insertSelective(new Department(null,"开发部"));
//          employeeMapper.insertSelective(new Employee(null,"jerry","M","jerry@mhj.com",1));

//            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//            for(int i = 10;i<20;i++){
//                String uid = UUID.randomUUID().toString().substring(0,5)+i;
//                mapper.insertSelective(new Employee(null,uid,"M",uid+"@mhj.com",1));
//            }
        String a="cvte欢迎你";
        System.out.print(a.length());
    }
}
