package io.hashnut.model.response;

import io.hashnut.model.HashNutOrder;

public class CreatePayOrderResponse extends SingleResponse{
    private HashNutOrder data;
    public HashNutOrder getData(){
        return data;
    }
}
