import java.util.LinkedList;
import java.util.List;

public class JavaList {
    private LinkedList<Integer> list;

    public JavaList(List<Integer> meh){
        this.list = new LinkedList<>(meh);
    }
    public JavaList(){
        this.list = new LinkedList<>();
    }

    public void addFirstElement(int element){
        list.addFirst(element);
    }

    public void addLastElement(int element){
        list.addLast(element);
    }

    public void addElement(int element, int index){
        list.add(index, element);
    }

    public void addElement(int element){
        list.add(element);
    }

    public int getElement(int i){
        return list.get(i);
    }

    public void sortList(){
        int nul = 0;
        int otr = 0;

        LinkedList<Integer> newList = new LinkedList<>();

        for (Integer integer : list) {
            if (integer < 0) {
                newList.add(otr, integer);
                nul += 1;
                otr += 1;
            } else if (integer == 0) {
                newList.add(nul, integer);
                nul += 1;
            } else {
                newList.addLast(integer);
            }
        }
        list = newList;
    }

    public void sortList2(){
        int nul = 0;
        int otr = 0;

    }

    public int getSize(){
        return list.size();
    }

}