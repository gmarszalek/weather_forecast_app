package main;

public class WeatherDateSegregation {

    public static boolean isTheSameDay(char currentDate, char hourlyDate) {
        return currentDate == hourlyDate;
    }

    public static String getFirstHourlyDate(OWMJapisRequest object) {
        return object.getHourlyDateTime(0);
    }

    public static int[] setHourIndexes(char decimalHourIndex, char singleHourIndex) {
        System.out.println("Decimal hourly index: " + decimalHourIndex);
        System.out.println("Single hourly index: " + singleHourIndex);

        if (decimalHourIndex == '0') {
            switch(singleHourIndex) {
                case '2': {
                    int[] hourIndexArray = new int[] {1, 3, 5, 7};
                    return hourIndexArray;
                }
                case '5': {
                    int[] hourIndexArray = new int[] {0, 2, 4, 6};
                    return hourIndexArray;
                }
                case '8': {
                    int[] hourIndexArray = new int[] {-1, 1, 3, 5};
                    return hourIndexArray;
                }
            }
        } else if (decimalHourIndex == '1') {
            switch(singleHourIndex) {
                case '1': {
                    int[] hourIndexArray = new int[] {-1, 0, 2, 4};
                    return hourIndexArray;
                }
                case '4': {
                    int[] hourIndexArray = new int[] {-1, 0, 1, 3};
                    return hourIndexArray;
                }
                case '7': {
                    int[] hourIndexArray = new int[] {-1, -1, 0, 2};
                    return hourIndexArray;
                }

            }
        } else if (decimalHourIndex == '2') {
            switch(singleHourIndex) {
                case '0': {
                    int[] hourIndexArray = new int[] {-1, -1, 0, 1};
                    return hourIndexArray;
                }
                case '3': {
                    int[] hourIndexArray = new int[] {-1, -1, -1, 0};
                    return hourIndexArray;
                }
            }

        }
        return null;
    }

    public static int[] selectWeatherData(OWMJapisRequest selectedCity) {

        String dateFirst = selectedCity.getCurrentDateTime();
        char dateFirstDay =  (dateFirst.charAt(9));
        System.out.println("Date first " + dateFirst);
        System.out.println("Date First Day: " + dateFirstDay);
        char dateFirstHourlyDay = getFirstHourlyDate(selectedCity).charAt(9);
        System.out.println("Get first hourly date " + getFirstHourlyDate(selectedCity));
        System.out.println("Date firs hourly day: " + dateFirstHourlyDay);


        int[] hourIndexArray = new int[] {-1, -1, -1, -1};
        System.out.println("hourly index array przed : " + hourIndexArray);

        if (isTheSameDay(dateFirstDay, dateFirstHourlyDay)) {
            hourIndexArray = setHourIndexes(getFirstHourlyDate(selectedCity).charAt(11), getFirstHourlyDate(selectedCity).charAt(12));
            System.out.println("Set hourly index(11): " + getFirstHourlyDate(selectedCity).charAt(11));
            System.out.println("Set hourly index(12): " + getFirstHourlyDate(selectedCity).charAt(12 ));


            return hourIndexArray;
        } else return hourIndexArray;
    }
}

