package ru.clevertec.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {


    @Test
    void shouldReturnTrue() {
        //given
        Validator validator = new Validator(c -> !c.isPrimitive()){};
        //when
        boolean actual = validator.validate(Integer.class);
        //then
        assertThat(actual).isTrue();
    }

    @Test
    void shouldReturnFalse() {
        //given
        Validator validator = new Validator(c -> !c.isPrimitive()){};
        //when
        boolean actual = validator.validate(int.class);
        //then
        assertThat(actual).isFalse();
    }
}
