package com.example.SpringWebApplication.service;

import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class NewsService {

    private String news ="{\n" +
            "  \"section\": \"section topic\",\n" +
            "  \"offset\": \"0\",\n" +
            "  \"results\": [\n" +
            "    {\n" +
            "      \"body\": \"Great spellers come in all types, from egotistical showoffs to loners who find sanctuary in the forest of words. Kunal Sah, a 13-year-old eighth-grader, is an angry speller. He lives with his uncle and aunt at the Ramada Limited Motel in this tough former railroad town in eastern Utah. Kunal is making himself into a great speller by way of\",\n" +
            "      \"byline\": \"By KIRK JOHNSON\",\n" +
            "      \"date\": \"20070506\",\n" +
            "      \"title\": \"AMERICAN ALBUM; Torn From Parents, a Top Speller Vents His Anger, Letter by Letter\",\n" +
            "      \"section\": \"AMERICAN ALBUM; Torn From Parents, a Top Speller Vents His Anger, Letter by Letter\",\n" +
            "      \"url\": \"http:\\/\\/www.nytimes.com\\/2007\\/05\\/06\\/us\\/06speller.html\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"body\": \"It began in 1978, Bob J. Frye recalled, as a way to break the ice at the beginning of the semester for his English composition class at Texas Christian University, in Fort Worth. He would write a letter introducing himself to the class, then ask each student to write a letter to him, once a week. No grades on the letters; just an exercise. Twenty\",\n" +
            "      \"byline\": \"By David W. Chen\",\n" +
            "      \"date\": \"19980405\",\n" +
            "      \"title\": \"BLACKBOARD: CLASS CORRESPONDENCE; Studying English, Letter by Letter\",\n" +
            "      \"url\": \"http:\\/\\/www.nytimes.com\\/1998\\/04\\/05\\/education\\/blackboard-class-correspondence-studying-english-letter-by-letter.html\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"tokens\": [\n" +
            "    \"title:\\\"Letter by Letter\\\"\",\n" +
            "    \"body:find\"\n" +
            "  ],\n" +
            "  \"total\": 2\n" +
            "}";

    private String uri = "http://developer.nytimes.com?apiKey=5cce3391e8c945e48eb126bf1a6fdd67";

    public String getTopStories() {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        //Add the Jackson Message converter
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        // Note: here we are making this converter to process any kind of response,
        // not only application/*json, which is the default behaviour
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, String.class);
    }

    public static void main(String s[]){
        NewsService newsService = new NewsService();
        System.out.println(newsService.getTopStories());
    }
}
