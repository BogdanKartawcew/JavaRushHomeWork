package com.javarush.test.level34.lesson02.home01;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by A261711 on 2017-07-14.
 */
class Decouple implements Results
{

    private Object decouple(String line)
    {
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        Object obj = null;
        try
        {
            obj = engine.eval(line);
        }
        catch (ScriptException e)
        {
            e.printStackTrace();
        }
        return obj;
    }

    @Override// від інтерфейсу
    public String getResult(String line)
    {
        return String.valueOf(decouple(line));
    }
}
