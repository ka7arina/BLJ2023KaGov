package ch.noseryoung.blj;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private String description;
    private Map<String, Room> exits;
    private List<Item> items;
    private Map<String, Boolean> doorStatus;

    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
        items = new ArrayList<>();
        doorStatus = new HashMap<>();
    }

    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
        doorStatus.put(direction, false);  // By default, doors are unlocked
    }

    public String getShortDescription() {
        return description;
    }

    public String getLongDescription() {
        return "You are " + description + ".\n" + getExitString() + "\n" + getItemString();
    }

    private String getExitString() {
        StringBuilder exitString = new StringBuilder("Exits:");
        for (String key : exits.keySet()) {
            exitString.append(" ").append(key);
            if (doorStatus.get(key)) {
                exitString.append(" (locked)");
            }
        }
        return exitString.toString();
    }

    private String getItemString() {
        if (items.isEmpty()) {
            return "No items here.";
        }
        StringBuilder itemString = new StringBuilder("Items:");
        for (Item item : items) {
            itemString.append(" ").append(item.getName());
        }
        return itemString.toString();
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public boolean isLocked(String direction) {
        return doorStatus.getOrDefault(direction, false);
    }

    public void lockDoor(String direction) {
        doorStatus.put(direction, true);
    }

    public void unlockDoor(String direction) {
        doorStatus.put(direction, false);
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }
}
