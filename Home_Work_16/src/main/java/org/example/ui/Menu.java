package org.example.ui;

import org.example.base.BaseRepository;
import org.example.business.*;
import org.example.entity.*;
import org.example.repository.Impl.StudentRepositoryImpl;
import org.example.repository.StudentRepository;
import org.example.service.Impl.StudentServiceImpl;
import org.example.service.StudentService;
import org.example.util.Constant;

import java.time.LocalDate;
import java.util.List;


public class Menu extends BaseRepository {
    public static void main(String[] args) {
menu();
    }

    public static void menu(){
        boolean loop = true;
        while (loop){
            Printer.printMenu(Constant.MAIN_MENU);
            int choice = inputUtility.giveIntegerInput(Constant.CHOICE);
            switch (choice){
                case 1 -> SignInAndSignUp.signUp();
                case 2 -> SignInAndSignUp.signIn();
                case 3 -> loop = false;
            }
        }
    }














}


