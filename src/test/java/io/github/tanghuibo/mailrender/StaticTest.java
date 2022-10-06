package io.github.tanghuibo.mailrender;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.io.IoUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.BeforeFilter;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.ValueFilter;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class StaticTest {

    @Test
    public void test1() throws IOException {
        String data = resourceAsString("/data/test1.json");
        JSONObject jsonObj = JSON.parseObject(data);
    }

    public static String resourceAsString(String path) throws IOException {
        try (InputStream inputStream = StaticTest.class.getResourceAsStream(path)) {
            return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        }
    }
}
