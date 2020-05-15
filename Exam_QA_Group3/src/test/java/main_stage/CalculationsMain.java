package main_stage;
import java.util.*;

/* Написать программу которая будет:
        1. Заходить на сайты банков
        2. Записывать 2 переменные: курс покупки и курс продажи валют (гривна\доллар)
        3. Вычислить средний курс валют (отдельно для покупки и продажи между всеми
        банками) и вывести значение в консоль
        4. Вывести в консоль банк с самым низким курсом покупки доллара
        5. Вывести в консоль банк с самым высоким курсом продажи */

public class CalculationsMain extends MainPerformance{
    public static void main(String []args){

        //главная часть (запуск всей программы)
        MainPerformance mainPerformance = new MainPerformance();
        mainPerformance.startAll();
        System.out.println();
        System.out.println("Курс НБУ: "+ NBU);

        //вся сортировка от меньшего к большему
        //сортируем значения для покупки

        List listBuy=new ArrayList(ratesBuy.entrySet());

        Collections.sort(listBuy,new Comparator(){
            public int compare(Object obj1, Object obj2){
                return ((Comparable)((Map.Entry)(obj1)).getValue

                        ()).compareTo(((Map.Entry)(obj2)).getValue());
            }
        });
        //System.out.println(listBuy);

        System.out.println("Самый низкий курс покупки: "+ listBuy.get(0));

       //сортируем значения для продажи

        List listSell=new ArrayList(ratesSell.entrySet());


        Collections.sort(listSell,new Comparator(){
            public int compare(Object obj1, Object obj2){
                return ((Comparable)((Map.Entry)(obj1)).getValue

                        ()).compareTo(((Map.Entry)(obj2)).getValue());
            }
        });
        //System.out.println(listSell);

        System.out.println("Самый высокий курс продажи: "+ listSell.get(3));



    }

}
