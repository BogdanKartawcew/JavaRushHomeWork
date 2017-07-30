package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

public class CurrencyManipulator
{

    private String currencyCode;
    private static Map<Integer, Integer> denominations = new HashMap<>();

    /*Now the amount is 2329. In test we add 1 USD. After that we withdraw 788 USD. So we have the output:
    * 200 - 3
	100 - 1
	50 - 1
	20 - 1
	10 - 1
	5 - 1
	2 - 1
	1 - 1

	And the the balance is 1541 USD
	*/
    static
    {
        denominations.put(1, 6);
        denominations.put(2, 6);
        denominations.put(5, 6);
        denominations.put(10, 6);
        denominations.put(20, 6);
        denominations.put(50, 6);
        denominations.put(100, 6);
        denominations.put(200, 6);
    }

    public boolean isAmountAvailable(int expectedAmount)
    {
        return expectedAmount <= getTotalAmount();
    }

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public void addAmount(int denomination, int count)
    {
        if (denominations.containsKey(denomination))
            denominations.put(denomination, denominations.get(denomination) + count);
        else
            denominations.put(denomination, count);
    }

    public int getTotalAmount()
    {
        int result = 0;
        for (Map.Entry<Integer, Integer> pair : denominations.entrySet())
            result = result + (pair.getKey() * pair.getValue());

        return result;
    }


    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (Map.Entry<Integer, Integer> ourmap : denominations.entrySet())
        {
            for (int i = 0; i < ourmap.getValue(); i++)
                linkedList.add(ourmap.getKey());
        }
        Collections.sort(linkedList);
        Collections.reverse(linkedList);
        Map<Integer, Integer> withdrawAmount = new TreeMap<>(/*new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2.compareTo(o1);
            }
        }*/Collections.<Integer>reverseOrder());
        List<Integer> list = new ArrayList<>();
        int sum = expectedAmount;

        for (int k = 0; k < linkedList.size() - 1; k++)
        {
            if (sum >= 0)
            {
                if (linkedList.get(k) <= sum)
                {
                    list.add(linkedList.get(k));
                    sum -= linkedList.get(k);
                    linkedList.remove(linkedList.indexOf(linkedList.get(k)) + 1);
                }
            }
        }


        for (int i = 0; i < list.size(); i++)
        {
            withdrawAmount.put(list.get(i), withdrawAmount.containsKey(list.get(i)) ? withdrawAmount.get(list.get(i)) + 1 : 1);
        }

        if (sum != 0)
            throw new NotEnoughMoneyException();

        else
        {
            denominations.clear();

            for (int i = 0; i < linkedList.size(); i++)
            {
                denominations.put(linkedList.get(i), denominations.containsKey(linkedList.get(i)) ? denominations.get(linkedList.get(i)) + 1 : 1);
            }
            for (Map.Entry<Integer, Integer> pair : withdrawAmount.entrySet())
                ConsoleHelper.writeMessage("\t" + pair.getKey() + " - " + pair.getValue());
            ConsoleHelper.writeMessage("Transaction complete successfully");
        }
        return withdrawAmount;
    }

    public boolean hasMoney()
    {
        return denominations.size() != 0;
    }
}
