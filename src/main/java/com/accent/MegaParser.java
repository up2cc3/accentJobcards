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

            boolean insertado= false;

            // Something with line

            if (line.indexOf("top") != -1) {
                jobCard.addJobOrder(tops, line);
                insertado=true;
            }
            if (line.indexOf("screen") != -1 && !line.contains("brackets")) {
                jobCard.addJobOrder(screens, line);
                insertado=true;
            }
            if (line.indexOf("Unit") != -1) {
                jobCard.addJobOrder(assembly, line);
                insertado=true;
            }
            if (line.indexOf("base") != -1) {
                jobCard.addJobOrder(fab, line);
                insertado=true;
            }
            
            if (!insertado){
                jobCard.addJobOrder(fab,line);
            }

        }
        return result;
    }
}
