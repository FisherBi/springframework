package com.fisher.repository.spittle;

import com.fisher.model.Spittle;

import java.util.List;

/**
 * Created by fisbii on 16-12-7.
 */
public interface SpittleCompicatedOperation {
    List<Spittle> findSpittles(long max,int firstPage, int count);
}
