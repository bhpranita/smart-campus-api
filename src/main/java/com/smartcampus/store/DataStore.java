/*
 * @author bhpranita
 */
package com.smartcampus.store;

import com.smartcampus.model.Room;
import com.smartcampus.model.Sensor;
import com.smartcampus.model.SensorReading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class DataStore {
    public static ConcurrentHashMap<String, Room> rooms = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<String, Sensor> sensors = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<String, List<SensorReading>> readings = new ConcurrentHashMap<>();

    static {
        Room room1 = new Room("LIB-301", "Library Quiet Study", 50);
        Room room2 = new Room("LAB-101", "Computer Lab", 30);
        rooms.put(room1.getId(), room1);
        rooms.put(room2.getId(), room2);

        Sensor sensor1 = new Sensor("TEMP-001", "Temperature", "ACTIVE", 22.5, "LIB-301");
        sensors.put(sensor1.getId(), sensor1);
        room1.getSensorIds().add(sensor1.getId());

        readings.put("TEMP-001", new ArrayList<>());
    }
}