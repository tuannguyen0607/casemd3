package service;

import model.Users;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    public static List<Users> users = new ArrayList<>();

    public static void add_User(Users user) {
        users.add(user);
    }

    public static boolean checkUser(String userName) {
        for (Users user : users) {
            if (user.getUserName().equals(userName)) {
                return false;
            }
        }
        return true;
    }
}

