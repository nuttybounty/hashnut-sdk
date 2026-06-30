package io.hashnut.model;

import java.util.HashMap;
import java.util.Map;

public class OrderState {
    public static final int INIT=0;
    public static final int PAID=1;
    public static final int CONFIRMING=2;
    public static final int SUCCESS=3;
    public static final int FINISH=4;
    public static final int FAILED=-1;
    public static final int EXPIRE=-2;
    public static final int CANCELED=-3;

    public static final String toString(int state){
        switch (state){
            case INIT:
                return "init";
            case PAID:
                return "paid";
            case CONFIRMING:
                return "confirming";
            case SUCCESS:
                return "success";
            case FINISH:
                return "finish";
            case FAILED:
                return "failed";
            case EXPIRE:
                return "expire";
            case CANCELED:
                return "canceled";
            default:
                return "unknown";
        }
    }
}
