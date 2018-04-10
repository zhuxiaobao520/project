package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class PropertyUtil {

	private static Properties properties;

	static{
		properties=new Properties();
	}
	public static  void writeFile(String key,String value){
		FileOutputStream fileOutputStream=null;
		FileInputStream fileInputStream=null;
		try {
			fileInputStream=new FileInputStream("m.properties");
			properties.load(fileInputStream);
			
			fileOutputStream=new FileOutputStream("m.properties");
			int index=properties.size()+1;
			properties.put(index+"."+key, value);
			//遍历
			List<Integer>list=new ArrayList<>();
			Collection<Object>objects=properties.values();
			for(Object object:objects){
				list.add(Integer.parseInt(object.toString()));
			}
			for(int i=0;i<list.size();++i){
				for(int j=0;j<list.size()-1;++j){
					if(list.get(i)>list.get(j)){
						Integer temp=list.get(i);
						list.set(i, list.get(j));
						list.set(j, temp);
					}
				}
			}
			Set<Object>keyset=properties.keySet();
			for(int i=0;i<list.size();++i){
				for(Object object:keyset){
					
					if(properties.getProperty(object.toString()).equals(list.get(i)+"")){
						Properties p=new Properties();
						p.put(object, list.get(i)+"");
						p.store(fileOutputStream, null);
					}
				}
			}
			
			
//			properties.put(index+"."+key, value);
//			properties.store(fileOutputStream, null);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
