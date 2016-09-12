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
