import domain.entity.User;
import domain.entityEnum.Sex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sup_4eg
 * @see User
 * Test class for User.java
 */
public class UserTest {
    private User user;
    private User user1;
    private User user2;

    // Exception users here
    private User userNotAdd;
    private User userNotAdd1;

    @Before
    public void setUp() throws Exception {
        user = new User("Евгений", 35, Sex.MALE);
        user1 = new User("Марина", 34, Sex.FEMALE);
        user2 = new User("Алина", 7, Sex.FEMALE);

        userNotAdd = new User("", 0, null);
        userNotAdd1 = new User(null, 0 , null);
    }

    /**
     * Check users with an empty name
     */
    @Test
    public void newUserEmptyName() {
        for (User user: User.getAllUsers()) {
            if (user.getName() != null && user.getName().isEmpty()) {
                Assert.fail("Попытка создания пользователя с пустым именем");
            }
        }
    }

    /**
     * Check users with a zero age
     */
    @Test
    public void newUserAgeZero() {
        for (User user: User.getAllUsers()) {
            if (user.getAge() <= 0) {
                Assert.fail("Попытка создания пользователя с недопустимым" +
                        "возрастом");
            }
        }
    }

    /**
     * Check users with sex = null
     */
    @Test
    public void newUserSexNoNull() {
        for (User user: User.getAllUsers()) {
            if (user.getSex() == null) {
                Assert.fail("Попытка создания пользоватеял с " +
                        "указанием пола = null");
            }
        }
    }


    @Test
    public void getAllUsers() {
        List<User> expected = User.getAllUsers();

        List<User> actual = new ArrayList<>();
        actual.add(user);
        actual.add(user1);
        actual.add(user2);
        //run test
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllUsersNoNull() {
        List<User> expected = User.getAllUsers();
        Assert.assertNotNull(expected);
    }

    @Test
    public void getAllUsersMale() {
        List<User> expected = User.getAllUsers(Sex.MALE);
        List<User> actual = new ArrayList<>();
        actual.add(user);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllUsersMaleNoNull() {
        List<User> expected = User.getAllUsers(Sex.MALE);
        Assert.assertNotNull(expected);
    }

    @Test
    public void getAllUsersFemale() {
        List<User> expected = User.getAllUsers(Sex.FEMALE);
        List<User> actual = new ArrayList<>();
        actual.add(user1);
        actual.add(user2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllUsersFemaleNoNull() {
        Assert.assertNotNull(User.getAllUsers(Sex.FEMALE));
    }

    @Test
    public void getHowManyUsers() {
        int expected = User.getHowManyUsers();
        int actual = 3;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHowManyUsersMale() {
        int expected = User.getHowManyUsers(Sex.MALE);
        int actual = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHowManyUsersFemale() {
        int expected = User.getHowManyUsers(Sex.FEMALE);
        int actual = 2;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllAgeUsers() {
        int expected = User.getAllAgeUsers();
        int actual = 35 + 34 + 7;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllAgeUsersMale() {
        int expected = User.getAllAgeUsers(Sex.MALE);
        int actual = 35;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllAgeUsersFemale() {
        int expected = User.getAllAgeUsers(Sex.FEMALE);
        int actual = 34 + 7;
        Assert.assertEquals(expected, actual);
    }
}
