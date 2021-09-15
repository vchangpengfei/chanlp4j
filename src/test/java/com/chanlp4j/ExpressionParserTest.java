package com.chanlp4j;

import com.chanlp4j.query.ParseException;
import java.util.HashMap;
import java.util.Map;


class ExpressionParserTest {


    public static void main(String args[]) throws ParseException {

        Map<String,String> exressionMap=new HashMap();
        exressionMap.put("16","(洗衣 || 干洗 || 熨衣 || 挂烫机 || 熨斗) && (有 || 提供 || 服务 || 可 || 帮) && !(洗衣液 || 洗衣粉)");
        exressionMap.put("120","<int>钱 || <int>元 || 多少钱");
        exressionMap.put("110","床-大床房-双床房");
        ExpressionParser.getInstance().load(exressionMap);

        System.out.println(ExpressionParser.getInstance().getMatchItems("酒店房间115元"));
        System.out.println(ExpressionParser.getInstance().getMatchItems("钱"));
        System.out.println(ExpressionParser.getInstance().getMatchItems("酒店房间没多少钱"));
        System.out.println(ExpressionParser.getInstance().getMatchItems("想洗衣服没洗衣粉"));
        System.out.println(ExpressionParser.getInstance().getMatchItems("大床房的床很大"));
        System.out.println(ExpressionParser.getInstance().getMatchItems("大床房和双床房的床很大"));
        System.out.println(ExpressionParser.getInstance().getMatchItems("大床房和双床房很大"));
        System.out.println(ExpressionParser.getInstance().getMatchItems("大床房很大"));

    }





}
