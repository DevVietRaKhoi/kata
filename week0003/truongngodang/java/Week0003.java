import java.util.*;

public class Week0003 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<String, Client> clientHashMap = new HashMap<String, Client>();
        ArrayList<String> output = new ArrayList<String>();
        ClientManagement clientManagement = new ClientManagement(clientHashMap);
        while (scan.hasNext()) {
            output.add(clientManagement.processRequest(scan.nextLine()));
        }
        for (int i = 0; i < output.size(); i++) {
            System.out.println(output.get(i));
        }
    }
}

class ClientManagement {

    private static final String ADD_NEW_CLIENT = "A";
    private static final String DEPOSIT_MONEY = "D";
    private static final String WITHDRAW_MONEY = "W";

    private HashMap<String, Client> clientHashMap;

    public ClientManagement(HashMap<String, Client> clientHashMap) {
        this.clientHashMap = clientHashMap;
    }

    public boolean addNewClient(String name, Double money) {
        if (this.clientHashMap.get(name) == null) {
            this.clientHashMap.put(name, new Client(name, money));
            return true;
        }
        return false;
    }

    public String processRequest(String request) {
        ProcessString processString = new ProcessString(request);
        switch (processString.getDefineRequest()) {
            case ADD_NEW_CLIENT : {
                if (addNewClient(processString.getName(), processString.getMoney())) {
                    return "True";
                } else {
                    return "False";
                }
            }
            case DEPOSIT_MONEY : {
                if (this.clientHashMap.get(processString.getName()) != null) {
                    this.clientHashMap.get(processString.getName()).depositMoney(processString.getMoney());
                    return "True";
                } else {
                    return "False";
                }
            }
            case WITHDRAW_MONEY : {
                if (this.clientHashMap.get(processString.getName()) != null) {
                    this.clientHashMap.get(processString.getName()).withdrawMoney(processString.getMoney());
                    return "True";
                } else {
                    return "False";
                }
            }
            default:
                return "Invalid";
        }
    }
}

class Client {
    private String name;
    private Double amount;

    public Client() {
    }

    public Client(String name, Double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public boolean depositMoney(Double money) {
        if (money > 0) {
            this.amount += money;
            return true;
        }
        return false;
    }

    public boolean withdrawMoney(Double money) {
        if (money > 0 && this.amount >= money) {
            this.amount -= money;
            return true;
        }
        return false;
    }
}

class ProcessString {
    private String defineRequest;
    private String name;
    private double money;

    public ProcessString(String defineRequest, String name, double amount) {
        this.defineRequest = defineRequest;
        this.name = name;
        this.money = amount;
    }

    public ProcessString(String string) {
        String[] value = string.split(" ");
        this.defineRequest = value[0];
        this.name = value[1];
        this.money = Double.valueOf(value[2]);
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

    public double getMoney() {
        return money;
    }

    public void setMoney(double amount) {
        this.money = amount;
    }
}