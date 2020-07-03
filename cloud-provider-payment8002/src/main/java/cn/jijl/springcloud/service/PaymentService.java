package cn.jijl.springcloud.service;

import cn.jijl.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author jijl
 * @Date 12:51 2020/7/2
 **/
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
