package com.soft2242.shop.mapper;

import com.soft2242.shop.entity.UserShoppingCart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft2242.shop.vo.CartGoodsVO;
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
public interface UserShoppingCartMapper extends BaseMapper<UserShoppingCart> {
    List<CartGoodsVO> getCartGoodsInfo(@Param("id") Integer id);

}
