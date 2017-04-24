package com.accent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ccc on 24/04/2017.
 */
public class  MegaParser {

    public List<Order> parse(Iterable<String> lines) {
        List<Order> result = new ArrayList<>();
        Order jobCard = new Order();
        result.add(jobCard);
        for (String line : lines) {

            // Something with line
            if (line.indexOf("table") != -1) {
                jobCard.addJobOrder(0, line);
            }
            if (line.indexOf("screen") != -1 && !line.contains("brackets")) {
                jobCard.addJobOrder(1, line);
            }
        }
        return result;
    }
}
