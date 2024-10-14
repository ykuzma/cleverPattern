package ru.clevertec.validation;

import lombok.Setter;

import java.util.function.Predicate;


@Setter
public abstract class Validator {

    public static Validator of() {
        return new Validator(c -> !c.isAnnotation()) {
        }.setNext(
                new Validator(c -> !c.isPrimitive()) {
                }).setNext(
                new Validator(c -> !c.isInterface()) {
                }
        );
    }

    private Validator nextValidator;
    private Predicate<Class<?>> predicate;

    protected Validator(Predicate<Class<?>> predicate) {
        this.predicate = predicate;
    }

    public boolean validate(Class<?> clazz) {
        boolean test = predicate.test(clazz);
        return test && nextValidator != null ? nextValidator.validate(clazz) : test;
    }

    public Validator setNext(Validator validator) {
        nextValidator = validator;
        return nextValidator;
    }
}

