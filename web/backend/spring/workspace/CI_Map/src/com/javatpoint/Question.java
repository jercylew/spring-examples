package com.javatpoint;  
import java.util.Iterator;  
import java.util.Map;  
import java.util.Set;  
import java.util.Map.Entry;  

public class Question {  
	private int m_nId;  
	private String m_strName;  
	private Map<String, String> m_mapAnswers;  

	public Question() {}  
	public Question(int id, String name, Map<String, String> answers) {  
		super();
		
		this.m_nId = id;  
		this.m_strName = name;  
		this.m_mapAnswers = answers;  
	}  

	public void displayInfo(){  
		System.out.println("question id:" + m_nId);  
		System.out.println("question name:" + m_strName);  
		System.out.println("Answers....");  
		Set<Entry<String, String>> set = m_mapAnswers.entrySet();  
		Iterator<Entry<String, String>> itr = set.iterator();
		
		while(itr.hasNext()) {  
			Entry<String,String> entry = itr.next();  
			System.out.println("Answer:" + entry.getKey() + " Posted By:" + entry.getValue());  
		}  
	}  
}