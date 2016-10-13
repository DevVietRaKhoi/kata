import java.util.*;

public class Week0003 {

    private static final String ADD_NEW_CLIENT = "A";
    private static final String DEPOSIT_MONEY = "D";
    private static final String WITHDRAW_MONEY = "W";

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        HashMap<String, Client> clients = new HashMap<String, Client>();
        ArrayList<String> output = new ArrayList<String>();

        while (scan.hasNext()) {
            processRequest(new ProcessStringRequest(scan.nextLine()), clients, output);
        }
        scan.close();
        for (int i = 0; i < output.size(); i++) {
            System.out.println(output.get(i));
        }
    }

    private static void processRequest(ProcessStringRequest processStringRequest,
                                       HashMap<String, Client> clients,
                                       ArrayList<String> output) {

            switch (processStringRequest.getDefineRequest()) {
                case ADD_NEW_CLIENT: {
                    addNewClient(processStringRequest, clients, output);
                    break;
                }
                case DEPOSIT_MONEY: {
                    depositMoney(processStringRequest, clients, output);
                    break;
                }
                case WITHDRAW_MONEY: {
                    withdrawMoney(processStringRequest, clients, output);
                    break;
                }
                default:
                    output.add("Invalid");

            }
    }

    private static void addNewClient(ProcessStringRequest processStringRequest,
                                     HashMap<String, Client> clients,
                                     ArrayList<String> output) {
        if (clients.get(processStringRequest.getName()) == null
                && processStringRequest.getAmount() > 0) {

            clients.put(processStringRequest.getName(),
                    new Client(processStringRequest.getName(),
                            processStringRequest.getAmount()));
            output.add("True");
        }
        else {
            output.add("False");
        }
    }

    private static void depositMoney(ProcessStringRequest processStringRequest,
                                     HashMap<String, Client> clients,
                                     ArrayList<String> output) {
        if (clients.get(processStringRequest.getName()) != null
                && processStringRequest.getAmount() > 0) {

            clients.get(processStringRequest.getName()).deposit(processStringRequest.getAmount());
            output.add("True");
        }
        else {
            output.add("False");
        }
    }
    
    private static void withdrawMoney(ProcessStringRequest processStringRequest,
                                      HashMap<String, Client> clients,
                                      ArrayList<String> output) {
        if (clients.get(processStringRequest.getName()) != null
                && processStringRequest.getAmount() > 0
                && clients.get(processStringRequest.getName()).getAmount() > processStringRequest.getAmount()) {

            clients.get(processStringRequest.getName()).withdraw(processStringRequest.getAmount());
            output.add("True");
        }
        else {
            output.add("False");
        }
    }
}

class Client {

    private String name;
    private Double amount;

    public Client(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    void deposit(Double amount) {
        this.amount += amount;
    }

    void withdraw(Double amount) {
        this.amount -= amount;
    }
}

class ProcessStringRequest {

    private String defineRequest;
    private String name;
    private double amount;

    public ProcessStringRequest(String defineRequest, String name, double amount) {
        this.defineRequest = defineRequest;
        this.name = name;
        this.amount = amount;
    }

    public ProcessStringRequest(String stringRequest) {
        String[] value = stringRequest.split(" ");
        this.defineRequest = value[0];
        this.name = value[1];
        this.amount = Double.valueOf(value[2]);
    }

    public String getDefineRequest() {
        return defineRequest;
    }

    public void setDefineRequest(String defineRequest) {
        this.defineRequest = defineRequest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
