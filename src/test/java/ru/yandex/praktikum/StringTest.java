package ru.yandex.praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {
    private String name;
    private boolean result;

    public AccountTest(String name, boolean result) {
        this.name = name;
        this.result = result;
    }

    @Parameterized.Parameters(name="Тестовые данные: {0} {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {" Тимоти Шаламе", false},
                {"Тимоти Шаламе ", false},
                {"ТимотиШаламе", false},
                {"Тимоти  Шаламе", false},
                {"Тимоти Шала ме", false},
                {"Ти", false},
                {"Тиммотей Шалламеевич", false},
                {null, false},
                {"Тимоти Шаламе", true},
                {"Т Ш", true},
        };
    }

    @Test
    public void checkString() {
        Account account = new Account(name);
        assertEquals("Некорректно введенные данные", account.checkNameToEmboss(), result);
    }
}
