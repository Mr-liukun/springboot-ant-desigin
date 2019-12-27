package com.example.demo.controller;

import com.example.demo.model.Result;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin
@RestController // @RestController = @Controller(控制器) + @ResponseBody(返回json)
@RequestMapping("/index")
public class OneController {

    @Autowired
    private StudentService stuService;

    @RequestMapping(value = "/getone", method = RequestMethod.GET)
    public Student Index(HttpServletRequest request) {
        //获取参数
        String idStr = request.getParameter("id");
        int id = Integer.valueOf(idStr);

        Student stu = stuService.getStudentById(id);
        return stu;
    }

    //获取所有列表数据
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Student> getUserList(HttpServletRequest request) {
        List<Student> stu = stuService.getStudentListService();
        return stu;
    }

    @RequestMapping(value = "/delone")
    public Result delOneUserById(HttpServletRequest request){
        //获取参数
        String idStr = request.getParameter("id");
        int id = Integer.valueOf(idStr);
        stuService.delStudentByIdService(id);

        Result rs = new Result();
        rs.setMessage("ok");
        return rs;
    }

    @RequestMapping(value = "/addone", method = {RequestMethod.POST})
    public Result addOneUser(HttpServletRequest request) {

        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");
        String desc = request.getParameter("desc");

        int age = Integer.valueOf(ageStr);

        stuService.addStudentService(name, age, desc);

        int maxId = stuService.getMaxIdService();

        Result rs = new Result();
        rs.setMessage("ok");
        rs.setContent(maxId);
        return rs;
    }

    @RequestMapping(value = "/updateone", method = {RequestMethod.POST,RequestMethod.GET})
    public Result updateOne(HttpServletRequest request) {
        String idStr = request.getParameter("id");
        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");
        String desc = request.getParameter("desc");

        int age = Integer.valueOf(ageStr);
        int id = Integer.valueOf(idStr);

        stuService.updateStudentByIdService(id, name, age, desc);
        Result rs = new Result();
        rs.setMessage("ok");
        return rs;
    }

    @RequestMapping(value = "/search", method = {RequestMethod.POST,RequestMethod.GET})
    public List<Student> search(HttpServletRequest request) {

        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String desc = request.getParameter("desc");
        //System.out.println(name+" "+ ageStr+" "+ desc);
        //int age = Integer.valueOf(ageStr);

        List<Student> list = stuService.searchServie(name, age, desc);

        return list;
    }

}
