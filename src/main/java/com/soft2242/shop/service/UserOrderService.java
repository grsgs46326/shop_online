package com.soft2242.shop.service;

import com.soft2242.shop.common.exception.ServerException;
import com.soft2242.shop.common.result.PageResult;
import com.soft2242.shop.convert.UserAddressConvert;
import com.soft2242.shop.entity.Goods;
import com.soft2242.shop.entity.UserOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.soft2242.shop.entity.UserShippingAddress;
import com.soft2242.shop.query.CancelGoodsQuery;
import com.soft2242.shop.query.OrderPreQuery;
import com.soft2242.shop.query.OrderQuery;
import com.soft2242.shop.vo.*;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ycshang
 * @since 2023-11-10
 */
public interface UserOrderService extends IService<UserOrder> {

  Integer addGoodsOrder(UserOrderVO orderVO);

  public OrderDetailVO getOrderDetail(Integer id);

  List<UserAddressVO> getAddressListByUserId(Integer userId, Integer addressId);

  SubmitOrderVO getPreOrderDetail(Integer userId);

  SubmitOrderVO getPreNowOrderDetail(OrderPreQuery query);

  SubmitOrderVO getRepurchaseOrderDetail(Integer id);

  PageResult<OrderDetailVO> getOrderList(OrderQuery query);

  OrderDetailVO cancelOrder(CancelGoodsQuery query);

  void deleteOrder(List<Integer> ids, Integer userId);

  void payOrder(Integer id);

  void consignOrder(Integer id);

  OrderDetailVO receiptOrder(Integer id);

  OrderLogisticVO getOrderLogistics(Integer id);
}



