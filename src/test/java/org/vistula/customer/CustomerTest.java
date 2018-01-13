package org.vistula.customer;

import org.junit.Test;
import org.vistula.basket.BasketItem;
import org.vistula.promoitem.PromoItem;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class CustomerTest {

    @Test
    public void isAdult1() {
        Customer Julek = new Customer();
        Julek.setAge(18);
        assertThat(Julek.isOfAge()).isTrue();
    }

    @Test
    public void isAdult2() {
        Customer Julek = new Customer();
        Julek.setAge(19);
        assertThat(Julek.isOfAge()).isTrue();
    }

    @Test
    public void isAdult3() {
        Customer Julek = new Customer();
        Julek.setAge(17);
        assertThat(Julek.isOfAge()).isFalse();
    }

    @Test
    public void canSumItemsPrice() {
        BasketItem wine = new BasketItem(29, true);
        BasketItem vodka = new BasketItem(39, true);
        List<BasketItem> basket = new ArrayList<>();
        Customer Julek = new Customer("Julek", "Testowania", 18, basket);
        basket.add(wine);
        basket.add(vodka);
        assertThat(Julek.sumItemsPrice() == 68).isTrue();
    }

    @Test
    public void canAddItem() {
        BasketItem wine = new BasketItem(29, true);
        BasketItem vodka = new BasketItem(39, true);
        List<BasketItem> basket = new ArrayList<>();
        Customer Julek = new Customer("Julek", "Testowania", 18, basket);
        Julek.addItem(wine);
        assertThat(basket.contains(wine)).isTrue();
    }

    @Test
    public void canRemoveItem(){
        BasketItem wine = new BasketItem(29, true);
        BasketItem vodka = new BasketItem(39, true);
        List<BasketItem> basket = new ArrayList<>();
        Customer Julek = new Customer("Julek", "Testowania", 18, basket);
        basket.add(wine);
        Julek.removeItem(wine);
        assertThat(basket.isEmpty()).isTrue();
    }

    @Test
    public void canReducePrice(){
        BasketItem winepromo = new PromoItem(30, true, 10);
        List<BasketItem> basket = new ArrayList<>();
        Customer Julek = new Customer("Julek", "Testowania", 18, basket);
        basket.add(winepromo);
        assertThat(winepromo.getPrice()==27).isTrue();
    }

    @Test
    public void canPrintItemsPositive(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expectedOutput  = "29.0 name of the item; 39.0 name of the item; ";
        BasketItem wine = new BasketItem(29, true);
        BasketItem vodka = new BasketItem(39, true);
        List<BasketItem> basket = new ArrayList<>();
        Customer Julek = new Customer("Julek", "Testowania", 18, basket);
        basket.add(wine);
        basket.add(vodka);
        Julek.printItems();
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void canPrintItemsNegative(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expectedOutput  = "29.0 name of the item; 39.0 name of the items; ";
        BasketItem wine = new BasketItem(29, true);
        BasketItem vodka = new BasketItem(39, true);
        List<BasketItem> basket = new ArrayList<>();
        Customer Julek = new Customer("Julek", "Testowania", 18, basket);
        basket.add(wine);
        basket.add(vodka);
        Julek.printItems();
        assertThat(expectedOutput.equals(outContent.toString())).isFalse();
    }
}