package com.example.mydreamcar;

import java.util.ArrayList;

public class Cars {

    String ImageUrl;
    String name;
    String year;
    String price;

    public Cars(String imageUrl, String name, String year, String price) {
        ImageUrl = imageUrl;
        this.name = name;
        this.year = year;
        this.price = price;
    }

    public static ArrayList<Cars> getCars() {
        ArrayList<Cars> list =new ArrayList<>();
        list.add(new Cars("https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fimgauto-phinf.pstatic.net%2F20201214_175%2Fauto_1607906188198YmDmK_PNG%2F20201214093618_0w9JrC4h.png","람보르기니 우라칸","2021","43,500만원"));
        list.add(new Cars("https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fimgauto-phinf.pstatic.net%2F20210708_54%2Fauto_16257397819427K86w_PNG%2F20210708192248_H4jyL0aZ.png","람보르기니 아벤타도르","2021","55,500만원"));
        list.add(new Cars("https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fimgauto-phinf.pstatic.net%2F20211109_194%2Fauto_1636459037084dUYeW_PNG%2F20211109205707_0yNWvMAF.png","메르세데스-벤츠 S클래스","2022","23,600만원"));
        list.add(new Cars("https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fimgauto-phinf.pstatic.net%2F20220112_163%2Fauto_1641972706199E2sD0_PNG%2F20220112163136_ZdSJlUGj.png","BMW M8","2022","24,020만원"));
        list.add(new Cars("https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fimgauto-phinf.pstatic.net%2F20211109_1%2Fauto_1636438968594hlWMA_PNG%2F20211109152238_hDvXqhQ5.png","BMW 7시리즈","2022","23,340만원"));
        list.add(new Cars("https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fimgauto-phinf.pstatic.net%2F20200904_27%2Fauto_15992004504822afLH_PNG%2F20200904152047_CIKGTYcQ.png","롤스로이스 팬텀 EWB","2018","74,000만원"));
        list.add(new Cars("https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fimgauto-phinf.pstatic.net%2F20211126_201%2Fauto_1637900300115SxsAj_PNG%2F20211126131808_0K38F65d.png","마세라티 MC20","2022","30,900만원"));
        list.add(new Cars("https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fimgauto-phinf.pstatic.net%2F20211214_182%2Fauto_163944496799798by8_PNG%2F20211214102237_s8eSKKgG.png","제네시스 G90 LWB","2022","16,557만원"));



        return list;
    }
}
