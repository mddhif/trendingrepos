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

@RestController
public class TrendingReposController {
	
   
  //String baseUrl = "https://api.github.com/search/repositories" ;

   //url parameter for restTemplate 
	String url =  "https://api.github.com/search/repositories?q=created:>"+getDate()+"&sort=stars&order=desc";

  // client used to make HTTP requests to Github
  @Autowired
  private RestTemplate restTemplate;


  //method to handle get requests and return final result 
  @GetMapping("/repos")
	public Object repos() throws Exception {
    
      //retrieve repos JSON string from Github
	  String repos = restTemplate.getForObject(url, String.class);

      
      //send json response to client
      return repos ;
      

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