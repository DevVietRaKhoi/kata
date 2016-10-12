import java.util.*;

public class Week0003 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<String> stringRequest = new ArrayList<String>();
        ArrayList<ProcessStringRequest> processRequests = new ArrayList<ProcessStringRequest>();
        HashMap<String, Client> clients = new HashMap<String, Client>();
        ArrayList<String> output = new ArrayList<String>();

        for (int i = 0; scan.hasNext(); i++) {
            stringRequest.add(scan.nextLine());
            processRequests.add(new ProcessStringRequest(stringRequest.get(i)));
        }
        scan.close();

        processRequest(processRequests, clients, output);

        output.forEach(System.out::println);
    }

    static void processRequest(ArrayList<ProcessStringRequest> processRequests,
                               HashMap<String, Client> clients,
                               ArrayList<String> output) {
        for (ProcessStringRequest value : processRequests) {
            if (Objects.equals(value.getDefineRequest(), "A")) {
                if (clients.get(value.getName()) == null) {
                    clients.put(value.getName(), new Client(value.getName(), value.getAmount()));
                    output.add("True");
                } else output.add("False");
            } else if (Objects.equals(value.getDefineRequest(), "D")) {
                if (clients.get(value.getName()) != null) {
                    clients.get(value.getName()).deposit(value.getAmount());
                    output.add("True");
                } else output.add("False");
            } else if (Objects.equals(value.getDefineRequest(), "W")) {
                if (clients.get(value.getName()) != null
                        && clients.get(value.getName()).getAmount() > value.getAmount()) {
                    clients.get(value.getName()).withdraw(value.getAmount());
                    output.add("True");
                } else output.add("False");
            } else {
                output.add("Invalid");
            }
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
