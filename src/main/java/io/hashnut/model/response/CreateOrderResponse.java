package io.hashnut.model.response;

import io.hashnut.model.HashNutOrder;

public class CreateOrderResponse extends SingleResponse {
    private HashNutOrder data;

    public HashNutOrder getData() {
        return data;
    }

    public void setData(HashNutOrder data) {
        this.data = data;
    }
}
