package com.designPtn.command;

/**
 * 遥控器类
 * 只负责： 1.按下按钮 2.执行命令
 */
public class SimpleRemoteControl {
    /**
     * 这个插槽执行命令，这个命令控制具体的装置
     */
    private Command slot;

    public SimpleRemoteControl(){}

    public void setCommand(Command command){
        this.slot = command;
    }

    public void buttonWasPressed(){
        slot.excute();
    }

    public static void main(String[] args) {

        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
        Light light = new Light();
        Command command = new LightOnCommand(light);

        //对于遥控器来说，他不知道设置的命令是控制哪个装备的，按钮按下即执行命令
        simpleRemoteControl.setCommand(command);
        simpleRemoteControl.buttonWasPressed();

        Door door = new Door();
        Command command1 = new DoorOpenCommand(door);

        //同上
        simpleRemoteControl.setCommand(command1);
        simpleRemoteControl.buttonWasPressed();

    }

}
