package com.springboot.repository;

import com.springboot.bean.EsBean;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface EsRepository  extends ElasticsearchRepository<EsBean,Integer> {

    //参照
    // https://docs.spring.io/spring-data/elasticsearch/docs/3.0.6.RELEASE/reference/html/
    public List<EsBean> findByBookNameLike(String bookName);

}
