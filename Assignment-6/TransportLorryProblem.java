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
			
			for (int i = 1; i <= totalDays; i++) {
				if ((calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) /* SUNDAY */
						|| ((calendar.get(Calendar.WEEK_OF_MONTH) == 2)
								&& (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY))/* SECOND SATURDAY */
						|| ((calendar.get(Calendar.MONTH) == Calendar.JANUARY) && (calendar.get(Calendar.DATE) == 26)
								&& (calendar.get(Calendar.DATE) == 1)) /* JAN 1 and JAN 26 Holiday */
						|| ((calendar.get(Calendar.MONTH) == Calendar.AUGUST)
								&& (calendar.get(Calendar.DATE) == 15)))/* AUGUST 15 HOIDAY */ {
					totalDaysRequired++;
					i--;
					calendar.add(Calendar.DATE, 1);
					continue;
				} else {
					totalDaysRequired++;
					calendar.add(Calendar.DATE, 1);
				}
			}

			calendar.setTime(dateObject);
			calendar.add(Calendar.DATE, totalDaysRequired - 1);
			calendar.add(Calendar.HOUR_OF_DAY, extraHours);

			System.out.println("LORRY STARTING DATE & TIME : " + startingDate);
			System.out.println("LORRY REACHING DATE & TIME : " + calendar.getTime());
		}
	}
}