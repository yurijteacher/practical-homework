package validation;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MyTest {

    private static MyUtils validationEmail;

    @BeforeAll
    public static void setUpBeforeClass() throws Exception{
        System.out.println("@BeforeClass setUpBeforeClass()");
        validationEmail = new MyUtils();
    }

    @AfterAll
    public static void tearDownAfterClass() throws  Exception{
        System.out.println("@AfterClass tearDownAfterClass()");
    }

    @BeforeEach
    public void  setUp() throws Exception{
        System.out.println("@Before setUp()");
    }

    @AfterEach
    public void tearDown() throws Exception{
        System.out.println("@After tearDown()");
    }



//    @Test
    @ParameterizedTest
    @ValueSource(strings =
            {
            "123username@gmail.com", // false
            "username.@gmail.com",   // false
            "username.gmail.com",    // false
            "user_name@gmail.com",   // false
            "user-name@gmail.com",   // false
            "user$name@gmail.com",   // false
            "user name@gmail.com",   // false
            "user. name@gmail-com",  // false
            "user. name@gmail com",  // false
            "username@gmail, com",   // false
            "user.name.name.gmail@ua",              // false
            "user.name.gmail@com.ua",               //true
            "user.name.name.gmail@com.ua",          // true
            "username@gmail.com",                   // true
            "user.name.name.gmail@shop.com.ua",     // true
            "user.name.name.gmail@i.ua",            // true
            "user.name.name.gmail@ex.ua",           // true
            })
    public void checkWrongEmail(String email){
        System.out.println("@Test : " + email);
        Assertions.assertTrue(validationEmail.checkEmail(email));
    }

}
