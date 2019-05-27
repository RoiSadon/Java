package Answer01;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Create array
		Hotel[] HotelAr = new Hotel[1];

		// Insert elements to array from user
		for(int i=0;i<HotelAr.length;i++)
		{
			System.out.println("\nPlease enter your hotel details:");
			Scanner input = new Scanner(System.in);
			
			System.out.print("Hotel: ");
			String n = input.nextLine();
			System.out.print("City: ");
			String c = input.nextLine();
			System.out.print("Rooms: ");
			int r = input.nextInt();
			System.out.print("Free: ");
			int f = input.nextInt();
			HotelAr[i]=new Hotel(n,c,r,f);			
		}
		
		// Search specific city
		System.out.print("Enter city name: ");
		Scanner in = new Scanner(System.in);
		String city = in.nextLine();
		for(int i=0;i<HotelAr.length;i++) {	
			if(city.equals( HotelAr[i].getCity())) {
				System.out.println(HotelAr[i].toString());
			}
		}
		
		// Free Rooms
		for(int i=0;i<HotelAr.length;i++) {
			if(HotelAr[i].getFree()>0) {
				System.out.println(HotelAr[i].toString());
			}
		}
		
		// Free above 40%
		for(int i=0;i<HotelAr.length;i++) {
			int r = HotelAr[i].getRooms();
			int f = HotelAr[i].getFree();
			int gap = (f*100/r);
			if(gap>40) {
				System.out.println(HotelAr[i].toString());
			}
		}		
	}

}
