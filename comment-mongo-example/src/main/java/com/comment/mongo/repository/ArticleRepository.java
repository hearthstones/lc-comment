package com.comment.mongo.repository;

import com.comment.mongo.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * ArticleRepository
 *
 * @author luchao
 * @since 2022/7/8
 */
public interface ArticleRepository extends MongoRepository<Article, String> {

    /**
     * 根据文章ID查询文章
     *
     * @param articleId 文章ID
     * @return 文章
     */
    Article findArticleByArticleId(String articleId);

    /**
     * 根据文章ID删除文章
     *
     * @param articleId 文章ID
     */
    void deleteByArticleId(String articleId);

}
