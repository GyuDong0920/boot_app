package com.example.myaddview;

import java.util.ArrayList;

public class Fruit {

    String imageUrl;
    String name;
    String price;
    String count;


    public Fruit(String imageUrl, String name, String price, String count) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.price = price;
        this.count = count;
    }

    // 샘플 데이터 만들어 보기
    public static ArrayList<Fruit> getFruits() {
        ArrayList<Fruit> list = new ArrayList<>();
        list.add(new Fruit("https://media.istockphoto.com/photos/whole-and-slices-watermelon-fruit-isolated-on-white-background-picture-id1142119394?b=1&k=20&m=1142119394&s=170667a&w=0&h=P_bYuVv_0g7z8h8SKIwZHEPabHwiA5Ae_6ErgXQ606M=","수박","10000원","1개"));
        list.add(new Fruit("https://media.istockphoto.com/photos/red-apple-picture-id495878092?b=1&k=20&m=495878092&s=170667a&w=0&h=bJgILGFxOka0ymPlgilH8qaRxFhKole_M6IiYs6RyGM=","사과","2000원","1개"));
        list.add(new Fruit("https://media.istockphoto.com/photos/cantaloupe-melon-picture-id910127132?b=1&k=20&m=910127132&s=170667a&w=0&h=I_s0-q863W7RwpzgV05P3DUEgHlx9-JVka8RbJCXF8w=","멜론","11000원","1개"));
        list.add(new Fruit("https://media.istockphoto.com/photos/pears-isolated-one-and-a-half-green-pear-fruit-with-leaf-on-white-picture-id1299073137?b=1&k=20&m=1299073137&s=170667a&w=0&h=-1I_nAU2lCOo5hszaF2l2M-x3cFUo7RA3fRxDljVQ-4=","배","3000원","1개"));
        list.add(new Fruit("https://media.istockphoto.com/photos/kiwi-picture-id537403487?b=1&k=20&m=537403487&s=170667a&w=0&h=i5-Jv00GX1iklojP_vPi33yiM6h0rUJPFj95Harnr5M=","키위","5000원","5개"));
        list.add(new Fruit("https://media.istockphoto.com/photos/bananas-picture-id619046500?b=1&k=20&m=619046500&s=170667a&w=0&h=vas7ybpnrDOLxdm3hCJkZI9K30FTUXH2nfnhRyhlqVs=","바나나","4000원","12개"));
        list.add(new Fruit("https://media.istockphoto.com/photos/two-strawberries-isolated-on-white-background-picture-id471674664?b=1&k=20&m=471674664&s=170667a&w=0&h=jvMxIr2Sy7sAeN2Y0lo50JPHWQ290S0XnfOhlhdR01c=","딸기","12000원","50개"));


        return list;
    }

}
