import java.util.Stack;

class Collisions {
    public static void main(String[] args){
        System.out.println(countCollisions("SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR"));
        //SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR
        //RRRRLL
        //SS
    }

    public static int countCollisions(String directions) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (char c: directions.toCharArray()){
            if (c == 'S'){
                while (!stack.empty() && stack.peek() == 'R'){
                    stack.pop();
                    count++;
                }
                stack.push(c);
            }else if (c == 'L'){
                if (!stack.empty() && stack.peek() == 'S'){
                    count++;
                    stack.push('S');
                }else if (!stack.empty() && stack.peek() == 'R'){
                    count++;
                    while (!stack.empty() && stack.peek() == 'R'){
                        stack.pop();
                        count++;
                    }
                    stack.push('S');
                }else{
                    stack.push('L');
                }
            }else{
                stack.push('R');
            }
        }
        return count;
    }
}