package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SearchResult.Builder;
import edu.iis.mto.search.SequenceSearcher;
import java.util.ArrayList;

public class SequenceSearcherDoubler implements SequenceSearcher {

    private int searchMethodCounter;
    private int[] seqParameter;
    private ArrayList<Boolean> foundKeysSequence;

    public SequenceSearcherDoubler() {
        searchMethodCounter = 0;
        seqParameter = null;
        foundKeysSequence = new ArrayList<>();
    }

    @Override public SearchResult search(int key, int[] seq) {
        Builder builder = SearchResult.builder();
        setSeqParameter(seq);
        searchMethodCounter++;
        for(int i = 0; i < seq.length; i++) {
            if(key == seq[i]) {
                pushFoundKeysSequence(true);
                return builder.withFound(true).build();
            }
        }
        pushFoundKeysSequence(false);
        return builder.withFound(false).build();
    }

    public int getSearchMethodCounter() {
        return searchMethodCounter;
    }

    public int[] getSeqParameter() {
        return seqParameter;
    }

    public void setSeqParameter(int[] seqParameter) {
        this.seqParameter = seqParameter;
    }

    public ArrayList<Boolean> getFoundKeysSequence() {
        return foundKeysSequence;
    }

    public void pushFoundKeysSequence(Boolean value) {
        this.foundKeysSequence.add(value);
    }
}
