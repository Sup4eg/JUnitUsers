package application;

import domain.entity.User;


/**
 * @author Sup_4eg
 * Start an application here
 */
public class Application {
    public static void main(String[] args) {
        User.getAllUsers().forEach(System.out::println);
        System.out.println("Все пользователи");
    }
}
