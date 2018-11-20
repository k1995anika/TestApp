package com.kanika.testapp;

import android.app.Activity;

public class Teacher extends Activity{


    private String EmpId;
    private String Name;
    private String Subjects;

    public Teacher() {
        EmpId = "";
        Name = "";
        Subjects = "";
    }



    public Teacher(String EmpIdVal,String NameVal,String SubjectsVal) {
        EmpId = EmpIdVal;
        Name = NameVal;
        Subjects = SubjectsVal;
    }


    public String getEmpId() {
        return EmpId;
    }

    public String getName() {
        return Name;
    }

    public String getSubjects() {
        return Subjects;
    }

}
