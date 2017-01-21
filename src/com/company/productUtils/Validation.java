package com.company.productUtils;

import com.company.controller.ProductActionsController;
import com.company.model.ProductModel;

public class Validation {

    public boolean checkProduct(ProductModel productModel){
        return productModel.getType() != null && productModel.getPrice() != 0;
    }

}
