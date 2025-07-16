package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {
        double[][] datas = {
                {1, 1},
                {2, 2},
                {3, 2.5},
                {4, 4}
        };

        Linear_Regression lin_reg = new Linear_Regression( datas, 0.01, 3000);
        System.out.printf("Начальные значения:\nTetta0 = %f, tetta1 = %f\n", lin_reg.getTetta0(), lin_reg.getTetta1());

        lin_reg.start();

        System.out.printf("\nКонечные значения:\nTetta0 = %f, tetta1 = %f\n", lin_reg.getTetta0(), lin_reg.getTetta1());
        System.out.printf("Ошибка равна: %f", lin_reg.mse());
    }
}