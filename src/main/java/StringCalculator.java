/*
* ODI - TP1
* 18.02.2019 - DeS
*/

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

   public StringCalculator() {
   }
   
   public int Add(String numbers){
    int returnNumber = 0;
    boolean cancel = false;
    List<String> delimiters =new ArrayList<String>();
   
    if((!(numbers.matches("^([0-9]+|\\/\\/(\\[.+\\])\\n[0-9]+)((.*|\\n)[0-9]+)*"))) || numbers == null)
    {
      cancel = true;
    }else
    {
      if(numbers.contains("//")){
        Matcher m = Pattern.compile("\\[.*?[^\\[]\\]")
                .matcher(numbers);
        while (m.find()) {
          delimiters.add(m.group().replace("[","").replace("]",""));
        }
        numbers = numbers.substring(numbers.indexOf("\n")+1);

        for (String delimiter : delimiters) {
          numbers = numbers.replace(delimiter,",");
        }
      }
    }
    if(cancel == false)
    {
      numbers = numbers.replace("\n",",");
      String[] Lchar = numbers.split(",");
      for(int i = 0; i<Lchar.length;i++){
        System.out.println(numbers);
        if(Integer.parseInt(Lchar[i])<0)
        {
          throw new RuntimeException(Lchar[i]+" is negative.");
        }
        if(Integer.parseInt(Lchar[i])<1000)
        {
          returnNumber = returnNumber + Integer.parseInt(Lchar[i]);
        }
      }
    }
    return returnNumber;
  }
   


}
