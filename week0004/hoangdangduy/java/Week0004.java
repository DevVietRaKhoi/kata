import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Week0004 {
	public static void main(String[] args) {
		Week0004 week0004 = new Week0004();
		args = new String[]{"event1.input","event2.input"};
		week0004.action(args);
	}

	public void action(String ... nameFile) {
		SortUtil sortUtil = new SortUtil();
		ProcessData processData = new ProcessData();
		ArrayList<Client> listClientTemporary = new ArrayList<>();
		ArrayList<Client> listClient = new ArrayList<>();
		Set<String> hashsetClient2Event = new HashSet<>();

		for (int i = 0; i < nameFile.length; i++) {
			listClientTemporary = processData.readDataFromFile(nameFile[i]);
			if (listClientTemporary != null && !listClientTemporary.isEmpty()) {
				for (int j = 0; j < listClientTemporary.size(); j++) {
					if (hashsetClient2Event.contains(listClientTemporary.get(j).getEmail())) {
						listClient.add(listClientTemporary.get(j));
					} else {
						hashsetClient2Event.add(listClientTemporary.get(j).getEmail());
					}
				}
			}
		}

		listClient = sortUtil.sort(listClient);

		for (int i = 0; i < listClient.size(); i++) {
			System.out.println(listClient.get(i).toString());
		}
	}
}
