package io.hashnut.model.response;

import java.util.List;
import io.hashnut.model.FiatInfo;

public class QueryFiatsResponse extends SingleResponse {
    private List<FiatInfo> data;

    public List<FiatInfo> getData() {
        return data;
    }

    public void setData(List<FiatInfo> data) {
        this.data = data;
    }
}
