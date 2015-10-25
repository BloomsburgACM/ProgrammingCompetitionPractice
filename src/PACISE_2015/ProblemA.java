package PACISE_2015;

/**
 * PACISE 2015 Problem A - Best Fishing Pattern
 *
 * @author Daniel Pany
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ProblemA 
{
    public void Start()
    {
        ArrayList<String> list = new ArrayList<String>();
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine())
        {
            String line = scan.nextLine();
            if (line.equals("x")) break;
            
            
            boolean hasFish = false;
            for (String fish : list) 
            {
                if (sortOnColors(fish).equals(sortOnColors(line))) hasFish = true;
            }
            
            if (!hasFish) 
            {
                list.add(line);
                map.put(sortOnColors(line).hashCode(), 1);
            }
            else 
            {
                map.put(sortOnColors(line).hashCode(), map.get(sortOnColors(line).hashCode())+1);
            }
            
        }
        
        int max = 0;
        String bestFish = "";
        
        for (String fish : list) 
        {
            if (map.get(sortOnColors(fish).hashCode()) > max)
            {
                max = (int) map.get(sortOnColors(fish).hashCode());
                bestFish = fish;
            }
        }
        
        System.out.println(bestFish);
        
    }
    
    
    private String sortOnColors(String fishString)
    {
        String[] split = fishString.split("\\s+");
        int colorCount = split.length-1;
        String depth = split[0];
        String[] colors;
        colors = new String[colorCount];

        for (int i = 0; i < colors.length; i++)
        {
            colors[i] = split[i+1];
        }

        Arrays.sort(colors);


        String fish = depth + " ";
        for (int i = 0; i < colors.length; i++)
        {
            fish += colors[i];
            if (i != colors.length-1) fish+=" ";
        }

        return fish;
    }
    
}
/*
 surface blue white yellow
 shallow blue silver red
 medlum blue white
 shallow silver red blue
 surface gold green
 shallow silver red blue
 */

/* Output
 shallow blue silver red
 */
