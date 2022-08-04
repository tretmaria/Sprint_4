package ru.yandex.praktikum;

public class Account {

    private String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */
        if (name != null && checkNameLength() && doesNameStartOrEndWithSpace() && isOnlyOneSpace()) {
            return true;
        }
        return false;
    }

    private boolean checkNameLength() {
        return (name.length() >= 3 && name.length() <= 19);
    }

    private boolean doesNameStartOrEndWithSpace() {
        return (!name.startsWith(" ") && !name.endsWith(" "));
    }

    private boolean isOnlyOneSpace() {
        int spaceCount = 0;
        for (char space : name.toCharArray()) {
            if (space == ' ') {
                spaceCount++;
            }
        }
        return (spaceCount == 1);
    }
}