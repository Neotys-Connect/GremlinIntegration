package com.neotys.gremlin.common;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Multimaptest {

    private Map<String, String[]> getTags(String tag)
    {
        Multimap<String,String> hashMap= ArrayListMultimap.create();
        if(tag.contains(","))
        {
            //case of several tags
            List<String> listofTags= Arrays.asList(tag.split(","));
            listofTags.stream().forEach(s -> {
                String[] strings=s.split(":");
                if(strings.length>0) {
                    hashMap.put(strings[0], strings[1]);
                }
            });
        }
        else {
            String[] strings = tag.split(":");
            if(strings.length>0) {
                hashMap.put(strings[0], strings[1]);
            }
        }


        //---clean t
        Map<String, Collection<String>> stringCollectionMap = hashMap.asMap();
        Map<String,String[]> result=stringCollectionMap.entrySet().stream().collect(Collectors.toMap(o -> o.getKey(),o -> o.getValue().toArray(new String[]{})));

        return result;
    }
    @Test
    public void testtags()
    {
        String tags="app:redis,app:top";
        Map<String,String[]> stringHashMap=getTags(tags);

        System.out.println(stringHashMap.toString());
    }
}
