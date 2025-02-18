package task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.aston.dvorianchykov_sa.task3.Product;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    private final List<Product> productList = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        productList.add(new Product("молоко", "молочные продукты", new BigDecimal("90.50")));
        productList.add(new Product("творог", "молочные продукты", new BigDecimal("69.70")));
        productList.add(new Product("стейк", "мясные продукты", new BigDecimal("900.34")));
        productList.add(new Product("печень свиная", "мясные продукты", new BigDecimal("334.12")));
        productList.add(new Product("картошка", "овощи", new BigDecimal("55.20")));
        productList.add(new Product("капуста", "овощи", new BigDecimal("24.12")));
    }

    @Test
    @DisplayName("Вывести числа в диапазоне от 1 до 50 с шагом 2.")
    public void stream1() {
        Stream.iterate(1, i -> i < 50, i -> i + 2)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("Посчитать сумму чисел в массиве [1, 2, 3, 4, 5], используя reduce()")
    public void stream2() {
        int[] arr = {1,2,3,4,5};
        int result = Arrays.stream(arr).reduce((a, b) -> a + b).getAsInt();
        //int result = Arrays.stream(arr).reduce(Integer::sum).getAsInt();
        System.out.println(result);
    }

    @Test
    @DisplayName("Выведите только те элементы коллекции, которые удовлетворяют определенному условию - являются уникальными.")
    public void stream3() {
        List<Integer> list = List.of(1, 3, 5, 7, 7, 1, 4, 9);
        list.stream()
                .collect(Collectors.groupingBy(elem -> elem, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("Создать два стрима: один из чисел от 0 до 10, другой из чисел от 10 до 20. Объединить их в один стрим и вывести на экран числа больше 10.")
    public void stream4() {
        Stream<Integer> stream1 = Stream.iterate(0, i -> i < 10, i -> i + 1);
        Stream<Integer> stream2 = Stream.iterate(10, i -> i < 20, i -> i + 1);
        Stream.of(stream1, stream2)
                .flatMap(stream -> stream.filter(elem -> elem > 10))
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("Разделить слова в Stream на две группы по первой букве: гласные и согласные, посчитать количество слов в каждой группе.")
    public void stream5() {
        List<String> frutList = List.of("Apple", "Banana", "orange", "mango");
        List<Character> vowelsList = List.of('A', 'E', 'I', 'O', 'U', 'Y');
        Map<Boolean, List<String>> map = frutList.stream()
                .collect(Collectors.partitioningBy(word -> vowelsList.contains(word.toUpperCase().charAt(0))));

        System.out.println("Начинаются с гласной: " + (long) map.get(true).size());
        System.out.println("Начинаются с согласной: " + (long) map.get(false).size());
    }

    @Test
    @DisplayName("Создание двух Stream из массивов целых чисел и объединение их в один, затем вывод на экран суммы квадратов элементов этого Stream.")
    public void stream6() {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 6, 6, 8, 9};
        Stream<Integer> stream1 = Arrays.stream(arr1).boxed();
        Stream<Integer> stream2 = Arrays.stream(arr2).boxed();
        int result = Stream.of(stream1, stream2)
                .flatMap(stream -> stream.map(elem -> elem * elem))
                .reduce(Integer::sum)
                .orElse(0);
        System.out.println(result);
    }

    @Test
    @DisplayName("Разделить продукты в Stream на несколько групп по категориям (например, молочные продукты, мясные продукты, овощи, фрукты), " +
                    "посчитать стоимость продуктов в каждой группе.")
    public void stream7() {
        productList.stream()
                .collect(Collectors.groupingBy(Product::getCategory))
                .forEach((key, value) -> System.out.println(key + ": " + value.stream()
                        .map(Product::getPrice)
                        .reduce(BigDecimal::add)
                        .orElse(new BigDecimal(0))));
    }

    @Test
    @DisplayName("Соберите продукты в Stream в один продукт, сложив цены и категории и выведите результат.")
    public void stream8() {
        String unionCategories = productList.stream()
                .map(Product::getCategory)
                .collect(Collectors.joining(" | "));
        BigDecimal unionPrices = productList.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);

        Product unionProduct = new Product("Union product", unionCategories, unionPrices);
        unionProduct.print();
    }

    @Test
    @DisplayName("Создание Stream целых чисел и поиск всех чисел, у которых сумма цифр равна заданному числу.")
    public void stream9() {
        int target = 5;
        List<Integer> resList = Stream.of(11111, 31, 50, 74, 78, 14, 45, 41)
                .filter(num -> {
                    int sum = String.valueOf(num)
                            .chars()
                            .map(Character::getNumericValue)
                            .sum();
                    return sum == target;
                })
                .collect(Collectors.toList());

        System.out.println(resList);
    }

    @Test
    @DisplayName("Создание Stream объектов и поиск всех объектов, у которых определенное поле равно определенному значению.")
    public void stream10() {
        List<Product> products = productList.stream()
                .filter(product -> product.getCategory().toLowerCase().startsWith("молочные")
                        && product.getPrice().compareTo(new BigDecimal("70")) < 0)
                .collect(Collectors.toList());
        System.out.println(products);
    }

}
