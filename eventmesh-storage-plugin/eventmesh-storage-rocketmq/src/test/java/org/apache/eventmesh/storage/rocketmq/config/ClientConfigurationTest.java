/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.eventmesh.storage.rocketmq.config;

import org.apache.eventmesh.api.factory.StoragePluginFactory;
import org.apache.eventmesh.storage.rocketmq.consumer.RocketMQConsumerImpl;
import org.apache.eventmesh.storage.rocketmq.producer.RocketMQProducerImpl;

import org.junit.Assert;
import org.junit.Test;

public class ClientConfigurationTest {

    @Test
    public void getConfigWhenRocketMQConsumerInit() {
        RocketMQConsumerImpl consumer = (RocketMQConsumerImpl) StoragePluginFactory.getMeshMQPushConsumer("rocketmq");

        ClientConfiguration config = consumer.getClientConfiguration();
        assertConfig(config);
    }

    @Test
    public void getConfigWhenRocketMQProducerInit() {
        RocketMQProducerImpl producer = (RocketMQProducerImpl) StoragePluginFactory.getMeshMQProducer("rocketmq");

        ClientConfiguration config = producer.getClientConfiguration();
        assertConfig(config);
    }

    private void assertConfig(ClientConfiguration config) {
        Assert.assertEquals("127.0.0.1:9876;127.0.0.1:9876", config.getNamesrvAddr());
        Assert.assertEquals("username-succeed!!!", config.getClientUserName());
        Assert.assertEquals("password-succeed!!!", config.getClientPass());
        Assert.assertEquals(Integer.valueOf(1816), config.getConsumeThreadMin());
        Assert.assertEquals(Integer.valueOf(2816), config.getConsumeThreadMax());
        Assert.assertEquals(Integer.valueOf(3816), config.getConsumeQueueSize());
        Assert.assertEquals(Integer.valueOf(4816), config.getPullBatchSize());
        Assert.assertEquals(Integer.valueOf(5816), config.getAckWindow());
        Assert.assertEquals(Integer.valueOf(6816), config.getPubWindow());
        Assert.assertEquals(7816, config.getConsumeTimeout());
        Assert.assertEquals(Integer.valueOf(8816), config.getPollNameServerInterval());
        Assert.assertEquals(Integer.valueOf(9816), config.getHeartbeatBrokerInterval());
        Assert.assertEquals(Integer.valueOf(11816), config.getRebalanceInterval());
        Assert.assertEquals("cluster-succeed!!!", config.getClusterName());
        Assert.assertEquals("accessKey-succeed!!!", config.getAccessKey());
        Assert.assertEquals("secretKey-succeed!!!", config.getSecretKey());
    }
}
