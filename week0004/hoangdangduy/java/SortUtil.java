import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortUtil {

	public ArrayList<Client> sort(ArrayList<Client> listClient) {
		Collections.sort(listClient, new Comparator<Client>() {

			@Override
			public int compare(Client client1, Client client2) {
				return client1.getFname().compareTo(client2.getFname());
			}
		});

		int varRun = 0;
		/*
		 * Check fname duplicate to sort lname according to fname
		 */
		for (int i = 0; i < listClient.size(); i++) {
			if (i < listClient.size()-1 && listClient.get(i).getFname().compareTo(listClient.get(i+1).getFname()) == 0) {
				varRun++;
			} else {
				if (varRun != 0) {
					Collections.sort(listClient.subList(i-varRun, i+1), new Comparator<Client>() {

						@Override
						public int compare(Client client1, Client client2) {
							return client1.getLname().compareTo(client2.getLname());
						}
					});
				}
				varRun = 0;
			}
		}

		/*
		 * Check lname duplicate to sort email according to lname
		 */
		for (int i = 0; i < listClient.size(); i++) {
			if (i < listClient.size()-1 && listClient.get(i).getLname().compareTo(listClient.get(i+1).getLname()) == 0
					&& listClient.get(i).getFname().compareTo(listClient.get(i+1).getFname()) == 0) {
				varRun++;
			} else {
				if (varRun != 0) {
					Collections.sort(listClient.subList(i-varRun, i+1), new Comparator<Client>() {

						@Override
						public int compare(Client client1, Client client2) {
							return client1.getEmail().compareTo(client2.getEmail());
						}
					});
				}
				varRun = 0;
			}
		}
		return listClient;
	}
}	
