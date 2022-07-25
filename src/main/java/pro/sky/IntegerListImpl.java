package pro.sky;

import pro.sky.IntegerList;

import java.util.Objects;

public class IntegerListImpl implements IntegerList {

    private static final int INITIAL_SIZE=15;
    private final Integer[] data;
    private int capacity;

    public IntegerListImpl() {
        data = new Integer[INITIAL_SIZE];
        capacity = 0;
    }
    public IntegerListImpl(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размер списка должен быть положительным");
        }
        data = new Integer[n];
        capacity = 0;
    }

    @Override
    public Integer add(Integer item) {
        if (Objects.isNull(item))
            throw new IllegalArgumentException("Нельзя добавлять 0 в список");
        if (capacity >= data.length) {
            throw new IllegalArgumentException("Список заполнен");
        }
        data[capacity++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if (capacity >= data.length) {
            throw new IllegalArgumentException("Список заполнен");
        }
        if (Objects.isNull(item))
            throw new IllegalArgumentException("Нельзя добавлять 0 в список");
        if (index < 0) {
            throw new IllegalArgumentException("Индекс не может быть отрицательным");
        }
        if (index > capacity) {
            throw new IllegalArgumentException("Индекс:" + index + "Размер:" + capacity);
        }
        for (int i = capacity; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = item;
        capacity++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        if (Objects.isNull(item))
            throw new IllegalArgumentException("Нельзя добавлять 0 в список");
        if (index < 0) {
            throw new IllegalArgumentException("Индекс не может быть отрицательным");
        }
        if (index > capacity) {
            throw new IllegalArgumentException("Индекс:" + index + "Размер:" + capacity);
        }
        data[index] = item;
        return item;
    }

    @Override
    public Integer remove (Integer item) {
        if (Objects.isNull(item))
            throw new IllegalArgumentException("Нельзя добавлять 0 в список");
        int indexRemov = -1;
        for (int i = 0; i < capacity; i++) {
            if (data[i].equals(item)) {
                indexRemov = i;
                break;
            }
        }
        if (indexRemov == -1) {
            throw new IllegalArgumentException("Элемент не найден");
        }
        return remove(indexRemov);
    }

    @Override
    public Integer remove(int index) {
        if (index >= capacity) {
            throw new IllegalArgumentException("Индекс:" + index + "Размер:" + capacity);
        }
        if (index < 0) {
            throw new IllegalArgumentException("Индекс не может быть отрицательным");
        }
        Integer removed = data[index];
        for (int i = index; i < capacity - 1; i++) {
            data[i] = data[i + 1];
        }
        data[--capacity] = null;
        return removed;
    }

    @Override
    public boolean contains(Integer item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("Нельзя добавлять 0 в список");
        }
            sort();
            int min = 0;
            int max = capacity - 1;
            while (min <= max) {
                int mid = (min + max) / 2;
                if (item.equals(data[mid])) {
                    return true;
                }

                if (item < data[mid]) {
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
                }
                return false;
            }
    @Override
    public int indexOf(Integer item) {
        if (Objects.isNull(item)){
            throw new IllegalArgumentException("Нельзя добавлять 0 в список");
        }
        int index = - 1;
        for (int i = 0; i < capacity; i++) {
            if (data[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(Integer item) {
        if (Objects.isNull(item)){
            throw new IllegalArgumentException("Нельзя добавлять 0 в список");
        }
        int index = -1;
        for (int i = capacity; i >= 0; i--) {
            if (data[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public Integer get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Индекс не может быть отрицательным");
        }
        if (index >= capacity) {
            throw new IllegalArgumentException("Индекс:" + index + "Размер:" + capacity);
        }
        return data[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (size() != otherList.size()) {
            return false;
        }
        for (int i = 0; i < capacity; i++) {
            if (!data[i].equals((otherList.get(i)))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return capacity;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            data[i] = null;
        }
        capacity = 0;
    }

    @Override
    public Integer[] toArray() {
        Integer[] result = new Integer[capacity];
        for (int i = 0; i < capacity; i++) {
            result[i] = data[i];
        }
        return result;
    }
    private void sort() {
        for (int i = 1; i < capacity; i++) {
            int temp = data[i];
            int j = i;
            while (j > 0 && data[j - 1] >= temp) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = temp;
        }
    }
}
