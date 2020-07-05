package cn.jijl.springcloud.service.impl;

import cn.jijl.springcloud.dao.PaymentDao;
import cn.jijl.springcloud.entities.Payment;
import cn.jijl.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author jijl
 * @Date 12:51 2020/7/2
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
