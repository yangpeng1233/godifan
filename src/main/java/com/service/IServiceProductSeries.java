package com.service;

import com.entity.*;
import java.util.*;

public interface IServiceProductSeries {
    List<ProductSeries> selectLike(Integer s1);
}
