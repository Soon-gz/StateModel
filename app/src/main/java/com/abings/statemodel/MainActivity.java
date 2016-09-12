package com.abings.statemodel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.abings.statemodel.StateModel.ForenoonState;
import com.abings.statemodel.StateModel.Work;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Work work = new Work(new ForenoonState());

        //一天的工作
        work.setHour(10);
        work.writeProgram();
        work.setHour(12);
        work.writeProgram();
        work.setHour(13);
        work.writeProgram();
        work.setHour(15);
        work.writeProgram();
        work.setHour(19);
        work.writeProgram();
        work.setHour(21);
        work.setIsFinished(true);
        work.writeProgram();
    }
}
