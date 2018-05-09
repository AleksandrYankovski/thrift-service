package com.bsuir.aipos.controler;

import com.bsuir.aipos.controler.command.Command;
import com.bsuir.aipos.controler.command.Type;

public class Controler {
    private static final Controler instance = new Controler();


    private Controler() {

    }

    public void processRequest(String commandName) {
        Type type = Type.valueOf(commandName);

        Command command = type.getCommand();
        command.execute();
    }


    public static Controler getInstance() {
        return instance;
    }
}
