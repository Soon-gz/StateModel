package com.abings.statemodel.StateModel;

import android.util.Log;

/**
 * Created by HaomingXu on 2016/9/12.
 */
public class AfternoonState extends State {
    @Override
    public void workstate(Work work) {
        if (work.getHour() < 17){
            Log.i("Tag","当前时间："+work.getHour()+"，下午工作，状态不错，继续努力。");
        }else{
            work.setState(new EveningState());
            work.writeProgram();
        }
    }
}
