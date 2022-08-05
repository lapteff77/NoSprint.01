import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.Account;


import java.util.Collections;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest
{

    private final String name;
    private final boolean expected;



    public AccountTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected; // создали конструктор тестового класса
    }

    @Parameterized.Parameters()
    public static Object[] getAccount() {
        return new Object[][]{
                {"Тимоти Шаламе", true},
                {"Тимоти Шаламешалам", true},
                {"Тимоти Шаламешаламе", true},
                {" Тимоти Шаламе ", false},
                {" Тимоти Шаламе", false},
                {"Тимоти Шаламе ", false},
                {"Т М", true},
                {"Ти М", true},
                {"", false},
                {"        ", false},
                {"Тимоти Шаламешаламем", false},
                {"Тимоти  Шаламе", false},
                {"ТимотимШаламешалам", false},
                {"Тимми Тимми Тимми", false},
                {"Тимоти Шаламешаламмамам", false},
                {" ТимотиШаламе", false},
                {"ТимотиШаламе ", false},
                {" ", false},
                {String.valueOf(Collections.EMPTY_LIST), false},// передали тестовые данные
        };
    }

    @Test
    public void shouldCorrectAccount() {
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expected, actual);
    }
}
