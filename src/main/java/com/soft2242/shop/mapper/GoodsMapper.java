package com.soft2242.shop.mapper;

import com.soft2242.shop.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft2242.shop.vo.UserOrderGoodsVO;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ycshang
 * @since 2023-11-10
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
  List<UserOrderGoodsVO> getGoodsListByOrderId(@Param("id") Integer id);
}
