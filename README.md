# StateModel

状态模式，实时监测状态，当状态发生变化相应的也会进行一些更新。通过把各种状态转移逻辑分布到state的子类，来减少相互之间的依赖，可以消除庞大的条件分支语句。当一个对象的行为取决于它的状态，并且它必须在运行时刻根据状态改变它的行为时，就可以考虑使用状态模式了。

一个人上班期间，根据时间的不同，对应不同的工作状态，那么按照平常的思路就是输入时间，一一去判断，这样的话就会违背了开放-封闭原则，这个时候采用状态模式，把每个时间点对应的状态，创建成为一个类，那么再添加类或者修改。都不会影响其他时间点的状态。
package com.abings.statemodel.StateModel;

/**
 * Created by HaomingXu on 2016/9/12.
 */
public abstract class State {
    public abstract void workstate(Work work);
}
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
package com.abings.statemodel.StateModel;

/**
 * Created by HaomingXu on 2016/9/12.
 */
public class Work {
    private State state;
    private int hour;
    private boolean isFinished = false;

    public boolean isFinished() {
        return isFinished;
    }

    public void setIsFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public Work(State state){
        setState(state);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void writeProgram(){
        state.workstate(this);
    }

}
客户端
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
运行结果
09-12 15:28:19.201 20503-20503/? I/Tag: 当前时间：10，上午工作，精神百倍。
09-12 15:28:19.201 20503-20503/? I/Tag: 当前时间：12，中午工作，饿了，犯困。
09-12 15:28:19.201 20503-20503/? I/Tag: 当前时间：13，中午工作，饿了，犯困。
09-12 15:28:19.202 20503-20503/? I/Tag: 当前时间：15，下午工作，状态不错，继续努力。
09-12 15:28:19.202 20503-20503/? I/Tag: 当前时间：19,不行，没完成，继续加班。
09-12 15:28:19.202 20503-20503/? I/Tag: 当前时间：21，完成了。回家吧。