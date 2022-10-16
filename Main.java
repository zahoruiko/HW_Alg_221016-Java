import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Задача №1
        System.out.println("Задача №1:");
        int[] sourceArray = new int[]{25, 14, 56, 15, 47};
        System.out.println("Исходный массив = " + Arrays.toString(sourceArray));
        System.out.println("Добавление значения в массив (позиция первого элемента = 0)");
        System.out.println("Вариант №1: Результат (добавление числа 5 в начало): " + Arrays.toString(insertValueInTheArray(sourceArray, 5, 0, true)));
        System.out.println("Вариант №2: Результат (добавление числа 5 в начало): " + Arrays.toString(insertValueInTheArrayV2(sourceArray, 5, 0, true)));
        System.out.println("Вариант №1: Результат (добавление числа 5 в позицию 2): " + Arrays.toString(insertValueInTheArray(sourceArray, 5, 2, true)));
        System.out.println("Вариант №2: Результат (добавление числа 5 в позицию 2): " + Arrays.toString(insertValueInTheArrayV2(sourceArray, 5, 2, true)));
        System.out.println("Вариант №1: Результат (добавление числа 5 в конец): " + Arrays.toString(insertValueInTheArray(sourceArray, 5, 4, true)));
        System.out.println("Вариант №2: Результат (добавление числа 5 в конец): " + Arrays.toString(insertValueInTheArrayV2(sourceArray, 5, 4, true)));
        System.out.println("");

        // Задача №2
        System.out.println("Задача №2:");
        sourceArray = new int[]{25, 14, 56, 15, 47};
        System.out.println("Исходный массив = " + Arrays.toString(sourceArray));
        // Вариант №1
        HashMap<String, Integer> result = getMinAndMax(sourceArray);
        System.out.println("Вариант №1: Min = " + result.get("min") + " Max = " + result.get("max"));
        // Вариант №2
        result = getMinAndMaxV2(sourceArray);
        System.out.println("Вариант №2: Min = " + result.get("min") + " Max = " + result.get("max"));
    }



    // Задача №1
    // Добавление элемента в массив
    public static int[] insertValueInTheArray(int[] sourceArray, int value, int position, boolean keepOriginalArraySize) {
        // Так как мы доавляем значение в массив, а не переопределяем существующее,
        // поэтому создаем новый массив, который вместит в себя все значения
        int[] resultArray;
        int arrayLengthCorrection;
        if (keepOriginalArraySize) {
            resultArray = new int[sourceArray.length];
            arrayLengthCorrection = 1;
        } else {
            resultArray = new int[sourceArray.length + 1];
            arrayLengthCorrection = 0;
        }
        // Если значение добавляется в начало массива
        if(position == 0) {
            // Указываем значение для элемента, который находится в нулевой позиции
            resultArray[position] = value;
            // Начиная с следующей позиции (1) результирующего массива, копируем в него значения из исходного массива (с учетом коррекции)
            for (int i = 0; i < sourceArray.length - arrayLengthCorrection; i++) {
                resultArray[i + 1] = sourceArray[i];
            }
        } else if (position > 0 && position < resultArray.length - 1) { // Если значение добавляется в середину массива
            // Копируем в результирующий массив значения от 0 до позиции, в которую должен быть вставлен новый элемент
            for (int i = 0; i < position; i++) {
                resultArray[i] = sourceArray[i];
            }
            // Указываем значение для элемента, который находится в заданной позиции
            resultArray[position] = value;
            // Копируем из исходного массива элементы, которые находятся после позиции добавления и до конца исходного массива (с учетом коррекции)
            for (int i = position; i < sourceArray.length - arrayLengthCorrection; i++) {
                resultArray[i + 1] = sourceArray[i];
            }
        } else if (position == resultArray.length - 1) { // Если значение добавляется в конце массива
            // Копируем в результирующий массив элементы мз исходного массива (с учетом коррекции)
            for (int i = 0; i < sourceArray.length - arrayLengthCorrection; i++) {
                resultArray[i] = sourceArray[i];
            }
            // Определяем значение для последнего элемента нового массива
            resultArray[position] = value;
        } else {
            System.out.println("Позиция элемента не может быть отрицательной или превышать последний индекс результирующего массива!!");
        }
        return resultArray;
    }

    public static int[] insertValueInTheArrayV2(int[] sourceArray, int value, int position, boolean keepOriginalArraySize) {
        // Так как мы доавляем значение в массив, а не переопределяем существующее,
        // поэтому создаем новый массив, который вместит в себя все значения
        int[] resultArray;
        int arrayLengthCorrection;
        if (keepOriginalArraySize) {
            resultArray = new int[sourceArray.length];
            arrayLengthCorrection = 1;
        } else {
            resultArray = new int[sourceArray.length + 1];
            arrayLengthCorrection = 0;
        }
        // Если значение добавляется в начало массива
        if(position == 0) {
            // Указываем значение для элемента, который находится в нулевой позиции
            resultArray[position] = value;
            // Начиная с следующей позиции (1) результирующего массива, копируем в него значения из исходного массива (с учетом коррекции)
            System.arraycopy(sourceArray, 0, resultArray, 1, sourceArray.length - arrayLengthCorrection);
        } else if (position > 0 && position < resultArray.length - 1) { // Если значение добавляется в середину массива
            // Копируем в результирующий массив значения от 0 до позиции, в которую должен быть вставлен новый элемент
            System.arraycopy(sourceArray, 0, resultArray, 0, position);
            // Указываем значение для элемента, который находится в заданной позиции
            resultArray[position] = value;
            // Копируем из исходного массива элементы, которые находятся после позиции добавления и до конца исходного массива  (с учетом коррекции)
            System.arraycopy(sourceArray, position, resultArray, position + 1, sourceArray.length - arrayLengthCorrection - position);
        } else if (position == resultArray.length - 1) { // Если значение добавляется в конце массива
            // Копируем в результирующий массив все элементы мз исходного массива (с учетом коррекции)
            System.arraycopy(sourceArray, 0, resultArray, 0, sourceArray.length - arrayLengthCorrection);
            // Определяем значение для последнего элемента нового массива
            resultArray[position] = value;
        } else {
            System.out.println("Позиция элемента не может быть отрицательной или превышать последний индекс результирующего массива!!");
        }
        return resultArray;
    }

    // Задача №2
    public static HashMap<String, Integer> getMinAndMax(int[] inputArray) {
        // Создаем ассоциативный "массив" (HashMap) для возврата найденных значений
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        // Определяем минимальное значение и добавляем в HashMap
        result.put("min", getMinValue(inputArray));
        // Определяем максимальное значение и добавляем в HashMap
        result.put("max", getMaxValue(inputArray));
        // Возвращаем HashMap с минимальным и максимальным значениями
        return result;
    }

    public static int getMaxValue(int[] inputArray) {
        // Определяем стартовое значение для сравнения (максимум)
        int max = inputArray[0];
        // Запускаем цикл для перебора элементов массива
        for (int element: inputArray) {
            // Если сравниваемый элемент больше ране определенного максимального значения,
            if (max < element) {
                // то устанавливаем это значение в качестве максимального
                max = element;
            }
        }
        // Возвращаем результат
        return max;
    }

    public static int getMinValue(int[] inputArray) {
        // Определяем стартовое значение для сравнения (минимум)
        int min = inputArray[0];
        // Запускаем цикл для перебора элементов массива
        for (int element: inputArray) {
            // Если сравниваемый элемент меньше ранее определенного минимального значения,
            if (min > element) {
                // то устанавливаем это значение в качестве минимального
                min = element;
            }
        }
        // Возвращаем результат
        return min;
    }

    public static HashMap<String, Integer> getMinAndMaxV2(int[] inputArray) {
        // Создаем ассоциативный "массив" (HashMap) для возврата найденных значений
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        // Сотрируем массив в порядке возрастания
        Arrays.sort(inputArray);
        // Минимальное значение теперь находится в начала отсортированного массива
        result.put("min", inputArray[0]);
        // Максимальное значение теперь находится в конце отсортированного массива
        result.put("max", inputArray[inputArray.length - 1]);
        // Возвращаем HashMap с минимальным и максимальным значениями
        return result;
    }
}