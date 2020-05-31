package domain.entity;

import domain.entityEnum.Sex;
import java.util.*;

/**
 * @author Sup_4eg
 * User entity
 */

public class User {
    private int id;
    private String name;
    private int age;
    private Sex sex;

    private static Map<Integer, User> allUsers = new HashMap<>();
    // count all users
    private static int countId = 0;

    /**
     * A constructor for class User
     * @param name name of the person
     * @param age age of the person
     * @param sex enum - sex of the person
     * @see Sex
     */
    public User(String name, int age, Sex sex) {
        if (name != null && !name.isEmpty() && age > 0 && sex != null) {
            this.name = name;
            this.age = age;
            this.sex = sex;

            if (!hasUser()) {
                countId++;
                this.id = countId;
                allUsers.put(id, this);
            }
        }

    }

    /**
     * Check if objects are the same
     * @param o comparable object
     * @return true if the same else false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) &&
                sex == user.sex;
    }

    /**
     * Get object hash code
     * @return hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }


    @Override
    public String toString() {
        return String.format("User{id=%d, name='%s', age=%d, " +
                "sex=%s}", id, name, age, sex);
    }

    /**
     * Check if user exists in the allUsers map
     * @return true if exists else false
     */
    private boolean hasUser(){
        for (User user: allUsers.values()){
            if (user.equals(this) && user.hashCode() == this.hashCode()) {
                return true;
            }
        }
        return false;
    }

    public static List<User> getAllUsers() {
        return new ArrayList<>(allUsers.values());
    }

    public static List<User> getAllUsers(Sex sex) {
        List<User> listAllUsers = new ArrayList<>();
        for (User user: allUsers.values()) {
            if (user.sex == sex) {
                listAllUsers.add(user);
            }
        }
        return listAllUsers;
    }

    public static int getHowManyUsers() {
        return allUsers.size();
    }

    public static int getAllAgeUsers() {
        int countAge = 0;
        for (User user: allUsers.values()) {
            countAge += user.age;
        }
        return countAge;
    }

    /**
     * Count all users by sex
     * @param sex
     * @return number of users
     */
    public static int getHowManyUsers(Sex sex) {
        return getAllUsers(sex).size();
    }

    /**
     * Count age of all users by sex
     * @param sex
     * @return number of age
     */
    public static int getAllAgeUsers(Sex sex) {
        int countAge = 0;
        for (User user: getAllUsers(sex)) {
            countAge += user.age;
        }
        return countAge;
    }

    public static int getAverageAgeOfAllUsers() {
        return getAllAgeUsers() / getHowManyUsers();
    }

    /**
     * Get average age of all users by sex
     * @param sex
     * @return
     */
    public static int getAverageAgeOfAllUsers(Sex sex) {
        return getAllAgeUsers(sex) / getHowManyUsers(sex);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public static void setAllUsers(Map<Integer, User> allUsers) {
        User.allUsers = allUsers;
    }

    public static int getCountId() {
        return countId;
    }

    public static void setCountId(int countId) {
        User.countId = countId;
    }
}
