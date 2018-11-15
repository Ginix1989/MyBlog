package com.ginix.blog.controller;


import com.ginix.blog.domain.es.EsBlog;
import com.ginix.blog.repository.es.EsBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 博客控制器
 */
@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private EsBlogRepository esBlogRepository;
    @GetMapping
    public List<EsBlog> List(@RequestParam(value="title",defaultValue="s") String title,
                             @RequestParam(value="summary",defaultValue="s") String summary,
                             @RequestParam(value="content",defaultValue="s") String content,
                             @RequestParam(value="pageIndex",defaultValue = "0") int pageIndex,
                             @RequestParam(value="pageSize",defaultValue = "10") int pageSize)
    {
//         title = "a";
//         summary = "b";
//         content = "d";
        esBlogRepository.deleteAll();
        esBlogRepository.save(new EsBlog("1111", "2222", "33333"));
        esBlogRepository.save(new EsBlog("aaaa", "cccc", "ddd"));
        esBlogRepository.save(new EsBlog("vvv", "bbb", "nnn"));
        Pageable pageable = PageRequest.of(pageIndex ,pageSize);
        Page<EsBlog> page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content, pageable);

        for (EsBlog blog :page.getContent())
        {
            System.out.println(blog.toString());
        }
        System.out.println("-------------------end");


        return  page.getContent();
    }
}
