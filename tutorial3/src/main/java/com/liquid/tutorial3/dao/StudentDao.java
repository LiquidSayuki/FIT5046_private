package com.liquid.tutorial3.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.liquid.tutorial3.pojo.Student;

import java.util.List;

@Dao
public interface StudentDao {

    @Query("SELECT * FROM student_table ORDER BY student_id ASC")
    List<Student> getStudents();

    @Query("SELECT * FROM student_table ORDER BY student_id ASC")
    LiveData<List<Student>> getStudentsLiveData();

    @Insert
    void insert (Student student);

}
