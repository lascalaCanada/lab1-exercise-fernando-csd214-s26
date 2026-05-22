package bookstore.pojos;

import java.util.Objects;
import java.util.Scanner;

public class Filament extends PrinterItem implements SaleableItem {
    // Unique field for filament components
    private String materialType;

    // No-argument constructor for framework compatibility
    public Filament() {
        super();
    }

    // Full constructor passing values up the three levels of inheritance
    public Filament(String title, double price, int copies, String brand, String materialType) {
        super(title, price, copies, brand);
        this.materialType = materialType;
    }

    // Getter for material type
    public String getMaterialType() {
        return materialType;
    }

    // Setter for material type
    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    // Overriding initialize to process parent setup before local data input
    @Override
    public void initialize(Scanner input) {
        super.initialize(input);
        System.out.print("Enter Material Type (e.g., PLA, ABS): ");
        this.materialType = input.nextLine();
    }

    // Overriding edit to enable modification of all fields down the pipeline
    @Override
    public void edit(Scanner input) {
        super.edit(input);
        System.out.print("Enter New Material Type [" + this.materialType + "]: ");
        String line = input.nextLine();
        if (!line.trim().isEmpty()) {
            this.materialType = line;
        }
    }

    // Polymorphic sales execution tracking inventory updates
    @Override
    public void sellItem() {
        if (getCopies() > 0) {
            System.out.println("Processing sale for Filament brand " + getBrand() + " (" + materialType + ")...");
            setCopies(getCopies() - 1);
        } else {
            System.out.println("Error: Out of stock for this filament item.");
        }
    }

    // Identity method providing explicit representation including super attributes
    @Override
    public String toString() {
        return super.toString() + ", Type: Filament, Material: " + materialType;
    }

    // Identity comparison matching structure and internal attributes
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Filament filament = (Filament) o;
        return Objects.equals(materialType, filament.materialType);
    }

    // Hash generation mechanism matching current data structures
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), materialType);
    }
}