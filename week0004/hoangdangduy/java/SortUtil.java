import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortUtil {

	public ArrayList<Client> sort(ArrayList<Client> listClient) {
		Collections.sort(listClient, new Comparator<Client>() {

			@Override
			public int compare(Client client1, Client client2) {
				if (client1.getFname().compareTo(client2.getFname()) == 0 && client1.getLname().compareTo(client2.getLname()) == 0) {
					return client1.getEmail().compareTo(client2.getEmail());
				} else if (client1.getFname().compareTo(client2.getFname()) == 0) {
					return client1.getLname().compareTo(client2.getLname());
				}
				return client1.getFname().compareTo(client2.getFname());
			}
		});
		return listClient;
	}
}
