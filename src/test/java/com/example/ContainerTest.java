package com.example;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContainerTest {

    private Container<Integer> container;

    @Before
    public void setUp() {
        container = new Container<>();
    }

    // Тестирование метода add() с Integer
    @Test
    public void testAdd() {
        container.add(10);
        container.add(20);
        assertEquals(2, container.size()); // Ожидаем 2 элемента
        assertEquals(Integer.valueOf(10), container.get(0)); // Первый элемент — 10
        assertEquals(Integer.valueOf(20), container.get(1)); // Второй элемент — 20
    }

    // Тестирование метода remove() с Integer
    @Test
    public void testRemove() {
        container.add(10);
        container.add(20);
        container.remove(0);
        assertEquals(1, container.size()); // Ожидаем 1 элемент после удаления
        assertEquals(Integer.valueOf(20), container.get(0)); // Оставшийся элемент — 20
    }

    // Тестирование с типом String
    @Test
    public void testStringContainer() {
        Container<String> stringContainer = new Container<>();
        stringContainer.add("Hello");
        stringContainer.add("World");
        assertEquals(2, stringContainer.size()); // Ожидаем 2 элемента
        assertEquals("Hello", stringContainer.get(0)); // Первый элемент — "Hello"
        assertEquals("World", stringContainer.get(1)); // Второй элемент — "World"
    }

    // Тестирование с типом Double
    @Test
    public void testDoubleContainer() {
        Container<Double> doubleContainer = new Container<>();
        doubleContainer.add(1.1);
        doubleContainer.add(2.2);
        assertEquals(2, doubleContainer.size()); // Ожидаем 2 элемента
        assertEquals(Double.valueOf(1.1), doubleContainer.get(0)); // Первый элемент — 1.1
        assertEquals(Double.valueOf(2.2), doubleContainer.get(1)); // Второй элемент — 2.2
    }

    // Тестирование выброса исключения при удалении элемента по недопустимому индексу
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveInvalidIndex() {
        container.add(10);
        container.remove(5); // Индекс 5 не существует
    }

    // Тестирование выброса исключения при получении элемента по недопустимому индексу
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetInvalidIndex() {
        container.add(10);
        container.get(5); // Индекс 5 не существует
    }
}