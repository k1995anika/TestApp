package com.kanika.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView EmpId,Name,Subjects;
    EditText EditEmp,EditName,EditSubjects;
    Button Submit;
    TeacherDb db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         db = new TeacherDb(this);


        EmpId = (TextView) findViewById(R.id.EmpId);
        EmpId.setText("Emp ID");

        Name = (TextView) findViewById(R.id.Name);
        Name.setText("Name");

        Subjects = (TextView) findViewById(R.id.Subjects);
        Subjects.setText("Subjects");

        EditEmp = (EditText) findViewById(R.id.EditEmp);
        EditEmp.setHint("Enter Employee ID");

        EditName = (EditText) findViewById(R.id.EditName);
        EditName.setHint("Enter Employee Name");

        EditSubjects = (EditText) findViewById(R.id.EditSubjects);
        EditSubjects.setHint("Enter Subjects Taught");

        Submit = (Button) findViewById(R.id.Submit);
        Submit.setText("SUBMIT");


        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Teacher t = new Teacher(EditEmp.getText().toString(),EditName.getText().toString(),EditSubjects.getText().toString());
                Toast.makeText(MainActivity.this,t.getEmpId().toString(),Toast.LENGTH_LONG).show();
                db.addTeacher(t);
            }
        });

    }


}
