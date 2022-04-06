package com.liquid.tutorial3.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "student_table")
public class Student{

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "student_id")
    private int id;

    @ColumnInfo(name = "student_l_name")
    private String lastName;

    @ColumnInfo(name = "student_f_name")
    private String firstName;

    public Student(int id, String lastName, String firstName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
    }

}
