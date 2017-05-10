package com.assistant.api;

import com.assistant.bean.Schedule;
import com.assistant.bean.User;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import rx.Observer;

/**
 * Created by hyc on 2017/5/10 15:40
 */

public interface Api {
    String baseUri = "http://218.75.197.121:8888/api/v1/";

    @GET("get/login/{username}/{password}")
    Observable<User> login(@Path("username") String username, @Path("password") String password);

    @GET("get/lessons/{username}/{key}")
    Observable<Schedule> loadSchedule(@Path("username") String username, @Path("key") String key);
}
