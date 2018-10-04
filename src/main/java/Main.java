import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cbu527.com.countryclasses.DifferentCountries;
import cbu527.com.countryclasses.UFO;
import org.apache.commons.lang3.StringUtils;

public class Main{

    public static ArrayList<UFO> listOfUFO;
    static FileInputStream fis;
    static BufferedReader br;
    static int counter =0;
    public static void main(String[] args) {
      System.out.println("Welcome to the Universe");
      listOfUFO = new ArrayList<UFO>();
      File input = new File("src/main/resources/scrubbed.csv");
      try{
          fis = new FileInputStream(input);
          br = new BufferedReader(new InputStreamReader(fis));

          String dataLine = br.readLine();
          while(dataLine != null){
              if(!StringUtils.isEmpty(dataLine)){
                  List<String> list = Arrays.asList(dataLine.split(","));
                  UFO sight = new UFO(list);
                  listOfUFO.add(sight);
                  counter++;

              }
              dataLine = br.readLine();
          }
          br.close();
      }catch(IOException e){
          System.err.println("File doesn't Exits");
      }
      System.out.println("Total number of UFO's seen so far:"+" "+listOfUFO.size());
      DifferentCountries dc = new DifferentCountries();
      for(UFO sight:listOfUFO){
          if(sight.getCountry().equals("us"))
              dc.setUSA(dc.getUSA()+1);
          if(sight.getCountry().equals("ca"))
              dc.setCanada(dc.getCanada()+1);
          if(sight.getCountry().equals("gb"))
              dc.setGreatBritian(dc.getGreatBritian()+1);
          if(sight.getCountry().equals(""))
              dc.setUnknown(dc.getUnknown()+1);
      }
        System.out.println("USA: "+dc.getUSA());
        System.out.println("Canada: "+dc.getCanada());
        System.out.println("Great Britian: "+dc.getGreatBritian());
        System.out.println("Unknown Countries: "+dc.getUnknown());
    }
}