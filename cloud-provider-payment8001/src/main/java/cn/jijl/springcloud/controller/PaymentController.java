package cn.jijl.springcloud.controller;

import cn.jijl.springcloud.entities.CommonResult;
import cn.jijl.springcloud.entities.Payment;

import cn.jijl.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author jijl
 * @Date 12:51 2020/7/2
 **/
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * @return cn.jijl.springcloud.entities.CommonResult
     * @Author jijl
     * @Description: 创建
     * @Date 15:17 2020/7/2
     * @Param [payment]
     **/
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("****插入结果:" + result);

        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    /**
     * @return cn.jijl.springcloud.entities.CommonResult<cn.jijl.springcloud.entities.Payment>
     * @Author jijl
     * @Description: 查询
     * @Date 15:17 2020/7/2
     * @Param [id]
     **/
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("**** 查询结果:" + payment + "1");

        if (payment != null) {
            return new CommonResult(200, "查询成功,serverPort: " + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录，查询ID: " + id, null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();

        //服务
        for (String service : services) {
            log.info("*****element:" + service);
            //实例
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                log.info(instance.getServiceId() + "\t" + instance.getHost() +
                        "\t" + instance.getPort() + "\t" + instance.getUri());
            }

        }


        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return serverPort;
        }
    }

    @GetMapping(value = "/payment/zipkin")
    public String paymentZipkin() {
        return "hello,i am paymentZipkin server fallback,O(∩_∩)O哈哈~";
    }
}
