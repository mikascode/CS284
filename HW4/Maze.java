package Maze;
import java.util.ArrayList; 
import java.util.Stack; 

//Name: Rashmika Batra 
//Section: RI 
//I pledge my honor that I have abided by the Stevens Honor System. 
/**
 * Class that solves maze problems with backtracking.
 * @author Koffman and Wolfgang
 **/
public class Maze implements GridColors {

    /** The maze */
    private TwoDimGrid maze;

    public Maze(TwoDimGrid m) {
        maze = m;
    }

    /** Wrapper method. */
    public boolean findMazePath() {
        return findMazePath(0, 0); // (0, 0) is the start point.
        
    }

    /**
     * Attempts to find a path through point (x, y).
     * @pre Possible path cells are in BACKGROUND color;
     *      barrier cells are in ABNORMAL color.
     * @post If a path is found, all cells on it are set to the
     *       PATH color; all cells that were visited but are
     *       not on the path are in the TEMPORARY color.
     * @param x The x-coordinate of current point
     * @param y The y-coordinate of current point
     * @return If a path through (x, y) is found, true;
     *         otherwise, false
     */
    public boolean findMazePath(int x, int y) {
    	
    	//checking coordinates are in bound
    	if (maze.getNCols()-1<x||x<0||y<0){ 
    		return false; 
    	}
    	if(maze.getNRows()-1<y) { 
    		return false; 
    	}
    	
    	//checking if it is background color 
    	if(maze.getColor(x, y)!=NON_BACKGROUND) { 
    		return false;	
    	}
    	//checking if it is the exit cell 
    	if (x==maze.getNCols()-1&& y==maze.getNRows()-1) { 
    		maze.recolor(x, y, PATH);
    		return true;	
    	}
    	
    	else { 
    		maze.recolor(x, y, PATH);
    		if  (findMazePath(x, y+1)|| findMazePath(x, y-1) || findMazePath(x-1, y) || findMazePath(x+1, y)) { 
    			return true; 
    		}
    		maze.recolor(x, y, TEMPORARY);
    		return false; 
    	}
    }
    
    public void findMazePathStackBased(int x, int y, ArrayList<ArrayList<PairInt>> result, Stack<PairInt> trace) {
    	//checking coordinates are in bound
    	if (maze.getNCols()-1<x||x<0||y<0){ 
    		return; 
    	}
    	
    	if(maze.getNRows()-1<y) { 
    		return; 
    	}
    	
    	//checking if it is background color 
    	if(maze.getColor(x, y)!=NON_BACKGROUND) { 
    		return;	
    	}
    	//checking if it is the exit cell 
    	if (x==maze.getNCols()-1&& y==maze.getNRows()-1) { 
    		PairInt pair = new PairInt(x,y); 
    		trace.push(pair); 
    		maze.recolor(x, y, PATH);
    		ArrayList<PairInt> list = new ArrayList<>(); 
    		list.addAll(trace); 
    		
    		result.add(list);
    		maze.recolor(x, y, NON_BACKGROUND); 
    		trace.pop(); 
    		return;	
    	}
    	//recursive calls 
    	else { 
    		PairInt pair = new PairInt(x,y); 
    		trace.push(pair); 
    		maze.recolor(x, y, PATH);	
    		findMazePathStackBased(x+1, y, result, trace); 
    		findMazePathStackBased(x, y+1, result, trace); 
    		findMazePathStackBased(x-1, y, result, trace); 
    		findMazePathStackBased(x, y-1, result, trace); 
    		maze.recolor(x, y, NON_BACKGROUND); 
    		trace.pop(); 
    		
    	}
    	}
    	
    
    //main function 
    public ArrayList<ArrayList<PairInt>> findAllMazePaths(int x, int y) {
    	ArrayList<ArrayList<PairInt>> result = new ArrayList<>(); 
    	Stack<PairInt> trace= new Stack<>(); 
    	findMazePathStackBased(0,0,result, trace); 
    	//checking if result is empty 
    	if (result.isEmpty()) { 
    	ArrayList<ArrayList<PairInt>> empty = new ArrayList<>();	
    	ArrayList<ArrayList<PairInt> >empty2 = new ArrayList<>();
    	ArrayList<PairInt> empty3 = new ArrayList<>();
    	empty.addAll(empty2); 
    	empty.add(empty3);
    	return empty; 
    	}
    	else { 
    	return result; 
    }
    }

    
    public ArrayList<PairInt> findMazePathMin(int x, int y) {
  
    	ArrayList<ArrayList<PairInt>> path = new ArrayList<> (); 
    	path= findAllMazePaths(x,y);
    	//if no paths exist 
    	if (path.size()==0) { 
    		ArrayList<PairInt> empty = new ArrayList<> (); 
    		return  empty; 
    	}
    	ArrayList<PairInt> min= path.get(0); 
    	//looping through the array to find the shortest path 
    	for (int i=0; i<path.size(); i++) { 
    		if (path.get(i).size()<(min.size())) { 
    			min=path.get(i); 
    		}
    	}
    	return min; 
    }
    

    public void resetTemp() {
        maze.recolor(TEMPORARY, BACKGROUND);
    }

    public void restore() {
        resetTemp();
        maze.recolor(PATH, BACKGROUND);
        maze.recolor(NON_BACKGROUND, BACKGROUND);
    }
    

    
    public static void main(String[] args) {
    	
    }
}


