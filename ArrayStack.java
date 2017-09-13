
public class ArrayStack implements IStack {
    
    private int top;
    private double[] stk; 
    
    public ArrayStack(int size){
        this.top = -1;
        this.stk = new double[size];
    }
    
    
   
   
    public void push(double value){
        if(isFull()){
            return;
        }else{ 
            top++;
            stk[top] = value;
        }
    }
    
    public double pop(){
        if(isEmpty()){
            return 0.0;
        }else{
            double toPop = stk[top];
            top--;
            return toPop;
        }
    }
    
    public double peek(){
        if(isEmpty()){
            return 0.0;
        }else{
            return stk[top];
        }
    }
    
    public int size(){
        return top + 1;
    }
    
    public boolean isEmpty(){
        if(top < 0){
            return true;
        }
        return false;
    }
    
    public boolean isFull(){
        if(top >= (stk.length - 1)){
            return true;
        }
        return false;
    }
    
    public void clear(){
        top = -1;
    }
    
    public void dump(){
        String line = "";
        for(int i = -1; i < stk.length + 1; i++){
            line = i + " : " ;
            
            if(i >= 0 && i < stk.length){
                line = line + stk[i];
            }
            if(i == top){
                line = line + "    <--TOP";
            }
            
            System.out.println(line);
        }
        System.out.println("________________\n________________\n\n\n");
    }
}

