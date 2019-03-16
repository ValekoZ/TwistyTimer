package com.aricneto.twistytimer.items;

import com.google.common.collect.Multiset;
import com.google.common.collect.SortedMultiset;
import com.google.common.collect.TreeMultiset;

import static com.aricneto.twistytimer.stats.AverageCalculator.DNF;
import static com.aricneto.twistytimer.stats.AverageCalculator.UNKNOWN;

/**
 * Stores a sum, best and worst times
 */
public class AverageComponent {
    public long sum;
    public long best;
    public long worst;
    public SortedMultiset<Long> tree;

    public AverageComponent() {
    }

    public AverageComponent(long sum, long best, long worst, SortedMultiset<Long> tree) {
        this.sum = sum;
        this.best = best;
        this.worst = worst;
        this.tree = tree;
    }

    public void add(long val) {
        if (val != DNF)
            sum = (this.sum == UNKNOWN ? 0L : this.sum) + val;
    }

    public void sub(long val) {
        // If the lower trim is filled with DNFs, its value may be 0
        // so do not allow any subtraction then
        if (val != DNF && sum != 0)
            sum = (this.sum == UNKNOWN ? 0L : this.sum) - val;
    }
}