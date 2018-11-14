package com.ginix.blog.repository.es;

import com.ginix.blog.domain.es.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsBlogRepository extends ElasticsearchRepository<EsBlog,String> {
//  Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining()

    /**
     *  分页查询
     * @param title
     * @param summary
     * @param content
     * @param pageable
     * @return
     */
    Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(String title, String  summary, String content, Pageable pageable);
}
