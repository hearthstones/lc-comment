package com.comment.mongo.controller;

import com.comment.mongo.pojo.dto.ArticleDTO;
import com.comment.mongo.service.ArticleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 文章Controller
 *
 * @author luchao
 * @since 2022/7/8
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @PostMapping("/add")
    public void add(@RequestBody ArticleDTO dto) {
        articleService.add(dto);
    }

}
