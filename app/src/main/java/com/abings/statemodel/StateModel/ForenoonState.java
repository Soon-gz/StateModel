package com.abings.statemodel.StateModel;

import android.util.Log;

/**
 * Created by HaomingXu on 2016/9/12.
 */
public class ForenoonState extends State {
    @Override
    public void workstate(Work work) {
        if (work.getHour() < 12){
            Log.i("Tag","当前时间："+work.getHour()+"，上午工作，精神百倍。");
        }else{
            work.setState(new NoonState());
            work.writeProgram();
        }
    }
}
