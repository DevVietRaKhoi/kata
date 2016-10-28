import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Week0004 {
	public static void main(String[] args) {
		Week0004 week0004 = new Week0004();
		week0004.action(args);
	}

	public void action(String ... nameFile) {
		SortUtil sortUtil = new SortUtil();
		ProcessData processData = new ProcessData();
		ArrayList<Client> listClientTemporary = new ArrayList<>();
		ArrayList<Client> listClient = new ArrayList<>();
		Map<String, Integer> hashmapClient2Event = new HashMap<>();

		for (int i = 0; i < nameFile.length; i++) {
			listClientTemporary = processData.readDataFromFile(nameFile[i]);
			if (listClientTemporary != null && !listClientTemporary.isEmpty()) {
				for (int j = 0; j < listClientTemporary.size(); j++) {
					if (hashmapClient2Event.containsKey(listClientTemporary.get(j).getEmail()) && hashmapClient2Event.get(listClientTemporary.get(j).getEmail()) == 1 ) {
						listClient.add(listClientTemporary.get(j));
						int total = hashmapClient2Event.get(listClientTemporary.get(j).getEmail());
						hashmapClient2Event.put(listClientTemporary.get(j).getEmail(), total++);
					} else if (!hashmapClient2Event.containsKey(listClientTemporary.get(j).getEmail())) {
						hashmapClient2Event.put(listClientTemporary.get(j).getEmail(), 1);
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
