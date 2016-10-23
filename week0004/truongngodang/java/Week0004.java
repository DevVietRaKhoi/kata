import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Week0004 {

    public static void main(String[] args) {
        if (args.length == 2) {
            ArrayList<Guest> guestsEvent1 = ReaderCVS.read(args[0]);
            ArrayList<Guest> guestsEvent2 = ReaderCVS.read(args[1]);
            Response response = new Response();
            Checker checker = new Checker();
            checker.check(guestsEvent1, guestsEvent2);
            System.out.println(response.standardPrint(checker.getGuestErrors()));
        }
    }
}

class Guest {
    private String fname;
    private String lname;
    private String email;

    public Guest(String fname, String lname, String email) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
    }

    public Guest() {
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

class ReaderCVS {

    public static ArrayList<Guest> read(String csvFilename) {
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<Guest> guests = new ArrayList<Guest>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(csvFilename)));
            for (int i = 0; (line = br.readLine()) != null; i++) {
                if (i > 0) {
                    String[] infos = line.split(cvsSplitBy);
                    guests.add(new Guest(infos[0], infos[1], infos[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return guests;
    }
}

class Checker {
    private ArrayList<Guest> guestErrors = new ArrayList<Guest>();

    public ArrayList<Guest> getGuestErrors() {
        return guestErrors;
    }

    public void check(ArrayList<Guest> guestEvent1, ArrayList<Guest> guestEvent2) {
        boolean temp = guestEvent1.size() > guestEvent2.size();
        if (temp) {
            for (int i = 0; i < guestEvent2.size(); i++) {
                for (int j = 0; j < guestEvent1.size(); j++) {
                    if (Objects.equals(guestEvent2.get(i).getEmail(), guestEvent1.get(j).getEmail())) {
                        this.guestErrors.add(guestEvent2.get(i));
                    }
                }
            }
        } else {
            for (int i = 0; i < guestEvent1.size(); i++) {
                for (int j = 0; j < guestEvent2.size(); j++) {
                    if (Objects.equals(guestEvent1.get(i).getEmail(), guestEvent2.get(j).getEmail())) {
                        this.guestErrors.add(guestEvent1.get(i));
                    }
                }
            }
        }
    }
}

class Response {
    private String result;

    public String getResult() {
        return result;
    }

    public String standardPrint(ArrayList<Guest> guestErrors) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < guestErrors.size(); i++) {
            sb.append(guestErrors.get(i).getFname()).append(" ");
            sb.append(guestErrors.get(i).getLname()).append(" ");
            sb.append("<").append(guestErrors.get(i).getEmail()).append(">");
            if (i != guestErrors.size() - 1) {
                sb.append("\n");
            }
        }
        this.result = String.valueOf(sb);
        return String.valueOf(sb);
    }
}