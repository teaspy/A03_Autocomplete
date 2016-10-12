package autocomplete;

import java.util.Arrays;
import java.util.Comparator;

public class Term implements Comparable<Term>{
	private String query;
	private double weight;
	
	public static void main(String[] args) {
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
		Arrays.sort(terms, Term.byReverseWeightOrder());
		for(Term t : terms){
			System.out.println(t);
		}

	}
    // Initialize a term with the given query string and weight.
    public Term(String query, double weight){
    	if(query == null) throw new NullPointerException();
    	if(weight < 0) throw new IllegalArgumentException();
    	this.query = query;
    	this.weight = weight;
    }

    // Compare the terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder(){
    	
    	class ByReverseWeightOrder implements Comparator<Term>{
    		@Override
    		public int compare(Term o1, Term o2) {
    			return (int)(o2.weight - o1.weight);
    		}
    	}
    	
    	return new ByReverseWeightOrder();
    }

    // Compare the terms in lexicographic order but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r){
    	if(r < 0) throw new IllegalArgumentException();
    	
    	class ByPrefixOrder implements Comparator<Term>{
			@Override
			public int compare(Term o1, Term o2) {
				String comparedString1 = o1.query.substring(0, r);
				String comparedString2 = o2.query.substring(0, r);
				return comparedString1.compareTo(comparedString2);
			}  
    	}
    	
    	return new ByPrefixOrder();
    }
    
	// Compare the terms in lexicographic order by query.
	@Override
	public int compareTo(Term that) {
		return (query.compareTo(that.query));
	}

    // Return a string representation of the term in the following format:
    // the weight, followed by a tab, followed by the query.
	@Override
    public String toString(){
		return weight + "\t" + query;   	
    }
}
