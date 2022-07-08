package com.comment.mongo.service;

import com.comment.mongo.pojo.dto.ArticleDTO;
import com.comment.mongo.pojo.vo.ArticleDetailVO;

/**
 * ArticleService
 *
 * @author luchao
 * @since 2022/7/8
 */
public interface ArticleService {

    /**
     * 分页查询文章列表
     *
     * @param pg 分页对象
     * @return 分页列表
     */
//    PageVO<ArticleListVO> page(PageInfo pg);

    /**
     * 文章详情
     *
     * @param articleId 文章ID
     * @return 文章详情
     */
    ArticleDetailVO getDetail(String articleId);

    /**
     * 添加
     *
     * @param dto 文章DTO
     */
    void add(ArticleDTO dto);

    /**
     * 编辑
     *
     * @param dto 文章DTO
     */
    void update(ArticleDTO dto);

    /**
     * 删除
     *
     * @param articleId 文章ID
     */
    void delete(String articleId);

    /**
     * 点赞
     *
     * @param userId 用户ID
     * @param articleId 文章ID
     * @param operate   操作：0-取消点赞；1-点赞。
     */
    void like(String userId, String articleId, Integer operate);

    /**
     * 收藏
     *
     * @param userId 用户ID
     * @param articleId 文章ID
     * @param operate   操作：0-取消收藏；1-收藏。
     */
    void collect(String userId, String articleId, Integer operate);

}
