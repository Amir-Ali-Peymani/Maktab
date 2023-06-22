package org.example.ui;

import org.example.base.repository.BaseRepository;
import org.example.entity.User;
import org.example.service.user.UserService;
import org.example.util.ApplicationContext;
import org.example.util.Constant;
import org.example.util.SecurityContext;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    private static final UserService userService = ApplicationContext.getUserService();

    public static void run(){

        while (true){
            Printer.printMenu(Constant.FIRST_MENU, Constant.WELCOME);
            Printer.printMsg(Constant.CHOOSE_ITEM, false);
            switch (new Scanner(System.in).next().trim()){
                case "1":
                    loginMenu();
                    break;
                case "2":
                    signupMenu();
                    break;
                case "3":
                    System.exit(0);
                    break;
                default:
                    Printer.printWarning(Constant.ITEM_NOT_FOUND);
                    break;
            }
        }
    }
    private static void signupMenu() {
        Scanner scanner=new Scanner(System.in);
        Printer.printMsg(Constant.ENTER_SIGNUP_INFO, true);
        Printer.printMsg(Constant.ENTER_FIRST_NAME,false);
        String name=scanner.next();
        String username=validateUsername(scanner);
        String password= validatePassword(scanner);
        try {
            userService.save(new User(name,username,password));
            Printer.printMsg(Constant.REGISTRATION_SUCCESS,true);
        } catch (SQLException e) {
            Printer.printWarning(e.getMessage());
        }
    }

    private static String validateUsername(Scanner scanner) {
        String username;
        while (true){
            Printer.printMsg(Constant.ENTER_USERNAME,false);
            username= scanner.next();
            try {
                if (!userService.isExistUsername(username)){
                    break;
                }
            } catch (Throwable e) {
                Printer.printWarning(e.getMessage());
            }
        }
        return username;
    }

    private static String validatePassword(Scanner scanner){
        String password;
        while(true){
            Printer.printMsg(Constant.ENTER_PASSWORD, false);
            password = scanner.next();
            try {
                if (!userService.isExistPassWord(password)) break;
            } catch (Throwable e) {
                Printer.printWarning(e.getMessage());
            }
        }
        return password;
    }

    public static void loginMenu(){
        String username;
        String passWord;
        boolean condition = true;
        while (true){
            Printer.printMsg(Constant.ENTER_USERNAME, false);
            username = new Scanner(System.in).next();
            if (username.equals(Constant.BREAK)) break;
            Printer.printMsg(Constant.ENTER_PASSWORD, false);
            passWord = new Scanner(System.in).next();
            if (passWord.equals(Constant.BREAK)) break;
            String[] credential = new String[2];
            credential[0] = username;
            credential[1] = passWord;
            try {
                User resultSet = userService.checkCredentialInfoForLogin(credential[0], credential[1]);
                setSecurityContext(resultSet);
//                dashboardMenu();
            }catch (ArrayIndexOutOfBoundsException e){
                Printer.printWarning(Constant.BAD_ENTRY_FORMAT);
            }
            catch (Throwable e){
                Printer.printWarning(e.getClass().getSimpleName() + ": " + e.getMessage());
            }
            break;
        }
    }

    private static void setSecurityContext(User resultSet) {
        SecurityContext.id = resultSet.getId();
        SecurityContext.name = resultSet.getName();
        SecurityContext.username = resultSet.getUserName();
        SecurityContext.passWord = resultSet.getPassWord();
    }
}
