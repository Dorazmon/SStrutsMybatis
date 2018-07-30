package com.booway.strutstest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booway.strutstest.entity.PageBean;
import com.booway.strutstest.entity.Student;
import com.booway.strutstest.mapper.StudentMapper;

/**
 * @author Administrator
 *
 */
@Service
public class StudentServiceImpl implements StudentService
{
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public boolean addStudent(Student student)
    {
        // TODO Auto-generated method stub

        return studentMapper.addStudent(student);
    }

    @Override
    public boolean deleteStudentById(String id)
    {
        // TODO Auto-generated method stub
        return studentMapper.deleteStudentById(id);
    }

    @Override
    public boolean updateStudent(Student student)
    {
        // TODO Auto-generated method stub
        return studentMapper.updateStudent(student);
    }

    @Override
    public Student getStudentById(String id)
    {
        // TODO Auto-generated method stub
        return studentMapper.getStudentById(id);
    }

    @Override
    public List<Student> getStudents()
    {
        // TODO Auto-generated method stub
        return studentMapper.getStudents();
    }

    @Override
    public PageBean<Student> getPageBean(int currentPage, int rows)
    {
        // TODO Auto-generated method stub
        List<Student> students = studentMapper.getStudentByPage(currentPage, rows);
        PageBean<Student> studentPage = new PageBean<Student>();
        studentPage.setPageDate(students);
        studentPage.setCurrentPage(currentPage);
        studentPage.setCurrentCount(students.size());
        long totalCount = studentMapper.getStudentCount();
        int totalPage = (int) Math.ceil((1.0 * totalCount) / rows);
        studentPage.setTotalPage(totalPage);
        return studentPage;
    }

}
