package com.programmingwithmati.notifications.service;

public abstract class Decorator<T> {

  protected final T target;

  protected Decorator(T target) {
    this.target = target;
  }
}
