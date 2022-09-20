package com.blog.mapper;

import javax.servlet.http.HttpServletRequest;

public interface Mapper<T> {
    T mapping(HttpServletRequest request) ;
}
