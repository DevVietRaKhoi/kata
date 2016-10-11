package hyrax.io;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Week0003 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] stringRequest = new String[12];
        ProcessRequest[] processRequests = new ProcessRequest[12];
        ArrayList<Client> clients = new ArrayList<Client>();
        ArrayList<String> output = new ArrayList<String>();

        for (int i = 0; i < stringRequest.length; i++) {
            stringRequest[i] = scan.nextLine();
            processRequests[i] = new ProcessRequest(stringRequest[i]);
        }

        for (ProcessRequest value: processRequests) {
            if (Objects.equals(value.getDefineRequest(), "A")) {
                if (Client.findClientByName(clients, value.getName()) == null) {
                    clients.add(new Client(value.getName(), value.getAmount()));
                    output.add("True");
                } else output.add("False");
            } else if (Objects.equals(value.getDefineRequest(), "D")) {
                if (Client.findClientByName(clients, value.getName()) != null) {
                    Client.findClientByName(clients, value.getName()).deposit(value.getAmount());
                    output.add("True");
                } else output.add("False");
            } else if (Objects.equals(value.getDefineRequest(), "W")) {
                if (Client.findClientByName(clients, value.getName()) != null
                        && Client.findClientByName(clients, value.getName()).getAmount() > value.getAmount()) {
                    Client.findClientByName(clients, value.getName()).wthdraw(value.getAmount());
                    output.add("True");
                } else output.add("False");
            } else {
                output.add("Invalid");
            }
        }

        for (String value:output) {
            System.out.println(value);
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

    static Client findClientByName(ArrayList<Client> clients, String name) {
        for (Client client : clients) {
            if (Objects.equals(client.getName(), name)) {
                return client;
            }
        }
        return null;
    }
    void deposit(Double amount) {
        this.amount += amount;
    }
    void wthdraw(Double amount) {
        this.amount -= amount;
    }
}

class ProcessRequest {
    
    private String defineRequest;
    private String name;
    private double amount;

    public ProcessRequest(String defineRequest, String name, double amount) {
        this.defineRequest = defineRequest;
        this.name = name;
        this.amount = amount;
    }

    public ProcessRequest(String stringRequest) {
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
