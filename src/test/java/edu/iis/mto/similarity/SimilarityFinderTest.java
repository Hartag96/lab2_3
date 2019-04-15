package edu.iis.mto.similarity;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimilarityFinderTest {

    SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherDoubler());

    @Test public void calculateJackardSimilarityWhenSeqLengthEqualsZero() {
        int[] seq1 = {};
        int[] seq2 = {};

        Assert.assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.equalTo(1.0));

    }

    @Test public void calculateJackardSimilarityWhenSeqAreEquals() {
        int[] seq1 = {1, 2, 3};
        int[] seq2 = {1, 2, 3};

        Assert.assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.equalTo(1.0));
    }

    @Test public void calculateJackardSimilarityWhenOneSeqIsEmpty() {
        int[] seq1 = {};
        int[] seq2 = {1, 2, 3};

        Assert.assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.equalTo(0.0));
    }
}
