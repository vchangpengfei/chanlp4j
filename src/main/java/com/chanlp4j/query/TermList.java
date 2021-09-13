package com.chanlp4j.query;

import java.util.Set;

/**
 * Created by pfchang
 * on 2020/7/30.
 */
public class TermList {

    Set< String > set;

    public TermList(Set< String > set) {
        this.set = set;
    }

    public boolean contain(String image) {
        return set.contains(image);
    }
}
