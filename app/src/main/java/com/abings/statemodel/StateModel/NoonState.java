package com.abings.statemodel.StateModel;

import android.util.Log;

/**
 * Created by HaomingXu on 2016/9/12.
 */
public class NoonState extends State {
    @Override
    public void workstate(Work work) {
        if (work.getHour() < 14){
            Log.i("Tag","当前时间："+work.getHour()+"，中午工作，饿了，犯困。");
        }else{
            work.setState(new AfternoonState());
            work.writeProgram();
        }
    }
}
