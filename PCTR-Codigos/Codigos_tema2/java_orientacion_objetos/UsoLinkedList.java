/**
 * @(#)UsoLinkedList.java
 *
 *
 * @author AT
 * @version 1.00 2011/10/25
 */

import java.util.*;

public class UsoLinkedList {

	static class Tontuna
	{
		int x = 3;
		Tontuna(){}
	}

    public static void main(String[] args)
    {
        LinkedList l = new LinkedList();
        int p = 3;
        l.add(p);
        l.add("Hola mundo...");
        LinkedList ll = new LinkedList();
        l.add(new Tontuna());
        l.add(new Thread());
        System.out.println(l.size());
        System.out.println(l.toString());
        //y ahora como es debido...
        LinkedList<Integer> lll = new LinkedList<Integer>();
        //esto funcionara...
        lll.add(3);
        //pero esto no...
        lll.add("hola");

    }
}
