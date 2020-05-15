package main_stage;

import base.BasePreparations;
import org.decimal4j.util.DoubleRounder;
import pages.*;

import java.util.*;

public class MainPerformance extends BasePreparations {
    public static String NBU;
    public static String BuyPrivat, BuyUkrsib, BuyAval, BuyOschad;
    public static String SellPrivat, SellUkrsib, SellAval, SellOschad;
    public static Map ratesSell = new HashMap<>();
    public static Map ratesBuy = new HashMap<>();

    static final String Privat = "Приват банк";
    static final String Ukrsib = "УкрСиб банк";
    static final String Aval = "Райфайзен банк Аваль";
    static final String Oschad = "Ощадбанк";

    //блок для запуска кода через main
    public void startAll(){
        MainPerformance mainPerformance = new MainPerformance();
        mainPerformance.setUp();

        mainPerformance.openPrivatPage();
        mainPerformance.openUkrsibPage();
        mainPerformance.openAvalPage();
        mainPerformance.openOschadPage();
        mainPerformance.openNbuPage();

        mainPerformance.tearDown();
        averageSum();
}

    public void openNbuPage() {
        BankNbuPage openNbu = new BankNbuPage(driver);
        openNbu.openPage(openNbu.getUrl());
        NBU = openNbu.getRates(openNbu.getXpathNbu()).getText();
    }

    public void openPrivatPage() {
        BankPrivatPage openPrivat = new BankPrivatPage(driver);
        openPrivat.openPage(openPrivat.getUrl());
        var getRatesPrivat = openPrivat.getRates(openPrivat.getXpathPrivat()).getText();
        var splitStr = "/ ";
        String[] arr = getRatesPrivat.split(splitStr);
        BuyPrivat = arr[0];
        SellPrivat = arr[1];
        ratesSell.put(Privat, SellPrivat);
        ratesBuy.put(Privat, BuyPrivat);
    }

    public void openUkrsibPage() {
        BankUkrsibPage openUkrsib = new BankUkrsibPage(driver);
        openUkrsib.openPage(openUkrsib.getUrl());
        SellUkrsib = openUkrsib.getRates(openUkrsib.getXpathSell()).getText();
        BuyUkrsib = openUkrsib.getRates(openUkrsib.getXpathBuy()).getText();
        ratesSell.put(Ukrsib, SellUkrsib);
        ratesBuy.put(Ukrsib, BuyUkrsib);
    }

    public void openAvalPage(){
        BankAvalPage openAval = new BankAvalPage(driver);
        openAval.openPage(openAval.getUrl());
        SellAval = openAval.getRates(openAval.getXpathSell()).getText().replace(',','.');
        BuyAval = openAval.getRates(openAval.getXpathBuy()).getText().replace(',','.');
        ratesSell.put(Aval, SellAval);
        ratesBuy.put(Aval, BuyAval);
    }

    public void openOschadPage(){
        BankOschadPage openOschad = new BankOschadPage(driver);
        openOschad.openPage(openOschad.getUrl());
        SellOschad = openOschad.getRates(openOschad.getXpathSell()).getText();
        BuyOschad = openOschad.getRates(openOschad.getXpathBuy()).getText();
        ratesSell.put(Oschad, SellOschad);
        ratesBuy.put(Oschad, BuyOschad);
    }
    //считаем средние значения для покупки-продажи по банкам
    public static void averageSum(){
        var averageBuy = (Double.parseDouble(BuyPrivat)
                              + Double.parseDouble(BuyUkrsib)
                              + Double.parseDouble(BuyAval)
                              + Double.parseDouble(BuyOschad))/4;

        var averageSell = (Double.parseDouble(SellPrivat)
                              + Double.parseDouble(SellUkrsib)
                              + Double.parseDouble(SellAval)
                              + Double.parseDouble(SellOschad))/4;
        System.out.println();
        System.out.println("Средняя цена покупки  = " + DoubleRounder.round(averageBuy, 4));
        System.out.println("Средняя цена продажи = " + DoubleRounder.round(averageSell, 4));
    }
}

