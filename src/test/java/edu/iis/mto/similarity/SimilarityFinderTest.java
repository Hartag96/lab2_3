package edu.iis.mto.similarity;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimilarityFinderTest {

    @Test public void calculateJackardSimilarityWhenSeqLengthEqualsZero() {
        SimilarityFinder similarityFinder = new SimilarityFinder();
        int[] seq1 = {};
        int[] seq2 = {};
        double result = 1.0;
        double delta = 0.1;

        Assert.assertEquals(result, similarityFinder.calculateJackardSimilarity(seq1, seq2), delta);
    }
}
