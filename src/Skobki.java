import java.util.Stack;

public class Skobki {
    public static Integer ns(char q) {
        switch (q + "") {
            case "(":
                return 0;
            case ")":
                return 1;
            case "{":
                return 4;
            case "}":
                return 5;
            case "[":
                return 8;
            case "]":
                return 9;
            case "<":
                return 12;
            case ">":
                return 13;
        }
        return null;
    }

    public static boolean have(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (ns(s.charAt(i)) - ns(s.charAt(i + 1)) == -1) {
                return true;
            }
        }
        return false;
    }

    public static int find(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (ns(s.charAt(i)) - ns(s.charAt(i + 1)) == -1) {
                return i;
            }
        }
        return 0;
    }

    public static String zam(String s, int q) {
        String s1 = "";
        for (int i = 0; i < s.length(); i += 1) {
            if (i == q || i == q + 1) {
                continue;
            }
            s1 += s.charAt(i);
        }
        return s1;
    }

    public static boolean myMethod(String s) {
        //s = new String(s);
        while (have(s)) {
            s = zam(s, find(s));
        }
        return s.equals("");
    }

    public static boolean stack(String s) {
        Stack<Integer> st = new Stack<>();
        for (char c : s.toCharArray()) {
            Integer a = ns(c);
            if (a == null) continue;
            if (a % 2 == 0) {
                st.push(a);
            } else {
                if (st.empty()) return false;
                if (st.pop() - a != -1) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
    public static boolean myStack(String s){
        MyStack1 st = new MyStack1();
        for (char c : s.toCharArray()) {
            Integer a = ns(c);
            if (a == null) continue;
            if (a % 2 == 0) {
                st.push(a);
            } else {
                try{
                    if (st.pop() - a != -1) {
                        return false;
                    }
                } catch (Exception e){
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String s = "({()({}<>)([])}([{(){[]}}]())";
        System.out.println(myMethod(s));
        System.out.println(stack(s));
        System.out.println(myStack(s));
        System.out.println(s);
        System.out.println(( (long) Integer.MAX_VALUE*4)/1024/1024/1024);
    }
}

class MyStack1 {
    int[] st = new int[1000];
    int size = 0;

    boolean isEmpty() {
        return size == 0;
    }

    int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        size--;
        return st[size];
    }

    void push(int a) {
        st[size] = a;
        size++;
    }
}