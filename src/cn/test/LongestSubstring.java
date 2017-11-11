package cn.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LongestSubstring {
	
	public static void main(String[] args) {
		System.out.println(gen("abcc"));
	}

	public static int gen(String m){
		char[] charArray = m.toCharArray();
		List<Integer> lst=new ArrayList<>();
		List<String> list= null;
		if(charArray.length==1){
			return 1;
		}else{
			for(int i=0;i<charArray.length;i++){
				String temp = String.valueOf(charArray[i]);
				if(list==null){
					list=new ArrayList<>();
				}else if(list.contains(temp)){
					lst.add(list.size());
					list=new ArrayList<>();
				}
				list.add(temp);
			}
		}
		int temp=0;
		for(Integer i : lst){
			if(i>temp){
				temp=i;
			}
		}
		return temp;
	}
}
