package com.accent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ccc on 24/04/2017.
 */
public class Order {

    public int jobNumber;
    private List<Dept> depts = new ArrayList<>(5);

    Order() {
        for (int i = 0; i < 5; i++) {
            depts.add(new Dept());
        }
    }

    public void addJobOrder(int deptNumber, String jobOrder) {
        if (deptNumber < 0 || deptNumber > 4) throw new RuntimeException("Dept. number " + deptNumber + " incorrect");

        depts.get(deptNumber).items.add(jobOrder);
    }

    public List<Dept> getDepts() {
        return Collections.unmodifiableList(depts);
    }
}
