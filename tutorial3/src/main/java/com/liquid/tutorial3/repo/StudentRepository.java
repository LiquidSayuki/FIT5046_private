package com.liquid.tutorial3.repo;


import android.app.Application;

import androidx.lifecycle.LiveData;

import com.liquid.tutorial3.dao.StudentDao;
import com.liquid.tutorial3.database.StudentDatabase;
import com.liquid.tutorial3.pojo.Student;

import java.util.List;

public class StudentRepository {
    private StudentDao studentDao;
    private LiveData<List<Student>> allStudents;

    public StudentRepository (Application application){
        StudentDatabase database = StudentDatabase.getInstance(application);
        studentDao =database.studentDao();
        allStudents = studentDao.getStudentsLiveData();
    }

    public LiveData<List<Student>> getAllStudents(){
        return allStudents;
    }

    public void insert(final Student student){
        StudentDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                studentDao.insert(student);
            }
        });
    }



}
