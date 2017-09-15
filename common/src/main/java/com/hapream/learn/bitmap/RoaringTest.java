package com.hapream.learn.bitmap;


import junit.framework.TestCase;
import org.roaringbitmap.RoaringBitmap;

/**
 * Created by zhangyanggang on 2017/9/13.
 */
public class RoaringTest extends TestCase {

    public void testRoaringBitMap() {
        RoaringBitmap rr = RoaringBitmap.bitmapOf(1, 2, 3, 1000);
        RoaringBitmap rr2 = new RoaringBitmap();
        rr2.add(4000L, 4255L);

        RoaringBitmap rror = RoaringBitmap.or(rr, rr2);// new bitmap
        rr.or(rr2); //in-place computation
        boolean equals = rror.equals(rr);// true
        if (!equals) throw new RuntimeException("bug");
        // number of values stored?
        long cardinality = rr.getLongCardinality();
        System.out.println(cardinality);
        // a "forEach" is faster than this loop, but a loop is possible:
//        for(int i : rr) {
//            System.out.println(i);
//        }
    }

    public void testRoarinfBitOr() {
        RoaringBitmap r1 = RoaringBitmap.bitmapOf(1, 23, 45, 67);
//        System.out.println(r1);
        RoaringBitmap r2 = RoaringBitmap.bitmapOf(1, 23, 44, 66);

        RoaringBitmap resultOr = RoaringBitmap.or(r1, r2);
        System.out.println(resultOr);

        RoaringBitmap resultAnd =  RoaringBitmap.and(r1, r2);
        System.out.println(resultAnd);


    }

}
