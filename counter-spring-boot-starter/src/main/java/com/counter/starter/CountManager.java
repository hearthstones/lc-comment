package com.counter.starter;

import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 统计模板类
 *
 * @author luchao
 * @date 2022/2/15
 */
public abstract class CountManager {

    @Resource
    private RedisTemplate<String, Integer> redisTemplate;

    /**
     * 构造key
     * <p>
     *   示例：key = "info:id:" + bizId + ":statistics"
     * </p>
     *
     * @param bizId 业务ID
     * @return key
     */
    protected abstract String getKey(String bizId);

    /**
     * 初始化redis数据
     *
     * @param bizId 业务ID
     */
    protected abstract void initData(String bizId);


    /**
     * 预检查 + 初始化
     *
     * @param bizId 业务ID
     */
    protected void before(String bizId) {
        String key = getKey(bizId);
        // 预检查
        if (Boolean.TRUE.equals(redisTemplate.hasKey(key))) {
            return;
        }
        // 初始化数据
        initData(bizId);
    }

    /**
     * 计数
     *
     * @param bizId 业务ID
     * @param type 操作类型
     * @param size 步长
     */
    public void count(String bizId, OperateTypeEnum type, long size) {
        before(bizId);
        redisTemplate.opsForHash().increment(getKey(bizId), type.getDesc(), size);
    }

    /**
     * 获取指定类型的数据统计
     *
     * @param bizId 业务ID
     * @param type 操作类型
     * @return 统计数据
     */
    public Integer get(String bizId, OperateTypeEnum type) {
        before(bizId);
        return (Integer) redisTemplate.opsForHash().get(getKey(bizId), type.getDesc());
    }

    /**
     * 获取所有数据统计（点赞数、评论数、收藏数、转发数...）
     *
     * @param bizId 资讯ID
     * @return 数据统计
     */
    public Map<String, Integer> getAll(String bizId) {
        before(bizId);
        Map<String, Integer> map = new HashMap<>();
        redisTemplate.opsForHash().entries(getKey(bizId)).forEach((k, v) -> map.put((String) k, (Integer) v));
        return map;
    }

    /**
     * 删除
     *
     * @param bizId 业务ID
     */
    public void remove(String bizId) {
        redisTemplate.delete(getKey(bizId));
    }

}
