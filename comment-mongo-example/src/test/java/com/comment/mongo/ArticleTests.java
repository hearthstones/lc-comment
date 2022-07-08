package com.comment.mongo;

import com.comment.mongo.pojo.dto.ArticleDTO;
import com.comment.mongo.pojo.vo.ArticleDetailVO;
import com.comment.mongo.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * ArticleTests
 *
 * @author luchao
 * @since 2022/7/8
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class ArticleTests {

    @Resource
    private ArticleService articleService;

    @Test
    public void addTest() {
        ArticleDTO dto = new ArticleDTO();
        dto.setTitle("2022.7.8");
        dto.setContent("安倍晋三身亡");
        dto.setOrigin("今日头条");
        articleService.add(dto);
    }

    @Test
    public void getDetailTest() {
        ArticleDetailVO detail = articleService.getDetail("e0ff5b18-997d-4bc3-82b4-1212c9604384");
        log.info("文章详情: {}", detail);
    }

    @Test
    public void updateTest() {

    }

    @Test
    public void deleteTest() {

    }

    @Test
    public void likeTest() {
        articleService.like("user001", "e0ff5b18-997d-4bc3-82b4-1212c9604384", 1);
    }

    @Test
    public void unlikeTest() {

    }

    @Test
    public void collectTest() {

    }

    @Test
    public void unCollectTest() {

    }


}
