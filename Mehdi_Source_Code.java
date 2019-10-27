package team_Formation_Code_C;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.*;

public class Mehdi_Source_Code {
	
		public static void main(String[] args) {
		}
		
		public static Map<Integer, Map<Integer, Double>> readGraphEdgeHash (String edgeHashFileName, String folderLocation) {
		    String line = null; 
		
		    Map<Integer, Map<Integer, Double>> edgeHash = new HashMap<Integer, Map<Integer, Double>>();

		    int edgeCount = 0;
		    int maxNodeDegree = 0;
//When starting from a single project expert, you initialize the edge count as 0. 
//As you begin to add more experts in the network, your edge count value will begin to incrementally increase in value//
//maxNodeDegree represents the total neighbor distance value within the network// 
		    
		    try {
		        BufferedReader input =  new BufferedReader(new FileReader(new File(folderLocation + "/" + edgeHashFileName)));
//Read from a file, containing the team formation information. Project Experts, number of nodes, neighbor distance value, etc)// 
//Buffered reader method helps interpret the information more efficiently/in a seamless manner. 		        
		        
		        while ( (( line = input.readLine()) != null ) ){
		            line = line.trim();
		            String []row = line.split("\t");
//While loop used to read through every line within the edgehashfile and process the information stored in the file//
//line.split("\t") Adds a space between each string in the file. 
//E.g. 0    1#0.2     2#0.4    		            
		            
		            edgeHash.put(Integer.parseInt(row[0]), new HashMap<Integer, Double>());
		            //So, the new HashMap contains the values of the Integer(Node) and the Double (Neighbor distance value)//

		            if((row.length - 1) > maxNodeDegree)
		                maxNodeDegree = (row.length-1);
		            
//What is the significance of the if statement here? What does the row.length represent here exactly?//
//What function does the row.length represent here exactly? 
		            
		            for(int i=1; i<row.length; i ++){
		                String []neighborDist = row[i].split("#");
		                edgeHash.get(Integer.parseInt(row[0])).put(Integer.parseInt(neighborDist[0]), Double.parseDouble(neighborDist[1]));
		                edgeCount ++;
		            }
		        }
////row[i].split("#"); Adds a space between the integers in the data file?// 
//Because line.split(“\t”) is the space between strings in the file//		        
		       
		        input.close();

		    }catch(Exception ex){
		        System.out.print(ex.getMessage()+"\n");
		    }

		    System.out.println("edgeCount: " + edgeCount/2);
		    System.out.println("maxNodeDegree: " + maxNodeDegree);
//Upon reading from the file, you would return the computed edgeCount value + the maxNodeDegree//
//Values are completely dependent upon how many nodes exist in the file itself. 
//The total incurred neighbourDist. values within the network, are dependent upon how many
//experts exist within the network, and the set of skills needed for successful project completion//
		    return edgeHash;
		}
		// TODO Auto-generated method stub

	}

}
