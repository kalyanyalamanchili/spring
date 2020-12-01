package com.example.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.*;

public class Commuter {

    private static final Log LOG = LogFactory.getLog(Commuter.class);

    private Commuter() { }

    /**
     * Check if destination can be reached from origin
     * @param origin the origin
     * @param destination the destination
     * @return true if cities are connected
     */
    public static boolean commute(City origin, City destination) {

        LOG.info("Origin: " + origin.getName() + ", destination: " + destination.getName());

        if (origin.equals(destination)) return true;

        if (origin.getNearby().contains(destination)) return true;

        /*
         * Initialise the set with the origin city since it was already visited
         */
        Set<City> visited = new HashSet<>(Collections.singleton(origin));

        /*
         * Insert all neighbouring cities into a list
         */
        Deque<City> list = new ArrayDeque<>(origin.getNearby());


        while (!list.isEmpty()) {

            City city = list.getLast();

            if (city.equals(destination)) return true;

            // If its a first time visit, then only add
            if (!visited.contains(city)) {

                visited.add(city);

                // add neighbours to the list and remove already visited cities from the list
                list.addAll(city.getNearby());
                list.removeAll(visited);

            } else {
                // When the city was already visted, remove it
                list.removeAll(Collections.singleton(city));
            }
        }

        return false;
    }
}

