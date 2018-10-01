package acheng1314.cn.controller;



class ListNode{
    int value;
    ListNode next;

     ListNode(int i, Object o) {
        int value;
        ListNode next;
    }
}
public class AddList {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1,null);
        ListNode list2 = new ListNode(2,null);
        for (int i = 3; i < 5; i++) {
            list1.next= new ListNode(i,null);
        }
        for (int i = 4; i < 5; i++) {
            list2.next = new ListNode(i,null);

        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if(list1.value <=list2.value){
            list1.next = Merge(list1.next,list2);
            return  list1;
        }else {
            list2.next =Merge(list1,list2.next);
            return  list2;
        }
    }
}
