package service;

import datastr.MyBST;

public class MainService {

    public static void main(String[] args) {
        MyBST<Integer> integerBST = new MyBST<>();

        try {
            integerBST.add(10);
            integerBST.add(5);
            integerBST.add(3);
            integerBST.add(21);
            integerBST.add(19);
            integerBST.add(9);
            integerBST.add(7);
            integerBST.add(11);


            integerBST.print();

            System.out.println(integerBST.search(25));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
