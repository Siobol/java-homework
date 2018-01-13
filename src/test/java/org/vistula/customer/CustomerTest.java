package org.vistula.customer;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {

    @Test
    public void isAdultPositive1() {
        Customer Julek = new Customer();
        Julek.setAge(18);
        assertThat(Julek.isOfAge()).isTrue();
    }

    @Test
    public void isAdultPositive2() {
        Customer Julek = new Customer();
        Julek.setAge(19);
        assertThat(Julek.isOfAge()).isTrue();
    }

    @Test
    public void isAdultNegative() {
        Customer Julek = new Customer();
        Julek.setAge(17);
        assertThat(Julek.isOfAge()).isFalse();
    }
}