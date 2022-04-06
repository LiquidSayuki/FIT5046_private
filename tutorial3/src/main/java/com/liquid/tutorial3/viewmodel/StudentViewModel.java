package com.liquid.tutorial3.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.liquid.tutorial3.pojo.Student;
import com.liquid.tutorial3.repo.StudentRepository;

import java.util.List;

public class StudentViewModel extends AndroidViewModel {
    private StudentRepository studentRepository;
    private LiveData<List<Student>> allStudents;

    public StudentViewModel (Application application) {
        super(application);
        studentRepository = new StudentRepository(application);
        allStudents = studentRepository.getAllStudents();
    }

    public LiveData<List<Student>> getAllStudents() {
        return allStudents;
    }

    public void insert(Student student){
        studentRepository.insert(student);
    }
}
