package com.abings.statemodel.StateModel;

import android.util.Log;

/**
 * Created by HaomingXu on 2016/9/12.
 */
public class EveningState extends State {
    @Override
    public void workstate(Work work) {
        if (work.isFinished()){
            Log.i("Tag","当前时间："+work.getHour()+"，完成了。回家吧。");
        }else{
            if (work.getHour() < 21){
                Log.i("Tag", "当前时间：" + work.getHour() + ",不行，没完成，继续加班。");
            }else{
                Log.i("Tag","当前时间："+work.getHour()+"，不行，没完成也要回家了。");
            }
        }
    }
}
