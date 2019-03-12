package com.sise.abner.abaselib.net;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * @author zhangduntai
 * @date 2019/3/12
 */
public class MoshiConverterFactory extends Converter.Factory {

    private Moshi moshi;

    public static MoshiConverterFactory create() {
        return create(new Moshi.Builder().build());
    }

    public static MoshiConverterFactory create(Moshi moshi) {
        if (moshi == null) throw new NullPointerException("moshi == null");
        return new MoshiConverterFactory(moshi);
    }

    private MoshiConverterFactory(Moshi moshi) {
        this.moshi = moshi;
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return super.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit);
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new MoshiResponseBodyConverter<>(moshi,type);
    }
}
