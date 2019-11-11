package com.soecode.lyf.demo.test.java8;

import org.junit.Test;

import java.util.function.Function;

/**
 * @author 魏文思
 * @date 2019/11/9$ 14:04$
 */
public class FunctionTest {

    @Test
    public void life() {
        //第一次，妈妈给小明10元去买酱油
        double tips = firstBuy(10.0, (m) -> 10.0 - getSoy().getCost());
        System.out.println("小明得到的小费：" + tips);

        //第二次，妈妈还是给小明10元买酱油，小明思考了一下，拒绝了
        System.out.println("小明将妈妈给的" + Function.identity().apply(10) + "元还了回去");

        //妈妈在了解完情况后，给了小明20元去买，小明当然很愉快去了
        double tips2 = secondBuy(20, (m) -> {
            System.out.println("买酱油前有" + m + "元");
            double v2 = m - getSoy().getCost();
            System.out.println("买完酱油后剩下" + v2 + "元");
            return v2;
        });
        System.out.println("小明剩下的小费：" + tips2);

    }

    public double firstBuy(double money, Function<Double, Double> buy) {
        return buy.apply(money);
    }

    public double secondBuy(double money, Function<Double, Double> buy) {
        //在去的路上小明先买了冰淇淋
        Function<Double, Double> beforeBuy = (m) -> {
            System.out.println("第一次买冰淇淋前有" + m + "元");
            double v1 = m - getIceCream().getCost();
            System.out.println("买完冰淇淋后剩下" + v1 + "元");
            return v1;
        };

        //回来的路上小明又买了冰淇淋
        Function<Double, Double> afterBuy = (m) -> {
            System.out.println("第二次买冰淇淋前有" + m + "元");
            double v3 = m - getIceCream().getCost();
            System.out.println("买完冰淇淋后剩下" + v3 + "元");
            return v3;
        };

        return buy.compose(beforeBuy).andThen(afterBuy).apply(money);
    }

    public Goods getSoy() {
        return new Goods("酱油", 10);
    }

    public Goods getIceCream() {
        return new Goods("冰淇淋", 5);
    }
}
