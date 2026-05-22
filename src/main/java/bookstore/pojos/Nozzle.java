package bookstore.pojos;

import java.util.Objects;
import java.util.Scanner;

public class Nozzle extends PrinterItem implements SaleableItem {
    // Unique numeric field for printer nozzle hardware
    private double diameter;

    // Required blank constructor for data mapping requirements
    public Nozzle() {
        super();
    }

    // Loaded bucket brigade constructor linking values across the codebase
    public Nozzle(String title, double price, int copies, String brand, double diameter) {
        super(title, price, copies, brand);
        this.diameter = diameter;
    }

    // Getter for component specifications
    public double getDiameter() {
        return diameter;
    }

    // Setter for component specifications
    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    // Processing interactive prompt setup via the inheritance architecture
    @Override
    public void initialize(Scanner input) {
        super.initialize(input);
        System.out.print("Enter Nozzle Diameter (e.g., 0.4, 0.6): ");
        while (!input.hasNextDouble()) {
            System.out.print("Invalid input. Enter a decimal number for diameter: ");
            input.next();
        }
        this.diameter = input.nextDouble();
        input.nextLine(); // Clear scanner buffer space
    }

    // Editing interactive fields tracking inherited and local scope data
    @Override
    public void edit(Scanner input) {
        super.edit(input);
        System.out.print("Enter New Diameter [" + this.diameter + "]: ");
        String line = input.nextLine();
        if (!line.trim().isEmpty()) {
            try {
                this.diameter = Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid numeric format. Keeping original value.");
            }
        }
    }

    // Polymorphic sales execution adhering to interface parameters
    @Override
    public void sellItem() {
        if (getCopies() > 0) {
            System.out.println("Heating nozzle and processing sale for size " + diameter + "mm...");
            setCopies(getCopies() - 1);
        } else {
            System.out.println("Error: Out of stock for this nozzle size.");
        }
    }


    // Representation build setup loading baseline text blocks
    @Override
    public String toString() {
        return super.toString() + ", Type: Nozzle, Diameter: " + diameter + "mm";
    }

    // Equivalence configuration parsing parameters precisely
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Nozzle nozzle = (Nozzle) o;
        return Double.compare(nozzle.diameter, diameter) == 0;
    }

    // Key indexing matching parameters from inherited blocks
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), diameter);
    }
}