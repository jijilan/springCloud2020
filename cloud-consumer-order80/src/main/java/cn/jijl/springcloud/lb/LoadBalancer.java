package cn.jijl.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author jijl
 * @Description: 自定义负载均衡规则
 * @Date 20:57 2020/7/4
 * @Param
 * @return
 **/

public interface LoadBalancer {
    /**
     * @Author jijl
     * @Description: 服务实例个数
     * @Date 20:58 2020/7/4
     **/
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
