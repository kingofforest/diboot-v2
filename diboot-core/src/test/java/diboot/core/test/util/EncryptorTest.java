/*
 * Copyright (c) 2015-2020, www.dibo.ltd (service@dibo.ltd).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package diboot.core.test.util;

import com.diboot.core.util.Encryptor;
import diboot.core.test.StartupApplication;
import diboot.core.test.config.SpringMvcConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <Description>
 *
 * @author mazc@dibo.ltd
 * @version 1.0
 * @date 2019/06/02
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SpringMvcConfig.class})
@SpringBootTest(classes = {StartupApplication.class})
public class EncryptorTest {

    @Test
    public void testEncrypt(){
        String text = "Hello World";
        String encryptText = Encryptor.encrypt(text);
        System.out.println(encryptText);
        // 加密后长度
        Assert.assertTrue(encryptText.length() >= 24);
        // 解密
        Assert.assertTrue(Encryptor.decrypt(encryptText).equals(text));

        String seed = "ABCDEF";
        encryptText = Encryptor.encrypt(text, seed);
        System.out.println(encryptText);
        // 加密后长度
        Assert.assertTrue(encryptText.length() >= 24);
        // 解密
        Assert.assertTrue(Encryptor.decrypt(encryptText, seed).equals(text));
    }

}
