package com.accent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ccc on 24/04/2017.
 * tops 0
 * screen 1
 * assembly 2
 * esp 3
 * fab 4
 */
public class  MegaParser {

    public List<Order> parse(Iterable<String> lines) {
        List<Order> result = new ArrayList<>();
        Order jobCard = new Order();
        result.add(jobCard);
        for (String line : lines) {

            // Something with line
            if (line.indexOf("mesa") != -1) {
                jobCard.addJobOrder(0, line);
            }
            if (line.indexOf("screen") != -1 && !line.contains("brackets")) {
                jobCard.addJobOrder(1, line);
            }
            if (line.indexOf("armario") != -1 && !line.contains("brackets")) {
                jobCard.addJobOrder(2, line);
            }
            else {jobCard.addJobOrder(4, line);}
        }
        return result;
    }
}
