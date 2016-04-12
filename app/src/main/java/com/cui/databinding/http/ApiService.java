package com.cui.databinding.http;

import com.cui.databinding.entity.PostEntity;
import com.cui.databinding.entity.ResponseEntity;

import retrofit.http.Body;
import retrofit.http.POST;
import rx.Observable;

/**
 * Created by cuiyang on 15/12/21.
 */
public interface ApiService {

    @POST("movie/search")
    Observable<ResponseEntity> getCookListResult(@Body PostEntity postEntity);

}
