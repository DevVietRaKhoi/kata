package event.management.processors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import event.management.domain.Guest;

public class RegistrationExtractor {

	private static final int HEADER_LINES = 1;
	
	public List<Guest> extractGuestsFromFile(String registrationFileName) throws Exception {
		try (Stream<String> stream = Files.lines(Paths.get(registrationFileName))) {
			return extractGuests(stream.skip(HEADER_LINES));
		} catch (IOException e) {
			throw new Exception(
					String.format("Error while processing file [%s]", registrationFileName), e);
		}
	}
	
	private List<Guest> extractGuests(Stream<String> registrationStream) {
		return registrationStream.map(Guest::fromRegistrationEntry)
		 .collect(Collectors.toList());
	}
}
