package assignment6;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LorryDriver {
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter the starting date in yyyy-mm-dd format : ");
			String startDate = scanner.nextLine();
			System.out.print("Enter the travel distance in km: ");
			int distance = scanner.nextInt();
			System.out.print("Enter the speed in km/h: ");
			int speed = scanner.nextInt();
			System.out.print("Enter the starting time in hh:mm format (24-hour clock) : ");
			String startTime = scanner.next();
			
			LocalDate startingDate = LocalDate.parse(startDate);
			LocalTime startingTime = LocalTime.parse(startTime);
		
			int totalHours = distance / speed;
			int totalDays = totalHours / 8;
			
			if (totalHours % 8 != 0) {
			    totalDays++;
			}
			
			List<LocalDate> holidays = Arrays.asList(
			    LocalDate.of(startingDate.getYear(), Month.JANUARY, 1), 
			    LocalDate.of(startingDate.getYear(), Month.AUGUST, 15), 
			    LocalDate.of(startingDate.getYear(), Month.JANUARY, 26) 
			);
			
			List<DayOfWeek> weekends = Arrays.asList(
			    DayOfWeek.SUNDAY, 
			    DayOfWeek.SATURDAY 
			);
			
			LocalDateTime currentDateTime = LocalDateTime.of(startingDate, startingTime);
			LocalDate currentDate = currentDateTime.toLocalDate();
			LocalTime currentTime = currentDateTime.toLocalTime();
			LocalDateTime destinationDateTime = null;
			for (int i = 0; i < totalDays; i++) {
			
			    if (holidays.contains(currentDate) || weekends.contains(currentDate.getDayOfWeek())) {
			        currentDate = currentDate.plusDays(1);
			        continue;
			    }
			    
			    int remainingHours = 8 - currentTime.getHour();
			    
			
			    if (i == totalDays - 1 && totalHours % 8 != 0) {
			        remainingHours = totalHours % 8;
			    }
			    
			
			    LocalTime destinationTime = currentTime.plusHours(remainingHours);
	
			    if (destinationTime.isAfter(LocalTime.of(20, 0))) {
			        destinationTime = LocalTime.of(20, 0);
			    }
	
			    LocalDate destinationDate = currentDate.plusDays(i);

			    destinationDateTime = LocalDateTime.of(destinationDate, destinationTime);

			   
			    
			    currentDate = destinationDate.plusDays(1);
			    currentTime = LocalTime.of(8, 0);
			}
			
		   System.out.println("The lorry will reach the destination on " + destinationDateTime);
		}
     
    }
    
}