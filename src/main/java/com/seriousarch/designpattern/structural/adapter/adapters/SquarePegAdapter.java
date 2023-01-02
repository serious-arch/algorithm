package com.seriousarch.designpattern.structural.adapter.adapters;

import com.seriousarch.designpattern.structural.adapter.round.RoundPeg;
import com.seriousarch.designpattern.structural.adapter.square.SquarePeg;

/**
 * 方钉到圆孔的适配器
 */
public class SquarePegAdapter extends RoundPeg {
    private SquarePeg peg;

    public SquarePeg getPeg() {
        return peg;
    }

    public SquarePegAdapter(SquarePeg peg) {
        this.peg = peg;
    }

    public double getRadius() {
        return (Math.sqrt(Math.pow((peg.getWidth() / 2), 2) * 2));
    }
}
