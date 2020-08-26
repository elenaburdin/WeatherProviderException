import java.util.Random;

public class WeatherProvider {

	private static double temperatureForToday = generateTemperature();
    private static double[] temperaturesFor10Days = generateTemperaturesForecastFor10Days();

    private static double generateTemperature() {
        Random rd = new Random(); 
        double temperature = 305 * ( rd.nextDouble() - 0.5 );
        return temperature;
    }

    private static double[] generateTemperaturesForecastFor10Days() {
    	double[] forecastArray = new double[10];
		for (int i = 0; i < forecastArray.length; i++) {
			forecastArray[i] = generateTemperature();
		}
		return forecastArray;
	}


    public static double getTemperatureForToday() {
		return temperatureForToday;
      
    }
    
    public static double getTemperatureForTodayForException() throws TemperatureDataOutOfRangeException {
    	if (temperatureForToday >= -150 && temperatureForToday <= 150) {
			return temperatureForToday;
		}
		double temperatureForTodayForException = 0;
		if (temperatureForToday >= -152 && temperatureForToday < -150) {
			temperatureForTodayForException = -150;
		} else if (temperatureForToday > 150 && temperatureForToday <= 152) {
			temperatureForTodayForException = 150;
		} else {
			throw new TemperatureDataOutOfRangeException();
		}
		return temperatureForTodayForException;
	}

    public static double[] getTemperaturesForecastFor10Days() {
		return temperaturesFor10Days;
       
    }
    public static double[] getTemperaturesForecastFor10DaysForException() throws TemperatureDataOutOfRangeException {
    	for (int i = 0; i < temperaturesFor10Days.length; i++) {
			if (temperaturesFor10Days[i] < -150 || temperaturesFor10Days[i] > 150) {
				break;
			} else if (i == temperaturesFor10Days.length - 1) {
				return temperaturesFor10Days;
			}
		}

		double[] temperaturesFor10DaysForException = new double[temperaturesFor10Days.length];
		for (int i = 0; i < temperaturesFor10DaysForException.length; i++) {
			if (temperaturesFor10Days[i] >= -150 && temperaturesFor10Days[i] <= 150) {
				temperaturesFor10DaysForException[i] = temperaturesFor10Days[i];
				continue;
			} else if (temperaturesFor10Days[i] >= -152 && temperaturesFor10Days[i] < -150) {
				temperaturesFor10DaysForException[i] = -150;
				continue;
			} else if (temperaturesFor10Days[i] > 150 && temperaturesFor10Days[i] <= 152) {
				temperaturesFor10DaysForException[i] = 150;
				continue;
			} else {
				throw new TemperatureDataOutOfRangeException();
			}
		}

		return temperaturesFor10DaysForException;

	}

    public static double calculateAvgFor10Days() {
    	double avgTemp10Days = 0;
		for (int i = 0; i < temperaturesFor10Days.length; i++) {
			avgTemp10Days += temperaturesFor10Days[i];
		}
		return avgTemp10Days / temperaturesFor10Days.length;
	}

    public static double getMaxTemperatureFor10Days() {
    	double maxTemp10Days = temperaturesFor10Days[0];
		for (int i = 1; i < temperaturesFor10Days.length; i++) {
			if (maxTemp10Days >= temperaturesFor10Days[i]) {
				continue;
			}
			maxTemp10Days = temperaturesFor10Days[i];
		}
		return maxTemp10Days;
	}

    
    public static double getMaxTemperatureFor10DaysForException() throws TemperatureDataOutOfRangeException {
    double maxTemp10Days = getTemperaturesForecastFor10DaysForException()[0];
	for (int i = 1; i < getTemperaturesForecastFor10DaysForException().length; i++) {
		if (maxTemp10Days >= getTemperaturesForecastFor10DaysForException()[i]) {
			continue;
		}
		maxTemp10Days = getTemperaturesForecastFor10DaysForException()[i];
	}
	return maxTemp10Days;
 }
    public static double getMinTemperatureFor10Days() {
    	double minTemp10Days = temperaturesFor10Days[0];
		for (int i = 1; i < temperaturesFor10Days.length; i++) {
			if (minTemp10Days <= temperaturesFor10Days[i]) {
				continue;
			}
			minTemp10Days = temperaturesFor10Days[i];
		}
		return minTemp10Days;
	}
    public static double getMinTemperatureFor10DaysForException() throws TemperatureDataOutOfRangeException {
		double MinTemp10Days = getTemperaturesForecastFor10DaysForException()[0];
		for (int i = 1; i < getTemperaturesForecastFor10DaysForException().length; i++) {
			if (MinTemp10Days <= getTemperaturesForecastFor10DaysForException()[i]) {
				continue;
			}
			MinTemp10Days = getTemperaturesForecastFor10DaysForException()[i];
		}
		return MinTemp10Days;
	}
}

class TemperatureDataOutOfRangeException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TemperatureDataOutOfRangeException() {
		System.out.println("We are sorry!\nThe data is unavailable!\nSerial Version " + serialVersionUID);
	}
}
















