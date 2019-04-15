package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SearchResult.Builder;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherDoubler implements SequenceSearcher {

    private int searchMethodCounter;
    private int[] seqParameter;

    public SequenceSearcherDoubler() {
        searchMethodCounter = 0;
    }

    @Override public SearchResult search(int key, int[] seq) {
        Builder builder = SearchResult.builder();
        setSeqParameter(seq);
        searchMethodCounter++;
        for(int i = 0; i < seq.length; i++) {
            if(key == seq[i]) {
                builder.withFound(true);
                builder.withPosition(i);
            }
        }
        return builder.build();
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
}
