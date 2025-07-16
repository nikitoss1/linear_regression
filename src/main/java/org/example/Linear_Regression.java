package org.example;

import java.util.Random;

public class Linear_Regression {

    private double[][] data;

    private double alpha;
    private double tetta0;
    private double tetta1;
    private int count_iterations;

    public Linear_Regression(double[][] data, double alpha, int count_iterations) {
        // Мои данные
        this.data = data;

        // Класс с рандомным значением
        Random rand = new Random();

        // Гиперпараметр альфа
        this.alpha = alpha;

        // tetta0 и tetta1 (веса)
        this.tetta0 = rand.nextDouble() * 10;
        this.tetta1 = rand.nextDouble() * 10;

        this.count_iterations = count_iterations;
    }

    public void start(){
        for(int numb_iter = 0; numb_iter < this.count_iterations; numb_iter++) {
            double mse_tetta0 = mse0();
            double mse_tetta1 = mse1();

            change_tettas();

            System.out.printf("Итерация: %d, Ошибка: %f\n", numb_iter, mse());
        }
    }

    public double predict(double x) {
        return this.tetta0 + tetta1 * x;
    }

    private double mse0() {
        double result = 0;

        for (double[] datum : this.data) {
            result += this.tetta0 + this.tetta1 * datum[0] - datum[1];
        }

        return ((double) 1 / this.data.length) * result;
    }

    private double mse1() {
        double result = 0;

        for (double[] datum : this.data) {
            result += (this.tetta0 + this.tetta1 * datum[0] - datum[1]) * datum[1];
        }

        return ((double) 1 / this.data.length) * result;
    }

    private void change_tettas(){
        this.tetta0 -= this.alpha * mse0();
        this.tetta1 -= this.alpha * mse1();
    }

    public double mse() {
        double result = 0;

        for (double[] datum : this.data) {
            result += Math.pow((predict(datum[0]) - datum[1]), 2);
        }

        return ((double) 1 / (2 * this.data.length)) * result;
    }

    public double[][] getData() {
        return data;
    }

    public void setData(double[][] data) {
        this.data = data;
    }

    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public double getTetta0() {
        return tetta0;
    }

    public void setTetta0(double tetta0) {
        this.tetta0 = tetta0;
    }

    public double getTetta1() {
        return tetta1;
    }

    public void setTetta1(double tetta1) {
        this.tetta1 = tetta1;
    }

}
