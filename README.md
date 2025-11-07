# Store Inventory

This repository contains a small example Java program that implements a basic inventory manager using a binary search tree (BST).

Files included
- `InventoryStore.java`  translated English version of the original `InventarioLoja.java`. It defines a `Node` class for inventory items and a `BinarySearchTree` for inserting/searching/displaying items.

What it does
- Stores products (name, price, stock quantity, ID) in a BST keyed by product name.
- Allows inserting new products or updating existing ones.
- Provides a search method to find a product by name.
- Prints the inventory in sorted order (in-order traversal).

How to compile and run
1. Open a terminal/PowerShell in this repository folder (or use an IDE):

```powershell
cd C:\Users\gabby\Downloads\store-inventory
javac InventoryStore.java
java InventoryStore
```

2. The program prints a search result for "Pens" and then lists the inventory.

Notes
- This is a simple educational example  no persistence, no GUI, and no external dependencies.
- If you want the original Portuguese file restored as well, I can add `InventarioLoja.java` alongside the translated file.

