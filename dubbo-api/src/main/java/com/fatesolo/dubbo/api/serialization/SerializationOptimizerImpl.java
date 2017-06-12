package com.fatesolo.dubbo.api.serialization;

import com.alibaba.dubbo.common.serialize.support.SerializationOptimizer;
import com.fatesolo.dubbo.api.bean.Book;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class SerializationOptimizerImpl implements SerializationOptimizer {

    @Override
    public Collection<Class> getSerializableClasses() {
        List<Class> classes = new LinkedList<>();

        classes.add(Book.class);

        return classes;
    }

}
