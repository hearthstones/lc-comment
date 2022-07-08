package com.comment.mongo.pojo.vo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * 文章详情VO
 *
 * @author luchao
 * @since 2022/7/8
 */
@Data
public class ArticleDetailVO {

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

    /**
     * 评论数
     */
    private Integer commentNum;

    /**
     * 点赞数
     */
    private Integer likeNum;

    /**
     * 收藏数
     */
    private Integer collectNum;

    /**
     * 转发数
     */
    private Integer forwardNum;

    /**
     * 点赞列表
     */
    private Set<String> likeSet;

    /**
     * 收藏列表
     */
    private Set<String> collectSet;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModified;

}
