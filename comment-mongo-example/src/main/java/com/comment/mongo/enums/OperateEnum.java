package com.comment.mongo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 操作枚举类
 *
 * @author luchao
 * @date 2022/7/8
 */
@Getter
@ToString
@AllArgsConstructor
public enum OperateEnum {

    /**
     * 正向操作：点赞、收藏
     */
    ASC(1),

    /**
     * 反向操作：取消点赞、取消收藏
     */
    DESC(0);

    private final Integer code;

}
