package com.demo.java.enumT;


/**
 * @description:
 * @author: zhusimu
 * @create: 2018/9/20
 */
public class EFoodTest {

    public static void main(String[] args) {
        for (EFood.Coffee coffee : EFood.Coffee.values()) {
            System.out.print(coffee + " ");
        }
        System.out.println();

        for (EFood.Dessert dessert : EFood.Dessert.values()) {
            System.out.print(dessert + " ");
        }
        System.out.println();

        EFood food = EFood.Coffee.CAPPUCCINO;
        System.out.println(food);

        food = EFood.Dessert.CAKE;
        System.out.println(food);
    }
}
interface EFood {
    enum Coffee implements EFood {
        BLACK_COFFEE, DECAF_COFFEE, LATTE, CAPPUCCINO
    }

    enum Dessert implements EFood {
        FRUIT, CAKE, GELATO
    }
}

