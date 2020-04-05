package com.java8;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamsFlatmap {

	public static void main(String[] args) {
		String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

        //Stream<String[]>
        Stream<String[]> temp = Arrays.stream(data);
                
        //filter a stream of string[], and return a string[]?
        Stream<String[]> stream = temp.filter(x -> "a".equals(x.toString()));

        stream.forEach(System.out::println);
        String[][] flatmapdata = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

        //Stream<String[]>
        Stream<String[]> flatmaptemp = Arrays.stream(flatmapdata);
        
      //Stream<String>, GOOD!
        Stream<String> stringStream = flatmaptemp.flatMap(x -> Arrays.stream(x));
        stringStream.forEach(System.out::println);
        //Stream<String> flatmapstream = stringStream.filter(x -> "a".equals(x.toString()));

       //flatmapstream.forEach(System.out::println);

	}

}
