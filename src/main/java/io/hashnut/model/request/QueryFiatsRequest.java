package io.hashnut.model.request;

import io.hashnut.model.response.QueryFiatsResponse;

public class QueryFiatsRequest extends PostRequest<QueryFiatsResponse> {

    public QueryFiatsRequest(Builder builder) {
    }

    @Override
    public String getUri() {
        return "/config/fiats";
    }

    @Override
    public Class<QueryFiatsResponse> getResponseClass() {
        return QueryFiatsResponse.class;
    }

    public static class Builder {
        public Builder() {
        }

        public QueryFiatsRequest build() {
            return new QueryFiatsRequest(this);
        }
    }
}
