package Com.HackerRankTest.DataProviderFactory;

import Com.HackerRankTest.DataProvider.RandomDataProvider;

public class DataProviderFactory {
	
	public static RandomDataProvider getRandomDataProperty() {

		return new RandomDataProvider();
	}

}
