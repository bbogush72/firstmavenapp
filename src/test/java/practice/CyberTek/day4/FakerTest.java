package practice.CyberTek.day4;

import com.github.javafaker.Faker;

public class FakerTest {

    public static void main(String[] args) {
        //create an object
        Faker faker = new Faker();

        // create a string of random methods
        String fact = faker.chuckNorris().fact();
        System.out.println(fact);

        System.out.println(faker.artist().name());

        String str = faker.educator().secondarySchool();
    }
}
