import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Week0004 {
	private Set<String> hashsetClient2Event = new HashSet<>();
	private ArrayList<Client> listClient = new ArrayList<>();
	private SortUtil sortUtil = new SortUtil();

	public static void main(String[] args) {
		Week0004 week0004 = new Week0004();
		week0004.action(args);
	}

	public void action(String ... nameFile) {
		SortUtil sortUtil = new SortUtil();
		ProcessData processData = new ProcessData();
		Client client = new Client();
		ArrayList<Client> listClientTemporary = new ArrayList<>();

		for (int i=0; i<nameFile.length; i++){
			listClientTemporary = processData.readDataFromFile(nameFile[i]);
			if (listClientTemporary != null && !listClientTemporary.isEmpty()){
				for (int j=0; j<listClientTemporary.size(); j++){
					if (hashsetClient2Event.contains(listClientTemporary.get(j).getEmail())){
						listClient.add(listClientTemporary.get(j));
					}else{
						hashsetClient2Event.add(listClientTemporary.get(j).getEmail());
					}
				}
			}
		}		
		
		sortUtil.QuickSoft(listClient, 0, listClient.size()-1, "fname");
		
		int varRun=0;
		/*
		 * Check fname duplicate to sort lname according to fname
		 */
		for (int i=0; i<listClient.size(); i++){
			if (i<listClient.size()-1 && listClient.get(i).getFname().compareTo(listClient.get(i+1).getFname()) == 0){
				varRun++;
			}else{
				if (varRun != 0){
					sortUtil.QuickSoft(listClient, i-varRun, i, "lname");
				}
				varRun = 0;
			}
		}
		
		
		varRun=0;
		/*
		 * Check lname duplicate to sort email according to lname
		 */
		for (int i=0; i<listClient.size(); i++){
			if (i<listClient.size()-1 && listClient.get(i).getLname().compareTo(listClient.get(i+1).getLname()) == 0){
				varRun++;
			}else{
				if (varRun != 0){
					sortUtil.QuickSoft(listClient, i-varRun, i, "email");
				}
				varRun = 0;
			}
		}
		
		for (int i=0; i<listClient.size(); i++){
			System.out.println(listClient.get(i).toString());
		}
	}
}
