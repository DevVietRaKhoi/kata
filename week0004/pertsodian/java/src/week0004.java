import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import event.management.domain.Guest;
import event.management.processors.RegistrationExtractor;

public class week0004 {

	public static void main(String[] inputArguments) {
		if (inputArguments.length != 2) {
			System.out.println("Require 2 events to find their duplicate guests");
			return;
		}

		RegistrationExtractor extractor = new RegistrationExtractor();

		List<Guest> firstEventGuests, secondEventGuests;
		try {
			firstEventGuests = extractor.extractGuestsFromFile(inputArguments[0]);
			secondEventGuests = extractor.extractGuestsFromFile(inputArguments[1]);
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
			return;
		}

		List<Guest> duplicatedGuests = new ArrayList<>(firstEventGuests);
		duplicatedGuests.retainAll(secondEventGuests);

		Collections.sort(duplicatedGuests);
		duplicatedGuests.forEach(System.out::println);
	}
}
