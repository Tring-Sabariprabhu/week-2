import java.util.Stack;
class LearnStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("Hi");
        stack.push("Good Morning!");
        stack.push("Have a nice day!");
        stack.pop();
        System.out.println("Top Element : " + stack.peek());
        System.out.println("Position : " + stack.search("Good Morning!"));
        System.out.println(stack);
        System.out.println("Size of the Stack : " + stack.size());
    }
}