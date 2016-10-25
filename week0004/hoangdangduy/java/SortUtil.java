import java.util.ArrayList;

public class SortUtil {
	public int Partition(ArrayList<Client> listClient, int left, int right, String chooseFunctionSort) {
		int x = left;
		int i = left + 1;
		int j = right;
		Client t;
		do {
			switch (chooseFunctionSort) {
			case "fname":
				while ((i <= j) && (listClient.get(i).getFname().compareTo(listClient.get(x).getFname()) <= 0)) {
					i++;
				}
				while ((i <= j) && (listClient.get(j).getFname().compareTo(listClient.get(x).getFname()) >= 0)) {
					j--;
				}
				break;
			case "lname":
				while ((i <= j) && (listClient.get(i).getLname().compareTo(listClient.get(x).getLname()) <= 0)) {
					i++;
				}
				while ((i <= j) && (listClient.get(j).getLname().compareTo(listClient.get(x).getLname()) >= 0)) {
					j--;
				}
				break;
			case "email":
				while ((i <= j) && (listClient.get(i).getEmail().compareTo(listClient.get(x).getEmail()) <= 0)) {
					i++;
				}
				while ((i <= j) && (listClient.get(j).getEmail().compareTo(listClient.get(x).getEmail()) >= 0)) {
					j--;
				}
				break;
			default:
				break;
			}

			while ((i <= j) && (listClient.get(i).getEmail().compareTo(listClient.get(x).getEmail()) <= 0)) {
				i++;
			}
			while ((i <= j) && (listClient.get(j).getEmail().compareTo(listClient.get(x).getEmail()) >= 0)) {
				j--;
			}
			if (i < j) {
				t = listClient.get(i);
				listClient.set(i, listClient.get(j));
				listClient.set(j, t);
				i++;
				j--;
			}
		} while (i <= j);
		t = listClient.get(left);
		listClient.set(left, listClient.get(j));
		listClient.set(j, t);
		return j;
	}

	void QuickSoft(ArrayList<Client> listClient, int left, int right, String chooseFunctionSort) {
		int k;
		if (left < right) {
			k = Partition(listClient, left, right, chooseFunctionSort);
			QuickSoft(listClient, left, k - 1, chooseFunctionSort);
			QuickSoft(listClient, k + 1, right, chooseFunctionSort);
		}
	}
}
