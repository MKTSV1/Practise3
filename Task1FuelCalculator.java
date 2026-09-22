package semestr1.practise03.HW;

import java.util.Scanner;

public class Task1FuelCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть відстань поїздки (км): ");
        double distance = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Введіть середню витрату на 100 км (л): ");
        double fuelConsumption = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Оберіть тип пального (1 - А-95, 2 - Дизель, 3 - Газ): ");
        int fuelType = scanner.nextInt();
        if (distance <= 0 || fuelConsumption <= 0) {
            System.out.println("Erorr044, поїздка чи середня витрата пального не може дорівнювати або менше 0");
            scanner.close();
            return;
        }
        double fuelPrice = 0.0;
        String fuelName = "";
        switch (fuelType) {
            case 1 -> {
                fuelName = "A-95";
                fuelPrice = 56.60;
            }

            case 2 -> {
                fuelName = "Дизель";
                fuelPrice = 52.80;
            }
            case 3 -> {
                fuelName = "Газ";
                fuelPrice = 29.40;
            }
            default -> {
                fuelName = "Erorr045, виберіть тип пального";
                scanner.close();
            }
        }
        double neededFuel = (distance * fuelConsumption) / 100.0;
        double baseCost = neededFuel * fuelPrice;
        double finalCost = (baseCost >= 2000.0) ? baseCost * 0.95 : baseCost;
        double sales = baseCost - finalCost;
            System.out.println("=== КАЛЬКУЛЯТОР ПОЇЗДКИ ТА ПАЛЬНОГО ===" +
                    "\nВвідстань поїздки (км): " + distance +
                    "\nСередня витрата на 100 км (л): " + fuelConsumption +
                    "\nТип пального: " + fuelName +
                    "\n---------------- ЗВІТ ПОЇЗДКИ ----------------" +
                    "\nОбране пальне:                " + fuelName +
                    "\nНеобхідно пального:           " + neededFuel + " л" +
                    "\nБазова вартість:              " + Math.round(baseCost *100.0) / 100.0 + " грн" +
                    "\nЗнижка АЗС (5%):              " + Math.round(sales *100.0) / 100.0 + " грн" +
                    "\n----------------------------------------------" +
                    "\nПідсумкова сума до сплати:    " + Math.round(finalCost *100.0) / 100.0 +
                    "\n==============================================");
        }

        }