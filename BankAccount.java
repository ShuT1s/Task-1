import java.time.LocalDateTime;

public class BankAccount
{
    String UserName;                                                 //имя владельца
    int balance = 0;                                                 //баланс
    LocalDateTime DateForOpen = LocalDateTime.of(2024, 1, 1, 12, 0); //дата открытия
    boolean accountisblocked = false;                                //заблокирован ли счёт

    // Конструктор, принимающий только имя владельца
    public BankAccount(String userName)
    {
        this.UserName = userName;
    }

    // Метод для пополнения счета
    public boolean deposit(int amount)
    {
        if (amount > 0)
        {
            balance += amount;
            System.out.println("Пополнение на " + amount + " успешно");
            return true;
        }
        else
        {
            System.out.println("Сумма для пополнения должна быть положительной");
            return false;
        }
    }

    // Метод для снятия денег со счета
    public boolean withdraw(int amount)
    {
        if (amount > 0 && balance >= amount)
        {
            balance -= amount;
            System.out.println("Снятие " + amount + " успешно");
            return true;
        }
        else if (amount <= 0)
        {
            System.out.println("Сумма для снятия должна быть положительной");
            return false;
        }
        else
        {
            System.out.println("Недостаточно средств на счете");
            return false;
        }
    }

    // Метод для перевода денег на другой счет
    public boolean transfer(BankAccount otherAccount, int amount)
    {
        if (amount > 0 && balance >= amount)
        {
            balance -= amount;
            otherAccount.balance += amount;
            System.out.println("Перевод " + amount + " на счет " + otherAccount.UserName + " успешно");
            return true;
        }
        else if(amount <= 0)
        {
            System.out.println("Сумма для перевода должна быть положительной");
            return false;
        }
        else
        {
            System.out.println("Недостаточно средств на счете для перевода");
            return false;
        }
    }
}
