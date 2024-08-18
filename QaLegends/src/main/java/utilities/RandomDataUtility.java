package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	static Faker faker;

	public static String getFirstName() {
		faker = new Faker();
		String firstName = faker.name().firstName();
		return firstName;
	}

	public static String getLastName() {
		faker = new Faker();
		String lastName = faker.name().lastName();
		return lastName;
	}

}
