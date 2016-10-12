package autocomplete;

import java.util.Arrays;

public class Autocomplete {
	private final Term[] TERMS;
	
	public static void main(String[] args){
		Term t1 = new Term("hello world!", 500);
		Term t2 = new Term("hello Again World!", 456);
		Term t3 = new Term("haY WORLD!", 738);
		Term t4 = new Term("world!", 634);
		Term t5 = new Term("goodbye world!", 150);
		Term t6 = new Term("goodbye cruel world!", 540);
		Term t7 = new Term("the world alive", 630);
		Term t8 = new Term("the world dead", 19);
		Term t9 = new Term("hEY WORLD WOOOORLD!", 564);
		Term t10 = new Term("so happy together!", 53);
		Term t11 = new Term("hello loving nobody but you", 1870);
		Term t12 = new Term("for all my life", 732);
		Term[] terms = {t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12};
		Autocomplete autocomplete = new Autocomplete(terms);
    	return numOfMatches;
    }
}
