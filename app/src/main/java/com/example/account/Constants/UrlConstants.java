package com.example.account.Constants;

public class UrlConstants {

    public static final String BASE_URL = "http://10.0.2.2:8080/";        //服务器地址
    public static final String GET_ALL_INCOME_TYPES = BASE_URL+"api/aIncomeType/getAllIncomeTypes";
    public static final String INSERT_ONE_USER = BASE_URL+"api/aUser/insertOne";
    public static final String GET_ONE_USER = BASE_URL+"api/aUser/selectOne";
    public static final String GET_WEEKLY_COST_STATISTICS = BASE_URL+"api/statistics/getWeeklyExpenditureStatistics";
}
