package com.soft2242.shop.controller;

import com.soft2242.shop.common.exception.ServerException;
import com.soft2242.shop.common.result.Result;
import com.soft2242.shop.entity.UserShippingAddress;
import com.soft2242.shop.service.UserShippingAddressService;
import com.soft2242.shop.vo.AddressVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.soft2242.shop.common.utils.ObtainUserIdUtils.getUserId;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ycshang
 * @since 2023-11-10
 */
@Tag(name = "地址管理")
@RestController
@RequestMapping("member")
@AllArgsConstructor
public class UserShippingAddressController {
  private final UserShippingAddressService userShippingAddressService;

  @Operation(summary = "添加收货地址")
  @PostMapping("address")
  public Result<Integer> saveAddress(@RequestBody @Validated AddressVO addressVO, HttpServletRequest request) {
    Integer userId = getUserId(request);
    addressVO.setUserId(userId);
    Integer addressId = userShippingAddressService.saveShippingAddress(addressVO);
    return Result.ok(addressId);
  }
  @Operation(summary = "修改收货地址")
  @PutMapping("address")
  public Result<Integer> editAddress(@RequestBody @Validated AddressVO addressVO, HttpServletRequest request) {
    if (addressVO.getId() == null) {
      throw new ServerException("请求参数不能为空");
    }
    addressVO.setUserId(getUserId(request));
    Integer addressId = userShippingAddressService.editShippingAddress(addressVO);
    return Result.ok(addressId);
  }
  /*   @GetMapping("address")
     @Operation(summary = "收货地址列表")
     public Result<List<AddressVO>> getAddress() {
         List<AddressVO> list = userShippingAddressService.getAllShippingAddresses();
         return Result.ok(list);
     }
     @DeleteMapping("address")
     @Operation(summary = "删除收货地址")
     public Result<String> deleteAddress(@RequestParam Integer addressId){
         String s = userShippingAddressService.deleteShippingAddress(addressId);
         return Result.ok(s);

     }
     @GetMapping("address/detail")
     @Operation(summary = "收货地址详情")
     public Result<AddressVO> detailAddress(@RequestParam Integer addressId){
         AddressVO addressVO = userShippingAddressService.detailShippingAddress(addressId);
         return Result.ok(addressVO);
     }*/
  @Operation(summary = "收货地址列表")
  @GetMapping("address")
  public Result<List<AddressVO>> getList(HttpServletRequest request) {
    Integer userId = getUserId(request);
    List<AddressVO> list = userShippingAddressService.getList(userId);
    return Result.ok(list);

  }
  @Operation(summary = "收货地址详情")
  @GetMapping("address/detail")
  public Result<AddressVO> getAddressDetail(@RequestParam Integer id, HttpServletRequest request) {
    if (id == null) {
      throw new ServerException("请求参数不能为空");
    }
    AddressVO addressInfo = userShippingAddressService.getAddressInfo(id);
    return Result.ok(addressInfo);
  }
  @Operation(summary = "删除收货地址")
  @DeleteMapping("address")
  public Result removeAddress(@RequestParam Integer id, HttpServletRequest request) {
    if (id == null) {
      throw new ServerException("请求参数不能为空");
    }
    userShippingAddressService.removeShippingAddress(id);
    return Result.ok();
  }
}
