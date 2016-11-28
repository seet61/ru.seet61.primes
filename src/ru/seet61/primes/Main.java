package ru.seet61.primes;

import java.util.ArrayList;
import java.util.List;

/**
 * Напишите программу, которая вычислит простые числа в пределах от 2 до 100.
 *(Опционально) Дополните программу так, чтобы она вычисляла составные числа.
 *
 * Для нахождения простых числе воспользуюсь алгоритмом "Решето Эратосфена".
 * 1. Выписать подряд все целые числа от двух до n (2, 3, 4, …, n).
 * 2. Пусть переменная p изначально равна двум — первому простому числу.
 * 3. Зачеркнуть в списке числа от 2p до n считая шагами по p (это будут числа кратные p: 2p, 3p, 4p, …).
 * 4. Найти первое незачёркнутое число в списке, большее чем p, и присвоить значению переменной p это число.
 * 5. Повторять шаги 3 и 4, пока возможно.
 *
 * Created by dmitry.arefyev on 28.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Ишем простые числа по алгоритму \"Решето Эратосфена\"");
        List list = new ArrayList<Integer>();
        int p = 2;

        //Заполняем цикл п.1-2
        for (int i=2; i < 101; i++) {
            list.add(i);
        }

        System.out.println("Размер массива: " + list);
        List natural = list;
        // п.3
        natural = workWithList(p, natural);

        // п.4-5
        List temp = natural;
        for (int i=0; i < natural.size(); i++) {
            int di = (int) natural.get(i);
            if (di != 2 && di >p) {
                p = di;
                natural = workWithList(p, natural);
            }
        }

        System.out.println("Результат: " + natural );
    }

    /**
     * Работаем с элементами массива
     * @param p
     * @param natural
     * @return
     */
    private static List workWithList(int p, List natural) {
        for (int i=2;i<100;i++) {
            if (p*i < 101) {
                natural = numberCleaning(p*i, natural);
            }
        }
        return natural;
    }

    /**
     *  Метод предназначен для зачеркивания чисел p*i
     * @param i
     * @param natural
     * @return
     */
    private static List numberCleaning(int i, List natural) {
        if (natural.contains(i)) {
            natural.remove(natural.indexOf(i));
        }
        return natural;
    }
}
