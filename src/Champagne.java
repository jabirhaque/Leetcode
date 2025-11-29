import java.util.ArrayList;
import java.util.List;

class Champagne {
    public static void main(String[] args){
        System.out.println(champagneTower(2, 1, 1));
    }

    public static double champagneTower(int poured, int query_row, int query_glass) {
        List<List<Double>> tower = new ArrayList<>();
        fill(tower, 0, 0, poured);
        if (query_row >= tower.size() || query_glass >= tower.get(query_row).size()) return 0;
        return tower.get(query_row).get(query_glass);
    }

    private static void fill(List<List<Double>> tower, int i, int j, double poured){
        if (tower.size() == i) tower.add(new ArrayList<>());
        while (j>=tower.get(i).size()) tower.get(i).add(0.0);
        double taken = Math.min(1-tower.get(i).get(j), poured);
        tower.get(i).set(j, tower.get(i).get(j)+taken);
        if (poured-taken>0){
            fill(tower, i+1, j, (poured-taken)/2);
            fill(tower, i+1, j+1, (poured-taken)/2);
        }
    }
}