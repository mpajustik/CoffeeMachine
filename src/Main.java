import java.util.Scanner;

public class Main {

    static int water = 400;
    static int milk = 540;
    static int coffeeBeans = 120;
    static int cups = 9;
    static int money = 550;

    public static void main(String[] args) {
        boolean nextAction = true;
        while(nextAction){
            nextAction = allActions();
        }
    }

    public static boolean inventory() {
        System.out.println("The coffee machine has:\n" +
                water + " ml of water\n" +
                milk + " ml of milk\n" +
                coffeeBeans + " g of coffee beans\n" +
                cups + " disposable cups\n" +
                "$" + money + "$ of money");
        System.out.println("Write action (buy, fill, take): ");
        return true;
    }

    public static boolean buy() {
        Scanner scanner = new Scanner(System.in);
        String coffeeBuyAction;
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        coffeeBuyAction = scanner.nextLine();
        switch (coffeeBuyAction) {
            case "1":
                espresso();
                break;
            case "2":
                latte();
                break;
            case "3":
                cappuccino();
                break;
            case "back":
                break;
        }
        return true;

    }

    public static boolean allActions(){
        Scanner scanner = new Scanner(System.in);
        String action;
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        action = scanner.nextLine();
        System.out.println(action);
        if(action.equals("take")){
            take();
            return true;
        }
         else if(action.equals("buy")){
            buy();
            return true;
        }

        else if(action.equals("fill")) {
            fill();
            return true;
        }

        else if(action.equals("remaining")){
            inventory();
            return true;
        }

        else if(action.equals("exit")){
            return false;
        } else {
            return true;
        }
    }

    public static void fill() {
        Scanner scanner = new Scanner(System.in);
        int fillWater, fillMilk, fillCoffeeBeans, fillCups;
        System.out.println("Write how many ml of water you want to add: ");
        fillWater = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        fillMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        fillCoffeeBeans = scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add: ");
        fillCups = scanner.nextInt();
        water += fillWater;
        milk += fillMilk;
        coffeeBeans += fillCoffeeBeans;
        cups += fillCups;
    }

    public static void take() {
        System.out.println("I gave you $" + money);
        money -= money;
    }

    public static void espresso() {
        /*For one espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
         */
        if(water >= 250 && coffeeBeans >= 16 && cups >= 0){
            System.out.println("I have enough resources, making you a coffee!");
            water -= 250;
            coffeeBeans -= 16;
            cups--;
            money += 4;
        } else if (water <350) {
            System.out.println("Sorry, not enough water!");
        }  else if (coffeeBeans < 20) {
            System.out.println("Sorry, not enough Coffee Beans!");
        } else if (cups <1) {
            System.out.println("Sorry, not enough cups!");
        }

    }

    public static void latte() {
        /*For a latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
         */

        if(water >= 350 && milk >= 75 && coffeeBeans >= 20 && cups >= 0){
            System.out.println("I have enough resources, making you a coffee!");
            water -= 350;
            milk -= 75;
            coffeeBeans -= 20;
            cups--;
            money += 7;
        } else if (water <350) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < 75) {
            System.out.println("Sorry, not enough milk!");
        } else if (coffeeBeans < 20) {
            System.out.println("Sorry, not enough Coffee Beans!");
        } else if (cups <1) {
            System.out.println("Sorry, not enough cups!");
        }

    }

    public static void cappuccino() {
        /*cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee beans. It costs $6.
         */
        if(  water >= 200 && milk >= 100 && coffeeBeans >= 12 && cups >= 0){
            System.out.println("I have enough resources, making you a coffee!");
            water -= 200;
            milk -= 100;
            coffeeBeans -= 12;
            cups--;
            money += 6;
        } else if (water <200) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < 100) {
            System.out.println("Sorry, not enough milk!");
        } else if (coffeeBeans < 12) {
            System.out.println("Sorry, not enough Coffee Beans!");
        } else if (cups <1) {
            System.out.println("Sorry, not enough cups!");
        }

    }

    public static void coffeeMachineAction() {
        Scanner scanner = new Scanner(System.in);
        int cupsOfCoffee, water, milk, coffeeBeans, waterAmount, milkAmount, coffeeBeansAmount, maxCupsOfCoffee;
        System.out.println("Write how many ml of water the coffee machine has:");
        waterAmount = scanner.nextInt();
        maxCupsOfCoffee = waterAmount / 200;
        System.out.println("Write how many ml of milk the coffee machine has:");
        milkAmount = scanner.nextInt();
        if (milkAmount / 50 < maxCupsOfCoffee) {
            maxCupsOfCoffee = milkAmount / 50;
        }
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        coffeeBeansAmount = scanner.nextInt();
        if (coffeeBeansAmount / 15 < maxCupsOfCoffee) {
            maxCupsOfCoffee = coffeeBeansAmount / 15;
        }

        System.out.println("Write how many cups of coffee you will need: ");
        cupsOfCoffee = scanner.nextInt();
        /*
        cupsOfCoffee = scanner.nextInt();
        water = cupsOfCoffee * 200;
        milk = cupsOfCoffee * 50;
        coffeeBeans = cupsOfCoffee * 15;

         */
        if (maxCupsOfCoffee > cupsOfCoffee) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (maxCupsOfCoffee - cupsOfCoffee) + " more than that)");
        } else if (maxCupsOfCoffee == cupsOfCoffee) {
            System.out.println("Yes, I can make that amount of coffee");
        } else {
            System.out.println("No, I can make only " + maxCupsOfCoffee + " cup(s) of coffee");
        }
    }
}
