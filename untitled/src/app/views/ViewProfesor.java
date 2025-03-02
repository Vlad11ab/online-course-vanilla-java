package app.views;

import app.User.service.UserService;

import java.util.Scanner;

public class ViewProfesor {
    private UserService userService;
    private Scanner scanner;


    public ViewProfesor() {
        this.userService = new UserService();
        this.scanner = new Scanner(System.in);
        this.play();
    }

    private void meniu(){
        System.out.println("1-> Afisare profesori");
        System.out.println("2-> Afisare cel mai batran profesor");
        System.out.println("3-> ");
    }

    private void play(){
        boolean running = true;

        while(running){
            this.meniu();
            int choose = Integer.parseInt(scanner.nextLine());
            switch(choose){
                case 1:
                    select1();
                    break;
                case 2:
                    select2();
                    break;
                default: System.out.println("Invalid option");


            }
        }


    }

    //Functii
    private void select1(){
        System.out.println("Lista profesorilor: ");
         userService.afisareProfesors();
    }

    private void select2(){
         System.out.println("Cel mai batran profesor este: " + userService.profVarstaMax());

    }



}
