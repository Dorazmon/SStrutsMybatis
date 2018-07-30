package com.booway.strutstest.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONObject;
import com.booway.strutstest.entity.PageBean;
import com.booway.strutstest.entity.Student;
import com.booway.strutstest.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author Administrator
 *StudentAction
 */
public class StudentAction extends ActionSupport implements ModelDriven<Student>
{

    /**
     * 
     */
    private static final long serialVersionUID = -928307972622576933L;
    private StudentService studentService;
    private Student student;

    public String pageStudents()
    {
        HttpServletRequest request = ServletActionContext.getRequest();
        PageBean<Student> pageBean = null;
        //当没有收到前端第几页时默认为第1页，并且默认每页5条数据
        if (request.getParameter("page") == null)
        {
            pageBean = studentService.getPageBean(1, 5);
            request.getSession().setAttribute("pageBean", pageBean);
            return "student";
        }
        pageBean = studentService.getPageBean(Integer.parseInt(request.getParameter("page")), 5);
        request.getSession().setAttribute("pageBean", pageBean);
        return "student";

    }

    public String addStudent()
    {
        student.setId(UUID.randomUUID().toString());
        studentService.addStudent(student);
        return "student";
    }

    public String updateStudent()
    {
        studentService.updateStudent(student);
        return "student";

    }
    //编辑时回显数据
    public void getStudentById()
    {
        HttpServletResponse response = ServletActionContext.getResponse();
        Student newStudent = studentService.getStudentById(student.getId());
        String jsonStudent = JSONObject.toJSONString(newStudent);
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        PrintWriter out = null;
        try
        {
            out = response.getWriter();
            out.write(jsonStudent);
            out.flush();
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally
        {
            out.close();
        }

    }

    public String deleteStudentById()
    {
        studentService.deleteStudentById(student.getId());
        return "student";

    }

    public StudentService getStudentService()
    {
        return studentService;
    }

    public void setStudentService(StudentService studentService)
    {
        this.studentService = studentService;
    }

    @Override
    public Student getModel()
    {
        // TODO Auto-generated method stub
        student = new Student();
        return student;
    }

}
