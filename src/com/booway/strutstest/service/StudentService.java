package com.booway.strutstest.service;

import java.util.List;

import com.booway.strutstest.entity.PageBean;
import com.booway.strutstest.entity.Student;

/**
 * @author Administrator
 *
 */
public interface StudentService
{
    public boolean addStudent(Student student);

    public boolean deleteStudentById(String id);
    
    public boolean updateStudent(Student student);

    //根据学生id获得学生对象
    public Student getStudentById(String id);

    public List<Student> getStudents();
   
    /**
     * @param currentPage
     * @param rows
     * @return
     * 返回一个分页对象
     */
    public PageBean<Student> getPageBean(int currentPage, int rows);

}
