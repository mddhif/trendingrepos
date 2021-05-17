package com.gemography.trendingrepos;




public class License
{
    private String key;

    private String name;

    private String spdx_id;

    private String url;

    private String node_id;

    public void setKey(String key){
        this.key = key;
    }
    public String getKey(){
        return this.key;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setSpdx_id(String spdx_id){
        this.spdx_id = spdx_id;
    }
    public String getSpdx_id(){
        return this.spdx_id;
    }
    public void setUrl(String url){
        this.url = url;
    }
    public String getUrl(){
        return this.url;
    }
    public void setNode_id(String node_id){
        this.node_id = node_id;
    }
    public String getNode_id(){
        return this.node_id;
    }
}
