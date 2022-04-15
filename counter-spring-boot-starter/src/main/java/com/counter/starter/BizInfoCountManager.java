package com.counter.starter;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * InfoCountManager
 *
 * @author luchao
 * @date 2022/2/15
 */
@Component
public class BizInfoCountManager extends CountManager {

    @Resource
    private RedisTemplate<String, Integer> redisTemplate;
    @Resource
    private BizInfoMapper bizInfoMapper;

    @Override
    protected String getKey(String infoId) {
        return "biz.info:info:" + infoId + ":count";
    }

    @Override
    protected void initData(String infoId) {
        int likeNum = 0;
        int commentNum = 0;
        int collectNum = 0;
        int forwardNum = 0;
        // 考虑redis丢失数据的情况，优先使用mysql数据
        BizInfo bizInfo = bizInfoMapper.selectOne(new LambdaQueryWrapper<BizInfo>().eq(BizInfo::getInfoId, infoId));
        if (ObjectUtils.isNotEmpty(bizInfo)) {
            likeNum = bizInfo.getLikeNum();
            commentNum = bizInfo.getCommentNum();
            collectNum = bizInfo.getCollectNum();
            forwardNum = bizInfo.getForwardNum();
        }
        Map<String, Integer> map = new HashMap<>(4);
        map.put(OperateTypeEnum.LIKE.getDesc(), likeNum);
        map.put(OperateTypeEnum.COMMENT.getDesc(), commentNum);
        map.put(OperateTypeEnum.COLLECT.getDesc(), collectNum);
        map.put(OperateTypeEnum.FORWARD.getDesc(), forwardNum);
        redisTemplate.opsForHash().putAll(getKey(infoId), map);
    }

}
