package com.example;
/**
 * Класс Container представляет собой реализацию контейнера для хранения произвольного
 * количества элементов с использованием односвязного списка.
 * Контейнер поддерживает операции добавления, получения и удаления элементов.
 *
 * @param <T> тип элементов, которые будут храниться в контейнере.
 */
public class Container<T> {

    /**
     * Внутренний класс, представляющий узел односвязного списка.
     *
     * @param <T> тип данных, хранящихся в узле.
     */
    private static class Node<T> {
        /** Данные, хранящиеся в узле. */
        T data;

        /** Ссылка на следующий узел. */
        Node<T> next;

        /**
         * Конструктор, создающий новый узел.
         *
         * @param data данные, которые будут сохранены в узле.
         */
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    /** Ссылка на первый элемент списка (голова). */
    private Node<T> head;

    /** Количество элементов в контейнере. */
    private int size;

    /**
     * Создает пустой контейнер.
     */
    public Container() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Добавляет элемент в конец контейнера.
     *
     * @param item элемент, который будет добавлен в контейнер.
     */
    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**
     * Возвращает элемент, расположенный по указанному индексу.
     *
     * @param index индекс элемента, который нужно получить.
     * @return элемент, расположенный по указанному индексу.
     * @throws IndexOutOfBoundsException если индекс выходит за пределы допустимого диапазона.
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Удаляет элемент по указанному индексу.
     *
     * @param index индекс элемента, который нужно удалить.
     * @throws IndexOutOfBoundsException если индекс выходит за пределы допустимого диапазона.
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    /**
     * Возвращает текущее количество элементов в контейнере.
     *
     * @return количество элементов в контейнере.
     */
    public int size() {
        return size;
    }
}