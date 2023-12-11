package com.kafka.Utils;

import com.jayway.jsonpath.JsonPath;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Set;

@Slf4j
public class Utils {

    public static JSONObject getAllXpathAndValueFromJsonObject(JSONObject json, Object document) {
        Set<String> jsonKeys = json.keySet();
        for (String key : jsonKeys) {
            Object object = json.get(key);
            if (object instanceof JSONObject) {
                getAllXpathAndValueFromJsonObject((JSONObject) object, document);
            }
            if (object instanceof JSONArray) {
                doJsonArray((JSONArray) object, json, key, document);
            }
            if (object instanceof String || object instanceof Boolean || object == null) {
                Object o = json.get(key);
                if (isExpression(o)) {
                    json.put(key, getExpressionValue(document, json.get(key).toString()));
                } else {
                    json.put(key, o);
                }
            }
        }
        return json;
    }

    private static void doJsonArray(JSONArray object, JSONObject json, String key, Object document) {
        for (int i = 0; i < object.length(); i++) {
            Object obj = object.get(i);
            if (obj instanceof JSONObject) {
                getAllXpathAndValueFromJsonObject((JSONObject) obj, document);
            }
            if (obj instanceof JSONArray) {
                doJsonArray((JSONArray) obj, json, key, document);
            }
            if (obj instanceof String || obj instanceof Boolean || obj == null) {
                Object o = json.get(key);
                if (isExpression(o)) {
                    json.put(key, getExpressionValue(document, json.get(key).toString()));
                } else {
                    json.put(key, o);
                }
            }
        }
    }

    public static boolean isExpression(Object value) {
        log.info("Inside isExpression having value : {} ", value);
        if (!(value instanceof String)) {
            log.info("Value is not an String");
            return false;
        }
        String strValue = (String) value;
        if (strValue.startsWith("$") && strValue.length() == 1) return true;
        return strValue.contains("$") && strValue.contains(".");
    }


    public static Object getExpressionValue(Object document, String expression) {
        Object ftrData = null;
        try {
            log.info("rule expression {}", expression);
            ftrData = JsonPath.read(document, expression);
        } catch (Exception e) {
            log.error("Error occurred while getExpressionValue having Payload : {} and Expression : {} cause : {}", document, expression, e.getStackTrace());
        }
        return ftrData;
    }



}
