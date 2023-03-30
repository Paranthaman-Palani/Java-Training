package assignment6;

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TransportLorryProblem {
	public static void main(String[] args) throws Exception {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Enter Starting Date and Time of Lorry Format : [ DD/MM/YYYY/HH:MM:SS ]");
			Date startingDate = new Date();
			String startDate = scan.next();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy/HH:mm:ss");
			startingDate = simpleDateFormat.parse(startDate);
			System.out.println("Enter Distance in kilometers : ");
			int distance = scan.nextInt();
			System.out.println("Enter Speed of the Lorry in km/hr : ");
			int speed = scan.nextInt();
			int time = distance / speed;

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(startingDate);

			Date dateObject = new Date();
			dateObject = startingDate;

			int extraHours = time % 8;
			int totalDays = time / 8;
			int totalDaysRequired = 0;

			  while (totalDays > 0) {
	                if (!isHoliday(calendar)) {
	                    totalDaysRequired++;
	                    totalDays--;
	                }
	                calendar.add(Calendar.DATE, 1);
	            }

			calendar.setTime(dateObject);
			calendar.add(Calendar.DATE, totalDaysRequired - 1);
			calendar.add(Calendar.HOUR_OF_DAY, extraHours);

			System.out.println("LORRY STARTING DATE & TIME : " + startingDate);
			System.out.println("LORRY REACHING DATE & TIME : " + calendar.getTime());
		}
	}

	public static boolean isHoliday(Calendar dateTime) {
		int year = dateTime.get(Calendar.YEAR);
		int month = dateTime.get(Calendar.MONTH);
		int day = dateTime.get(Calendar.DATE);

		// Check if it's a Sunday or second Saturday
		if (dateTime.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
				|| ((dateTime.get(Calendar.WEEK_OF_MONTH) == 2) && dateTime.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)) {
			return true;
		}

		// Check if it's a holiday
		if ((month == Calendar.JANUARY && day == 1) || (month == Calendar.AUGUST && day == 15)
				|| (month == Calendar.JANUARY && day == 26)
				|| (year % 4 == 0 && month == Calendar.FEBRUARY && day == 29)) {
			return true;
		}
		return false;
	}
}