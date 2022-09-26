package com.mvc.mvc.mvc;

public interface HandlerMapping {
    Object findHandler(HandlerKey handlerKey);
}
