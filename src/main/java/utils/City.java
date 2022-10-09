package utils;

public enum City {
    VILNUS("Вильнюс"),
    VITEBSK("Витебск"),
    VORONEZ("Воронеж"),
    VOLGOGRAD("Волгоград"),
    KALININGRAD("Калининград"),
    KAUNAS("Каунас"),
    KIEV("Киев"),
    ZHITOMIR("Житомир"),
    KISHINEV("Кишинёв"),
    ST_PETERBURG("Санкт-Петербург"),
    MOSCOW("Москва"),
    MURMANSK("Мурманск"),
    OREL("Орёл"),
    ODESSA("Одесса"),
    RIGA("Рига"),
    TALLINN("Таллинн"),
    KHARKIV("Харьков"),
    YAROSLAVL("Ярославль"),
    UFA("Уфа"),
    KAZAN("Казань"),
    SAMARA("Самара"),
    BREST("Брест"),
    NIZ_NOVGOROD("Нижний Новгород"),
    DAUGAVPILS("Даугавпилс"),
    DONETSK("Донецк"),
    MINSK("Минск"),
    SIMFEROPOL("Симферополь");

    String name;

    City(String name) {
        this.name = name;
    }

    City() {}

    public String getName() {
        return name;
    }
}
