package io.hashnut.model.request;

import io.hashnut.model.response.QueryChainsResponse;

public class QueryChainsRequest extends GetRequest<QueryChainsResponse> {

    public QueryChainsRequest(Builder builder){

    }

    @Override
    public String getUri() {
        return "/mch/queryAllChainInfo";
    }

    @Override
    public Class<QueryChainsResponse> getResponseClass() {
        return QueryChainsResponse.class;
    }

    public static class Builder{
        public Builder(){

        }

        public QueryChainsRequest build(){
            return new QueryChainsRequest(this);
        }
    }
}
