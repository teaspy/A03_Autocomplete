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
		Term[] testTerms = autocomplete.allMatches("");
		for(Term t : testTerms) System.out.println(t);
	}

    // Initialize the data structure from the given array of terms.
    public Autocomplete(Term[] terms){
    	if(terms == null) throw new NullPointerException();
    	this.TERMS = terms;
    	Arrays.sort(this.TERMS);
    }

    // Return all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix){
    	if(prefix == null) throw new NullPointerException();
    	Term[] returnedTerms = new Term[numberOfMatches(prefix)];
    	Term comparedTerm = new Term(prefix, 0);
    	int termIndex = BinarySearchDeluxe.firstIndexOf(TERMS, comparedTerm, Term.byPrefixOrder(prefix.length()));
    	
    	for(int i = 0; i < returnedTerms.length; i++){
    		returnedTerms[i] = TERMS[termIndex + i];
    	}
    	Arrays.sort(returnedTerms, Term.byReverseWeightOrder());
    	return returnedTerms;
    }

    // Return the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix){
    	if(prefix == null) throw new NullPointerException();
    	Arrays.sort(TERMS, Term.byPrefixOrder(prefix.length()));
    	//The temporary term for searching purposes.
    	Term comparedTerm = new Term(prefix, 0);
    	int lastIndex = BinarySearchDeluxe.lastIndexOf(TERMS, comparedTerm, Term.byPrefixOrder(prefix.length()));
    	int firstIndex = BinarySearchDeluxe.firstIndexOf(TERMS, comparedTerm, Term.byPrefixOrder(prefix.length()));
    	int numOfMatches = (lastIndex - firstIndex) + 1;
    	//Account for it not existing
    	if(lastIndex == -1 || firstIndex == -1) numOfMatches = 0;
    	return numOfMatches;
    }
}
