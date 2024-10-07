import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Jewelry> jewelries = new ArrayList<>();
        
        for (int i = 0; i < n; ++i) {
            jewelries.add(new Jewelry(sc.nextInt(), sc.nextInt()));
        }

        jewelries = jewelries.stream().sorted().collect(Collectors.toList());

        double maxPrice = 0;

        int index = 0;

        while (m > 0 && index < jewelries.size()) {
            int weight = jewelries.get(index).getWeight();
            int price = jewelries.get(index).getPrice();
            double unitPrice = jewelries.get(index).getUnitPrice();

            if (m >= weight) {
                m -= weight;
                maxPrice += price;

            } else {
                maxPrice += unitPrice * m;
                m = 0;
            }

            ++index;
        }

        System.out.printf("%.3f", maxPrice);
    }
}

class Jewelry implements Comparable<Jewelry> {
    private final int weight;
    private final int price;
    private final double unitPrice;

    public Jewelry(int weight, int price) {
        this.weight = weight;
        this.price = price;

        this.unitPrice = (double) price / weight;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getPrice() {
        return this.price;
    }

    public double getUnitPrice() {
        return this.unitPrice;
    }

    @Override
    public int compareTo(Jewelry other) {
        return Double.compare(other.unitPrice, this.unitPrice);
    }
}