package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.StorageStrategy;

/**
 * Created by MyWORID on 08.06.2017.
 */

/*класс, который может для любой строки вернуть некий уникальный идентификатор и наоборот,
по ранее полученному идентификатору вернуть строку

Два дополнительных требования к Shortener:
- для двух одинаковых строк должен возвращаться один и тот же идентификатор;
- он должен поддерживать столько строк, сколько значений может принимать long,
именно этот тип будет использоваться для идентификатора.
Первое требование очень сильно влияет на производительность, т.к. при получении
идентификатора для новой строки мы должны проверить не обрабатывалась ли эта
строка ранее, чтобы вернуть старый идентификатор.*/
public class Shortener
{
    private Long lastId = Long.valueOf(0); //будет отвечать за последнее значение идентификатора
    private StorageStrategy storageStrategy; //в котором будет храниться стратегия хранения данных

    public Shortener(StorageStrategy storageStrategy)
    {
        this.storageStrategy = storageStrategy;
    }

    public synchronized Long getId(String string)
    /*будет возвращать идентификатор id для заданной строки*/
    {
        if (storageStrategy.containsValue(string))
            return storageStrategy.getKey(string);
        else
        {
            lastId++;
            storageStrategy.put(lastId, string);
            return lastId;
        }
    }

    public synchronized String getString(Long id)
    /*будет возвращать строку для заданного идентификатора или null, если передан неверный идентификатор*/
    {
        return storageStrategy.getValue(id);
    }
}
