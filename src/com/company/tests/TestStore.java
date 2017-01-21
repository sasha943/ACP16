package com.company.tests;

import com.company.exceptions.NotUniqueProductException;
import com.company.model.ProductTypes;
import com.company.store.Store;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestStore {

    private Store store;
    private ProductTypes type1Positive;
    private ProductTypes type2Positive;
    private ProductTypes type3Positive;

    private ProductTypes type1Negative;

    private double pricePositive;
    private double priceNegative1;
    private double priceNegative2;


    @BeforeClass
    private void beforeTestActions() {
        store = new Store();
        type1Positive = ProductTypes.CAMERA;
        type2Positive = ProductTypes.LAPTOP;
        type3Positive = ProductTypes.SMARTPHONE;
        type1Negative = null;
        pricePositive = 315.51;
        priceNegative1 = 0;
        priceNegative2 = -1;
    }

    @Test
    private void testPositiveAddProductMethod() throws NotUniqueProductException {
        Assert.assertTrue(store.addProduct(type1Positive, pricePositive));
        Assert.assertEquals(pricePositive, store.productModelList.get(0).getPrice());
        Assert.assertEquals(type1Positive, store.productModelList.get(0).getType());
        store.productModelList.clear();
    }

    @Test
    private void testNegativeAddProductMethod() throws NotUniqueProductException {
        Assert.assertFalse(store.addProduct(type1Positive, priceNegative1));
        Assert.assertFalse(store.addProduct(type1Negative, pricePositive));
        Assert.assertFalse(store.addProduct(type1Negative, priceNegative2));
        store.productModelList.clear();
    }



}
