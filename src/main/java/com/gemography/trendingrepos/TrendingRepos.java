package com.gemography.trendingrepos;


import java.util.List;


//model class for trending repos
public class TrendingRepos {

private String language ;
private int numberOfRepos;
private List repos;


public TrendingRepos(String language, int numberOfRepos, List repos) {

     this.language = language;
     this.numberOfRepos = numberOfRepos;
     this.repos = repos;

}

public String getLanguage() {

   return language;

}

public int getNumberOfRepos() {

	return numberOfRepos;
}

public List getRepos() {


	return repos;
}


}