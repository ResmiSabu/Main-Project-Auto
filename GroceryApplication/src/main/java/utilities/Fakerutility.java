package utilities;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;

public class Fakerutility {
	Faker faker=new Faker();
	
	public String username() {
		return faker.name().username();
	}
	
	public String password() {
		return faker.internet().password();
	}
	
	public String generateaddress() {
		return faker.address().fullAddress();
	}
	
	public PhoneNumber phonenumber() {
		return faker.phoneNumber();
	}
	
	public String emailid() {
		return faker.internet().emailAddress();
	}
	
	public String city() {
		return faker.address().city();
	}
	
	public String randomdigit() {
		return faker.number().digit();
	}
	
   public int randomnumber() {
	   return faker.number().numberBetween(5, 10);
   }
   
   public String newcategoryfood() {
	   return faker.food().fruit();
   }
}
