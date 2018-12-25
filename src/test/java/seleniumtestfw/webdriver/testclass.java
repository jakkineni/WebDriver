package seleniumtestfw.webdriver;

import utility.ConfigReader;

public class testclass {

	ConfigReader config;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigReader config = new ConfigReader();
		System.out.println(config.getUserID());

	}

}
