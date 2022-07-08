package com.comment.mongo.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

/**
 * 文章
 *
 * @author luchao
 * @since 2022/7/8
 */
@Data
@Accessors(chain = true)
@Document(collection = Article.COLLECTION_NAME)
public class Article {

    public static final String COLLECTION_NAME = "article";

    /**
     * 主键ID
     */
    @Id
    private String id;

    /**
     * 文章ID
     */
    @Field
    private String articleId;

    /**
     * 文章标题
     */
    @Field
    private String title;

    /**
     * 文章内容
     */
    @Field
    private String content;

    /**
     * 文章来源
     */
    @Field
    private String origin;

    /**
     * 评论数
     */
    @Field
    private Integer commentNum;

    /**
     * 点赞数
     */
    @Field
    private Integer likeNum;

    /**
     * 收藏数
     */
    @Field
    private Integer collectNum;

    /**
     * 转发数
     */
    @Field
    private Integer forwardNum;

    /**
     * 点赞列表
     */
    @Field
    private Set<String> likeSet;

    /**
     * 收藏列表
     */
    @Field
    private Set<String> collectSet;

    /**
     * 创建时间
     */
    @Field
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    @Field
    private LocalDateTime gmtModified;

}
