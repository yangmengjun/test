package com.base.webcrowler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 网络爬虫
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Json
 * @since 1.0.0
 */
public class WebCrawlerDemo {
    public static void main(String[] args) {
        printAllLinks("http://www.shanbay.com/");
    }

    private static void printAllLinks(String baseUrl) {
        /*1.连接-是否被遍历*/
        Map<String, Boolean> oldMap = new LinkedHashMap<>();
        String oldLinkHost = "";
        Pattern p = Pattern.compile("<a.*?href=[\"']?((https?://)?/?[^\"']+)[\"']?.*?>(.+)</a>");
        Matcher m = p.matcher(baseUrl);
        if (m.find()) {
            oldLinkHost = m.group();
        }
        oldMap.put(baseUrl, false);
        oldMap = crawLinks(oldLinkHost, oldMap);
        for (Map.Entry<String, Boolean> entry : oldMap.entrySet()) {
            System.out.println("链接：" + entry.getKey());
        }
    }

    /**
     * 抓取一个网站所有可以抓取的网页链接，在思路上使用了广度优先算法
     * 对未遍历过的新链接不断发起GET请求，一直到遍历完整个集合都没能发现新的链接
     * 则表示不能发现新的链接了，任务结束
     * 
     * @param oldLinkHost  域名，如：http://www.zifangsky.cn
     * @param oldMap  待遍历的链接集合
     * 
     * @return 返回所有抓取到的链接集合
     * */
    private static Map<String, Boolean> crawLinks(String oldLinkHost, Map<String, Boolean> oldMap) {
        Map<String, Boolean> newMap = new LinkedHashMap<String, Boolean>();
        String oldLink = "";
        for (Map.Entry<String, Boolean> mapping : oldMap.entrySet()) {
            oldLink = mapping.getKey();
            System.out.println("link:" + oldLink + " check:" + mapping.getValue());
            if (!mapping.getValue()) {//没有发出请求
                try {
                    URL url = new URL(mapping.getKey());
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(2000);
                    connection.setReadTimeout(2000);
                    if (connection.getResponseCode() == 200) {
                        InputStream is = connection.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                        String line = "";
                        Pattern p = Pattern.compile("<a.*?href=[\"']?((https?://)?/?[^\"']+)[\"']?.*?>(.+)</a>");
                        Matcher matcher = null;
                        while ((line = reader.readLine()) != null) {
                            matcher = p.matcher(line);
                            if (matcher.find()) {
                                String newLink = matcher.group(1).trim();//链接
                                String title = matcher.group(3).trim();//标题
                                // 判断获取到的链接是否以http开头   
                                if (newLink.startsWith("http")) {
                                    if (newLink.startsWith("/")) {
                                        newLink = oldLinkHost + newLink;
                                    } else {
                                        newLink = oldLinkHost + "/" + newLink;
                                    }
                                }
                                //去除链接末尾的 /
                                if (newLink.endsWith("/")) {
                                    newLink = newLink.substring(0, newLink.length() - 1);
                                }
                                //去重，并且丢弃其他网站的链接
                                if (!oldMap.containsKey(newLink) && !newMap.containsKey(newLink)
                                        && newLink.startsWith(oldLinkHost)) {
                                    // System.out.println("temp2: " + newLink);
                                    newMap.put(newLink, false);
                                }
                            }
                        }
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                oldMap.put(oldLink, true);
            }
            //有新链接，继续遍历
            if (!newMap.isEmpty()) {
                oldMap.putAll(newMap);
                oldMap.putAll(crawLinks(oldLinkHost, oldMap));//由于Map的特性，不会导致出现重复的键值
            }
        }
        return oldMap;
    }

}
