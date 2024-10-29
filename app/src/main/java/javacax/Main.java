package javacax;

import java.util.*; // подсос всего из java util

public class Main {

    private static int[] createRandomArray(int n) {
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(101);
        }
        return array;
    }
    public static <K, V> Map<V, K> swapKeysAndValues(Map<K, V> originalMap) {
        Map<V, K> swappedMap = new HashMap<>();
        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            swappedMap.put(entry.getValue(), entry.getKey());
        }
        return swappedMap;
    }

    public static void main(String[] args) {
        // zadanie 1 a
        int[] array = createRandomArray(10);
        // zadanie 1 b
        List<Integer> list = new ArrayList<>();
        for (int num : array) {
            list.add(num); // добавление нового числа в лист
        }
        System.out.println("Созданный массив: " + Arrays.toString(array));
        List<Integer> list1 = new ArrayList<>();
        list1.addAll(list);
        // zadanie 1 c
        Collections.sort(list1);
        System.out.println("Отсортированный массив: " + list1);
        list1.clear();
        list1.addAll(list);
        // zadanie 1 d
        Collections.sort(list1, Collections.reverseOrder());
        System.out.println("Реверс массива: " + list1);
        list1.clear();
        list1.addAll(list);
        // zadanie 1 e
        Collections.shuffle(list1);
        System.out.println("Список после мешания: " + list1);
        list1.clear();
        list1.addAll(list);
        // zadanie 1 f
        Collections.rotate(list1, 1);
        System.out.println("Сдвиг по фазе на 1: " + list1);
        list1.clear();
        list1.addAll(list);
        // zadanie 1 g
        Set<Integer> uniqueSet = new HashSet<>(list);
        list1.clear();
        list1.addAll(uniqueSet);
        System.out.println("УниКАЛьные: " + list1);
        // zadanie 1 h
        Set<Integer> duplicatesSet = new HashSet<>();
        List<Integer> duplicatesList = new ArrayList<>();
        for (Integer num : list) {
            if (!duplicatesSet.add(num)) {
                duplicatesList.add(num);
            }
        }
        System.out.println("Дубли: " + duplicatesList);
        // zadanie 1 i
        list1.clear();
        list1.addAll(list);
        Integer[] uniqueArray = list1.toArray(new Integer[0]);
        System.out.println("Массив из списка: " + Arrays.toString(uniqueArray));
        list1.clear();
        list1.addAll(list);
        // zadabue 1 j
        Map<Integer, Integer> countMap = new HashMap<>();
        for (Integer num : uniqueArray) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        System.out.println("Сколько раз число было в массиве: ");
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        List<Human> humans = new ArrayList<>();
        humans.add(new Human("Arsen", "Majanbekov", 42));
        humans.add(new Human("Zeus", "Ultimatov", 99));
        humans.add(new Human("Pudge", "Hooking", 72));
        humans.add(new Human("TheReal", "SmallMan", 1));
        humans.add(new Human("Ugmubhem", "Osas", 55));
        humans.add(new Human("Tayler", "TaynoDernull", 32));
        humans.add(new Human("TheReal", "OldMan", 999));

        // zadanie 3 a
        Set<Human> hashSet = new HashSet<>(humans);
        System.out.println("HashSet: " + hashSet);

        // zadanie 3 b
        Set<Human> linkedHashSet = new LinkedHashSet<>(humans);
        System.out.println("LinkedHashSet: " + linkedHashSet);

        // zadanie 3 c
        Set<Human> treeSet = new TreeSet<>(humans);
        System.out.println("TreeSet: " + treeSet);

        // zadanie 3 d
        Set<Human> WithComparator = new TreeSet<>(new HumanComparatorByLastName());
        WithComparator.addAll(humans);
        System.out.println("TreeSet from comparator: " + WithComparator);

        // zadanie 3 e
        Set<Human> Anonymous = new TreeSet<>(new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return Integer.compare(h1.getAge(), h2.getAge());
            }
        });
        Anonymous.addAll(humans);
        System.out.println("TreeSet with anonymous age comparator: " + Anonymous);

        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("Four", 4);
        originalMap.put("Five", 5);
        originalMap.put("Six", 6);

        Map<Integer, String> swappedMap = swapKeysAndValues(originalMap);

        System.out.println("Original Map: " + originalMap);
        System.out.println("Swapped Map: " + swappedMap);
    }
    // Обратите внимание на выводы разных сетов. Почему так произошло? В чем отличие
    // каждого из рассмотренных подходов? Ответы на эти вопросы укажите в
    // комментариях
    // HashSet - элементы в любом порядке
    // LinkedHashSet - элементы *поссылке* тобишь в порядке добавления
    // TreeSet - порядок естественного справнения от компаратора
    // TreeSet с компаратором - элементы в порядке опредленном компаратором
    // TreeSet с анононом по возрасту - элементы от младшего к старшему

    public class WordFrequencyCounter {
        public static void main(String[] args) {
            String text = "If there is a choice between a greater evil and a lesser evil, I would prefer not to choose";
            Map<String, Integer> wordFrequency = countWordFrequency(text);

            // вывод
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }

        public static Map<String, Integer> countWordFrequency(String text) {
            // преобразование строки в нижний регистр
            text = text.toLowerCase();

            // храниение слов и частоты появления слова
            Map<String, Integer> wordFrequency = new HashMap<>();

            // раздел на слова по пробелам
            String[] words = text.split("\\s+");

            // обновление частоты в hash
            for (String word : words) {
                // делит символов которые не буквы
                word = word.replaceAll("[^a-zA-Z]", "");

                // слово не пустое - обновление частоты
                if (!word.isEmpty()) {
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }
            return wordFrequency;
        }

    }
}