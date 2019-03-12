package com.sise.abner.abaselib.net;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * @author zhangduntai
 * @date 2019/3/12
 */
public class MoshiResponseBodyConverter<T> implements Converter<ResponseBody,T> {
    private final Moshi moshi;
    private final Type type;

    MoshiResponseBodyConverter(Moshi moshi, Type type)
    {
        this.moshi = moshi;
        this.type= type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {

        return (T) moshi.adapter(type).fromJson(value.string());
    }
}
