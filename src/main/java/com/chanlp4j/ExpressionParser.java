package com.chanlp4j;


import com.chanlp4j.query.ParseException;
import com.chanlp4j.query.TermList;
import com.chanlp4j.query.TermQueryParser;
import com.hankcs.hanlp.collection.trie.DoubleArrayTrie;
import org.apache.commons.lang3.StringUtils;


import java.io.ByteArrayInputStream;
import java.util.*;

/**
 * Created by pfchang
 * on 2021/9/9.
 */
public class ExpressionParser<T> {


    private  DoubleArrayTrie<String> trie=new DoubleArrayTrie();


    private Map<T, String> exressionMap;

    private static ExpressionParser instance=new ExpressionParser();

    private ExpressionParser(){}

    public static ExpressionParser getInstance(){
        return instance;
    }


    public void load(Map<T, String> dict){
        TreeMap<String,String> treeMap=new TreeMap<>();
        Map<T,String> exressionMap=new HashMap();

        for(Map.Entry<T, String> entry:dict.entrySet())
        {
            String value=entry.getValue().toLowerCase();
            T key=entry.getKey();
            if(StringUtils.isNotBlank(value))
            {

                exressionMap.put(key,value);

                String[] termTypeStr = value.split("\\|\\||&&|\\(|\\)|\\!|\\<int\\>|\\-");
                for(String s:termTypeStr)
                {
                    if(StringUtils.isNotBlank(s))
                    {
                        treeMap.put(s.trim().toLowerCase(),null);

                    }
                }
            }
        }


        trie.build(treeMap);
        this.exressionMap=exressionMap;
    }


    public ArrayList<T> getMatchItems(String sentence) throws ParseException {


        if(exressionMap==null)
        {
            throw new RuntimeException("请执行load方法初始化");
        }

        HashMap<String,List<Integer[]>> map=new HashMap<String,List<Integer[]>>();
        ArrayList<T> res=new ArrayList<>();
        char[] carray=sentence.toLowerCase().toCharArray();
        DoubleArrayTrie<String>.Searcher searcher
                = trie.getSearcher(carray, 0);
        while (searcher.next()) {
            Integer offset[]=new Integer[2];
            offset[0]=searcher.begin;
            offset[1]=searcher.length;
            String token=new String(carray, searcher.begin, searcher.length);
            if(map.containsKey(token))
            {
                map.get(token).add(offset);
            }else{
                ArrayList<Integer[]> offList=new ArrayList<>();
                offList.add(offset);
                map.put(new String(carray, searcher.begin, searcher.length),offList);
            }

        }

        for (Map.Entry<T, String> entry : exressionMap.entrySet()) {

            TermQueryParser filter = new TermQueryParser(new ByteArrayInputStream(entry.getValue().getBytes()),"utf-8");
            if (filter.parse(new TermList(map,carray))) {
                res.add(entry.getKey());
            }


        }

        return res;
    }



}
