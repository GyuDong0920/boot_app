package com.example.myrtrofit3.models.response;

/**
 * {
 * "userId": 1,
 * "id": 1,
 * "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
 * "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
 * }
 */


public class ResponsePostDto {

    public int userId;
    public int id;
    public String title;
    public String body;

    // 코드 길어져서 퍼블릭으로함원래는 게터세터 다달아줘야함

    @Override
    public String toString() {
        return "ResponsePostDto{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
