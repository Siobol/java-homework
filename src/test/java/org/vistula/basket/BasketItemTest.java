package org.vistula.basket;

import org.junit.Test;
import org.vistula.customer.Customer;
import org.vistula.promoitem.PromoItem;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class BasketItemTest {

    @Test
    public void canSumItemsPricePositive() {
        BasketItem wine = new BasketItem(29, true);
        BasketItem vodka = new BasketItem(39, true);
        List<BasketItem> basket = new ArrayList<>();
        Customer Julek = new Customer("Julek", "Testowania", 18, basket);
        basket.add(wine);
        basket.add(vodka);
        assertThat(Julek.sumItemsPrice() == 68).isTrue();
    }

    @Test
    public void canSumItemsPriceNegative1() {
        BasketItem wine = new BasketItem(29, true);
        BasketItem vodka = new BasketItem(39, true);
        List<BasketItem> basket = new ArrayList<>();
        Customer Julek = new Customer("Julek", "Testowania", 18, basket);
        basket.add(wine);
        basket.add(vodka);
        assertThat(Julek.sumItemsPrice() == 67).isFalse();
    }

    @Test
    public void canSumItemsPriceNegative2() {
        BasketItem wine = new BasketItem(29, true);
        BasketItem vodka = new BasketItem(39, true);
        List<BasketItem> basket = new ArrayList<>();
        Customer Julek = new Customer("Julek", "Testowania", 18, basket);
        basket.add(wine);
        basket.add(vodka);
        assertThat(Julek.sumItemsPrice() == 69).isFalse();
    }

    @Test
    public void canAddItemPositive1() {
        BasketItem water = new BasketItem(19, false);
        List<BasketItem> basket = new ArrayList<>();
        Customer Julek = new Customer("Julek", "Testowania", 13, basket);
        Julek.addItem(water);
        assertThat(basket.contains(water)).isTrue();
    }

    @Test
    public void canAddItemPositive2() {
        BasketItem vodka = new BasketItem(39, true);
        List<BasketItem> basket = new ArrayList<>();
        Customer Julek = new Customer("Julek", "Testowania", 18, basket);
        Julek.addItem(vodka);
        assertThat(basket.contains(vodka)).isTrue();
    }

    @Test
    public void canAddItemNegative() {
        BasketItem vodka = new BasketItem(39, true);
        List<BasketItem> basket = new ArrayList<>();
        Customer Julek = new Customer("Julek", "Testowania", 13, basket);
        Julek.addItem(vodka);
        assertThat(basket.contains(vodka)).isFalse();
    }

    @Test
    public void canRemoveItemPositive(){
        BasketItem wine = new BasketItem(29, true);
        List<BasketItem> basket = new ArrayList<>();
        Customer Julek = new Customer("Julek", "Testowania", 18, basket);
        basket.add(wine);
        Julek.removeItem(wine);
        assertThat(basket.isEmpty()).isTrue();
    }

    @Test
    public void canRemoveItemNegative(){
        BasketItem wine = new BasketItem(29, true);
        BasketItem vodka = new BasketItem(39, true);
        List<BasketItem> basket = new ArrayList<>();
        Customer Julek = new Customer("Julek", "Testowania", 18, basket);
        basket.add(wine);
        Julek.removeItem(vodka);
        assertThat(basket.isEmpty()).isFalse();
    }

    @Test
    public void canReducePricePositive(){
        BasketItem winepromo = new PromoItem(30, true, 10);
        List<BasketItem> basket = new ArrayList<>();
        Customer Julek = new Customer("Julek", "Testowania", 18, basket);
        basket.add(winepromo);
        assertThat(winepromo.getPrice()==27).isTrue();
    }

    @Test
    public void canReducePriceNegative1(){
        BasketItem winepromo = new PromoItem(30, true, 10);
        List<BasketItem> basket = new ArrayList<>();
        Customer Julek = new Customer("Julek", "Testowania", 18, basket);
        basket.add(winepromo);
        assertThat(winepromo.getPrice()==26).isFalse();
    }

    @Test
    public void canReducePriceNegative2(){
        BasketItem winepromo = new PromoItem(30, true, 10);
        List<BasketItem> basket = new ArrayList<>();
        Customer Julek = new Customer("Julek", "Testowania", 18, basket);
        basket.add(winepromo);
        assertThat(winepromo.getPrice()==28).isFalse();
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