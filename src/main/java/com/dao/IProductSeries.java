package com.dao;
import java.util.*;
import com.entity.*;
public interface IProductSeries {

    List<ProductSeries> selectLike(Integer s1);
}
