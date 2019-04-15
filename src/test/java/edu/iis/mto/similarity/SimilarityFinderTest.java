package edu.iis.mto.similarity;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.sound.midi.Sequence;

import static org.junit.Assert.*;

public class SimilarityFinderTest {

    private SimilarityFinder similarityFinder;
    private SequenceSearcherDoubler sequenceSearcherDoubler;

    @Before public void initialize(){
        sequenceSearcherDoubler = new SequenceSearcherDoubler();
        similarityFinder = new SimilarityFinder(sequenceSearcherDoubler);
    }

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


    @Test(expected = NullPointerException.class)
    public void calculateJackardSimilarityWhenOneSeqIsNull() {
        int[] seq1 = null;
        int[] seq2 = {1, 2, 3};

        similarityFinder.calculateJackardSimilarity(seq1, seq2);
    }

    @Test public void calculateJackardSimilarityWhenTwoSeqGiven() {
        int[] seq1 = {1, 2, 3};
        int[] seq2 = {1, 2, 4};

        Assert.assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.equalTo(0.5));
    }

    @Test public void sequenceSearcherDoublerValidCompareCounter() {
        int[] seq1 = {1, 2, 3};
        int[] seq2 = {1, 2, 4};

        similarityFinder.calculateJackardSimilarity(seq1, seq2);
        Assert.assertThat(sequenceSearcherDoubler.getSearchMethodCounter(), Matchers.equalTo(3));
    }

    @Test public void sequenceSearcherDoublerValidSeqParameter() {
        int[] seq1 = {1, 2, 3};
        int[] seq2 = {1, 2, 4};

        similarityFinder.calculateJackardSimilarity(seq1, seq2);
        Assert.assertThat(sequenceSearcherDoubler.getSeqParameter(), Matchers.equalTo(seq2));
    }
}
