package com.example.myrtrofit3;

import android.net.Uri;
import android.os.Build;

public class Person {

    private String name;
    private int age;

    private Person () {}

  public static class MyBuilder {
        private String name;
        private int age;

        public MyBuilder setName (String name) {
            this.name = name;

            return this;
        }

        public MyBuilder setAge (int age) {
            this.age = age;

            return this;
        }
        public Person Build() {
            Person person = new Person();
            person.name = name;
            person.age = age;
            return person;

        }
  }

    public static void main(String[] args) {
        Person person1 = new MyBuilder().setName("정규동").setAge(27).Build();
        Person person2 = new MyBuilder().setName("손흥민").setAge(30).Build();

        System.out.println(person1);
        System.out.println(person2);

    }

}
