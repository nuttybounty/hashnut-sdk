package io.hashnut.model.response;

import io.hashnut.model.HashNutOrder;

public class QueryOrderResponse extends SingleResponse{
    private HashNutOrder data;
    public HashNutOrder getData(){
        return data;
    }
}
