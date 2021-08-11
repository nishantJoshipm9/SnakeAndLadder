package com.nishant.snakandladder;

import java.util.Objects;

public class Box {

    private int val;
    public Box(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box box = (Box) o;
        return val == box.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }
}
