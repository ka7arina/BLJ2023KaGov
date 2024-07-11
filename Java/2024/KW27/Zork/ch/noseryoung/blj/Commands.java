package ch.noseryoung.blj;

import java.util.Scanner;

public class Commands {

    private String action;
    private String object;

    public void command(String action, String object) {
        this.action = action;
        this.object = object;

        Scanner commandInput = new Scanner(System.in);
        String direction = commandInput.nextLine();

        switch(direction) {
            case "north":
                System.out.println("You went north.");
                break;
            case "west":
                System.out.println("You went west.");
                break;
            case "south":
                System.out.println("You went south.");
                break;
            case "east":
                System.out.println("You went east. You're now");
                break;
        }
    }

    public boolean isCommand(String input) {
        String[] validCommands = {"help", "go east", "go west", "go north", "go south", "take", "drop", "use", "quit", "check inventory", "inventory", "open", "take", "inspect", "attack", "eat", "heal", "buy", "continue", "respond", "unlock" };
        for (String command : validCommands) {
            if (input.equals(command) || input.startsWith(command.split(" ")[0])) {
                return true;
            }
        }
        return false;
    }

    public String getAction(String input) {
        return input.split(" ")[0];
    }

    public String getObject(String input) {
        if (input.split(" ").length > 1) {
            return input.split(" ", 2)[1];
        }
        return "";
    }
}
