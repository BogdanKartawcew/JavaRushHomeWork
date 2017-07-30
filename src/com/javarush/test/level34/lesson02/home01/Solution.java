package com.javarush.test.level34.lesson02.home01;

public class Solution
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        String[] array = new String[]{
                "sin(2*(-5+1.5*4)+28)",
                "sin(2*(-5+1.5*(6-(-2))+28))",
                "(-2)*(-2)",
                "(-2)/(-2)",
                "sin(-30)",
                "cos(-30)",
                "tan(-30)",
                "cos(3 + 19*3)",
                "2+8*(9/4-1.5)^(1+1)",
                "tan(45)",
                "0+0.304",
                "0.3051",
                "1+(1+(1+1)*(1+1))*(1+1)+1",
                "tan(44 + sin(89 - cos(180) ^ 2))",
                "- 2 + (-2 + (-2) - 2 * (2 + 2))",
                "sin(80 + (2 + (1 + 1)) * (1 + 1) + 2)",
                "1 + 4 / 2 / 2 + 2 ^ 2 + 2 * 2 - 2 ^ (2 - 1 + 1)",
                "2 ^ 10 + 2 ^ (5 + 5)",
                "1.01 + (2.02 - 1 + 1 / 0.5 * 1.02) / 0.1 + 0.25 + 41.1",
                "0.000025 + 0.000012",
                "- 2 - (-2 - 1 - (-2) - (-2) - (-2 - 2 - (-2) - 2) - 2 - 2)",
                "cos(3 + 19 * 3)",
                "2*(589 + ((24540.1548 / 0.01*(-2 + 9 ^ 2))+((25123.12 + 45877 * 25) + 25))-547)",
                "(-1 + (-2))",
                "- sin(2 *(-5 + 1.54) + 28)",
                "sin(100) - sin(100)",
                "- (-22 + 22 * 2)",
                "- 2 ^ (-2)"};
        for (String s : array)
            solution.recursion(s, 0); //expected output 0.5 6
    }

    public void recursion(final String expression, int countOperation)
    {
        Process process = new Process();
        CountCalc calc = new CountCalc();
        System.out.println(process.getResult(expression) + " " + calc.getResult(expression));
    }

    public Solution()
    {
        //don't delete
    }
}
