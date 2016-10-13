package autocomplete;

import java.util.Arrays;
import java.util.Comparator;

public class Term implements Comparable<Term>{
	private final String QUERY;
	private final double WEIGHT;
	
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
    	this.QUERY = query;
    	this.WEIGHT = weight;
    }

    // Compare the terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder(){
    	
    	class ByReverseWeightOrder implements Comparator<Term>{
    		@Override
    		public int compare(Term o1, Term o2) {
    			return (int)(o2.WEIGHT - o1.WEIGHT);
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
				int substringIndex = r;
				//This was to prevent the length from being too long
				if(r >= o1.QUERY.length() || r >= o2.QUERY.length()){
					if (o1.QUERY.length() > o2.QUERY.length()){
						substringIndex = o2.QUERY.length();
					} else {
						substringIndex = o1.QUERY.length();
					}
				}
				String comparedString1 = o1.QUERY.substring(0, substringIndex);
				String comparedString2 = o2.QUERY.substring(0, substringIndex);
				return comparedString1.compareTo(comparedString2);
			}  
    	}
    	
    	return new ByPrefixOrder();
    }
    
	// Compare the terms in lexicographic order by query.
	@Override
	public int compareTo(Term that) {
		return (QUERY.compareTo(that.QUERY));
	}

    // Return a string representation of the term in the following format:
    // the weight, followed by a tab, followed by the query.
	@Override
    public String toString(){
		return WEIGHT + "\t" + QUERY;   	
    }
}
