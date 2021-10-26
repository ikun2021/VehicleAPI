package com.udacity.pricing;

import com.udacity.pricing.Price;
import org.springframework.data.repository.CrudRepository;

public interface PriceRepository extends CrudRepository<Price, Long>{

}
