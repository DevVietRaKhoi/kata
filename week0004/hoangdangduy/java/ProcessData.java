import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ProcessData {
	public Client convertDataToEntityClient(String data) {
		String[] inforClient = data.split(",");
		StringBuilder fname = new StringBuilder(inforClient[0].toLowerCase());
		StringBuilder lname = new StringBuilder(inforClient[1].toLowerCase());
		StringBuilder email = new StringBuilder(inforClient[2].toLowerCase());

		fname.setCharAt(0, Character.toUpperCase(fname.charAt(0)));
		lname.setCharAt(0, Character.toUpperCase(lname.charAt(0)));
		if (email.toString().contains("@")) {
			Client client = new Client();
			client.setFname(fname.toString());
			client.setLname(lname.toString());
			client.setEmail(email.toString());
			return client;
		}
		return null;
	}

	public ArrayList<Client> readDataFromFile(String nameFileInput) {
		ArrayList<Client> listClient = new ArrayList<>();
		Client client = new Client();

		Path currentRelativePath = Paths.get("");
		String folderPath = currentRelativePath.toAbsolutePath().toString();
		Path path = Paths.get(folderPath, nameFileInput);
		Charset charset = Charset.forName("UTF-8");
		String strLine;

		try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
			while ((strLine = reader.readLine()) != null) {
					client = convertDataToEntityClient(strLine);
					if (client != null) {
						listClient.add(client);
					}
			}
			return listClient;
		} catch (IOException  e) {
			e.printStackTrace();
		}
		return null;
	}
}
