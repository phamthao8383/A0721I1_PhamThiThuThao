package ss11_stack_queue.bai_tap.dao_nguoc_phan_tu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ReverseStack {
    public static ArrayList<Integer> reverseArray(ArrayList<Integer> inputArray) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer integer : inputArray) {
            stack.push(integer);
        }
        while(!stack.empty()) {
            result.add(stack.pop());
        }
        return result;
    }
    public static StringBuilder reverseString(String inputString) {
        StringBuilder result = new StringBuilder();
        Stack<String> wStack = new Stack<>();
        ArrayList<String> listOfWords = new ArrayList<>(Arrays.asList(inputString.split(" ")));
        for (String listOfWord : listOfWords) {
            wStack.push(listOfWord + " ");
        }
        while(!wStack.empty()) {
            result.append(wStack.pop());
        }
        return result;
    }
    public static void main(String[] args) {
        ArrayList<Integer> inputArray = new ArrayList<>(5);
        for (int i = 1; i <= 5; i++) {
            inputArray.add(i);
        }
        System.out.println(inputArray);
        System.out.println(reverseArray(inputArray));

        String reverseString = "string reversed a is this";
        System.out.println(reverseString(reverseString));
    }
}
