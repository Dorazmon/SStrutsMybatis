package com.booway.strutstest.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.booway.strutstest.entity.Student;
import com.booway.strutstest.service.StudentService;



/**
 * @author Administrator
 *测试类
 */
public class Test
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
        StudentService studentMapper = (StudentService) ac.getBean("studentServiceImpl");
        Student student = studentMapper.getStudentById("01c86b97-c9df-4e52-b276-7ad894e8c474");
        System.out.println(student);
    }

}
