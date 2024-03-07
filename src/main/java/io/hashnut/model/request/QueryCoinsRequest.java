package io.hashnut.model.request;

import io.hashnut.model.CoinInfo;
import io.hashnut.model.response.QueryCoinsResponse;

import java.util.List;

public class QueryCoinsRequest extends PostRequest<QueryCoinsResponse> {

    public QueryCoinsRequest(Builder builder){
    }

    @Override
    public String getUri() {
        return "/mch/queryAllCoinInfo";
    }

    @Override
    public Class<QueryCoinsResponse> getResponseClass() {
        return QueryCoinsResponse.class;
    }

    public static class Builder{
        public Builder(){

        }

        public QueryCoinsRequest build(){
            return new QueryCoinsRequest(this);
        }
    }
}
