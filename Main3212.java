public class Main{
    
    
    public static void main(String[] args){
        Container<person> personContainer = new Container<>(initialCapacity:2);
        personContainer.add(new person(name: "Bob", age:19));
        personContainer.add(new person(name: "Jim", age: 79));
        System.out.println("First element: "+ personContainer.get(index:0));

        Queue<Integer> integerQueue = new LinkedList<>();
        integerQueue.add(e:8);
        integerQueue.add(e:2);
        integerQueue.add(e:4);
        integerQueue.add(e:1);
        integerQueue.add(e:9);
        System.out.println("Head value using peek function:" + integerQueue.peek());
        System.out.println("The queue elements:");
        for (int i : integerQueue){
            System.out.println(i);
        }

        PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<>();
        integerPriorityQueue.add(e:8);
        integerPriorityQueue.add(e:2);
        integerPriorityQueue.add(e:4);
        integerPriorityQueue.add(e:1);
        integerPriorityQueue.add(e:9);
        System.out.println("Head value using peek function:" + integerQueue.peek());
        System.out.println("The queue elements:");
        for (int i : integerQueue){
            System.out.println(i);
        }
    }

}