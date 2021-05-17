package com.gemography.trendingrepos;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

import com.google.gson.Gson;
import org.json.simple.JSONObject;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;


@RestController
public class TrendingReposController {
	
   
  //String baseUrl = "https://api.github.com/search/repositories" ;

   //url parameter for restTemplate 
	String url =  "https://api.github.com/search/repositories?q=created:>"+getDate()+"&sort=stars&order=desc";

  // client used to make HTTP requests to Github
  @Autowired
  private RestTemplate restTemplate;


  //method to handle get requests and return final result 
  @GetMapping("/trendingrepos")
	public Object repos() throws Exception {
    
      //retrieve repos JSON string from Github
	  String repos = restTemplate.getForObject(url, String.class);

      
      //extract items from reponse using Gson library
      Gson gson = new Gson();
      JSONObject jsonObject = gson.fromJson(repos, JSONObject.class);
      String items = gson.toJson(jsonObject.get("items"));

      
      //map items into a list of resources to model the objects in the items array
      ObjectMapper mapper = new ObjectMapper();
      
      List<ReposResource> list = mapper.readValue(items, new TypeReference<List<ReposResource>>(){});
 
      
      //iterate through our list of ReposResources and group them by language     
      Map<String, List<ReposResource>> groupedMap = list.stream().filter(x -> x.getLanguage() != null)

      .collect(Collectors.groupingBy(ReposResource::getLanguage));
      


      //send json response to client, now as a grouped Map
      return groupedMap ;
      

    }


    //get 30 days before today
    public String getDate() {

        Date now = new Date();

        Calendar calendar = new GregorianCalendar();

		calendar.setTime(now);

		calendar.add(Calendar.DAY_OF_MONTH, -30);

		Date amonthago = calendar.getTime();  

		String simpledate = new SimpleDateFormat("yyyy-MM-dd").format(amonthago);

		return simpledate;


    }
    

}