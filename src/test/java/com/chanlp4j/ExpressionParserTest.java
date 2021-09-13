package com.chanlp4j;

import com.chanlp4j.query.ParseException;

import java.util.HashMap;
import java.util.Map;


class ExpressionParserTest {


    public static void main(String args[]) throws ParseException {

        Map<String,String> exressionMap=new HashMap();
        exressionMap.put("16","(洗衣 || 干洗 || 熨衣 || 挂烫机 || 熨斗) && (有 || 提供 || 服务 || 可 || 帮) && !(洗衣液 || 洗衣粉)");
        ExpressionParser.getInstance().load(exressionMap);

        System.out.println(ExpressionParser.getInstance().getMatchItems("酒店提供干洗服务"));
        System.out.println(ExpressionParser.getInstance().getMatchItems("想洗衣服没洗衣粉"));

    }


}