package com.designPtn.command;

public class DoorOpenCommand implements Command {

    Door door;

    public DoorOpenCommand(Door door){
        this.door = door;
    }

    @Override
    public void excute() {
        door.open();
    }
}
