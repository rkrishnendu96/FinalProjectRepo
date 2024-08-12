package dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name = "invalidUserCredentials")
	public Object[][] verifyUserCredentialData() {
		Object[][] data = new Object[3][2];
		data[0][0] = "admin";
		data[0][1] = "12488#58";

		data[1][0] = "adminggt8";
		data[1][1] = "123456";

		data[2][0] = "adminggt8";
		data[2][1] = "12488#58";
		return data;

	}

}
