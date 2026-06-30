package io.hashnut.model.response;

import io.hashnut.model.CoinInfo;

import java.util.List;

public class QueryCoinsResponse extends SingleResponse {
    private List<CoinInfo> data;

    public List<CoinInfo> getData() {
        return data;
    }

    public void setData(List<CoinInfo> data) {
        this.data = data;
    }
}
