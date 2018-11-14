package com.ginix.blog;
import  static  org.assertj.core.api.Assertions.assertThat;
import com.ginix.blog.domain.es.EsBlog;
import com.ginix.blog.repository.es.EsBlogRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EsBlogRepositoryTest {

    @Autowired
    private EsBlogRepository esBlogRepository;

    @Before
    public void initRepositoryData() {
        esBlogRepository.deleteAll();
        esBlogRepository.save(new EsBlog("1111", "2222", "33333"));
        esBlogRepository.save(new EsBlog("aaaa", "cccc", "ddd"));
        esBlogRepository.save(new EsBlog("vvv", "bbb", "nnn"));
    }

    @Test
    public void
    findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining() {
        Pageable pageable = PageRequest.of(0, 20);
        String title = "a";
        String summary = "b";
        String content = "d";
        Page<EsBlog> page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content, pageable);
        assertThat(page.getTotalElements()).isEqualTo(2);
//        assertThat(page.getTotalElements(),equals());

        System.out.println("-------------------start");
        for (EsBlog blog :page.getContent())
        {
            System.out.println(blog.toString());
        }
        System.out.println("-------------------end");
    }
}
