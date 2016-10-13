import java.util.*;

public class Week0003 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<String, Client> clientList = new HashMap<String, Client>();
        ClientManagement clientManagement = new ClientManagement(clientList);
        while (scan.hasNext()) {
            System.out.println(clientManagement.processRequest(scan.nextLine()));
        }
    }
}

class ClientManagement {

    private static final String ADD_NEW_CLIENT = "A";
    private static final String DEPOSIT_MONEY = "D";
    private static final String WITHDRAW_MONEY = "W";

    private HashMap<String, Client> clientList;

    public ClientManagement(HashMap<String, Client> clientList) {
        this.clientList = clientList;
    }

    public boolean addNewClient(String name, Double money) {
        if (this.clientList.get(name) == null) {
            this.clientList.put(name, new Client(name, money));
            return true;
        }
        return false;
    }

    public String processRequest(String request) {
        ProcessStringRequest processString = new ProcessStringRequest(request);
        switch (processString.getDefineRequest()) {
            case ADD_NEW_CLIENT : {
                if (addNewClient(processString.getName(), processString.getMoney())) {
                    return "True";
                } else {
                    return "False";
                }
            }
            case DEPOSIT_MONEY : {
                if (this.clientList.get(processString.getName()) != null) {
                    this.clientList.get(processString.getName()).depositMoney(processString.getMoney());
                    return "True";
                } else {
                    return "False";
                }
            }
            case WITHDRAW_MONEY : {
                if (this.clientList.get(processString.getName()) != null) {
                    this.clientList.get(processString.getName()).withdrawMoney(processString.getMoney());
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

class ProcessStringRequest {
    private String defineRequest;
    private String name;
    private double money;

    public ProcessStringRequest(String defineRequest, String name, double amount) {
        this.defineRequest = defineRequest;
        this.name = name;
        this.money = amount;
    }

    public ProcessStringRequest(String string) {
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