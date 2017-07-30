package com.javarush.test.level33.lesson15.big01.strategies;

import java.io.Serializable;

/**
 * Created by MyWORID on 11.06.2017.
 */
public class Entry implements Serializable
{
    final int hash;
    final Long key;
    String value;
    Entry next;

    public Entry(int hash, Long key, String value, Entry next)
    {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public final Long getKey()
    {
        return key;
    }

    public final String getValue()
    {
        return value;
    }


    @Override
    public int hashCode()
    {
        int result = hash;
        result = 31 * result + (getKey() != null ? getKey().hashCode() : 0);
        result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
        result = 31 * result + (next != null ? next.hashCode() : 0);
        return result;

        //return Objects.hashCode(key) ^ Objects.hashCode(value);
    }

    @Override
    public String toString()
    {
        return getKey() + "=" + getValue();

        //return key + "=" + value;
    }
}
