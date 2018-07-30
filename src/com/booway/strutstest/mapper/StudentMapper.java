package com.booway.strutstest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.booway.strutstest.entity.Student;

/**
 * @author Administrator
 *
 */
public interface StudentMapper
{
    public boolean addStudent(Student student);

    public boolean deleteStudentById(String id);

    public boolean updateStudent(Student student);

    //根据学生id获得学生对象
    public Student getStudentById(String id);

    //
    public List<Student> getStudents();

    public long getStudentCount();

    public List<Student> getStudentByPage(@Param("currentPage") int currentPage, @Param("rows") int rows);

}
