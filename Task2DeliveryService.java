package semestr1.practise03.HW;

import java.util.Scanner;

public class Task2DeliveryService {
    public static <Int> void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть вагу відправлення (кг): ");
        double weight = scanner.nextDouble();
        if (weight <= 0) {
            System.out.println("Вага не може дорівнювати або менше 0 ");
            return;
        } else if (weight > 50.0) {
                System.out.println("Вага занадто висока");
                return;
        }
        System.out.println("Введіть відстань транспортування (км): ");
        double distance = scanner.nextDouble();
        if (distance <= 0) {
            System.out.println("Дистанція не може дорівнювати або менше 0");
            return;
        }
        System.out.println("Оберіть пункт призначення (1 - Відділення, 2 - Поштомат, 3 - Кур'єр):");
        int deliveryType = scanner.nextInt();
        scanner.nextLine();
        double deliveryCost = 0.0;
        String deliveryTypeStr = "";
        switch (deliveryType) {
            case 1 -> {
                deliveryTypeStr = "Відділення";
                deliveryCost = 50.0;
            }
            case 2 -> {
                deliveryTypeStr = "Поштомат";
                if (weight > 15.0) {
                    System.out.println("Поштомат не приймає габаридні посилки!");
                    return;
                }else {
                        deliveryCost = 60.0;
                    }
                }
            case 3 -> {
                deliveryTypeStr = "Кур'єрська доставка до дверей";
                deliveryCost = 100.0;
            }
                default -> {
                    System.out.println("Треба було Обрати пункт призначення (1 - Відділення, 2 - Поштомат, 3 - Кур'єр):");
                    return;
                }
            }
        double sales = 1.0;
        System.out.println("Ви маєте карту \"Premium\"");
        String premium = scanner.nextLine();
        String isPremiumHave = (premium.equalsIgnoreCase("так") ? "так" : "ні");
        String status = (premium.equalsIgnoreCase("так") ? "Premium (-20%)" : "базовий");
        if (isPremiumHave.equalsIgnoreCase("так")){
            sales =0.8;
        }
double distancePrice = 0.0;
if (distance <=50) {
distancePrice = 0.0;
}else if (distance >= 51 && distance <= 200) {
distancePrice = 35.0;
}else if (distance >200) {
distancePrice = 80.0;
}
    double costBeforeSales = deliveryCost + distancePrice;
    double finalCost = (costBeforeSales * sales);
    System.out.println(
                "=== ТАРИФІКАТОР СЛУЖБИ ДОСТАВКИ ===" +
            "\nВага відправлення (кг):" + weight +
            "\nВідстань транспортування (км):" + distance +
            "\nПункт призначення: " + deliveryTypeStr +
            "\nЧи є у вас карта Premium?: " + isPremiumHave +
            "\n------------- НАКЛАДНА ДОСТАВКИ -------------" +
            "\nТип доставки:                   " + deliveryTypeStr + "(базовий тариф: " + deliveryCost + "грн)" +
            "\nДоплата за відстань:            " + distancePrice + "грн" + "(" + distance + "км)" +
            "\nСума до знижки:                 " + costBeforeSales +
            "\nСтатус клієнта:                 " + status +
            "\n---------------------------------------------" +
            "\nРАЗОМ ДО СПЛАТИ:                " + finalCost +
            "\n=============================================");
        }
    }