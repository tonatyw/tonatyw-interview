package com.lerss.ent.api

class MyBlogEntry {
	String title
    String content
    Date dateCreated
    static constraints = {
    	title (blank:false)
       	content (blank:false)
       	dateCreated (blank:false)
    }
}
