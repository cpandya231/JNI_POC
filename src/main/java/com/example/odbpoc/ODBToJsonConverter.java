package com.example.odbpoc;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class ODBToJsonConverter {


        private static Set<String> getNamedGroupCandidates(String regex) {
            Set<String> namedGroups = new TreeSet<String>();
    
            Matcher m = Pattern.compile("\\(\\?<([a-zA-Z][a-zA-Z0-9]*)>").matcher(regex);
    
            while (m.find()) {
                namedGroups.add(m.group(1));
            }
    
            return namedGroups;
        }

        public static  Map<String, String> convertFeaturesToJson(String text) {
            Map<String, String> resultMap=new HashMap<>();
            String patternString = "^P (?<x>\\d(.\\d*)?) (?<y>\\d(.\\d*)?) (?<aptdef>\\d) (?<polarity>P|N) (?<dcode>\\d) (?<orientdef>\\d)( (?<rotation>\\d{0,3}))?;(?<atrs>(?<atrval>\\d*=.*)*|,|(?<atr>\\d*))*;ID=(?<id>\\d*)$";
            Set<String> namedGroupCandidates = getNamedGroupCandidates(patternString);

            Pattern pattern = Pattern.compile(patternString);

            Matcher matcher = pattern.matcher(text);

            if(matcher.find()){
                resultMap= namedGroupCandidates.stream().map(group -> {
                    String[] kv = new String[2];
                    kv[0] = group;
                    kv[1] = matcher.group(group);
                    kv[1] = null != kv[1] ? kv[1] : "";
                    return kv;
    
                }).collect(Collectors.toMap(e -> e[0], e -> e[1]));
                System.out.println(resultMap);
    
            }
            return resultMap;
        }
    }