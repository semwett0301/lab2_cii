package utils;

import java.util.HashMap;
import java.util.Map;

public class WeightedVerticalsGraph extends Graph {

    private final Map<City, Integer> weights = new HashMap<>();

    public WeightedVerticalsGraph() {
        super();

        weights.put(City.TALLINN, 0);
        weights.put(City.RIGA, 308);
        weights.put(City.KAUNAS, 507);
        weights.put(City.ST_PETERBURG, 317);
        weights.put(City.MURMANSK, 1132);
        weights.put(City.MINSK, 639);
        weights.put(City.MOSCOW, 868);
        weights.put(City.KAZAN, 1496);
        weights.put(City.UFA, 1939);
        weights.put(City.SAMARA, 1702);
        weights.put(City.VILNUS, 264);
        weights.put(City.DAUGAVPILS, 410);
        weights.put(City.KALININGRAD, 584);
        weights.put(City.BREST, 1025);
        weights.put(City.VITEBSK, 573);
        weights.put(City.OREL, 1002);
        weights.put(City.DONETSK, 1527);
        weights.put(City.KISHINEV, 1408);
        weights.put(City.ZHITOMIR, 1050);
        weights.put(City.KIEV, 1064);
        weights.put(City.KHARKIV, 1281);
        weights.put(City.SIMFEROPOL, 1730);
        weights.put(City.ODESSA, 1495);
        weights.put(City.VOLGOGRAD, 1742);
        weights.put(City.VORONEZ, 1250);
        weights.put(City.YAROSLAVL, 900);
        weights.put(City.NIZ_NOVGOROD, 1184);
    }

    public Map<City, Integer> getWeights() {
        return weights;
    }
}
