package io.hashnut.sdk.config;

import java.math.BigInteger;

public class PayConstant {
    public static void initEnv(int env){
        switch (env){
            case ENV_PRD:
                URL_HOST=URL_HOST_PRD;
                break;
            case ENV_TEST:
                URL_HOST=URL_HOST_TEST;
                break;
            case ENV_DEV:
                URL_HOST=URL_HOST_DEV;
                break;
            default:
                URL_HOST=URL_HOST_DEV;
                break;
        }
        URL_QUERY_ALL_CHAININFO= URL_HOST +API_VERSION+"/mch/queryAllChainInfo";
        URL_QUERY_ALL_COININFO= URL_HOST +API_VERSION+"/mch/queryAllCoinInfo";
        URL_QUERY_SUPPORT_COIN_BY_CHAIN_CODE= URL_HOST +API_VERSION+"/mch/querySupportCoinsByChainCode";
        URL_QUERY_ALL_LEGAL_TENDER = URL_HOST +API_VERSION+"/mch/querySupportLegalTenders";
        URL_QUERY_ALL_FLIAT_EXCHANGE_RATE = URL_HOST +API_VERSION+"/mch/queryFliatExchangeRate";

        URL_CREATE_PAY_ORDER= URL_HOST +API_VERSION+"/pay/createPayOrderWithApiKey";
        URL_QUERY_PAY_ORDER= URL_HOST +API_VERSION+"/pay/queryPayOrderWithAccessSign";
        URL_CONFIRM_PAY_ORDER= URL_HOST +API_VERSION+"/pay/confirmPayOrderPaid";
        URL_LOCK_PAY_ORDER= URL_HOST +API_VERSION+"/pay/lockPayOrder";
    }

    public static final int ENV_PRD=0;
    public static final int ENV_TEST=1;
    public static final int ENV_DEV=2;

    public static String URL_HOST="";
    public static final String URL_HOST_DEV ="https://dev-web3.hashnut.io/api/";
    public static final String URL_HOST_TEST ="https://testnet-web3.hashnut.io/api/";
    public static final String URL_HOST_PRD ="https://hashnut.io/api/";
    private static String API_VERSION = "v1.0.0";
    private static String API_LOCALE = "en";

    public static String URL_QUERY_ALL_CHAININFO= URL_HOST +API_VERSION+"/mch/queryAllChainInfo";
    public static String URL_QUERY_ALL_COININFO= URL_HOST +API_VERSION+"/mch/queryAllCoinInfo";
    public static String URL_QUERY_SUPPORT_COIN_BY_CHAIN_CODE= URL_HOST +API_VERSION+"/mch/querySupportCoinsByChainCode";
    public static String URL_QUERY_ALL_LEGAL_TENDER = URL_HOST +API_VERSION+"/mch/querySupportLegalTenders";
    public static String URL_QUERY_ALL_FLIAT_EXCHANGE_RATE = URL_HOST +API_VERSION+"/mch/queryFliatExchangeRate";
    public static String URL_QUERY_MEMBER_SERVICE_ENTRIES = URL_HOST +API_VERSION+"/upgradeable/queryMemberServiceEntries";

    public static String URL_CREATE_PAY_ORDER= URL_HOST +API_VERSION+"/pay/createPayOrderWithApiKey";
    public static String URL_QUERY_PAY_ORDER= URL_HOST +API_VERSION+"/pay/queryPayOrderWithAccessSign";
    public static String URL_CONFIRM_PAY_ORDER= URL_HOST +API_VERSION+"/pay/confirmPayOrderPaid";
    public static String URL_LOCK_PAY_ORDER= URL_HOST +API_VERSION+"/pay/lockPayOrder";


    public final static byte   	CREATE_CHANNEL_MCH_SYSTEM = 0;	// ??????????????????
    public final static byte   	CREATE_CHANNEL_API_KEY = 1;		// ??????Api Key??????
    public final static byte	ACCESS_CHANNEL_CHAIN = 0;		// ??????????????????

    public static final int RESULT_CODE_SUCCESS = 0;
    public static final int RESULT_CODE_FAILED = -1;
    public static final int RESULT_CODE_EXCEPTION = -2;
    public static final int RESULT_CODE_UNAUTHORIZED = -3;
    public static final int RESULT_CODE_UNAUTHENTICATED = -4;

    public static final String RESULT_MSG_SUCCESS = "success";
    public static final String RESULT_MSG_FAILED = "failed";
    public static final String RESULT_MSG_EXCEPTION = "exception";
    public static final String RESULT_MSG_UNAUTHORIZED = "unauthorized";
    public static final String RESULT_MSG_UNAUTHENTICATED = "unauthenticated";

    public final static byte PAY_STATUS_REFUNDED = -5; 		// ????????????
    public final static byte PAY_STATUS_REFUNDING = -4; 	// ?????????
    public final static byte PAY_STATUS_CANCELED = -3; 		// ??????????????????
    public final static byte PAY_STATUS_EXPIRED = -2; 		// ????????????
    public final static byte PAY_STATUS_FAILED = -1; 		// ????????????
    public final static byte PAY_STATUS_INIT = 0; 			// ?????????
    public final static byte PAY_STATUS_PAID = 1; 			// ?????????
    public final static byte PAY_STATUS_CONFIRMING = 2; 	// ??????????????????
    public final static byte PAY_STATUS_SUCCESS = 3; 		// ????????????
    public final static byte PAY_STATUS_FINISH = 4; 		// ????????????

    public static void setApiVersion(String v){
        API_VERSION=v;
    }
    public static String getApiVersion(){
        return API_VERSION;
    }
    public static void setApiLocale(String l){
        API_LOCALE=l;
    }
    public static String getApiLocale(){
        return API_LOCALE;
    }
}
