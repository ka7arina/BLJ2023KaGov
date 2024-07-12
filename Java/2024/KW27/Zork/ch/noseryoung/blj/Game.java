package ch.noseryoung.blj;

import java.util.Scanner;

public class Game {
    private Room currentRoom;
    private Player player;
    private boolean gameOver;

    public Game() {
        createRooms();
        player = new Player();
        gameOver = false;
    }

    private void createRooms() {

        Room spawn = new Room("at the spawn point");
        Room fairylair = new Room("in the fairy lair");
        Room ruins = new Room("in the ruins");
        Room tunnel = new Room("in a dark tunnel");
        Room outsideofborder = new Room("outside of the border");
        Room willowshut = new Room("at Willow's hut");

        spawn.setExit("east", fairylair);
        fairylair.setExit("west", spawn);
        fairylair.setExit("east", ruins);
        ruins.setExit("west", fairylair);
        ruins.setExit("east", tunnel);
        tunnel.setExit("west", ruins);
        tunnel.setExit("south", outsideofborder);
        outsideofborder.setExit("north", tunnel);
        outsideofborder.setExit("south", willowshut);
        willowshut.setExit("north", outsideofborder);

        currentRoom = spawn;

        Item key = new Item("key", "A small rusty key.", false, " ");
        Item bread = new Item("bread", "A loaf of freshly baked bread.", false, " ");
        Item mailbox = new Item("mailbox", "A rusty white old mailbox", true, "you hit the hard metal with your bare hands JWNSBBDJSJKAJWHWB - wow. now your hand is bleeding! why did you think attacking a mailbox would be a good idea??? dumbass.");
        spawn.addItem(mailbox);
        spawn.addItem(key);
        fairylair.addItem(bread);

        fairylair.lockDoor("east");
    }

    public void play() {
        printWelcome();

        Scanner scanner = new Scanner(System.in);
        while (!gameOver) {
            System.out.print("> ");
            String input = scanner.nextLine();
            processCommand(input);
        }
        scanner.close();
        System.out.println("Thank you for playing. Goodbye!");
    }

    private void printWelcome() {
        System.out.println("Welcome to the Zork game!");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private void processCommand(String input) {
        Commands command = new Commands();
        if (command.isCommand(input)) {
            String[] parts = input.split(" ", 2);
            String commandWord = parts[0];
            String argument = parts.length > 1 ? parts[1] : null;

            switch (commandWord) {
                case "help":
                    printHelp();
                    break;
                case "go":
                    goRoom(argument);
                    break;
                case "quit":
                    gameOver = true;
                    break;
                case "take":
                    if (argument != null) {
                        takeItem(argument);
                    } else {
                        System.out.println("Take what?");
                    }
                    break;
                case "drop":
                    if (argument != null) {
                        dropItem(argument);
                    } else {
                        System.out.println("Drop what?");
                    }
                    break;
                case "examine":
                    if (argument != null) {
                        examineItem(argument);
                    } else {
                        System.out.println("Examine what?");
                    }
                    break;
                case "inventory":
                    showInventory();
                    break;
                case "unlock":
                    if (argument != null) {
                        unlockDoor(argument);
                    } else {
                        System.out.println("Unlock which direction?");
                    }
                    break;
                case "attack":
                    if (argument != null) {
                        attackItem(argument);
                    } else {
                        System.out.println("Attack what?");
                    }
                    break;
                case "open":
                    if (argument != null) {
                        openItem(argument);
                    } else {
                        System.out.println("Open what?");
                    }
                    break;
                default:
                    System.out.println("I don't know what you mean...");
                    break;
            }
        } else {
            System.out.println("I don't understand...");
        }
    }

    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander around in a magical forest.");
        System.out.println("Your command words are:");
        System.out.println("   go [direction], take [item], drop [item], examine [item], inventory, help, quit");
    }

    private void goRoom(String direction) {
        if (direction == null) {
            System.out.println("Go where?");
            return;
        }

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else if (currentRoom.isLocked(direction)) {
            System.out.println("The door is locked. You need a key to unlock it.");
        } else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    public void takeItem(String itemName) {
        Item item = getItemInRoom(itemName);
        if (!itemName.equals("mailbox") && item != null) {
            player.addItem(item);
            currentRoom.removeItem(item);
            System.out.println("You take the " + item.getName() + ".");
        } else {
            System.out.println("You can't take " + itemName + " here.");
        }
    }


    public void dropItem(String itemName) {
        Item item = player.getItemByName(itemName);
        if (item != null) {
            player.removeItem(item);
            currentRoom.addItem(item);
            System.out.println("You drop the " + item.getName() + ".");
        } else {
            System.out.println("You don't have a " + itemName + ".");
        }
    }

    public void examineItem(String itemName) {
        Item item = player.getItemByName(itemName);
        if (item != null) {
            System.out.println("You examine the " + item.getName() + ": " + item.getDescription());
        } else {
            item = getItemInRoom(itemName);
            if (item != null) {
                System.out.println("You examine the " + item.getName() + ": " + item.getDescription());
            } else {
                System.out.println("There is no " + itemName + " here.");
            }
        }
    }

    public void showInventory() {
        if (player.getInventory().isEmpty()) {
            System.out.println("You are not carrying any items.");
        } else {
            System.out.println("You are carrying:");
            for (Item item : player.getInventory()) {
                System.out.println("- " + item.getName() + ": " + item.getDescription());
            }
        }
    }

    private Item getItemInRoom(String itemName) {
        for (Item item : currentRoom.getItems()) {
            if (item.getName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    public void attackItem(String itemName) {
        Item item = getItemInRoom(itemName);
        if (item != null && item.isAttackable()) {
            System.out.println("You attack the " + item.getName() + ": " + item.getAttackDescription());
        } else {
            System.out.println("You can't attack " + itemName + " here, dumbass.");
        }
    }

    public void unlockDoor(String direction) {
        if (currentRoom.isLocked(direction)) {
            Item key = player.getItemByName("key");
            if (key != null) {
                currentRoom.unlockDoor(direction);
                System.out.println("You unlock the door to the " + direction + " with the key.");
            } else {
                System.out.println("You don't have a key to unlock the door.");
            }
        } else {
            System.out.println("The door is already unlocked.");
        }
    }


    private Item openItem(String itemName) {
        Item item = getItemInRoom(itemName);
        if (item != null) {
            System.out.println("You open the " + item.getName());
        } else {
            System.out.println("You can't open " + itemName + ", dumbass.");
        }
        return item;
    }
}
