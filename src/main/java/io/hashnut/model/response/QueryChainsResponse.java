package io.hashnut.model.response;

import java.util.List;
import io.hashnut.model.ChainInfo;

public class QueryChainsResponse extends SingleResponse {
    private List<ChainInfo> data;

    public List<ChainInfo> getData() {
        return data;
    }

    public void setData(List<ChainInfo> data) {
        this.data = data;
    }
}
