package com.comment.mongo.pojo.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * 文章DTO
 *
 * @author luchao
 * @since 2022/7/8
 */
@Data
public class ArticleDTO {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 文章ID
     */
    private String articleId;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 文章来源
     */
    private String origin;

}
