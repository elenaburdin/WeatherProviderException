
public class WeatherApplication {

	public static void main(String[] args){
    	printWeather();
    }

    public static void printWeather() {
try {
        System.out.println( "############# WEATHER #############\n" );
		System.out.printf( "TODAY: %5.1f C\n\n", WeatherProvider.getTemperatureForToday() );
		System.out.println( "-----------------------------------" );
		System.out.println( "\nFORECAST FOR 10 DAYS\n" );
		for (int i = 0; i < 10; i++) {
			System.out.printf( "DAY %2d: %5.1f C\n", i + 1,
					WeatherProvider.getTemperaturesForecastFor10Days()[i] );
		}
  
		System.out.println();
		
		System.out.printf( "MAX: %9.1f C\n", WeatherProvider.getMaxTemperatureFor10Days() );
		System.out.printf("AVG: %9.1f C\n", WeatherProvider.calculateAvgFor10Days() );
		System.out.printf( "MIN: %9.1f C\n\n", WeatherProvider.getMinTemperatureFor10Days() );
		System.out.println( "###################################" );

	}
catch (Exception TemperatureDataOutOfRangeException) {
    System.out.println(TemperatureDataOutOfRangeException);
  }
    }
}