# Bookstore CLI Application

> - [git repository](https://github.com/fcarella/lab1-exercise-fred-carella-csd214-s26)
>  - [based on bookstore git repository: ](https://github.com/fcarella/bookstore-2026-01-30)

- A console-based Java application for managing a bookstore inventory, performing sales, and tracking cash flow. This project demonstrates object-oriented programming concepts including inheritance, polymorphism, and interface implementation in Java 24.

## Features

*   **Inventory Management:**
    *   **Books:** Manage items with Title, Author, Price, and Copies.
    *   **Magazines:** Manage periodicals with Order Quantity and Issue Date.
    *   **Disc Magazines:** Specialized magazines that include a disc.
    *   **Tickets:** Simple saleable items with a description and price.
*   **CRUD Operations:** Add, Edit, and Delete items from the inventory.
*   **Sales System:** Sell items to decrement inventory count and increase the Cash Till total.
*   **Data Generation:** Uses `JavaFaker` to populate the inventory with realistic dummy data.
*   **Menu System:** Interactive console menu for navigation.

## Class Hierarchy

![Class Diagram](documentation/bookstore-2026-01-30-142617.png)

The hierarchy implements the following structure:
*   **SaleableItem (Interface):** Defines `sellItem()` and `getPrice()`.
*   **Editable (Abstract):** Handles console input/output and parsing.
*   **Publication:** Base class for Books and Magazines (Title, Price, Copies).

## Prerequisites

*   **Java JDK:** Version 24
*   **Maven:** 3.6+

## Dependencies

*   [JavaFaker](https://github.com/DiUS/java-faker) (1.0.2): For generating random test data.
*   [JUnit 5](https://junit.org/junit5/) (5.10.0): For unit testing.

## How to Run

1.  **Compile the project:**
    ```bash
    mvn clean compile
    ```

2.  **Run the application:**
    ```bash
    mvn exec:java -Dexec.mainClass="csd214.bookstore.Main"
    ```

## Usage

Upon starting, the application will populate the list with random data. You will see the following menu:

```text
***********************
 1. Add Items
 2. Edit Items
 3. Delete Items
 4. Sell item(s)
 5. List items
99. Quit
***********************
```

*   **Add Items:** Choose a specific type (Book, Magazine, etc.) and follow the prompts.
*   **Edit Items:** Select an index from the list to modify fields.
*   **Sell Items:** Select an index to sell. This decreases the 'Copies' count (for Publications) and adds the price to the internal Cash Till.

## Running Tests

Unit tests are implemented using JUnit 5 to verify the logic of POJOs and input mocking.

Run the tests using Maven:

```bash
mvn test
```

## Project Structure

```
src/
├── main/
│   └── java/
│       └── csd214/
│           └── bookstore/
│               ├── Main.java           # Entry point
│               ├── App.java            # Controller / Menu Logic
│               └── pojos/              # Data Models
│                   ├── Editable.java
│                   ├── SaleableItem.java
│                   ├── Product.java
│                   ├── Publication.java
│                   ├── Book.java
│                   ├── Magazine.java
│                   ├── DiscMag.java
│                   ├── Ticket.java
│                   └── CashTill.java
└── test/
    └── java/
        └── csd214/
            └── bookstore/
                └── pojos/              # Unit Tests
```

*________________________________________________________________________________________*

# LAB 1 - All statements

## Phase 1

### Analysis — Step 1 (Niche Selection & Analysis)

* **Problem Statement**

    The 3D Printer Store specializes in selling equipment, materials, and digital assets for hobbyists and professionals working with additive manufacturing. The store offers 3D printers, filaments, nozzles, accessories, and premium STL files for custom printing. Customers can also purchase pre‑printed customized pieces made on demand. The goal of the store is to provide a complete ecosystem for users who want reliable hardware, high‑quality materials, and exclusive digital models. 

### Noun / Verb Table

| **Nouns (Potential Classes / Attributes)** | **Verbs (Potential Methods)** |
| --- | --- |
| 3D Printer | Print() |
| Filament | LoadMaterial() |
| Nozzle | Replace() |
| Accessory | Install() |
| STL File | Download() |
| Custom Printed Piece | Customize() |

### Synonym Identification
* Filament = Material
* Nozzle = Extruder Tip

## PHASE 2
### AI‑Assisted Architectural Blueprinting

#### Abstract Class (extends Product)
* Class Name: PrinterItem
* Parent Class: Product
* Unique Field (common to all items in this niche):
* * String brand

#### Concrete Class 1
* Class Name: Filament
* Parent Class: PrinterItem
* Unique Field:
    * String materialType  
      (e.g., PLA, ABS, PETG)

#### Concrete Class 2
* Class Name: Nozzle
* Parent Class: PrinterItem
* Unique Field:
    * double diameter  
      (e.g., 0.4mm, 0.6mm, 0.8mm)



*________________________________________________________________________________________*
