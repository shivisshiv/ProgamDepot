import java.util.*;

public class Rails2 {
    private java.util.Queue incomingTrain = new java.util.LinkedList();
    private java.util.Queue outgoingTrain = new java.util.LinkedList();
    private ArrayStack station = null;
    
    public void checkCoachOrder(String fileLoc){
        String[] fileAry = SUtil.fileToArray(fileLoc);
        
        for(int lineNum = 1; lineNum < (fileAry.length - 1); lineNum = lineNum++){
        		if(fileAry[lineNum].equals("0")) {
        			//ignores lines that are not input for the outgoing train
        			lineNum = lineNum + 2;
        			System.out.println("");
        		}else {
        			this.initializeOutgoingTrain(fileAry[lineNum]);
            		this.initializeIncomingTrain(this.outgoingTrain.size());
                
                if( this.isTrainReorderPossible() ){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
        		}
        		
        }
    }
    
    public boolean isTrainReorderPossible(){
    		int incomingTrainSize = this.incomingTrain.size();
    		this.station = new ArrayStack(incomingTrainSize);
    		
    		for(int coachNum = 1; coachNum < incomingTrainSize; coachNum++) {
    			//compare first element of incomingTrain and outgoingTrain
    			
    			int incomingCoach =  ( (Integer) this.incomingTrain.peek() ).intValue();
    			int outgoingCoach =  ( (Integer) this.outgoingTrain.peek() ).intValue();
    			
    			
    			if( incomingCoach == outgoingCoach ) {
    				this.incomingTrain.remove();
    				this.outgoingTrain.remove();
    			}else {
    				double incomingCoachDouble = (double) (   ( (Integer) this.incomingTrain.remove() ).intValue()   ) ;
    				this.station.push(incomingCoachDouble);
    			}
    			
    		}
    			
		int outgoingTrainSize = this.outgoingTrain.size();
		int trainsInStation = this.station.size();
		for(int i = trainsInStation ; i > 0; i-- ) {
			int topOfStation = (int) this.station.peek();
			int firstCoachOfOutgoingTrain = ( (Integer) this.outgoingTrain.peek() ).intValue();
			if( topOfStation == firstCoachOfOutgoingTrain) {
				this.station.pop();
				this.outgoingTrain.remove();
			}else {
				return false;
			}
		}
    	
   
    		if(this.outgoingTrain.size() == 0) {
    			return true;
    		}
    	
    		return false;
    }
    
    
    public void initializeIncomingTrain(int coachCount){
         for(int i = 1; i <= coachCount; i++){
                this.incomingTrain.add(new Integer(i));  
        }  
         
    }
    
    public void initializeOutgoingTrain(String inputLine){
        
            String coachAry[] = inputLine.split(" ");
         
            for(int i = 0; i < coachAry.length; i++){
            		this.outgoingTrain.add(new Integer (Integer.parseInt(coachAry[i])) );
            }  
         
    }    
    
    public   ArrayStack getInvertedStack(ArrayStack stk){
        //inverts stack using a new stack
        ArrayStack newStack = new ArrayStack(stk.size()); //should be stk.length or something
        
        for(int i = stk.size(); i > 0; i--){
            newStack.push(stk.pop()); 
        }     
        stk = newStack;
        
        return stk;
        
    }
    

    
}