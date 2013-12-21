package qa.dataprovider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import com.thoughtworks.xstream.XStream;

public class Test {

	public static void main(String[] args) {
		
		
		Multimap<String, String> myMultimap = ArrayListMultimap.create();
        myMultimap.put("Fruits", "Bannana");
        myMultimap.put("Fruits", "Apple");
        myMultimap.put("Fruits", "Pear");
        myMultimap.put("Vegetables", "Carrot");
     //      int size = myMultimap.size();   System.out.println(size);
     //     Collection<String> fruits = myMultimap.get("Fruits");
     //    System.out.println(fruits); 
     //    Collection<String> vegetables = myMultimap.get("Vegetables");
     //    System.out.println(vegetables);
     //    for(String value : myMultimap.values()) {
     //       System.out.println(value);  
     //       } 
     //     myMultimap.remove("Fruits","Pear");
     //   System.out.println(myMultimap.get("Fruits"));
     // myMultimap.removeAll("Fruits");
     // System.out.println(myMultimap.get("Fruits"));
        
		


		XStream xstream = new XStream();
		xstream.alias("suite", Multimap.class );
		//xstream.alias("test", List.class);
		//xstream.alias("args", String[].class);
		//xstream.alias("arg", String.class);
        //
		String xml = xstream.toXML(myMultimap);
        //
		System.out.println(xml);

		//String[][] strs = (String[][])xstream.fromXML(xml);

	}

}
