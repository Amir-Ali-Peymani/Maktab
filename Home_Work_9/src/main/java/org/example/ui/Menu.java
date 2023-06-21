package org.example.ui;

import org.example.entity.User;
import org.example.service.user.UserService;
import org.example.util.ApplicationContext;
import org.example.util.Constant;

import java.util.Scanner;

public class Menu {

    private static final UserService userService = ApplicationContext.getUserService();

    public static void run(){

        while (true){
            Printer.printMenu(Constant.FIRST_MENU, Constant.WELCOME);
            Printer.printMsg(Constant.CHOOSE_ITEM, false);
            switch (new Scanner(System.in).next().trim()){
                case "1":

            }
        }
    }
}
