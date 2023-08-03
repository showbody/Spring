package com.yc.bean;

public enum OpType {
    WITHDRAW("wirhdraw",1),DEPOSITE("deposite",2),TRANSFER("TRANSFER",3);


    private String key;
    private int i;
    OpType(String key, int value) {
        this.key = key;
        this.i = i;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
