// Class to represent an inventory item
class Node {
    String name;
    double price;
    int stock;
    String id;
    Node left;
    Node right;

    public Node(String name, double price, int stock, String id) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.id = id;
        this.left = null;
        this.right = null;
    }
}

// Binary Search Tree class
class BinarySearchTree {
    Node root;

    public void insert(String name, double price, int stock, String id) {
        Node newNode = new Node(name, price, stock, id);
        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        while (true) {
            if (name.compareTo(current.name) < 0) {
                if (current.left == null) {
                    current.left = newNode;
                    return;
                }
                current = current.left;
            } else if (name.compareTo(current.name) > 0) {
                if (current.right == null) {
                    current.right = newNode;
                    return;
                }
                current = current.right;
            } else {
                // Product already exists: update price and stock
                current.price = price;
                current.stock = stock;
                return;
            }
        }
    }

    public Node search(String name) {
        Node current = root;
        while (current != null) {
            if (name.equals(current.name)) {
                return current;
            }
            current = name.compareTo(current.name) < 0 ? current.left : current.right;
        }
        return null;
    }

    public void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.printf("%-15s | $ %.2f | %3d units | ID: %s\n",
                node.name, node.price, node.stock, node.id);
        inOrder(node.right);
    }

    public void displayInventory() {
        System.out.println("Inventory:");
        System.out.println("----------------------------------------------");
        inOrder(root);
    }
}

// Main class
class InventoryStore {
    public static void main(String[] args) {
        BinarySearchTree store = new BinarySearchTree();

        store.insert("Pencil", 0.20, 175, "O8XV-5OIB-G4QV-EIJT");
        store.insert("Notebooks", 2.49, 200, "FDA9-65RX-QF35-IUPU");
        store.insert("Protractors", 1.79, 82, "KN8C-B0TK-22PE-ZFN3");
        store.insert("Erasers", 0.50, 88, "IQPL-T7QS-L1QI-3MPG");
        store.insert("Pens", 0.75, 102, "P3PC-3P4E-HBN8-ZBJG");

        // Search for a specific item
        Node item = store.search("Pens");
        if (item != null) {
            System.out.printf("Found: %s - $ %.2f - %d units - ID: %s\n",
                    item.name, item.price, item.stock, item.id);
        } else {
            System.out.println("Item not found");
        }

        // Display all products
        store.displayInventory();
    }
}
