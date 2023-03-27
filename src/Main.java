public class Main {
    public static void main(String[] args) throws SimleList.SimpleLinkedListException {

        JavaList list = new JavaList();

        if (args.length == 0) {
            System.out.println("file: ");
            int[] numbers = Utils.readNumbersFromFile(Utils.scanString());
            for (int number : numbers) {
                list.addElement(number);
            }
            list.sortList();
            for (int i = 0; i < list.getSize(); i++) {
                System.out.println(list.getElement(i));
            }
        } else {
            int[] numbers = Utils.readNumbersFromFile(args[1]);
            for (int number : numbers) {
                list.addElement(number);
            }
            list.sortList();
            for (int i = 0; i < list.getSize(); i++) {
                System.out.println(list.getElement(i));
            }
        }

        SimleList simpleList = new SimleList();

        if (args.length == 0) {
            System.out.println("file: ");
            int[] numbers = Utils.readNumbersFromFile(Utils.scanString());
            for (int number : numbers) {
                simpleList.addLast(number);
            }
            simpleList.sortSimpleList();
            for (int i = 0; i < simpleList.size(); i++) {
                System.out.println(simpleList.getNode(i));
            }
        } else {
            int[] numbers = Utils.readNumbersFromFile(args[1]);
            for (int number : numbers) {
                simpleList.addLast(number);
            }
            simpleList.sortSimpleList();
            for (int i = 0; i < simpleList.size(); i++) {
                System.out.println(simpleList.getNode(i));
            }
        }
    }
}