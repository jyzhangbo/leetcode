package cn.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Test2 {
	
	public static void main(String[] args) {
		System.out.println(gen("abcbbad"));
	}

	public static int gen(String m){
		char[] charArray = m.toCharArray();
		Map<List<String>,Integer> map=new HashMap<>();
		List<String> list= null;
		for(int i=0;i<charArray.length;i++){
			String temp = String.valueOf(charArray[i]);
			if(list!=null && !list.contains(temp)){
				list.add(temp);
			}else{
				list=new ArrayList<>();
				list.add(temp);
			}
			map.put(list, list.size());
		}
		Integer temp = 0;
		for(Entry<List<String>, Integer> entry  : map.entrySet()){
			if(entry.getValue()>temp){
				temp = entry.getValue();
			}
		}
		
		return temp;
	}
}
