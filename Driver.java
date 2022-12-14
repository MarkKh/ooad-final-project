import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Item> Items = new ArrayList<>();
        Item item = new Item();
        Table table = new Table();
        Customer customer = new Customer();
        Bill bill = new Bill();
        Income income = new Income();
        Expenses expense = new Expenses();
        Order orders = new Order(Items);

        Item[] items = new Item[4];
        items[0] = new Item("001", "Noodles blood soup", 30);
        items[1] = new Item("002", "Tom Yum noodle soup", 30);
        items[2] = new Item("003", "Steamed noodles without soup", 30);
        items[3] = new Item("004", "Steamed noodles without tom yum soup", 30);

        customer.addName("Mark Khomsan");
        customer.addPhoneNumber("0616768126");
        customer.addName("Nan Kanyarat");
        customer.addPhoneNumber("0873986487");

        income.addValue(20.00);
        income.addDescription("xxxxx");
        income.addValue(40.00);
        income.addDescription("yyyyy");

        expense.addValue(330.00);
        expense.addDescription("aaaaa");
        expense.addValue(1230.00);
        expense.addDescription("bbbbb");

        while (true) {

            System.out.println("\nWho are you?");
            System.out.println("1. Customer");
            System.out.println("2. Employee");
            System.out.println("3. Owner");
            System.out.println("0. Exit");

            System.out.println("Please enter 1-3 or 0 for exit : ");
            int who = scanner.nextInt();

            if (who == 1) {

                System.out.println("\n1. Login" + "\n2. Register");
                int a = scanner.nextInt();

                if (a == 1) {
                    System.out.println("\nEnter your phone number : ");
                    String phone = scanner.next();
                    boolean b = customer.login(phone);

                    if (b == true) {
                        System.out.println("\n------------Hello " + customer.get_Name() + "------------");

                        while (true) {
                            System.out.println("\n1. Order" + "\n2. Check Order" + "\n0. exit");
                            int h = scanner.nextInt();
                            if (h == 1) {

                                String tableNumber;

                                System.out.println("\nChoose one");
                                System.out.println("1.at restaurant" + "\n2.Take home");
                                System.out.println("Enter 1 or 2 : ");
                                int choose = scanner.nextInt();
                                if (choose == 1) {
                                    System.out.println("\nEnter table number : ");
                                    tableNumber = scanner.next();
                                    table.setTable(tableNumber);
                                } else if (choose == 2) {
                                    tableNumber = "[ Take home ]";
                                    table.setTable(tableNumber);
                                }

                                System.out.println("\nEnter the total Menu you would like to order : ");
                                int total = scanner.nextInt();

                                System.out.println();
                                for (int i = 0; i < total; ++i) {
                                    Item item_ = new Item();
                                    ArrayList<String> options = new ArrayList<>();

                                    System.out.println();
                                    for (Item ite : items) {
                                        System.out.println(ite.toString());
                                    }

                                    String menu;
                                    System.out.println("Enter menu what you want :");
                                    menu = scanner.next();
                                    String xmenu;
                                    if (menu.equals("001")) {
                                        xmenu = "Noodles blood soup";
                                        options.add(xmenu);
                                    } else if (menu.equals("002")) {
                                        xmenu = "Tom Yum noodle soup";
                                        options.add(xmenu);
                                    } else if (menu.equals("003")) {
                                        xmenu = "Steamed noodles without soup";
                                        options.add(xmenu);
                                    } else if (menu.equals("004")) {
                                        xmenu = "Steamed noodles without tom yum soup";
                                        options.add(xmenu);
                                    } else {
                                        options.add(null);
                                    }

                                    String size;
                                    System.out.println("\nBowl size(Large, Medium, Small) : ");
                                    size = scanner.next();
                                    item_.setSize(size);
                                    options.add(size);

                                    String RiceNoodles;
                                    System.out.println(
                                            "\nRice Noodles(1. Rice Vermicelli, 2. Rice Stick Noodles, 3. Wide Rice Noodles, 4. Glass Noodles, 5. Egg Noodles, 6. Instant Noodles) : ");
                                    RiceNoodles = scanner.next();
                                    String xRiceNoodles;
                                    if (RiceNoodles.equals("1")) {
                                        xRiceNoodles = "Rice Vermicelli";
                                        options.add(xRiceNoodles);
                                    } else if (RiceNoodles.equals("2")) {
                                        xRiceNoodles = "Rice Stick Noodles";
                                        options.add(xRiceNoodles);
                                    } else if (RiceNoodles.equals("3")) {
                                        xRiceNoodles = "Wide Rice Noodles";
                                        options.add(xRiceNoodles);
                                    } else if (RiceNoodles.equals("4")) {
                                        xRiceNoodles = "Glass Noodles";
                                        options.add(xRiceNoodles);
                                    } else if (RiceNoodles.equals("5")) {
                                        xRiceNoodles = "Egg Noodles";
                                        options.add(xRiceNoodles);
                                    } else if (RiceNoodles.equals("6")) {
                                        xRiceNoodles = "Instant Noodles";
                                        options.add(xRiceNoodles);
                                    } else {
                                        options.add(null);
                                    }

                                    String meat;
                                    System.out.println(
                                            "\nMeat(1. Marinated Pork, 2. Braised Pork, 3. Meatball, 4. Pork liver) : ");
                                    meat = scanner.next();
                                    String xMeat;
                                    if (meat.equals("1")) {
                                        xMeat = "Marinated Pork";
                                        options.add(xMeat);
                                    } else if (meat.equals("2")) {
                                        xMeat = "Braised Pork";
                                        options.add(xMeat);
                                    } else if (meat.equals("3")) {
                                        xMeat = "Meatball";
                                        options.add(xMeat);
                                    } else if (meat.equals("4")) {
                                        xMeat = "Pork liver";
                                        options.add(xMeat);
                                    } else {
                                        options.add(null);
                                    }

                                    String note;
                                    System.out.println("\nNote : ");
                                    note = scanner.next();
                                    options.add(note);

                                    item_.setItemOptions(options);
                                    Items.add(item_);

                                }

                                UUID randomUUID = UUID.randomUUID();
                                String randomId = randomUUID.toString().replaceAll("-", "");

                                orders.setOrderId(randomId);
                                orders.calculateTotalOrder();
                                System.out
                                        .println(
                                                "\n-----------------------------Ordered is-----------------------------");
                                System.out.println("Table number " + table.getTable());
                                System.out.println("Ordered by  " + customer.get_Name());
                                orders.printOrderSummary();
                                System.out
                                        .println(
                                                "--------------------------------------------------------------------\n");

                                orders.setOrderPreparing(0);
                                double va = orders.getOrderTotalAmount();
                                String de = orders.getOrderId();
                                income.addValue(va);
                                income.addDescription(de);
                            } else if (h == 2) {
                                System.out
                                        .println(
                                                "\n-----------------------------Ordered is-----------------------------");
                                System.out.println("Table number " + table.getTable());
                                System.out.println("Ordered by  " + customer.get_Name());
                                orders.printOrderSummary();
                                System.out
                                        .println(
                                                "--------------------------------------------------------------------\n");

                            } else {
                                break;
                            }
                        }

                    } else {
                        System.out.println("Please try again");
                    }
                } else if (a == 2) {
                    System.out.println("\nEnter your phone : ");
                    String p = scanner.next();
                    System.out.println("Enter your name : ");
                    String n = scanner.next();
                    customer.register(p, n);
                } else {
                }

            } else if (who == 2) {
                Employee employee = new Employee();
                System.out.println("Username : ");
                String username = scanner.next();
                System.out.println("Password : ");
                String password = scanner.next();
                boolean x = employee.Login(username, password);
                if (x == true) {
                    employee.say();

                    while (true) {
                        System.out.println("\n1. CheckOrdering" + "\n2. Receipt" + "\n0. exit");

                        System.out.println("What will you do?");
                        int employee_do = scanner.nextInt();

                        if (employee_do == 0) {
                            break;
                        } else if (employee_do == 1) {

                            if (orders.getOrderPreparing() == 1) {
                                System.out.println(
                                        "--------------------------------------------------------------------");
                                System.out.println(
                                        "                               No Order                             ");
                                System.out.println(
                                        "--------------------------------------------------------------------");
                            } else {
                                System.out.println(
                                        "--------------------------------------------------------------------");
                                System.out.println("Table number " + table.getTable());
                                System.out.println("Ordered by  " + customer.get_Name());
                                orders.printOrderSummary();
                                System.out
                                        .println(
                                                "--------------------------------------------------------------------\n");

                                System.out.println("\nHave you completed this order(Y/N) ?");
                                String CheckOrderPreparing = scanner.next();

                                if (CheckOrderPreparing.equalsIgnoreCase("y")) {
                                    orders.setOrderPreparing(1);
                                }
                            }

                        } else if (employee_do == 2) {
                            String timeStamp = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss")
                                    .format(Calendar.getInstance().getTime());
                            bill.setBillDate(timeStamp);
                            System.out.println("\n-----------------------------  Bill ------------------------------");
                            bill.showBill();
                            System.out.println("Table number " + table.getTable());
                            orders.printOrderSummary();
                            System.out.println("Ordered by  " + customer.get_Name());
                            System.out
                                    .println("--------------------------------------------------------------------\n");

                            System.out.println("do yo want to clear this order(Y/N) ?");
                            String choose = scanner.next();
                            if (choose.equalsIgnoreCase("y")) {
                                orders.setOrderId(null);
                                table.setTable(null);
                                Items.clear();
                                customer.set_Name(null);
                            } else {

                            }
                        }

                    }

                } else {
                    System.out.println("Please try again");
                }

            } else if (who == 3) {
                Owner owner = new Owner();
                System.out.println("Username : ");
                String username = scanner.next();
                System.out.println("Password : ");
                String password = scanner.next();
                boolean x = owner.Login(username, password);
                if (x == true) {
                    owner.say();
                    while (true) {
                        System.out.println("\nWhat do you want to do?" + "\n1. Check All Income"
                                + "\n2. Check All Expenses" + "\n3. Check Sum of Income" + "\n4. Chaeck Sum of Expenses"
                                + "\n5. Check Balance" + "\n6. Add Income" + "\n7. Add Expenses" + "\n0. exit");
                        int own_choose = scanner.nextInt();
                        if (own_choose == 1) {
                            income.printAll();
                        } else if (own_choose == 2) {
                            expense.printAll();
                        } else if (own_choose == 3) {
                            income.printSum();
                        } else if (own_choose == 4) {
                            expense.printSum();
                        } else if (own_choose == 5) {
                            System.out.println("------------------------------");
                            System.out.println("Total Balance is : " + (income.getSum() - expense.getSum()) + " Baht");
                            System.out.println("------------------------------");
                        } else if (own_choose == 6) {
                            System.out.println("Add Income");
                            System.out.println("Enter value :");
                            double value = scanner.nextDouble();
                            income.addValue(value);
                            System.out.println("Enter Description :");
                            String description = scanner.next();
                            income.addDescription(description);
                        } else if (own_choose == 7) {
                            System.out.println("Add Expenses");
                            System.out.println("Enter value :");
                            double value = scanner.nextDouble();
                            expense.addValue(value);
                            System.out.println("Enter Description :");
                            String description = scanner.next();
                            expense.addDescription(description);
                        } else {
                            break;
                        }
                    }
                } else {
                    System.out.println("Please try again");
                }

            } else if (who == 0) {
                break;
            } else {
                System.out.println("Please enter again!!");
            }
        }

    }

}