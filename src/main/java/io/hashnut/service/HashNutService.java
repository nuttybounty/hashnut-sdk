package io.hashnut.service;

import io.hashnut.exception.HashNutException;
import io.hashnut.model.request.CancelOrderRequest;
import io.hashnut.model.request.ConfirmPaidRequest;
import io.hashnut.model.request.CreateOrderRequest;
import io.hashnut.model.request.QueryChainsRequest;
import io.hashnut.model.request.QueryCoinsRequest;
import io.hashnut.model.request.QueryOrderRequest;
import io.hashnut.model.response.CreateOrderResponse;
import io.hashnut.model.response.QueryChainsResponse;
import io.hashnut.model.response.QueryCoinsResponse;
import io.hashnut.model.response.QueryOrderResponse;
import io.hashnut.model.response.SingleResponse;

public interface HashNutService {
    CreateOrderResponse createOrder(CreateOrderRequest request) throws HashNutException;
    QueryOrderResponse queryOrder(QueryOrderRequest request) throws HashNutException;
    SingleResponse confirmPaid(ConfirmPaidRequest request) throws HashNutException;
    SingleResponse cancelOrder(CancelOrderRequest request) throws HashNutException;
    QueryChainsResponse queryAllChainInfo(QueryChainsRequest request) throws HashNutException;
    QueryCoinsResponse queryAllCoinInfo(QueryCoinsRequest request) throws HashNutException;
}
