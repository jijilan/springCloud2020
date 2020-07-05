package cn.jijl.springCloud.service;

import org.springframework.stereotype.Component;


/**
 * @Author jijl
 * @Description: 服务降级实现类
 * @Date 20:46 2020/7/5
 * @Param
 * @return
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "----PaymentFallbackService fall back paymentInfo_OK,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "----PaymentFallbackService fall back paymentInfo_Timeout,o(╥﹏╥)o";
    }
}
