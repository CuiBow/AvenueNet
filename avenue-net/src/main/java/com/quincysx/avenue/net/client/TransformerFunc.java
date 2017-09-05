package com.quincysx.avenue.net.client;

import com.alibaba.fastjson.JSON;
import com.quincysx.avenue.net.AvenueNet;

import java.lang.reflect.Type;

import io.reactivex.functions.Function;

public class TransformerFunc<T> implements Function<String, T> {
    private Type type;

    public TransformerFunc(Type type) {
        this.type = type;
    }

    @Override
    public T apply(String json) throws Exception {
        if (type.equals(String.class)) {
            return (T) json;
        } else {
            T t = JSON.parseObject(json, type);
            AvenueNet.getVerify().verify(t);
            return t;
        }
    }
}
