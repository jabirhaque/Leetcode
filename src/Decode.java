import java.util.Stack;

class Decode {
    public static void main(String[] args){
        String result = decodeAtIndex("vk6u5xhq9v", 554);
        System.out.println(result);
    }

    public static String decodeAtIndex(String s, int k) {
        String str = "";
        char[] charArray = s.toCharArray();
        int i=0;
        while (i<charArray.length){
            if (charArray[i]-'0'>=0 && charArray[i]-'0'<10){
                long product = charArray[i]-'0';
                int j=i+1;
                while (j<charArray.length && charArray[j]-'0'>=0 && charArray[j]-'0'<10){
                    product*=charArray[j]-'0';
                    j++;
                }
                str+=String.valueOf(product);
                i=j;
            }else{
                str += charArray[i];
                i++;
            }
        }
        String[] strings = str.split("\\d+");
        String[] numbers = str.split("\\D+");
        Stack<Long> operators = new Stack<>();
        operators.push((long)strings[0].length());
        int index = 1;
        for (String n: numbers){
            if (n.equals("")){
                continue;
            }
            operators.push(Long.valueOf(n)*operators.peek());
            if (index<strings.length){
                operators.push(strings[index].length()+operators.peek());
                index++;
            }
        }
        Stack<String> stringStack = new Stack<>();
        for (String string: strings){
            stringStack.push(string);
        }
        if (s.charAt(s.length()-1) - '0'>=0 && s.charAt(s.length()-1) - '0'<10){
            operators.pop();
        }
        long n = k-1;
        while (!operators.empty()){
            n = n%operators.pop();
            if (operators.empty() || n>=operators.peek()){
                return String.valueOf(stringStack.pop().charAt(operators.empty()?(int)n:(int)(n-operators.pop())));
            }
            operators.pop();
            stringStack.pop();
        }
        return String.valueOf(stringStack.pop().charAt((int)n));
    }
}