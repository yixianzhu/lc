class MinStack {
    int min=Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    
    //how to push is really tricky, and also the heart of the solution
    //每个阶段的min都会存两次，一次是在第一次出现的时候，第二次是有新的min时候先存个旧min，然后再存新min
    //所以不断pop掉的时候，如果新min被pop了，就要把min值换成旧min，并把新min前面的那个旧min也pop掉
    public void push(int x) {
       // only push the old minimum value when the current 
       // minimum value changes after pushing the new value x
        if(x <= min){          
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
       // if pop operation could result in the changing of the current minimum value, 
       // pop twice and change the current minimum value to the last minimum value.
        int value = stack.pop();
        if(value == min){
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
