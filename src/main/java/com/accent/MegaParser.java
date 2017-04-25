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
public class MegaParser {

    int tops = 0;
    int screens = 1;
    int assembly = 2;
    int esp = 3;
    int fab = 4;

    public List<Order> parse(Iterable<String> lines) {
        List<Order> result = new ArrayList<>();
        Order jobCard = new Order();
        result.add(jobCard);

        for (String line : lines) {

            // Something with line
            if (line.indexOf("mesa") != -1) {
                jobCard.addJobOrder(tops, line);
            }
            if (line.indexOf("screen") != -1 && !line.contains("brackets")) {
                jobCard.addJobOrder(screens, line);
            }
            if (line.indexOf("armario") != -1) {
                jobCard.addJobOrder(assembly, line);
            }
            if (line.indexOf("brackets") != -1) {
                jobCard.addJobOrder(fab, line);
            }

        }
        return result;
    }
}
