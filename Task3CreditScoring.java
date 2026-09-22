package semestr1.practise03.HW;

import java.util.Scanner;

public class Task3CreditScoring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть вік позичальника: ");
        int age = scanner.nextInt();
        System.out.println("Введіть офіційний місячний дохід (грн): ");
        double monthlyIncome = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Чи є негативна кредитна історія? (true/false): ");
        String hasBadCreditHistory =scanner.nextLine();
        System.out.println("Введіть запитувану суму кредиту (грн): ");
        double loanAmount = scanner.nextDouble();
        System.out.println("Введіть бажаний термін (місяців): ");
        int loanMonths = scanner.nextInt();
        double monthlyPayment = loanAmount / loanMonths;
        boolean isPaymentAffordable = (loanMonths > 0) && ((loanAmount / loanMonths) <= (monthlyIncome * 0.5));
        double rate = 0.79;
        double procent = 0.0;
        if (monthlyIncome >=35000) {
            rate = 0.855;
        }
        if (monthlyIncome >=35000) {
            procent = 14.5;
        }else{ procent = 21.0;
        }
        String result = "ВІДМОВЛЕНО";
        if (hasBadCreditHistory.equalsIgnoreCase("false") && isPaymentAffordable == true && age >= 21 && age <= 65) {
            result = "Схвалено✅";
        }
        double procentOfIncome = monthlyPayment / monthlyIncome * 100.0;
        System.out.println("=== СИСТЕМА БАНКІВСЬКОГО СКОРИНГУ ===" +
        "\nВік позичальника: " + age +
        "\nОфіційний місячний дохід (грн): " + monthlyIncome +
        "\nЧи є негативна кредитна історія?: "  + hasBadCreditHistory+
        "\nЗапитувану суму кредиту (грн): " + loanAmount+
        "\nБажаний термін (місяців): " + loanMonths+
        "\n" +
        "\n------------- РІШЕННЯ СКОРИНГУ -------------" +
        "\nСтатус заявки:                 " + result +
        "\nОрієнтовний платіж/міс:        " + monthlyPayment + "грн" + "(" + procentOfIncome +"% від доходу)" +
        "\nПерсональна ставка:            " + procent+ "% річних" +
        "\n=============================================");
        if (isPaymentAffordable == false){
            System.out.println("Ваш щомісячний платіж перевищує 50% від щомісячного доходу");
    }
        if (hasBadCreditHistory.equalsIgnoreCase("true")){
        System.out.println("Погана кредитна історія!");
    }
        if (age <21 || age > 65){
        System.out.println("Ваш вік повинен бути від 21 до 65");
    }
        if (loanAmount <=0){
        System.out.println("Введіть коректне значення на скільки місяців ви плануєте взяти кредит");
    }
}
}
