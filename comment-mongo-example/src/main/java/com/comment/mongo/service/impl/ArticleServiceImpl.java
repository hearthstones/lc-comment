package com.comment.mongo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import com.comment.mongo.enums.OperateEnum;
import com.comment.mongo.model.Article;
import com.comment.mongo.pojo.dto.ArticleDTO;
import com.comment.mongo.pojo.vo.ArticleDetailVO;
import com.comment.mongo.repository.ArticleRepository;
import com.comment.mongo.service.ArticleService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ArticleServiceImpl
 *
 * @author luchao
 * @since 2022/7/8
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleRepository articleRepository;
    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public ArticleDetailVO getDetail(String articleId) {
        Article article = articleRepository.findArticleByArticleId(articleId);
        // todo: 评论
        return BeanUtil.copyProperties(article, ArticleDetailVO.class);
    }

    @Override
    public void add(ArticleDTO dto) {
        Article article = BeanUtil.copyProperties(dto, Article.class);
        article.setArticleId(IdUtil.fastUUID());
        articleRepository.save(article);
    }

    @Override
    public void update(ArticleDTO dto) {
        Article article = BeanUtil.copyProperties(dto, Article.class);
        articleRepository.save(article);
    }

    @Override
    public void delete(String articleId) {
        articleRepository.deleteByArticleId(articleId);
        // todo: 删除评论

    }

    @Override
    public void like(String userId, String articleId, Integer operate) {
        Query query = Query.query(Criteria.where("articleId").is(articleId));
        Update update = new Update();
        if (OperateEnum.ASC.getCode().equals(operate)) {
            // 点赞：点赞数+1、点赞列表
            update.inc("likeNum", 1);
            update.push("likeSet", userId);
        } else {
            // 取消点赞：点赞数-1、点赞列表
            update.inc("likeNum", -1);
            update.pull("likeSet", userId);
        }
        // update
        mongoTemplate.updateFirst(query, update, Article.COLLECTION_NAME);
    }

    @Override
    public void collect(String userId, String articleId, Integer operate) {
        Query query = Query.query(Criteria.where("articleId").is(articleId));
        Update update = new Update();
        if (OperateEnum.ASC.getCode().equals(operate)) {
            // 收藏：收藏数+1、收藏列表
            update.inc("collectNum", 1);
            update.push("collectSet", userId);
        } else {
            // 取消收藏：收藏数-1、收藏列表
            update.inc("collectNum", -1);
            update.pull("collectSet", userId);
        }
        // update
        mongoTemplate.updateFirst(query, update, Article.COLLECTION_NAME);
    }

}
