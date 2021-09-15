package com.chanlp4j.query;

import com.hankcs.hanlp.utility.CharacterHelper;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by pfchang
 * on 2020/7/30.
 */
public class TermList {

    Set< String > set;

    HashMap<String, List<Integer[]>> map;

    char[] charArr;

    public TermList(Set< String > set) {
        this.set = set;
    }

    public TermList(HashMap<String, List<Integer[]>> map) {
        set=map.keySet();
        this.map=map;
    }

    public TermList(HashMap<String, List<Integer[]>> map, char[] carray) {
        this.set=map.keySet();
        this.map=map;
        this.charArr=carray;
    }

    public boolean contain(String image) {

        boolean needInt=false;
        if(image.indexOf("<int>")!=-1)
        {
            image=image.replace("<int>","");
            needInt=true;
        }

        List<Integer[]> x = processExclude(image);


        if(x!=null&&x.size()>0&&needInt)
        {
            boolean hasInt=false;
            for(Integer[] offset:x)
            {
                if(offset[0]>0)
                {
                    if(CharacterHelper.isArabicNumber(charArr[offset[0]-1]))
                    {
                        hasInt=true;
                    }
                }
            }

            if(hasInt)
            {
                return true;
            }else{
                return false;
            }

        }

        if (x != null&&x.size()>0)
            return true;

        return set.contains(image);
    }

    private List<Integer[]> processExclude(String image) {
        String excludeArr[]= StringUtils.split(image,'-');
        if(excludeArr.length>1&&set.contains(excludeArr[0]))
        {
            List<Integer[]> offList=map.get(excludeArr[0]);
            List<Integer[]> offListTemp=new ArrayList<>(offList);

            int termNum=offList.size();
            for(int i=1;i<excludeArr.length;i++)
            {

                List<Integer[]> otherOffList=map.get(excludeArr[i]);
                if(otherOffList!=null)
                {
                    for(Integer[] offset:otherOffList)
                    {
                        for(Integer[] off:offList)
                        {
                            if(checkCross(off,offset))
                            {
                                termNum--;
                                offListTemp.remove(off);
                                if(termNum==0)
                                {
                                    return null;
                                }
                            }
                        }
                    }
                }
            }
            return offListTemp;
        }else{
            return map.get(image);
        }
    }

    public boolean contain(Token token,String image) {
        List<Integer[]> x = processExclude(image);
        if(token!=null&&token.image.equals("<int>"))
        {
            for(Integer[] offset:x)
            {

                for(int i=offset[0];i>=0;i--)
                {

                }


            }



        }else{
            if (x != null&&x.size()>0)
                return true;
            else
                return false;
        }

        return contain(image);
    }


    public boolean checkCross(Integer[] a,Integer[] b) {
        return (a[0] >= b[0] && a[0] <= b[0]+b[1])
                || (a[0]+a[1] >= b[0] && a[0]+a[1] <= b[0]+b[1]);
    }

}
