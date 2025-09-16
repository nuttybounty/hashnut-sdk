package io.hashnut.service;

import io.hashnut.exception.HashNutException;
import io.hashnut.model.request.*;
import io.hashnut.model.response.*;

public interface HashNutService {
    QueryCoinsResponse queryAllCoinInfo(QueryCoinsRequest request) throws HashNutException;
    QueryChainsResponse queryAllChainInfo(QueryChainsRequest request) throws HashNutException;
    QueryCoinsResponse querySupportCoin(QuerySupportCoinRequest request) throws HashNutException;
    QueryOrderResponse queryOrder(QueryOrderRequest request) throws HashNutException;
    CreateOrderResponse createOrder(CreateOrderRequest request) throws HashNutException;
    CreatePassThroughOrderResponse createPassThroughOrder(CreatePassThroughOrderRequest request) throws HashNutException;
    SingleResponse lockPayOrder(LockPayOrderRequest build) throws HashNutException;
    SingleResponse confirmPayOrder(ConfirmPayOrderRequest build) throws HashNutException;
}
