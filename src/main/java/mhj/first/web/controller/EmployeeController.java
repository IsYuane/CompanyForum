package mhj.first.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mhj.first.web.bean.Employee;
import mhj.first.web.bean.History;
import mhj.first.web.bean.Msg;
import mhj.first.web.service.EmployeeService;
import mhj.first.web.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 处理员工CRUD请求
 * URI地址约定：
 *  /emp/{id} GET 查询员工
 *  /emp POST 保存员工
 *  /emp/{id} PUT 更新员工
 *  /emp/{id} DELETE 删除员工
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    FileService fileService;
    @RequestMapping(value ="/login" ,method = RequestMethod.POST)
    @ResponseBody
    public Msg login(String userName, String password, HttpServletRequest request){
        HttpSession session = request.getSession();
        return employeeService.login(userName, password, session);
    }
    /**
     * 单个批量删除员工
     * ids 1-2-3
     */
    @RequestMapping(path = "/emp/{ids}",method = RequestMethod.DELETE)
    @ResponseBody
    public Msg deleteEmp(@PathVariable("ids") String ids){
//        批量删除
        if(ids.contains("-")){
            List<Integer> list = new ArrayList<>();
            String[] split = ids.split("-");
//            组装id的集合
            for (String string:split
                 ) {
                list.add(Integer.parseInt(string)); // Int
//                list.add(Integer.valueOf(string)); 转换为Integer
            }
            employeeService.deleteBatch(list);
        }else {
            Integer id = Integer.parseInt(ids);
            employeeService.deleteEmp(id);
        }

        return Msg.success();
    }
    /**
     * 更新员工
     */
    @RequestMapping(value = ("/emp/{empId}"),method = RequestMethod.PUT)
    @ResponseBody
    public Msg updateEmp(Employee employee){
//        System.out.print(employee);
        employeeService.updateEmp(employee);
        return Msg.success();
    }

    /**
     * 查询员工信息
     * @param id
     * @return
     */
    @RequestMapping(value="/emp/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Msg getEmp(@PathVariable("id")Integer id){
       Employee employee = employeeService.getEmp(id);
       return Msg.success().add("emp",employee);
    }
    /**
     * 检验员工姓名不重复且合法
     */
    @RequestMapping(value = "/checkUser",method = RequestMethod.POST)
    @ResponseBody
    public Msg checkUser(@RequestParam("empName")String empName){
        String regx = "(^[a-zA-Z0-9_-]{6,16})|(^[\\u2E80-\\u9FFF]{2,5})";
        if(!empName.matches(regx)){
            return Msg.fail().add("va_msg","用户名只能是6到16位英文或者2到5位中文");
        }
        boolean b = employeeService.checkUser(empName);
        if(b){
            return Msg.success();
        }else {
            return Msg.fail().add("va_msg","该用户名已存在");
        }
    }
    /**
     * 保存员工数据  进行jsr303 校验时 需要导入hibernate validator包
     */
    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    @ResponseBody
    public Msg saveEmp(@Valid Employee employee, BindingResult result){
//        校验信息之后获得的错误信息应该放在模态框上
        if(result.hasErrors()) {

            Map<String,Object> map = new HashMap<>();
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError fieldError:errors
                 ) { System.out.println("错误的字段名："+fieldError.getField());
                 System.out.print("错误信息："+fieldError.getDefaultMessage());
                 map.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return Msg.fail().add("FieldErrors",map);
        }else{
            employeeService.saveEmp(employee);
            return Msg.success();
        }

    }
    /**
     * 查询所有员工数据（分页查询）
     * @return
     */
    /**
     * 使用ResponseBody转化json字符需要导入jackson包
     * @param pn
     * @return
     */
    //path and value have same function
    @RequestMapping(path=  "emps.do", method = RequestMethod.GET)
    @ResponseBody
    public Msg getEmpsWithJson(@RequestParam(value="pn",defaultValue = "1")Integer pn){
//        分页查询需要导入相应的pagehelper包以及设置在mybatis-confg.xml设置插件plugins
//        引入PageHelper分页插件后，查询之前只需调用，传入页码，每页大小
        PageHelper.startPage(pn,5);
        //startPage紧跟的查询就是分页查询，用PageInfo对结果进行包装
        List<Employee> emps = employeeService.getAll();
        //使用pageInfo包装查询后的结果，只需要将pageInfo交给页面
        //封装了详细的分页信息，包括查询数据，连续显示5页
        PageInfo page = new PageInfo(emps,5);
        return Msg.success().add("pageInfo",page);
    }

    @RequestMapping("/emps")
    public  String getEmps(@RequestParam(value="pn",defaultValue = "1")Integer pn , Model model,HttpSession session){
//        分页查询需要导入相应的包以及设置plugin
//        这不是一个分页查询，引入PageHelper分页插件，查询之前只需调用，传入页码，每页大小
//        PageHelper.startPage(pn,5);
//        //startPage紧跟的查询就是分页查询
//        List<Employee> emps = employeeService.getAll();
//        //使用pageInfo包装查询后的结果，只需要将pageInfo交给页面
//        //封装了详细的分页信息，包括查询数据，连续显示5页
//        PageInfo page = new PageInfo(emps,5);
//        model.addAttribute("pageInfo",page);
//        Employee employee= (Employee) session.getAttribute("employee");
//        if (employee==null){
//            return "pleaselogin";
//        }
//        if (employee.getLevel()==0){
//            return "redirect:/topic";
//        }
        List<History> histories = fileService.getHistories();
        model.addAttribute("histories",histories);
        return "list";
    }
}
