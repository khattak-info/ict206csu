/*
 * ============================================================
 *  SYDNEY OPAL TRANSPORT SYSTEM  -  ITC206 Exam Revision Case Study
 * ============================================================
 *  One case study that covers every topic in the exam paper:
 *
 *   Q1  Arrays + counting in a range       -> countInRange()       (peak-hour tap-ons)
 *   Q2  while loop with a sentinel value   -> sumBoardings()       (passengers boarding a bus)
 *   Q3  References vs primitives           -> topUp() demo         (two variables, one card)
 *   Q4  Inheritance + aggregation (UML)    -> Person / Commuter / StationStaff / TrainLine
 *   Q5  File input + exceptions            -> readTapFile()        (taps.txt)
 *   Q6  Abstract class + polymorphism      -> OpalCard.calculateFare()
 *   Q7  Search an array from the end       -> findLastAbove()      (last expensive trip)
 *   Q8  Interfaces                         -> Chargeable, ParkingFee, StationAccessFee
 *   Q9  Overriding + ArrayList of supers   -> displayDetails() on every card type
 *
 *  Compile and run:
 *      javac OpalSystem.java
 *      java OpalSystem
 * ============================================================
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// ------------------------------------------------------------
//  INHERITANCE: shared fields live ONCE in the superclass
// ------------------------------------------------------------
class Person {
    private String name;
    private String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

// Commuter IS-A Person
class Commuter extends Person {
    private OpalCard card;          // a Commuter HAS-A card

    public Commuter(String name, String email, OpalCard card) {
        super(name, email);         // let Person set the shared fields
        this.card = card;
    }

    public OpalCard getCard() {
        return card;
    }
}

// StationStaff IS-A Person
class StationStaff extends Person {
    private String station;

    public StationStaff(String name, String email, String station) {
        super(name, email);
        this.station = station;
    }

    public String getStation() {
        return station;
    }
}

//  AGGREGATION: a TrainLine HAS commuters, but commuters
// exist on their own and are not destroyed with the line.
class TrainLine {
    private String code;
    private ArrayList<Commuter> commuters = new ArrayList<>();

    public TrainLine(String code) {
        this.code = code;
    }

    public void addCommuter(Commuter c) {
        commuters.add(c);
    }

    public int getCommuterCount() {
        return commuters.size();
    }

    public String getCode() {
        return code;
    }
}

// ------------------------------------------------------------
//  ABSTRACT CLASS, OVERRIDING, POLYMORPHISM
// ------------------------------------------------------------
abstract class OpalCard {
    private String holder;
    private double balance;

    public OpalCard(String holder, double balance) {
        this.holder = holder;
        this.balance = balance;
    }

    public String getHolder() {
        return holder;
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double amount) {
        balance += amount;
    }

    // : no body -> every concrete subclass MUST provide one
    public abstract double calculateFare();

    // : has a body -> subclasses MAY override it
    public void displayDetails() {
        System.out.printf("%-8s balance $%.2f%n", holder, balance);
    }
}

class AdultCard extends OpalCard {
    public AdultCard(String holder, double balance) {
        super(holder, balance);
    }

    @Override
    public double calculateFare() {
        return 4.80;                // Adult fare is 4.80
    }

    @Override
    public void displayDetails() {
        System.out.printf("[Adult]      %s, fare $%.2f, balance $%.2f%n",
                getHolder(), calculateFare(), getBalance());
    }
}

class ConcessionCard extends OpalCard {
    public ConcessionCard(String holder, double balance) {
        super(holder, balance);
    }

    @Override
    public double calculateFare() {
        return 2.40;                // Concession fare is 2.40
    }

    @Override
    public void displayDetails() {
        System.out.printf("[Concession] %s, fare $%.2f, balance $%.2f%n",
                getHolder(), calculateFare(), getBalance());
    }
}

class GoldSeniorCard extends OpalCard {
    public GoldSeniorCard(String holder, double balance) {
        super(holder, balance);
    }

    @Override
    public double calculateFare() {
        return 2.50;
    }
    // No displayDetails() override -> the OpalCard version is used
}

// ------------------------------------------------------------
// INTERFACE: unrelated classes promise the same method
// ------------------------------------------------------------
interface Chargeable {
    double getCharge();
}

class ParkingFee implements Chargeable {
    private double charge;

    public ParkingFee(double charge) {
        this.charge = charge;
    }

    @Override
    public double getCharge() {
        return charge;
    }
}

class StationAccessFee implements Chargeable {   // e.g. airport station fee
    private double charge;

    public StationAccessFee(double charge) {
        this.charge = charge;
    }

    @Override
    public double getCharge() {
        return charge;
    }
}

// ------------------------------------------------------------
// MAIN PROGRAM
// ------------------------------------------------------------
public class OpalSystem {

    // How many tap-ons happened in peak hours (e.g. 7..9 inclusive)?
    public static int countInRange(int[] values, int minimum, int maximum) {
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] >= minimum && values[i] <= maximum) {   // inclusive -> >= and <=
                count++;
            }
        }
        return count;
    }

    // A bus driver enters passengers boarding at each stop; 0 ends the shift.
    public static int sumBoardings(Scanner input) {
        int total = 0;
        int number = input.nextInt();       // priming read

        while (number != 0) {               // FIX 1: loop while NOT the sentinel
            total += number;                // FIX 2: += (not =+)
            number = input.nextInt();       // FIX 3: read the next value or it loops forever
        }
        return total;
    }

    //  Changes the object (visible to caller) and the local copy of amount (NOT visible).
    public static void topUp(OpalCard card, double amount) {
        card.addBalance(amount);
        amount = 0;
    }

    // Q5  Read taps.txt: one integer per line = tap-ons at a station.
    public static void readTapFile(String fileName) {
        try {
            Scanner fileIn = new Scanner(new File(fileName));
            int total = 0;

            while (fileIn.hasNextLine()) {
                String line = fileIn.nextLine().trim();
                try {
                    int taps = Integer.parseInt(line);
                    System.out.println(taps);
                    total += taps;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid entry: " + line);   // keep going
                }
            }
            fileIn.close();
            System.out.println("Total tap-ons: " + total);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    // Q7  Index of the LAST trip that cost strictly more than limit, else -1.
    public static int findLastAbove(double[] values, double limit) {
        for (int i = values.length - 1; i >= 0; i--) {   // walk backwards
            if (values[i] > limit) {                      // strictly greater -> >
                return i;                                 // first hit from the end = last one
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        heading("Q1  countInRange - peak-hour tap-ons");
        int[] tapOnHours = {6, 7, 8, 8, 9, 12, 17, 18, 9, 22};
        System.out.println("Tap-ons between 7 and 9: " + countInRange(tapOnHours, 7, 9));

        heading("Q2  Sentinel loop - passengers boarding the 333 bus");
        // In the exam this is new Scanner(System.in); a String keeps the demo automatic.
        Scanner input = new Scanner("12 5 8 0 99");
        System.out.println("Total boarded: " + sumBoardings(input));

        heading("Q3  References - two variables, ONE card");
        OpalCard ariaCard = new AdultCard("Aria", 10.00);
        OpalCard phoneWallet = ariaCard;          // copies the reference, not the card
        double amount = 5.00;
        topUp(phoneWallet, amount);
        System.out.printf("%.2f %.2f%n", ariaCard.getBalance(), phoneWallet.getBalance());
        System.out.println("amount in main is still " + amount);

        heading("Q4  Inheritance + aggregation");
        TrainLine t1 = new TrainLine("T1 North Shore");
        Commuter noah = new Commuter("Noah", "noah@example.com", new ConcessionCard("Noah", 20));
        Commuter mia = new Commuter("Mia", "mia@example.com", new AdultCard("Mia", 30));
        t1.addCommuter(noah);
        t1.addCommuter(mia);
        StationStaff sam = new StationStaff("Sam", "sam@example.com", "Central");
        System.out.println(t1.getCode() + " has " + t1.getCommuterCount() + " commuters");
        System.out.println(sam.getName() + " works at " + sam.getStation()
                + " (name inherited from Person)");

        heading("Q5  File input - taps.txt");
        readTapFile("taps.txt");
        readTapFile("missing.txt");

        heading("Q6  Abstract class - each card calculates its own fare");
        OpalCard[] cards = {
            new AdultCard("Aria", 25.00),
            new ConcessionCard("Noah", 12.00),
            new GoldSeniorCard("Margaret", 8.00)
        };
        for (OpalCard card : cards) {
            System.out.printf("%s pays $%.2f%n", card.getHolder(), card.calculateFare());
        }

        heading("Q7  findLastAbove - last trip over $4.00");
        double[] tripFares = {3.20, 4.80, 2.40, 5.10, 3.90};
        System.out.println("Index: " + findLastAbove(tripFares, 4.00));
        System.out.println("Index for limit 10: " + findLastAbove(tripFares, 10.00));

        heading("Q8  Interface - extra charges");
        Chargeable[] charges = {
            new ParkingFee(0.00),            // Park&Ride with a valid trip
            new StationAccessFee(16.40)      // airport station access fee
        };
        for (Chargeable c : charges) {
            System.out.printf("Charge: $%.2f%n", c.getCharge());
        }

        heading("Q9  Polymorphism - ArrayList<OpalCard> calling displayDetails()");
        ArrayList<OpalCard> wallet = new ArrayList<>();
        wallet.add(new AdultCard("Aria", 25.00));
        wallet.add(new ConcessionCard("Noah", 12.00));
        wallet.add(new GoldSeniorCard("Margaret", 8.00));
        for (OpalCard card : wallet) {
            card.displayDetails();           // the OBJECT's version runs (dynamic binding)
        }
    }

    private static void heading(String text) {
        System.out.println();
        System.out.println("=== " + text + " ===");
    }
}
